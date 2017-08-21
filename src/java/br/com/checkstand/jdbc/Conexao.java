package br.com.checkstand.jdbc;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Alex Souza
 */
public class Conexao {   
    public static Connection getConnection(){
        Connection conexao = null;
         try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/checkstand","root","");
            System.out.println("Conectado com sucesso!");
            return conexao;
                         
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            throw  new RuntimeException("Erro SQLException ao abrir a conexão! ", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ClassNotFoundException!", ex);
        }                
    }     
}