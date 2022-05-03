package dao;


import dto.Artikal;
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

public class ArtikalDAO {

    private static final String SQL_GET ="SELECT a.Barkod, a.NazivArtikla, a.Zaliha, p.Naziv FROM artikal a \n" +
                                         "inner join proizvodjac p on p.IdProizvodjac = a.IdProizvodjac ORDER BY a.Barkod;";
    
    private static final String SQL = "SELECT * FROM artikal_pogled";
    
    public static ObservableList<Artikal> getArtikal() {
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        ArrayList<Artikal> rezultati = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            s = con.createStatement();
            rs = s.executeQuery(SQL_GET);

            while (rs.next()) {
                rezultati.add(new Artikal(rs.getInt(1), rs.getString(2), rs.getInt(3),
                              new Proizvodjac(rs.getString(4))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Artikal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Artikal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Artikal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return FXCollections.observableArrayList(rezultati);
    }
    
    public static ObservableList<Artikal> getSkladiste() {
        ArrayList<Artikal> rezultati = new ArrayList<>();
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try {
            con = ConnectionPool.getInstance().checkOut();
            cs = con.prepareCall(SQL);
	    rs = cs.executeQuery();

            while (rs.next()) {
                
                rezultati.add(new Artikal(rs.getInt(1), rs.getString(2), rs.getInt(3),
                              new Proizvodjac(rs.getString(4))));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArtikalDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ArtikalDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ArtikalDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return FXCollections.observableArrayList(rezultati);
    }
    
}