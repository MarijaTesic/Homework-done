package domaciklasesestanedelja;

public class Meni {
	private Namirnica[] niz;
	private int brNam;

	public Meni(int kapacitet) {
		niz = new Namirnica[kapacitet];
		this.brNam = 0;
	}

	public boolean dodaj(Namirnica n) {
		if (brNam == niz.length) {
			return false;
		}
		niz[brNam] = n;
		brNam++;
		return true;
	}

	public double energVr() {
		double zbir = 0;
		for (int i = 0; i < niz.length; i++) {
			if(niz[i] != null) {
				zbir += niz[i].energVr();
			}
		}
		return zbir;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Meni (" + energVr() + "kJ): \n");
		for (int i = 0; i < niz.length; i++) {
			if(niz[i] != null) {
				sb.append(niz[i] + "\n");
			}
		}

		return sb.toString();

	}

}
