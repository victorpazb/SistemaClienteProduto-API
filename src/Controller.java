import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Controller {

	private HashMap<String, Cliente> colecaoClientes;
	private HashMap<String, Fornecedor> colecaoFornecedores;

	public Controller() {
		this.colecaoClientes = new HashMap<>();
		this.colecaoFornecedores = new HashMap<>();
	}
	
	public HashMap<String, Fornecedor> getColecaoFornecedores() {
		return this.colecaoFornecedores;
	}
	
	public HashMap<String, Cliente> getColecaoClientes() {
		return this.colecaoClientes;
	}

	public boolean cadastrarCliente(String cpf, String nome, String local, String email) {
		if (this.colecaoClientes.containsKey(cpf)) {
			throw new IllegalArgumentException("cpf ja cadastrado");
		}

		if (cpf == null | nome == null | local == null | email == null) {
			throw new NullPointerException("algum parametro passodo eh nulo");
		}

		if (cpf.trim().equals("") | nome.trim().equals("") | local.trim().equals("") | email.trim().equals("")) {
			throw new IllegalArgumentException("algum parametro passado eh vazio");
		}

		Cliente novoCliente = new Cliente(cpf, nome, local, email);
		this.colecaoClientes.put(cpf, novoCliente);
		return true;

	}

	public String exibirCliente(String cpf) {
		if (this.colecaoClientes.containsKey(cpf)) {
			return this.colecaoClientes.get(cpf).toString();
		}
		throw new IllegalArgumentException("cpf nao cadastrado");
	}

	public String exibeListaDeClientes() {

		if (this.colecaoClientes.isEmpty()) {
			throw new NullPointerException("nenhum cliente foi cadastrado");
		}

		ArrayList<Cliente> listaAuxiliarClientes = new ArrayList<>();
		listaAuxiliarClientes.addAll(this.colecaoClientes.values());
		Collections.sort(listaAuxiliarClientes);

		String listaOrdenada = "";
		for (int i = 0; i < listaAuxiliarClientes.size(); i++) {
			if (i == 0) {
				listaOrdenada += listaAuxiliarClientes.get(i).toString();
			} else {
				listaOrdenada += (" | " + listaAuxiliarClientes.get(i).toString());
			}

		}
		return listaOrdenada;

	}

	public void editarCliente(String cpf, String nomeAtributo, String novoValor) {

		if (cpf == null || nomeAtributo == null || novoValor == null) {
			throw new NullPointerException("algum argumento passado foi nulo");
		}

		if (cpf.trim().equals("") || novoValor.trim().equals("")) {
			throw new IllegalArgumentException("cpf ou novo valor estao vazios");
		}

		if (!this.colecaoClientes.containsKey(cpf)) {
			throw new IllegalArgumentException("cpf nao cadastrado");
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
			throw new NullPointerException("cpf nao cadastrado");
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
		if (!this.colecaoFornecedores.containsKey(nome) || nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("parametro invalido");
		}
		return this.colecaoFornecedores.get(nome).toString();

	}

	public String exibirFornecedores() {
		if (this.colecaoFornecedores.isEmpty()) {
			throw new NullPointerException("lista vazia");
		}

		ArrayList<Fornecedor> listaAuxiliarFornecedores = new ArrayList<>();
		listaAuxiliarFornecedores.addAll(this.colecaoFornecedores.values());

		Collections.sort(listaAuxiliarFornecedores);

		String listaOrdenada = "";
		for (int i = 0; i < listaAuxiliarFornecedores.size(); i++) {

			if (i == 0) {
				listaOrdenada += listaAuxiliarFornecedores.get(i).toString();
			} else {
				listaOrdenada += (" | " + listaAuxiliarFornecedores.get(i).toString());
			}

		}
		return listaOrdenada;
	}

	public void editarFornecedor(String nome, String nomeAtributo, String novoValor) {
		if (!this.colecaoFornecedores.containsKey(nome) || nome == null || nomeAtributo == null || novoValor == null
				|| nome.trim().equals("") || nomeAtributo.trim().equals("") || novoValor.trim().equals("")) {
			throw new IllegalArgumentException("parametro invalido passado");
		}

		switch (nomeAtributo.toLowerCase()) {
		case "email":
			this.colecaoFornecedores.get(nome).setEmail(novoValor);
			break;
		case "telefone":
			this.colecaoFornecedores.get(nome).setTelefone(novoValor);
			break;
		default:

			throw new IllegalArgumentException("opcao invalida, deve digitar email ou telefone");
		}

	}

	public void removerFornecedor(String nome) {
		if (!this.colecaoFornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("fornecedor nao cadastrado");
		}
		this.colecaoFornecedores.remove(nome);

	}

	public void cadastrarProduto(String nomeFornecedor, String nomeProduto, String descricao, String preco) {
		if (!this.colecaoFornecedores.containsKey(nomeFornecedor)) {
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

	public String exibirProtudosDeUmFornecedor(String nomeFornecedor) {
		if (!this.colecaoFornecedores.containsKey(nomeFornecedor)) {
			if (this.colecaoFornecedores.get(nomeFornecedor).getListaDeProdutos().isEmpty()) {
				throw new NullPointerException("lista de produtos vazia!");
			}
			throw new IllegalArgumentException("fornecedor nao encontrado");
		}

		ArrayList<Produto> listaDeProdutos = new ArrayList<>();

		listaDeProdutos.addAll(this.colecaoFornecedores.get(nomeFornecedor).getListaDeProdutos().values());

		Collections.sort(listaDeProdutos);

		String listaDeProdutosDoFornecedor = "";
		for (int i = 0; i < listaDeProdutos.size(); i++) {
			if (i == 0) {
				listaDeProdutosDoFornecedor += listaDeProdutos.get(i).toString();
			} else {
				listaDeProdutosDoFornecedor += (" | " + listaDeProdutos.get(i).toString());
			}

		}
		return listaDeProdutosDoFornecedor;

	}

	public String exibirProdutosDeTodosOsFornecedores() {
		if (this.colecaoFornecedores.isEmpty()) {
			throw new NullPointerException("sem fornecedores cadastrados");
		}

		ArrayList<Fornecedor> listaDeFornecedores = new ArrayList<>();
		listaDeFornecedores.addAll(this.colecaoFornecedores.values());

		ArrayList<Produto> listaDeProdutos = new ArrayList<>();

		String listaDeProdutosDeTodosFornecedores = "";
		boolean peloMenosUmTemProdutos = false;
		for (Fornecedor fornecedor : listaDeFornecedores) {
			if (!fornecedor.getListaDeProdutos().values().isEmpty()) {
				peloMenosUmTemProdutos = true;
				listaDeProdutos.addAll(fornecedor.getListaDeProdutos().values());

			}

		}
		if (peloMenosUmTemProdutos == false) {
			throw new IllegalArgumentException("fornecedor ainda nao tem produtos cadastrados");
		}

		Collections.sort(listaDeProdutos);
		for (int i = 0; i < listaDeProdutos.size(); i++) {
			if (i == 0) {
				listaDeProdutosDeTodosFornecedores += listaDeProdutos.get(i).toString();
			} else {
				listaDeProdutosDeTodosFornecedores += " | " + listaDeProdutos.get(i).toString();
			}

		}

		return listaDeProdutosDeTodosFornecedores;

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