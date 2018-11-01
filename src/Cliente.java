
public class Cliente implements Comparable<Cliente> {

	private String cpf;
	private String nome;
	private String localizacao;
	private String email;

	public Cliente(String cpf, String nome, String email, String localizacao) {
		this.cpf = cpf.trim();
		this.nome = nome.trim();
		this.localizacao = localizacao.trim();
		this.email = email.trim();
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String novoNome) {
		this.nome = novoNome;
	}

	public void setLocal(String novoLocal) {
		this.localizacao = novoLocal;
	}

	public void setEmail(String novoEmail) {
		this.email = novoEmail;
	}

	public String toString() {
		return this.nome + " - " + this.email + " - " +this.localizacao;
	}

	@Override
	public int compareTo(Cliente outroCliente) {
		return this.nome.compareTo(outroCliente.getNome());
	}

}
