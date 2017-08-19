package br.com.checkstand.jdbc;

import br.com.checkstand.bens.Produto;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
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
public class ProdutoDao implements IProdutoDao{
    
     private Connection conexao = Conexao.getConnection();
     
     @Override
     public void cadastar(Produto produto){
     
         try {
             String sql = "INSERT INTO produto(codigo, nome, quantidade, preco) values (?, ?, ?, ?)";
             
             PreparedStatement prepared = (PreparedStatement) conexao.prepareStatement(sql);
             prepared.setString(1, produto.getCodigo());
             prepared.setString(2, produto.getNome());
             prepared.setString(3, produto.getQuantidade());
             prepared.setString(4, produto.getPreco());
             
             prepared.executeUpdate();
             prepared.close();
             JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso!");
             
         } catch (SQLException ex) {
             Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);             
             JOptionPane.showMessageDialog(null,"Erro ao inserir os dados!  "+ex.getMessage());
             throw new RuntimeException("Erro ao inserir os dados! "+ex.getMessage());
         }
     }
     @Override
     public void excluir(Produto produto){
         try {
             String sql = "delete from produto where id = ?";
             
             PreparedStatement prepared = (PreparedStatement) conexao.prepareStatement(sql);
             prepared.setInt(1, produto.getId());
             
             prepared.executeUpdate();
             prepared.close();
             JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
        
          } catch (SQLException ex) {
             Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Erro ao excluir os dados! "+ex.getMessage());
             throw new RuntimeException("Erro ao excluir os dados! "+ex.getMessage());
          }        
     } 
     @Override
    public List<Produto> listar(Produto produto){
         try {
             String sql = "select * from produto";
             List <Produto> lista = new ArrayList<Produto>();
             
             PreparedStatement prepared =  (PreparedStatement) conexao.prepareStatement(sql);
             ResultSet result = prepared.executeQuery();
             while (result.next()){
             Produto prod = new Produto();
             prod.setId(result.getInt("id"));
             prod.setCodigo(result.getString("codigo"));
             prod.setNome(result.getString("nome"));
             prod.setQuantidade(result.getString("quantidade"));
             prod.setPreco(result.getString("preco"));
             lista.add(prod);
             }
             prepared.close();
             result.close();
                        
             return lista;
             
         } catch (SQLException ex) {
             Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,"Erro ao  listar os dados! "+ex.getMessage());
             throw new RuntimeException("Erro ao listar os dados! "+ex.getMessage());
         }          
    }  
     @Override
    public void editar(Produto produto){
         try {
                String sql = "update produto set codigo = ?, nome = ?, quantidade = ?, preco = ? where  id = ?";
             
             PreparedStatement prepared = (PreparedStatement) conexao.prepareStatement(sql);
             prepared.setString(1, produto.getCodigo());
             prepared.setString(2, produto.getNome());
             prepared.setString(3, produto.getQuantidade());
             prepared.setString(4, produto.getPreco());
             prepared.setInt(5, produto.getId());
             
             prepared.executeUpdate();
             prepared.close();
             JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
             
         } catch (SQLException ex) {             
             Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
             throw new RuntimeException("Erro ao alterar os dados! "+ex.getMessage());
         }
    }
    
      
     @Override
    public void alterarProdutoCodigo(Produto produto){
         try {
                String sql = "update produto set id = ?, nome = ?, quantidade = ?, preco = ? where  codigo = ?";
             
             PreparedStatement prepared = (PreparedStatement) conexao.prepareStatement(sql);
             prepared.setInt(1, produto.getId());
             prepared.setString(2, produto.getNome());
             prepared.setString(3, produto.getQuantidade());
             prepared.setString(4, produto.getPreco());
             prepared.setString(5, produto.getCodigo());
             
             prepared.executeUpdate();
             prepared.close();
             JOptionPane.showMessageDialog(null, "Produto Retirado Com Sucesso!");
             
         } catch (SQLException ex) { 
             Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
             throw new RuntimeException("Erro ao retirar produto! "+ex.getMessage());
         }
    }
    
     @Override
       public Produto buscarId(int id) {
           Produto produtoRetorno = null;
           String sql = "select * from produto where id = ?";
        try {
            PreparedStatement prepared = (PreparedStatement) conexao.prepareStatement(sql);
            prepared.setInt(1, id);//pega o id do indice 1
            ResultSet result = prepared.executeQuery();//executa a pesquisa e retorna no resultado
            
            if(result.next()){//Se tem registro pega o primeiro registro retornado no ResultSet, pra isso foi instceado o pessoa
            produtoRetorno = new Produto();
            produtoRetorno.setId(result.getInt("id"));
            produtoRetorno.setCodigo(result.getString("codigo"));
            produtoRetorno.setNome(result.getString("nome"));
            produtoRetorno.setQuantidade(result.getString("quantidade"));
            produtoRetorno.setPreco(result.getString("preco"));
            }
            System.out.println("Encontrado com Sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro SQL: "+ex.getMessage());
        }        
            return produtoRetorno;//retorna valor para servlet acao alterar
    }
       
     @Override
        public Produto buscarProduto(String codigo) {
           Produto produtoRetorno = null;
           String sql = "select * from produto where codigo = ?";
        try {
            PreparedStatement prepared = (PreparedStatement) conexao.prepareStatement(sql);
            prepared.setString(1, codigo);
            ResultSet result = prepared.executeQuery();
            
            if(result.next()){
            produtoRetorno = new Produto();
            produtoRetorno.setId(result.getInt("id"));
            produtoRetorno.setCodigo(result.getString("codigo"));
            produtoRetorno.setNome(result.getString("nome"));
            produtoRetorno.setQuantidade(result.getString("quantidade"));
            produtoRetorno.setPreco(result.getString("preco"));
            }          
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro SQL: "+ex.getMessage());
        }        
            return produtoRetorno;//retorna valor para servlet acao Pesquisar Produto
    }
        
     @Override
          public Produto buscarCodigo(String codigo) {
           Produto produtoRetorno = null;
           String sql = "select * from produto where codigo = ?";
        try {
            PreparedStatement prepared = (PreparedStatement) conexao.prepareStatement(sql);
            prepared.setString(1, codigo);
            ResultSet result = prepared.executeQuery();
            
            if(result.next()){
            produtoRetorno = new Produto();
            produtoRetorno.setId(result.getInt("id"));
            produtoRetorno.setCodigo(result.getString("codigo"));
            produtoRetorno.setNome(result.getString("nome"));
            produtoRetorno.setQuantidade(result.getString("quantidade"));
            produtoRetorno.setPreco(result.getString("preco"));
            JOptionPane.showMessageDialog(null,"Produto já cadastrado! ");
            }          
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro SQL: "+ex.getMessage());
        }        
            return produtoRetorno;//retorna valor para salvarProduto.jsp
    }
    
}