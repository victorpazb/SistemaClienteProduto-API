import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe cliente, representa um cliente a ser cadastrado no sistema e tem como
 * atributos: String nome, String localizacao, String email.
 */
public class Cliente implements Comparable<Cliente> {

	public String cpf;
	private String nome;
	private String localizacao;
	private String email;
	private ArrayList<Compra> listaDeCadaFornecedor;
	private HashMap<String, ArrayList<Compra>> listasDeCompraEmTodosOsFornecedore;

	/**
	 * Construtor da classe, recebe os parametros nome, emailç e localizacao.
	 * 
	 * @param nome
	 *            String que reprensenta o nome do cliente
	 * @param email
	 *            string que representa o endereco de email do cliente
	 * @param localizacao
	 *            string que representa a localizacao do cliente (onde trabalha/
	 *            estuda)
	 */
	public Cliente(String cpf, String nome, String email, String localizacao) {
		this.cpf = cpf;
		this.nome = nome.trim();
		this.localizacao = localizacao.trim();
		this.email = email.trim();
		this.listasDeCompraEmTodosOsFornecedore = new HashMap<>();
		this.listaDeCadaFornecedor = new ArrayList<>();

	}

	/**
	 * metodo que coloca uma Compra na lista de compras de um cliente que eh um
	 * mapa, o metodo recebe o nome do fornecedor, que sao as chaves do mapa. Caso a
	 * chave nao exista, ela eh inserida. O valor do mapa sao Arraylist que recebem
	 * o tipo Compra. Assim, ao criar uma compra, esse metodo eh chamado e verifica
	 * se o fornecedor existe na nesse mapa, se sim, a compra eh colocada pra ele,
	 * se ele nao existe na lista mas esta cadastrado na colecao de fornecedores,
	 * sera inserido um novo fornecedor na lista do cliente.
	 * 
	 * @param nomeFornecedor
	 *            String que representa o nome do fornecedor
	 * @param novaCompra
	 *            objeto do tipo compra, criado para ser inserido na lista de
	 *            compras que corresponde ao fornecedor passado
	 */
	public void setComprasNosFornecedores(String nomeFornecedor, Compra novaCompra) {
		if (!this.listasDeCompraEmTodosOsFornecedore.containsKey(nomeFornecedor)) {
			this.listaDeCadaFornecedor = new ArrayList<>();
			this.listaDeCadaFornecedor.add(novaCompra);
			this.listasDeCompraEmTodosOsFornecedore.put(nomeFornecedor, listaDeCadaFornecedor);

		} else {
			this.listasDeCompraEmTodosOsFornecedore.get(nomeFornecedor).add(novaCompra);
		}

	}

	public HashMap<String, ArrayList<Compra>> getListaGeralDeCOmpras() {
		return this.listasDeCompraEmTodosOsFornecedore;
	}
	
	public String getCpf() {
		return this.cpf;
	}

	/**
	 * getter que retorna o nome do cliente
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * setter que pode modificar o nome do cliente. recebe uma string novoNome e a
	 * atribiu ao nome do cliente
	 */
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}

	/**
	 * setter que modifica a localizacao do cliente, recebe uma String novoLocal e a
	 * atribui a localizacao
	 * 
	 * @param novoLocal
	 */
	public void setLocal(String novoLocal) {
		this.localizacao = novoLocal;
	}

	/**
	 * 
	 * setter que modifica o email do cliente, recebe uma String novoEmail e a
	 * atribui a email
	 */
	public void setEmail(String novoEmail) {
		this.email = novoEmail;
	}

	/**
	 * metodo toString de cliente, retorna: "NomeDoCliente - Localizacao - email"
	 */
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}

	/**
	 * compareTo da classe cliente, usado para comprar os nomes dos clientes uns com
	 * os outros para serem exibidos em ordem alfabetica
	 */
	@Override
	public int compareTo(Cliente outroCliente) {
		return this.nome.compareTo(outroCliente.getNome());
	}

}
