package dao;

import dto.Cijena;
import dto.TipArtikla;
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
public class CijenaDAO {
     private static final String SQL_GET = "SELECT IdCijena, NabavnaCijena, ProdajnaCijena, Barkod, IdTipArtikla FROM cijena;";
    
    public static ObservableList<Cijena> getCijena() {
       
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        ArrayList<Cijena> rezultati = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            s = con.createStatement();
            rs = s.executeQuery(SQL_GET);

            while (rs.next()){
                
                rezultati.add(new Cijena(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getInt(4), 
                              new TipArtikla(rs.getInt(5))));
  
            }
        } catch (SQLException ex) {
            Logger.getLogger(CijenaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CijenaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CijenaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return FXCollections.observableArrayList(rezultati);
    }
}