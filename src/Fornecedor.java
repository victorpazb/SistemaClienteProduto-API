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
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
		if (preco < 0.0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}

		this.listaDeProdutos.put(novoProduto.getIdProduto(), novoProduto);
	}

	public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {

		Produto novoCombo = new Produto(fornecedor, nome, descricao, fator, produtos);

		if (this.listaDeProdutos.containsKey(nome + " - " + descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
		}
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		}
		if (fator <= 0.0 || fator >= 1.0) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}
		if (produtos == null || produtos.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: combo deve ter produtos.");
		}

		if (produtos.contains("+")) {
			throw new IllegalArgumentException(
					"Erro no cadastro de combo: um combo não pode possuir combos na lista de produtos.");
		}

		String[] listaProdutos = produtos.split(",");
		for (String produto : listaProdutos) {
			if (!this.listaDeProdutos.containsKey(produto.trim())) {
				throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
			}
		}

		novoCombo.setPreco(definePrecoCombo(produtos, fator));
		this.listaDeProdutos.put(nome + " - " + descricao, novoCombo);

	}

	/**
	 * metodo que recebe uma stirng que identifica os produtos e eles sao separados
	 * por virgula, ao receber a string ela eh quebrada justamente na virgula e
	 * colada em um array de strings, eh procurado entao na colecao de produtos pelo
	 * produto citado, caso encontre o metodo verifica o preco do produto e o soma a
	 * variavel valor combo q depois sera ponderada com o fator do combo para entao
	 * termos o valor final do combo
	 * 
	 * @param produtos
	 *            String que representa a lista de produtos do combo
	 * @param fator
	 *            double que representa o desconto que havera no combo em relacao ao
	 *            preco se os produtos fossem adquiridos individualmente
	 * @return retorna o double valor final do combo
	 */
	private double definePrecoCombo(String produtos, double fator) {

		if (fator <= 0.0 || fator >= 1.0) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		}

		double valorDoCombo = 0.0;
		String[] produtosLista = produtos.split(",");
		for (int i = 0; i < produtosLista.length; i++) {

			if (!this.listaDeProdutos.containsKey(produtosLista[i].trim())) {
				throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
			}

			valorDoCombo += this.getListaDeProdutos().get(produtosLista[i].trim()).getPreco();         // o trim() eh necessario
																								       // para que o espaco
																								// apos a virgula na
																								         // string produtos nao
																								         // possa ser considerado

		}
		return valorDoCombo = valorDoCombo * (1.0 - fator);
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
