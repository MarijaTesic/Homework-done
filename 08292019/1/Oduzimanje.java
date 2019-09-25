package domaci08292019;

public class Oduzimanje extends BinarnaOperacija {
	public Oduzimanje(Izraz levi, Izraz desni) {
		super(levi, desni);
	}

	public double izracunaj() {
		return levi.izracunaj() - desni.izracunaj();
	}

	public String toString() {
		return "Rezultat oduzimanja " + levi.izracunaj() + " i " + desni.izracunaj() + " je " + izracunaj();
	}

}
