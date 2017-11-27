package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Pessoa;

public class DaoPessoa {

    private Connection conn;
    
    public DaoPessoa(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Pessoa pessoa) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbpessoa(cpf, nome, endereco,cidade,cep,uf,ddd,telefone) VALUES(?,?,?,?,?,?,?,?)");
            
            ps.setString(1, pessoa.getCpf());
            ps.setString(2, pessoa.getNome());
            ps.setString(3, pessoa.getEndereco());
            ps.setString(4, pessoa.getCidade());
            ps.setString(5, pessoa.getCep());
            ps.setString(6, pessoa.getUf());
            ps.setString(7, pessoa.getDdd());
            ps.setString(8, pessoa.getTelefone());
            
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Pessoa pessoa) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbpessoa set nome = ? " +
                                                            "endereco = ?" +
                                                            "cidade = ?" +
                                                            "cep = ?" +
                                                            "uf = ?" +
                                                            "ddd = ?" +
                                                            "telefone = ?" +
                                                            "where cpf = ?");
            
            ps.setString(1, pessoa.getCpf());
            ps.setString(2, pessoa.getNome());
            ps.setString(3, pessoa.getEndereco());
            ps.setString(4, pessoa.getCidade());
            ps.setString(5, pessoa.getCep());
            ps.setString(6, pessoa.getUf());
            ps.setString(7, pessoa.getDdd());
            ps.setString(8, pessoa.getTelefone());

            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
        
     public  Pessoa consultar (String cpf) {
        Pessoa d = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbpessoa where " +
                                                 "cpf = ?");
            
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                d = new Pessoa (cpf, rs.getString("nome"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (d);
    }    
     
     public void excluir(Pessoa pessoa) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbpessoa where cpf = ?");
            
            ps.setString(1, pessoa.getCpf());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}





