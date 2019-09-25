package domaci08272019;

public class Prodavnica {
    private String ime;
    private String lokacija;
    private Artikal[] inventar;
    private int brojac = 0;

    public Prodavnica(String ime, String lokacija) {
        this.ime = ime;
        this.lokacija = lokacija;
        this.inventar=new Artikal[10];
        this.brojac = 0;
    }

    public void dodaj(Artikal artikal) {
        if (brojac < inventar.length) {
            inventar[brojac] = artikal;
            brojac++;
        } else {
            Artikal[] noviNiz = new Artikal[2*inventar.length ];
            for (int i = 0; i < inventar.length; i++) {
                noviNiz[i] = inventar[i];
            }
            inventar = noviNiz;
            inventar[brojac] = artikal;
            brojac++;
        }
    }

    public void kupi(int idArtikla) {
        for (int i = 0; i <brojac ; i++) {
            if(inventar[i].getId() == idArtikla) {
                inventar[i].kupi();
                return;
            }
        }
    }
    public Artikal[] pretrazi(String tekst){
        int br=0;
        for (int i = 0; i <brojac ; i++) {
            if(inventar[i].ime().toLowerCase().contains(tekst.toLowerCase()))
                br++;
        }
        Artikal[] lista = new Artikal[br];
        br = 0;
        for (int i = 0; i <brojac ; i++) {
            if(inventar[i].ime().toLowerCase().contains(tekst.toLowerCase()))
                lista[br++]=inventar[i];
        }

        return lista;
    }
    public String toString() {
        String buffer = String.format("%s: %s [", ime, lokacija);
        for (int i = 0; i < brojac; i++) {
            buffer += String.format("\n\t%s", inventar[i].toString());
        }
        buffer+="\n]";
        return buffer;
    }
}
