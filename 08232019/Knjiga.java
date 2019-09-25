package domaci2308;

import java.util.Arrays;

public class Knjiga {
	private String naziv;
	private ListPapira [] straniceKnjige;
	private int brojListova=0;
	
	public Knjiga(String naziv) {
		this.naziv = naziv;
		straniceKnjige=new ListPapira[6];
	}
	
	public void dodaj(ListPapira lp) {   //umesto da dodam kao promenljivu redniBr
		if(lp.getRedniBr()<0)           //pozvala sam ovde getRedniBr()
			return;
		
		if(brojListova>=straniceKnjige.length) {
			ListPapira[]temp=new ListPapira[straniceKnjige.length];
			int i=0;
			for(ListPapira l: straniceKnjige) {     //for each petlja
				temp[i]=l;
				i++;
				
			}
			straniceKnjige=temp;
		}
		straniceKnjige[brojListova]=lp;
		brojListova++;
	}
	

	public String getNaziv() {
		return naziv;
	}

	public int getBrojListova() {
		return brojListova;
	}
	
	public ListPapira dohvati(int redniBr) {
	   if(redniBr<0 || redniBr>=straniceKnjige.length)
				return null;
			return straniceKnjige[redniBr];
		
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(naziv).append("\n");
		for(ListPapira lp:straniceKnjige) {
			if(lp == null)
				break;
			sb.append(lp).append("\n");
		}
		return sb.toString();
	}
	
	
	
	

}
