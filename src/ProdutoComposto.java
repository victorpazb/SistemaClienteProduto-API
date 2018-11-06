
public class ProdutoComposto extends Produto {
	
	
	private String fornecedor;
	private String nome;
	private String descricao;
	private double fator;
	private double preco;
	
	
	
	
	public ProdutoComposto(String nomeFornecedor, String nome, String descricao, double fator, String produtos) {
		super(nomeFornecedor, nome, descricao, fator);
		this.fornecedor = nomeFornecedor;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = definePreco(fator);
	}
	
	public void setFator(double novoFator) {
		this.fator = novoFator;
	}

	@Override
	public double definePreco(double fator) {
		double preco = 10 * (1 - fator);
		return preco;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
