
public class Main {

	public static void main(String[] args) {

		Controller controle = new Controller();
		controle.cadastrarFornecedor("victor", "victor@yahoo.com", "423423");
		controle.cadastrarFornecedor("hugo", "hugo@yahoo.com", "4234423");
		
		//facade.cadastrarProduto("victor", "papel", "higienico", "234");
		//facade.cadastrarProduto("victor", "desodorante", "sovaco", "334");
		//facade.cadastrarProduto("hugo", "carvao", "carvao vegetal", "324");
		//
		
		controle.cadastrarCliente("324", "hugo", "lcc3", "hugo@paz.com");
		controle.cadastrarCliente("123", "victor", "lcc3", "victor@paz.com");
		controle.cadastrarCliente("345", "paulo", "lcc3", "paulo@paz.com");
		
		
		
		
		
		controle.removerCliente("555");
	}

}
