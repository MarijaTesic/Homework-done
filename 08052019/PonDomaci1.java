package trecanedelja;

import java.util.Scanner;

public class PonDomaci1 {

	public static void main(String[] args) {
		//element koji nedostaje
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Unesite n: ");
		int n=sc.nextInt();
		int[] a=new int[n];
		ucitajNiz(a);
		int N = min(a);
		int M = max(a);

		int z = zbirBrojevaIzmedjuNiM(N, M);
		int z2 = zbirBrojevaUNizu(a);

		int brojKojiFali = z - z2;

		System.out.println("Broj koji fali je: " + brojKojiFali);

		}

		static void ucitajNiz(int[] a){
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite sve elemente niza:");
		for(int i = 0; i<a.length; i++){
		a[i] = sc.nextInt();
		}
		}

		static int min(int[] a){
		int min = a[0];
		for(int i=1; i<a.length; i++){
		if(a[i]<min)min = a[i];
		}
		return min;
		}

		static int max(int[] a){
		int max = a[0];
		for(int i=1; i<a.length; i++){
		if(a[i]>max)max = a[i];
		}
		return max;
		}

		static int zbirBrojevaIzmedjuNiM(int N, int M){
		int zbir = 0;
		for(int i=N; i<=M; i++){
		zbir = zbir + i;
		}
		return zbir;
		}

		static int zbirBrojevaUNizu(int[] a){
		int zbir = 0;
		for(int i = 0; i<a.length; i++){
		zbir = zbir + a[i];
		}
		return zbir;
		
			
		}
		

	}


