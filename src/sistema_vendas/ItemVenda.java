
public class ItemVenda {

	protected Produto produto;
	protected int quantidade;
	protected double valor;

	public ItemVenda(){

	}
	
	public ItemVenda(Produto produto, int quantidade) {
		this.produto = produto;
		this.valor = produto.getValor()*quantidade;
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		return "Item: " + this.produto + " Qtd: " + this.quantidade + " Vlr: " + this.valor; 
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
