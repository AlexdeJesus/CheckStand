<%-- 
    Document   : home
    Created on : 20/12/2016, 04:37:03
    Author     : Alex Souza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estilo.css">
        <title>Home</title>
    </head>
    <body>
        
        <div  id="interface">
            <header id="cabecalho">               
                <nav id="menu">
                    <ul type="disc">
                        <li> <a href="UsuarioControllador?acao=home">Home</a></li>
                        <li> <a href="UsuarioControllador?acao=cadastro">Cadastrar Usuario</a></li>
                        <li> <a href="UsuarioControllador?acao=lista">Listar Usuarios</a></li>  
                        <li> <a href="UsuarioControllador?acao=pesquisarUsuario">Pesquisar Usuario</a></li>       
                        <li> <a href="ProdutoControllador?acao=cadastrarProduto">Cadastrar Produto</a></li>       
                        <li> <a href="ProdutoControllador?acao=listar">Listar Produtos</a></li>       
                        <li> <a href="ProdutoControllador?acao=pesquisarProduto">Pesquisar Produto</a></li>
                        <li> <a href="ProdutoControllador?acao=retiraProduto">Retirar Produto</a></li>    
                        <li> <a href="AutenticacaoControllador?acao=sair">Sair</a></li>
                        <br><br>
                        <div align = "center"> 
                            <%--    <%
                                Usuario usuarioAutenticar = (Usuario)session.getAttribute("usuarioAutenticar");
                                out.print("Ola, seja bem vindo "+usuarioAutenticar.getNome()+"!");        
                            %> --%>
                        </div>
                    </ul>                    
                </nav>  
            </header>
        </div>
    </body>
</html>
