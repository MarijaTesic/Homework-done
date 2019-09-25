package sqljavadomaci;

public class Main {

	public static void main(String[] args) {
		StudentskaBaza sb=new StudentskaBaza("jdbc:sqlite:C:\\Users\\Marija\\Downloads\\StudentskaBaza.sb");
		sb.connect();
		sb.dodajStudenta(20140021, "Milos", "Peric", "06.07.2014.", "20.01.1995.", "Beograd");
		sb.izbrisatiIspite();
		sb.disconnect();

	}

}
