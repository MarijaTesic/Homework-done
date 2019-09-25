package pozoriste;

import java.util.ArrayList;

public class Repertoar {
	private Pozoriste pozoriste;
	private ArrayList<Predstava> predstave;

	public Repertoar(Pozoriste p) {
		this.pozoriste = p;
		predstave = new ArrayList<Predstava>();
	}

	public void dodaj(Predstava predstava) {
		predstave.add(predstava);
	}

	public void ukloni(String imePredstave) {
		for (int i = 0; i < predstave.size(); i++) {
			if (predstave.get(i).getNaziv().equals(imePredstave)) {
				predstave.remove(i);
				break;
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(pozoriste.getNaziv() + ": [\n");
		for (int i = 0; i < predstave.size(); i++) {

			sb.append(predstave.get(i) + "\n");

		}
		sb.append("]");
		return sb.toString();
	}
}
