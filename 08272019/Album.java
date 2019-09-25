package domaci08272019;

import java.time.LocalDate;


public class Album {
    private String naziv;
    private String izvodjac;
    private LocalDate datum;
    private Numera[] lista;
    private int brojac;

    public Album(String naziv, String izvodjac, LocalDate datum) {
        this.naziv = naziv;
        this.izvodjac = izvodjac;
        this.datum = datum;
        this.brojac = 0;
        this.lista = new Numera[5];
    }

    void dodaj(Numera num) {
        if (brojac < lista.length) {
            lista[brojac] = num;
            brojac++;
        } else {
            Numera[] noviNiz = new Numera[2*lista.length ];
            for (int i = 0; i < lista.length; i++) {
                noviNiz[i] = lista[i];
            }
            lista = noviNiz;
            lista[brojac] = num;
            brojac++;
        }
    }
    void dodaj(String name, String trajanje) {
        this.dodaj(new Numera(name,izvodjac,trajanje));
    }

    public String getNaziv() {
        return naziv;
    }

    public String getIzvodjac() {
        return izvodjac;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public String getTrajanje() {
        int trajanje = 0;
        for(int i=0;i<lista.length;i++) {
            String[] razbijeno = lista[i].getTrajanje().split(":");
            trajanje += Integer.parseInt(razbijeno[0])*60 + Integer.parseInt(razbijeno[1]);
        }
        return String.format("%d:%d", trajanje/60, trajanje%60);
    }

    public Numera getNumera(int index) {
        return lista[index];
    }
    public Numera getNumera(String ime) {
        for(int i=0;i<lista.length;i++) {
            if(lista[i].getNaizv().equals(ime))
                return lista[i]; //cim ga pronadjemo vracamo
        }
        //ako smo dosli do ovde sigurno nije pronadjeno
        return null;
    }
    public String toString() {
        String buffer = String.format("%s - %s(%d):[", izvodjac,naziv,datum.getYear());
        for(int i=0;i<brojac;i++) {
            buffer += String.format("\n\t%s", lista[i].toString());
        }
        buffer += String.format("\n]: %s\n",getTrajanje());

        return buffer;
    }
}
