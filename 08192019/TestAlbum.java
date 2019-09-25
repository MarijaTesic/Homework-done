package klasedomaci;

import java.util.Date;

public class TestAlbum {

	public static void main(String[] args) {
		Album love_supreme = new Album("A Love Supreme", "John Coltrane", new
				Date(1965,1,12));
				love_supreme.dodaj("Part I: Acknowledgement", "7:42");
				love_supreme.dodaj("Part II: Resolution", "7:19");
				love_supreme.dodaj("Part III: Pursuance", "10:41");
				love_supreme.dodaj("Part IV: Psalm", "7:02");
				Album animals = new Album("Animals", "Pink Floyd", new Date(1977,1,23));
				animals.dodaj("Pigs on the wing 1","1:25");
				animals.dodaj("Dogs", "17:05");
				animals.dodaj("Pigs (Three diffrent ones)","11:26");
				animals.dodaj("Sheep","10:18");
				animals.dodaj("Pigs on the wing 2","1:28");
				System.out.println(love_supreme);
				System.out.println(animals);
				}
				

	}


