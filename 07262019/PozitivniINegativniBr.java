package drugipaket;

import java.util.Scanner;

public class PozitivniINegativniBr {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		double zbir=0;
		int i=0;
		for(;i<5;i++) {
			System.out.println("Unesite "+(i+1)+ ".broj: ");
			int b=sc.nextInt();
			if(b>0) {
				zbir+=b;}
			else{continue;}
			}
			
		System.out.println("Zbir unetih brojeva je: " +zbir);
		} 
		
}

