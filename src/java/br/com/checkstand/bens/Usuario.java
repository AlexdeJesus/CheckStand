package br.com.checkstand.bens;
/**
 * @author Alex Souza
 */
public class Usuario {
    private int cd;
    private String nome;
    private String matricula;
    private String login;
    private String senha;
    private String perfil;

    public int getId() {
        return cd;
    }

    public void setId(int cd) {
        this.cd = cd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    } 
}
