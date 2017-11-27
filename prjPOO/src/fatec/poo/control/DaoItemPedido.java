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
            ps = conn.prepareStatement("INSERT INTO ITEMPEDIDO" +
                                                   "(numeroItem, codigo, qtdeVendida)" + 
                                                   "VALUES(?,?,?)");
            ps.setInt(1,itempedido.getNumeroItem());
            ps.setInt(2,itempedido.getProduto().getCodigo());
            ps.setInt(3,itempedido.getQtdeVendida());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(ItemPedido itempedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE ITEMPEDIDO" + "SET qtdeVendida = ?," +
                                                              "codigo = ?" +
                                                              "where numeroItem = ?");
            
            ps.setInt(1, itempedido.getQtdeVendida());
            ps.setInt(2, itempedido.getProduto().getCodigo());
            ps.setInt(3, itempedido.getNumeroItem());
                
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
        
     public  ItemPedido consultar (int numeroItem) {
        ItemPedido d = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from ITEMPEDIDO where " +
                                                 "numeroItem = ?");
            
            ps.setInt(1, numeroItem);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                d = new ItemPedido (numeroItem, rs.getInt("qtdeVendida"));
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
            ps = conn.prepareStatement("DELETE FROM ITEMPEDIDO where numeroItem = ?");
            
            ps.setInt(1, itempedido.getNumeroItem());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}





