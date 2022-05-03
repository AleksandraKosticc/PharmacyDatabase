package dto;

import java.util.Objects;

/**
 *
 * @author Aleksandra
 */
public class Cijena {

    private int IdCijena;
    private double NabavnaCijena;
    private double ProdajnaCijena;
    private int Barkod;
    private TipArtikla tipArtikla;

    public Cijena(int IdCijena, double NabavnaCijena, double ProdajnaCijena, int Barkod, TipArtikla tipArtikla) {
        this.IdCijena = IdCijena;
        this.NabavnaCijena = NabavnaCijena;
        this.ProdajnaCijena = ProdajnaCijena;
        this.Barkod = Barkod;
        this.tipArtikla = tipArtikla;
    }

    public int getIdCijena() {
        return IdCijena;
    }

    public void setIdCijena(int IdCijena) {
        this.IdCijena = IdCijena;
    }

    public double getProdajnaCijena() {
        return ProdajnaCijena;
    }

    public void setProdajnaCijena(double ProdajnaCijena) {
        this.ProdajnaCijena = ProdajnaCijena;
    }

    public double getNabavnaCijena() {
        return NabavnaCijena;
    }

    public void setNabavnaCijena(double NabavnaCijena) {
        this.NabavnaCijena = NabavnaCijena;
    }

    public int getBarkod() {
        return Barkod;
    }

    public void setBarkod(int Barkod) {
        this.Barkod = Barkod;
    }

    public TipArtikla getTipArtikla() {
        return tipArtikla;
    }

    public void setTipArtikla(TipArtikla tipArtikla) {
        this.tipArtikla = tipArtikla;
    }    
}
