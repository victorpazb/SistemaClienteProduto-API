
public class Facade {

	private Controller controle = new Controller();

	public void inicializa(int caixa, double taxa) {
		controle.inicializa(caixa, taxa);
	}

	public int getCaixa() {
		return controle.getCaixa();
	}

	public int cadastrarCenario(String descricao) {
		return controle.cadastrarCenario(descricao);

	}

	public String exibirCenario(int cenario) {
		return controle.exibirCenario(cenario);
	}

	public String exibirCenarios() {
		return controle.exibirCenarios();
	}

	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		controle.cadastrarAposta(cenario, apostador, valor, previsao);
	}

	public int valorTotalDeApostas(int cenario) {
		return controle.valorTotalDeApostas(cenario);
	}

	public int totalDeApostas(int cenario) {
		return controle.totalDeApostas(cenario);
	}

	public String exibeApostas(int cenario) {
		return controle.exibeApostas(cenario);
	}

	public void fecharAposta(int cenario, boolean ocorreu) {
		controle.fecharAposta(cenario, ocorreu);
	}

	public int getCaixaCenario(int cenario) {
		return controle.getCaixaCenario(cenario);

	}

	public int getTotalRateioCenario(int cenario) {
		return controle.getTotalRateioCenario(cenario);
	}

}
