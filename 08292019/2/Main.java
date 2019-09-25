package domaci08292019drugi;

public class Main {

	public static void main(String[] args) {
		SlimJim sj = new SlimJim(4);
		LeftGun lg = new LeftGun(3);
		RightGun rg = new RightGun(3);
		SmashBoy sb = new SmashBoy(2);
		Saw s = new Saw(3);
		s.rotacija();
		Zaw z = new Zaw(3);
		z.rotacija();
		Ted t = new Ted(3);
				
		System.out.println(sj);
		System.out.println(lg);
		System.out.println(rg);
		System.out.println(sb);
		System.out.println(s);
		System.out.println(z);
		System.out.println(t);
	}

}
