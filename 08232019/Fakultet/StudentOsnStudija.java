package fakultet;

import java.time.LocalDate;

public class StudentOsnStudija extends Student {
	private String smerOsnStudija;

	public StudentOsnStudija(String ime, String pr, LocalDate godRodj, int trnGodStudija, double trnProsek,
			String smer) {
		super(ime, pr, godRodj, trnGodStudija, trnProsek);
		smerOsnStudija = smer;
	}

	public String getSmerOsnStudija() {
		return smerOsnStudija;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append("Smer osnovnih studija: " + smerOsnStudija + "\n");

		return sb.toString();
	}

}
