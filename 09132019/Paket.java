package tovar;

import java.util.ArrayList;

public class Paket extends Tovar {
	private ArrayList<Tovar> listaTovara;

	public Paket() {
		listaTovara = new ArrayList<Tovar>();
	}

	@Override
	public String vrsta() {
		// TODO Auto-generated method stub
		return "paket";
	}

	@Override
	public double tezina() {
		// TODO Auto-generated method stub
		double tezina = 0;
		for (Tovar t : listaTovara) {
			tezina += t.tezina();
		}
		return tezina;
	}

	public void dodaj(Tovar t) {
		if (t == null) {
			return;
		} else
			listaTovara.add(t);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(vrsta() + "[");
		for (int i = 0; i < listaTovara.size(); i++) {
			if (i == listaTovara.size() - 1) {
				sb.append(listaTovara.get(i).vrsta() + "(" + tezina() + ")");
			} else
				sb.append(listaTovara.get(i).vrsta() + ",");
		}
		sb.append("]");
		return sb.toString();
	}

}
