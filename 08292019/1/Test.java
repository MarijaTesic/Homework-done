package domaci08292019;

public class Test {
	
	public static void main(String[] args) {
		 // 2 + 10 - 11 + 20 = 21
		 Broj b2 = new Broj(2);
		 Broj b10 = new Broj(10);
		 Broj bn11 = new Broj(-11);
		 Broj b20 = new Broj(20);
		
		Sabiranje s1 = new Sabiranje(b2, b10);
		 Oduzimanje o1 = new Oduzimanje(s1, bn11);
		 Sabiranje s2 = new Sabiranje(o1, b20);
		
		 System.out.println("Reazultat: "  + s2.izracunaj());
		 

	}
	

}