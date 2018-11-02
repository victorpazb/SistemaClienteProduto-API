/**
 * classe que define Produto, tem os atributos String nome, String descricao,
 * double preco.
 * 
 * @author victorpfb
 *
 */
public class Produto implements Comparable<Produto> {

	private String nome;
	private String descricao;
	private double preco;
	private String idProduto;

	/**
	 * construtor da classe, recebe o nome, descricao e preco
	 * 
	 * @param nome
	 *            String que define o nome
	 * @param descricao
	 *            String que descreve o produto
	 * @param preco
	 *            double que eh o preco do produto
	 */
	public Produto(String nome, String descricao, double preco) {
		if (nome.trim().equals("") || descricao.trim().equals("") || preco < 0.0) {
			throw new IllegalArgumentException(
					"parametro passado para construcao de produto vazio ou preco eh negativo");
		}

		this.nome = nome.trim();
		this.descricao = descricao.trim();
		this.preco = preco;
		this.idProduto = nome + " - " + descricao;
	}

	/**
	 * getter que retorna o nome do produto
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * getter que retorna o idProduto
	 * 
	 */
	public String getIdProduto() {
		return this.idProduto;
	}

	/**
	 * @return getter que retorna a descricao
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * setter que atualizar o preco do produto, recebe um double novoPreco e
	 * atualiza preco
	 * 
	 * @param novoPreco
	 */
	public void setPreco(double novoPreco) {
		this.preco = novoPreco;
	}

	/**
	 * metodo equals que diz q um produto eh igual ao outro se tiverem nome e
	 * descricao iguais.
	 */
	@Override
	public boolean equals(Object obj) {

		Produto produtoTeste = (Produto) obj;
		return this.nome.equals(produtoTeste.nome) && this.descricao.equals(produtoTeste.getDescricao());
	}

	/**
	 * metodo compareTo serve para ordenar os produtos em ordem alfabetica para que
	 * so entao possam ser exibidor em uma lista
	 */
	@Override
	public int compareTo(Produto outroProduto) {
		return this.nome.compareTo(outroProduto.getNome());
	}

	/**
	 * metodo toString de produto, retorna a representacao textual do produto da
	 * seguinte forma: "nomeProduto - descricaoProduto - preco"
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.descricao + " - " + this.preco;
	}

}
