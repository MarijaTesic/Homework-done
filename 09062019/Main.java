package sqljavadomaci2;

public class Main {

	public static void main(String[] args) {

		BazaDB b = new BazaDB("jdbc:sqlite:C:\\Users\\Milos\\Desktop\\fudbalskiklub\\FudbalskiSavez.db");
		b.connect();
		b.ispisFudbalera();
	    System.out.println("---------------------------------------------");
	    b.fudbaleriManUTD();
		System.out.println("---------------------------------------------");
		b.fubalerGolovi();
		System.out.println("---------------------------------------------");
		b.fudbalerNajviseGolova();
		System.out.println("---------------------------------------------");
		b.kartoni();
		System.out.println("---------------------------------------------");
		b.gradoviGdeJeFudbalerIgrao(13);
		b.dodajFudbalera("Milos", "Barselona");
		b.dodajTim("Partizan", "Beograd");
		b.dodajUtakmicu("Arsenal", "Manchester United", 12, "X", 1983);    //ovoj metodi sam dodao da ne moze bilo koji od timova da igra 2x u istom kolu	
		b.obrisiTim("Arsenal");
		b.disconnect();
	}

}
