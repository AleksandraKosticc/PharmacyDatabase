package dto;

/**
 *
 * @author Aleksandra
 */
public class Faktura {

    private int BrojFakture;
    private java.sql.Date DatumIzdavanja;
    private double IznosRacuna;
    private Proizvodjac Proizvodjac;

    public Faktura(int BrojFakture, java.sql.Date DatumIzdavanja, double IznosRacuna, Proizvodjac Proizvodjac) {
        this.BrojFakture = BrojFakture;
        this.DatumIzdavanja = DatumIzdavanja;
        this.IznosRacuna = IznosRacuna;
        this.Proizvodjac = Proizvodjac;
    }

    public int getBrojFakture() {
        return BrojFakture;
    }

    public void setBrojFakture(int BrojFakture) {
        this.BrojFakture = BrojFakture;
    }

    public java.sql.Date getDatumIzdavanja() {
        return DatumIzdavanja;
    }

    public void setDatumIzdavanja(java.sql.Date DatumIzdavanja) {
        this.DatumIzdavanja = DatumIzdavanja;
    }

    public double getIznosRacuna() {
        return IznosRacuna;
    }

    public void setIznosRacuna(double IznosRacuna) {
        this.IznosRacuna = IznosRacuna;
    }

    public Proizvodjac getProizvodjac() {
        return Proizvodjac;
    }

    public void setProizvodjac(Proizvodjac Proizvodjac) {
        this.Proizvodjac = Proizvodjac;
    }
}
