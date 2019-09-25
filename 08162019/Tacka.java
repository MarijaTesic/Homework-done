public class Tacka {

	private double x;
	private double y;

	public Tacka(double x, double y) {
		this.x = x;
		this.y = y;

	}

	public double getX() {
		return x;
	}

	public double getY() {
			return y;
	}

	public String ispisiXY() {
		String ispis = "(";
		ispis += x + "," + y + ")";
		return ispis;
	}

	public boolean jednako(Tacka t2) {
		if (x == t2.getX() && y == t2.getY())
			return true;
		else
			return false;
	}


}
