package fakultet;

import java.time.LocalDate;

public class StudentMstrStudija extends Student {
	private String smerMstrStudija;

	public StudentMstrStudija(String ime, String pr, LocalDate godRodj, int trnGodStudija, double trnProsek,
			String smer) {
		super(ime, pr, godRodj, trnGodStudija, trnProsek);
		smerMstrStudija = smer;
	}

	public String getSmerMstrStudija() {
		return smerMstrStudija;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append("Smer master studija: " + smerMstrStudija + "\n");

		return sb.toString();
	}

}
