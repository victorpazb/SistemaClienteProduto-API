import java.util.ArrayList;
public class Cenario {

	private String descricao;
	private String aconteceu;
	private String finalizado = "Nao finalizado";
	private int id = 0;
	private ArrayList<Aposta> colecaoApostades;

	public Cenario(String descricao) {
		this.descricao = descricao;
		this.colecaoApostades = new ArrayList<>();
		this.id += 1;
		
	}
	
	public ArrayList getApostadores() {
		return this.colecaoApostades;
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

	
	public String toString() {
		if(this.finalizado.equals("Nao finalizado")) {
			return this.id + " - " + this.descricao + " - " + this.finalizado;
		}
		return this.id + " - " + this.descricao + " - " + this.finalizado + " (" + this.aconteceu + ")";
	}

}
