package domacitrecanedelja;

import java.util.Scanner;

public class Nizovi3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Unesite broj elemenata niza: ");
		int n=sc.nextInt();
		int []a=new int[n];
		ucitajNiz(a);

		double sV = srVrednost(a);
		System.out.println("Srednja vrednost je: " + sV);

		ispisiVece(a, sV);
		int najblizi = najbliziBrojPoVrednosti(a, sV);
		System.out.println("Najblizi broj po vrednosti je: " + najblizi);

		}

		static void ucitajNiz(int []a) {
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<a.length;i++) {
		System.out.println("Unesite " + i + " element: ");
		a[i]=sc.nextInt();
		}
		}

		static double srVrednost(int[] a){
		int zbir = 0;
		for(int i = 0; i<a.length; i++){
		zbir = zbir + a[i];
		}
		double srVred = zbir / a.length;
		return srVred;
		}

		static void ispisiVece(int []a, double sV){
		System.out.print("Brojevi veci od srednje vrednosti elemenata su: ");
		for(int i = 0; i<a.length; i++){
		if(a[i] > sV){
		System.out.print(a[i] + " ");
		}
		}
		System.out.println();
		}

		static int najbliziBrojPoVrednosti(int [] a, double sV){
		double razlika = 0;
		double najmanjaRazlika = sV- a[0];
		int najbliziBroj = a[0];

		for(int i = 1; i<a.length; i++){
		razlika = sV - a[i];
		if(razlika<0) razlika = -razlika;

		if(najmanjaRazlika < razlika){
		najmanjaRazlika = razlika;
		najbliziBroj = a[i];
		}
		}

		return najbliziBroj;

	}

}
