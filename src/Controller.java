import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Controller {

	HashMap<String, Cliente> colecaoClientes;
	HashMap<String, Fornecedor> colecaoFornecedores;
	ArrayList<Fornecedor> listaAuxiliar;

	public Controller() {
		this.colecaoClientes = new HashMap<>();
		this.colecaoFornecedores = new HashMap<>();
	}

	public void cadastrarClientes(String cpf, String nome, String local, String email) {
		if (this.colecaoClientes.containsKey(cpf)) {
			throw new IllegalArgumentException("cpf ja cadastrado");
		}
		Cliente novoCliente = new Cliente(cpf, nome, local, email);
		this.colecaoClientes.put(cpf, novoCliente);

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
		if (!this.colecaoClientes.containsKey(cpf)) {
			throw new NullPointerException("cpf nao cadastrado");
		}

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

	public void removerCliente(String cpf) {
		if (!this.colecaoClientes.containsKey(cpf)) {
			throw new IllegalArgumentException("cpf nao cadastrado");
		}
		this.colecaoClientes.remove(cpf);

	}

	public void cadastrarFornecedor(String nome, String email, String telefone) {
		if (this.colecaoFornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("fornecedero ja cadastrado");
		}

		Fornecedor novoFornecedor = new Fornecedor(nome, email, telefone);
		this.colecaoFornecedores.put(nome, novoFornecedor);

	}

	public String exibeFornecedor(String nome) {
		if (!this.colecaoFornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("fornecedor nao cadastrado");
		}
		return this.colecaoFornecedores.get(nome).toString();

	}

	public String exibirFornecedores() {
		
		listaAuxiliar = new ArrayList<>();
		listaAuxiliar.addAll(this.colecaoFornecedores.values());
		Collections.sort(listaAuxiliar);
		String listaOrdenada = "";
		for (Fornecedor fornecedor : listaAuxiliar) {
			listaOrdenada += fornecedor.toString() + "\n";
		}
		return listaOrdenada;
	}

	public void editarFornecedor(String nome, String nomeAtributo, String novoValor) {
		if (!this.colecaoFornecedores.containsKey(nome)) {
			throw new NullPointerException("cpf nao cadastrado");
		}

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

	public void removerFornecedor(String nome) {
		if (!this.colecaoFornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("fornecedor nao cadastrado");
		}
		this.colecaoClientes.remove(nome);

	}

	public void cadastrarProduto(String nomeFornecedor, String nomeProduto, String descricao, String preco) {

		if (!this.colecaoFornecedores.containsKey(nomeFornecedor)) {
			if (this.colecaoFornecedores.get(nomeFornecedor).getListaDeProdutos().containsKey(nomeProduto)) {
				throw new IllegalArgumentException("produto ja cadastrado");
			}

			throw new IllegalArgumentException("fornecedor nao cadastrado");
		}

		this.colecaoFornecedores.get(nomeFornecedor).addProduto(nomeProduto, descricao, preco);

	}

	public String exibirProdutoEpecificoDeUmFornecedor(String nomeFornecedor, String nomeProduto) {
		if (!this.colecaoFornecedores.containsKey(nomeFornecedor)) {
			if (!this.colecaoFornecedores.get(nomeFornecedor).getListaDeProdutos().containsKey(nomeProduto)) {
				throw new IllegalArgumentException("produto nao cadastrado");
			}
			throw new IllegalArgumentException("fornecedor nao cadastrado");
		}
		return this.colecaoFornecedores.get(nomeFornecedor).getListaDeProdutos().get(nomeProduto).toString();
	}

	public String exibirProtudosDeUmFornecedor(String nomeFornecedor) { // em ordem alfa
		return "SSA";
	}

	public String exibirProdutosDeTodosOsFornecedores() { // em ordem alfabetica do fornecedor
		return "CFZ";
	}

	public void editarProduto(String nomeFornecedor, String nomeProduto, String novoPreco) {
		if (!this.colecaoFornecedores.containsKey(nomeFornecedor)) {
			if (!this.colecaoFornecedores.get(nomeFornecedor).getListaDeProdutos().containsKey(nomeProduto)) {
				throw new IllegalArgumentException("produto nao cadastrado");
			}
			throw new IllegalArgumentException("fornecedor nao cadastrado");
		}
		this.colecaoFornecedores.get(nomeFornecedor).getListaDeProdutos().get(nomeProduto).setPreco(novoPreco);

	}

}