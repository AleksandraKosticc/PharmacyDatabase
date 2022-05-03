package dao;

import dto.Lijek;
import dto.Proizvodjac;
import dto.TipArtikla;
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
public class LijekDAO {

    private static final String SQL_SELECT = "SELECT a.Barkod, a.NazivArtikla, a.Zaliha, p.Naziv, ta.NazivTipa, c.NabavnaCijena, c.ProdajnaCijena, GenerickiNaziv, Doza, Oblik, NazivListe\n"
            + "                                             FROM lijek l\n"
            + "                                             INNER JOIN artikal a on a.Barkod = l.Barkod\n"
            + "                                             INNER JOIN cijena c on c.Barkod = a.Barkod\n"
            + "                                             INNER JOIN tip_artikla ta on ta.IdTipArtikla= c.IdTipArtikla\n"
            + "                                             INNER JOIN proizvodjac p on p.IdProizvodjac = a.IdProizvodjac\n"
            + "                                             ORDER BY Barkod;";

    public static ObservableList<Lijek> getLijekovi() {
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        ArrayList<Lijek> rezultati = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            s = con.createStatement();
            rs = s.executeQuery(SQL_SELECT);

            while (rs.next()) {

                rezultati.add(new Lijek(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        new Proizvodjac(rs.getString(4)),
                        new TipArtikla(rs.getString(5)),
                        rs.getDouble(6), rs.getDouble(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11))
                );

            }
        } catch (SQLException ex) {
            Logger.getLogger(LijekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LijekDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LijekDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return FXCollections.observableArrayList(rezultati);
    }

    public static boolean upisiLijek(int Barkod, String NazivArtikla, int RezimIzdavanja, double NabavnaCijena,
            double ProdajnaCijena, int Proizvodjac, String GenerickiNaziv, String Doza, String Oblik, String NazivListe) {
        boolean retValue = false;
        Connection con = null;
        CallableStatement cs = null;

        String query = "{call dodaj_lijek(?,?,?,?,?,?,?,?,?,?)}";

        try {
            con = ConnectionPool.getInstance().checkOut();
            cs = con.prepareCall(query);

            cs.setInt(1, Barkod);
            cs.setString(2, NazivArtikla);
            cs.setInt(3, RezimIzdavanja);
            cs.setDouble(4, NabavnaCijena);
            cs.setDouble(5, ProdajnaCijena);
            cs.setInt(6, Proizvodjac);
            cs.setString(7, GenerickiNaziv);
            cs.setString(8, Doza);
            cs.setString(9, Oblik);
            cs.setString(10, NazivListe);

            retValue = cs.executeUpdate() == 1;

        } catch (SQLException ex) {
            Logger.getLogger(LijekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LijekDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return retValue;
    }

    public static boolean izmijeniLijek(int Barkod, String NazivArtikla, int Proizvodjac, String GenerickiNaziv, String Doza, String Oblik, String NazivListe) {
        boolean retValue = false;
        Connection con = null;
        CallableStatement cs = null;

        String query = "{call azuriraj_lijek(?,?,?,?,?,?,?)}";
        try {
            con = ConnectionPool.getInstance().checkOut();
            cs = con.prepareCall(query);

            cs.setInt(1, Barkod);
            cs.setString(2, NazivArtikla);
            cs.setInt(3, Proizvodjac);
            cs.setString(4, GenerickiNaziv);
            cs.setString(5, Doza);
            cs.setString(6, Oblik);
            cs.setString(7, NazivListe);

            retValue = cs.executeUpdate() == 1;

        } catch (SQLException ex) {
            Logger.getLogger(LijekDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LijekDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return retValue;
    }
}
