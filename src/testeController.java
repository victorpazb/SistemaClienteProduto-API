import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testeController {

	Controller controleTeste;

	@Test
	void testeCadastrarCliente() {
		controleTeste = new Controller();
		assertTrue(controleTeste.adicionaCliente("123", "victor", "lcc3", "victor@paz.com"));
	}

	@Test
	void testeCadastrarClienteComAlgumParametroNulo() {
		controleTeste = new Controller();
		assertThrows(NullPointerException.class,
				() -> controleTeste.adicionaCliente(null, "victor", "lcc3", "victor@ufcg.br"));
		assertThrows(NullPointerException.class,
				() -> controleTeste.adicionaCliente("123", null, "lcc3", "victor@ufcg.br"));
		assertThrows(NullPointerException.class,
				() -> controleTeste.adicionaCliente("123", "victor", null, "victor@ufcg.br"));
		assertThrows(NullPointerException.class, () -> controleTeste.adicionaCliente("123", "victor", "lcc3", null));
	}

	@Test
	void testeCadastrarClienteComAlgumParametroVazio() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaCliente("    ", "victor", "lcc3", "victor@ufcg.br"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaCliente("123", "    ", "lcc3", "victor@ufcg.br"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaCliente("123", "victor", "    ", "victor@ufcg.br"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaCliente("123", "victor", "lcc3", "    "));
	}

	@Test
	void testeCadastrarClienteJaCadastrado() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("123", "victor", "lcc3", "victor.braga@ccc.ufcg.edu.br");
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaCliente("123", "victor", "lcc3", "victor.braga@ccc.ufcg.edu.br"));

	}

	@Test
	void testeExibirCliente() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("123", "victor", "lcc3", "victor.braga@ccc.ufcg.edu.br");
		assertEquals("victor - lcc3 - victor.braga@ccc.ufcg.edu.br", controleTeste.exibeCliente("123"));
	}

	@Test
	void testeExibirClienteQueNaoExiste() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeCliente("234"));
	}

	@Test
	void testeExibirListaDeClientes() {
		controleTeste = new Controller();

		controleTeste.adicionaCliente("324", "hugo", "lcc3", "hugo@paz.com");
		controleTeste.adicionaCliente("123", "victor", "lcc3", "victor@paz.com");
		controleTeste.adicionaCliente("345", "paulo", "lcc3", "paulo@paz.com");
		assertEquals("hugo - lcc3 - hugo@paz.com | paulo - lcc3 - paulo@paz.com | victor - lcc3 - victor@paz.com",
				controleTeste.exibeListaDeClientes());
	}

	@Test
	void testeExibirListaDeClientesVazia() {
		controleTeste = new Controller();
		assertThrows(NullPointerException.class, () -> controleTeste.exibeListaDeClientes());
	}

	@Test
	void testeEditarClienteNome() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("123", "victor", "lcc3", "victor@paz.com");
		controleTeste.editaCliente("123", "nome", "braga");
		assertEquals("braga - lcc3 - victor@paz.com", controleTeste.exibeCliente("123"));
	}

	@Test
	void testeEditarClienteLocal() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("123", "victor", "lcc3", "victor@paz.com");
		controleTeste.editaCliente("123", "local", "spLab");
		assertEquals("victor - spLab - victor@paz.com", controleTeste.exibeCliente("123"));
	}

	@Test
	void testeEditarClienteEmail() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("123", "victor", "lcc3", "victor@paz.com");
		controleTeste.editaCliente("123", "email", "victorpfb@ufcg.com");
		assertEquals("victor - lcc3 - victorpfb@ufcg.com", controleTeste.exibeCliente("123"));
	}

	@Test
	void testeEditarClienteNaoCadastrado() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.editaCliente("123", "email", "victorpfb@ufcg.com"));
	}

	@Test
	void testeEditarClienteComParametroNulo() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("123", "victor", "lcc3", "victor@paz.com");

		assertThrows(NullPointerException.class, () -> controleTeste.editaCliente(null, "local", "lcc2"));
		assertThrows(NullPointerException.class, () -> controleTeste.editaCliente("123", null, "victorpfb@ufcg.com"));
		assertThrows(NullPointerException.class, () -> controleTeste.editaCliente("123", "nome", null));

	}

	@Test
	void testeEditarClienteComParametroVazio() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("123", "victor", "lcc3", "victor@paz.com");

		assertThrows(IllegalArgumentException.class, () -> controleTeste.editaCliente("   ", "local", "lcc2"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.editaCliente("123", "  ", "victorpfb@ufcg.com"));
		assertThrows(IllegalArgumentException.class, () -> controleTeste.editaCliente("123", "nome", "   "));

	}

	@Test
	void testeRemoverCliente() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("123", "victor", "lcc3", "victor@paz.com");
		assertEquals("victor - lcc3 - victor@paz.com", controleTeste.exibeCliente("123"));
		controleTeste.removeCliente("123");
		assertTrue(controleTeste.getColecaoClientes().isEmpty());
	}

	@Test
	void testeRemoverClienteQueNaoExiste() {
		assertThrows(NullPointerException.class, () -> controleTeste.removeCliente("666"));

	}

	@Test
	void testeCadastrarFornecedor() {
		controleTeste = new Controller();
		controleTeste.cadastrarFornecedor("victor", "victor@yahoo.com", "423423");
		assertEquals("victor - victor@yahoo.com - 423423",
				controleTeste.getColecaoFornecedores().get("victor").toString());
	}

	@Test
	void testeCadastrarFornecedorIguais() {
		controleTeste = new Controller();
		controleTeste.cadastrarFornecedor("victor", "victor@yahoo.com", "423423");
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.cadastrarFornecedor("victor", "victor@yahoo.com", "423423"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.cadastrarFornecedor("victor", "victor@yahoo.com", "423423"));
	}

	@Test
	void testeCadastrarFornecedorComMesmoNome() {
		controleTeste = new Controller();
		controleTeste.cadastrarFornecedor("victor", "victor@yahoo.com", "423423");
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.cadastrarFornecedor("victor", "victor@yahoo.com", "423423"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.cadastrarFornecedor("victor", "testes@yahoo.com", "123133"));
	}

	@Test
	void testeExibeFornecedor() {
		controleTeste = new Controller();
		controleTeste.cadastrarFornecedor("victor", "victor@yahoo.com", "423423");
		assertEquals("victor - victor@yahoo.com - 423423", controleTeste.exibeFornecedor("victor"));
	}

	@Test
	void testeExibirFornecedorQuandoFornecedorNaoExiste() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeFornecedor("victor"));
	}

	@Test
	void testeExibirFornecedorQuandoNomeEhNulo() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeFornecedor(null));
	}

	@Test
	void testeExibirFornecedorQuandoNomeEhVazio() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeFornecedor("    "));
	}

	// retornando na ordem alfabetica
	@Test
	void testeExibirFornecedores() {
		controleTeste = new Controller();
		controleTeste.cadastrarFornecedor("victor", "victor@yahoo.com", "423423");
		controleTeste.cadastrarFornecedor("hugo", "hugo@yahoo.com", "4234423");
		assertEquals("hugo - hugo@yahoo.com - 4234423 | victor - victor@yahoo.com - 423423",
				controleTeste.exibirFornecedores());

	}

	@Test
	void testeExibirFornecedoresSemFornecedoresCadastrados() {
		controleTeste = new Controller();
		assertThrows(NullPointerException.class, () -> controleTeste.exibirFornecedores());
	}

	@Test
	void testeEditarFornecedorEmail() {
		controleTeste = new Controller();
		controleTeste.cadastrarFornecedor("victor", "victor@yahoo.com", "123456");
		controleTeste.editarFornecedor("victor", "email", "victorpazb@yahoo.com");
		assertEquals("victor - victorpazb@yahoo.com - 123456", controleTeste.exibeFornecedor("victor"));
	}

	@Test
	void testeEditarFornecedorNumero() {
		controleTeste = new Controller();
		controleTeste.cadastrarFornecedor("victor", "victor@yahoo.com", "123456");
		controleTeste.editarFornecedor("victor", "telefone", "987654");
		assertEquals("victor - victor@yahoo.com - 987654", controleTeste.exibeFornecedor("victor"));
	}

	@Test
	void testeEditarFornecedorComParametroNulo() {
		controleTeste = new Controller();
		controleTeste.cadastrarFornecedor("victor", "victor@paz.com", "12345");

		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.editarFornecedor(null, "email", "victorpb@yahoo.com"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.editarFornecedor("victor", null, "victorpfb@ufcg.com"));
		assertThrows(IllegalArgumentException.class, () -> controleTeste.editarFornecedor("victor", "telefone", null));

	}

	@Test
	void testeEditarFornecedorComParametroVazio() {
		controleTeste = new Controller();
		controleTeste.cadastrarFornecedor("victor", "victor@paz.com", "12345");

		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.editarFornecedor("    ", "email", "victorpb@yahoo.com"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.editarFornecedor("victor", "     ", "victorpfb@ufcg.com"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.editarFornecedor("victor", "telefone", "    "));

	}

	@Test
	void testeEditarFornecedorComNomeDoParametroInvalido() {
		controleTeste = new Controller();
		controleTeste.cadastrarFornecedor("victor", "victor@paz.com", "12345");

		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.editarFornecedor("victor", "emaiLIs", "victorpb@yahoo.com"));

		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.editarFornecedor("victor", "telefonUS", "987565"));

	}

	@Test
	void testeRemoveFornecedor() {
		controleTeste = new Controller();
		controleTeste.cadastrarFornecedor("victor", "victor@paz.com", "12345");
		assertEquals("victor - victor@paz.com - 12345", controleTeste.exibeFornecedor("victor"));
		controleTeste.removerFornecedor("victor");
		assertTrue(controleTeste.getColecaoFornecedores().isEmpty());
	}

	@Test
	void testeRemoveFornecedorQueNaoExiste() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class, () -> controleTeste.removerFornecedor("victor"));
	}

	@Test
	void testeCadastrarProduto() {
		controleTeste = new Controller();
		controleTeste.cadastrarFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.cadastrarProduto("victor", "carne", "carne de sol", "12,32");
		assertEquals("carne - carne de sol - 12,32",
				controleTeste.getColecaoFornecedores().get("victor").getListaDeProdutos().get("carne").toString());
	}

	@Test
	void testeCadastrarProdutoEmFornecedorInexistente() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.cadastrarProduto("victor", "carne", "carne de sol", "12,32"));

	}

	@Test
	void testeCadastrarProdutoEmFornecedorNulo() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.cadastrarProduto(null, "carne", "carne de sol", "12,32"));

	}

	@Test
	void testeCadastrarProdutoEmFornecedorVazio() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.cadastrarProduto("    ", "carne", "carne de sol", "12,32"));

	}

	@Test
	void testeCadastrarProdutoComAlgumParametroNulo() {
		controleTeste = new Controller();
		controleTeste.cadastrarFornecedor("victor", "victor@paz.com", "12345");
		assertThrows(NullPointerException.class,
				() -> controleTeste.cadastrarProduto("victor", null, "carne de sol", "12,32"));
		assertThrows(NullPointerException.class,
				() -> controleTeste.cadastrarProduto("victor", "carne", null, "12,32"));
		assertThrows(NullPointerException.class,
				() -> controleTeste.cadastrarProduto("victor", "carne", "carne de sol", null));

	}

	@Test
	void testeCadastrarProdutoComAlgumParametroVazio() {
		controleTeste = new Controller();
		controleTeste.cadastrarFornecedor("victor", "victor@paz.com", "12345");
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.cadastrarProduto("victor", "     ", "carne de sol", "12,32"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.cadastrarProduto("victor", "carne", "        ", "12,32"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.cadastrarProduto("victor", "carne", "carne de sol", "      "));

	}

	@Test
	void testeExibirProdutoEspecificoDeUmFornecedor() {
		controleTeste = new Controller();
		controleTeste.cadastrarFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.cadastrarProduto("victor", "carne", "carne de sol", "12,32");
		assertEquals("carne - carne de sol - 12,32",
				controleTeste.exibirProdutoEpecificoDeUmFornecedor("victor", "carne"));
	}

	@Test
	void testeExibirProdutoNaoCadastrado() {
		controleTeste = new Controller();
		controleTeste.cadastrarFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.cadastrarProduto("victor", "carne", "carne de sol", "12,32");
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.exibirProdutoEpecificoDeUmFornecedor("victor", "leite"));
	}
	
	

}
