import java.util.ArrayList;
import java.util.Scanner;

public class Produtos extends Produto {

	public Produtos() {
		super();

	}

	public Produtos(int codigo, String descricao, double valor, int quatEstoque) {
		super(codigo, descricao, valor, quatEstoque);
	}
	

	Scanner entrada = new Scanner(System.in);
	ArrayList <Produto> listaDeProdutos = new ArrayList <Produto>();

	public void cadastrarProduto(){
		listaDeProdutos.add(new Produto(1, "celular", 550.0, 20));
		listaDeProdutos.add(new Produto(2, "televisao", 1300.0, 15));
		listaDeProdutos.add(new Produto(3, "notebook", 1700.0, 8));
		listaDeProdutos.add(new Produto(4, "geladeira", 1100.0, 10));
		listaDeProdutos.add(new Produto(5, "ventilador", 120.0, 30));
		
	}
	public String toString() {
		return "Produtos [produtos=" + listaDeProdutos + "]";
	}
	Produto buscarProduto(int codigo){
		for(int i=0;i< listaDeProdutos.size();i++){
			if(listaDeProdutos.get(i).getCodigo() == codigo)
				return listaDeProdutos.get(i);
		}	
		return null;
	}

	void listarProdutos(){
		System.out.println("\n\t\t--- Produtos no Estoque ---");
		for(int i=0; i<listaDeProdutos.size(); i++){
			System.out.print("\t\tCodigo: " + listaDeProdutos.get(i).getCodigo() + "\n\t\tDescricao: " + listaDeProdutos.get(i).getDescricao() + "\n\t\tPreco unitario: "+listaDeProdutos.get(i).getValor()+"\n\t\tQuantidade: "+listaDeProdutos.get(i).getQuatEstoque()+"\n\t\t----------------\n");
		}
		Principal.menu();
	}
	

}
