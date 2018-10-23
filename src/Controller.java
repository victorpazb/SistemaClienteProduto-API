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

	public int getCaixa() {
		return novoCaixa.getCaixa();
	}

	public int cadastrarCenario(String descricao) {
		novoCenario = new Cenario(descricao);
		this.colecaoCenarios.put(novoCenario.getId(), novoCenario);
		return this.novoCenario.getId();
	}

	public String exibirCenario(int cenario) {
		if (!this.colecaoCenarios.containsKey(cenario)) {
			throw new NullPointerException("cenario nao cadastrado");
		}
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
			this.colecaoCenarios.get(cenario).setApostadores(apostador, valor, previsao.toUpperCase());
		} else {
			throw new NullPointerException("cenario nao cadastrado");
		}
	}

	public int valorTotalDeApostas(int cenario) {

		if (this.colecaoCenarios.get(cenario).getColecaoApostadores().isEmpty()) {
			throw new NullPointerException("nao foram feitas apostas ainda neste cenario");
		}

		int valorTotalApostas = 0;
		int quantidadeApostas = this.colecaoCenarios.get(cenario).getColecaoApostadores().size();

		for (int i = 0; i < quantidadeApostas; i++) {
			valorTotalApostas += this.colecaoCenarios.get(cenario).getApostadores(i).getValorAposta();
		}

		return valorTotalApostas;
	}

	public int totalDeApostas(int cenario) {
		if (!this.colecaoCenarios.containsKey(cenario)) {
			throw new NullPointerException("cenario nao cadastrado");
		}
		return this.colecaoCenarios.get(cenario).getColecaoApostadores().size();
	}

	public void fecharAposta(int cenario, boolean ocorreu) {

		if (!this.colecaoCenarios.containsKey(cenario)) {
			throw new NullPointerException("cenario nao cadastrado");
		}

		int valorTotalRateio = 0;
		String ocorreuOuNao = "";
		String resultado = "";

		if (ocorreu == false) {
			resultado = "N VAI ACONTECER";
			ocorreuOuNao = "n ocorreu";

		} else if (ocorreu == true) {
			resultado = "VAI ACONTECER";
			ocorreuOuNao = "ocorreu";

		}

		int quantidadeApostasNoCenario = this.colecaoCenarios.get(cenario).getColecaoApostadores().size();
		for (int i = 0; i < quantidadeApostasNoCenario; i++) {
			if (!this.colecaoCenarios.get(cenario).getApostadores(i).getPrevisao().equals(resultado)) {
				valorTotalRateio += this.colecaoCenarios.get(cenario).getApostadores(i).getValorAposta();
			}

		}

		this.colecaoCenarios.get(cenario).setValorTotalRateio(valorTotalRateio);
		this.novoCaixa
				.setTaxa((int) (this.colecaoCenarios.get(cenario).getValorTotalRateio() * this.novoCaixa.getTaxa()));
		this.colecaoCenarios.get(cenario).setFinalizado("Finalizado");
		this.colecaoCenarios.get(cenario).setAconteceu(ocorreuOuNao);

	}

	public String exibeApostas(int cenario) {
		if (!this.colecaoCenarios.containsKey(cenario)) {
			throw new NullPointerException("cenario nao cadastrado");
		}

		if (this.colecaoCenarios.get(cenario).getColecaoApostadores().isEmpty()) {
			throw new NullPointerException("nao foram feitas apostas ainda neste cenario");
		}
		String apostas = "";
		for (int i = 0; i < this.colecaoCenarios.get(cenario).getColecaoApostadores().size(); i++) {
			apostas += this.colecaoCenarios.get(cenario).getApostadores(i) + " \n";
		}

		return apostas;

	}

	public int getCaixaCenario(int cenario) {
		if (!this.colecaoCenarios.containsKey(cenario)) {
			throw new NullPointerException("cenario nao cadastrado");
		}
		return (int) (this.colecaoCenarios.get(cenario).getValorTotalRateio() * this.novoCaixa.getTaxa());

	}

	public int getTotalRateioCenario(int cenario) {
		if (!this.colecaoCenarios.containsKey(cenario)) {
			throw new NullPointerException("cenario nao cadastrado");
		}
		return this.colecaoCenarios.get(cenario).getValorTotalRateio() - getCaixaCenario(cenario);

	}

}