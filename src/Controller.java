import java.util.HashMap;
import java.util.ArrayList;

public class Controller {

	HashMap<String, Cliente> colecaoClientes;
	ArrayList<String> listaDeClientes;

	public Controller() {
		this.colecaoClientes = new HashMap<>();
		this.listaDeClientes = new ArrayList<String>();
	}

	public void cadastrarClientes(String cpf, String nome, String local, String email) {
		Cliente novoCliente = new Cliente(cpf, nome, local, email);
		this.colecaoClientes.put(cpf, novoCliente);
		this.listaDeClientes.add(this.colecaoClientes.get(cpf).toString());

	}

	public String exibirCliente(String cpf) {
		if (this.colecaoClientes.containsKey(cpf)) {
			return this.colecaoClientes.get(cpf).toString();
		}
		return "cliente não cadastrado";
	}

	public String exibeListaDeClientes() {

		return this.listaDeClientes.toString();

	}

	public void editarCliente(String cpf, String nomeAtributo, String novoValor) {
		if(this.colecaoClientes.containsKey(cpf)) {
			
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

	public void removerCliente() {
		// lançar um illeagal?
	}

	public void cadastrarFornecedor(String nome, String email, String telefone) {

	}

	public String exibeFornecedor(String nome) {
		return fornecedor.toString();
	}

	public String exibirFornecedores() {
		return colecaoFornecedores.toString(); // retorno em ordem alfabetica
	}

	public void editarFornecedor(String nome) {

	}

	public void removerFornecedor() {

	}

	public void cadastrarProduto(String nome, String descricao, String preco) {

	}

	public String exibirProduto(String nome) {
		return colecaoProdutos.get(nome).toString(); // criar ou n classe produto??
	}

	public String exibirProtudos(){
	    for colecao{
	    string final += colecao.get(i).toString();    
	    }    
	    return colecaoProdutos.
	}

}