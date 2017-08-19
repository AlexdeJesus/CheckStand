package br.com.checkstand.controller;
import br.com.checkstand.bens.Produto;
import br.com.checkstand.bens.Usuario;
import br.com.checkstand.jdbc.ProdutoDao;
import br.com.checkstand.jdbc.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
/**
 * @author Alex Souza
 */
public class ProdutoControllador extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    
        Produto produto = new Produto();
        String acao = request.getParameter("acao");
        ProdutoDao produtodao = new ProdutoDao();
        
        //Cadastrar 
        if (acao != null && acao.equals("cadastrarProduto")){
            request.getRequestDispatcher("cadastrarProduto.jsp").forward(request, response);
            
        //Listar
        }else if(acao != null && acao.equals("listar")){
            List<Produto> lista = produtodao.listar(produto);        
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("listarProduto.jsp").forward(request, response);  
        
        //Excluir
        }else if (acao != null && acao.equals("excluir")){
            String id = request.getParameter("id");
            produto.setId(Integer.parseInt(id));
            produtodao.excluir(produto);
            response.sendRedirect("ProdutoControllador?acao=listar");
        
        //Alterar
        }else if(acao != null && acao.equals("alterar")){
            String id = request.getParameter("id");
            produto = produtodao.buscarId(Integer.parseInt(id));
            request.setAttribute("produto", produto);
            request.getRequestDispatcher("alterarProduto.jsp").forward(request, response);
        
        //Pesquisar Produto    
        }else if(acao != null && acao.equals("pesquisarProduto")){
            request.getRequestDispatcher("pesquisarProduto.jsp").forward(request, response);
       
        //Retira Produto    
        }else if(acao != null && acao.equals("retiraProduto")){
            request.getRequestDispatcher("retiraProduto.jsp").forward(request, response);            
        
        //Pesquisar Produto Passador   
        }else if(acao != null && acao.equals("pesquisarProdutoPassador")){
            request.getRequestDispatcher("pesquisarProdutoPassador.jsp").forward(request, response);
        
        //Pesquisar Produto Passador 
        }else if(acao != null && acao.equals("retiraProdutoPassador")){
            request.getRequestDispatcher("retiraProdutoPassador.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
            String acao = request.getParameter("acao");
            ProdutoDao produtodao = new ProdutoDao();
            Produto produto = new Produto();
            
            //Alterar (Dados já alterados pelo usuario)
        if(acao != null && acao.equals("alterar")){
            String id = request.getParameter("id");
            String codigo = request.getParameter("codigo");
            String nome = request.getParameter("nome");
            String quantidade = request.getParameter("quantidade");
            String preco = request.getParameter("preco");       

            produto.setCodigo(codigo);
            produto.setNome(nome);
            produto.setQuantidade(quantidade);
            produto.setPreco(preco);
            produto.setId(Integer.parseInt(id));        

            produtodao.editar(produto);
            response.sendRedirect("ProdutoControllador?acao=listar");             
            //Fim da acao alterar
            
        }else if (acao != null && acao.equals("pesquisarProduto")){   
            String codigo = request.getParameter("codigo");
            produto = produtodao.buscarProduto(codigo);
            if(produto != null){
            request.setAttribute("produto", produto);
            request.getRequestDispatcher("produtoEncontrado.jsp").forward(request, response);                
            }else if(produto == null){
               JOptionPane.showMessageDialog(null,"Produto não cadastrado! ");  
               request.getRequestDispatcher("pesquisarProduto.jsp").forward(request, response);
            }
            //Fim da acao pesquisarProduto
            
        }else if(acao != null && acao.equals("retirarProduto")){
            String codigo = request.getParameter("codigo");
            produto = produtodao.buscarProduto(codigo);
            if(produto != null){
                request.setAttribute("produto", produto);
                request.getRequestDispatcher("retirarProduto.jsp").forward(request, response);                
                
            }else if(produto == null ){
                 JOptionPane.showMessageDialog(null,"Produto Não Cadastrado! ");                   
            }
            request.getRequestDispatcher("retiraProduto.jsp").forward(request, response);
             
             //Fim da acao retirarProduto  
             
        }else if(acao != null && acao.equals("retirandoProduto")){            
                String matricula = request.getParameter("matricula");
                String id = request.getParameter("id");
                String codigo = request.getParameter("codigo");
                String nome = request.getParameter("nome");
                String quantidade = request.getParameter("quantidade");
                String preco = request.getParameter("preco");
                String retirarQuantidade = request.getParameter("retirarQuantidade");

                Usuario usuario = new Usuario();
                UsuarioDao usuariodao = new UsuarioDao();            
                usuario = usuariodao.buscarUsuario(matricula); 
                
            if(usuario == null){                
                JOptionPane.showMessageDialog(null,"Usuario Não Cadastrado!");  
                response.sendRedirect("ProdutoControllador?acao=retiraProduto");         
            }else if(usuario != null){
                int qtd = Integer.parseInt(quantidade);
                int retirarQtd = Integer.parseInt(retirarQuantidade);
                
                if (retirarQtd <= qtd){            
                qtd = qtd - retirarQtd;
                String qtd_banco = Integer.toString(qtd);

                produto.setId(Integer.parseInt(id));
                produto.setNome(nome);
                produto.setQuantidade(qtd_banco);
                produto.setPreco(preco);
                produto.setCodigo(codigo);        

                produtodao.alterarProdutoCodigo(produto);
                response.sendRedirect("ProdutoControllador?acao=retiraProduto"); 
            
                }else{
                JOptionPane.showMessageDialog(null, "Estoque Insuficiente! ");
                response.sendRedirect("ProdutoControllador?acao=retiraProduto");           
                }                      
            }
         //Fim da acao retirandoProduto         
         
        //Pesquisar Produto Passador
        }else if (acao != null && acao.equals("pesquisarProdutoPassador")){   
            String codigo = request.getParameter("codigo");
            produto = produtodao.buscarProduto(codigo);
            if(produto != null){
            request.setAttribute("produto", produto);
            request.getRequestDispatcher("produtoEncontradoPassador.jsp").forward(request, response);                
            }else if(produto == null){
               JOptionPane.showMessageDialog(null,"Produto não cadastrado! ");  
               request.getRequestDispatcher("pesquisarProdutoPassador.jsp").forward(request, response);
            }
            //Fim da acao Pesquisar Produto Passador
            
            
         }else if(acao != null && acao.equals("retirarProdutoPassador")){
            String codigo = request.getParameter("codigo");
            produto = produtodao.buscarProduto(codigo);
            if(produto != null){
                request.setAttribute("produto", produto);
                request.getRequestDispatcher("retirarProdutoPassador.jsp").forward(request, response);                
                
            }else if(produto == null ){
                 JOptionPane.showMessageDialog(null,"Produto Não Cadastrado! ");                   
            }            
             request.getRequestDispatcher("retiraProdutoPassador.jsp").forward(request, response);
             
             //Fim da acao retirarProdutoPassador
             
        }else if(acao != null && acao.equals("retirandoProdutoPassador")){            
                String matricula = request.getParameter("matricula");
                String id = request.getParameter("id");
                String codigo = request.getParameter("codigo");
                String nome = request.getParameter("nome");
                String quantidade = request.getParameter("quantidade");
                String preco = request.getParameter("preco");
                String retirarQuantidade = request.getParameter("retirarQuantidade");

                Usuario usuario = new Usuario();
                UsuarioDao usuariodao = new UsuarioDao();            
                usuario = usuariodao.buscarUsuario(matricula); 
                
            if(usuario == null){                
                JOptionPane.showMessageDialog(null,"Usuario Não Cadastrado!");  
                response.sendRedirect("ProdutoControllador?acao=retiraProdutoPassador");         
            }else if(usuario != null){
                int qtd = Integer.parseInt(quantidade);//do banco
                int retirarQtd = Integer.parseInt(retirarQuantidade);//do usuario
                
                if (retirarQtd <= qtd){            
                qtd = qtd - retirarQtd;
                String qtd_banco = Integer.toString(qtd);

                produto.setId(Integer.parseInt(id));
                produto.setNome(nome);
                produto.setQuantidade(qtd_banco);
                produto.setPreco(preco);
                produto.setCodigo(codigo);        

                produtodao.alterarProdutoCodigo(produto);
                response.sendRedirect("ProdutoControllador?acao=retiraProdutoPassador"); 
            
                }else{
                JOptionPane.showMessageDialog(null, "Estoque Insuficiente! ");
                response.sendRedirect("ProdutoControllador?acao=retiraProdutoPassador");           
                }                      
            }                       
        }//Fim da acao retirando Produto Passador
    }//Fim do Post
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}