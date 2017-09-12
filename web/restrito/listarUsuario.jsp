<%-- 
    Document   : listarUsuario
    Created on : 20/12/2016, 04:44:05
    Author     : Alex Souza
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.checkstand.bens.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Usuarios</title>
    </head>
    <body>        
        <jsp:include page="home.jsp"></jsp:include>
         <div  id="interface">
             <div align = "center">
        
            <%          
              List<Usuario> lista = (List<Usuario>)request.getAttribute("lista");
            %>  
            <table border rules = cols>
                <tr bgcolor="#ffcc99">
                    <th width = 200>Nome</th> 
                    <th width = 150>Login</th> 
                    <th width = 100>Senha</th> 
                    <th width = 100>Matricula</th>
                    <th width = 100>Perfil</th>
                    <th width = 150>Excluir Dados</th>
                    <th width = 150>Alterar Dados</th>                                 
                </tr>          
                <%
                   for(Usuario usuario :lista){           
                 %>
                 
                 <tr bgcolor= "#FFE4C4">
                    <th><%=usuario.getNome ()%></th>
                    <th><%=usuario.getLogin ()%></th>
                    <th><%=usuario.getSenha ()%></th>
                    <th><%=usuario.getMatricula ()%></th>
                    <th><%=usuario.getPerfil()%></th>
 <th><a href="UsuarioControllador?acao=excluir&id=<%=usuario.getId ()%>" style="text-decoration:none"><font color="228B22">Excluir</a></th>
 <th><a href="UsuarioControllador?acao=alterar&id=<%=usuario.getId ()%>" style="text-decoration:none"><font color="228B22">Alterar</a></th>
                </tr>           
                <%}%>
            </table>
            <br><br>
             </div>
        </div>
    </body>
</html>