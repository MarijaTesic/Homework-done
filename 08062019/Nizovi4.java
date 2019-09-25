package domacitrecanedelja;

import java.util.Scanner;

public class Nizovi4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite broj elemenata niza: ");
		int n = sc.nextInt();
		int[] a = new int[n];
		ucitajNiz(a);

		boolean postoji = daliPostojeDuplikati(a);
		if(postoji == true)System.out.println("Postoje duplikati u nizu");
		else System.out.println("Ne postoje duplikati u nizu");
		}

		static void ucitajNiz(int[] a) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < a.length; i++) {
		System.out.println("Unesite " + i + " element: ");
		a[i] = sc.nextInt();
		}
		}

		static boolean daliPostojeDuplikati(int[] a) {

		for(int i = 0; i<a.length-1; i++){
		for(int j = i+1; j<a.length; j++){
		if(a[i] == a[j]) return true;
		}
		}

		return false;

	}

}
