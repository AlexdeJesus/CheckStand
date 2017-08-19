package br.com.checkstand.jdbc;
import br.com.checkstand.bens.Usuario;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Alex Souza
 */
public class UsuarioDao implements IUsuarioDao{
    
     private Connection conexao = Conexao.getConnection();     
     
     public void cadastrar(Usuario usuario){
         try {
             String sql = "INSERT INTO usuario(nome, login, senha, matricula, perfil) values(?, ?, ?, ?, ?)";
             
             PreparedStatement prepared =  (PreparedStatement) conexao.prepareStatement(sql);
             prepared.setString(1, usuario.getNome());
             prepared.setString(2, usuario.getLogin());
             prepared.setString(3, usuario.getSenha());
             prepared.setString(4, usuario.getMatricula());
             prepared.setString(5, usuario.getPerfil());
             
             prepared.executeUpdate();
             prepared.close();
             JOptionPane.showMessageDialog(null,"Usuário Cadastrado Com Sucesso!");
             
         } catch (SQLException ex) {
             Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
             throw new RuntimeException("Erro ao inserir os dados");
         }     
     }
     
       public Usuario buscarMatricula(String matricula) {
           Usuario usuarioRetorno = null;
           String sql = "select * from usuario where matricula = ?";
        try {
            PreparedStatement prepared = (PreparedStatement) conexao.prepareStatement(sql);
            prepared.setString(1, matricula);
            ResultSet result = prepared.executeQuery();//executa a pesquisa e retorna no resultado
            
            if(result.next()){//Se tem registro pega o primeiro registro retornado no ResultSet, pra isso foi instceado o pessoa
            usuarioRetorno = new Usuario();
            usuarioRetorno.setId(result.getInt("id"));
            usuarioRetorno.setNome(result.getString("nome"));
            usuarioRetorno.setLogin(result.getString("login"));
            usuarioRetorno.setSenha(result.getString("senha"));            
            usuarioRetorno.setMatricula(result.getString("matricula"));
                           
            JOptionPane.showMessageDialog(null, "Usuario já cadastrado!! ");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro SQL: "+ex.getMessage());
        }        
            return usuarioRetorno;
    } 
     
     public void editar(Usuario usuario){
         try {
             String sql = "UPDATE  usuario SET nome = ?, login = ?, senha =  ?, matricula = ?, perfil = ? WHERE id = ?";
             
             PreparedStatement prepared =  (PreparedStatement) conexao.prepareStatement(sql);
             prepared.setString(1, usuario.getNome());
             prepared.setString(2, usuario.getLogin());
             prepared.setString(3, usuario.getSenha());
             prepared.setString(4, usuario.getMatricula());
             prepared.setString(5, usuario.getPerfil());
             prepared.setInt(6, usuario.getId());
             
             prepared.executeUpdate();
             prepared.close();
             JOptionPane.showMessageDialog(null,"Dados Alterados Com Sucesso!");
             
         } catch (SQLException ex) {
             Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
              throw new RuntimeException("Erro sql! "+ex.getMessage());
         }     
     }    
     
       public Usuario buscarId(int id) {
           Usuario usuarioRetorno = null;
           String sql = "select * from usuario where id = ?";
        try {
            PreparedStatement prepared = (PreparedStatement) conexao.prepareStatement(sql);
            prepared.setInt(1, id);//pega o id do indice 1
            ResultSet resultado = prepared.executeQuery();//executa a pesquisa e retorna no resultado
            
            if(resultado.next()){//Se tem registro pega o primeiro registro retornado no ResultSet, pra isso foi instceado o pessoa
            usuarioRetorno = new Usuario();
            usuarioRetorno.setId(resultado.getInt("id"));
            usuarioRetorno.setNome(resultado.getString("nome"));
            usuarioRetorno.setLogin(resultado.getString("login"));
            usuarioRetorno.setSenha(resultado.getString("senha"));            
            usuarioRetorno.setMatricula(resultado.getString("matricula"));
            usuarioRetorno.setPerfil(resultado.getString("perfil"));            
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro SQL: "+ex.getMessage());
        }        
            return usuarioRetorno;//retorna valor para servlet acao alterar
    }
       
        public Usuario buscarUsuario(String matricula) {
           Usuario usuarioRetorno = null;
           String sql = "select * from usuario where matricula = ?";
        try {
            PreparedStatement prepared = (PreparedStatement) conexao.prepareStatement(sql);
            prepared.setString(1, matricula);
            ResultSet result = prepared.executeQuery();//executa a pesquisa e retorna no resultado
            
            if(result.next()){//Se tem registro pega o primeiro registro retornado no ResultSet, pra isso foi instceado o pessoa
            usuarioRetorno = new Usuario();
            usuarioRetorno.setId(result.getInt("id"));
            usuarioRetorno.setNome(result.getString("nome"));
            usuarioRetorno.setLogin(result.getString("login"));
            usuarioRetorno.setSenha(result.getString("senha"));            
            usuarioRetorno.setMatricula(result.getString("matricula"));
            
            }else{
                JOptionPane.showMessageDialog(null, "Usuario nao cadastrado! ");
            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Usuario nao cadastrado! "+ex.getMessage());
            throw new RuntimeException("Erro SQL: "+ex.getMessage());
        }        
            return usuarioRetorno;//retorna valor para servlet acao Pesquisar Usuario
    } 
     
       public void excluir(Usuario usuario){
         try {
             String sql = "DELETE FROM usuario WHERE id = ?";
             
             PreparedStatement prepared =  (PreparedStatement) conexao.prepareStatement(sql);
             prepared.setInt(1, usuario.getId());
                          
             prepared.executeUpdate();
             prepared.close();
             JOptionPane.showMessageDialog(null,"Dados Excluidos Com Sucesso!");
             
         } catch (SQLException ex) {
             Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
              throw new RuntimeException("Erro ao Excluir dados");
         }     
     }
       
       public List<Usuario> listar(Usuario usuario){
           
             String sql = "SELECT * FROM usuario";
             List <Usuario>lista = new ArrayList<Usuario>();
         try {             
             PreparedStatement prepared = (PreparedStatement) conexao.prepareStatement(sql);
             ResultSet resultado = prepared.executeQuery();
             while(resultado.next()){
             Usuario user = new Usuario();
             user.setId(resultado.getInt("id"));
             user.setNome(resultado.getString("nome"));             
             user.setLogin(resultado.getString("login"));
             user.setSenha(resultado.getString("senha"));
             user.setMatricula(resultado.getString("matricula"));
             user.setPerfil(resultado.getString("perfil"));
             lista.add(user);      
             }             
             prepared.close();
             resultado.close();             
             
             return lista;
             
         } catch (SQLException ex) {
             Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
             throw new RuntimeException("Falha ao listar usuario!");      
         }
    }

        public Usuario autenticacao(Usuario usuario) {
           Usuario usuarioRetorno = null;
           String sql = "select * from usuario where login = ? and senha = ? and perfil = ?";
        try {
            PreparedStatement prepared = (PreparedStatement) conexao.prepareStatement(sql);
            prepared.setString(1, usuario.getLogin());
            prepared.setString(2, usuario.getSenha());
            prepared.setString(3, usuario.getPerfil());
            
            ResultSet resultado = prepared.executeQuery();
            
            if(resultado.next()){
            usuarioRetorno = new Usuario();             
            usuarioRetorno.setId(resultado.getInt("id")); 
            usuarioRetorno.setNome(resultado.getString("nome"));
            usuarioRetorno.setLogin(resultado.getString("login"));
            usuarioRetorno.setSenha(resultado.getString("senha"));
            usuarioRetorno.setMatricula(resultado.getString("matricula"));
            usuarioRetorno.setPerfil(resultado.getString("perfil"));
            }
                       
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro SQL: "+ex.getMessage());
        }        
            return usuarioRetorno;
    }    
}
