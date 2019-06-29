
import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Vendedor {
	protected int codigo;
	protected String nome;
	protected String dataAdm;

	public Vendedor(int codigo, String nome, String dataAdm) {
		this.codigo = codigo;
		this.nome = nome;
		this.dataAdm = dataAdm;
	}
	Vendedor(){
		
	}
	
	@Override
	public String toString() {
		return this.nome;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataAdm() {
		return dataAdm;
	}
	public void setDataAdm(String dataAdm) {
		this.dataAdm = dataAdm;
	}
	
	ArrayList <Vendedor> vendedor = new ArrayList <Vendedor>();

	public void cadastrarVendedor(){
		
		vendedor.add(new Vendedor(1, "Alisson", "01/03/2005"));
		vendedor.add(new Vendedor(2, "Laila", "28/07/2010"));
		vendedor.add(new Vendedor(3, "Fernando", "04/06/2000"));
		vendedor.add(new Vendedor(4, "Alicia", "15/10/2015"));
		vendedor.add(new Vendedor(5, "Rodrigo", "30/08/2009"));

	}
	Vendedor buscarVendedor(int codigo){
		for(int i=0;i< vendedor.size();i++){
			if(vendedor.get(i).getCodigo() == codigo)
				return vendedor.get(i);
		}	
		return null;
	}
	

	void listarVendedores(){
		System.out.println("\n\t\t--- Vendedores ---");
		for(int i=0; i<vendedor.size(); i++){
			System.out.print("\n\t\tNome: " + vendedor.get(i).getNome() + "\n\t\tData de admissao: "+vendedor.get(i).getDataAdm()+"\n\t\t----------------\n");
		}
		Principal.menu();
	}

}
