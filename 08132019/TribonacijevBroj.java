package domaci;

import java.util.Scanner;

public class TribonacijevBroj {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Unesite n: ");
		 int n = sc.nextInt(); 
		  
	     System.out.println(n+ ".Tribonacijev broj je: "+tribonacijev(n)); 
	       
	    } 
	
		 static int tribonacijev(int n) { 
	
		     if (n == 1 || n == 2) 
		            return 1; 
		              
		           else if (n == 0) 
		            return 0; 
		        
		        else return
		            tribonacijev(n - 1) +  tribonacijev(n - 2) + tribonacijev(n - 3); 
		        
		       
		        
		    } 
			 
		
	}


