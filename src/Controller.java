import java.util.HashMap;

public class Controller {

	private Caixa novoCaixa;
	private Cenario novoCenario;
	private HashMap<Integer, Cenario> colecaoCenarios;

	public Controller() {
		colecaoCenarios = new HashMap<>();
	}

	public void inicializa(int caixa, double taxa) {
		novoCaixa = new Caixa(caixa, taxa);
	}

	public int getQuntidadeCenarios() {
		return this.colecaoCenarios.size();
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
		for (int i = 1; i <= this.colecaoCenarios.size(); i++) {
			cenarios += this.colecaoCenarios.get(i).toString() + "\n";
		}
		return cenarios;
	}

	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		if (this.colecaoCenarios.containsKey(cenario)) {
			this.colecaoCenarios.get(cenario).setApostadores(apostador, valor, previsao);
		} else {
			throw new NullPointerException("cenario nao cadastrado");
		}
	}

	public void fecharAposta(int cenario, boolean ocorreu) {

	}

	public String exibirApostasDeCenario(int cenario) {
		if(this.colecaoCenarios.get(cenario).getColecaoApostadores().isEmpty()) {
			throw new NullPointerException("nao foram feitas apostas ainda neste cenario");
		}
		String apostas = "";
		for(int i = 0; i < this.colecaoCenarios.get(cenario).getColecaoApostadores().size() ; i++) {
			apostas += this.colecaoCenarios.get(cenario).getApostadores(i) + " \n";
		}
		
		
		return apostas;

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
