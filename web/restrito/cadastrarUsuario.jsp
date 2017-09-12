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
                <table border = "0" align = "center"  bgcolor="#FFE4C4" width="20%">   
                <form action="restrito/salvarUsuario.jsp" method = "post">
                    
                        <tr>
                            <th>Cadastro De Colaboradores</th>
                        </tr>
                        <tr>
                            <td><b>Nome: <input type="text" name="nome" required="required"></td>                        
                        </tr> 
                        <tr>
                            <td><b>Login: <input type="text" name="login" required="required"></td>
                        </tr>
                        <tr>
                            <td><b>Senha: <input type="password" name="senha" required="required"></td>
                        </tr>
                        <tr>
                            <td><b>Matricula: <input type="text" name="matricula" required="required"></td>
                         </tr>
                        <tr>
                        <th><select name="perfil">
                             <option value="admin">Administrador</option>
                             <option value="passador">Passador</option> <br><br><br>
                         </select><br><br></th>
                        </tr>               
                        <tr>
                          <th><input type="submit" name="cadastrar" value="Cadastrar"></th>
                        </tr> 
                        <tr>
                            <td>
                                
                            </td>
                        </tr>
                </form>      
               </table>
            </div>
    </body>
</html>
