
public class Main {
	public static void main(String[] args) {
		
		Controller controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "Victor Paz", "victor@vic.com", "lcc3");
		controleTeste.adicionaCliente("12345678911", "Hugo Braga", "hugo@paz.com", "lcc3");

		controleTeste.adicionaFornecedor("Seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaFornecedor("Ana boleira", "ana@ccc.com", "1231231232");
		controleTeste.adicionaProduto("Seu paulo", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("Seu paulo", "file", "file com macaxeira", 18);
		controleTeste.adicionaProduto("Ana boleira", "carne", "carne moida", 6);
		controleTeste.adicionaProduto("Ana boleira", "bolo", "bolo de chocolate", 6);
		controleTeste.adicionaProduto("Ana boleira", "sorvete", "sorvete de chocolate", 4);
		controleTeste.adicionaCompra("12345678910", "Seu paulo", "12/12/2018", "carne", "carne de sol");
		controleTeste.adicionaCompra("12345678910", "Seu paulo", "12/12/2018", "file", "file com macaxeira");
		controleTeste.adicionaCompra("12345678910", "Ana boleira", "12/12/2018", "bolo", "bolo de chocolate");
		controleTeste.adicionaCompra("12345678911", "Seu paulo", "12/12/2018", "carne", "carne de sol");
		controleTeste.adicionaCompra("12345678911", "Ana boleira", "12/12/2018", "bolo", "bolo de chocolate");
		controleTeste.adicionaCompra("12345678911", "Ana boleira", "12/12/2018", "sorvete", "sorvete de chocolate");

		System.out.println(controleTeste.listarCompras());
		
		
	}
}
