package DataAccessObject;

import Configurations.Configuration;
import Entity.Bibliotecario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BibliotecarioDAO {

    public int getUltimoId() throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String sql = "SELECT MAX(codigo) as max_id FROM bibliotecarios";
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

    public void cadastrarBibliotecario(Bibliotecario bibliotecario) throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String sql = "INSERT INTO bibliotecarios (codigo, nome, bi, idade, email, sector, senha) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, bibliotecario.getCodigo());
        ps.setString(2, bibliotecario.getNome());
        ps.setString(3, bibliotecario.getBi());
        ps.setInt(4, bibliotecario.getIdade());
        ps.setString(5, bibliotecario.getEmail());
        ps.setString(6, bibliotecario.getSector());
        ps.setString(7,bibliotecario.getSenha());
        ps.executeUpdate();
        conn.close();
    }

    public static List<Bibliotecario> listarBibliotecarios() throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String sql = "SELECT * FROM bibliotecarios";
        List<Bibliotecario> listaBibliotecarios = new ArrayList<>();
    
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Bibliotecario bibliotecario = new Bibliotecario(
                rs.getInt("codigo"),
                rs.getString("nome"),
                rs.getString("bi"),
                rs.getInt("idade"),
                rs.getString("email"),
                rs.getString("sector"),
                rs.getString("senha")
            );
            listaBibliotecarios.add(bibliotecario);
        conn.close();
        }
        return listaBibliotecarios;
    }

    public Bibliotecario encontrarBibliotecario(int codigo) throws SQLException { 
        Connection conn = Configuration.getConfiguration();
        String sql = "SELECT codigo, nome, bi, idade, email, sector, senha FROM bibliotecarios WHERE codigo = ?";
        
        Bibliotecario bibliotecario = null;
    
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
            
        if (rs.next()) {
            bibliotecario = new Bibliotecario(
                    rs.getInt("codigo"),
                    rs.getString("nome"),
                    rs.getString("bi"),
                    rs.getInt("idade"),
                    rs.getString("email"),
                    rs.getString("sector"),
                    rs.getString("senha")
            );
        }
        conn.close();
        return bibliotecario;
    }

    public static void apagarBibliotecario(int codigo) throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String sql = "DELETE FROM bibliotecarios WHERE codigo = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, codigo);
        ps.executeUpdate();
        conn.close();
    }

}

