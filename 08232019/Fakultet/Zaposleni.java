package fakultet;

import java.time.LocalDate;

public class Zaposleni extends Covek {
	private LocalDate godinaZaposlenja;
	private int plata;

	public Zaposleni(String ime, String prezime, LocalDate godinaRodjenja, LocalDate godinaZaposlenja, int plata) {
		super(ime, prezime, godinaRodjenja);
		this.godinaZaposlenja = godinaZaposlenja;
		this.plata = plata;
	}

	public LocalDate getGodinaZaposlenja() {
		return godinaZaposlenja;
	}

	public int getPlata() {
		return plata;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append("Godina zaposlenja: " + godinaZaposlenja + "\n");
		sb.append("Plata: " + plata + "\n");

		return sb.toString();
	}

}
