package fakultet;

import java.time.LocalDate;

public class Sluzbenik extends Zaposleni {
	private String odsek;

	public Sluzbenik(String ime, String prezime, LocalDate godinaRodjenja, LocalDate godinaZaposlenja, int plata,
			String odsek) {
		super(ime, prezime, godinaRodjenja, godinaZaposlenja, plata);
		this.odsek = odsek;
	}

	public String getOdsek() {
		return odsek;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append("Odsek: " + odsek + "\n");

		return sb.toString();
	}

}
