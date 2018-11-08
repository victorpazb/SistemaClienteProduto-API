
public class ProdutoSimples extends Produto {

	public String idProduto;

	public ProdutoSimples(String nomeFornecedor, String nome, String descricao, double preco) {
		super(nomeFornecedor, nome, descricao, preco);
		this.idProduto = nome + " - " + descricao;
		
	}
	
	public String getId() {
		return this.idProduto;
	}

	
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public double definePreco() {
		return this.preco;
	}
	
	
	
	
	

}
