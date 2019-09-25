import java.util.Scanner;

public class ProstBroj {

	public static void main(String[] args) {
        
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Unesite broj: ");
		int broj = sc.nextInt();
		
        boolean oznaka = false;
        
        for(int i = 2; i <= broj/2; ++i)
        {
            
            if(broj % i == 0)
            {
                oznaka = true;
                break;
            }
        }
        if (!oznaka)
            System.out.println(broj + " je prost broj.");
        else
            System.out.println(broj + " nije prost broj.");
	}

}
