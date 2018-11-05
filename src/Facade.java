import easyaccept.EasyAccept;

public class Facade {
	
	public static void main(String[] args) {
		args = new String[] {"Facade", "testesAceitacao/use_case_1.txt", "testesAceitacao/use_case_2.txt", "testesAceitacao/use_case_3.txt", "testesAceitacao/use_case_4.txt" };
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

	public String adicionaFornecedor(String nome, String email, String telefone) {
		controle.adicionaFornecedor(nome, email, telefone);
		return nome;
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

	public String adicionaProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		controle.adicionaProduto(nomeFornecedor, nomeProduto, descricao, preco);
		return nomeProduto + " - " + descricao;
	}
	

	public String exibeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		return controle.exibeProduto(nomeProduto, descricao, nomeFornecedor);
	}

	public String exibeProdutosFornecedor(String nomeFornecedor) { 
		return controle.exibeProdutosFornecedor(nomeFornecedor);
	}

	public String exibeProdutos() { 
		return controle.exibeProdutos();
	}

	public void editaProduto(String nomeFornecedor, String nomeProduto, String descricao, double novoPreco) {
		controle.editaProduto(nomeFornecedor, nomeProduto, descricao, novoPreco);
	}
	
	public void removeProduto(String nomeProduto, String descricao, String nomeFornecedor) {
		controle.removeProduto(nomeProduto, descricao, nomeFornecedor);
	}
	
	public String adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		controle.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
		return nome;
	}





}
