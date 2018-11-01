
public class Produto implements Comparable<Produto>{

	private String nome;
	private String descricao;
	private double preco;
	private String idProduto;

	public Produto(String nome, String descricao, double preco) {
		if(nome.trim().equals("") || descricao.trim().equals("") || preco < 0.0) {
			throw new IllegalArgumentException("parametro passado para construcao de produto vazio ou preco eh negativo");
		}
		
		this.nome = nome.trim();
		this.descricao = descricao.trim();
		this.preco = preco;
		this.idProduto = nome + " - " + descricao;
	}

	public String getNome() {
		return this.nome;
	}
	
	public String getIdProduto() {
		return this.idProduto;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

	public void setPreco(double novoPreco) {
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
