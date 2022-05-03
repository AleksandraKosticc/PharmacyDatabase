package dto;

/**
 *
 * @author Aleksandra
 */
public class RacunStavka {

    private int Barkod;
    private String NazivArtikla;
    private int Kolicina;
    private double Cijena;
    private int IdZaposlenog;
    private int IdTipArtikla;

    public RacunStavka(int Barkod, String NazivArtikla, int Kolicina, double Cijena, int IdZaposlenog, int IdTipArtikla) {
        this.Barkod = Barkod;
        this.NazivArtikla = NazivArtikla;
        this.Kolicina = Kolicina;
        this.Cijena = Cijena;
        this.IdZaposlenog = IdZaposlenog;
        this.IdTipArtikla = IdTipArtikla;
    }

    public int getBarkod() {
        return Barkod;
    }

    public void setBarkod(int Barkod) {
        this.Barkod = Barkod;
    }

    public String getNazivArtikla() {
        return NazivArtikla;
    }

    public void setNazivArtikla(String NazivArtikla) {
        this.NazivArtikla = NazivArtikla;
    }

    public int getKolicina() {
        return Kolicina;
    }

    public void setKolicina(int Kolicina) {
        this.Kolicina = Kolicina;
    }

    public double getCijena() {
        return Cijena;
    }

    public void setCijena(double Cijena) {
        this.Cijena = Cijena;
    }

    public int getIdZaposlenog() {
        return IdZaposlenog;
    }

    public void setIdZaposlenog(int IdZaposlenog) {
        this.IdZaposlenog = IdZaposlenog;
    }

    public int getIdTipArtikla() {
        return IdTipArtikla;
    }

    public void setIdTipArtikla(int IdTipArtikla) {
        this.IdTipArtikla = IdTipArtikla;
    }
}
