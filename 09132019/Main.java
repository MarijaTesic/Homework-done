package tovar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kamion kam = new Kamion("BG 123-4567", 5000);
		kam.stavi(new Predmet("secer", 500));
		Paket p = new Paket();
		p.dodaj(new Predmet("radio", 3));
		p.dodaj(new Predmet("tv", 10));
		kam.stavi(p);
		kam.stavi(new Predmet("brasno", 300));
		System.out.println(kam);

	}

}
