package sqljavaFULL;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String connectionString = ("jdbc:sqlite:C:\\Users\\User\\Downloads\\Prodavnica (1).db");
		  System.out.println("Dobro Dosli");
		  DBProdavnica dbp = new DBProdavnica(connectionString);
		  dbp.connect();
		  boolean f= dbp.logujSe();
		  if(f==false) {
			  dbp.registracija();
		  }
		  
		  System.out.println("1.Pogledajte automobile;\n 2.Uplatite novac");
		  Scanner sc=new Scanner(System.in);
		  int a=sc.nextInt();
		  if(a==1) {
			  dbp.ispisiAutomobile();
		  }
		  else if(a==2) {
			  dbp.ispisiAutomobileKojeJeKupioTrenutniKorisnik();
			  dbp.uplatiNovac();
		  }
		  
		 
		  
		  dbp.disconect();
	}

}
