
public class Main {

	public static void main(String[] args) {

		Controller controle = new Controller();
		controle = new Controller();
		controle.cadastrarFornecedor("victor", "victor@paz.com", "12345");
		controle.cadastrarProduto("victor", "carne", "carne de sol", "23");
		System.out.println(controle.exibirProdutoEpecificoDeUmFornecedor("victor", "leite"));
		
		
		
		
		
		
	}

}
