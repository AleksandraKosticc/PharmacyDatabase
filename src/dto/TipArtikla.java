package dto;

/**
 *
 * @author Aleksandra
 */
public class TipArtikla {

     int IdTipArtikla;
     String NazivTipa;

    public TipArtikla(int IdTipArtikla, String NazivTipa) {
        this.IdTipArtikla = IdTipArtikla;
        this.NazivTipa = NazivTipa;
    }

    public TipArtikla(int IdTipArtikla) {
        this.IdTipArtikla = IdTipArtikla;
    }

    public TipArtikla(String NazivTipa) {
        this.NazivTipa = NazivTipa;
    }

    public int getIdTipArtikla() {
        return IdTipArtikla;
    }

    public void setIdTipArtikla(int IdTipArtikla) {
        this.IdTipArtikla = IdTipArtikla;
    }

    public String getNazivTipa() {
        return NazivTipa;
    }

    public void setNazivTipa(String NazivTipa) {
        this.NazivTipa = NazivTipa;
    }

    @Override
    public String toString() {
        return this.NazivTipa;
    }
}
