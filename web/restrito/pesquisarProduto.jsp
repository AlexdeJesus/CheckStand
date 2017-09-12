<%-- 
    Document   : pesquisarProduto
    Created on : 22/12/2016, 04:49:21
    Author     : Alex Souza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisar Produto</title>
    </head>
    <body>
         <jsp:include page="home.jsp"></jsp:include>
        <div  id="interface"> 
            <form action="ProdutoControllador?acao=pesquisarProduto" method="post">
                <table align="center" bgcolor="#FFE4C4">
                    <tr>
                        <th>Pesquisar Produto<br><br></th>
                    </tr>
                    <tr><th>Codigo:
                            <input type="text" name="codigo" value=""required="required"maxlength=""><br><br></th>
                    </tr>
                    <tr>
                        <th><input type="submit" name="pesquisar" value="Pesquisar"></th>
                    </tr>
                </table>         
            </form>
            <br><br>
        </div>
    </body>
</html>
