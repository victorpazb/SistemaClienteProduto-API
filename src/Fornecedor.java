import java.util.HashMap;

public class Fornecedor implements Comparable<Fornecedor> {
	
	private HashMap<String, Produto> listaDeProdutos;
	private String nome;
	private String email;
	private String telefone;
	
	
	public Fornecedor(String nome, String email, String telefone) {
		this.nome = nome.trim();
		this.email = email.trim();
		this.telefone = telefone.trim();
		this.listaDeProdutos = new HashMap<>();
	}
	
	
	@Override
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone; 
	}
	
	public String getNome() {
		return this.nome;
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
			if(this.listaDeProdutos.containsKey(nome)) {
				throw new IllegalArgumentException("produto ja cadastrado");
			}
		}
		
		Produto novoProduto = new Produto(nome, descricao, preco);
		this.listaDeProdutos.put(nome, novoProduto);
	}

	@Override
	public int compareTo(Fornecedor outroFornecedor) {
		return this.nome.compareTo(outroFornecedor.getNome());
	}
	
	
	
	

}
