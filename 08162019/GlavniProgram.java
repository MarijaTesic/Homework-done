import java.util.Random;

public class GlavniProgram {


	public static void main(String [] args){
		Tacka[] nizTacka = new Tacka[10];

		for(int i = 0; i<nizTacka.length; i++){
			Random r = new Random();
			int x = r.nextInt(10);
			int y = r.nextInt(10);
			Tacka t = new Tacka(x, y);

			nizTacka[i] = t;
		}

		Trougao t1 = new Trougao(nizTacka[0], 10, 12, 14);
		Trougao t2 = new Trougao(nizTacka[1], 15, 17, 19);
		Trougao t3 = new Trougao(nizTacka[2], 19, 21, 22);

		System.out.println(t1.ispis());
		if(t2.jednokraki()==true){
			System.out.println("Jeste jednakokraki");
		}
		else{
			System.out.println("Nije jednakokraki");
		}

		Trougao t4 = new Trougao(nizTacka[1], 22, 22, 22);
		if(t2.jednakeTacke(t4)==true){
			System.out.println("Jesu jednake tacke");
		}
		else {
			System.out.println("Nisu jednake tacke");
		}
	}


}
