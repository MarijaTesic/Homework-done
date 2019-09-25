package domacitrecanedelja;

import java.util.Scanner;

public class Nizovi1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Unesite broj elemenata niza: ");
		int n=sc.nextInt();
		int []a=new int[n];
		ucitajNiz(a);

		System.out.println("Unesite broj: ");
		int br=sc.nextInt();

		boolean flag = broj(a, br);
		if(flag == true)System.out.println("Broj postoji u nizu");
		else System.out.println("Broj ne postoji u nizu");
		}

		static void ucitajNiz(int []a) {
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<a.length;i++) {
		System.out.println("Unesite " + i + " element: ");
		a[i]=sc.nextInt();
		}
		}

		static boolean broj(int[]a, int br) {
		for(int i=0;i<a.length;i++) {
		if(a[i] == br) {
		return true;
		}
		}
		return false;


	}

}
