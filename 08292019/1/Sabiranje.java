package domaci08292019;

public class Sabiranje extends BinarnaOperacija {

	public Sabiranje(Izraz levi, Izraz desni) {
		super(levi, desni);
	}

	public double izracunaj() {
		return levi.izracunaj() + desni.izracunaj();
	}

	public String toString() {
		return "Rezultat sabiranja " + levi.izracunaj() + " i " + desni.izracunaj() + " je " + izracunaj();
	}

}
