
public class Produto {
	protected int codigo;
	protected String descricao;
	protected double valor;
	protected int quatEstoque;
	
	public Produto(int codigo, String descricao, double valor, int quatEstoque) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.quatEstoque = quatEstoque;
	}

	public Produto(){
		
	}
	
	@Override
	public String toString() {
		return this.descricao + " R$ " + this.valor;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQuatEstoque() {
		return quatEstoque;
	}

	public void setQuatEstoque(int quatEstoque) {
		this.quatEstoque = quatEstoque;
	}
	
	public void setDecrementaEstoque(int quantidade) {

		this.quatEstoque = this.quatEstoque - quantidade;
		
		//setQuatEstoque(quatEstoque);
	}
	
	
}
