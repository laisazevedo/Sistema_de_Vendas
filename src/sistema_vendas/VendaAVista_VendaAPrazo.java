import java.util.*;
import java.lang.*;
import java.io.*;

class VendaAVista extends Venda{

	public VendaAVista() {
		super();	
	}

	public VendaAVista(int id, String data, Cliente cliente, Vendedor vendedor, ArrayList<ItemVenda> itens) {
		super(id, data, cliente, vendedor, itens);
	}

	public double getValor(){
		return this.getValorTotalOriginal()*0.9; //retorna desconto 10%
	}
	/*double getTotalVendav(){
		double total = 0;
		for(int i=0; i<itens.size(); i++){
			double valor = (itens.get(i).getQuantidade()*itens.get(i).getValor())*0.9;
			total = total+valor;
		}
		return total;
	}*/

}

class VendaAPrazo extends Venda{	
	private int qtdDeParcelas;

	public VendaAPrazo() {
		super();

	}

	public VendaAPrazo(int id, String data, Cliente cliente, Vendedor vendedor, ArrayList<ItemVenda> item) {
		super(id, data, cliente, vendedor, item);

	}

	public double getValor(){
		if (this.qtdDeParcelas == 1)
			return this.getValorTotalOriginal();
		else
			return this.getValorTotalOriginal()*1.1;//acrescimo de 10%
	}

	double getTotalVenda(){
		double total = 0;
		for(int i=0; i<itens.size(); i++){
			double valor = (itens.get(i).getQuantidade()*itens.get(i).getValor());
			total = total+valor;
		}
		return total;
	}

}
