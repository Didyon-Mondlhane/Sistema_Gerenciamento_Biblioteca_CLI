package DataAccessObject;

import Configurations.Configuration;
import Entity.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAO {

    public int getUltimoId() throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String sql = "SELECT MAX(codigo) as max_id FROM administradores";
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

    public void cadastrarAdministrador(Administrador admin) throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String sql = "INSERT INTO administradores (codigo, nome, bi, idade, email, senha) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, admin.getCodigo());
        ps.setString(2, admin.getNome());
        ps.setString(3, admin.getBi());
        ps.setInt(4, admin.getIdade());
        ps.setString(5, admin.getEmail());
        ps.setString(6, admin.getSenha());
        ps.executeUpdate();
        conn.close();
    }

    public static List<Administrador> listarAdministradores() throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String sql = "SELECT * FROM administradores";
        List<Administrador> listaAdmin = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Administrador admin = new Administrador(
                    rs.getInt("codigo"),
                    rs.getString("nome"),
                    rs.getString("bi"),
                    rs.getInt("idade"),
                    rs.getString("email"),
                    rs.getString("senha")
                );
                listaAdmin.add(admin);
            }
        conn.close();
        return listaAdmin;
    }

    public Administrador encontrarAdministrador(int codigo) throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String sql = "SELECT * FROM administradores WHERE codigo = ?";
        
        Administrador administrador = null;
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
            
        if (rs.next()) {
            administrador = new Administrador(
                rs.getInt("codigo"),
                rs.getString("nome"),
                rs.getString("bi"),
                rs.getInt("idade"),
                rs.getString("email"),
                rs.getString("senha")
            );
        }
        conn.close();
        return administrador;

    }

    public static void apagarAdministradores(int codigo) throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String sql = "DELETE FROM administradores WHERE codigo = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, codigo);
        ps.executeUpdate();
        conn.close();
    }
    
}