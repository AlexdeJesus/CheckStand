package br.com.checkstand.jdbc;

import br.com.checkstand.bens.Usuario;
import java.util.List;

/*
 * @author Alex Souza
 */
public interface IUsuarioDao {
      public void cadastrar(Usuario usuario);      
      public Usuario buscarMatricula(String matricula);
      public void editar(Usuario usuario);
      public Usuario buscarId(int id);
      public Usuario buscarUsuario(String matricula);
      public void excluir(Usuario usuario);
      public List<Usuario> listar(Usuario usuario);
      public Usuario autenticacao(Usuario usuario);  
}
