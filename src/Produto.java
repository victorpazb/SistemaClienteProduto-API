
public class Produto implements Comparable<Produto>{

	private String nome;
	private String descricao;
	private String preco;

	public Produto(String nome, String descricao, String preco) {
		this.nome = nome.trim();
		this.descricao = descricao.trim();
		this.preco = preco.trim();
	}

	public String getNome() {
		return this.nome;
	}

	public void setPreco(String novoPreco) {
		this.preco = novoPreco;
	}

	@Override
	public boolean equals(Object obj) {

		Produto produtoTeste = (Produto) obj;
		return this.nome.equals(produtoTeste.nome);
	}

	@Override
	public int compareTo(Produto outroProduto) {
		return this.nome.compareTo(outroProduto.getNome());
	}
	
	@Override
	public String toString() {
		return this.nome + " - " + this.descricao + " - " + this.preco;
	}

}
