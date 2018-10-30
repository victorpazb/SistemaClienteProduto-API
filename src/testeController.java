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
	
	@Test void testeExibirCliente() {
		Controller controleTeste = new Controller();
		controleTeste.cadastrarCliente("123", "victor", "lcc3", "victor.braga@ccc.ufcg.edu.br");
		assertEquals("victor - lcc3 - victor.braga@ccc.ufcg.edu.br", controleTeste.exibirCliente("123"));
	}
	
	@Test void testeExibirClienteQueNaoExiste() {
		Controller controleTeste = new Controller();
		assertThrows(IllegalArgumentException.class, ()-> controleTeste.exibirCliente("234"));
	}
	
	
	

}
