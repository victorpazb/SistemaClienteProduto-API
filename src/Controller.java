import java.util.HashMap;

public class Controller {

	Caixa novoCaixa;
	Cenario novoCenario;
	HashMap<Integer, Cenario> colecaoCenarios;

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
		this.colecaoCenarios.put(novoCenario.getId(), novoCenario);
		return this.novoCenario.getId();
	}

	public String exibirCenario(int cenario) {
		return this.colecaoCenarios.get(cenario).toString();

	}
	
	public String exibirCenarios() {
		String cenarios = "";
		for (int i = 0; i < this.colecaoCenarios.size(); i++) {
			cenarios += this.colecaoCenarios.get(i).toString() + "\n"; 
		}
		return cenarios;
	}

	//public boolean encerrarCenario(String ocorreuOunao) {

		//return ocorreuOuNao;
	//}
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		if(this.colecaoCenarios.containsKey(cenario)) {
			this.colecaoCenarios.get(cenario).setApostadores(apostador, valor, previsao);
		}
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
