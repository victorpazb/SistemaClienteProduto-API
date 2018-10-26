
public class Main {

	public static void main(String[] args) {

		Facade facade = new Facade();
		facade.cadastrarClientes("123", "victor", "lcc3", "victorpazb@gmail.com");
		System.out.println(facade.exibirCliente("123"));
		facade.editarCliente("123", "nome", "hugo");
		System.out.println(facade.exibirCliente("123"));
		facade.removerCliente("123");
		System.out.println(facade.exibirCliente("123"));

	}

}
