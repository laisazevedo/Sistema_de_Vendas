
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class  Venda {
	protected int id;
	protected String data;
	protected Cliente cliente;
	protected Vendedor vendedor;
	ArrayList<ItemVenda> itens = new ArrayList<ItemVenda>();

	public Venda(int id, String data, Cliente cliente, Vendedor vendedor, ArrayList<ItemVenda> itens) {
		this.id = id;
		this.data = data;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.itens = itens;	
	}
	
	Venda(){

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public String imprimirItens(){
		String str = "";
		for (ItemVenda itemVenda : itens) {
			str += "\t\t\t\t"+itemVenda + "\n ";
		}
		
		return str;
	}
	
	public ArrayList<ItemVenda> getItens() {
		return itens;
	}

	public void setItem(ArrayList<ItemVenda> itens) {
		this.itens = itens;
	}
	
	public abstract double getValor();

	public double getValorTotalOriginal(){
		double total = 0.0;
		for(int i=0; i<itens.size(); i++){
			double valor = itens.get(i).getValor();
			total = total+valor;
		}
		return total;
	}

}
