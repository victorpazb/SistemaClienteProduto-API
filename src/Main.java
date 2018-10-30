
public class Main {

	public static void main(String[] args) {

		Facade facade = new Facade();
		facade.cadastrarFornecedor("Victor", "victorpazb@gmail.com", "123123");
		facade.cadastrarFornecedor("Hugo", "hugopazb@gmail.com", "24234234");
		facade.cadastrarFornecedor("Paulo", "paulo@gmail.com", "324234");
		
		facade.cadastrarProduto("Victor", "leite", "litro de caixa", "1123");
		facade.cadastrarProduto("Victor", "papel", "higienico", "123");
		facade.cadastrarProduto("Victor", "chocolate", "branco com frutas", "223");
		facade.cadastrarProduto("Hugo", "vagem", "selecionada", "55");
		
		
		System.out.println(facade.exibirProdutosDeTodosOsFornecedores());
	}

}
