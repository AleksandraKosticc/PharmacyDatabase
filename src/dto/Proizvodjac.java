package dto;

/**
 *
 * @author Aleksandra
 */
public class Proizvodjac {

    private int IdProizvodjac;
    private String Naziv;
    private String Adresa;
    private int BrojPoste;
    private Mjesto mjesto;
    private String Telefon;

    public Proizvodjac(String Naziv, String Adresa, int BrojPoste, Mjesto mjesto, String Telefon) {
        this.Naziv = Naziv;
        this.Adresa = Adresa;
        this.BrojPoste = BrojPoste;
        this.mjesto = mjesto;
        this.Telefon = Telefon;
    }

    public Proizvodjac(String Naziv) {
        this.Naziv = Naziv;
    }

    public Proizvodjac(int IdProizvodjac) {
        this.IdProizvodjac = IdProizvodjac;
    }

    public int getIdProizvodjac() {
        return IdProizvodjac;
    }

    public void setIdProizvodjac(int IdProizvodjac) {
        this.IdProizvodjac = IdProizvodjac;
    }

    public Mjesto getMjesto() {
        return mjesto;
    }

    public void setMjesto(Mjesto mjesto) {
        this.mjesto = mjesto;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String Naziv) {
        this.Naziv = Naziv;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String Adresa) {
        this.Adresa = Adresa;
    }

    public int getBrojPoste() {
        return BrojPoste;
    }

    public void setBrojPoste(int BrojPoste) {
        this.BrojPoste = BrojPoste;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String Telefon) {
        this.Telefon = Telefon;
    }

    @Override
    public String toString() {
        return this.Naziv;
    }
}
