<%-- 
    Document   : salvarProduto
    Created on : 21/12/2016, 05:23:05
    Author     : Alex Souza
--%>

<%@page import="br.com.checkstand.jdbc.ProdutoDao"%>
<%@page import="br.com.checkstand.bens.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salvar Produto</title>
    </head>
    <body>        
        <%
        String codigo = request.getParameter("codigo");
        String nome = request.getParameter("nome");
        String quantidade = request.getParameter("quantidade");
        String preco = request.getParameter("preco");        
       
       
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setNome(nome);
        produto.setQuantidade(quantidade);
        produto.setPreco(preco);
        

        ProdutoDao produtodao = new ProdutoDao();
        Produto prod = produtodao.buscarCodigo(produto.getCodigo());
        if(prod == null){
        produtodao.cadastar(produto);
        }
        response.sendRedirect("../ProdutoControllador?acao=cadastrarProduto");
        %>
    </body>
</html>
