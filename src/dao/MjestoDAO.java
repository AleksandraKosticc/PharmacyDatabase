package dao;

import dto.Mjesto;
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
public class MjestoDAO {
    private static final String SQL_GET = "SELECT * FROM mjesto";
    
    public static ObservableList<Mjesto> getMjesto() {
        
        Mjesto text = new Mjesto(1, "Izaberi"); 
        ObservableList<Mjesto> rezultati //
                = FXCollections.observableArrayList(text);
        
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            con = ConnectionPool.getInstance().checkOut();
            s = con.createStatement();
            rs = s.executeQuery(SQL_GET);

            while (rs.next()){
                int BrojPoste = rs.getInt(1);
                String Naziv = rs.getString(2);
                               
            rezultati.add(new Mjesto(BrojPoste, Naziv));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MjestoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MjestoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MjestoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return FXCollections.observableArrayList(rezultati);
    }   
}