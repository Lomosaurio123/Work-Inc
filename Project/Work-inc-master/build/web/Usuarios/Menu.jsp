<%-- 
    Document   : Menu
    Created on : 9/11/2018, 02:05:57 AM
    Author     : juan-
--%>

<%@page import="com.working.modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Menu</title>
        <link rel="shortcut icon" type="image/png" href="../RecursosGraficos/Imagenes/ha.png"/>
        <link rel="stylesheet" href="../Disegno/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="../Disegno/CSS/menuNoActualizado.css">
        <link rel="stylesheet" href="../Disegno/CSS/iconos.css">
         <link rel="stylesheet" href="../RecursosGraficos/icon/style.css">

    </head>  
        <%  
        try{
        HttpSession sesion= (HttpSession) request.getSession();
        Usuario usuario =(Usuario)sesion.getAttribute("usuario");      
        String correo = usuario.getCorreo();
        String contra = usuario.getContra();
        

        }catch(Exception e){
            response.sendRedirect("../index.html");
        }
        
        %>
        <body>
        
        <header>
            <nav class="navbar navbar-default">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-1">
                        <span class="sr-only">Menu</span>
                        
                    </button>
                    <a href="#" class="navbar-brand">BIENVENIDO:  </a>
                </div>
                <div class="navbar navbar-collapse" id="navbar-1">
                    <ul class="nav navbar-nav">   
                        <li><a href="">ACERCA DE AXIS</a></li>    
                        <li ><a href="">INICIO</a></li>   
                    </ul>
                    
                    <ul class="nav navbar-nav navbar-right">
                        <li data-toggle="modal" data-target="#ModalRegis"><a>AYUDA</a></li>
                        <li><a href="../cerrarcesion">CERRAR SESION</a></li>
                    </ul>
                    
                    
                    
                    <form class="navbar-form navbar-right" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control icon-next" placeholder="Buscar" >
                        </div>
                    </form>
                </div>
            </nav> 
        </header>
        

         
     <main>
        <div class="content-menu">
           
            
            <a href="../ReadUsuario"><li><span class="lnr lnr-user icon2"></span><h4 class="text2">Usuario</h4></li></a>
            <a href="../Proyectos/Proyectos.jsp"> <li><span class="lnr lnr-apartment icon3"></span><h4 class="text3">Proyectos</h4></li></a>
            <li><span class="lnr lnr-bubble icon6"></span><h4 class="text6">Chats</h4></li>
            <a href="../Curriculum/PrimerPaso.jsp"><li><span class="lnr lnr-envelope icon7"></span><h4 class="text7">Curriculos</h4></li></a>
            
        </div>
        <article>
            <center><h1>WorkInc</h1></center>
           
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quod consequatur, ex assumenda fuga, rem quidem delectus mollitia optio repellendus neque alias repellat distinctio sint omnis, quae blanditiis aliquam? Eius inventore esse, voluptas vero dolores iusto in aut ipsam fugiat possimus hic maxime deleniti, commodi at quidem cupiditate laborum, tempore iste dolorem. Et expedita tenetur saepe dolores fuga excepturi iste sit quos, ab temporibus, molestiae vel sint sed nihil. Officiis debitis unde facilis aperiam quae perspiciatis necessitatibus veniam, quisquam sed animi cumque maiores deleniti reprehenderit exercitationem, culpa. Perferendis repellat corrupti tempore placeat, illo fugiat, magnam, omnis voluptate deserunt ad nihil alias!</p>
        </article>
    </main>
   
        <script src="Disegno/js/jquery.js"></script>
        <script src="Disegno/js/bootstrap.js"></script>
        
    </body>
</html>
