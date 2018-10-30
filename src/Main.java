
public class Main {

	public static void main(String[] args) {

		Facade facade = new Facade();
		facade.cadastrarFornecedor("victor", "victor@yahoo.com", "423423");
		facade.cadastrarFornecedor("hugo", "hugo@yahoo.com", "4234423");
		
		//facade.cadastrarProduto("victor", "papel", "higienico", "234");
		//facade.cadastrarProduto("victor", "desodorante", "sovaco", "334");
		//facade.cadastrarProduto("hugo", "carvao", "carvao vegetal", "324");
		//
		
		facade.cadastrarCliente("324", "hugo", "lcc3", "hugo@paz.com");
		facade.cadastrarCliente("123", "victor", "lcc3", "victor@paz.com");
		facade.cadastrarCliente("345", "paulo", "lcc3", "paulo@paz.com");
		
		facade.editarCliente("123", "    ", "123");
		
		
		System.out.println(facade.exibirListaDeClientes());
	}

}
