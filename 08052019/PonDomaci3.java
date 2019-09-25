package trecanedelja;

import java.util.Scanner;

public class PonDomaci3 {

	public static void main(String[] args) {
		// aritmeticka sredina niz
			Scanner sc=new Scanner(System.in);
			System.out.println("Unesite n: ");
			int n=sc.nextInt();
			int[] a=new int[n];
			ucitajNiz(a);
			double as = arSred(a);
			int med = medijana(a);
			System.out.println("Aritmeticak sredina niza je " + as);
			System.out.println("Medijana niza je " + med);
			}

			static void ucitajNiz(int[] a){
			Scanner sc = new Scanner(System.in);
			System.out.println("Unesite sve elemente niza:");
			for(int i = 0; i<a.length; i++){
			a[i] = sc.nextInt();
			}

			}

			static double arSred(int[] a) {
			int i;
			int zbir=0;
			double as=0;
			for(i=0;i<a.length;i++) {
			zbir=zbir+a[i];

			}
			as=zbir/a.length;
			return as;
			}

			static int medijana(int[] a) {
			int index = a.length/2;
			return a[index];
	
	
	
	
	
	}
	

}
