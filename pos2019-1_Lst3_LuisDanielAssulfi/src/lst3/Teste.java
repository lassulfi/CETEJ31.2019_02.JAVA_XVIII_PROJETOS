package lst3;

import list3.pai.Pai;

public class Teste {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("list3.pai.Pai.class");
			Pai pai = new Pai();
			pai.nome = "Luis Celso Assulfi";
			pai.idade = 60;
			
			pai.impPai();
			
			pai.cadPai("Joaquim José da Silva", 45, 4000);
			pai.impPai();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
