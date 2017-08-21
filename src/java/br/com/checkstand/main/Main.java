package br.com.checkstand.main;

import br.com.checkstand.bens.Usuario;
import br.com.checkstand.jdbc.Conexao;
import br.com.checkstand.jdbc.UsuarioDao;
import java.util.List;

/**
 * @author Alex Souza
 */
public class Main {
    public static void main(String[] args) {
       conexao();
       //cadastrarUsuario();
       //alterarUsuario();
        //listarUsuario();
     // excluirUsuario();
       
    }   

    public static void conexao() {
        Conexao.getConnection();
    }

    public static void cadastrarUsuario() {
        
        Usuario usuario = new Usuario();        
        usuario.setNome("Marcio Silva");
        usuario.setLogin("msilva");
        usuario.setSenha("123");
        usuario.setMatricula("123456");
        usuario.setPerfil("passador");
        
        UsuarioDao usuariodao = new UsuarioDao();
        usuariodao.cadastrar(usuario);
    }

    public static void alterarUsuario() {
        Usuario usuario = new Usuario();
         usuario.setNome("Marcio Braga");
        usuario.setLogin("mbraga");
        usuario.setSenha("123");
        usuario.setMatricula("1234");
        usuario.setPerfil("admin");
        usuario.setId(1);
        UsuarioDao usuariodao = new UsuarioDao();
        usuariodao.editar(usuario);       
    }

    public static void listarUsuario() {
        Usuario usuario = new Usuario();
        UsuarioDao usuariodao = new UsuarioDao();
        List<Usuario> lista = usuariodao.listar(usuario);
        for(Usuario user: lista){
            System.out.println("Id: "+user.getId());
            System.out.println("Nome: "+user.getNome());
            System.out.println("Login: "+user.getLogin());
            System.out.println("Senha: "+user.getSenha());
            System.out.println("Matricula: "+user.getMatricula());
            System.out.println("Perfil: "+user.getPerfil());
            System.out.println("================================================");        
        }
    }

    public static void excluirUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(2);
        UsuarioDao usuariodao = new UsuarioDao();
        usuariodao.excluir(usuario);   
    }    
}