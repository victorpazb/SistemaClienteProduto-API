
public class Main {

	public static void main(String[] args) {

		Controller controle = new Controller();
		controle = new Controller();
		controle.cadastrarFornecedor("victor", "victor@paz.com", "12345");
		System.out.println(controle.exibeFornecedor("victor"));
		controle.removerFornecedor("victor");
		System.out.println(controle.colecaoFornecedores.isEmpty());
		
		
		
		
		
	}

}
