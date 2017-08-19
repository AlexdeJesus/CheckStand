<%-- 
    Document   : cadastrarUsuario
    Created on : 20/12/2016, 04:34:48
    Author     : Alex Souza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Usuario</title>
    </head>
    <body>
        <jsp:include page="home.jsp"></jsp:include>           
           <div  id="interface">        
                <form action="salvarUsuario.jsp" method = "post">
                    <table border = "0" align = "center" bgcolor="#d5e8f9">    
                        <tr>
                            <th>Cadastro De Usuario</th>
                        </tr>
                        <tr>
                            <th><br>Nome</th>
                        </tr>
                        <tr>
                            <th><input type="text" name="nome" required=""></th>
                        </tr> 
                        <tr>
                            <th>Login</th>
                        </tr>                     
                        <tr>
                            <th><input type="text" name="login" required=""></th>
                        </tr>
                        <tr>
                            <th>Senha</th>
                        </tr>
                        <tr>
                            <th><input type="password" name="senha" maxlength="30" required=""></th>
                        </tr>
                        <tr>
                            <th>Matricula</th>
                        </tr>
                        <tr>
                            <th><input type="text" name="matricula" maxlength="20" required=""></th>
                         </tr>
                        <tr>
                        <th><br><select name="perfil">
                             <option value="admin">Administrador</option>
                             <option value="passador">Passador</option> <br><br><br>
                         </select><br><br></th>
                        </tr>               
                        <tr>
                          <th><input type="submit" name="cadastrar" value="Cadastrar"></th>
                        </tr>
                    </table>                    
                    <br><br><br><br>
                </form>       
            </div>
    </body>
</html>
