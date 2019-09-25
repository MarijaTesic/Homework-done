package domaci08272019;

public class LP extends AlbumArtikal {
    private int tezina;

    public LP(Album album, String izdavac, int cena, int kolicina, int tezina) {
        super(album, izdavac, cena, kolicina);
        this.tezina = tezina;
    }

    @Override
    public String ime() {
        return String.format("%s - %s (%dg LP)", album.getIzvodjac(), album.getNaziv(), tezina);
    }

}