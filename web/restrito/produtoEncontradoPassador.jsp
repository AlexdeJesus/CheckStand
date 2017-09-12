<%-- 
    Document   : produtoEncontradoPassador
    Created on : 23/12/2016, 04:34:35
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
        <jsp:include page="homePassador.jsp"></jsp:include>
        <%
            Produto produto = (Produto)request.getAttribute("produto");
        %>  
        <div  id="interface">
            <table border rules = cols align = "center">
                <tr bgcolor="#ffcc99">  
                    <th width = 150>Codigo Fornecedor</th> 
                    <th width = 150>Descrição</th> 
                    <th width = 150>Quantidade</th> 
                    <th width = 150>Preço Unitário</th>  
                </tr>
                <tr bgcolor="#FFE4C4">                     
                    <th><%=produto.getCodigo()%> </th> 
                    <th><%=produto.getNome()%> </th> 
                    <th><%=produto.getQuantidade()%></th> 
                    <th><%=produto.getPreco()%> </th>                        
                </tr>                
            </table>    
        </div> 
    </body>
</html>