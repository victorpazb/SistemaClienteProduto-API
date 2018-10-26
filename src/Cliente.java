
public class Cliente {
	
	private String cpf;
	private String nome;
	private String local;
	private String email;
	
	
	public Cliente(String cpf, String nome, String local, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.local = local;
		this.email = email;
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public void setLocal(String novoLocal) {
		this.local = novoLocal;
	}
	
	public void setEmail(String novoEmail) {
		this.email = novoEmail;
	}
	
	public String toString() {
		return this.nome + " - " + this.local + " - " + this.email;
	}
	
	

}
