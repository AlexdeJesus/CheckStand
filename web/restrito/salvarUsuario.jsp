<%-- 
    Document   : salvarUsuario
    Created on : 20/12/2016, 05:17:33
    Author     : Alex Souza
--%>

<%@page import="br.com.checkstand.jdbc.UsuarioDao"%>
<%@page import="br.com.checkstand.bens.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Usuario</title>
    </head>
    <body>        
        <%
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");        
        String matricula = request.getParameter("matricula");
        String perfil = request.getParameter("perfil");
        
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setMatricula(matricula);
        usuario.setPerfil(perfil);
        

        UsuarioDao usuariodao = new UsuarioDao();
        Usuario user = usuariodao.buscarMatricula(usuario.getMatricula());      
        if(user == null){        
        usuariodao.cadastrar(usuario);        
        }
        response.sendRedirect("../UsuarioControllador?acao=cadastro");
        %>
    </body>
</html>