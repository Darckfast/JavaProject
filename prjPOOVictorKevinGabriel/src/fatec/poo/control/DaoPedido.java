package fatec.poo.control;

import fatec.poo.model.Cliente;
import fatec.poo.model.ItemPedido;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Pedido;
import fatec.poo.model.Produto;
import fatec.poo.model.Vendedor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
        //Pedido d = new Pedido(numero,"11/11/1111");
        Pedido d = null;
       
        PreparedStatement ps = null;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            ps = conn.prepareStatement("SELECT * from PEDIDO where " +
                                                 "numero = ?");
            
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                d = new Pedido (numero, rs.getString("DATAEMISSAOPEDIDO"));
                d.setDataPgto(rs.getString("DATAPGTO"));
                d.setStatus(rs.getBoolean("STATUS"));
                d.setCliente(new DaoCliente(conn).consultar(rs.getString("CPFCLIENTE")));
                d.setVendedor(new DaoVendedor(conn).consultar(rs.getString("CPFVENDEDOR")));
                d.setItenspedido(new DaoItemPedido(conn).consultarPedido(numero));
                //TODO: adicionar arraylist.
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