import java.util.HashMap;

public class Fornecedor {
	private HashMap<String, Produto> listaDeProdutos;
	private String nome;
	private String email;
	private String telefone;
	
	
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.listaDeProdutos = new HashMap<>();
	}
	
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone; 
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public HashMap<String, Produto> getListaDeProdutos() {
		return this.listaDeProdutos;
	}
	
	public void addProduto(String nome, String descricao, String preco ) {
		for(int i = 0; i < this.listaDeProdutos.size(); i++) {
			if(this.listaDeProdutos.get(i).getNome().equals(nome)) {
				throw new IllegalArgumentException("produto ja cadastrado");
			}
		}
		
		Produto novoProduto = new Produto(nome, descricao, preco);
		this.listaDeProdutos.put(nome, novoProduto);
	}
	
	
	
	

}
