
public class Facade {
	
	public static void main(String[] args) {
		args = new String[] {"Sample facade", "acceptance_test/us1.txt"};
	}

	Controller controle = new Controller();

	public void adicionaCliente(String cpf, String nome, String local, String email) {
		controle.adicionaCliente(cpf, nome, local, email);
	}

	public String exibeCliente(String cpf) {
		return controle.exibeCliente(cpf);

	}
	
	public String exibirListaDeClientes() {
		return controle.exibeListaDeClientes();
	}

	public void editaCliente(String cpf, String atributo, String novoValor) {
		controle.editaCliente(cpf, atributo, novoValor);

	}

	public void removeCliente(String cpf) {
		controle.removeCliente(cpf);
	}

	public void cadastrarFornecedor(String nome, String email, String telefone) {
		controle.cadastrarFornecedor(nome, email, telefone);
	}

	public String exibeFornecedor(String nome) {
		return controle.exibeFornecedor(nome);
	}

	public String exibirFornecedores() {
		return controle.exibirFornecedores();

	}

	public void editarFornecedor(String nome, String nomeAtributo, String novoValor) {
		controle.editarFornecedor(nome, nomeAtributo, novoValor);
	}

	public void removerFornecedor(String nome) {
		controle.removerFornecedor(nome);
	}

	public void cadastrarProduto(String nomeFornecedor, String nomeProduto, String descricao, String preco) {
		controle.cadastrarProduto(nomeFornecedor, nomeProduto, descricao, preco);
	}

	public String exibirProdutoEpecificoDeUmFornecedor(String nomeFornecedor, String nomeProduto) {
		return controle.exibirProdutoEpecificoDeUmFornecedor(nomeFornecedor, nomeProduto);
	}

	public String exibirProtudosDeUmFornecedor(String nomeFornecedor) { 
		return controle.exibirProtudosDeUmFornecedor(nomeFornecedor);
	}

	public String exibirProdutosDeTodosOsFornecedores() { 
		return controle.exibirProdutosDeTodosOsFornecedores();
	}

	public void editarProduto(String nomeFornecedor, String nomeProduto, String novoPreco) {
		controle.editarProduto(nomeFornecedor, nomeProduto, novoPreco);
	}




}
