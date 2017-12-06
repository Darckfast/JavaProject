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
               /*Pedido d = null;
       ItemPedido itempedido = null;
       Produto produto = null;
       
       DaoCliente daoCliente = new DaoCliente(conn);
       DaoVendedor daoVendedor = new DaoVendedor(conn);

       PreparedStatement psP, psI, psPr = null;
        try {
            psP = conn.prepareStatement("SELECT * from PEDIDO where " +
                                                 "numero = ?");
            
            psP.setInt(1, numero);
            ResultSet rsP = psP.executeQuery();
           if(rsP.next() == true){
               Cliente c = daoCliente.consultar(rsP.getString("cpfcliente"));
               Vendedor v = daoVendedor.consultar(rsP.getString("cpfvendedor"));
               
                d = new Pedido (numero, rsP.getString("DATAEMISSAOPEDIDO"));
                d.setCliente(c);
                d.setVendedor(v);
                
                d.setDataPgto(rsP.getString("datapagto"));
                d.setStatus(rsP.getBoolean("status"));
                psI = conn.prepareStatement("SELECT * FROM ITEMPEDIDO WHERE NUMERO = ?");
                psI.setInt(1,d.getNumero());
                ResultSet rsI = psI.executeQuery();
                while(rsI.next() == true){
                    psP = conn.prepareStatement("SELECT * FROM PRODUTO WHERE CODIGO =?");
                    psP.setInt(1,rsI.getInt("CODIGOPRODUTO"));
                    
                    rsP = psP.executeQuery();
                    
                    if(rsP.next() == true){
                        produto = new Produto(rsI.getInt("CODIGOPRODUTO"), rsP.getString("DESCRICAO"));
                        produto.setQtdeDisponivel(rsP.getInt("QTDEDISPONIVEL"));
                        produto.setPrecoUnit(rsP.getDouble(("PRECOUNIT")));
                        produto.setEstoqueMin(rsP.getInt("ESTOQUEMIN"));
                        
                    }
                    itempedido = new ItemPedido(rsI.getInt("CODIGOPRODUTO"), rsI.getInt("QTDVENDIDA"));
                    itempedido.setProduto(produto);
                    itempedido.setPedido(d);
                    
                    d.getItenspedido().add(itempedido);
                    
                }
           }

        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }*/
       //return (d);
    //} 
        try {
            ps = conn.prepareStatement("SELECT * from PEDIDO where " +
                                                 "numero = ?");
            
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                d = new Pedido (numero, rs.getString("dataEmissaoPedido"));
                d.setDataPgto(rs.getString("datapagto"));
                d.setStatus(rs.getBoolean("status"));
                d.setCliente(new DaoCliente(conn).consultar(rs.getString("cpfcliente")));
                d.setVendedor(new DaoVendedor(conn).consultar(rs.getString("cpfvendedor")));
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