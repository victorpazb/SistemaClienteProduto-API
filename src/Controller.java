import java.util.HashMap;

public class Controller {
	
	Caixa novoCaixa;
	Cenario novoCenario;
    HashMap<String, Cenario> colecaoCenarios;
	
	public Controller() {
		colecaoCenarios = new HashMap<>();
	}
	
	public void inicializa(int caixa, double taxa) {
		novoCaixa = new Caixa(caixa, taxa);
	}

	public int getCaixa() {
		return novoCaixa.getCaixa();
	}
	
	public int cadastrarCenario(String descricao) {
		novoCenario = new Cenario(descricao);
		this.colecaoCenarios.put(descricao, novoCenario);
		return this.colecaoCenarios.get(descricao).getId();
	}

	boolean encerrarCenario(String ocorreuOunao) {
		
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
