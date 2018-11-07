
public class Compra implements Comparable<Compra> {

	private String data;
	private String identifcacaoProduto;
	private double preco;

	public Compra(String data, String identifcacaoProduto, double preco) {

		this.data = data;
		this.identifcacaoProduto = identifcacaoProduto;
		this.preco = preco;

	}


	public String getIdentificacaoDoProduto() {
		return this.identifcacaoProduto;
	}

	public double getPreco() {
		return this.preco;
	}

	@Override
	public int compareTo(Compra outraCompra) {
		return this.identifcacaoProduto.compareTo((outraCompra.getIdentificacaoDoProduto()));
	}

	@Override
	public String toString() {
		return this.identifcacaoProduto + " - " + this.data.replace("/", "-");
	}

}
