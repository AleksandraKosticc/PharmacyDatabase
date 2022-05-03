package dto;

/**
 *
 * @author Aleksandra
 */
public class ProizvodjacCombo {

    private int IdProizvodjac;
    private String Naziv;

    public ProizvodjacCombo(int IdProizvodjac, String Naziv) {
        this.IdProizvodjac = IdProizvodjac;
        this.Naziv = Naziv;
    }

    public int getIdProizvodjac() {
        return IdProizvodjac;
    }

    public void setIdProizvodjac(int IdProizvodjac) {
        this.IdProizvodjac = IdProizvodjac;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String Naziv) {
        this.Naziv = Naziv;
    }

    @Override
    public String toString() {
        return Naziv;
    }
}
