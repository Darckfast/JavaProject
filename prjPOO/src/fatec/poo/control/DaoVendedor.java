package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Vendedor;

public class DaoVendedor {

    private Connection conn;
    
    public DaoVendedor(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Vendedor vendedor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO VENDEDOR" + 
                                                    "(cpf, nome, salarioBase,comissao,endereco,cidade,cep,uf,ddd,telefone)" + 
                                                    " VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, vendedor.getCpf());
            ps.setString(2, vendedor.getNome());
            ps.setDouble(3, vendedor.getSalarioBase());
            ps.setDouble(4, vendedor.getComissao());
            ps.setString(5, vendedor.getEndereco());
            ps.setString(6, vendedor.getCidade());
            ps.setString(7, vendedor.getCep());
            ps.setString(8, vendedor.getUf());
            ps.setString(9, vendedor.getDdd());
            ps.setString(10, vendedor.getTelefone());
            
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Vendedor vendedor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE VENDEDOR" +
                                                              "SET nome = ?,"+ 
                                                              "salarioBase = ?," +
                                                              "comissao = ?," +
                                                              "endereco = ?," +
                                                              "cidade = ?," +
                                                              "cep = ?," +
                                                              "uf = ?," +
                                                              "ddd = ?," +
                                                              "telefone = ?" +
                                                              "where cpf = ?;");
            
            ps.setString(1, vendedor.getNome());
            ps.setDouble(2, vendedor.getSalarioBase());
            ps.setDouble(3, vendedor.getComissao());
            ps.setString(4, vendedor.getEndereco());
            ps.setString(5, vendedor.getCidade());
            ps.setString(6, vendedor.getCep());
            ps.setString(7, vendedor.getUf());
            ps.setString(8, vendedor.getDdd());
            ps.setString(9, vendedor.getTelefone());
            ps.setString(10, vendedor.getCpf());
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
        
     public  Vendedor consultar (String cpf) {
        Vendedor d = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from VENDEDOR where " +
                                                 "cpf = ?");
            
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                d = new Vendedor (cpf, rs.getString("nome"), rs.getDouble("salarioBase"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (d);
    }    
     
     public void excluir(Vendedor vendedor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM VENDEDOR where cpf = ?");
            
            ps.setString(1, vendedor.getCpf());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}





