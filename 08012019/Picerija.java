package druganedelja;

import java.util.Scanner;

public class Picerija {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dobrodošli u Braško++ pametnu kasu!");
		System.out.print("Koji je danas dan (Pon-1/Uto-2/Sre-3/Čet-4/Pet-5/Sub-6/Ned-7): ");
		int dan = sc.nextInt();

		String dnevna_naziv = "";
		double dnId = 0;
		double dnProcenat = 0;

		switch (dan) {
		case 2:
			dnId = 5;
			dnevna_naziv = "Vesuvio";
			dnProcenat = 0.1;
			break;
		case 4:
			dnId = 2;
			dnevna_naziv = "Capricciosa";
			dnProcenat = 0.1;
			break;
		case 6:
		case 7:
			dnId = 2 * 3 * 5;
			dnevna_naziv = "SVE";
			dnProcenat = 0.15;
			break;
		}

		int idMusterije = 1;
		int ukupnoPizza = 1;

		System.out.println("Musterija id#" + idMusterije + ": ");
		int broj_narucenih = sc.nextInt();
		while (broj_narucenih != -1) {
			double akcija1 = 0;
			double ukupna_cena = 0;
			System.out.println("Racun za musteriju id#" + idMusterije + " ");
			for (int i = 1; i <= broj_narucenih; i++) {
				int id = sc.nextInt();

				int cena = 0;
				String naziv;

				switch (id) {
				case 2:
					cena = 320;
					naziv = "Cappricciosa";
					break;
				case 3:
					cena = 290;
					naziv = "Pepperoni";
					break;
				case 5:
					cena = 310;
					naziv = "Vesuvio";
					break;
				default:
					System.err.print("Uneli ste neispravan id. Pokusajte ponovo: ");
					continue;
				}

				String akcija2 = "Pizza";

				if (i % 4 == 0) {
					cena = 0;
					akcija2 = "AKCIJA 3+1";
				} else if (ukupnoPizza % 7 == 0) {
					cena = 0;
					akcija2 = "AKCIJA #7";
				}

				ukupna_cena += cena;

				System.out.printf( akcija2, naziv, cena);

				if (dnId % id == 0) {
					akcija1 += dnProcenat * cena;
				}

				ukupnoPizza++;
			}
			System.out.printf("Ukupno: %.1f \n", ukupna_cena);

			if (akcija1 > 0) {
				System.out.printf("DNEVNA 10%% %s \t %.1f \n", dnevna_naziv, -akcija1);
				System.out.printf("Ukupno: %.1f \n", ukupna_cena - akcija1);
			}

			idMusterije++;
			System.out.print("Musterija id#" + idMusterije + ":");
			broj_narucenih = sc.nextInt();
		}
	}
}
