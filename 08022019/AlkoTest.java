package druganedelja;

import java.util.Scanner;

public class AlkoTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dobrodošli u alko aproksimator 9000!");

		System.out.print("Unesite vasu tezinu (kg): ");
		double kg = sc.nextDouble();

		System.out.print("Unesite vaš pol (ako ste musko unesite 1, ako ste zensko unesite 0): ");
		int pol = sc.nextInt();

		while (pol != 0 && pol != 1) {
			System.err.print("Greška u unosu, molim pokusajte ponovo: ");
			pol = sc.nextInt();
		}
		double r;
		if (pol == 1) {
			r = 0.55;
		} else {
			r = 0.68;
		}

		double procenat, alkMl = 0;

		while (true) {
			System.out.print("Unesite id pica koje ste pili ili -1 ako ste vec uneli sva pića koja ste pili: ");
			int id = sc.nextInt();

			if (id == -1)
				break;

			switch (id) {
			case 1:
				procenat = 0.5;
				break;
			case 2:
				procenat = 0.4;
				break;
			case 3:
				procenat = 0.047;
				break;
			case 4:
				procenat = 0.11;
				break;
			default:
				System.out.println("Greška, željeni id nije u bazi podataka. Pokušajte ponovo");
				continue;
			}

			System.out.print("Unesite koliko mililitra tog pica ste popili: ");
			double kolicina = sc.nextDouble();

			alkMl += kolicina * procenat;
		}

		double BAC = alkMl / (kg * 1000 * r) * 1000;

		String naziv = "";
		String kazna = "";
		int poeni = 0;
		int zabrana = 0;

		if (BAC <= 0.2) {
			naziv = "Dozvoljena alkoholisanost";
			kazna = "Bez kazne";
			poeni = 0;
			zabrana = 0;
		} else if (BAC > 0.2 && BAC <= 0.5) {
			naziv = "Umerena alkoholisanost";
			kazna = "10.000din";
			poeni = 0;
			zabrana = 0;
		} else if (BAC > 0.5 && BAC <= 0.8) {
			naziv = "Srednja alkoholisanost";
			kazna = "10.000-20.000din";
			poeni = 6;
			zabrana = 3;
		} else if (BAC > 0.8 && BAC <= 1.2) {
			naziv = "Visoka alkoholisanost";
			kazna = "20.000-40.000din";
			poeni = 8;
			zabrana = 4;
		} else if (BAC > 1.2 && BAC <= 1.6) {
			naziv = "Teska alkoholisanost";
			kazna = "100.000-120.000din";
			poeni = 9;
			zabrana = 8;
		} else if (BAC > 1.6 && BAC <= 2.0) {
			naziv = "Teska alkoholisanost";
			kazna = "100.000-120.000din";
			poeni = 14;
			zabrana = 8;
		} else if (BAC > 2.0) {
			naziv = "Potpuna alkoholisanost";
			kazna = "30-60 dana zatvora";
			poeni = 15;
			zabrana = 9;
		}

		System.out.println("--------------------------");
		System.out.printf("BAC: %.2f", BAC);
		System.out.println(" - " + naziv);
		System.out.println("--------------------------");
		System.out.println("Kazna: " + kazna);
		System.out.println("Kazneni poeni: " + poeni);
		System.out.println("Zabrana voznje: " + zabrana + " meseci");

	}
}
