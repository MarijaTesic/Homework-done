package druganedelja;

import java.util.Scanner;

public class VracanjeKusura {

	static int napraviRacun(){
		int i =1;
		int racun = 0;
		Scanner sc = new Scanner(System.in);
		while(true){
		if(i==1) {
		System.out.println("Unesite cenu " +i+ ". proizvoda");
		}
		else {
		System.out.println("Unesite cenu " + i + ". proizvoda ili -1 ako nemate vise proizvoda");
		}

		int cena = sc.nextInt();
		if(cena == -1){
		break;
		}
		else{
		System.out.println("Unesite kolicinu " + i + ". proizvoda");
		i++;
		int kolicina = sc.nextInt();
		int iznos = kolicina * cena;

		if(kolicina > 3)iznos = iznos - iznos/10;

		racun += iznos;
		}
		}

		System.out.println("Da li ste penzioner?(unesite 1 ako jeste ili 0 ako niste): ");
		int penzioner = sc.nextInt();
		if(penzioner == 1)racun = racun - racun/10;
		return racun;
		}

		static void ispisiKusur(int kusur){
		int b20, b10, b5, b2, b1;
		b20 = b10 = b5 = b2 = b1 = 0;

		while (kusur > 0) {
		if (kusur >= 20) {
		kusur = kusur - 20;
		b20 = b20 + 1;
		continue;
		}
		if (kusur >= 10) {
		kusur = kusur - 10;
		b10 = b10 + 1;
		continue;
		}
		if (kusur >= 5) {
		kusur = kusur - 5;
		b5 = b5 + 1;
		continue;
		}
		if (kusur >= 2) {
		kusur = kusur - 2;
		b2 = b2 + 1;
		continue;
		}
		if (kusur >= 1) {
		kusur = kusur - 1;
		b1 = b1 + 1;
		continue;
		}
		}
		if(b20>0){
		System.out.println("Treba da mu vratim " + b20 + " kovanica od 20");
		}
		if(b10>0){
		System.out.println("Treba da mu vratim " + b10 + " kovanica od 10");
		}
		if(b5>0){
		System.out.println("Treba da mu vratim " + b5 + " kovanica od 5");
		}
		if(b2>0){
		System.out.println("Treba da mu vratim " + b2 + " kovanica od 2");
		}
		if(b1>0){
		System.out.println("Treba da mu vratim " + b1 + " kovanica od 1");
		}

		}


		public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int racun = napraviRacun();
		System.out.println("Vas racun je: " + racun);

		System.out.println("Unesite koliko para dajete: ");
		int gotovina;
		gotovina = sc.nextInt();
		while(gotovina<racun){
		System.out.println("Niste dali dovoljno novca, dajte ponovo:");
		gotovina = sc.nextInt();
		}

		int kusur = gotovina - racun;
		System.out.println("Vas kusur je:" + kusur);
		ispisiKusur(kusur);


		}
}