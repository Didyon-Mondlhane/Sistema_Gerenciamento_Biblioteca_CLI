package DataAccessObject;


import Configurations.Configuration;
import Entity.Leitor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeitorDAO {

    public int getUltimoId() throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String sql = "SELECT MAX(codigo) as max_id FROM leitores";
        int ultimoId = 2200000;
    
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Integer maxId = rs.getObject("max_id") != null ? rs.getInt("max_id") : null;
            if (maxId != null) {
                ultimoId = maxId;
            }
        }
        conn.close();
        return ultimoId;

    }

    public void cadastrarLeitor(Leitor leitor) throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String sql = "INSERT INTO leitores (codigo, nome, bi, idade, email, senha) VALUES (?, ?, ?, ?, ?, ?)";
    
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, leitor.getCodigo());
        ps.setString(2, leitor.getNome());
        ps.setString(3, leitor.getBi());
        ps.setInt(4, leitor.getIdade());
        ps.setString(5, leitor.getEmail());
        ps.setString(6, leitor.getSenha());
        ps.executeUpdate();
        conn.close();

    }

    public static List<Leitor> listarLeitores() throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String sql = "SELECT * FROM leitores";
        List<Leitor> listaLeitores = new ArrayList<>();
    
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Leitor leitor = new Leitor(
                rs.getInt("codigo"),
                rs.getString("nome"),
                rs.getString("bi"),
                rs.getInt("idade"),
                rs.getString("email"),
                rs.getString("senha")
            );
            listaLeitores.add(leitor);
            }
        conn.close();
        return listaLeitores;
    }

    public Leitor encontrarLeitor(int codigo) throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String sql = "SELECT codigo, nome, bi, idade, email, senha FROM leitores WHERE codigo = ?";
        
        Leitor leitor = null;
    
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
            
        while (rs.next()) {
                leitor = new Leitor(
                rs.getInt("codigo"),
                rs.getString("nome"),
                rs.getString("bi"),
                rs.getInt("idade"),
                rs.getString("email"),
                rs.getString("senha")
            );
        }
        conn.close();
        return leitor;
        
    }

    public static void apagarLeitor(int codigo) throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String sql = "DELETE FROM leitores WHERE codigo = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, codigo);
        ps.executeUpdate();
        conn.close();
    }

}

