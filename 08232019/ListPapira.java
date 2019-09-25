package domaci2308;

public class ListPapira {
	private int redniBr;
	private String tekst;
	public ListPapira(int redniBr, String tekst) {
		this.redniBr = redniBr;
		this.tekst = tekst;
	}
	public int getRedniBr() {
		return redniBr;
	}
	
	public static boolean poredjenje(ListPapira a, ListPapira b) {  
		//vraca true ako je prvi veci od drugog
		return a.redniBr>=b.redniBr;
	}
	public boolean poredjenje(ListPapira a) {
		return this.redniBr>=a.redniBr;
	}
	//ova dva booleana rade isto, samo sto je jedna
	//staticka, a druga nestaticka metoda
	
	
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	
	public String getTekst() {
		return tekst;
	}
	@Override
	public String toString() {
		return tekst + "(" + redniBr + ")";
	}
	
	
	

}
