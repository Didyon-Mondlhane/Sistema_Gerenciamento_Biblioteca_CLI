package Entity;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int numeroCopias;

    public Livro(String titulo, String autor, String isbn, int numeroCopias) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.numeroCopias = numeroCopias;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumeroCopias() {
        return numeroCopias;
    }

    public void setNumeroCopias(int numeroCopias) {
        this.numeroCopias = numeroCopias;
    }

}
