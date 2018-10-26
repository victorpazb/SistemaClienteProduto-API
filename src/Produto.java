import com.sun.org.apache.xpath.internal.operations.Equals;

import sun.security.util.Cache.EqualByteArray;

public class Produto {

	private String nome;
	private String descricao;
	private String preco;

	public Produto(String nome, String descricao, String preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public String getNome() {
		return this.nome;
	}

	public void setPreco(String novoPreco) {
		this.preco = novoPreco;
	}

	@Override
	public boolean equals(Object obj) {

		Produto produtoTeste = (Produto) obj;
		return this.nome.equals(produtoTeste.nome);
	}

}
