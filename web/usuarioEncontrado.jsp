<%-- 
    Document   : usuarioEncontrado
    Created on : 20/12/2016, 04:55:21
    Author     : Alex Souza
--%>

<%@page import="br.com.checkstand.bens.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="home.jsp"></jsp:include>   
        <%
        Usuario usuario = (Usuario)request.getAttribute("usuario");
        %>
        <div  id="interface">
            <table border rules = cols align = "center">
                    <tr bgcolor="#FFF8DC">
                        <th width = 150>MATRICULA</th>
                        <th width = 150>NOME</th> 
                        <th width = 100>LOGIN</th> 
                        <th width = 100>SENHA</th> 
                        <th width = 100>EXCLUIR</th>
                        <th width = 100>ALTERAR</th>
                    </tr>

                    <tr bgcolor= #FFFFF0>    
                        <th><%=usuario.getMatricula()%></th>
                        <th><%=usuario.getNome()%> </th> 
                        <th><%=usuario.getLogin()%> </th> 
                        <th><%=usuario.getSenha()%> </th> 
<th><a href="UsuarioControllador?acao=excluir&id=<%=usuario.getId ()%>" style="text-decoration:none"><font color="228B22">Excluir</a></th>
<th><a href="UsuarioControllador?acao=alterar&id=<%=usuario.getId ()%>" style="text-decoration:none"><font color="228B22">Alterar</a></th>
                </tr>                
            </table>
            <br><br>
        </div>
    </body>
</html>
