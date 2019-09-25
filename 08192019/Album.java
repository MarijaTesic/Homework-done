package klasedomaci;

import java.util.Date;

public class Album {

	private String naziv;
	private String izvodjac;
	private Date datum;
	private MuzickaNumera[] nizPesama;
	private int brPesama;

	public Album(String naziv, String izvodjac, Date datum) {
		this.naziv = naziv;
		this.izvodjac = izvodjac;
		this.datum = datum;
		this.nizPesama = new MuzickaNumera[5];
		brPesama = 0;

	}

	public void dodaj(MuzickaNumera pesma) {
		if (brPesama < nizPesama.length) {
			nizPesama[brPesama++] = pesma;
		} else {
			MuzickaNumera[] nizPesama2 = new MuzickaNumera[2 * nizPesama.length];
			for (int i = 0; i < nizPesama.length; i++) {
				nizPesama2[i] = nizPesama[i];   //kopiranje elemenata starog niza u novi niz
			}
			nizPesama = nizPesama2;
			nizPesama[brPesama] = pesma;
			brPesama++;
			}
	}

	void dodaj(String name, String trajanje) {
		MuzickaNumera pesma = new MuzickaNumera(name, izvodjac, trajanje);
		dodaj(pesma);
	}

	public String getNaziv() {
		return naziv;
	}

	public String getIzvodjac() {
		return izvodjac;
	}

	public String getTrajanje() {
		int sek = 0;
		int minuti = 0;
		for (int i = 0; i < brPesama; i++) {
			String trajanje = nizPesama[i].getTrajanje();// 3:43
			String[] niz = trajanje.split(":");
			String procitaneSekunde = niz[1];
			String procitaniMinuti = niz[0];
			int procitaneSekundeInteger = Integer.parseInt(procitaneSekunde);
			int procitaniMinutiInteger = Integer.parseInt(procitaniMinuti);

			sek += procitaneSekundeInteger;
			if (sek >= 60) {
				minuti = minuti + 1;
				sek = sek - 60;
			}
			minuti += procitaniMinutiInteger;
		}//15:55
		String minutiString = Integer.toString(minuti);
		String sekundeString = Integer.toString(sek);
		String ukupnoTrajanje = minutiString + ":" + sekundeString;
		return ukupnoTrajanje;
	}

	public Date getDatum() {
		return datum;

	}

	public MuzickaNumera getMuzickaNumera(int index) {
		return nizPesama[index];
	}

	public MuzickaNumera getMuzickaNumera(String ime) {
		for (int i = 0; i < brPesama; i++) {
			String nazivPesma = nizPesama[i].getNaziv();
			if (nazivPesma.equals(ime))
				return nizPesama[i];
		}
		return null;
	}

	public String toString() {
		String ispis = "";
		ispis += izvodjac;
		ispis += " - ";
		ispis += naziv;
		ispis += "(" + datum + ")[";
		for (int i = 0; i < brPesama; i++) {
			MuzickaNumera pesma = nizPesama[i];
			ispis += "\n \t";
			ispis += izvodjac + " - " + pesma.getNaziv() + ": " + pesma.getTrajanje();
		}
		ispis += "\n]: " + getTrajanje();
		return ispis;
	}
}