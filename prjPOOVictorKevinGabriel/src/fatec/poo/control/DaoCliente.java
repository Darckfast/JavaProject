    package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Cliente;

public class DaoCliente {

    private Connection conn;
    
    public DaoCliente(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO CLIENTE"
                    + "(cpf, nome, endereco, cidade, cep, uf, ddd, telefone, limiteCred, limiteDisp)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?)");
            
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getCidade());
            ps.setString(5, cliente.getCep());
            ps.setString(6, cliente.getUf());
            ps.setString(7, cliente.getDdd());
            ps.setString(8, cliente.getTelefone());
            ps.setDouble(9, (cliente.getLimiteCred()));
            ps.setDouble(10,(cliente.getLimiteDisp()));
           
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE CLIENTE SET nome = ?, endereco = ?, cidade = ?, cep = ?, uf = ?, ddd = ?, telefone= ?, limiteCred = ?, limiteDisp = ? where cpf = ?");
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getCidade());
            ps.setInt(4, Integer.parseInt(cliente.getCep()));
            ps.setString(5, cliente.getUf());
            ps.setInt(6, Integer.parseInt(cliente.getDdd()));
            ps.setInt(7, Integer.parseInt(cliente.getTelefone()));
            ps.setDouble(8, cliente.getLimiteCred());
            ps.setDouble(9, cliente.getLimiteDisp());
            ps.setString(10, cliente.getCpf());
           

            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
        
     public  Cliente consultar (String cpf) {
        Cliente d = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM CLIENTE WHERE " +
                                                 "CPF = ?");
            
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next() == true) {
            d = new Cliente (cpf, rs.getString("nome"), rs.getDouble("limiteCred"));
            d.setCep(rs.getString("cep"));
            d.setCidade(rs.getString("cidade"));
            d.setDdd(rs.getString("ddd"));
            d.setEndereco(rs.getString("endereco"));
            d.setTelefone(rs.getString("telefone"));
            d.setLimiteDisp(rs.getDouble("limitedisp"));
            d.setUf(rs.getString("uf"));
            d.setLimiteCredAntigo(rs.getDouble("limiteCred"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (d);
    }    
     
     public void excluir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM CLIENTE where cpf = ?");
            
            ps.setString(1, cliente.getCpf());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
        
    }
    public Cliente Limite (String cpf) {
        Cliente d = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT LIMITEDISP FROM CLIENTE WHERE " +
                                                 "CPF = ?");
            
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            d.setLimiteCredAntigo(rs.getDouble("LIMITEDISP"));
           
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (d);
    }   
}





