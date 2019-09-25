import java.util.Scanner;

public class PrestupnaGodina {

	public static void main(String[] args) {
		
		int godina;
		
		System.out.println("Unesi godinu: ");
		
		Scanner sc = new Scanner(System.in);
		
		godina = sc.nextInt();

		
		if ((godina % 100 != 0 || godina % 400 == 0) && (godina %4==0))
			System.out.println("Godina je prestupna");
		else
			System.out.println("Godina nije prestupna");

	}

}
