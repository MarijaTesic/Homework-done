package domaci08292019;

public class Promenljiva extends Izraz {
	private String ime;
	private double vrednost;

	public Promenljiva(String ime, double vrednost) {
		super();
		this.ime = ime;
		this.vrednost = vrednost;
	}

	public double izracunaj() {
		return vrednost;
	}

	public String toString() {
		return "Promenljiva " + ime + " ima vrednost: " + vrednost;
	}

}
