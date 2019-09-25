package domaci08272019;

public class Numera {
    private String naziv;
    public Numera(String naziv, String izvodjac, String trajanje) {
        this.naziv = naziv;
        this.izvodjac = izvodjac;
        this.trajanje = trajanje;
    }
    private String izvodjac;
    private String trajanje;
    public String getNaizv() {
        return naziv;
    }
    public void setNaizv(String naziv) {
        this.naziv = naziv;
    }
    public String getIzvodjac() {
        return izvodjac;
    }
    public void setIzvodjac(String izvodjac) {
        this.izvodjac = izvodjac;
    }
    public String getTrajanje() {
        return trajanje;
    }
    public String toString() {
        return String.format("%s - %s: %s", izvodjac,naziv,trajanje);
    }
}
