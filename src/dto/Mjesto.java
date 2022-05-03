package dto;

/**
 *
 * @author Aleksandra
 */
public class Mjesto {

    private int BrojPoste;
    private String Grad;

    public Mjesto(int BrojPoste, String Grad) {
        this.BrojPoste = BrojPoste;
        this.Grad = Grad;
    }

    public Mjesto(String Grad) {
        this.Grad = Grad;
    }

    public int getBrojPoste() {
        return BrojPoste;
    }

    public void setBrojPoste(int BrojPoste) {
        this.BrojPoste = BrojPoste;
    }

    public String getGrad() {
        return Grad;
    }

    public void setGrad(String Grad) {
        this.Grad = Grad;
    }

    @Override
    public String toString() {
        return Grad;
    }
}
