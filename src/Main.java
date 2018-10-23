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
			
			
			facade.cadastrarAposta(2, "victor", 2000, "VAI ACONTECER");
			facade.cadastrarAposta(2, "HUGO", 3000, "N VAI ACONTECER");
			facade.cadastrarAposta(2, "carlos", 1000, "VAI ACONTECER");
			
			facade.fecharAposta(2, false);
			facade.inicializa(1000, 0.01);
			System.out.println(facade.getCaixaCenario(2));

			System.out.println(facade.getTotalRateioCenario(2));
			
			
			
			
			
			
		
		
	}

}
