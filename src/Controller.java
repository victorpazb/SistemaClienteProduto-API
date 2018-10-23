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
		return this.colecaoCenarios.get(cenario).getColecaoApostadores().size();
	}

	public int getQuntidadeCenarios() {
		return this.colecaoCenarios.size();
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
			this.colecaoCenarios.get(cenario).setApostadores(apostador, valor, previsao.toUpperCase());
		} else {
			throw new NullPointerException("cenario nao cadastrado");
		}
	}

	public void fecharAposta(int cenario, boolean ocorreu) {
		int valorTotalDosPerdedores = 0;
		String resultado = "";
		if (ocorreu == false) {
			resultado = "NAO VAI ACONTECER";

		} else if (ocorreu == true) {
			resultado = "VAI ACONTECER";
		}

		int quantidadeApostasNoCenario = this.colecaoCenarios.get(cenario).getColecaoApostadores().size();
		for (int i = 0; i < quantidadeApostasNoCenario; i++) {
			if (!this.colecaoCenarios.get(cenario).getApostadores(i).getPrevisao().equals(resultado)) {
				valorTotalDosPerdedores += this.colecaoCenarios.get(cenario).getApostadores(i).getValorAposta();
			}

		}

		this.colecaoCenarios.get(cenario).setValorTotalDosPerdedores(valorTotalDosPerdedores);

	}

	public String exibirApostasDeCenario(int cenario) {
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
		return (int) (this.colecaoCenarios.get(cenario).getValorTotalDosPerdedores() * this.novoCaixa.getTaxa());

	}

	public int getTotalRateioCenario(int cenario) {
		return valorTotalDeApostas(cenario) - this.colecaoCenarios.get(cenario).getValorTotalDosPerdedores();

	}


}