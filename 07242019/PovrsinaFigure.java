import java.util.Scanner;

public class PovrsinaFigure {

	public static void main(String[] args) {

		double a, b, r;
		double povrsina, obim;
		System.out.println("Unesite naziv figure(kvadrat, pravougaonik, krug): ");
		Scanner sc = new Scanner(System.in);

		String figura = sc.nextLine();

		switch (figura) {

		case ("kvadrat"):
			System.out.println("Unesite stranicu a: ");
			a = sc.nextDouble();
			povrsina = a * a;
			obim = a * 4;
			System.out.println("Povrsina kvadrata: " + povrsina);
			System.out.println("Obim kvadrata: " + obim);
			break;
		case ("pravougaonik"):
			System.out.println("Unesite stranicu a: ");
			a = sc.nextDouble();
			System.out.println("Unesite stranicu b: ");
			b = sc.nextDouble();
			povrsina = a * b;
			obim = (a + b) * 2;
			System.out.println("Povrsina pravougaonika: " + povrsina);
			System.out.println("Obim pravougaonika: " + obim);
			break;
			
		case("krug"):
			System.out.println("Unesite poluprecnik kruga: ");
		    r=sc.nextDouble();
		    povrsina=(r*r)* Math.PI; 
		    obim= 2*r*Math.PI;
		    System.out.println("Povrsina kruga je : " + povrsina);
			System.out.println("Obim kruga je : " + obim);
			break;
		default:
			System.out.println("Uneli ste pogresan string");
			break;

		}
	}

}
