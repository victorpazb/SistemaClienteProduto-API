/**
 * Classe cliente, representa um cliente a ser cadastrado no sistema e tem como
 * atributos: String nome, String localizacao, String email.
 */
public class Cliente implements Comparable<Cliente> {

	private String nome;
	private String localizacao;
	private String email;

	/**
	 * Construtor da classe, recebe os parametros nome, emailç e localizacao.
	 * 
	 * @param nome
	 *            String que reprensenta o nome do cliente
	 * @param email
	 *            string que representa o endereco de email do cliente
	 * @param localizacao
	 *            string que representa a localizacao do cliente (onde trabalha/
	 *            estuda)
	 */
	public Cliente(String nome, String email, String localizacao) {
		this.nome = nome.trim();
		this.localizacao = localizacao.trim();
		this.email = email.trim();
	}

	/**
	 * getter que retorna o nome do cliente
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * setter que pode modificar o nome do cliente. recebe uma string novoNome e a
	 * atribiu ao nome do cliente
	 */
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}

	/**
	 * setter que modifica a localizacao do cliente, recebe uma String novoLocal e a
	 * atribui a localizacao
	 * 
	 * @param novoLocal
	 */
	public void setLocal(String novoLocal) {
		this.localizacao = novoLocal;
	}

	/**
	 * 
	 * setter que modifica o email do cliente, recebe uma String novoEmail e a
	 * atribui a email
	 */
	public void setEmail(String novoEmail) {
		this.email = novoEmail;
	}

	/**
	 * metodo toString de cliente, retorna: "NomeDoCliente - Localizacao - email"
	 */
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}

	/**
	 * compareTo da classe cliente, usado para comprar os nomes dos clientes uns com
	 * os outros para serem exibidos em ordem alfabetica
	 */
	@Override
	public int compareTo(Cliente outroCliente) {
		return this.nome.compareTo(outroCliente.getNome());
	}

}
