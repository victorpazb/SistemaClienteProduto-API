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

	public void editarCliente() {
		// alterar atributos de cliente, menos o cpf
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