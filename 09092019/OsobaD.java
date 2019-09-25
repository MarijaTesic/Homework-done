package sqljavaosobe;

public class OsobaD extends Osoba {

	private Datum datumRodjenja;

	public OsobaD(Datum datumRodjenja, String ime, String prezime, String adresa) {
		super(ime, prezime, adresa);
		this.datumRodjenja = datumRodjenja;
	}

	public OsobaD(OsobaD a) {
		super(a.adresa, a.prezime, a.ime);
		this.datumRodjenja = a.datumRodjenja;
	}

	@Override
	public String toString() {
		return super.toString() + ", Datum Rodjenja: " + datumRodjenja.toString();
	}

	@Override
	public int numeroloskiBroj() {
		int suma = zbirCifri(datumRodjenja.getDan()) + zbirCifri(datumRodjenja.getMesec())
				+ zbirCifri(datumRodjenja.getGodina());
		int numBr = zbirCifri(suma);
		return numBr;
	}

	@Override
	public String metabolizam(final Datum d) {
		StringBuilder sb = new StringBuilder();
		boolean prenosIzSabiranja = false;
		
		for ( int i = d.datumBezTacke().length()-1 ; i >= 0; i--) {
			int a = 0;
			if (prenosIzSabiranja) {
				a++;
				prenosIzSabiranja = false;
			}
			a += Character.getNumericValue(d.datumBezTacke().charAt(i)) + Character.getNumericValue(datumRodjenja.datumBezTacke().charAt(i));
			if ( a >= 10) {
				prenosIzSabiranja = true;
			}
			sb.append(a%10);	
		}
		sb.reverse();
		return sb.toString();
	}
}
