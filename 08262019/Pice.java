package domaciklasesestanedelja;

public class Pice extends Namirnica{
	private double kolicina;
	private double enVr;
	
	public Pice (String ime, double kolicina, double enVr) {
		super (ime);
		this.kolicina = kolicina;
		this.enVr = enVr;
	}

	public double getKolicina() {
		return kolicina;
	}
	
	public double energVr() {
		return enVr * kolicina;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append("(" + kolicina + "l" + ", " + energVr() + "kJ)");
				
		return sb.toString();
	}
}
