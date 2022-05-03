package dto;

/**
 *
 * @author Aleksandra
 */
public class Lijek extends Artikal {

    private double NabavnaCijena;
    private double ProdajnaCijena;
    private String GenerickiNaziv;
    private String Doza;
    private String Oblik;
    private String NazivListe;

    public Lijek(int Barkod, String NazivArtikla, int Zaliha, Proizvodjac Proizvodjac, TipArtikla NazivTipa, double NabavnaCijena, double ProdajnaCijena, String GenerickiNaziv, String Doza, String Oblik, String NazivListe) {
        super(Barkod, NazivArtikla, Zaliha, Proizvodjac, NazivTipa);
        this.NabavnaCijena = NabavnaCijena;
        this.ProdajnaCijena = ProdajnaCijena;
        this.GenerickiNaziv = GenerickiNaziv;
        this.Doza = Doza;
        this.Oblik = Oblik;
        this.NazivListe = NazivListe;
    }

    public double getNabavnaCijena() {
        return NabavnaCijena;
    }

    public void setNabavnaCijena(double NabavnaCijena) {
        this.NabavnaCijena = NabavnaCijena;
    }

    public double getProdajnaCijena() {
        return ProdajnaCijena;
    }

    public void setProdajnaCijena(double ProdajnaCijena) {
        this.ProdajnaCijena = ProdajnaCijena;
    }

    public String getGenerickiNaziv() {
        return GenerickiNaziv;
    }

    public void setGenerickiNaziv(String GenerickiNaziv) {
        this.GenerickiNaziv = GenerickiNaziv;
    }

    public String getDoza() {
        return Doza;
    }

    public void setDoza(String Doza) {
        this.Doza = Doza;
    }

    public String getOblik() {
        return Oblik;
    }

    public void setOblik(String Oblik) {
        this.Oblik = Oblik;
    }

    public String getNazivListe() {
        return NazivListe;
    }

    public void setNazivListe(String NazivListe) {
        this.NazivListe = NazivListe;
    }  
}
