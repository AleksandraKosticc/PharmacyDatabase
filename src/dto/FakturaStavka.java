package dto;

/**
 *
 * @author Aleksandra
 */
public class FakturaStavka {

    private int BrojFakture;
    private int Barkod;
    private String NazivArtikla;
    private int Kolicina;
    private double CijenaStavke;
    private int IdProizvodjaca;
    private int IdZaposlenog;

    public FakturaStavka(int BrojFakture, int Barkod, String NazivArtikla, int Kolicina, double CijenaStavke, int IdProizvodjaca, int IdZaposlenog) {
        this.BrojFakture = BrojFakture;
        this.Barkod = Barkod;
        this.NazivArtikla = NazivArtikla;
        this.CijenaStavke = CijenaStavke;
        this.Kolicina = Kolicina;
        this.IdProizvodjaca = IdProizvodjaca;
        this.IdZaposlenog = IdZaposlenog;
    }

    public int getBrojFakture() {
        return BrojFakture;
    }

    public void setBrojFakture(int BrojFakture) {
        this.BrojFakture = BrojFakture;
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

    public double getCijenaStavke() {
        return CijenaStavke;
    }

    public void setCijenaStavke(double CijenaStavke) {
        this.CijenaStavke = CijenaStavke;
    }

    public int getIdProizvodjaca() {
        return IdProizvodjaca;
    }

    public void setIdProizvodjaca(int IdProizvodjaca) {
        this.IdProizvodjaca = IdProizvodjaca;
    }

    public int getIdZaposlenog() {
        return IdZaposlenog;
    }

    public void setIdZaposlenog(int IdZaposlenog) {
        this.IdZaposlenog = IdZaposlenog;
    }

}
