import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clientes extends Cliente {

	
	public Clientes() {
		super();
		cadastrarCliente();
	}
	public Clientes(int cpf, String nome) {
		super(cpf, nome);
		
	}

	Scanner entrada = new Scanner(System.in);
	ArrayList <Cliente> listaDeClientes = new ArrayList <Cliente>();

	void cadastrarCliente(){
		listaDeClientes.add(new Cliente(1, "Cecilia"));
		listaDeClientes.add(new Cliente(2, "Eduardo"));
		listaDeClientes.add(new Cliente(3, "Helena"));
		listaDeClientes.add(new Cliente(4, "Daniel"));
		listaDeClientes.add(new Cliente(5, "Ricardo"));
	}
	
	Cliente buscarCliente(int cpf){
		for(int i=0;i< listaDeClientes.size();i++){
			if(listaDeClientes.get(i).getCpf()== cpf){
				return listaDeClientes.get(i);
			}
		}
		return null;	
		
	}

	void listarClientes(){
		System.out.println("\n\t\t--- Clientes ---");
		for(int i=0; i<listaDeClientes.size(); i++){
			System.out.print("\t\tCPF: " + listaDeClientes.get(i).getCpf() + "\n\t\tNome: " + listaDeClientes.get(i).getNome() + "\n\t\t----------------\n");
		}
		Principal.menu();
	}

}
