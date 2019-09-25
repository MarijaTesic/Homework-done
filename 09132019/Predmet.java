package tovar;

public class Predmet extends Tovar {
	private String vrsta;
	private double tezina;

	public Predmet(String vrsta, double tezina) {
		this.vrsta = vrsta;
		this.tezina = tezina;
	}

	@Override
	public String vrsta() {
		// TODO Auto-generated method stub
		return vrsta;
	}

	@Override
	public double tezina() {
		// TODO Auto-generated method stub
		return tezina;
	}

}
