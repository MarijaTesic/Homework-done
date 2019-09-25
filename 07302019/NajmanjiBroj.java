package druganedelja;

import java.util.Scanner;

public class NajmanjiBroj {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n1,n2,n3;
		System.out.println("Unesite 1.broj: ");
		n1=sc.nextInt();
		System.out.println("Unesite 2.broj: ");
		n2=sc.nextInt();
		System.out.println("Unesite 3.broj: ");
		n3=sc.nextInt();
		int najmanji=odrediNajmanji(n1,n2,n3);
		System.out.println("Najmanji je: "+najmanji);
		}
	
		static int odrediNajmanji(int n1, int n2, int n3) {
		if(n1<=n2 && n1<=n3)
			return n1;
		else if(n2<=n1 && n2<=n3)
			return n2;
		else
			return n3;
	

	}

}
