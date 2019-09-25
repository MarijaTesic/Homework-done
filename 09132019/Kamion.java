package tovar;

import java.util.ArrayList;

public class Kamion {
	private String regBroj;
	private ArrayList<Tovar> tovar;
	private double nosivost;
	private double teret;

	public Kamion(String regBroj, double nosivost) {
		tovar = new ArrayList<Tovar>();
		this.regBroj = regBroj;
		this.nosivost = nosivost;
	}

	public boolean stavi(Tovar t) {
		if (teret + t.tezina() > nosivost) {
			return false;
		} else {
			tovar.add(t);
			teret += t.tezina();
			return true;
		}
	}

	public void skini() {
		if (tovar.size() > 0) {
			teret -= tovar.get(tovar.size() - 1).tezina();
			tovar.remove(tovar.size() - 1);
		} else
			return;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(regBroj + "(" + teret + "/" + nosivost + ")\n");
		for (int i = 0; i < tovar.size(); i++) {
			sb.append(tovar.get(i) + "\n");
		}
		return sb.toString();
	}

}
