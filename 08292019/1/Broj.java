package domaci08292019;

public class Broj extends Izraz {
	private int vrednost;

	public Broj(int vrednost) {
		this.vrednost = vrednost;
	}

	public int getvrednost() {
		return vrednost;
	}

	public void setvrednost(int vrednost) {
		this.vrednost = vrednost;
	}

	public double izracunaj() {
		return vrednost;
	}

	public String toString() {
		return "Broj ima vrednost: " + vrednost;
	}

}
