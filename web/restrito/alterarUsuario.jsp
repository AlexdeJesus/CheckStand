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
                    <table align = "center" bgcolor="#FFE4C4" width="20%">
                        <tr>
                            <th>Alterar Cadastro<br></th>
                        </tr>
                    <input type="hidden" name ="acao" value="salvar">
                    <tr>
                        <td><b>Id: <input type="text" name = "id" value = "<%=usuario.getId()%>" readonly="readonly"></td>
                    </tr>
                    <tr>
                        <td><b>Nome: <input type = "text" name = "nome" value = "<%=usuario.getNome()%>"></td>
                    </tr>
                    <tr>
                        <td><b>Login: <input type="text" name = "login" value="<%=usuario.getLogin()%>"></td>
                    </tr>
                    <tr>
                        <td><b>Senha: <input type = "password" name = "senha" value="<%=usuario.getSenha()%>"></td>
                    </tr>
                    <tr>
                        <td><b>Matricula: <input type="text" name="matricula" value = "<%=usuario.getMatricula()%>"><br></td>
                    </tr>
                    <tr>
                        <td><b>Perfil: <input type="text" name="perfil" value = "<%=usuario.getPerfil()%>"><br></td>
                   
                    </tr>
                    <tr>
                        <th><br><input type="submit" name="alterar" value = "Salvar"></th>
                    </tr>
                </table>            
            </form>
            <br><br>
        </div>
    </body>
</html>
