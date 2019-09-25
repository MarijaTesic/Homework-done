package sqljavaosobe;

public abstract class Osoba {

	protected String ime;
	protected String prezime;
	protected String adresa;

	public Osoba(String ime, String prezime, String adresa) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
	}

	public Osoba(Osoba a) {
		super();
		this.ime = a.ime;
		this.prezime = a.prezime;
		this.adresa = a.adresa;
	}

	@Override
	public String toString() {
		return "Ime: " + ime + ", Prezime: " + prezime + ", Adresa:" + adresa;
	}

	public abstract int numeroloskiBroj();

	public abstract String metabolizam(final Datum d);
	
	public int zbirCifri(int a) {
		int zbirCifri = 0;
		while (a > 0) {
			zbirCifri += a % 10;
			a /= 10;
		}
		return zbirCifri;
	}
}
