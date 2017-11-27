package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Produto;

public class DaoProduto {

    private Connection conn;
    
    public DaoProduto(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Produto produto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbproduto(codigo, descricao,qtdeDisponivel,precoUnit,estoqueMin) VALUES(?,?,?,?,?)");
            ps.setString(1, String.valueOf(produto.getCodigo()));
            ps.setString(2, produto.getDescricao());
            ps.setString(3, String.valueOf(produto.getQtdeDisponivel()));
            ps.setString(4, String.valueOf(produto.getPrecoUnit()));
            ps.setString(5, String.valueOf(produto.getEstoqueMin()));
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Produto produto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbproduto set descricao = ? " +
                                                            "qtdedisponivel = ?" +
                                                            "precounit = ?" +
                                                            "estoquemin = ?" +
                                                            "where codigo = ?");
            ps.setString(1, String.valueOf(produto.getCodigo()));
            ps.setString(2, produto.getDescricao());
            ps.setString(3, String.valueOf(produto.getQtdeDisponivel()));
            ps.setString(4, String.valueOf(produto.getPrecoUnit()));
            ps.setString(5, String.valueOf(produto.getEstoqueMin()));
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
        
     public  Produto consultar (int codigo) {
        Produto d = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbproduto where " +
                                                 "codigo = ?");
            
            ps.setString(1, String.valueOf(codigo));
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                d = new Produto (codigo, rs.getString("descricao"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (d);
    }    
     
     public void excluir(Produto produto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbproduto where codigo = ?");
            
            ps.setString(1, String.valueOf(produto.getCodigo()));
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}





