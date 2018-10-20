import java.util.ArrayList;
public class Cenario {

	private String descricao;
	private String aconteceu;
	private String finalizado = "Nao finalizado";
	private static int id;
	private int count;
	private ArrayList<Aposta> colecaoApostades;

	
	
	
	public Cenario(String descricao) {
		this.descricao = descricao;
		this.colecaoApostades = new ArrayList<>();
		this.id = geradorDeId();
		
		
	}
	public static int geradorDeId() {
		return // travado nessse gerador do id...
	}
	
	public ArrayList getApostadores() {
		return this.colecaoApostades;
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
	
	public String exibirApostasDoCenrio() {
		String apostas = "";
		for(int i = 0; i < this.colecaoApostades.size(); i++) {
			apostas += this.colecaoApostades.get(i).toString() + "\n";
		}
		return apostas;
	}

	
	public String toString() {
		if(this.finalizado.equals("Nao finalizado")) {
			return this.id + " - " + this.descricao + " - " + this.finalizado;
		}
		return this.id + " - " + this.descricao + " - " + this.finalizado + " (" + this.aconteceu + ")";
	}

}
