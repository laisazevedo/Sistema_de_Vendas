import java.util.ArrayList;

public class Cliente {

	protected int cpf;
	protected String nome;
	
	public Cliente(int cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}
	Cliente(){
		
	}
	
	@Override
	public String toString() {
		return this.cpf+" >> "+this.nome;
	}
	
	public int getCpf() {
		return cpf;
	}
	public void setId(int cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
