package dao;

import dto.Faktura;
import dto.FakturaStavka;
import dto.Proizvodjac;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Aleksandra
 */
public class FakturaDAO {

    private static final String SQL_GET = "select BrojFakture, DatumIzdavanja, IznosRacuna, p.Naziv\n"
            + "from faktura f\n"
            + "inner join proizvodjac p on p.IdProizvodjac = f.IdProizvodjac;";

    public static ObservableList<Faktura> getFaktura() {
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        ArrayList<Faktura> rezultati = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            s = con.createStatement();
            rs = s.executeQuery(SQL_GET);

            while (rs.next()) {
                rezultati.add(new Faktura(rs.getInt(1), rs.getDate(2), rs.getDouble(3),
                        new Proizvodjac(rs.getString(4))
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return FXCollections.observableArrayList(rezultati);
    }

    public static boolean faktura(ObservableList<FakturaStavka> lista) {
        Connection con = null;
        CallableStatement cs = null;

        try {
            con = ConnectionPool.getInstance().checkOut();
            cs = con.prepareCall("{call dodaj_fakturu(?,?,?)}");

            int brojFakture = lista.get(0).getBrojFakture();
            int idProizvodjaca = lista.get(0).getIdProizvodjaca();
            int idZaposlenog = lista.get(0).getIdZaposlenog();

            cs.setInt(1, brojFakture);
            cs.setInt(2, idProizvodjaca);
            cs.setInt(3, idZaposlenog);

            cs.executeUpdate();

            cs = null;
            cs = con.prepareCall("{call dodaj_faktura_stavka(?,?,?)}");

            for (int i = 0; i < lista.size(); ++i) {

                FakturaStavka artikal = lista.get(i);

                int barkod = artikal.getBarkod();
                int kolicina = artikal.getKolicina();
                double cijena = artikal.getCijenaStavke();

                cs.setInt(1, barkod);
                cs.setInt(2, kolicina);
                cs.setDouble(3, cijena);

                cs.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FakturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return true;
    }
}
