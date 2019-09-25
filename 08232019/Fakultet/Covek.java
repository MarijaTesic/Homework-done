package fakultet;

import java.time.LocalDate;

public class Covek {
	private String ime;
	private String prezime;
	private LocalDate godinaRodjenja;
	
	public Covek(String ime, String prezime, LocalDate godinaRodjenja) {
		this.ime = ime;
		this.prezime = prezime;
		this.godinaRodjenja = godinaRodjenja;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public LocalDate getGodinaRodjenja() {
		return godinaRodjenja;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Ime: " + ime + "\n");
		sb.append("Prezime: " + prezime + "\n");
		sb.append("Godina rodjenja: " + godinaRodjenja + "\n");
		
		return sb.toString();
	}
	
	
	
}
