package domaci;

import java.util.Scanner;

public class NajduziPodstring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite vrednost stringa: ");
		String s=sc.nextLine();
		String najduzi = najduziSamoglasnici(s);
		System.out.println(najduzi);


		}

		static boolean jeSamoglasnik(char c){
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
		c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')return true;
		else return false;

		}

		static String najduziSamoglasnici(String s){
		String tekuci = "";
		String maximalni = "";

		for(int i = 0; i<s.length(); i++){
		if(jeSamoglasnik(s.charAt(i)) == true) {
		tekuci = tekuci + s.charAt(i);
		}
		else{
		if(tekuci.length() > maximalni.length()){
		maximalni = tekuci;
		}
		tekuci = new String();
		tekuci = "";
		}
		}
		return maximalni;
		}

	}


