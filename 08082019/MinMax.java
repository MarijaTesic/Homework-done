package domaci;

import java.util.Scanner;

public class MinMax {

	public static void main(String[] args) {
		// Написати функциjу коjа враћа минимум и максимум дводимензионог низа
		// Потпис функциjе: static int[ ] minMax(int[ ][ ] a)

		Scanner sc = new Scanner(System.in);

		int[][] a = new int[2][3];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.println("Unesite element: ");
				a[i][j] = sc.nextInt();
			}
		}

		int[] mm = minMax(a);
		System.out.println("Min je: " + mm[0] + ". Max je " + mm[1]);
	}

	static int[] minMax(int[][] a) {
		int min = a[0][0];
		int max = a[0][0];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {

				if (a[i][j] < min)
					min = a[i][j];
				if (a[i][j] > max)
					max = a[i][j];

			}

		}
		int[] niz = { min, max };
		return niz;
	}

}
