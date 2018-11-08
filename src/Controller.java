import java.util.HashMap;
import java.util.List;

import com.sun.java.accessibility.util.java.awt.ListTranslator;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * classe controller que contem todos os metodos usados pela fachada
 *
 */
public class Controller {

	private HashMap<String, Cliente> colecaoClientes;
	private HashMap<String, Fornecedor> colecaoFornecedores;

	/**
	 * construtor da classe controller, ao ser criada cria tambem os mapas que sao
	 * as colecoes colecaoClientes e colecaoFornecedores
	 */
	public Controller() {
		this.colecaoClientes = new HashMap<>();
		this.colecaoFornecedores = new HashMap<>();
	}

	/**
	 * @return getter que retorna a colecao de fornecedores
	 */

	public HashMap<String, Fornecedor> getColecaoFornecedores() {
		return this.colecaoFornecedores;
	}

	/**
	 * @return getter que retorna a colecao de clientes
	 */

	public HashMap<String, Cliente> getColecaoClientes() {
		return this.colecaoClientes;
	}

	/**
	 * metodo que adiona um cliente a colecao de clientes, recebe cpf, nome, email e
	 * localizacao
	 * 
	 * @param cpf
	 *            string que define o cpf do cliente
	 * @param nome
	 *            string que define o nome do cliente
	 * @param email
	 *            string que define o email do cliente
	 * @param localizacao
	 *            string que define a localizacao do cliente
	 * @return retorna o cpf cadastrado
	 */

	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		if (this.colecaoClientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}

		if (cpf == null || nome == null || localizacao == null || email == null) {
			throw new NullPointerException("algum parametro passado eh nulo");
		}

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
		if (email.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		if (localizacao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}

		Cliente novoCliente = new Cliente(nome, email, localizacao);
		this.colecaoClientes.put(cpf, novoCliente);
		return cpf;

	}

	/**
	 * metodo que exibe a representacao textual de um cliente, e o procura na
	 * colecao de clientes apartir do cpf passado
	 * 
	 * @param cpf
	 *            String usada para procurar o cliente na colecao de clientes
	 * @return retorna o toString() do cliente em questao, caso exista
	 */
	public String exibeCliente(String cpf) {
		if (!this.colecaoClientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");

		}

		return this.colecaoClientes.get(cpf).toString();

	}

	/**
	 * @return retorna o toString de todos os clientes cadastrados separados por "|"
	 *         e em ordem alfabetica
	 */
	public String exibeClientes() {

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

	/**
	 * metodoq que pode alterar os atributos de um cliente, exceto o cpf. recebe o
	 * cpf para localizar o cliente, o atributo q quer se alterar e o novo valor
	 * para o mesmo
	 * 
	 * @param cpf
	 *            string que localiza e identifica o cliente
	 * @param atributo
	 *            string que representa o atributo q se deseja alterar
	 * @param novoValor
	 *            valor novo para o atributo escolhido
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {

		if (cpf == null) {
			throw new NullPointerException("cpf nulo");
		}

		if (atributo == null || atributo.trim().equals("")) {
			throw new NullPointerException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}

		if (novoValor == null || novoValor.trim().equals("")) {
			throw new NullPointerException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}

		if (!this.colecaoClientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}

		if (!this.colecaoClientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}

		switch (atributo.toLowerCase()) {
		case "nome":
			this.colecaoClientes.get(cpf).setNome(novoValor);
			break;
		case "localizacao":
			this.colecaoClientes.get(cpf).setLocal(novoValor);
			break;
		case "email":
			this.colecaoClientes.get(cpf).setEmail(novoValor);
			break;
		default:
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
	}

	/**
	 * [ metodo que remove um clinete da colecao de clientes a partir de uma String
	 * cpf recebida com o cpf o cliente eh localizado ou nao na colecao e, caso
	 * exista, eh removido.
	 * 
	 * @param cpf
	 */
	public void removeCliente(String cpf) {
		this.colecaoClientes.remove(cpf);

	}

	/**
	 * metodo que cria e adiciona um fornecedor a colecao de fornecedores, caso ele
	 * ja nao exista na colecao. oq determina isso eh o nome, nao devem existir dois
	 * fornecedores de mesmo nome. priemrio o metodo verifica se a colecao contem a
	 * chave nome, caso nao exista ele cria o objeto novoFornecedor com os
	 * parametros passados.
	 * 
	 * @param nome
	 *            String que representa o nome do fornecedor
	 * @param email
	 *            String que representa o email do fornecedor
	 * @param telefone
	 *            String que representa o telefone do fornecedor
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		if (this.colecaoFornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}

		if (nome == null || email == null || telefone == null) {
			throw new NullPointerException("algum parametro passado eh nulo");
		}

		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if (email.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		if (telefone.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazia ou nula.");
		}

		Fornecedor novoFornecedor = new Fornecedor(nome, email, telefone);
		this.colecaoFornecedores.put(nome, novoFornecedor);
		return nome;

	}

	/**
	 * metodo que recebe uma String nome e com ela retorna o valor correspondente no
	 * mapa que guarda os fornecedores.
	 * 
	 * @param nome
	 *            String que representa o nome do fornecedor que se busca exibir
	 * @return Caso encontre, retorna o objeto correspondente na sua repsentacao
	 *         textual
	 */

	public String exibeFornecedor(String nome) {
		if (!this.colecaoFornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
		return this.colecaoFornecedores.get(nome).toString();

	}

	/**
	 * metodo que retorna a representacao textual de todos os fornecedores presentes
	 * na colecao de fornecedores separados por " | " e em ordem alfabetica
	 * 
	 */
	public String exibeFornecedores() {
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

	/**
	 * * metodoq que pode alterar os atributos de um fornecedor, exceto o nome.
	 * recebe o nome para localizar o fornecedor, o atributo q quer se alterar e o
	 * novo valor para o mesmo
	 * 
	 * @param nome
	 *            string que representa o fornecedor que se quer encontrar
	 * @param nomeAtributo
	 *            nome do atributo que se quer alterar
	 * @param novoValor
	 *            novo valor a ser atribuido ao atributo escolhido
	 */
	public void editaFornecedor(String nome, String nomeAtributo, String novoValor) {
		if (!this.colecaoFornecedores.containsKey(nome) || nome == null || nomeAtributo == null
				|| nome.trim().equals("") || nomeAtributo.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		}
		if (novoValor == null || novoValor.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		}

		switch (nomeAtributo.toLowerCase()) {
		case "email":
			this.colecaoFornecedores.get(nome).setEmail(novoValor);
			break;
		case "telefone":
			this.colecaoFornecedores.get(nome).setTelefone(novoValor);
			break;
		case "nome":
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");

		default:

			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}

	}

	/**
	 * metodo que remove um fornecedor da colecao de fornecedores. O localiza
	 * atraves da String nome passada, caso exista na colecao.
	 */
	public void removeFornecedor(String nome) {
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		}

		if (!this.colecaoFornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("fornecedor nao cadastrado");
		}
		this.colecaoFornecedores.remove(nome);

	}

	/**
	 * recebe o nome do fornecedor e tenta localiza lo na colecao de fornecedores,
	 * caso encontre usa o nome do produto + sua descricao para saber se esse
	 * fornecedor ja tem esse produto cadastrado, caso nao tenha o objeto produto eh
	 * criado com os parametros passados e adicionado a colecao de produtos daquele
	 * fornecedor especifico
	 * 
	 */
	public String adicionaProduto(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		if(descricao == null) {
			throw new NullPointerException();
		}
		
		if (nomeFornecedor == null || nomeFornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}

		if (!this.colecaoFornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}

		this.colecaoFornecedores.get(nomeFornecedor).addProduto(nomeFornecedor, nomeProduto, descricao, preco);
		return nomeProduto + " - " + descricao;
	}

	/**
	 * metodo que recebe o nome de um produto, descricao e fornecedor. com essas
	 * informacoes verifica se o fornecedor existe, existindo ele verifica na
	 * colecao de produtos desse cornecedor se o produto com essa descricao existe,
	 * existindo ele retorna o toString desse produto
	 *
	 */
	public String exibeProduto(String nomeProduto, String descricao, String nomeFornecedor) {

		if (nomeProduto == null || nomeProduto.trim().equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}

		if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}

		if (nomeFornecedor == null || nomeFornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}

		if (this.colecaoFornecedores.containsKey(nomeFornecedor)) {
			if (!this.colecaoFornecedores.get(nomeFornecedor).getListaDeProdutos()
					.containsKey(nomeProduto + " - " + descricao)) {
				throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
			}
		} else {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}

		if (this.colecaoFornecedores.get(nomeFornecedor).getListaDeProdutos()
				.containsKey(nomeProduto + " - " + descricao)) {
			return this.colecaoFornecedores.get(nomeFornecedor).getListaDeProdutos()
					.get(nomeProduto + " - " + descricao).toString();
		}
		throw new IllegalArgumentException("produto nao encontrado");
	}

	/**
	 * metodo que recebe uma String nome do fornecedor, verifica se ele esta na
	 * colecao de fornecedores. caso esteja presente, o metodo retorna uma
	 * represencao textual de todos os produso cadastrados para o fornecedor,
	 * separados por " | " e em ordem alfabetica, caso exista algum produto.
	 * 
	 */

	public String exibeProdutosFornecedor(String nomeFornecedor) {
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
				listaDeProdutosDoFornecedor += nomeFornecedor + " - " + listaDeProdutos.get(i).toString();
			} else {
				listaDeProdutosDoFornecedor += (" | " + nomeFornecedor + " - " + listaDeProdutos.get(i).toString());
			}

		}
		return listaDeProdutosDoFornecedor;

	}

	/**
	 * metodo retorna uma represencao textual de todos os produso cadastrados para
	 * todos os fornecedores, separados por " | " e em ordem alfabetica, caso exista
	 * algum para todos eles produto.
	 */

	public String exibeProdutos() {
		if (this.colecaoFornecedores.isEmpty()) {
			throw new NullPointerException("sem fornecedores cadastrados");
		}

		ArrayList<Fornecedor> listaDeFornecedores = new ArrayList<>();

		listaDeFornecedores.addAll(this.colecaoFornecedores.values());
		Collections.sort(listaDeFornecedores);

		String todosOsProdutos = "";
		for (int j = 0; j < listaDeFornecedores.size(); j++) {
			ArrayList<Produto> listaDeProdutos = new ArrayList<>();
			listaDeProdutos.addAll(listaDeFornecedores.get(j).getListaDeProdutos().values());
			Collections.sort(listaDeProdutos);

			for (int i = 0; i < listaDeProdutos.size(); i++) {

				if (i == 0 && j == 0) {
					todosOsProdutos += listaDeProdutos.get(i).toStringParaImpressaoEmListaGeral();
				} else {

					todosOsProdutos += " | " + listaDeProdutos.get(i).toStringParaImpressaoEmListaGeral();
				}
			}
		}

		return todosOsProdutos;

	}

	/**
	 * metodo que edita o preco de um produto. Nem o nome nem a descricao podem ser
	 * alterados
	 * 
	 */
	public void editaProduto(String nomeProduto, String descricao, String nomeFornecedor, double novoPreco) {

		if (novoPreco < 0.0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
		if (nomeProduto == null || nomeProduto.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.trim().equals("")) {

			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}

		if (nomeFornecedor == null || nomeFornecedor.trim().equals("")) {

			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}

		if (!this.colecaoFornecedores.containsKey(nomeFornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}

		if (!this.colecaoFornecedores.get(nomeFornecedor).getListaDeProdutos()
				.containsKey(nomeProduto + " - " + descricao)) {
			throw new IllegalArgumentException("produto nao cadastrado");
		}

		this.colecaoFornecedores.get(nomeFornecedor).getListaDeProdutos().get(nomeProduto + " - " + descricao)
				.setPreco(novoPreco);

	}

	/**
	 * 
	 * Metodo que recebe uma String nomeFornecedor e verifica se ele existe na
	 * colecao de fornecedores. Caso exista, verifica-se se o produto existe na
	 * colecao de produtos dele. Caso exista, esse produto eh removido
	 */

	public void removeProduto(String nomeProduto, String descricao, String nomeFornecedor) {

		if (nomeProduto == null || nomeProduto.trim().equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}
		if (nomeFornecedor == null || nomeFornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}

		if (nomeFornecedor.trim().equals("") || descricao.trim().equals("") || nomeProduto.trim().equals("")) {
			throw new IllegalArgumentException();
		}

		if (!this.colecaoFornecedores.containsKey(nomeFornecedor)) {

			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");

		}

		if (!this.colecaoFornecedores.get(nomeFornecedor).getListaDeProdutos()
				.containsKey(nomeProduto + " - " + descricao)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}

		this.colecaoFornecedores.get(nomeFornecedor).getListaDeProdutos().remove(nomeProduto + " - " + descricao);

	}

	/**
	 * recebe o nome do fornecedor e tenta localiza lo na colecao de fornecedores,
	 * caso encontre, usa o nome do combo para saber se esse fornecedor ja tem esse
	 * Combo cadastrado, caso nao tenha o objeto combo eh criado com os parametros
	 * passados e adicionado a colecao de Combos daquele fornecedor especifico
	 * 
	 */
	public String adicionaCombo(String fornecedor, String nomeCombo, String descricao, double fator, String produtos) {

		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		}

		if (!this.colecaoFornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
		}

		this.colecaoFornecedores.get(fornecedor).adicionaCombo(fornecedor, nomeCombo, descricao, fator, produtos);
		return nomeCombo;
	}

	/**
	 * [ metodo que edita apenas o fator de um combo
	 * 
	 * @param nomeCombo
	 *            - String que representa o nome do combo e junto com a descricao eh
	 *            usado como chave no mapa de produtos
	 *
	 * @param descricao
	 *            string que descreve o combo e compoe a chave do combo no mapa de
	 *            produtos
	 * @param fornecedor
	 *            string que representa o fornecedor que vai se pesquisar os
	 *            produtos que formarao o combo
	 * @param novoFator
	 *            double que representa o novoFator que sera aplicado ao combo
	 */
	public void editaCombo(String nomeCombo, String descricao, String fornecedor, double novoFator) {

		if (nomeCombo == null || nomeCombo.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		}
		if (descricao == null || descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		}
		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
		}
		if (!this.colecaoFornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao existe.");
		}

		if (novoFator <= 0 || novoFator >= 1) {
			throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
		}

		if (!this.colecaoFornecedores.get(fornecedor).getListaDeProdutos().containsKey(nomeCombo + " - " + descricao)) {
			throw new IllegalArgumentException("Erro na edicao de combo: produto nao existe.");
		}

		if (this.colecaoFornecedores.get(fornecedor).getListaDeProdutos()
				.get(nomeCombo + " - " + descricao) instanceof ProdutoComposto) {
			((ProdutoComposto) this.colecaoFornecedores.get(fornecedor).getListaDeProdutos()
					.get(nomeCombo + " - " + descricao)).setFator(novoFator);
		}

	}

	/**
	 * metodo que adiciona um objeto compra a uma lista de compras(arrayList) e esta
	 * relacionada a um fornecedor. essa dupla eh armazenada em um mapa que o
	 * cliente contem, onde a chave e valor do mapa sao respectivamente fornecedor e
	 * lista que recebe o tipo compra
	 * 
	 * @param cpf
	 *            string que representa o cpf do cliente e eh usado para encontralo
	 *            na colecao de clientes
	 * @param fornecedor
	 *            string que representa o fornecedor e eh usado para encontrar o
	 *            fornecedor na colecao de fornecedores alem de setar as chaves do
	 *            mapa
	 * @param data
	 *            string que representa a data da compra e eh um atributo de compra
	 *            tambem
	 * @param nomeProduto
	 *            string q representa o produto e eh um atributo de compra
	 * @param descricaoProduto
	 *            string que representa a descricao do produto e tambem eh um
	 *            atributo de compra
	 */
	public void adicionaCompra(String cpf, String fornecedor, String data, String nomeProduto,
			String descricaoProduto) {
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
		}
		if (data == null || data.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		}
		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		}
		if (descricaoProduto == null || descricaoProduto.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula");
		}

		String[] dataQuebrada = data.split("/");
		if (dataQuebrada[0].length() != 2 || dataQuebrada[1].length() != 2 || dataQuebrada[2].length() != 4) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");

		}
		if (nomeProduto == null || nomeProduto.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		}

		if (!this.colecaoClientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}
		if (!this.colecaoFornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
		}

		if (!this.colecaoFornecedores.get(fornecedor).getListaDeProdutos()
				.containsKey(nomeProduto + " - " + descricaoProduto)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
		}

		double preco = this.colecaoFornecedores.get(fornecedor).getListaDeProdutos()
				.get(nomeProduto + " - " + descricaoProduto).getPreco();
		Compra novaCompra = new Compra(data, nomeProduto, preco);
		this.colecaoClientes.get(cpf).setComprasNosFornecedores(fornecedor, novaCompra);

	}

	/**
	 * metodo que atraves do cpf passado encontra um cliente e com o nome do
	 * fornecedor verifica o saldo devedor pelas compras feitas com equele
	 * fornecedor especifico
	 * 
	 * @param cpf
	 *            String que representa o cpf do cliente
	 * @param fornecedor
	 *            string que representa nome do fornecedor
	 * @return retorna uma String que representa o saldo devedor do cliente junto ao
	 *         fornecedor informado
	 */
	public String getDebito(String cpf, String fornecedor) {

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf invalido.");
		}
		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		}
		if (!this.colecaoClientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
		}
		if (!this.colecaoFornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
		}
		if (this.colecaoFornecedores.containsKey(fornecedor) && this.colecaoClientes.containsKey(cpf)
				&& (!this.colecaoClientes.get(cpf).getListaGeralDeCOmpras().containsKey(fornecedor))) {
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		}

		double debitoDoCliente = 0.0;
		String debitoDoClienteFormatado = "";
		if (this.colecaoFornecedores.containsKey(fornecedor) && this.colecaoClientes.containsKey(cpf)
				&& this.colecaoClientes.get(cpf).getListaGeralDeCOmpras().containsKey(fornecedor)) {
			ArrayList<Compra> listaDeCompras = this.colecaoClientes.get(cpf).getListaGeralDeCOmpras().get(fornecedor);
			for (Compra compra : listaDeCompras) {
				debitoDoCliente += compra.getPreco();
			}
		}
		debitoDoClienteFormatado = String.format("%.2f", debitoDoCliente);
		return debitoDoClienteFormatado;

	}

	/**
	 * Metodo que recebe o cpf para encontrar um cliente, a partir dele verifica a
	 * lista de contas do cliente, verifica se exite uma conta que seja do
	 * fornecedor informado. caso exista, eh feita uma varredura nos produtos e seus
	 * toString sao coledos e uma lista com os produtos consumidos naquele
	 * fornecedor pelo cliente, eh exibida.
	 * 
	 * @param cpf
	 *            cpf do cliente
	 * @param fornecedor
	 *            nome do fornecedor onde foram feitas as compras
	 * @return retorna uma lista de Strings q sao os produtos consumidos no
	 *         fornecedor informado
	 */

	public String exibeContas(String cpf, String fornecedor) {

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf invalido.");
		}

		if (!this.colecaoClientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
		}
		if (fornecedor == null || fornecedor.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		}
		if (!this.colecaoFornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");
		}

		if (this.colecaoFornecedores.containsKey(fornecedor) && this.colecaoClientes.containsKey(cpf)
				&& (!this.colecaoClientes.get(cpf).getListaGeralDeCOmpras().containsKey(fornecedor))) {
			throw new IllegalArgumentException(
					"Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		}

		String listaComprasEmUmFornecedor = "Cliente: " + this.colecaoClientes.get(cpf).getNome() + " | "
				+ this.colecaoFornecedores.get(fornecedor).getNome();
		ArrayList<Compra> comprasEmUmFornecedor = this.colecaoClientes.get(cpf).getListaGeralDeCOmpras()
				.get(fornecedor);
		for (Compra compra : comprasEmUmFornecedor) {
			listaComprasEmUmFornecedor += " | " + compra.toString();
		}
		return listaComprasEmUmFornecedor;
	}

	/**
	 * @return exibe a lista de todas as compras realizadas em todos os
	 *         fornecedores, sendo apresentada de modo que os fornecedores aparecam
	 *         em ordem alfabetica
	 * 
	 */
	public String exibeContasClientes(String cpf) {

		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf invalido.");
		}
		if (!this.colecaoClientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
		}
		if (this.colecaoClientes.get(cpf).getListaGeralDeCOmpras().isEmpty()) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
		}

		ArrayList<String> listaOrdenadaDeFornecedores = new ArrayList<>();
		listaOrdenadaDeFornecedores.addAll(this.colecaoClientes.get(cpf).getListaGeralDeCOmpras().keySet());
		Collections.sort(listaOrdenadaDeFornecedores);

		HashMap<String, ArrayList<Compra>> listasDeCompraDeUmCliente = this.colecaoClientes.get(cpf)
				.getListaGeralDeCOmpras();

		String representacaoTodasAsCompras = "Cliente: " + this.colecaoClientes.get(cpf).getNome();
		for (String fornecedor : listaOrdenadaDeFornecedores) {
			if (listasDeCompraDeUmCliente.containsKey(fornecedor)) {
				representacaoTodasAsCompras += " | " + fornecedor;
				ArrayList<Compra> listaDeCompra = listasDeCompraDeUmCliente.get(fornecedor);
				for (Compra compra : listaDeCompra) {
					representacaoTodasAsCompras += " | " + compra.toString();
				}
			}
		}

		return representacaoTodasAsCompras;

	}

}