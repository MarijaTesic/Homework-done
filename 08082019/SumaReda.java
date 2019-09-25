package domaci;

import java.util.Scanner;

public class SumaReda {

	public static void main(String[] args) {
		// Написати функциjу коjа враћа суму n-tog реда дводимензионог низа
		//Потпис функциjе: static int sumaReda(int[ ][ ] a, int n)

		int [][]a=new int [3][4];
		
		System.out.println("Unesite red: ");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		for(int j=0;j<a[n].length;j++) {
		System.out.println("Unesite element: ");
		a[n][j]=sc.nextInt();
		}
		
		int z1=sumaReda(a,n);
		System.out.println("Suma je: "+z1);
		
		
	}
	
	static int sumaReda(int[][]a,int n) {
		
		int zbir=0;
		for(int j=0;j<a[n].length;j++) {
			zbir+=a[n][j];

	}
		return zbir;
		

}
}