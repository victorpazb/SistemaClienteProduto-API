/**
 * classe que define um produto. 
 * @author victorpfb
 *
 */
public abstract class Produto implements Comparable<Produto> {

	protected String fornecedor;
	protected String nome;
	protected String descricao;
	protected double preco;

	public Produto(String nomeFornecedor, String nome, String descricao, double preco) {

		this.fornecedor = nomeFornecedor;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;

	}

	/**
	 * @return getter que retorna um double preco do produto
	 */
	public double getPreco() {
		return this.preco;
	}

	/**
	 * setter que atualiza o preco do produto
	 * 
	 * @param novoPreco
	 *            double passado para atualizar o preco do produto
	 */
	public void setPreco(double novoPreco) {
		this.preco = novoPreco;
	}

	/**
	 * @return getter que retorna uma String que eh o nome do produto
	 */

	public String getNome() {
		return this.nome;
	}

	/**
	 * 
	 * @return getter que retorna uma string q representa a descricao do produto
	 */
	public String getDescricao() {
		return this.descricao;
	}

	public abstract double definePreco();

	/**
	 * 
	 * metodo criado para gerar a representacao textual do produto juntamente com o
	 * nome de seu fornecedor para ser apresentado no metodo que exibe todos os
	 * produtos de todos os fornecedores e que pede que venha antes de cada produto
	 * o nome de seu fornecedor
	 */
	public String toStringParaImpressaoEmListaGeral() {
		String preco = String.format(" - R$%.2f", definePreco());
		String precoFormatado = preco.replace(".", ",");
		return this.fornecedor + " - " + this.nome + " - " + this.descricao + precoFormatado;
	}

	/**
	 * metodo toString de produto, retorna a representacao textual do produto da
	 * seguinte forma: "nomeProduto - descricaoProduto - preco"
	 */
	@Override
	public String toString() {
		String preco = String.format(" - R$%.2f", definePreco());
		String precoFormatado = preco.replace(".", ",");
		return this.nome + " - " + this.descricao + precoFormatado;
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
	 * metodo equals que diz q um produto eh igual ao outro se tiverem nome e
	 * descricao iguais.
	 */
	@Override
	public boolean equals(Object obj) {

		Produto produtoTeste = (Produto) obj;
		if (produtoTeste instanceof Produto) {
			return this.nome.equals(produtoTeste.nome) && this.descricao.equals(produtoTeste.getDescricao());
		}
		return false;
	}
}
