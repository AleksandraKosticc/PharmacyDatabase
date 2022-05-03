package dao;

import dto.TipArtikla;
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
public class TipArtiklaDAO {
    private static final String SQL_GET = "SELECT * FROM tip_artikla";
    
    public static ObservableList<TipArtikla> getTipArtikla() {
        
        TipArtikla text = new TipArtikla(1, "Izaberi"); 
        ObservableList<TipArtikla> rezultati //
                = FXCollections.observableArrayList(text);
        
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            con = ConnectionPool.getInstance().checkOut();
            s = con.createStatement();
            rs = s.executeQuery(SQL_GET);

            while (rs.next()){
                int IdTipArtikla = rs.getInt(1);
                String NazivTipa = rs.getString(2);
                               
            rezultati.add(new TipArtikla(IdTipArtikla, NazivTipa));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipArtiklaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TipArtiklaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TipArtiklaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return FXCollections.observableArrayList(rezultati);
    }
}