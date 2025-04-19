package DataAccessObject;


import Configurations.Configuration;
import Entity.Livro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    private LivroDAO livroDAO = new LivroDAO();

    public void adicionarLivro(Livro livro) throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String query = "INSERT INTO livros (titulo, autor, isbn, numero_copias) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, livro.getTitulo());
        ps.setString(2, livro.getAutor());
        ps.setString(3, livro.getIsbn());
        ps.setInt(4, livro.getNumeroCopias());
        ps.executeUpdate();
        conn.close();
    }

    public void removerLivro(String isbn) throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String query = "DELETE FROM livros WHERE isbn = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, isbn);
        ps.executeUpdate();
        conn.close();
    }

    /*public static List<Livro> listarLivros() throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String sql = "SELECT * FROM livros";
        List<Livro> livros = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);
        
        while (rs.next()) {
            Livro livro = new Livro(
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("isbn"),
                rs.getInt("numero_copias")
            );
            livros.add(livro);
        }
        conn.close();
        return livros;

    }*/

    public static List<Livro> listarLivros() throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String query = "SELECT * FROM livros";
        Statement ps = conn.createStatement();
        ResultSet rs = ps.executeQuery(query);
        List<Livro> livros = new ArrayList<>();
        while (rs.next()) {
            Livro livro = new Livro(
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("isbn"),
                rs.getInt("numero_copias")
            );
            livros.add(livro);
        }
        conn.close();
        return livros;
    }

    public void actualizarNumeroCopias(Livro livro) throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String query = "UPDATE livros SET numero_copias = ? WHERE isbn = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, livro.getNumeroCopias());
        ps.setString(2, livro.getIsbn());
        ps.executeUpdate();
        conn.close();
    }

    public void registarEmprestimo(Livro livro) throws SQLException {

        if (livro.getNumeroCopias() > 0) {
            livro.setNumeroCopias(livro.getNumeroCopias() - 1);
            livroDAO.actualizarNumeroCopias(livro);
            System.out.println("Empréstimo registado. Cópias restantes: " + livro.getNumeroCopias());
        } else {
            System.out.println("Não há cópias disponíveis para empréstimo.");
        }
    }

    public void registarDevolucao(Livro livro) throws SQLException {
        
        livro.setNumeroCopias(livro.getNumeroCopias() + 1);
        livroDAO.actualizarNumeroCopias(livro);
        System.out.println("Devolução registada. Cópias disponíveis: " + livro.getNumeroCopias());

        /*if (diasAtraso > 0) {
            MultaLivro calcularMulta = new MultaService();
            calcularMulta.calcularMulta(diasAtraso);
        }*/
        
    }

    public static Livro obterLivroPorISBN(String isbn) throws SQLException {
        Connection conn = Configuration.getConfiguration();
        String query = "SELECT * FROM livros WHERE isbn = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, isbn);
        ResultSet rs = ps.executeQuery();
        
        Livro livro = null;
        if (rs.next()) {
            livro = new Livro(
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("isbn"),
                rs.getInt("numero_copias")
            );
        }
        conn.close();
        return livro;
    }    
    
}
