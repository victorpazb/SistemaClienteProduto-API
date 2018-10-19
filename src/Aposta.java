
public class Aposta {

	private String nomeApostador;
	private int valorAposta;
	private String previsao;

	
	public Aposta(String nome, int valor, String previsao) {
		
		this.nomeApostador = nome;
		this.valorAposta = valor;
		this.previsao = previsao;
	}


	public String getNomeApostador() {
		return this.nomeApostador;
	}


	public int getValorAposta() {
		return this.valorAposta;
	}


	public String getPrevisao() {
		return this.previsao;
	}


	@Override
	public String toString() {
		return this.nomeApostador + " - " + this.valorAposta + " - " + this.previsao;
	}
	
	

}
