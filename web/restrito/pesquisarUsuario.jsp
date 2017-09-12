<%-- 
    Document   : pesquisarUsuario
    Created on : 20/12/2016, 04:49:42
    Author     : Alex Souza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisar Usuario</title>
    </head>
    <body>
         <jsp:include page="home.jsp"></jsp:include>
            <div  id="interface"> 
                <form action="UsuarioControllador?acao=pesquisarUsuario" method="post">
                    <table align="center" bgcolor="#FFE4C4">
                        <tr>
                            <th>PESQUISAR USUARIO<br><br></th>
                        </tr>
                        <tr>
                            <th>
                                Matricula:
                                <input type="text" name="matricula" value=""required="required"><br><br>
                            </th>
                        </tr>
                        <tr>
                            <th><input type="submit" name="buscar" value="Pesquisar"></th>
                        </tr>
                    </table>         
                </form>
                <br><br>
            </div>
    </body>
</html>
