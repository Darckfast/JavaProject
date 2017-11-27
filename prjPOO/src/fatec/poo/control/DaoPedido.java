package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Pedido;

public class DaoPedido {

    private Connection conn;
    
    public DaoPedido(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Pedido pedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbpedido(numero, dataEmissaoPedido,dataPgto,status,cliente,vendedor) VALUES(?,?)");
            ps.setString(1, String.valueOf(pedido.getNumero()));
            ps.setString(2, String.valueOf(pedido.getDataEmissaoPedido()));
            ps.setString(3, String.valueOf(pedido.getDataPgto()));
            ps.setString(4, String.valueOf(pedido.getStatus()));
            ps.setString(5, String.valueOf(pedido.getCliente()));
            ps.setString(6, String.valueOf(pedido.getVendedor()));
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Pedido pedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbpedido set qtdeVendidadataEmissaoPedido = ?" + " dataPgto = ?" + "status = ?" + "cliente = ?" + "vendedor = ? " +
                                                 "where numero = ?");
            
            ps.setString(1, String.valueOf(pedido.getNumero()));
            ps.setString(2, String.valueOf(pedido.getDataEmissaoPedido()));
            ps.setString(3, String.valueOf(pedido.getDataPgto()));
            ps.setString(4, String.valueOf(pedido.getStatus()));
            ps.setString(5, String.valueOf(pedido.getCliente()));
            ps.setString(6, String.valueOf(pedido.getVendedor()));
                
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
        
     public  Pedido consultar (int numero) {
        Pedido d = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbpedido where " +
                                                 "numero = ?");
            
            ps.setString(1, String.valueOf(numero));
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                d = new Pedido (numero, rs.getString("dataEmissaoPedido") );
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (d);
    }    
     
     public void excluir(Pedido pedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbpedido where numero = ?");
            
            ps.setString(1, String.valueOf(pedido.getNumero()));
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}





