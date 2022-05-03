package dao;

import dto.Kozmetika;
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
public class KozmetikaDAO {
    
     private static final String SQL_SELECT = "select a.Barkod, a.NazivArtikla, a.Zaliha, p.Naziv, c.NabavnaCijena, c.ProdajnaCijena,  JedinicaMjere, ta.NazivTipa\n" +
"                                             from kozmetika k\n" +
"                                             inner join artikal a on k.Barkod = a.Barkod\n" +
"                                             inner join cijena c on c.Barkod = a.Barkod\n" +
"                                             inner join tip_artikla ta on ta.IdTipArtikla= c.IdTipArtikla\n" +
"                                             inner join proizvodjac p on p.IdProizvodjac = a.IdProizvodjac order by a.Barkod;";
      

    public static ObservableList<Kozmetika> getKozmetika() {
        
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        ArrayList<Kozmetika> rezultati = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            s = con.createStatement();
            rs = s.executeQuery(SQL_SELECT);

            while (rs.next()){
                
                rezultati.add(new Kozmetika(rs.getInt(1), rs.getString(2), rs.getInt(3), new Proizvodjac(rs.getString(4)), rs.getDouble(5), rs.getDouble(6), rs.getString(7),         
                              new TipArtikla(rs.getString(8))
                ));
                
              }
                 
        } catch (SQLException ex) {
            Logger.getLogger(KozmetikaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KozmetikaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KozmetikaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return FXCollections.observableArrayList(rezultati);
    }
    
    public static boolean upisiKozmetika(int Barkod, String NazivArtikla, double NabavnaCijena, double ProdajnaCijena, int Proizvodjac,  String JedinicaMjere, int NazivTipa){
        boolean retValue = false;
        Connection con = null;
        CallableStatement cs = null;
        
        String query = "{call dodaj_kozmetika(?,?,?,?,?,?,?)}";
        
        try{
            con = ConnectionPool.getInstance().checkOut();
            cs = con.prepareCall(query);
            
            cs.setInt(1, Barkod);
            cs.setString(2, NazivArtikla);
            cs.setDouble(3, NabavnaCijena);  
            cs.setDouble(4, ProdajnaCijena);
            cs.setInt(5, Proizvodjac);
            cs.setString(6, JedinicaMjere);
            cs.setInt(7, NazivTipa);
            
            retValue = cs.executeUpdate() == 1;
                       
        }catch (SQLException ex) {
            Logger.getLogger(KozmetikaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KozmetikaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return retValue; 
    }
    
    public static boolean izmijeniKozmetiku(int Barkod, String NazivArtikla, int Proizvodjac, String JedinicaMjere) {
        boolean retValue = false;
        Connection con = null;
        CallableStatement cs = null;

        String query = "{call azuriraj_kozmetiku(?,?,?,?)}";
        try {
            con = ConnectionPool.getInstance().checkOut();
            cs = con.prepareCall(query);
            
            cs.setInt(1, Barkod);
            cs.setString(2, NazivArtikla);
            cs.setInt(3, Proizvodjac);
            cs.setString(4, JedinicaMjere);
            
            retValue = cs.executeUpdate() == 1;

        }catch (SQLException ex) {
            Logger.getLogger(KozmetikaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KozmetikaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return retValue;
    }   
}