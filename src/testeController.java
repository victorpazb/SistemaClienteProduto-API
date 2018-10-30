import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testeController {

	@Test 
	void testeCadastrarCliente() {
		Facade facadeTeste = new Facade();
		facadeTeste.cadastrarCliente("123", "victor", "lcc3", "victor@paz.com");
		assertTrue(true);
	}
	
	
	
	
	@Test
	void testeCadastrarClienteComAlgumParametroNulo() {
		Facade facadeTeste = new Facade();
		assertThrows(NullPointerException.class, ()-> facadeTeste.cadastrarCliente( null, "victor", "lcc3", "victor@ufcg.br"));
		assertThrows(NullPointerException.class, ()-> facadeTeste.cadastrarCliente("123", null, "lcc3", "victor@ufcg.br"));
		assertThrows(NullPointerException.class, ()-> facadeTeste.cadastrarCliente("123", "victor", null, "victor@ufcg.br"));
		assertThrows(NullPointerException.class, ()-> facadeTeste.cadastrarCliente( "123", "victor", "lcc3", null));
	}
	
	@Test
	void testeCadastrarClienteComAlgumParametroVazio() {
		Facade facadeTeste = new Facade();
		assertThrows(IllegalArgumentException.class, ()-> facadeTeste.cadastrarCliente( "    ", "victor", "lcc3", "victor@ufcg.br"));
		assertThrows(IllegalArgumentException.class, ()-> facadeTeste.cadastrarCliente("123", "    ", "lcc3", "victor@ufcg.br"));
		assertThrows(IllegalArgumentException.class, ()-> facadeTeste.cadastrarCliente("123", "victor", "    ", "victor@ufcg.br"));
		assertThrows(IllegalArgumentException.class, ()-> facadeTeste.cadastrarCliente( "123", "victor", "lcc3", "    "));
	}
	
	
	@Test
	void testeCadastrarClienteJaCadastrado() {
		Facade facadeTeste = new Facade();
		facadeTeste.cadastrarCliente("123", "victor", "lcc3", "victor.braga@ccc.ufcg.edu.br");
		assertThrows(IllegalArgumentException.class,()->  facadeTeste.cadastrarCliente("123", "victor", "lcc3", "victor.braga@ccc.ufcg.edu.br"));
		
	}

}
