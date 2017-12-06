package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.ItemPedido;
import java.util.ArrayList;

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
     
     public  ItemPedido consultarProduto (int codigoProduto) {
        ItemPedido d = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from ITEMPEDIDO where " +
                                                 "codigoproduto = ?");
            
            ps.setInt(1, codigoProduto);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                d = new ItemPedido (codigoProduto, rs.getInt("qtdeVendida"));
                d.setPedido(new DaoPedido(conn).consultar(rs.getInt("numeropedido")));
                d.setProduto(new DaoProduto(conn).consultar(rs.getInt("codigoproduto")));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (d);
    }    
     
     public ArrayList <ItemPedido> consultarPedido (int numeroPedido) {
         ArrayList <ItemPedido> d = new ArrayList<ItemPedido>();
         ItemPedido i = null;
         
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from ITEMPEDIDO where " +
                                                 "numeropedido = ?");
            
            ps.setInt(1, numeroPedido);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next() == true) {
                i = new ItemPedido (numeroPedido, rs.getInt("qtdeVendida"));
                i.setProduto(new DaoProduto(conn).consultar(rs.getInt("codigoproduto")));
                d.add(i);
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





