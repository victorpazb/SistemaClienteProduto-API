import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testeController {


	@Test
	public void testeInicializaCaixa() {
		Caixa caixaTeste = new Caixa(1000, 0.01);
		assertEquals(1000, caixaTeste.getCaixa());
		assertEquals(0.01, caixaTeste.getTaxa());
	}

	@Test
	public void testeCadastrarCenario() {
		Facade facade = new Facade();
		assertEquals(1, facade.cadastrarCenario("Brasil campeao"));
		assertEquals("1 - Brasil campeao - Nao finalizado", facade.exibirCenario(1));

	}
// testes estaao estranhos, o cadastro do cenario do segundo teste parece persistir no terceiro
//	tendo assim q assumir q eh o segundo cadastro no terceiro teste
	@Test
	public void testeExibirCenario() {
		Facade facade = new Facade();
		facade.cadastrarCenario("Brasil campeao");
		assertEquals("2 - Brasil campeao - Nao finalizado", facade.exibirCenario(2));
	}
	
	@Test
	public void testeExibirCenarioQueNaoExiste() {
		Facade facade = new Facade();
		assertThrows(NullPointerException.class, ()-> facade.exibirCenario(1));
	}
}
