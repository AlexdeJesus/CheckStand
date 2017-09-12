<%-- 
    Document   : retirarProduto
    Created on : 23/12/2016, 02:59:47
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
        <%
           Produto produto = (Produto)request.getAttribute("produto");         
       %>
       <jsp:include page="home.jsp"></jsp:include>        
        <div  id="interface">            
            <form action="ProdutoControllador?acao=retirandoProduto" method="post"> 
                <table border rules = cols align = "center">
                    <tr bgcolor="#ffcc99">
                        <th>Id</th>
                        <th>Codigo Fornecedor</th> 
                        <th>Descricao</th>
                        <th>Quantidade</th> 
                        <th>Preco</th>
                    </tr>                       
                    <tr bgcolor="#FFE4C4">  
                        <th><input type="text" name="id" value = "<%=produto.getId()%>" readonly="readonly"></th>
                    <th><input type="text" name="codigo" value = "<%=produto.getCodigo()%>" readonly="readonly"></th>         
                    <th><input type="text" name="nome" value ="<%=produto.getNome()%>" readonly="readonly"></th>                          
                    <th><input type="text" name="quantidade" value ="<%= produto.getQuantidade()%>" readonly="readonly"></th>               
                    <th><input type="text" name="preco" value ="<%=produto.getPreco()%>" readonly="readonly"></th><br><br>
                    </tr>
                </table> 
                     <br><br>
                <div align ="center">
                    <b>Matricula:  <input type="text" value="" name="matricula" required="required">
                    <b>Quantidade: <input type="text" value="" name="retirarQuantidade"required="required"><br><br>
                       <input type="submit" value="Retirar" name="retirar"> 
                </div>
                <br><br>
            </form>
        </div>
    </body>
</html>
