package domaciklasesestanedelja;

abstract class Namirnica extends Energent {
	protected String ime;
	private static int globalID = 1;
	protected int id;
	
	public Namirnica (String ime) {
		this.ime = ime;
		this.id = globalID;
		globalID++;
	}
	
	public String getIme() {
		return ime;
	}

	public int getId() {
		return id;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[" + id + "] " + ime);
				
		return sb.toString();
	}
	
	public abstract double energVr();

}
