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
            ps = conn.prepareStatement("INSERT INTO PEDIDO" + 
                                                        "(numero, dataEmissaoPedido,dataPgto,status,cliente,vendedor)" + 
                                                        "VALUES(?,?,?,?,?,?)");
            ps.setInt(1, pedido.getNumero());
            ps.setString(2, pedido.getDataEmissaoPedido());
            ps.setString(3, pedido.getDataPgto());
            ps.setBoolean(4, pedido.getStatus());
            ps.setString(5, pedido.getCliente().getCpf());
            ps.setString(6, pedido.getVendedor().getCpf());
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Pedido pedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE PEDIDO" +
                                                            "SET qtdeVendidadataEmissaoPedido = ?," + 
                                                            "dataPgto = ?," + 
                                                            "status = ?," + 
                                                            "cliente = ?," + 
                                                            "vendedor = ?" +
                                                 "where numero = ?");
            
            ps.setString(1, pedido.getDataEmissaoPedido());
            ps.setString(2, pedido.getDataPgto());
            ps.setBoolean(3, pedido.getStatus());
            ps.setString(4, pedido.getCliente().getCpf());
            ps.setString(5, pedido.getVendedor().getCpf());
            ps.setInt(6, pedido.getNumero());
                
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
        
     public  Pedido consultar (int numero) {
        Pedido d = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from PEDIDO where " +
                                                 "numero = ?");
            
            ps.setInt(1, numero);
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
            ps = conn.prepareStatement("DELETE FROM PEDIDO where numero = ?");
            
            ps.setInt(1, pedido.getNumero());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}





