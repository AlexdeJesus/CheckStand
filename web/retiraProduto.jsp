<%-- 
    Document   : retirarProduto
    Created on : 22/12/2016, 04:58:59
    Author     : Alex Souza
--%>

<%@page import="br.com.checkstand.bens.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Retirar Produto</title>
    </head>
    <body>        
          <jsp:include page="home.jsp"></jsp:include>
        <div  id="interface"> 
            <form action="ProdutoControllador?acao=retirarProduto" method="post">
                <table align="center" bgcolor="#FFE4C4">
                    <tr>
                            <th>Retirar Produto<br><br></th>
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
