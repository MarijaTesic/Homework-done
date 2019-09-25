package sqljavaosobe;

public class OsobaJMBG extends Osoba {

	private String jmbg;

	public OsobaJMBG(String jmbg, String ime, String prezime, String adresa) {
		super(ime, prezime, adresa);
		this.jmbg = jmbg;
	}

	public OsobaJMBG(OsobaJMBG a) {
		super(a.adresa, a.prezime, a.ime);
		this.jmbg = a.jmbg;
	}

	public String toString() {
		return super.toString() + ", JMBG: " + jmbg;
	}

	@Override
	public int numeroloskiBroj() {
		int suma = 1;
		for (int i = 0; i < 7; i++) {
			suma += Character.getNumericValue(jmbg.charAt(i));
		}
		int numBr = zbirCifri(suma);
		return numBr;
	}
	
	public String datumRodjenjaIzJmbg () {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 7; i++) {
			if ( i == 4) {
				sb.append('1');
			}
			sb.append(jmbg.charAt(i));
		}
		return sb.toString();
		
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
			a += Character.getNumericValue(d.datumBezTacke().charAt(i)) + Character.getNumericValue(datumRodjenjaIzJmbg().charAt(i));
			if ( a >= 10) {
				prenosIzSabiranja = true;
			}
			sb.append(a%10);	
		}
		sb.reverse();
		return sb.toString();
	}
	
}
