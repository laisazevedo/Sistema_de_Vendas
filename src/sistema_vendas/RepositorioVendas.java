/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema_Vendas;

import java.util.ArrayList;

/**
 *
 * @author +
 */
public class RepositorioVendas {
       private ArrayList<Venda> lista;
        private static RepositorioVendas instanciaRep;
        private RepositorioVendas(){
            this.lista = new ArrayList<Venda>();
        }
        public static RepositorioVendas obterInstancia(){
            if(instanciaRep== null){
                instanciaRep=new RepositorioVendas();
            }
            return instanciaRep;
        }
        public ArrayList<Venda> listarTodos(){
             return this.lista;
        }
        
        
        public void inserir(Venda venda) throws Exception{
          if (venda==null){
            throw new Exception("A venda não foi instanciado");
           
          }
          if (venda.getNumero() <=0){
            throw new Exception("Informar o numero da venda");
          }
           if (venda.getData()== null){
            throw new Exception("Informar data da venda");
          }
          if (venda.getData().trim().equals("")){
            throw new Exception("Informar a data da venda");
          }
          ////////////////////////////////////parou aqui pag 36
          if (venda.getItemVenda().size()<=0 == null){
            throw new Exception("Informar a descricao do produto");
          }   
          if (venda.getDescricao().trim().equals("")){
            throw new Exception("Informar a descricao do produto");
          } 
           if (venda.getPreco() <=0){
            throw new Exception("O preco do produto devera ser superior a zero");
          }   
          if(this.verificaExistencia(venda)>=0){
              throw new Exception("O referido produto já se encontra cadastrado");
          }
             this.lista.add(venda);
        }
        
        
        
        public void remover(Venda venda) throws Exception{
            
            if (venda==null){
              throw new Exception("O Produto não foi instanciado");
            }
            if (venda.getCodigo() == null){
              throw new Exception("Informar o Codigo do Produto");
            }
            if (venda.getCodigo().trim().equals("")){
              throw new Exception("Informar o Codigo do produto");
            }
            if(this.verificaExistencia(venda)==-1){
               throw new Exception("O referido produto não se encontra cadastrado");
            }
            this.lista.remove(this.verificaExistencia(venda));
     
        }
        
        
        
        public void atualizar(Venda venda) throws Exception{
          if (venda==null){
            throw new Exception("O produto não foi instanciado");
           
          }
          if (venda.getCodigo() == null){
            throw new Exception("Informar o codigo do produto");
          }
          if (venda.getCodigo().trim().equals("")){
            throw new Exception("Informar o codigo do produto");
          }
          if (venda.getDescricao() == null){
            throw new Exception("Informar a descricao do produto");
          }   
          if (venda.getDescricao().trim().equals("")){
            throw new Exception("Informar a descricao do produto ");
          } 
          if (venda.getPreco() <=0){
            throw new Exception("O preco do produto devera ser superior a zero");
          }
          if(this.verificaExistencia(venda) <0){
               throw new Exception("O referido produto nao se encontra cadastrado");
          }
        
           this.lista.set(this.verificaExistencia(venda),venda);
        }
        
        public int verificaExistencia(Venda venda){
            int retorno = -1;
            for (int i =0; i<this.lista.size();i++){
                if (venda.getCodigo().trim().equals(this.lista.getCodigo(i).getCodigo().trim()));
                retorno = i;
                break;
            }
            return retorno;
        }
        
}
