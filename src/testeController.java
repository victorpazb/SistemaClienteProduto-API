import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testeController {

	Controller controleTeste;

	@Test
	void testeCadastrarCliente() {
		controleTeste = new Controller();
		assertEquals("12345678910", controleTeste.adicionaCliente("12345678910", "victor", "lcc3", "victor@paz.com"));
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
		controleTeste.adicionaCliente("12345678910", "victor", "lcc3", "victor.braga@ccc.ufcg.edu.br");
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaCliente("123", "victor", "lcc3", "victor.braga@ccc.ufcg.edu.br"));

	}

	@Test
	void testeExibirCliente() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "Victor Emanuel", "vitao@ccc.ufcg.edu.br", "Labarc");
		assertEquals("Victor Emanuel - Labarc - vitao@ccc.ufcg.edu.br", controleTeste.exibeCliente("12345678910"));
	}

	@Test
	void testeExibirClienteQueNaoExiste() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeCliente("234"));
	}

	@Test
	void testeExibirListaDeClientes() {
		controleTeste = new Controller();

		controleTeste.adicionaCliente("12345678910", "hugo", "lcc3", "hugo@paz.com");
		controleTeste.adicionaCliente("12345678911", "victor", "lcc3", "victor@paz.com");
		controleTeste.adicionaCliente("12345678912", "paulo", "lcc3", "paulo@paz.com");
		assertEquals("hugo - hugo@paz.com - lcc3 | paulo - paulo@paz.com - lcc3 | victor - victor@paz.com - lcc3",
				controleTeste.exibeClientes());
	}

	@Test
	void testeExibirListaDeClientesVazia() {
		controleTeste = new Controller();
		assertThrows(NullPointerException.class, () -> controleTeste.exibeClientes());
	}

	@Test
	void testeEditarClienteNome() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@paz.com", "lcc3");
		controleTeste.editaCliente("12345678910", "nome", "Braga");
		assertEquals("Braga - lcc3 - victor@paz.com", controleTeste.exibeCliente("12345678910"));
	}

	@Test
	void testeEditarClienteLocal() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@paz.com", "lcc3");
		controleTeste.editaCliente("12345678910", "localizacao", "spLab");
		assertEquals("victor - spLab - victor@paz.com", controleTeste.exibeCliente("12345678910"));
	}

	@Test
	void testeEditarClienteEmail() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@paz.com", "lcc3");
		controleTeste.editaCliente("12345678910", "email", "victorpfb@ufcg.com");
		assertEquals("victor - lcc3 - victorpfb@ufcg.com", controleTeste.exibeCliente("12345678910"));
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
		controleTeste.adicionaCliente("12345678910", "victor", "victor@paz.com", "lcc3");

		assertThrows(NullPointerException.class, () -> controleTeste.editaCliente(null, "localizacao", "lcc2"));
		assertThrows(NullPointerException.class,
				() -> controleTeste.editaCliente("12345678910", null, "victorpfb@ufcg.com"));
		assertThrows(NullPointerException.class, () -> controleTeste.editaCliente("12345678910", "nome", null));

	}

	@Test
	void testeEditarClienteComParametroVazio() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@paz.com", "lcc3");

		assertThrows(IllegalArgumentException.class, () -> controleTeste.editaCliente("   ", "localizacao", "lcc2"));
		assertThrows(NullPointerException.class,
				() -> controleTeste.editaCliente("12345678910", "  ", "victorpfb@ufcg.com"));
		assertThrows(NullPointerException.class, () -> controleTeste.editaCliente("12345678910", "nome", "   "));

	}

	@Test
	void testeRemoverCliente() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@paz.com", "lcc3");
		assertEquals("victor - lcc3 - victor@paz.com", controleTeste.exibeCliente("12345678910"));
		controleTeste.removeCliente("12345678910");
		assertTrue(controleTeste.getColecaoClientes().isEmpty());
	}

	@Test
	void testeRemoverClienteQueNaoExiste() {
		assertThrows(NullPointerException.class, () -> controleTeste.removeCliente("666"));

	}

	@Test
	void testeCadastrarFornecedor() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@yahoo.com", "423423");
		assertEquals("victor - victor@yahoo.com - 423423",
				controleTeste.getColecaoFornecedores().get("victor").toString());
	}

	@Test
	void testeCadastrarFornecedorIguais() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@yahoo.com", "423423");
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaFornecedor("victor", "victor@yahoo.com", "423423"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaFornecedor("victor", "victor@yahoo.com", "423423"));
	}

	@Test
	void testeCadastrarFornecedorComMesmoNome() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@yahoo.com", "423423");
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaFornecedor("victor", "victor@yahoo.com", "423423"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaFornecedor("victor", "testes@yahoo.com", "123133"));
	}

	@Test
	void testeExibeFornecedor() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@yahoo.com", "423423");
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
		controleTeste.adicionaFornecedor("victor", "victor@yahoo.com", "423423");
		controleTeste.adicionaFornecedor("hugo", "hugo@yahoo.com", "4234423");
		assertEquals("hugo - hugo@yahoo.com - 4234423 | victor - victor@yahoo.com - 423423",
				controleTeste.exibeFornecedores());

	}

	@Test
	void testeExibirFornecedoresSemFornecedoresCadastrados() {
		controleTeste = new Controller();
		assertThrows(NullPointerException.class, () -> controleTeste.exibeFornecedores());
	}

	@Test
	void testeEditarFornecedorEmail() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@yahoo.com", "123456");
		controleTeste.editaFornecedor("victor", "email", "victorpazb@yahoo.com");
		assertEquals("victor - victorpazb@yahoo.com - 123456", controleTeste.exibeFornecedor("victor"));
	}

	@Test
	void testeEditarFornecedorNumero() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@yahoo.com", "123456");
		controleTeste.editaFornecedor("victor", "telefone", "987654");
		assertEquals("victor - victor@yahoo.com - 987654", controleTeste.exibeFornecedor("victor"));
	}

	@Test
	void testeEditarFornecedorComParametroNulo() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");

		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.editaFornecedor(null, "email", "victorpb@yahoo.com"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.editaFornecedor("victor", null, "victorpfb@ufcg.com"));
		assertThrows(IllegalArgumentException.class, () -> controleTeste.editaFornecedor("victor", "telefone", null));

	}

	@Test
	void testeEditarFornecedorComParametroVazio() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");

		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.editaFornecedor("    ", "email", "victorpb@yahoo.com"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.editaFornecedor("victor", "     ", "victorpfb@ufcg.com"));
		assertThrows(IllegalArgumentException.class, () -> controleTeste.editaFornecedor("victor", "telefone", "    "));

	}

	@Test
	void testeEditarFornecedorComNomeDoParametroInvalido() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");

		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.editaFornecedor("victor", "emaiLIs", "victorpb@yahoo.com"));

		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.editaFornecedor("victor", "telefonUS", "987565"));

	}

	@Test
	void testeRemoveFornecedor() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		assertEquals("victor - victor@paz.com - 12345", controleTeste.exibeFornecedor("victor"));
		controleTeste.removeFornecedor("victor");
		assertTrue(controleTeste.getColecaoFornecedores().isEmpty());
	}

	@Test
	void testeRemoveFornecedorQueNaoExiste() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class, () -> controleTeste.removeFornecedor("victor"));
	}

	@Test
	void testeCadastrarProduto() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12.32);
		assertEquals("carne - carne de sol - R$12,32", controleTeste.getColecaoFornecedores().get("victor")
				.getListaDeProdutos().get("carne - carne de sol").toString());
	}

	@Test
	void testeCadastrarProdutoEmFornecedorInexistente() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12.32));

	}

	@Test
	void testeCadastrarProdutoEmFornecedorNulo() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaProduto(null, "carne", "carne de sol", 12.43));

	}

	@Test
	void testeCadastrarProdutoEmFornecedorVazio() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaProduto("    ", "carne", "carne de sol", 12.32));

	}

	@Test
	void testeCadastrarProdutoComAlgumParametroNulo() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		assertThrows(NullPointerException.class,
				() -> controleTeste.adicionaProduto("victor", null, "carne de sol", 12.32));
		assertThrows(NullPointerException.class, () -> controleTeste.adicionaProduto("victor", "carne", null, 12.32));

	}

	@Test
	void testeCadastrarProdutoComAlgumParametroVazioOuInvalido() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "99931-2231");
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaProduto("  ", "carne", "carne de sol", 12.44));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaProduto("victor", "     ", "carne de sol", 12.44));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaProduto("victor", "carne", "        ", 12.44));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaProduto("victor", "carne", "carne de sol", -2));

	}

	@Test
	void testeExibeProduto() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12.32);
		assertEquals("carne - carne de sol - R$12,32", controleTeste.exibeProduto("carne", "carne de sol", "victor"));
	}

	@Test
	void testeEditaProduto() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12.32);
		controleTeste.editaProduto("carne", "carne de sol", "victor", 15);
		assertEquals("carne - carne de sol - R$15,00", controleTeste.exibeProduto("carne", "carne de sol", "victor"));
	}

	@Test
	void testeEditaProdutoPassandoFornecedorVazioOuNulo() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12.32);
		controleTeste.editaProduto("carne", "carne de sol", "victor", 15);
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeProduto("carne", "carne de sol", "  "));
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeProduto("carne", "carne de sol", null));
	}

	@Test
	void testeEditaProdutoPassandoNomeVazioOuNulo() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12.32);
		controleTeste.editaProduto("carne", "carne de sol", "victor", 15);
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.exibeProduto("victor", "carne de sol", "victor"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.exibeProduto("victor", "carne de sol", "victor"));
	}

	@Test
	void testeEditaProdutoPassandoDescricaoVaziaOuNula() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12.32);
		controleTeste.editaProduto("carne", "carne de sol", "victor", 15);
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeProduto("victor", "  ", "victor"));
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeProduto("victor", null, "victor"));
	}

	@Test
	void testeExibirProdutoNaoCadastrado() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12.32);
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.exibeProduto("victor", "leite", "leite desnatado"));
	}

	@Test
	void testeRemoveProduto() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12.32);
		assertFalse(controleTeste.getColecaoFornecedores().get("victor").getListaDeProdutos().isEmpty());
		controleTeste.removeProduto("carne", "carne de sol", "victor");
		assertTrue(controleTeste.getColecaoFornecedores().get("victor").getListaDeProdutos().isEmpty());
	}

	@Test
	void testeAdicionaCombo() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12.32);
		controleTeste.adicionaProduto("victor", "suco", "suco de laranja", 2);
		assertEquals("carne + suco", controleTeste.adicionaCombo("victor", "carne + suco", "carne de sol com suco", 0.5,
				"carne - carne de sol, suco - suco de laranja"));

	}

	@Test
	void testeAdicionaComboFornecedorNuloOuVazio() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12.32);
		controleTeste.adicionaProduto("victor", "suco", "suco de laranja", 2);
		assertThrows(IllegalArgumentException.class, () -> controleTeste.adicionaCombo("  ", "carne + suco",
				"carne de sol com suco", 0.5, "carne - carne de sol, suco - suco de laranja"));
	}

	@Test
	void testeAdicionaComboNomeComboNuloOuVazio() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12.32);
		assertThrows(IllegalArgumentException.class, () -> controleTeste.adicionaCombo("victor", "   ",
				"carne de sol com suco", 0.5, "carne - carne de sol, suco - suco de laranja"));
	}

	@Test
	void testeAdicionaComboDescricaoComboNulaOuVazia() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12.32);
		assertThrows(IllegalArgumentException.class, () -> controleTeste.adicionaCombo("victor", "carne + suco", "    ",
				0.5, "carne - carne de sol, suco - suco de laranja"));
	}

	@Test
	void testeExibeCombo() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("victor", "suco", "suco de laranja", 2);
		controleTeste.adicionaCombo("victor", "carne + suco", "carne de sol com suco", 0.5,
				"carne - carne de sol, suco - suco de laranja");
		assertEquals("carne + suco - carne de sol com suco - R$7,00",
				controleTeste.exibeProduto("carne + suco", "carne de sol com suco", "victor"));

	}

	@Test
	void testeExibeComboNomeComboVazioOuNulo() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("victor", "suco", "suco de laranja", 2);
		controleTeste.adicionaCombo("victor", "carne + suco", "carne de sol com suco", 0.5,
				"carne - carne de sol, suco - suco de laranja");
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.exibeProduto("  ", "carne de sol com suco", "victor"));

	}

	@Test
	void testeExibeComboDescricaoComboVaziaOuNula() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("victor", "suco", "suco de laranja", 2);
		controleTeste.adicionaCombo("victor", "carne + suco", "carne de sol com suco", 0.5,
				"carne - carne de sol, suco - suco de laranja");
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.exibeProduto("carne + suco", "    ", "victor"));

	}

	@Test
	void testeExibeComboFornecedorVazioOuNulo() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("victor", "suco", "suco de laranja", 2);
		controleTeste.adicionaCombo("victor", "carne + suco", "carne de sol com suco", 0.5,
				"carne - carne de sol, suco - suco de laranja");
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.exibeProduto("carne + suco", "carne de sol com suco", "    "));

	}

	@Test
	void testeExibeComboFornecedorNaoExiste() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("victor", "suco", "suco de laranja", 2);
		controleTeste.adicionaCombo("victor", "carne + suco", "carne de sol com suco", 0.5,
				"carne - carne de sol, suco - suco de laranja");
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.exibeProduto("carne + suco", "carne de sol com suco", "hugo"));

	}

	@Test
	void testeExibeComboComboNaoCadastrado() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("victor", "suco", "suco de laranja", 2);
		controleTeste.adicionaCombo("victor", "carne + suco", "carne de sol com suco", 0.5,
				"carne - carne de sol, suco - suco de laranja");
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.exibeProduto("bolo + refri", "bolo de chocolate e coca", "victor"));

	}

	@Test
	void testeEditaCombo() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("victor", "suco", "suco de laranja", 2);
		controleTeste.adicionaCombo("victor", "carne + suco", "carne de sol com suco", 0.5,
				"carne - carne de sol, suco - suco de laranja");
		assertEquals("carne + suco - carne de sol com suco - R$7,00",
				controleTeste.exibeProduto("carne + suco", "carne de sol com suco", "victor"));
		controleTeste.editaCombo("carne + suco", "carne de sol com suco", "victor", 0.3);
		assertEquals("carne + suco - carne de sol com suco - R$9,80",
				controleTeste.exibeProduto("carne + suco", "carne de sol com suco", "victor"));

	}

	@Test
	void testeEditaComboPassandoNomeComboVazioOuNulo() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("victor", "suco", "suco de laranja", 2);
		controleTeste.adicionaCombo("victor", "carne + suco", "carne de sol com suco", 0.5,
				"carne - carne de sol, suco - suco de laranja");
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.exibeProduto("  ", "carne de sol com suco", "victor"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.exibeProduto(null, "carne de sol com suco", "victor"));

	}

	@Test
	void testeEditaComboPassandoDescricaoVaziaOuNula() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("victor", "suco", "suco de laranja", 2);
		controleTeste.adicionaCombo("victor", "carne + suco", "carne de sol com suco", 0.5,
				"carne - carne de sol, suco - suco de laranja");
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.exibeProduto("carne + suco", "     ", "victor"));
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeProduto("carne + suco", null, "victor"));

	}

	@Test
	void testeEditaComboPassandoFornecedorVazioOuNulo() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("victor", "suco", "suco de laranja", 2);
		controleTeste.adicionaCombo("victor", "carne + suco", "carne de sol com suco", 0.5,
				"carne - carne de sol, suco - suco de laranja");
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.exibeProduto("carne + suco", "carne de sol com suco", "  "));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.exibeProduto("carne + suco", "carne de sol com suco", null));

	}

	@Test
	void testeExibeProdutosFornecedor() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("victor", "suco", "suco de laranja", 2);
		assertEquals("victor - carne - carne de sol - R$12,00 | victor - suco - suco de laranja - R$2,00",
				controleTeste.exibeProdutosFornecedor("victor"));

	}

	@Test
	void testeExibeProdutosFornecedorFornecedorNuloOuVazio() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("victor", "suco", "suco de laranja", 2);
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeProdutosFornecedor("    "));
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeProdutosFornecedor(null));

	}

	@Test
	void testeExibeProdutosFornecedorQueNaoExiste() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("victor", "suco", "suco de laranja", 2);
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeProdutosFornecedor("hugo"));

	}

	@Test
	void testeExibeProdutosFornecedorComListaDeProdutosVazia() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		assertThrows(NullPointerException.class, () -> controleTeste.exibeProdutosFornecedor("victor"));

	}

	@Test
	void testeExibeProdutos() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("hugo", "hugo@paz.com", "12346789");
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		controleTeste.adicionaProduto("victor", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("victor", "suco", "suco de laranja", 2);
		controleTeste.adicionaProduto("hugo", "carne", "carne moida", 6);
		controleTeste.adicionaProduto("hugo", "refri", "coca", 3);
		assertEquals(
				"hugo - carne - carne moida - R$6,00 | hugo - refri - coca - R$3,00 | victor - carne - carne de sol - R$12,00 | victor - suco - suco de laranja - R$2,00",
				controleTeste.exibeProdutos());

	}

	@Test
	void testeExibeProdutosSemProdutosParaMostrar() {
		controleTeste = new Controller();
		controleTeste.adicionaFornecedor("hugo", "hugo@paz.com", "12346789");
		controleTeste.adicionaFornecedor("victor", "victor@paz.com", "12345");
		assertThrows(NullPointerException.class, () -> controleTeste.exibeProdutos());

	}

	@Test
	void testeExibeProdutosSemFornecedoresCadastrados() {
		controleTeste = new Controller();
		assertThrows(NullPointerException.class, () -> controleTeste.exibeProdutos());

	}

	@Test
	void testeAdicionaCompra() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "carne", "carne de sol");
		assertEquals("Cliente: victor | seu paulo | carne - 12-12-2018",
				controleTeste.exibeContas("12345678910", "seu paulo"));
	}

	@Test
	void testeAdicionaCompraCpfInvalido() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaCompra("12345", "seu paulo", "12/12/2018", "carne", "carne de sol"));
	}

	@Test
	void testeAdicionaCompraFornecedorNuloOuVazio() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaCompra("12345", "   ", "12/12/2018", "carne", "carne de sol"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaCompra("12345", null, "12/12/2018", "carne", "carne de sol"));
	}

	@Test
	void testeAdicionaCompraDataNulaOuVazia() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaCompra("12345", "seu paulo", "    ", "carne", "carne de sol"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaCompra("12345", "seu paulo", null, "carne", "carne de sol"));
	}

	@Test
	void testeAdicionaCompraDataInvalida() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaCompra("12345", "seu paulo", "12/120/2018", "carne", "carne de sol"));

	}

	@Test
	void testeAdicionaCompraNomeProdutoVazioOuNulo() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaCompra("12345", "seu paulo", "12/12/2018", "   ", "carne de sol"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaCompra("12345", "seu paulo", "12/12/2018", null, "carne de sol"));
	}

	@Test
	void testeAdicionaCompraDescricaoProdutoVazioOuNulo() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "carne", "  "));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "carne", null));
	}

	@Test
	void testeGetDebito() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("seu paulo", "file", "file com macaxeira", 18);
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "carne", "carne de sol");
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "file", "file com macaxeira");
		assertEquals("30.00", controleTeste.getDebito("12345678910", "seu paulo"));

	}

	@Test
	void testeGetDebitoCpfInvalido() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("seu paulo", "file", "file com macaxeira", 18);
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "carne", "carne de sol");
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "file", "file com macaxeira");
		assertThrows(IllegalArgumentException.class, () -> controleTeste.getDebito("1235", "seu paulo"));
	}

	@Test
	void testeGetDebitoClienteNaoExiste() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("seu paulo", "file", "file com macaxeira", 18);
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "carne", "carne de sol");
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "file", "file com macaxeira");
		assertThrows(IllegalArgumentException.class, () -> controleTeste.getDebito("12345678911", "seu paulo"));
	}

	@Test
	void testeGetDebitoFornecedorNaoExiste() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("seu paulo", "file", "file com macaxeira", 18);
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "carne", "carne de sol");
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "file", "file com macaxeira");
		assertThrows(IllegalArgumentException.class, () -> controleTeste.getDebito("12345678911", "Seu Olavo"));
	}

	@Test
	void testeExibeContas() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("seu paulo", "file", "file com macaxeira", 18);
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "carne", "carne de sol");
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "file", "file com macaxeira");
		assertEquals("Cliente: victor | seu paulo | carne - 12-12-2018 | file - 12-12-2018",
				controleTeste.exibeContas("12345678910", "seu paulo"));

	}

	@Test
	void testeExibeContasCpfInvalido() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("seu paulo", "file", "file com macaxeira", 18);
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "carne", "carne de sol");
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "file", "file com macaxeira");
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeContas("123410", "seu paulo"));

	}

	@Test
	void testeExibeContasClienteNaoExiste() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("seu paulo", "file", "file com macaxeira", 18);
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "carne", "carne de sol");
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "file", "file com macaxeira");
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeContas("12345678911", "seu paulo"));

	}

	@Test
	void testeExibeContasFornecedorVazioOuNulo() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("seu paulo", "file", "file com macaxeira", 18);
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "carne", "carne de sol");
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "file", "file com macaxeira");
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeContas("12345678911", "  "));
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeContas("12345678911", null));

	}

	@Test
	void testeExibeContasFornecedorNaoExiste() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("seu paulo", "file", "file com macaxeira", 18);
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "carne", "carne de sol");
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "file", "file com macaxeira");
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeContas("12345678911", "Seu Olavo"));

	}

	@Test
	void testeExibeContasClienteNaoFezCompras() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("seu paulo", "file", "file com macaxeira", 18);
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeContas("12345678911", "seu paulo"));

	}

	@Test
	void testeExibeContasClientes() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaFornecedor("seu olavo", "olavo@ufcg.com", "1234331232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("seu paulo", "file", "file com macaxeira", 18);
		controleTeste.adicionaProduto("seu olavo", "batata", "batata frita", 5);
		controleTeste.adicionaProduto("seu olavo", "suco", "suco de laranja", 2);
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "carne", "carne de sol");
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "file", "file com macaxeira");
		controleTeste.adicionaCompra("12345678910", "seu olavo", "12/12/2018", "suco", "suco de laranja");
		controleTeste.adicionaCompra("12345678910", "seu olavo", "12/12/2018", "batata", "batata frita");
		assertEquals(
				"Cliente: victor | seu olavo | suco - 12-12-2018 | batata - 12-12-2018 | seu paulo | carne - 12-12-2018 | file - 12-12-2018",
				controleTeste.exibeContasClientes("12345678910"));
	}

	@Test
	void testeExibeContasClientesCpfInvalido() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeContasClientes("123456789"));
	}

	@Test
	void testeExibeContasClientesClienteNaoExiste() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeContasClientes("12345678910"));
	}

	@Test
	void testeExibeContasClientesClienteNaoTemCompras() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibeContasClientes("12345678910"));
	}

	@Test
	void testeRealizaPagamento() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("seu paulo", "file", "file com macaxeira", 18);
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "carne", "carne de sol");
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "file", "file com macaxeira");
		assertEquals("30.00", controleTeste.getDebito("12345678910", "seu paulo"));
		controleTeste.realizaPagamento("12345678910", "seu paulo");
		assertThrows(IllegalArgumentException.class, () -> controleTeste.getDebito("12345678910", "seu paulo"));
	}

	@Test
	void testeRealizaPagamentoCpfInvalido() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class, () -> controleTeste.realizaPagamento("123410", "seu paulo"));
	}

	@Test
	void testeRealizaPagamentoCpfNuloOuVazio() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class, () -> controleTeste.realizaPagamento("   ", "seu paulo"));
		assertThrows(IllegalArgumentException.class, () -> controleTeste.realizaPagamento(null, "seu paulo"));
	}

	@Test
	void testeRealizaPagamentoFornecedorNuloOuVazio() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class, () -> controleTeste.realizaPagamento("12345678910", "     "));
		assertThrows(IllegalArgumentException.class, () -> controleTeste.realizaPagamento("12345678910", null));
	}
	
	@Test
	void testeRealizaPagamentoClienteNaoExiste() {
		controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class, () -> controleTeste.realizaPagamento("12345678911", "seu paulo"));
	}
	
	@Test
	void testeRealizaPagamentoFornecedorNaoExiste() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		assertThrows(IllegalArgumentException.class, () -> controleTeste.realizaPagamento("12345678910", "seu paulo"));
	}
	
	@Test
	void testeRealizaPagamentoMasNaoTemDebito() {
		controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		assertThrows(IllegalArgumentException.class, () -> controleTeste.realizaPagamento("12345678910", "seu paulo"));
	}
	

}
