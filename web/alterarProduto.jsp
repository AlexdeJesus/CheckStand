<%-- 
    Document   : alterarProduto
    Created on : 22/12/2016, 04:30:19
    Author     : Alex Souza
--%>

<%@page import="br.com.checkstand.bens.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Produto</title>
    </head>
    <body>
         <jsp:include page="home.jsp"></jsp:include>
        <div  id="interface">
            <%
            Produto produto = (Produto)request.getAttribute("produto");
            %>
              
            <form action = "ProdutoControllador?acao=alterar" method = "post">                        
                <table align = "center" bgcolor="#FFE4C4" width="20%">
                    <input type="hidden" name ="acao" value="salvar">
                    <tr>
                        <th>Alterar Produto<br></th>
                    </tr>
                    <tr>
                        <td><b>Id: <input type="text" name = "id" value = "<%=produto.getId()%>"readonly="readonly"></td>
                    </tr>
                    <tr>
                        <td><b>Codigo: <input type = "text" name = "codigo" value = "<%=produto.getCodigo()%>"></td>
                    </tr>
                    <tr>
                        <td><b>Nome: <input type = "text" name = "nome" value = "<%=produto.getNome()%>"></td>
                    </tr>
                    <tr>
                        <td><b>Quantidade: <input type="text" name = "quantidade" value="<%=produto.getQuantidade()%>"></td>
                    </tr>
                    <tr>
                        <td><b>Preço: <input type = "text" name = "preco" value="<%=produto.getPreco()%>"><br><br></td>
                    </tr>
                    <tr>
                        <th><input type="submit" name="alterar" value = "Salvar"></th>
                    </tr>
                 </table>
            </form> 
            <br><br>
        </div>        
    </body>
</html>
