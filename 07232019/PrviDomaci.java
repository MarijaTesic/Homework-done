package drugipaket;

import java.util.Scanner;

public class PrviDomaci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double r,v;
		System.out.println("Unesite poluprecnik ");
		r=sc.nextDouble();
	    v=(4*(r*r*r)*Math.PI)/3;
		System.out.println("Zapremina lopte je: " +v);
		
		
		
	}

}
