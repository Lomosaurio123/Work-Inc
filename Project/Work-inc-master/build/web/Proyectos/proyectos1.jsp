

<%@page import="com.working.modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../Disegno/CSS/proyectos_1.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
     <%      
        HttpSession sesion= (HttpSession) request.getSession();
        Usuario usuario =(Usuario)sesion.getAttribute("usuario");
        
        String correo = usuario.getCorreo();
        String contra = usuario.getContra();
        
        %>
    <body>
        
            
            <div class="container">

                

                    <fieldset>

                       <ul class="toolbar clearfix">

                            <li><a href="../ProyectosPropios" target="pruebas" class="fontawesome-heart">&ThinSpace; Mis Proyectos</a></li>
                            <li><a href="proyectoalta.jsp" target="pruebas" class="fontawesome-eye-open">&ThinSpace; Nuevo Proyecto</a></li>
                            <li><a href="../ProyectosCoolaborador" target="pruebas" class="fontawesome-eye-open" class="fontawesome-search">&ThinSpace; Proyectos participante</a></li>
                            <!--<li><input type="search" id="search" placeholder="Buscar Proyecto"></li>
                            <li><button type="submit" id="btn-search"><span class="fontawesome-search"></span></button></li>-->

                       </ul>

                    </fieldset>

            

            </div> 

            <div class="page">
                <iframe src="../TodosProyectos" name="pruebas" style="left: 0px; position: absolute; height: 100%;width: 98%;top:18%;"></iframe>
            </div>

            <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
            <script>
                (function () {

                    $('#btn-search').on('click', function (e) {

                        e.preventDefault();
                        $('#search').animate({width: 'toggle'}).focus();

                    });

                }());
            </script>
    </body>
</html>
