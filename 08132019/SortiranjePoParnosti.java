package domaci;

import java.util.Random;

public class SortiranjePoParnosti {

	public static void main(String[] args) {
		

		int []a=new int[5];
		generisiNiz(a, 100);
		ispisiNiz(a);
		System.out.println("Niz je: ");
		int [] niz = sortiranje(a);
		ispisiNiz(niz);
		}

		static void ispisiNiz(int [] a){
		for(int i = 0 ; i<a.length; i++){
		System.out.print(a[i] + " ");
		}
		System.out.println();
		}

		static void generisiNiz(int [] a, int gornjaGranica){
		Random r = new Random();
		for(int i = 0 ; i<a.length; i++){
		a[i] = r.nextInt(gornjaGranica);
		}
		}



		
		static int [] sortiranje(int []a) {
		int[] niz=new int[a.length];
		int temp=0;

		for(int i=0;i<a.length;i++) {
		if(a[i]%2==0)
		niz[temp++]=a[i];
		}

		for(int i=0;i<a.length;i++) {
		if(a[i]%2==1)
		niz[temp++]=a[i];
		}

		return niz;
		}

}


