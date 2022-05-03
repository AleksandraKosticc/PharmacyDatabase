package dao;

import dto.Zaposleni;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Aleksandra
 */
public class ZaposleniDAO {
    private static final String SQL_GET = "SELECT * FROM zaposleni";
    
    public static ObservableList<Zaposleni> getZaposleni() {
        
        Zaposleni text = new Zaposleni(1, "Izaberi"); 
        ObservableList<Zaposleni> rezultati //
                = FXCollections.observableArrayList(text);
        
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            con = ConnectionPool.getInstance().checkOut();
            s = con.createStatement();
            rs = s.executeQuery(SQL_GET);

            while (rs.next()){
                int IdZaposlenog = rs.getInt(1);
                String KorisnickoIme = rs.getString(2);
                               
            rezultati.add(new Zaposleni(IdZaposlenog, KorisnickoIme));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ZaposleniDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ZaposleniDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ZaposleniDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return FXCollections.observableArrayList(rezultati);
    }
}