package domaci;

import java.util.Scanner;

public class StringPalindrom {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite vrednost stringa: ");
		String s=sc.nextLine();
		s = s.toLowerCase();
		boolean dalije = dalijePalindrom(s);
		if(dalije == true)System.out.println("Jeste");
		else System.out.println("Nije");

		}

		static boolean dalijePalindrom(String s){
		int i = 0;
		int j = s.length()-1;
		for(;i<j; i++,j--){
		if(s.charAt(i) != s.charAt(j))return false;
		}
		return true;
		}

	}


