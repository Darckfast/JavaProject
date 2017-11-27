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
            ps = conn.prepareStatement("INSERT INTO tbcliente(cpf, nome, limiteCred,limiteDisp,endereco,cidade,cep,uf,ddd,telefone)) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, String.valueOf(cliente.getLimiteCred()));
            ps.setString(4, String.valueOf(cliente.getLimiteDisp()));
            ps.setString(5, cliente.getEndereco());
            ps.setString(6, cliente.getCidade());
            ps.setString(7, cliente.getCep());
            ps.setString(8, cliente.getUf());
            ps.setString(9, cliente.getDdd());
            ps.setString(10, cliente.getTelefone());
           
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbcliente set nome = ? " + "limiteCred = ?" + "limiteDisp = ?" +
                                                 "where cpf = ?");
            
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, String.valueOf(cliente.getLimiteCred()));
            ps.setString(4, String.valueOf(cliente.getLimiteDisp()));

            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
        
     public  Cliente consultar (String cpf) {
        Cliente d = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbcliente where " +
                                                 "cpf = ?");
            
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                d = new Cliente (cpf, rs.getString("nome"), rs.getDouble("limiteCred"));
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
            ps = conn.prepareStatement("DELETE FROM tbcliente where cpf = ?");
            
            ps.setString(1, cliente.getCpf());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}





