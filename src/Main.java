import java.util.HashMap;
public class Main {
	
	
	public static void main(String[] args) {
		
		HashMap<String, String> mapa = new HashMap<>();
		
		String p1 = "coxa - coxa de frango, file - file no molho";
		
		mapa.put("coxa - coxa de frango", "1");
		mapa.put("file - file no molho", "2");
		String[] lista = p1.split(",");
		
		for (String item : lista) {
			System.out.println(mapa.containsKey(item.trim()));
		}
		
	}

}
