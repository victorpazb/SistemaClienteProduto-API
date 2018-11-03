import java.util.HashMap;

/**
 * classe que define um Fornecedor, e que tem os atributos HashMap
 * listaDeProdutos, String nome, String email, String telefone
 *
 */
public class Fornecedor implements Comparable<Fornecedor> {

	private HashMap<String, Produto> listaDeProdutos;
	private String nome;
	private String email;
	private String telefone;

	/**
	 * construtor da classe Fornecedor
	 * 
	 * @param nome
	 *            String que define o nome do fornecedor
	 * @param email
	 *            String que define o email do fornecedor
	 * @param telefone
	 *            String que define o telefone do fornecedor
	 */
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome.trim();
		this.email = email.trim();
		this.telefone = telefone.trim();
		this.listaDeProdutos = new HashMap<>();
		
	}

	/**
	 * @return * getter que retorna a String nome do fornecedor
	 */

	public String getNome() {
		return this.nome;
	}

	/**
	 * @return * setter que altera a o atributo email do fornecedor recebendo uma
	 *         nova string email para isso.
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * setter que altera o atributo telefone do fornecedor
	 */

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return getter que retorna o HasgMap que guarda os produtos do fornecedor
	 */

	public HashMap<String, Produto> getListaDeProdutos() {
		return this.listaDeProdutos;
	}

	/**
	 * metodo que adiciona um produto a colecao de produtos do fornecedor atual
	 * 
	 * @param nome
	 *            string que representa o nome do produto
	 * @param descricao
	 *            string que representa a descricao do produto
	 * @param preco
	 *            double que representa o preco do produto
	 */
	public void addProduto(String nomeFornecedor, String nome, String descricao, double preco) {

		Produto novoProduto = new Produto(nomeFornecedor, nome, descricao, preco);
		if (this.getListaDeProdutos().containsValue(novoProduto)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}if(descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}if(preco < 0.0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de produto: preco invalido.");
		}

		this.listaDeProdutos.put(novoProduto.getIdProduto(), novoProduto);
	}
	
	public void addCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		
	}

	/**
	 * metodo toString que retorna a representacao textual de um fornecedor, sendo
	 * da forma: "nomeFornecedor - email - telefone"
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	/**
	 * metodo compareTo de fornecedor, que serve para ordenar os fornecedores na
	 * ordem alfabetica para que possam ser exibidor
	 */
	@Override
	public int compareTo(Fornecedor outroFornecedor) {
		return this.nome.compareTo(outroFornecedor.getNome());
	}

}
