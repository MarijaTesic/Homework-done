package fakultet;

import java.time.LocalDate;

public class Asistent extends Nastavnik {
	private String smerDrStudija;

	public Asistent(String ime, String prezime, LocalDate godinaRodjenja, LocalDate godinaZaposlenja, int plata,
			String omPr, String lPr, String smer) {
		super(ime, prezime, godinaRodjenja, godinaZaposlenja, plata, omPr, lPr);
		smerDrStudija = smer;
	}

	public String getSmerDrStudija() {
		return smerDrStudija;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append("Smer doktorskih studija: " + smerDrStudija + "\n");

		return sb.toString();
	}
}
