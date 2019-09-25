import java.util.Scanner;

public class Palindrom {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		
		System.out.println("Unesite broj: ");
		int a, suma = 0, c;
		int n = sc.nextInt();

		c = n;
		
		while (n > 0) {
			a = n % 10; // uzimam ostatak
			n = n / 10;
			suma = (suma * 10) + a;
			
		}
		if (c == suma)
			System.out.println("Broj je palindrom ");
		else
			System.out.println("Broj nije palindrom");
	}

}
