package Entity;

public class Bibliotecario extends Utilizador {
    private String sector;

    public Bibliotecario(int codigo, String nome, String bi, int idade, String email, String sector, String senha) {
        super(codigo, nome, bi, idade, email, senha);
        this.sector = sector;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}

