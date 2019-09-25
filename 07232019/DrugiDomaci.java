package drugipaket;

import java.util.Scanner;

public class DrugiDomaci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a,b,c,sv;
		System.out.println("Prvi broj: ");
		a=sc.nextDouble();
		System.out.println("Drugi broj: ");
		b=sc.nextDouble();
		System.out.println("Treci broj: ");
		c=sc.nextDouble();
		sv=(a+b+c)/3;
		System.out.println("Srednja vrednost je: "+sv);
		sc.close();
		

	}

}
