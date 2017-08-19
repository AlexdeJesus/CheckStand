<%-- 
    Document   : index
    Created on : 26/12/2016, 00:02:01
    Author     : Alex Souza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CheckStand</title>
    </head>
    <body>
         <%
        for(int i = 0; i < 10; i++){                    
        %>
            <br>
        <%}%>        
        <form action="AutenticacaoControllador?acao=autenticacao" method = "post">
            <table align = "center" bgcolor="#d5e8f9">    
                <tr>
                    <th><font size="4" color="#006600">Olá seja bem vindo!<br><br></th>
                </tr>
                <tr>
                    <th><font color="009900" size="3">Login: <input type="text" name="login" required=""></th>
                </tr>
                <tr>
                    <th><font color="009900" size="3">Senha: <input type="password" name="senha" maxlength="30" required=""></th>
                </tr> 
                               
                <tr>
                    <th><br>
                       <select name="perfil"><br>
                            <option value="admin">Administrador</option>
                            <option value="passador">Passador</option> 
                       </select>
                       <br><br>
                    </th>
                </tr> 
                <tr>
                    <th><input type="submit" name="entrar" value="Entrar"></th>
                </tr>
            </table>  
        </form>
    </body>
</html>
