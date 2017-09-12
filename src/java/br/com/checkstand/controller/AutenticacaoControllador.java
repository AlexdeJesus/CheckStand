package br.com.checkstand.controller;

import br.com.checkstand.bens.Usuario;
import br.com.checkstand.jdbc.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
/**
 * @author Alex Souza
 */
public class AutenticacaoControllador extends HttpServlet {
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
            
        String acao = request.getParameter("acao"); 
        
        if(acao != null && acao.equals("sair")){
            HttpSession session = request.getSession(false);
            if(session != null){//se a sessao existir
            session.invalidate(); //entao se torna invalida           
            }            
            response.sendRedirect("index.jsp");   
        }            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    
         String acao = request.getParameter("acao");
        
        if(acao != null && acao.equals("autenticacao")){
            String perfil = null;
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            perfil = request.getParameter("perfil");  
            //String nome = request.getParameter("nome");
            
            if(perfil != null && perfil.equals("admin")){ 
                Usuario usuario = new Usuario();        
                usuario.setLogin(login);
                usuario.setSenha(senha);
                usuario.setPerfil(perfil);
             //   usuario.setNome(nome);

                UsuarioDao usuariodao = new UsuarioDao();
                Usuario usuarioAutenticar = usuariodao.autenticacao(usuario);
                if(usuarioAutenticar != null){
                    HttpSession session = request.getSession();
                    session.setAttribute("usuarioAutenticar",usuarioAutenticar);//setar para usar no filtro de paginas
                   // session.setMaxInactiveInterval(3000);
                    request.getRequestDispatcher("restrito/home.jsp").forward(request, response);
                }else if (usuarioAutenticar == null){
                    JOptionPane.showMessageDialog(null,"Usuario ou senha invalidos! Tente novamente! ");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                //Fim do perfil admin
                
            }else if(perfil != null && perfil.equals("passador")){
                Usuario usuario = new Usuario();        
                usuario.setLogin(login);
                usuario.setSenha(senha);
                usuario.setPerfil(perfil);
            //    usuario.setNome(nome);

                UsuarioDao usuariodao = new UsuarioDao();
                Usuario usuarioAutenticar = usuariodao.autenticacao(usuario);
                if(usuarioAutenticar != null){                    
                    HttpSession session = request.getSession();
                    session.setAttribute("usuarioAutenticar",usuarioAutenticar);
                    request.getRequestDispatcher("restrito/homePassador.jsp").forward(request, response);
                }else if (usuarioAutenticar == null){
                    JOptionPane.showMessageDialog(null,"Usuario ou senha invalidos! Tente novamente! ");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } //fim do usuarioAtenticar
            }//fim do perfil Passador
        }//Fim da acao autenticacao
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
