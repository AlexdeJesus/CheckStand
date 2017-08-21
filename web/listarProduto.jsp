<%-- 
    Document   : listarProduto
    Created on : 22/12/2016, 04:21:09
    Author     : Alex Souza
--%>

<%@page import="br.com.checkstand.bens.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Produto</title>
    </head>
    <body>        
        <jsp:include page="home.jsp"></jsp:include>
        <div  id="interface">                            
                <%
                List<Produto> lista = (List<Produto>)request.getAttribute("lista");
                %>            
                <table align="center" border rules = cols>
                    <tr bgcolor="#ffcc99">
                        <th width = 150>Codigo Fornecedor</th> 
                        <th width = 200>Descrição</th> 
                        <th width = 100>Quantidade</th> 
                        <th width = 150>Preço Unitario</th>                     
                        <th width = 100>Excluir Dados</th>
                        <th width = 100>Alterar Dados</th>
                    </tr>

                    <%
                    for(Produto produto : lista){                              
                    %>

                    <tr bgcolor="#FFE4C4">
                        <th><%=produto.getCodigo ()%></th>
                        <th><%=produto.getNome ()%></th>
                        <th><%=produto.getQuantidade ()%></th>
                        <th><%=produto.getPreco ()%></th> 
<th><a href="ProdutoControllador?acao=excluir&id=<%=produto.getId ()%>"  style="text-decoration:none"><font color="228B22">Excluir</a></th>
<th><a href="ProdutoControllador?acao=alterar&id=<%=produto.getId ()%>"  style="text-decoration:none"><font color="228B22">Alterar</a></th>         
                    </tr>
                    <%}%>
                </table>
                <br><br>
        </div>
    </body>
</html>
