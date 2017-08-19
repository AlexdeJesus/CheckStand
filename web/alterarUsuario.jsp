<%-- 
    Document   : alterarUsuario
    Created on : 20/12/2016, 05:07:20
    Author     : Alex Souza
--%>

<%@page import="br.com.checkstand.bens.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Cadastro</title>
    </head>
    <body>         
        <jsp:include page="home.jsp"></jsp:include>
        <%
            Usuario usuario = (Usuario)request.getAttribute("usuario");
        %>
         <div  id="interface">
            <form action = "UsuarioControllador?acao=alterar" method = "post">                 
                    <table align = "center" bgcolor="#d5e8f9">
                        <tr>
                            <th>Alterar Cadastro<br></th>
                        </tr>
                    <input type="hidden" name ="acao" value="salvar">
                    <tr>
                        <th><label>Id</label></th>
                    </tr>
                    <tr>
                        <th><input type="text" name = "id" value = "<%=usuario.getId()%>"></th>
                    </tr>
                    <tr>
                        <th><label>Nome</label></th>
                    </tr>
                    <tr>
                        <th><input type = "text" name = "nome" value = "<%=usuario.getNome()%>"></th>
                    </tr>
                    <tr>
                        <th><label>Login</label></th><br>
                    </tr>
                    <tr>
                        <th><input type="text" name = "login" value="<%=usuario.getLogin()%>"></th><br>
                    </tr>
                    <tr>
                        <th><label>Senha</label></th>
                    </tr>
                    <tr>
                        <th><input type = "password" name = "senha" value="<%=usuario.getSenha()%>"></th>
                    </tr>
                    <tr>
                        <th><label>Matricula</label></th>
                    </tr>
                    <tr>
                        <th><input type="text" name="matricula" value = "<%=usuario.getMatricula()%>"><br><br></th>
                    </tr>
                    <tr>
                        <th><label>Perfil</label></th>
                    </tr>
                    <tr>
                        <th><input type="text" name="perfil" value = "<%=usuario.getPerfil()%>"><br><br></th>
                    </tr>
                    <tr>
                        <th><input type="submit" name="alterar" value = "Salvar"></th>
                    </tr>
                </table>            
            </form>
            <br><br>
        </div>
    </body>
</html>
