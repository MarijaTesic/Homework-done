package domaci08292019;

public abstract class BinarnaOperacija extends Izraz {
	protected Izraz levi;
	protected Izraz desni;

	public BinarnaOperacija(Izraz levi, Izraz desni) {
		this.levi = levi;
		this.desni = desni;
	}

	public Izraz getLevi() {
		return levi;
	}

	public Izraz getDesni() {
		return desni;
	}

	public abstract double izracunaj();
}
