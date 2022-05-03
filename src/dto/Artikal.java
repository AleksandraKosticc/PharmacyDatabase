package dto;

/**
 *
 * @author Aleksandra
 */
public class Artikal {

    private int Barkod;
    private String NazivArtikla;
    private int Zaliha;
    private Proizvodjac Proizvodjac;
    private TipArtikla NazivTipa;

    public Artikal(int Barkod, String NazivArtikla, int Zaliha, Proizvodjac Proizvodjac, TipArtikla NazivTipa) {
        this.Barkod = Barkod;
        this.NazivArtikla = NazivArtikla;
        this.Zaliha = Zaliha;
        this.Proizvodjac = Proizvodjac;
        this.NazivTipa = NazivTipa;
    }
    
    public Artikal(int Barkod, String NazivArtikla, int Zaliha, Proizvodjac Proizvodjac) {
        this.Barkod = Barkod;
        this.NazivArtikla = NazivArtikla;
        this.Zaliha = Zaliha;
        this.Proizvodjac = Proizvodjac;
    }

    public Artikal(int Barkod, String NazivArtikla) {
        this.Barkod = Barkod;
        this.NazivArtikla = NazivArtikla;
    }

    public TipArtikla getNazivTipa() {
        return NazivTipa;
    }

    public void setNazivTipa(TipArtikla NazivTipa) {
        this.NazivTipa = NazivTipa;
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

    public int getZaliha() {
        return Zaliha;
    }

    public void setZaliha(int Zaliha) {
        this.Zaliha = Zaliha;
    }

    public Proizvodjac getProizvodjac() {
        return Proizvodjac;
    }

    public void setProizvodjac(Proizvodjac Proizvodjac) {
        this.Proizvodjac = Proizvodjac;
    }

    @Override
    public String toString() {
        return Barkod + " - " + NazivArtikla;
    }
}
