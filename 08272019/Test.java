package domaci08272019;


import java.time.LocalDate;
import java.time.Month;

public class Test {
    public static void main(String[] args) {
        Album love_supreme = new Album("A Love Supreme", "John Coltrane", LocalDate.of(1965,Month.JANUARY,12));

        love_supreme.dodaj("Part I: Acknowledgement", "7:42");
        love_supreme.dodaj("Part II: Resolution", "7:19");
        love_supreme.dodaj("Part III: Pursuance", "10:41");
        love_supreme.dodaj("Part IV: Psalm", "7:02");

        Album animals = new Album("Animals", "Pink Floyd", LocalDate.of(1977, Month.JANUARY,23));
        animals.dodaj("Pigs on the wing 1","1:25");
        animals.dodaj("Dogs", "17:05");
        animals.dodaj("Pigs (Three diffrent ones)","11:26");
        animals.dodaj("Sheep","10:18");
        animals.dodaj("Pigs on the wing 2","1:28");

        Prodavnica p = new Prodavnica("MusicShop", "Koltrejnova 7");
        p.dodaj(new LP(love_supreme,"Imuplse! Records",2750, 0, 120));
        p.dodaj(new LP(love_supreme,"Imuplse! Records",3110, 7, 180));
        p.dodaj(new CD(love_supreme,"Imuplse! Records",1500, 40));

        p.dodaj(new LP(animals,"Pink Floyd Records",2500, 7, 120));
        p.dodaj(new CD(animals,"Pink Floyd Records",1250, 30));

        System.out.println(p+"");

        simulacija(p, "Pink Floyd");
        simulacija(p, "David Bowie");
        simulacija(p, "colTrane");

        System.out.println(p);
    }
    public static void simulacija(Prodavnica p, String zelja) {
        System.out.println("-- Kupac ulazi u radnju --");
        System.out.println("Kupac: Dobar dan! Želeo bih da kupim nesto od " + zelja + "-a!");
        Artikal[] ponuda = p.pretrazi(zelja);
        if(ponuda.length==0) {
            System.out.println("Prodavac: Nažalost nemamo to u ponudi :(");
            System.out.println("Kupac: Ih prava šteta, vidimo se neki drugi put!");
        }else {
            System.out.println("Prodavac: Pozdrav, od " + zelja + "-a imamo u ponudi: ");
            for(int i=0;i<ponuda.length;i++)
                System.out.println("  " + ponuda[i]);

            boolean kupio = false;
            int kolicina = 0;
            while(ponuda.length>0 && !kupio && ponuda[0]!=null) {
                System.out.println("Kupac: Kupiću -- " + ponuda[0].ime());
                kupio = ponuda[0].kupi();
                if(!kupio) {
                    System.out.print("Prodavac: ");
                    System.err.println("Nažalost nemamo traženi artikal trenutno :(");
                    ponuda[0] = null;
                }
            }
            if(kupio) {
                System.out.println("Prodavac: Izvolite!");
                System.out.println("Kupac: Hvala lepo! Vidimo se sledeceg meseca kad legne plata!");
            }else {
                System.out.println("Kupac: Ih baš šteta! Vidimo se za nedelju dana!");
            }
        }
        System.out.println();
    }
}
