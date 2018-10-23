/**
 * main apenas para testes!
 * @author victorpfb
 *
 */
public class Main {
	
	public static void main(String[] args) {
			Facade facade = new Facade();
			
			System.out.println(facade.cadastrarCenario("flamengo campeao"));
			System.out.println(facade.cadastrarCenario("palmeiras campeao"));
			System.out.println(facade.cadastrarCenario("inter campeao"));
			System.out.println(facade.cadastrarCenario("lalalaooo"));
			
			
			facade.cadastrarAposta(2, "victor", 1999, "ocorre");
			facade.cadastrarAposta(2, "HUGO", 3400, "ocorre");
			facade.cadastrarAposta(2, "carlos", 900, "ocorre");

			System.out.println(facade.controle.exibirApostasDeCenario(2));
			
			
			
		
		
	}

}
