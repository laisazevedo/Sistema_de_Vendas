/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema_Vendas;

import java.util.ArrayList;

/**
 *
 * @author alunos
 */
public class RepositorioProduto {
    private ArrayList<Produto> lista;
        private static RepositorioProduto instanciaRep;
        private RepositorioProduto(){
            this.lista = new ArrayList<Produto>();
        }
        public static RepositorioProduto obterInstancia(){
            if(instanciaRep== null){
                instanciaRep=new RepositorioProduto();
            }
            return instanciaRep;
        }
        public ArrayList<Produto> listarTodos(){
             return this.lista;
        }
        
        
        public void inserir(Produto produto) throws Exception{
          if (produto==null){
            throw new Exception("O Produto não foi instanciado");
           
          }
          if (produto.getCodigo() == null){
            throw new Exception("Informar o codigo do produto");
          }
          if (produto.getCodigo().trim().equals("")){
            throw new Exception("Informar o codigo do produto");
          }
          if (produto.getDescricao() == null){
            throw new Exception("Informar a descricao do produto");
          }   
          if (produto.getDescricao().trim().equals("")){
            throw new Exception("Informar a descricao do produto");
          } 
           if (produto.getPreco() <=0){
            throw new Exception("O preco do produto devera ser superior a zero");
          }   
          if(this.verificaExistencia(produto)>=0){
              throw new Exception("O referido produto já se encontra cadastrado");
          }
             this.lista.add(produto);
        }
        
        
        
        public void remover(Produto produto) throws Exception{
            
            if (produto==null){
              throw new Exception("O Produto não foi instanciado");
            }
            if (produto.getCodigo() == null){
              throw new Exception("Informar o Codigo do Produto");
            }
            if (produto.getCodigo().trim().equals("")){
              throw new Exception("Informar o Codigo do produto");
            }
            if(this.verificaExistencia(produto)==-1){
               throw new Exception("O referido produto não se encontra cadastrado");
            }
            this.lista.remove(this.verificaExistencia(produto));
     
        }
        
        
        
        public void atualizar(Produto produto) throws Exception{
          if (produto==null){
            throw new Exception("O produto não foi instanciado");
           
          }
          if (produto.getCodigo() == null){
            throw new Exception("Informar o codigo do produto");
          }
          if (produto.getCodigo().trim().equals("")){
            throw new Exception("Informar o codigo do produto");
          }
          if (produto.getDescricao() == null){
            throw new Exception("Informar a descricao do produto");
          }   
          if (produto.getDescricao().trim().equals("")){
            throw new Exception("Informar a descricao do produto ");
          } 
          if (produto.getPreco() <=0){
            throw new Exception("O preco do produto devera ser superior a zero");
          }
          if(this.verificaExistencia(produto) <0){
               throw new Exception("O referido produto nao se encontra cadastrado");
          }
        
           this.lista.set(this.verificaExistencia(produto),produto);
        }
        
        public int verificaExistencia(Produto produto){
            int retorno = -1;
            for (int i =0; i<this.lista.size();i++){
                if (produto.getCodigo().trim().equals(this.lista.getCodigo(i).getCodigo().trim()));
                retorno = i;
                break;
            }
            return retorno;
        }
        
}
