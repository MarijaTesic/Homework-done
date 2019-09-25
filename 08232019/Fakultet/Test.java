package fakultet;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		Covek c = new Covek ("Predrag", "Petrovic", LocalDate.of(1990, 3, 21));
		Student s = new Student("Ana", "Janjic", LocalDate.of(1987, 6, 21), 4, 8.55);
		StudentOsnStudija sos = new StudentOsnStudija("Vanja", "Radic", LocalDate.of(1996, 6, 17), 3, 9.54, "Logopedija");
		StudentMstrStudija sms = new StudentMstrStudija("Nikola", "Lukic", LocalDate.of(1994, 6, 16), 1, 7.88, "Psihologija");
		Zaposleni z = new Zaposleni ("Marko", "Jovanovic", LocalDate.of(1966, 7, 22), LocalDate.of(1999, 9, 30), 50000);
		Nastavnik n = new Nastavnik ("Milica", "Drakulic", LocalDate.of(1966, 2, 12), LocalDate.of(2001, 8, 30), 60000, "Istorija dzeza", 
				"Istorija dzeza, Istorija SAD-a, Moderna istorija XX veka");
		Profesor p = new Profesor("Nada", "Sekulic", LocalDate.of(1963, 1, 12), LocalDate.of(2006, 3, 13), 70000, "Postmodernizam i sociologija",
				"Postmodernizam i sociologija, Socijalna istorija XX veka, Film i socilogija", "docent");
		Asistent a = new Asistent("Jana", "Sekulic", LocalDate.of(1986, 12, 24), LocalDate.of(2012, 3, 1), 50000, "Socilogija kulture",
				"Sociologija kulture, Sociologija muzike", "Sociologija");
		Sluzbenik sl = new Sluzbenik("Margarita", "Ristic", LocalDate.of(1962, 5, 4), LocalDate.of(2001, 8, 22), 45000, "Administracija");
		
		System.out.println(c.toString());
		System.out.println("-----------------------------------");
		System.out.println(s.toString());
		System.out.println("-----------------------------------");
		System.out.println(sos.toString());
		System.out.println("-----------------------------------");
		System.out.println(sms.toString());
		System.out.println("-----------------------------------");
		System.out.println(z.toString());
		System.out.println("-----------------------------------");
		System.out.println(n.toString());
		System.out.println("-----------------------------------");
		System.out.println(p.toString());
		System.out.println("-----------------------------------");
		System.out.println(a.toString());
		System.out.println("-----------------------------------");
		System.out.println(sl.toString());
		System.out.println("-----------------------------------");
		
		
		
		
	}

}
