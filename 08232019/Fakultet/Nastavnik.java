package fakultet;

import java.time.LocalDate;

public class Nastavnik extends Zaposleni {
	private String omiljeniPredmet;
	private String listaPredmeta;

	public Nastavnik(String ime, String prezime, LocalDate godinaRodjenja, LocalDate godinaZaposlenja, int plata,
			String omPr, String lPr) {
		super(ime, prezime, godinaRodjenja, godinaZaposlenja, plata);
		omiljeniPredmet = omPr;
		listaPredmeta = lPr;
	}

	public String getOmiljeniPredmet() {
		return omiljeniPredmet;
	}

	public String getListaPredmeta() {
		return listaPredmeta;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append("Omiljeni predmet: " + omiljeniPredmet + "\n");
		sb.append("Predmeti na kojima drzi nastavu: " + listaPredmeta + "\n");

		return sb.toString();
	}

}
