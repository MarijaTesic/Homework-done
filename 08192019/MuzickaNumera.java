package klasedomaci;

public class MuzickaNumera {
	
	private String naziv;
	private String izvodjac;
	private String trajanje;
	
	
	public MuzickaNumera(String naziv, String izvodjac, String trajanje) {
		this.naziv = naziv;
		this.izvodjac = izvodjac;
		this.trajanje = trajanje;
	}


	public String getNaziv() {
		return naziv;
	}


	public String getIzvodjac() {
		return izvodjac;
	}


	public String getTrajanje() {
		return trajanje;
	}
	
	
	
	

}
