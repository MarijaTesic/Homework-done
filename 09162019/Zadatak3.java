package domaci;

import java.util.ArrayList;
import java.util.HashMap;

public class Zadatak3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> deca = new ArrayList<String>();
		deca.add("Pera");
		deca.add("Mika");
		deca.add("Zika");
		deca.add("Laza");
		deca.add("Pera");
		
		ArrayList<String> dobraDeca = new ArrayList<String>();
		dobraDeca.add("Zika");
		dobraDeca.add("Laza");
		dobraDeca.add("Zika");
		dobraDeca.add("Mika");
		dobraDeca.add("Mika");
		dobraDeca.add("Mika");
		dobraDeca.add("Mika");
		dobraDeca.add("Mika");
		dobraDeca.add("Pera");
		
		HashMap<String, Integer> rezultat = viseOdJednogDobrogDela(deca, dobraDeca);
		System.out.println("Deca koja imaju vise od 1 dobrog dela: ");
		for(String s: rezultat.keySet()) {
			if(rezultat.get(s) > 1) {
				System.out.println(s + ", broj dobrih dela: " + rezultat.get(s));
			}
		}
	}
	public static HashMap<String, Integer> viseOdJednogDobrogDela(ArrayList<String> svaDeca, ArrayList<String> dobraDeca) {
		HashMap<String, Integer> decaDobraDelaMapa = new HashMap();
		for(String s: svaDeca) {
			decaDobraDelaMapa.put(s, 0);
		}
		for(String s: dobraDeca) {
			if(decaDobraDelaMapa.containsKey(s)) {
				decaDobraDelaMapa.put(s, decaDobraDelaMapa.get(s) + 1);
			} 
		}
		return decaDobraDelaMapa;
	}

}
