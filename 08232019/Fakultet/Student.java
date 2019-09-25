package fakultet;

import java.time.LocalDate;

public class Student extends Covek {
	private int trnGodinaStudija;
	private double trnProsek;
	
	public Student (String ime, String prezime, LocalDate godinaRodjenja, int trnGodStudija, double trnProsek) {
		super(ime, prezime, godinaRodjenja);
		this.trnGodinaStudija = trnGodStudija;
		this.trnProsek = trnProsek;
	}

	public int getTrnGodinaStudija() {
		return trnGodinaStudija;
	}

	public double getTrnProsek() {
		return trnProsek;
	}
	
	public String toString() {
		String ispis = super.toString();
		
		ispis += "Godina studija: " + trnGodinaStudija + "\n";
		ispis += "Prosek: " + trnProsek + "\n";
		
		return ispis;
	}

}
