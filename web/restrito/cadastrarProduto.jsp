<%-- 
    Document   : cadastrarProduto
    Created on : 21/12/2016, 05:21:27
    Author     : Alex Souza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
    </head>
    <body>
        <jsp:include page="home.jsp"></jsp:include>
        <div  id="interface">     
                <table border = "0" align = "center"  bgcolor="#FFE4C4" width="20%">   
                    <form action="restrito/salvarProduto.jsp" method = "post">
                    <tr>
                        <th>Cadastro De Produtos</th>
                    </tr>
                    <tr>
                            <td><b>Codigo: <input type="text" name="codigo" required="required"></td><br>
                    </tr>
                    <tr>
                        <td><b>Descricao: <input type="text" name="nome" required="required"></td>
                    </tr>
                    <tr>
                        <td><b>Quantidade: <input type="text" name="quantidade" maxlength="30" required="required"></td>
                    </tr>
                    <tr>
                        <td><b>Preco: <input type="text" name="preco" maxlength="20" required="required"><br><br></td>
                    </tr>

                        <tr>
                            <th><input type="submit" name="cadastrar" value="Cadastrar"></th>
                        </tr>
                        </form>
                </table>  
            <br><br>
        </div>    
    </body>
</html>
