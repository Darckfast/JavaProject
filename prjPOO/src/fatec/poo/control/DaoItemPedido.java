package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.ItemPedido;

public class DaoItemPedido {

    private Connection conn;
    
    public DaoItemPedido(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(ItemPedido itempedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbitempedido(numeroItem, qtdeVendida) VALUES(?,?)");
            ps.setString(1, String.valueOf(itempedido.getNumeroItem()));
            ps.setString(2, String.valueOf(itempedido.getQtdeVendida()));
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(ItemPedido itempedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbitempedido set qtdeVendida = ? " +
                                                 "where numeroItem = ?");
            
            ps.setString(1, String.valueOf(itempedido.getNumeroItem()));
            ps.setString(2, String.valueOf(itempedido.getQtdeVendida()));
                
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
        
     public  ItemPedido consultar (int numeroItem) {
        ItemPedido d = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbitempedido where " +
                                                 "numeroItem = ?");
            
            ps.setString(1, String.valueOf(numeroItem));
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                d = new ItemPedido (numeroItem, Integer.valueOf(rs.getString("qtdeVendida")));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (d);
    }    
     
     public void excluir(ItemPedido itempedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbitempedido where numeroItem = ?");
            
            ps.setString(1, String.valueOf(itempedido.getNumeroItem()));
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}





