package klasedomaci;

public class Student {
	
	private String potpis;
	private String jmbg;
	private Ocena[] upisaneOcene;

	public Student(String potpis, String jmbg, Ocena[] upisaneOcene) {

		this.potpis = potpis;
		this.jmbg = jmbg;
		this.upisaneOcene = upisaneOcene;
	}

	public String getPotpis() {
		return potpis;
	}

	public void setPotpis(String potpis) {
		this.potpis = potpis;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public Ocena[] getUpisaneOcene() {
		return upisaneOcene;
	}

	public void setUpisaneOcene(Ocena[] upisaneOcene) {
		this.upisaneOcene = upisaneOcene;
	}

	public double getProsecnaOcena() {
		double zbir = 0;
		int brPrelaznih = 0;
		
		for (int i = 0; i < upisaneOcene.length; i++) {
			if (upisaneOcene[i].getOcena() > 5 ) {
				zbir += upisaneOcene[i].getOcena();
				brPrelaznih ++;
			}
		}
		return zbir/brPrelaznih;
	}
	
	public String getDatumRodjenja() {
		
		String milenijalac = "";
		
		if(getJmbg().charAt(4) == '0') {
			milenijalac = "2";
		}
		else {
			milenijalac = "1";
		}
		
		String datumRodj = getJmbg().substring(0, 2) + ".";
		datumRodj += getJmbg().substring(2, 4) + ".";
		datumRodj += milenijalac + getJmbg().substring(4, 7) + ".";
				
		return datumRodj;
	}
	
	public String getIme() {
		String[] p = potpis.split(" ");
		String ime = p[0];
		return ime;
		
	}
	
	public String getPrezime() {
		String[] p = potpis.split(" ");
		String prezime = p [1];
		return prezime;
	}
	
	public String najboljaOcena() {
		int max = 0;
		Predmet maxPredmet = null;
		
		for (int i = 0; i < upisaneOcene.length; i++) {
			if (max <= upisaneOcene[i].getOcena()) {
				max = upisaneOcene[i].getOcena();
				maxPredmet = upisaneOcene[i].getPr();
			}
			
		}
		return maxPredmet.getIme();
	}
	
	static boolean starijiOd(Student s, int god) {
		String godinaRodjenja = s.getDatumRodjenja().substring(6, 10);
		int godS = 2019 - Integer.parseInt(godinaRodjenja);
		if (godS > god) {
			return true;
		}
		else return false;
	}
	
	static Student[] prosekVeciOd(Student[] nizStudenata, double ocena) {
		Student[] veci = new Student[nizStudenata.length];
		int brojac = 0;
		
		for (int i = 0; i < nizStudenata.length; i++) {
			if (nizStudenata[i] != null && ocena < nizStudenata[i].getProsecnaOcena()) {
				veci[brojac] = nizStudenata[i];
				brojac++;
			}
		}
		
		Student[] rezultat = new Student[brojac];	
		for(int i = 0; i < rezultat.length; i++) {
			rezultat[i] = veci[i];
		}
		
		return rezultat;
		
	}
	
}
