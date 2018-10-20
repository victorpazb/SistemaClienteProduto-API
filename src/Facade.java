
public class Facade {

	
	Controller controle = new Controller();
	
	
	public void inicializa(int caixa, double taxa) {
		
	}
	
	int getCaixa() {
		return 1;
	}
	
	public int cadastrarCenario(String descricao) {
		return controle.cadastrarCenario(descricao);
		
	}
	
	public String exibirCenario(int cenario) {
		return controle.exibirCenario(cenario);
	}

	boolean encerrarCenario() {
		boolean ocorreuOuNao = false;
		return ocorreuOuNao;
	}

	public void fecharAposta(int cenario, boolean ocorreu) {

	}

	double retornarValorTotalCenárioParaCaixa() {
		// cenario encerrado que será destinado ao caixa
	}

	public int getCaixaCenario(int cenario) {

	}

	int getTotalRateioCenarioParaVencedores(int cenario) {

	}

	int getTotalRateioCenario(int cenario) {

	}

}
