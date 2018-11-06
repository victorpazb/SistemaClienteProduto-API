
public class ProdutoSimples extends Produto {

	public double preco;
	public String fornecedor;
	public String descricao;
	public String nome;
	public String idProduto;

	public ProdutoSimples(String nomeFornecedor, String nome, String descricao, double preco) {
		super(nomeFornecedor, nome, descricao, preco);
		this.nome = nome;
		this.fornecedor = nomeFornecedor;
		this.descricao = descricao;
		this.preco = definePreco(preco);
		this.idProduto = nome + " - " + descricao;
		
	}
	
	public String getId() {
		return this.idProduto;
	}

	@Override
	public double definePreco(double preco) {
		
		return this.preco = preco;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	
	
	
	

}
