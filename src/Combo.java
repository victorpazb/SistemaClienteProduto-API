import java.util.ArrayList;

public class Combo {

	private String produtos;
	private String fornecedor;
	private String nome;
	private String descricao;
	private double fator;
	private double precoDoCombo;

	public Combo(String fornecedor, String nome, String descricao, double fator, String produtos) {

		this.fornecedor = fornecedor;
		this.nome = nome;
		this.descricao = descricao;
		this.produtos = produtos;

	}

	public String getNome() {
		return this.nome;
	}
	
	public void setPreco(double preco) {
		this.precoDoCombo = preco;
	}


}
