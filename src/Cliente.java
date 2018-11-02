
public class Cliente implements Comparable<Cliente> {

	private String nome;
	private String localizacao;
	private String email;

	public Cliente(String nome, String email, String localizacao) {
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
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}

	@Override
	public int compareTo(Cliente outroCliente) {
		return this.nome.compareTo(outroCliente.getNome());
	}

}
