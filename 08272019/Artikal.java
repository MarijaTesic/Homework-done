package domaci08272019;

public abstract class Artikal {
    private static int next_id = 1;
    private int id = next_id++;
    private double cena;
    private int kolicina;

    public Artikal(int cena, int kolicina){
        this.cena = cena;
        this.kolicina = kolicina;
    }
    public boolean kupi() {
        if(kolicina<=0) {
            return false;
        }
        kolicina--;
        return true;
    }
    public int getId() {
        return id;
    }
    public double getCena() {
        return cena;
    }
    public int getKolicina() {
        return kolicina;
    }
    public abstract String ime();
    public String toString() {
        return String.format("#%d: %s - %.2f [kol: %d]", id, ime(), cena, kolicina);
    }
}
