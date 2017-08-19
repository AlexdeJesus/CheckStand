<%-- 
    Document   : produtoEncontrado
    Created on : 22/12/2016, 04:53:39
    Author     : Alex Souza
--%>

<%@page import="br.com.checkstand.bens.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisar Produto</title>
    </head>
    <body>
         <jsp:include page="home.jsp"></jsp:include>
        <%
            Produto produto = (Produto)request.getAttribute("produto");
        %> 
        <div  id="interface">
            <table border rules = cols align = "center">
                    <tr bgcolor="#FFF8DC">                 
                    <th width = 150>Codigo Fornecedor</th> 
                    <th width = 150>Descrição</th> 
                    <th width = 150>Quantidade</th> 
                    <th width = 150>Preço Unitário</th>                                         
                    <th width = 150>Excluir Dados</th>
                    <th width = 150>Alterar Dados</th>
                 </tr>
                 
                 <tr bgcolor="#FFFFF0">                    
                    <th><%=produto.getCodigo()%> </th> 
                    <th><%=produto.getNome()%> </th> 
                    <th><%=produto.getQuantidade()%></th> 
                    <th><%=produto.getPreco()%> </th>                    
<th><a href="ProdutoControllador?acao=excluir&id=<%=produto.getId ()%>" style="text-decoration:none"><font color="228B22">Excluir</a></th>
<th><a href="ProdutoControllador?acao=alterar&id=<%=produto.getId ()%>" style="text-decoration:none"><font color="228B22">Alterar</a></th>     
                 </tr>                
            </table>
            <br><br>
        </div>             
    </body>
</html>
