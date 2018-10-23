
public class Caixa {

	private int valorEmCaixa;
	private double taxa;

	public Caixa(int valor, double taxa) {
		this.valorEmCaixa = valor;
		this.taxa = taxa;

	}
	
	public int getCaixa() {
		return this.valorEmCaixa;
	}
	
	public void setTaxa(int valor) {
		this.valorEmCaixa += valor;
	}
	
	public double getTaxa() {
		return this.taxa;
	}	
	

}
