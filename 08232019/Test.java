package domaci2308;

public class Test {

	public static void main(String[] args) {
		ListPapira lp=new ListPapira(1,"maki");
		ListPapira lp2=new ListPapira(2,"maki");
		ListPapira lp3=new ListPapira(3,"maki");
		ListPapira lp4=new ListPapira(4,"maki");
		ListPapira lp5=new ListPapira(5,"maki");
		ListPapira lp6=new ListPapira(6,"maki");
		
		Knjiga k=new Knjiga("Orlovi rano lete");
		Knjiga k1=new Knjiga("Tom Sojer");
		
		k.dodaj(lp);
		k.dodaj(lp2);
		k.dodaj(lp3);
		k1.dodaj(lp4);
		k1.dodaj(lp5);
		k1.dodaj(lp6);
		
		Police p=new Police();
		p.dodajKnjigu(k);
		p.dodajKnjigu(k1);
		
		System.out.println(p);

	}

}
