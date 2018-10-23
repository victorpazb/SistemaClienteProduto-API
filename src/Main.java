/**
 * main apenas para testes!
 * @author victorpfb
 *
 */
public class Main {
	
	public static void main(String[] args) {
			
			
			
			Facade facade = new Facade();
			facade.inicializa(1000, 0.01);
			
			System.out.println(facade.cadastrarCenario("flamengo campeao"));
			System.out.println(facade.cadastrarCenario("palmeiras campeao"));
			System.out.println(facade.cadastrarCenario("inter campeao"));
			System.out.println(facade.cadastrarCenario("lalalaooo"));
			
			facade.cadastrarAposta(2, "victor", 199, "VAI ACONTECER");
			facade.cadastrarAposta(2, "victor", 20000, "VAI ACONTECER");
			facade.cadastrarAposta(2, "HUGO", 3000, "N VAI ACONTECER");
			facade.cadastrarAposta(2, "carlos", 1000, "N VAI ACONTECER");
			
			facade.fecharAposta(2, false);
			
			System.out.println(facade.getCaixaCenario(2));
			
			System.out.println(facade.exibeApostas(2));

			System.out.println(facade.getTotalRateioCenario(2));
			
			System.out.println(facade.getCaixa());
			
			
			
			
			
			
		
		
	}

}
