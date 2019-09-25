package domacitrecanedelja;

import java.util.Random;
import java.util.Scanner;

public class Nizovi2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		System.out.println("Unesite broj elemenata niza: ");
		int n=sc.nextInt();
		System.out.println("Unesite gornju granicu");
		int gornja = sc.nextInt();

		int []a=new int[n];

		generisiNiz(a, gornja);
		ispisiNiz(a);

		System.out.println("Unesite broj: ");
		int br=sc.nextInt();

		boolean postoji = broj(a, br);
		if(postoji == true)System.out.println("Broj postoji u nizu");
		else System.out.println("Broj ne postoji u nizu");
		}

		static void ispisiNiz(int a[]){
		System.out.print("Elementi niza su: ");
		for(int i = 0; i<a.length; i++){
		System.out.print(a[i] + " ");
		}
		System.out.println();
		}

		static void generisiNiz(int []a, int gornja) {
		Random rand = new Random();
		for(int i=0;i<a.length;i++) {
		a[i]=rand.nextInt(gornja);
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
