
public class Facade {

	Controller controle = new Controller();

	public void cadastrarClientes(String cpf, String nome, String local, String email) {
		controle.cadastrarClientes(cpf, nome, local, email);
	}

	public String exibirCliente(String cpf) {
		return controle.exibirCliente(cpf);

	}

	public void editarCliente(String cpf, String nomeAtributo, String novoValor) {
		controle.editarCliente(cpf, nomeAtributo, novoValor);

	}

	public void removerCliente(String cpf) {
		controle.removerCliente(cpf);
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

	public String exibirProtudosDeUmFornecedor(String nomeFornecedor) { // em ordem alfa
		return controle.exibirProtudosDeUmFornecedor(nomeFornecedor);
	}

	public String exibirProdutosDeTodosOsFornecedores() { // em ordem alfabetica do fornecedor
		return controle.exibirProdutosDeTodosOsFornecedores();
	}

	public void editarProduto(String nomeFornecedor, String nomeProduto, String novoPreco) {
		controle.editarProduto(nomeFornecedor, nomeProduto, novoPreco);
	}




}
