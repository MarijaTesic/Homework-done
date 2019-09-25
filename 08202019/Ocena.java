package klasedomaci;

public class Ocena {

	private int bodovi;
	private Predmet pr;
	int ocena;
	
	public Ocena(int bodovi, Predmet pr) {
		this.bodovi = bodovi;
		this.pr = pr;
	}

	public int getBodovi() {
		return bodovi;
	}

	public Predmet getPr() {
		return pr;
	}
	public int getOcena() {
		if(bodovi>91 && bodovi<101) 
			ocena=10;
		else if(bodovi>81 && bodovi<91)
				ocena=9;
		else if(bodovi>71 && bodovi<81)
				ocena=8;
		else if(bodovi>61 && bodovi<71)
				ocena=7;
		else if(bodovi>51 && bodovi<61)
				ocena=6;
		else {
			ocena=5;
		}
		return ocena;
			}
	
	
}
