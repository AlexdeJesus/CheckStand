<%-- 
    Document   : home
    Created on : 20/12/2016, 04:37:03
    Author     : Alex Souza
--%>

<%@page import="br.com.checkstand.bens.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="restrito/estilo.css">
        <title>Home</title>
    </head>
<body>  
    <div id="interface">
        <header id="cabecalho"> 
            <nav id="menu">
                <br>
                <table border="0"  width="80%"  height="40" align="center" cellspacing="0">            
                    <tr>
                         <td width="50%" align="right" valign="baseline">
                        <font color="blue" size="+3">Check Stand</font>
                        </td>
                    </tr>
                    <tr>
                        <td><%for (int i=0;i<3;i++){%>
                           <br>
                        </td>   
                           <%}%>    
                     </tr>
                    <tr>
                        <td align="center" bgcolor="#ffcc99" height="30">
                            <font size="3"color="#ffffff">
                            &nbsp;&nbsp; <b><a href="UsuarioControllador?acao=home">Home</a>&nbsp; |
                            &nbsp;<b><a href="UsuarioControllador?acao=cadastro">Cadastrar Colaborador</a>&nbsp; |
                            &nbsp;<b><a href="UsuarioControllador?acao=lista">Listar</a>&nbsp; |
                            &nbsp;<b><a href="UsuarioControllador?acao=pesquisarUsuario">Pesquisar</a>&nbsp; |
                            &nbsp;<b><a  href="ProdutoControllador?acao=cadastrarProduto">Cadastrar Produto</a>&nbsp; |
                            &nbsp;<b><a  href="ProdutoControllador?acao=listar">Listar</a>&nbsp; | 
                            &nbsp;<b><a href="ProdutoControllador?acao=pesquisarProduto">Pesquisar</a>&nbsp;|
                            &nbsp;<b><a href="ProdutoControllador?acao=retiraProduto">Retirar</a>&nbsp;|
                            &nbsp;<b><a href="AutenticacaoControllador?acao=sair">Sair</a>&nbsp;&nbsp; 
                        </td>
                    </tr> 
                    <div align = "center"> <b>
                              <%
                                Usuario usuarioAutenticar = (Usuario)session.getAttribute("usuarioAutenticar");
                                out.print("Olá, seja bem vindo "+usuarioAutenticar.getNome()+"!");        
                              %> 

                    </div>                        
                </table>
            </nav>
        </header>
    </div>	                    
</body>
</html>