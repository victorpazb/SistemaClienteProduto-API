
public class Main {
	
	public static void main(String[] args) {
			
			
			
			Facade facade = new Facade();
			System.out.println(facade.cadastrarCenario("Brasil campeao"));
			System.out.println(facade.cadastrarCenario("Brasil hexa"));
			facade.cadastrarAposta(1, "Victor", 1000, "VAI ACONTECER");

			System.out.println(facade.exibeApostas(1));
			
			
		
		
	}

}
