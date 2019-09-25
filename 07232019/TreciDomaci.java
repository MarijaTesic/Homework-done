package drugipaket;

import java.util.Scanner;

public class TreciDomaci {

	public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int a,b,c,d,e;
          System.out.println("Unesite trocifreni broj: ");
          d=sc.nextInt();
          a=d/100;
          b=(d/10)%10;
          c=(d%10);
          e=(a+b+c);
          System.out.println("Zbir cifara unetog trocifrenog broja je: " +e);
	}

}
