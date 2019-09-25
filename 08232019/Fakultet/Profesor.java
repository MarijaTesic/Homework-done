package fakultet;

import java.time.LocalDate;

public class Profesor extends Nastavnik {
	public String titula;

	public Profesor(String ime, String prezime, LocalDate godinaRodjenja, LocalDate godinaZaposlenja, int plata,
			String omPr, String lPr, String titula) {
		super(ime, prezime, godinaRodjenja, godinaZaposlenja, plata, omPr, lPr);
		this.titula = titula;
	}

	public String getTitula() {
		return titula;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append("Titula: " + titula + "\n");
		
		return sb.toString();
	}
}
