package domaci08292019drugi;


public class Ted extends Blok {

	public Ted(int n) {
		super(n);
		kockice[1][1] = '\u2588';
		kockice[2][0] = '\u2588';
		kockice[2][1] = '\u2588';
		kockice[2][2] = '\u2588';
	}

	public String toString() {
		return super.toString();
	}
}
