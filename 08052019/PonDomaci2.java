package trecanedelja;

import java.util.Scanner;

public class PonDomaci2 {

	public static void main(String[] args) {
		// min/max u nizu
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite n: ");
		int n = sc.nextInt();
		int[] a = new int[n];
		System.out.println("Unesite elemente: ");
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
        int []niz=minMax(a);
        System.out.println("Najveci element: " + niz[1]);
		System.out.println("Najmanji element: " + niz[0]);
	}

	static int [] minMax(int[] a) {
		int max = a[1];
		int min = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
			if (a[i] < min)
				min = a[i];
		}
		int[]b=new int[2];
		b[0]=min;
		b[1]=max;
		return b;

	}
	

}
