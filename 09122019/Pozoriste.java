package pozoriste;

public class Pozoriste {
	private static int globalID = 1;
	private int id;
	private String naziv;

	public Pozoriste(String naziv) {
		this.naziv = naziv;
		id = globalID++;
	}

	public int getId() {
		return id;
	}

	public String getNaziv() {
		return naziv;
	}

	public String getSkraceniNaziv() {
		String[] odvojeneReci = naziv.toUpperCase().split("\\s+");
		String skraceni = "";
		for (int i = 0; i < odvojeneReci.length; i++) {
			skraceni += odvojeneReci[i].charAt(0);
		}
		return skraceni;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv).append(" [").append(id).append("]");
		return sb.toString();
	}
}
