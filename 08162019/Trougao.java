import java.util.Random;
import java.util.Scanner;

public class Trougao {

	private Tacka tacka;
	private double a;
	private double b;
	private double c;

	public Trougao(Tacka tacka, double a, double b,double c) {
		this.tacka = tacka;
		boolean validan = validnost(a, b, c);
		if(validan == true){
			this.a = a;
			this.b = b;
			this.c = c;
		}
		else{
			a=0;
			b=0;
			c=0;
			System.out.println("Nije validan");
		}
	}

	public boolean validnost(double str1,double str2,double str3) {
		if (str1 + str2 > str3 && str1 + str3 > str2 && str2 + str3 > str1) {
			return true;
		}
		else {
			System.out.println("Unos nije validan.");
			return false;
		}

	}

	public void setA(double a){
		if(validnost(a, b, c) == true){
			this.a = a;
		}
		else{
			System.out.println("Unos nije validan");
		}
	}

	public void setB(double b){
		if(validnost(a, b, c) == true){
			this.b = b;
		}
		else{
			System.out.println("Unos nije validan");
		}
	}

	public void setC(double c){
		if(validnost(a, b, c) == true){
			this.c = c;
		}
		else{
			System.out.println("Unos nije validan");
		}
	}

	public Tacka getTacka(){
		return tacka;
	}

	public boolean jednokraki() {
		if(a==b || a==c || b==c ) {
			return true;
		}
		else return false;

	}

	public double obim(){
		return a+b+c;
	}

	public double povrsina(){
		double s = obim()/2;
		double p = Math.sqrt(s*(s-a)*(s-b)*(s-c));
		return p;
	}

	public boolean jednakeTacke(Trougao t2){
		Tacka tackaTrougla2 = t2.getTacka();
		return tacka.jednako(tackaTrougla2);
	}

	public String ispis(){
		String s = "";
		s += "Trougao sa pocetkom u (" + tacka.getX() + ", " + tacka.getY() + "): \n";
		s += "Stranice trougla: " + a +" " + b + " " + c + "\n";
		s+= "Povrsina i obim: P = " + povrsina() + " O = " + obim();
		return s;
	}
}
