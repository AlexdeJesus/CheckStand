package br.com.checkstand.controller;

import br.com.checkstand.bens.Usuario;
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
public class UsuarioControllador extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
      
       Usuario usuario = new Usuario();
       String acao = request.getParameter("acao");
       UsuarioDao usuariodao = new UsuarioDao(); 
       
       //Home
       if(acao != null && acao.equals("home")){
       request.getRequestDispatcher("home.jsp").forward(request, response);
       
       //Cadastro
       }else if(acao != null && acao.equals("cadastro")){
            request.getRequestDispatcher("cadastrarUsuario.jsp").forward(request, response);         
        
        //Lista
       }else if(acao != null && acao.equals("lista")){//Só vai listar os dados se acao = l na url
       List<Usuario>lista = usuariodao.listar(usuario);
       request.setAttribute("lista", lista);
       request.getRequestDispatcher("listarUsuario.jsp").forward(request, response);
       
       //Pesquisar Usuario
       }else if (acao != null && acao.equals("pesquisarUsuario")){
        request.getRequestDispatcher("pesquisarUsuario.jsp").forward(request, response);
       
         //Excluir
       }else if (acao != null && acao.equals("excluir")){
        String id = request.getParameter("id");
        usuario.setId(Integer.parseInt(id));
        usuariodao.excluir(usuario);            
        response.sendRedirect("UsuarioControllador?acao=lista");
          
         //Alterar
        }else if (acao != null && acao.equals("alterar")){
        String id = request.getParameter("id");
        usuario = usuariodao.buscarId(Integer.parseInt(id));
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("alterarUsuario.jsp").forward(request, response);  
           
        //Home Passador
        }else if(acao != null && acao.equals("homePassador")){
        request.getRequestDispatcher("homePassador.jsp").forward(request, response); 
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String acao = request.getParameter("acao"); 
        UsuarioDao usuariodao = new UsuarioDao();
        Usuario produto = new Usuario();
        
        if(acao != null && acao.equals("pesquisarUsuario")){
            String matricula = request.getParameter("matricula");
            Usuario usuario = usuariodao.buscarUsuario(matricula);
            if(usuario != null){
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("usuarioEncontrado.jsp").forward(request, response);
            }else if(usuario == null){
                JOptionPane.showMessageDialog(null,"Usuario Não Cadastrado! ");            
                request.getRequestDispatcher("pesquisarUsuario.jsp").forward(request, response);
            }            
            //Fim da acao Pesquisar Usuario
            
        }else if(acao != null && acao.equals("alterar")){
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            String matricula = request.getParameter("matricula");
            String perfil = request.getParameter("perfil");
            
            //Criando objeto usuario e atribuindo valores da tela
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setLogin(login);
            usuario.setSenha(senha);
            usuario.setMatricula(matricula);
            usuario.setPerfil(perfil);
            usuario.setId(Integer.parseInt(id));            
                    
            usuariodao.editar(usuario);
            response.sendRedirect("UsuarioControllador?acao=lista");
           
            //Fim da acao alterar        
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}