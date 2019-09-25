package domaci;

import java.util.Random;

public class Podskup {

	public static void main(String[] args) {
		int[]a=new int[5];
		int[]b=new int[7];
		generisiNiz(a,100);
		ispisiNiz(a);
		generisiNiz(b,100);
		ispisiNiz(b);
		
		boolean niz=podskup(a,b);
		if (niz==true) System.out.println("Jeste");	
		else System.out.println("Nije");

	}
	
	
	static void generisiNiz(int []a, int gornja) {
		Random rand = new Random();
		for(int i=0;i<a.length;i++) {
		a[i]=rand.nextInt(gornja);
		}
		}
	
	
	static void ispisiNiz(int[]a) {
		System.out.println("Elementi niza su: ");
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]+ " ");
		}
		System.out.println();
		
		
		
	}
	static boolean podskup(int[ ] a,int[ ] b) {
		
		int k=0;
		for(int i = 0; i<a.length; i++){
		for(int j = 0 ; j<b.length; j++){
		if(a[i]==b[j]){
		k++;
		break;
		}
		}
		}
		if(k==a.length)return true;
		else return false;
	}

}
