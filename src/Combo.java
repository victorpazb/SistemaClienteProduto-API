import java.util.HashMap;
public class Combo {
	
	private HashMap<String, Produto> colecaoCombos;
	private String nome;
	private String descricao;
	private double fator;
	private double preco;
	
	public Combo(String nome, String descricao, double fator) {
		this.nome = nome;
		this.descricao = descricao;
		// this.preco = preco dos produtos - precoDosProdutos * fator;
	}
	
}
