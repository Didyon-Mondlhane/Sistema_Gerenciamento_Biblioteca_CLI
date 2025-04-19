package Entity;

public abstract class Utilizador {
    
    private int codigo;
    private String nome;
    private String bi;
    private int idade;
    private String email;
    private String senha;

    public Utilizador(int codigo, String nome, String bi, int idade, String email, String senha) {
        this.codigo=codigo;
        this.nome = nome;
        this.bi = bi;
        this.idade = idade;
        this.email = email;
        this.senha=senha;
    }

    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}