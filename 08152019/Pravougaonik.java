package klasedomaci;

public class Pravougaonik {


	private double a;
	private double b;
	private String ime;
	private double p;
	private double o;
	
	public Pravougaonik(double a,double b,String ime) {
		this.a=a;
		this.b=b;
		this.ime=ime;
	
	}
	
	public Pravougaonik(double a,String ime) {
		this.a=a;
		this.ime=ime;
	}
	
	public double getA() {
		return a;
	}
	public double getB() {
		return b;
	}
	public String getIme() {
		return ime;
	}
	public void setA(double a) {
		this.a=a;
	}
	public void setB(double b) {
		this.b=b;
	}
	public void setIme(String ime) {
		this.ime=ime;
	}
	public double izracunajObim() {
		double o=(a+b)*2;
		return o;
	}
	
	public double izracunajPovrsina() {
		double p=a*b;
		return p;
	}
	
	public String ispisiPravougaonik() {
		double p=izracunajPovrsina();
		double o=izracunajObim();
		String ispis="";
		ispis+="Pravougaonik! "+ "\nDuzina prve stranice je: "+a+"\nDuzina druge stranice je: "+b;
		ispis+="\nPovrsina pravougaonika je: "+p+"\nObim pravougaonika je: "+o;
			
		return ispis;
	}

}
