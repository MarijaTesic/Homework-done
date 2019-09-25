package domaci08292019drugi;

public class SmashBoy extends Blok {
	
	public SmashBoy(int n) {
		super(n);
		kockice[0][0] = '\u2588';
		kockice[0][1] = '\u2588';
		kockice[1][0] = '\u2588';
		kockice[1][1] = '\u2588';
	}
	
	public String toString() {
		return super.toString();
	}

}
