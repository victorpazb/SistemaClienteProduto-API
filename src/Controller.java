import java.util.HashMap;

public class Controller {

	HashMap<String, Cliente> colecaoClientes;
	HashMap<String, Fornecedor> colecaoFornecedores;

	public Controller() {
		this.colecaoClientes = new HashMap<>();
		this.colecaoFornecedores = new HashMap<>();
	}

	public void cadastrarClientes(String cpf, String nome, String local, String email) {
		if (!this.colecaoClientes.containsKey(cpf)) {
			Cliente novoCliente = new Cliente(cpf, nome, local, email);
			this.colecaoClientes.put(cpf, novoCliente);
		}
		throw new IllegalArgumentException("cpf ja cadastrado");
	}

	public String exibirCliente(String cpf) {
		if (this.colecaoClientes.containsKey(cpf)) {
			return this.colecaoClientes.get(cpf).toString();
		}
		return "cliente não cadastrado";
	}

	public String exibeListaDeClientes() { // tem que ser em ordem alfabetica tambem

		return "";

	}

	public void editarCliente(String cpf, String nomeAtributo, String novoValor) {
		if (this.colecaoClientes.containsKey(cpf)) {

			switch (nomeAtributo.toLowerCase()) {
			case "nome":
				this.colecaoClientes.get(cpf).setNome(novoValor);
				break;
			case "local":
				this.colecaoClientes.get(cpf).setLocal(novoValor);
				break;
			case "email":
				this.colecaoClientes.get(cpf).setEmail(novoValor);
				break;
			default:
				throw new IllegalArgumentException("opcao invalida");
			}
		}
		throw new NullPointerException("cpf nao cadastrado"); // alguma duvida sobre qual excecao lancar
	}

	public void removerCliente(String cpf) {
		if (this.colecaoClientes.containsKey(cpf)) {
			this.colecaoClientes.remove(cpf);
		}
		throw new IllegalArgumentException("cpf nao cadastrado");

	}

	public void cadastrarFornecedor(String nome, String email, String telefone) {
		if (!this.colecaoFornecedores.containsKey(nome)) {
			Fornecedor novoFornecedor = new Fornecedor(nome, email, telefone);
			this.colecaoFornecedores.put(nome, novoFornecedor);
		}

		throw new IllegalArgumentException("fornecedero ja cadastrado");

	}

	public String exibeFornecedor(String nome) {
		if (this.colecaoFornecedores.containsKey(nome)) {
			return this.colecaoFornecedores.get(nome).toString();
		}
		throw new IllegalArgumentException("fornecedor nao cadastrado");

	}

	public String exibirFornecedores() {
		return colecaoFornecedores.toString(); // retorno em ordem alfabetica
	}

	public void editarFornecedor(String nome, String nomeAtributo, String novoValor) {
		if (this.colecaoFornecedores.containsKey(nome)) {

			switch (nomeAtributo.toLowerCase()) {
			case "email":
				this.colecaoFornecedores.get(nome).setEmail(novoValor);
				break;
			case "telefone":
				this.colecaoFornecedores.get(nome).setTelefone(novoValor);
				break;
			default:

				throw new IllegalArgumentException("opcao invalida");
			}
		}
		throw new NullPointerException("cpf nao cadastrado");

	}

	public void removerFornecedor(String nome) {
		if (this.colecaoFornecedores.containsKey(nome)) {
			this.colecaoClientes.remove(nome);
		}
		throw new IllegalArgumentException("fornecedor nao cadastrado");

	}

	public void cadastrarProduto(String nomeFornecedor, String nomeProduto, String descricao, String preco) {

		if (this.colecaoFornecedores.containsKey(nomeFornecedor))
			this.colecaoFornecedores.get(nomeFornecedor).addProduto(nomeProduto, descricao, preco);

	}

	public String exibirProdutoEpecificoDeUmFornecedor(String nomeFornecedor, String nomeProduto) {
		if (this.colecaoFornecedores.containsKey(nomeFornecedor)) {
			if (this.colecaoFornecedores.get(nomeFornecedor).getListaDeProdutos().containsKey(nomeProduto)) {
				return this.colecaoFornecedores.get(nomeFornecedor).getListaDeProdutos().get(nomeProduto).toString();
			}
			throw new IllegalArgumentException("produto nao cadastrado");
		}
		throw new IllegalArgumentException("fornecedor nao cadastrado");
	}

	public String exibirProtudosDeUmFornecedor(String nomeFornecedor) { // em ordem alfa
		return "SSA";
	}

	public String exibirProdutosDeTodosOsFornecedores() { // em ordem alfabetica do fornecedor
		return "CFZ";
	}

	public void editarProduto(String nomeFornecedor, String nomeProduto, String novoPreco) {
		if (this.colecaoFornecedores.containsKey(nomeFornecedor)) {
			if (this.colecaoFornecedores.get(nomeFornecedor).getListaDeProdutos().containsKey(nomeProduto)) {
				this.colecaoFornecedores.get(nomeFornecedor).getListaDeProdutos().get(nomeProduto).setPreco(novoPreco);
			}
			throw new IllegalArgumentException("produto nao cadastrado");
		}
		throw new IllegalArgumentException("fornecedor nao cadastrado");
	}

}