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
            <form action="salvarProduto.jsp" method = "post">
                <table border = "0" align = "center" bgcolor="#d5e8f9">    
                    <tr>
                        <th>Cadastro De Produto</th>
                    </tr>
                        <tr>
                            <th><br>Codigo</th>
                        </tr>
                        <tr>
                            <th><input type="text" name="codigo" required=""></th>
                        </tr> 
                        <tr>
                            <th>Descricao</th>
                        </tr>                     
                        <tr>
                            <th><input type="text" name="nome" required=""></th>
                        </tr>
                        <tr>
                            <th>Quantidade</th>
                        </tr>
                        <tr>
                            <th><input type="text" name="quantidade" maxlength="30" required=""></th>
                        </tr>
                        <tr>
                            <th>Preco</th>
                        </tr>
                        <tr>
                            <th><input type="text" name="preco" maxlength="20" required=""><br><br></th>
                        </tr>

                        <tr>
                            <th><input type="submit" name="cadastrar" value="Cadastrar"></th>
                        </tr>
                </table>  
            </form>
            <br><br>
        </div>    
    </body>
</html>
