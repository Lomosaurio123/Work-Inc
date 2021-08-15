<%-- 
    Document   : Prueba
    Created on : 19/03/2019, 08:52:57 PM
    Author     : mauga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en" >

    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href='https://fonts.googleapis.com/css?family=Roboto:300,400,600' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="../Disegno/CSSLogin/style.css">

    </head>

    <body>

        <div id="back">
            <canvas id="canvas" class="canvas-back"></canvas>
            <div class="backRight">    
            </div>
            <div class="backLeft">
            </div>
        </div>

        <div id="slideBox">
            <div class="topLayer">
                <div class="right">
                    <div class="content">
                        <h2>Login</h2>
                        <form action="../Login" method="post" >
                            <div class="form-element form-stack">
                                <label for="username-login" class="form-label">Correo</label>
                                <input id="usuario" type="text" name="usuario">
                            </div>
                            <div class="form-element form-stack">
                                <label for="password-login" class="form-label">Password</label>
                                <input id="contra" type="password" name="contra">
                            </div>
                            <div class="form-element form-submit">
                                <input type="submit" class="btn btn-primary" value="Log In">
                            </div>
                            <div class="form-element form-submit">
                                <a href="../Usuarios/RecuperarContraseña.jsp">No recuerdas tu contraseña?</a><br>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/paper.js/0.11.3/paper-full.min.js'></script>



        <script  src="../Disegno/jsLogin/index.js"></script>




    </body>

</html>
