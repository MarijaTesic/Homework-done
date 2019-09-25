package tovar;

public abstract class Tovar {

	public abstract String vrsta();

	public abstract double tezina();

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(vrsta() + "(" + tezina() + ")");
		return sb.toString();
	}
}
