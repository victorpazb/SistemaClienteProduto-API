
public class Facade {
	
	public static void main(String[] args) {
		args = new String[] {"Facade", "testesAceitacao/use_case_1.txt"};
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




}
