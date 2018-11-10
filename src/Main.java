
public class Main {
	public static void main(String[] args) {
		
		Controller controleTeste = new Controller();
		controleTeste.adicionaCliente("12345678910", "victor", "victor@vic.com", "lcc3");
		controleTeste.adicionaFornecedor("seu paulo", "ourixSilva@ccc.com", "1231231232");
		controleTeste.adicionaProduto("seu paulo", "carne", "carne de sol", 12);
		controleTeste.adicionaProduto("seu paulo", "file", "file com macaxeira", 18);
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "carne", "carne de sol");
		controleTeste.adicionaCompra("12345678910", "seu paulo", "12/12/2018", "file", "file com macaxeira");
		System.out.println(controleTeste.exibeContas("12345678910", "seu paulo"));
		controleTeste.realizaPagamento("12345678910", "seu paulo");
		System.out.println(controleTeste.exibeContas("12345678910", "seu paulo"));
		
		
	}
}
