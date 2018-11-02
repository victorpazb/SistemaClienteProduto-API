import easyaccept.EasyAccept;

public class Facade {
	
	public static void main(String[] args) {
		args = new String[] {"Facade", "testesAceitacao/use_case_1.txt"};
		EasyAccept.main(args);
	}

	Controller controle = new Controller();

	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		controle.adicionaCliente(cpf, nome, email, localizacao);
		return cpf;
	}

	public String exibeCliente(String cpf) {
		return controle.exibeCliente(cpf);

	}
	
	public String exibeClientes() {
		return controle.exibeClientes();
	}

	public void editaCliente(String cpf, String atributo, String novoValor) {
		controle.editaCliente(cpf, atributo, novoValor);

	}

	public void removeCliente(String cpf) {
		controle.removeCliente(cpf);
	}

	public void adicionaFornecedor(String nome, String email, String telefone) {
		controle.adicionaFornecedor(nome, email, telefone);
	}

	public String exibeFornecedor(String nome) {
		return controle.exibeFornecedor(nome);
	}

	public String exibeFornecedores() {
		return controle.exibeFornecedores();

	}

	public void editaFornecedor(String nome, String nomeAtributo, String novoValor) {
		controle.editaFornecedor(nome, nomeAtributo, novoValor);
	}

	public void removeFornecedor(String nome) {
		controle.removeFornecedor(nome);
	}

	public void adicionaProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		controle.adicionaProduto(nomeFornecedor, nomeProduto, descricao, preco);
	}
	

	public String exibeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		return controle.exibeProduto(nomeProduto, descricao, nomeFornecedor);
	}

	public String exibirProtudosDeUmFornecedor(String nomeFornecedor) { 
		return controle.exibirProtudosDeUmFornecedor(nomeFornecedor);
	}

	public String exibirProdutosDeTodosOsFornecedores() { 
		return controle.exibirProdutosDeTodosOsFornecedores();
	}

	public void editaProduto(String nomeFornecedor, String nomeProduto, String descricao, double novoPreco) {
		controle.editaProduto(nomeFornecedor, nomeProduto, descricao, novoPreco);
	}
	
	public void removeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		controle.removeProduto(nomeProduto, descricao, nomeFornecedor);
	}




}
