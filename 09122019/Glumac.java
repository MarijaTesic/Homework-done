package pozoriste;

public class Glumac extends Zaposleni {

	public Glumac(String ime, Pozoriste pozoriste) {
		super(ime, pozoriste);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String imePosla() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName();
	}

	@Override
	public char getOznaka() {
		return imePosla().charAt(0);
	}
}
