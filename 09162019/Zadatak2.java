package domaci;

import java.util.HashMap;

public class Zadatak2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] niz = {2,3,5,4,5,2,4,3,5,2,4,4,2};
		int rezultat = neparnoPonavaljanje(niz);
		if (rezultat == Integer.MIN_VALUE) {
			System.out.println("Nijedan se ne ponavlja neparan broj");
		} else {
			System.out.println(neparnoPonavaljanje(niz));
		}
		
	}
	
	public static int  neparnoPonavaljanje(int [] niz) {
	HashMap<Integer, Integer> mapa = new HashMap<Integer, Integer>();
	for (int i=0; i<niz.length; i++) {
		if (mapa.containsKey(niz[i])) {
			mapa.put(niz[i], mapa.get(niz[i]) + 1);
		}
		else mapa.put(niz[i], 1);
	}
	for(int n: mapa.keySet()) {
		if(mapa.get(n) % 2 != 0) {
			return n;
		}
	}
	return Integer.MIN_VALUE;
	}

}
