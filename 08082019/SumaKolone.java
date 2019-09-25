package domaci;

import java.util.Scanner;

public class SumaKolone {

	public static void main(String[] args) {

		int[][] a = new int[3][4];

		System.out.println("Unesite kolonu: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < a.length; i++)
		{

			for (int j = 0; j < a[i].length; j++) {
				System.out.println("Unesite element: ");
				a[i][j] = sc.nextInt();
			}
		}
		int z1 = sumaKolone(a, n);
		System.out.println("Suma je: " + z1);

	}

	static int sumaKolone(int[][] a, int n) {

		int zbir = 0;
		for (int i = 0; i < a.length; i++) {
			zbir += a[i][n];
		}
		return zbir;
	}

}
