package dao;

import dto.MedicinskiAparat;
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
public class MedicinskiAparatDAO {
    private static final String SQL_SELECT = "select a.Barkod, a.NazivArtikla, a.Zaliha, p.Naziv, c.NabavnaCijena, c.ProdajnaCijena, ta.NazivTipa\n" +
"                                             from medicinski_aparat mk\n" +
"                                             inner join artikal a on mk.Barkod = a.Barkod\n" +
"                                             inner join cijena c on c.Barkod = a.Barkod\n" +
"                                             inner join tip_artikla ta on ta.IdTipArtikla= c.IdTipArtikla\n" +
"                                             inner join proizvodjac p on p.IdProizvodjac = a.IdProizvodjac order by Barkod;";
 
    public static ObservableList<MedicinskiAparat> getMedicinskiAparati() {
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        ArrayList<MedicinskiAparat> rezultati = new ArrayList<>();

        try {
            con = ConnectionPool.getInstance().checkOut();
            s = con.createStatement();
            rs = s.executeQuery(SQL_SELECT);

            while (rs.next()){
                
                rezultati.add(new MedicinskiAparat(rs.getInt(1), rs.getString(2), rs.getInt(3), 
                              new Proizvodjac(rs.getString(4)), rs.getDouble(5), rs.getDouble(6), 
                              new TipArtikla(rs.getString(7))
                ));
   
              } 
        } catch (SQLException ex) {
            Logger.getLogger(MedicinskiAparatDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MedicinskiAparatDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MedicinskiAparatDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return FXCollections.observableArrayList(rezultati);
    }
    
    public static boolean upisiMedicinskiAparati(int Barkod, String NazivArtikla, double NabavnaCijena, double ProdajnaCijena, int Proizvodjac, int NazivTipa){
        boolean retValue = false;
        Connection con = null;
        CallableStatement cs = null;
        
        String query = "{call dodaj_medicinski_aparat(?,?,?,?,?,?)}";
        
        try{
            con = ConnectionPool.getInstance().checkOut();
            cs = con.prepareCall(query);
            
            cs.setInt(1, Barkod);
            cs.setString(2, NazivArtikla);           
            cs.setDouble(3, NabavnaCijena);
            cs.setDouble(4, ProdajnaCijena);  
            cs.setInt(5, Proizvodjac);
            cs.setInt(6, NazivTipa);
            
            retValue = cs.executeUpdate() == 1;
                       
        }catch (SQLException ex) {
            Logger.getLogger(MedicinskiAparatDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MedicinskiAparatDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return retValue; 
    }
    
    public static boolean izmijeniMedicinskiAparat(int Barkod, String NazivArtikla, int Proizvodjac) {
        boolean retValue = false;
        Connection con = null;
        CallableStatement cs = null;

        String query = "{call azuriraj_medicinski_aparat(?,?,?)}";
        try {
            con = ConnectionPool.getInstance().checkOut();
            cs = con.prepareCall(query);
            
            cs.setInt(1, Barkod);
            cs.setString(2, NazivArtikla);   
            cs.setInt(3, Proizvodjac);
            
            retValue = cs.executeUpdate() == 1;

        }catch (SQLException ex) {
            Logger.getLogger(MedicinskiAparatDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                ConnectionPool.getInstance().checkIn(con);
            }
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MedicinskiAparatDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return retValue;
    }    
}