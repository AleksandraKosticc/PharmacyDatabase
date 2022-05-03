package dto;

/**
 *
 * @author Aleksandra
 */
public class Zaposleni {

    private int IdZaposlenog;
    private String KorisnickoIme;

    public Zaposleni(int IdZaposlenog, String KorisnickoIme) {
        this.IdZaposlenog = IdZaposlenog;
        this.KorisnickoIme = KorisnickoIme;
    }

    public Zaposleni(int IdZaposlenog) {
        this.IdZaposlenog = IdZaposlenog;
    }

    public int getIdZaposlenog() {
        return IdZaposlenog;
    }

    public void setIdZaposlenog(int IdZaposlenog) {
        this.IdZaposlenog = IdZaposlenog;
    }

    public String getKorisnickoIme() {
        return KorisnickoIme;
    }

    public void setKorisnickoIme(String KorisnickoIme) {
        this.KorisnickoIme = KorisnickoIme;
    }

    @Override
    public String toString() {
        return this.KorisnickoIme;
    }
}
