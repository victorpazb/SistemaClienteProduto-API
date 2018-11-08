
public class ProdutoComposto extends Produto {

	private double fator;

	public ProdutoComposto(String nomeFornecedor, String nome, String descricao, double fator, double preco, String produtos) {
		super(nomeFornecedor, nome, descricao, preco);
		this.fator = fator;
	}

	
	
	public void setFator(double novoFator) {
		this.fator = novoFator;
	}
	
	

	@Override
	public double definePreco() {
		double preco = this.preco * (1 - this.fator);
		return preco; 
	}


}
