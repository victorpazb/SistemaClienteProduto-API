
public class Main {

	public static void main(String[] args) {

		Facade facade = new Facade();
		facade.cadastrarCliente("123", "Victor", "lcc3", "vic@");
		facade.cadastrarCliente("234", "Hugo", "lcc3", "hugo@");
		
		
		
		
		System.out.println(facade.exibirListaDeClientes());
	}

}
