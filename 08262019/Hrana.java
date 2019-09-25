package domaciklasesestanedelja;

public class Hrana extends Namirnica {
	private double tezina;
	private double belancevine;
	private double masti;
	private double ugljHidrati;
	private final double BELANCEVINEkJ = 16.7;
	private final double MASTIkJ = 37.6;
	private final double UGLJENIHIDRATIkJ = 17.2;

	public Hrana(String ime, double tezina, double belancevine, double masti, double ugljHidrati) {
		super(ime);
		this.tezina = tezina;
		this.belancevine = belancevine;
		this.masti = masti;
		this.ugljHidrati = ugljHidrati;
	}

	public double getMasti() {
		return masti;
	}

	public double getTezina() {
		return tezina;
	}

	public double getBelancevine() {
		return belancevine;
	}

	public double getUgljHidrati() {
		return ugljHidrati;
	}

	public double energVr() {
		double b = tezina * (belancevine / 100) * BELANCEVINEkJ;
		double m = tezina * (masti / 100) * MASTIkJ;
		double uH = tezina * (ugljHidrati / 100) * UGLJENIHIDRATIkJ;
		return b + m + uH;

	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append("(" + tezina + "g" + ", " + energVr() + "kJ)");
				
		return sb.toString();
	}

}

