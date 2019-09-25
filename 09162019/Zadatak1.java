package domaci;

import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeMap;

public class Sortiranje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> mapa = new HashMap<String, Integer>();
		mapa.put("Aleksa", 23);
		mapa.put("Bilja", 1);
		mapa.put("Jovica", 35);
		mapa.put("Katarina", 20);
		mapa.put("Svetlana", 19);
		printSortedHashMap(mapa);
		

	}
	public static void printSortedHashMap(HashMap<String, Integer> mapa) {
		TreeMap<String, Integer> sortedMap = new TreeMap(mapa);
		for(String s: sortedMap.keySet()) {
			System.out.println(s + " " + sortedMap.get(s));
		}

	}
}
