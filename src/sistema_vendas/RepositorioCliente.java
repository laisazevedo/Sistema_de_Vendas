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
class RepositorioCliente {
        private ArrayList<Cliente> lista;
        private static RepositorioCliente instanciaRep;
        private RepositorioCliente(){
            this.lista = new ArrayList<Cliente>();
        }
        public static RepositorioCliente obterInstancia(){
            if(instanciaRep== null){
                instanciaRep=new RepositorioCliente();
            }
            return instanciaRep;
        }
        public ArrayList<Cliente> listarTodos(){
             return this.lista;
        }
        
        
        public void inserir(Cliente cliente) throws Exception{
          if (cliente==null){
            throw new Exception("O cliente não foi instanciado");
           
          }
          if (cliente.getCPF() == null){
            throw new Exception("Informar o CPF do Cliente");
          }
          if (cliente.getCPF().trim().equals("")){
            throw new Exception("Informar o CPF do Cliente");
          }
          if (cliente.getNome() == null){
            throw new Exception("Informar o Nome do Cliente");
          }   
          if (cliente.getNome().trim().equals("")){
            throw new Exception("Informar o Nome do Cliente");
          } 
          if(this.verificaExistencia(cliente)>=0){
              throw new Exception("O referido cliente já se encontra cadastrado");
          }
             this.lista.add(cliente);
        }
        
        
        
        public void remover(Cliente cliente) throws Exception{
            
            if (cliente==null){
              throw new Exception("O cliente não foi instanciado");
            }
            if (cliente.getCPF() == null){
              throw new Exception("Informar o CPF do Cliente");
            }
            if (cliente.getCPF().trim().equals("")){
              throw new Exception("Informar o CPF do Cliente");
            }
            if(this.verificaExistencia(cliente)>=0){
               throw new Exception("O referido cliente já se encontra cadastrado");
            }
            this.lista.remove(this.verificaExistencia(cliente));
     
        }
        
        
        
        public void atualizar(Cliente cliente) throws Exception{
          if (cliente==null){
            throw new Exception("O cliente não foi instanciado");
           
          }
          if (cliente.getCPF() == null){
            throw new Exception("Informar o CPF do Cliente");
          }
          if (cliente.getCPF().trim().equals("")){
            throw new Exception("Informar o CPF do Cliente");
          }
          if (cliente.getNome() == null){
            throw new Exception("Informar o Nome do Cliente");
          }   
          if (cliente.getNome().trim().equals("")){
            throw new Exception("Informar o Nome do Cliente");
          } 
          if(this.verificaExistencia(cliente)== -1){
               throw new Exception("O referido cliente já se encontra cadastrado");
          }
           this.lista.set(this.verificaExistencia(cliente), cliente);
        }
        
        public int verificaExistencia(Cliente cliente){
            int retorno = -1;
            for (int i =0; i<this.lista.size();i++){
                if (cliente.getCPF().trim().equals(this.lista.getCPF(i).getCPF().trim()));
                retorno = i;
                break;
            }
            return retorno;
        }
        
}
        