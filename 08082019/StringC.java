package domaci;

import java.util.Scanner;

public class StringC {

	public static void main(String[] args) {
		// Написати функциjу коjа броjи колико пута jе поновљен карактер c у String-у s
		//Потпис функциjе: static int brojKaraktera(String s, char c)

		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite vrednost stringa: ");
		String s=sc.nextLine();
		System.out.println("Unesite karakter koji zelite da proverite: ");
		String unos2 = sc.nextLine(); //procitam string koji korisnik unese
		char c = unos2.charAt(0); //iz tog string izvucem char koji se nalazi na prvom mestu

		int brojKaraktera = brojKaraktera(s, c);
		System.out.println("Broj karaktera je " + brojKaraktera);
		}

		static int brojKaraktera(String s, char c){
		int broj = 0;
		for(int i = 0; i<s.length(); i++){
		if(s.charAt(i) == c)broj++;
		}
		return broj;
		}

	
		
	}

