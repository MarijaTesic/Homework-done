package pozoriste;

import java.util.ArrayList;

public class Predstava {
	private String naziv;
	private Pozoriste pozoriste;
	private ArrayList<Zaposleni> zaposleni = new ArrayList<Zaposleni>();

	public Predstava(String naziv, Pozoriste pozoriste, Reditelj reditelj) {
		this.naziv = naziv;
		this.pozoriste = pozoriste;
		if (reditelj.getPozoriste().getId() == pozoriste.getId()) {
			zaposleni.add(reditelj);
		} else {
			System.out.println("Reditelj nije zaposlen u ovom pozoristu");
		}
	}

	public boolean dodaj(Glumac g) {
		if (g.getPozoriste().getId() != pozoriste.getId()) {
			System.out.println("Glumac nije zaposlen u pozoristu u kom se predstava odrzava");
			return false;
		}
		zaposleni.add(g);
		return true;
	}

	public boolean dodaj(Kostimograf k) {
		int brojKost = 0;
		if (k.getPozoriste().getId() != pozoriste.getId()) {
			System.out.println("Kostimograf nije zaposlen u pozoristu u kom se predstava odrzava");
			return false;
		}
		for (int i = 0; i < zaposleni.size(); i++) {
			if (zaposleni.get(i) instanceof Kostimograf) {
				brojKost++;
			}
		}
		if (brojKost == 2) {
			return false;
		} else {
			zaposleni.add(k);
			return true;
		}
	}

	public String getNaziv() {
		return naziv;
	}

	public Pozoriste getPozoriste() {
		return pozoriste;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		boolean imaRezisera = false;
		for (int i = 0; i < zaposleni.size(); i++) {
			if (zaposleni.get(i) instanceof Reditelj) {
				imaRezisera = true;
			}
		}
		if (!imaRezisera) {

			return "Predstava nema rezisera";
		}
		sb.append(naziv + ":\n");
		for (int i = 0; i < zaposleni.size(); i++) {
			if (i != zaposleni.size() - 1)
				sb.append("\t" + zaposleni.get(i) + "\n");
			else
				sb.append("\t" + zaposleni.get(i));
		}
		return sb.toString();
	}

}
