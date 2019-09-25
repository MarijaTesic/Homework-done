package druganedelja;

import java.util.Scanner;

public class FunkcijaNiK {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite n: ");
		int n = sc.nextInt();
		System.out.println("Unesite k: ");
		int k = sc.nextInt();
		double a = vrednost(n,k);
		System.out.println("Vrednost izraza je: " + a);

	}

	static double vrednost(double n, double k) {
		double i=0;
		double tekBr=0;
		double suma=0;
		for (i = 0; i <= n; i++) {
			tekBr = (i + 1) / (k + i);
			suma += tekBr;
		}
		return suma;

	}

}
