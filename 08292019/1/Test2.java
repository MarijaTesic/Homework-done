package domaci08292019;

public class Test2 {
	
	public static void main(String[] args) {


	// 2 + x0 - 11 + x1 = 21
	 Broj b2 = new Broj(2);
	 Promenljiva p0 = new Promenljiva("x1", 10);
	 Broj bn11 = new Broj(-11);
	 Promenljiva p1 = new Promenljiva("x2", 20);
	
	 Sabiranje s1 = new Sabiranje(b2, p0);
	 Oduzimanje o1 = new Oduzimanje(s1, bn11);
	 Sabiranje s2 = new Sabiranje(o1, p1);
	
	 System.out.println("Rezultat je: " + s2.izracunaj());
}
}