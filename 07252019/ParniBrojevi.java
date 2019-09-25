import java.util.Scanner;

public class ParniBrojevi {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int suma = 0;
		int a, b, d, g;
		System.out.println("Unesite prvi broj: ");
		a = sc.nextInt();
		System.out.println("Unesite drugi broj: ");
		b = sc.nextInt();

		System.out.print("Parni brojevi su: ");
		
		if(a<b) {
			d=a;
			g=b;
		}else {
			d=b;
			g=a;
		}
		for (int i = d;i <= g; i++) {
			
			if (i % 2 == 0) {
				System.out.print(i + " ");
				suma += i;
			}
			
		}
		System.out.println(" ");
		System.out.println("Zbir parnih brojeva je: " + suma);
	}

}
