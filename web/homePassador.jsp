<%-- 
    Document   : homePassador
    Created on : 21/12/2016, 04:55:18
    Author     : Alex Souza
--%>

<%@page import="br.com.checkstand.bens.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%--    <link rel="stylesheet" type="text/css" href="estilo.css">--%>
        <title>Home</title>
    </head>
    <body>
        <%--   <%
             Usuario usuarioAutenticar = (Usuario)session.getAttribute("usuarioAtenticar");   
        %> --%>
         <div id="interface">
            <header id="cabecalho">               
                <nav id="menu">
                    <ul type="disc"> 
                        <li> <a href="UsuarioControllador?acao=homePassador">Home</a></li>
                        <li><a href="ProdutoControllador?acao=pesquisarProdutoPassador">Pesquisar Produto</a></li>
                        <li><a href="ProdutoControllador?acao=retiraProdutoPassador">Retirar Produto</a></li>       
                        <li><a href="AutenticacaoControllador?acao=sair">Sair</a></li> 
                        <br><br>
                        <div align = "center"> 
                            <%--        <%
                                out.print("Ola, seja bem vindo "+usuarioAutenticar.getNome()+"!");        
                            %> --%>
                        </div>
                    </ul>                    
                </nav>  
            </header>
        </div> 
    </body>
</html>
