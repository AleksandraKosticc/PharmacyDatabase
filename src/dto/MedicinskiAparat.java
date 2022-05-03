package dto;

/**
 *
 * @author Aleksandra
 */
public class MedicinskiAparat extends Artikal {

    private double NabavnaCijena;
    private double ProdajnaCijena;

    public MedicinskiAparat(int Barkod, String NazivArtikla, int Zaliha, Proizvodjac Proizvodjac, double NabavnaCijena, double ProdajnaCijena, TipArtikla NazivTipa) {
        super(Barkod, NazivArtikla, Zaliha, Proizvodjac, NazivTipa);
        this.NabavnaCijena = NabavnaCijena;
        this.ProdajnaCijena = ProdajnaCijena;
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
}
