package sqljavaosobe;

public class Datum {

	private int dan;
	private int mesec;
	private int godina;

	public Datum(int dan, int mesec, int godina) {
		super();
		this.dan = dan;
		this.mesec = mesec;
		this.godina = godina;
	}
	
	public Datum(Datum d) {
		super();
		this.dan = d.dan;
		this.mesec = d.mesec;
		this.godina = d.godina;
	}

	public String uStringPlusNula (int a) {
		String aa = "";
		if ( a < 10) {
			aa = "0" + a;
		} else {
			aa = Integer.toString(a);
		}
		return aa;
	}
	
	@Override
	public String toString() {
		return uStringPlusNula(dan) + "." + uStringPlusNula(mesec) + "." + godina + ".";
	}

	public int getDan() {
		return dan;
	}

	public int getMesec() {
		return mesec;
	}

	public int getGodina() {
		return godina;
	}
	
	public String datumBezTacke () {
		return uStringPlusNula(dan) + uStringPlusNula(mesec) + godina;	
	}
	
	public static Datum datumIzStringa (String s) {
		int dann = Integer.parseInt(s.substring(0, 2));
		int mesecc = Integer.parseInt(s.substring(3, 5));
		int godinaa = Integer.parseInt(s.substring(6, 10));
		Datum d = new Datum(dann, mesecc, godinaa);
		return d;
	}

}
