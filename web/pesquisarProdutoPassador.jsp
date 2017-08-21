<%-- 
    Document   : pesquisarProdutoPassador
    Created on : 23/12/2016, 04:30:44
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
         <jsp:include page="homePassador.jsp"></jsp:include>
        <div  id="interface">
            <form action="ProdutoControllador?acao=pesquisarProdutoPassador" method="post">
                <table align="center" bgcolor="#FFE4C4">
                    <tr>
                        <th>Pesquisar Produto<br><br></th>
                    </tr>
                    <tr>
                        <th>Codigo:
                            <input type="text" name="codigo" value=""required="required"maxlength=""><br><br>
                        </th>
                    </tr>
                        <tr>
                            <th><input type="submit" name="buscar" value="Buscar"></th>
                        </tr>
                    </table>         
                </form>
            <br><br>
        </div>
    </body>
</html>
