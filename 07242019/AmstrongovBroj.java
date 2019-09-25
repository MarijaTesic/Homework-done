import java.util.Scanner;

public class AmstrongovBroj {

	public static void main(String[] args) {

		int c = 0, a, b;
		Scanner sc = new Scanner(System.in);

		System.out.println("Unesite broj: ");
		int n = sc.nextInt();
        
		b=n;
		
		while (n > 0) {
			a = n % 10;
			n = n / 10;
			c = c + (a * a * a);
		}
		if (b == c)
			System.out.println("Broj " + b + " je Armstrongov");
		else
			System.out.println("Broj " + b + " nije Armstrongov");
	}
}
