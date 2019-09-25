package klasedomaci;

public class TestPravougaonika {

	public static void main(String[] args) {
		
		Pravougaonik p1=new Pravougaonik(5,5,"Pravougaonik");
		Pravougaonik p2=new Pravougaonik(5,"Pravougaonik");
		
		System.out.println(p1.getA());
		System.out.println(p1.getB());
		
	
		System.out.println(p1.ispisiPravougaonik());

	}

}
