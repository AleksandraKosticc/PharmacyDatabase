package dto;

/**
 *
 * @author Aleksandra
 */
public class Kozmetika extends Artikal {

    private double NabavnaCijena;
    private double ProdajnaCijena;
    private String JedinicaMjere;

    public Kozmetika(int Barkod, String NazivArtikla, int Zaliha, Proizvodjac Proizvodjac, double NabavnaCijena, double ProdajnaCijena, String JedinicaMjere, TipArtikla NazivTipa) {
        super(Barkod, NazivArtikla, Zaliha, Proizvodjac, NazivTipa);
        this.NabavnaCijena = NabavnaCijena;
        this.ProdajnaCijena = ProdajnaCijena;
        this.JedinicaMjere = JedinicaMjere;
        
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

    public String getJedinicaMjere() {
        return JedinicaMjere;
    }

    public void setJedinicaMjere(String JedinicaMjere) {
        this.JedinicaMjere = JedinicaMjere;
    }

}
