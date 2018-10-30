import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testeController {

	@Test
	void testeCadastrarCliente() {
		Controller controleTeste = new Controller();
		assertTrue(controleTeste.cadastrarCliente("123", "victor", "lcc3", "victor@paz.com"));
	}

	@Test
	void testeCadastrarClienteComAlgumParametroNulo() {
		Controller controleTeste = new Controller();
		assertThrows(NullPointerException.class,
				() -> controleTeste.cadastrarCliente(null, "victor", "lcc3", "victor@ufcg.br"));
		assertThrows(NullPointerException.class,
				() -> controleTeste.cadastrarCliente("123", null, "lcc3", "victor@ufcg.br"));
		assertThrows(NullPointerException.class,
				() -> controleTeste.cadastrarCliente("123", "victor", null, "victor@ufcg.br"));
		assertThrows(NullPointerException.class, () -> controleTeste.cadastrarCliente("123", "victor", "lcc3", null));
	}

	@Test
	void testeCadastrarClienteComAlgumParametroVazio() {
		Controller controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.cadastrarCliente("    ", "victor", "lcc3", "victor@ufcg.br"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.cadastrarCliente("123", "    ", "lcc3", "victor@ufcg.br"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.cadastrarCliente("123", "victor", "    ", "victor@ufcg.br"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.cadastrarCliente("123", "victor", "lcc3", "    "));
	}

	@Test
	void testeCadastrarClienteJaCadastrado() {
		Controller controleTeste = new Controller();
		controleTeste.cadastrarCliente("123", "victor", "lcc3", "victor.braga@ccc.ufcg.edu.br");
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.cadastrarCliente("123", "victor", "lcc3", "victor.braga@ccc.ufcg.edu.br"));

	}

	@Test
	void testeExibirCliente() {
		Controller controleTeste = new Controller();
		controleTeste.cadastrarCliente("123", "victor", "lcc3", "victor.braga@ccc.ufcg.edu.br");
		assertEquals("victor - lcc3 - victor.braga@ccc.ufcg.edu.br", controleTeste.exibirCliente("123"));
	}

	@Test
	void testeExibirClienteQueNaoExiste() {
		Controller controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class, () -> controleTeste.exibirCliente("234"));
	}

	@Test
	void testeExibirListaDeClientes() {
		Controller controleTeste = new Controller();

		controleTeste.cadastrarCliente("324", "hugo", "lcc3", "hugo@paz.com");
		controleTeste.cadastrarCliente("123", "victor", "lcc3", "victor@paz.com");
		controleTeste.cadastrarCliente("345", "paulo", "lcc3", "paulo@paz.com");
		assertEquals("hugo - lcc3 - hugo@paz.com | paulo - lcc3 - paulo@paz.com | victor - lcc3 - victor@paz.com",
				controleTeste.exibeListaDeClientes());
	}

	@Test
	void testeExibirListaDeClientesVazia() {
		Controller controleTeste = new Controller();
		assertThrows(NullPointerException.class, () -> controleTeste.exibeListaDeClientes());
	}

	@Test
	void testeEditarClienteNome() {
		Controller controleTeste = new Controller();
		controleTeste.cadastrarCliente("123", "victor", "lcc3", "victor@paz.com");
		controleTeste.editarCliente("123", "nome", "braga");
		assertEquals("braga - lcc3 - victor@paz.com", controleTeste.exibirCliente("123"));
	}

	@Test
	void testeEditarClienteLocal() {
		Controller controleTeste = new Controller();
		controleTeste.cadastrarCliente("123", "victor", "lcc3", "victor@paz.com");
		controleTeste.editarCliente("123", "local", "spLab");
		assertEquals("victor - spLab - victor@paz.com", controleTeste.exibirCliente("123"));
	}

	@Test
	void testeEditarClienteEmail() {
		Controller controleTeste = new Controller();
		controleTeste.cadastrarCliente("123", "victor", "lcc3", "victor@paz.com");
		controleTeste.editarCliente("123", "email", "victorpfb@ufcg.com");
		assertEquals("victor - lcc3 - victorpfb@ufcg.com", controleTeste.exibirCliente("123"));
	}

	@Test
	void testeEditarClienteNaoCadastrado() {
		Controller controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.editarCliente("123", "email", "victorpfb@ufcg.com"));
	}
	
	@Test
	void testeEditarClienteComParametroNulo() {
		Controller controleTeste = new Controller();
		controleTeste.cadastrarCliente("123", "victor", "lcc3", "victor@paz.com");
		
		assertThrows(NullPointerException.class,
				() -> controleTeste.editarCliente(null,"local", "lcc2"));
		assertThrows(NullPointerException.class,
				() -> controleTeste.editarCliente("123", null, "victorpfb@ufcg.com"));
		assertThrows(NullPointerException.class,
				() -> controleTeste.editarCliente("123", "nome", null));
		
	}
	
	@Test
	void testeEditarClienteComParametroVazio() {
		Controller controleTeste = new Controller();
		controleTeste.cadastrarCliente("123", "victor", "lcc3", "victor@paz.com");
		
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.editarCliente("   ","local", "lcc2"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.editarCliente("123", "  ", "victorpfb@ufcg.com"));
		assertThrows(IllegalArgumentException.class,
				() -> controleTeste.editarCliente("123", "nome", "   "));
		
	}
}
