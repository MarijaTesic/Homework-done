package domaci2308;

import java.util.Arrays;

public class Police {
	private Knjiga [] knjige;
	private int brKnjiga;

	public Police() {
		brKnjiga=0;
		knjige=new Knjiga[10];
		

	}
	public void dodajKnjigu(Knjiga k) {
		if(brKnjiga==knjige.length) {
			System.out.println("Polica je popunjena");
			return;

		}
		
			knjige[brKnjiga]=k;
			brKnjiga++;
	}
	public Knjiga uzimanjeKnjige(Knjiga k) {
		int i;
		for(i=0; i<brKnjiga;i++) {
			if(k.equals(knjige[i].getNaziv())) {
				System.out.println("Knjiga sa nazivom " +k+ "nalazi se na polici"
						+ "na mestu " +(i+1)+ ".");
				return knjige[i];
			}
		}
			System.out.println("Uzeli ste knjigu");
			return null;
	}
	@Override
	public String toString() {
		String ispis="";
		for(int i=0; i<brKnjiga;i++) {
			ispis+=knjige[i].toString();
	
		}
		return ispis;
	}
	
}
