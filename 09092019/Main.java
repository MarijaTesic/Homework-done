package sqljavaosobe;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Broj objekata: ");
		int brObjekata = sc.nextInt();
		Osoba[] nizOsoba = new Osoba[brObjekata];
		for (int i = 0; i < nizOsoba.length; i++) {
			System.out.print("Ime: ");
			String ime = sc.next();
			System.out.print("Prezime: ");
			String prezime = sc.next();
			System.out.print("Adresa: ");
			String adresa = sc.next();
			System.out.println("Unesite 1 za datum rodjenja, 2 za jmbg");
			int izbor = sc.nextInt();
			switch (izbor) {
			case 1:
				System.out.println("Datum rodjenja: ");
				String datum = sc.next();
				Datum d = Datum.datumIzStringa(datum); 
				nizOsoba [i] = new OsobaD(d, ime, prezime, adresa);
				break;
			case 2:
				System.out.println("JMBG: ");
				String jmbg = sc.next();
				nizOsoba [i] = new OsobaJMBG (jmbg, ime, prezime, adresa); 
				break;
			default:
				System.out.println("Neispravan unos.");
			}
		}
		System.out.println("Datum: ");
		String datZaRac = sc.next();
		Datum datumZaRacun = Datum.datumIzStringa(datZaRac);
		System.out.println();
		for (int i  = 0 ; i < nizOsoba.length; i++) {
			System.out.println(nizOsoba[i].toString());
			System.out.println("Numeroloski broj svi: " + nizOsoba[i].numeroloskiBroj());
			System.out.println("String za racunanje trouglica svi: " + nizOsoba[i].metabolizam(datumZaRacun));
			if (nizOsoba[i].numeroloskiBroj() != 7) {
				System.out.println("Numeroloski broj: " + nizOsoba[i].numeroloskiBroj());
			}
			boolean imaNula = false;
			for ( int j  = 0; j < nizOsoba[i].metabolizam(datumZaRacun).length(); j++ ) {
				if ( nizOsoba[i].metabolizam(datumZaRacun).charAt(j) == '0' ) {
					imaNula = true;
					break;
				}
			}
			if (!imaNula) {
				System.out.println("String za racunanje trouglica: " + nizOsoba[i].metabolizam(datumZaRacun));
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

}
