
public class Main {
	
	public static void main(String[] args) {
			Facade facade = new Facade();
			
			System.out.println(facade.cadastrarCenario("flamengo campeao"));
			System.out.println(facade.cadastrarCenario("palmeiras campeao"));
			System.out.println(facade.cadastrarCenario("inter campeao"));
			System.out.println(facade.cadastrarCenario("lalalaooo"));
			
			facade.cadastrarAposta(1, "victor", 23, "ocorre");
			facade.cadastrarAposta(1, "HUGO", 34, "ocorre");
			facade.cadastrarAposta(1, "carlos", 9, "ocorre");
			facade.cadastrarAposta(1, "abel", 12, "n ocorre");
			
			System.out.println(facade.controle.exibirApostasDeCenario(2));
			
			
			
		
		
	}

}
