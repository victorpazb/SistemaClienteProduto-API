import java.util.ArrayList;

public class Cenario {

	private int valorTotalRateio;
	private String descricao;
	private String aconteceu;
	private String finalizado = "Nao finalizado";
	private static int counter;
	private int id;
	private ArrayList<Aposta> colecaoApostades;

	Controller controle = new Controller();

	public Cenario(String descricao) {
		this.descricao = descricao;
		this.colecaoApostades = new ArrayList<>();
		counter++;
		this.id = counter;

	}
	
	public ArrayList<Aposta> getColecaoApostadores() {
		return this.colecaoApostades;
	}

	
	public Aposta getApostadores(int i) {
		return this.colecaoApostades.get(i);
	}

	public void setApostadores(String apostador, int valor, String previsao) {
		Aposta novaAposta = new Aposta(apostador, valor, previsao);
		this.colecaoApostades.add(novaAposta);
	}

	public int getId() {
		return this.id;
	}

	public void setAconteceu(String ocorreuOuNao) {
		this.aconteceu = ocorreuOuNao;
	}

	public void setFinalizado(String finalizadoOuNao) {
		this.finalizado = finalizadoOuNao;
	}
	
	public void setValorTotalRateio(int valor) {
		this.valorTotalRateio = valor;
	}
	
	public int getValorTotalRateio() {
		return this.valorTotalRateio;
	}

	public String exibirApostasDoCenario() {
		String apostas = "";
		for (int i = 0; i < this.colecaoApostades.size(); i++) {
			apostas += this.colecaoApostades.get(i).toString() + "\n";
		}
		return apostas;
	}

	public String toString() {
		if (this.finalizado.equals("Nao finalizado")) {
			return this.id + " - " + this.descricao + " - " + this.finalizado;
		}
		return this.id + " - " + this.descricao + " - " + this.finalizado + " (" + this.aconteceu + ")";
	}

}
