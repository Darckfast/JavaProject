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
import java.util.ArrayList;

public class DaoPedido {

    private Connection conn;
    
    public DaoPedido(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Pedido pedido) {
        DaoItemPedido daoItemPedido = new DaoItemPedido(conn);
        PreparedStatement ps = null;
        try {
            for(ItemPedido ip : pedido.getItenspedido()){
                ps = conn.prepareStatement("UPDATE PRODUTO set QTDEDISPONIVEL = QTDEDISPONIVEL - ? WHERE CODIGO = ?");
                ps.setInt(1, ip.getQtdeVendida());
                ps.setInt(2, ip.getProduto().getCodigo());   
                ps.execute();
                
                ps = conn.prepareStatement("UPDATE CLIENTE set LIMITEDISP = LIMITEDISP - ? * ? WHERE CPF = ?");
                ps.setInt(1, ip.getQtdeVendida());
                ps.setDouble(2, ip.getProduto().getPrecoUnit());
                ps.setString(3, ip.getPedido().getCliente().getCpf());
                
                ps.execute();
            }
            
            ps = conn.prepareStatement("INSERT INTO PEDIDO" + 
                                                        "(numero,dataEmissaoPedido,datapagto,status,cpfcliente,cpfvendedor)" + 
                                                        "VALUES(?,?,?,?,?,?)");
            ps.setInt(1, pedido.getNumero());
            ps.setString(2, pedido.getDataEmissaoPedido());
            ps.setString(3, pedido.getDataPgto());
            ps.setBoolean(4, pedido.getStatus());
            ps.setString(5, pedido.getCliente().getCpf());
            ps.setString(6, pedido.getVendedor().getCpf());
            
            ps.execute();
            Integer cont = 0;
            
            while (cont < pedido.getItenspedido().size()) {
                daoItemPedido.inserir(pedido.getItenspedido().get(cont));
                cont++;
            }     
            
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Pedido pedido) {
        DaoItemPedido daoItemPedido = new DaoItemPedido(conn);
        
        PreparedStatement ps = null;
        PreparedStatement pb = null;
        PreparedStatement pp = null;
        boolean f1 = false, f2 = false;
        try {
               for(ItemPedido ip : pedido.getItenspedido()){
                /*ps = conn.prepareStatement("UPDATE PRODUTO set QTDEDISPONIVEL = ? WHERE CODIGO = ?");
                ps.setInt(1, ip.getProduto().getQtdeDisponivel());
                ps.setInt(2, ip.getProduto().getCodigo());   
                ps.executeQuery();*/
                
                ps = conn.prepareStatement("UPDATE CLIENTE set LIMITEDISP = LIMITEDISP + ? * ? WHERE CPF = ?");
                ps.setInt(1, ip.getQtdeAntiga());
                ps.setDouble(2, ip.getProduto().getPrecoUnit());
                ps.setString(3, pedido.getCliente().getCpf());
                ps.executeQuery();

               }
               ps = null;
               daoItemPedido.excluir(pedido.getNumero());
               Integer cont = 0;
               while (cont < pedido.getItenspedido().size()) {   
                    daoItemPedido.inserir(pedido.getItenspedido().get(cont));
                    cont++;
                }
               for(ItemPedido ip : pedido.getItenspedido()){
                ps = conn.prepareStatement("UPDATE PRODUTO set QTDEDISPONIVEL = QTDEDISPONIVEL - ? WHERE CODIGO = ?");
                ps.setInt(1, ip.getQtdeVendida());
                ps.setInt(2, ip.getProduto().getCodigo());   
                ps.execute();
                
                ps = conn.prepareStatement("UPDATE CLIENTE set LIMITEDISP = LIMITEDISP - ? * ? WHERE CPF = ?");
                ps.setInt(1, ip.getQtdeVendida());
                ps.setDouble(2, ip.getProduto().getPrecoUnit());
                ps.setString(3, pedido.getCliente().getCpf());
                
                ps.execute();
            }
               //ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
}
        
     public  Pedido consultar (int numero) {
        Pedido d = null;
        DaoCliente daoCliente = new DaoCliente(conn);
        
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT NUMERO,TRUNC(DATAEMISSAOPEDIDO), DATAPAGTO, STATUS, CPFCLIENTE, CPFVENDEDOR from PEDIDO where NUMERO = ?");
            
           ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                d = new Pedido (numero, rs.getString("TRUNC(DATAEMISSAOPEDIDO)"));
                d.setDataPgto(rs.getString("DATAPAGTO"));
                //d.setStatus(rs.getBoolean("STATUS"));
                if(rs.getInt("STATUS") == 1){
                    d.setStatus(true);
                }else{
                    d.setStatus(false);
                }
                d.setCliente(daoCliente.consultar(rs.getString("CPFCLIENTE")));
                d.setVendedor(new DaoVendedor(conn).consultar(rs.getString("CPFVENDEDOR")));
                d.setItenspedido(new DaoItemPedido(conn).consultarPedido(numero));
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
            for(ItemPedido ip : pedido.getItenspedido()){
                ps = conn.prepareStatement("UPDATE PRODUTO set QTDEDISPONIVEL = ? WHERE CODIGO = ?");
                ps.setInt(1, ip.getProduto().getQtdeDisponivel());
                ps.setInt(2, ip.getProduto().getCodigo());   
                ps.execute();
                
                ps = conn.prepareStatement("UPDATE CLIENTE set LIMITEDISP = LIMITEDISP + ? * ? WHERE CPF = ?");
                ps.setInt(1, ip.getQtdeVendida());
                ps.setDouble(2, ip.getProduto().getPrecoUnit());
                ps.setString(3, pedido.getCliente().getCpf());

            }
            
            ps = conn.prepareStatement("DELETE FROM ITEMPEDIDO where numeropedido = ?");
            ps.setInt(1, pedido.getNumero());
            ps.execute();
            
            ps = conn.prepareStatement("DELETE FROM PEDIDO where numero = ?");
            ps.setInt(1, pedido.getNumero());
            ps.execute();
            
            
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
} 