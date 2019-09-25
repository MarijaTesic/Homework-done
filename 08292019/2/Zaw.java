package domaci08292019drugi;

public class Zaw extends Blok {

	public Zaw(int n) {
		super(n);
		kockice[0][1] = '\u2588';
		kockice[1][0] = '\u2588';
		kockice[1][1] = '\u2588';
		kockice[2][0] = '\u2588';
	}

	public String toString() {
		return super.toString();
	}

}
