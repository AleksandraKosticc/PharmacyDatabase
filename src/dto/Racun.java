package dto;

/**
 *
 * @author Aleksandra
 */
public class Racun {

    private int IdRacuna;
    private double UkupanIznos;
    private Zaposleni IdZaposlenog;

    public Racun(int IdRacuna, double UkupanIznos, Zaposleni IdZaposlenog) {
        this.IdRacuna = IdRacuna;
        this.UkupanIznos = UkupanIznos;
        this.IdZaposlenog = IdZaposlenog;
    }

    public int getIdRacuna() {
        return IdRacuna;
    }

    public void setIdRacuna(int IdRacuna) {
        this.IdRacuna = IdRacuna;
    }

    public double getUkupanIznos() {
        return UkupanIznos;
    }

    public void setUkupanIznos(double UkupanIznos) {
        this.UkupanIznos = UkupanIznos;
    }

    public Zaposleni getIdZaposlenog() {
        return IdZaposlenog;
    }

    public void setIdZaposlenog(Zaposleni IdZaposlenog) {
        this.IdZaposlenog = IdZaposlenog;
    }
}
