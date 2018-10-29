
public class Cliente implements Comparable<Cliente> {

	private String cpf;
	private String nome;
	private String local;
	private String email;

	public Cliente(String cpf, String nome, String local, String email) {
		this.cpf = cpf.trim();
		this.nome = nome.trim();
		this.local = local.trim();
		this.email = email.trim();
	}

	public String getNome() {
		return this.nome;
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

	@Override
	public int compareTo(Cliente outroCliente) {
		return this.nome.compareTo(outroCliente.getNome());
	}

}
