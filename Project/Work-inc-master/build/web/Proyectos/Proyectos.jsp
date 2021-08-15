
<%@page import="com.working.modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Menu</title>
        <link rel="shortcut icon" type="image/png" href="RecursosGraficos/Imagenes/ha.png"/>
        <link rel="stylesheet" href="../Disegno/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="../Disegno/CSS/menu.css">
        <link rel="stylesheet" href="../Disegno/CSS/iconos.css">
        <link rel="stylesheet" href="../RecursosGraficos/icon/style.css">
    </head>  
        <%      
        HttpSession sesion= (HttpSession) request.getSession();
        Usuario usuario =(Usuario)sesion.getAttribute("usuario");
        
        String correo = usuario.getCorreo();
        String contra = usuario.getContra();
        
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
                         <li><a href="">PROYECTOS</a></li>    
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li data-toggle="modal" data-target="#ModalRegis"><a>¿COMO UTILIZO ESTE MODULO?</a></li>
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
 
        <article>
            <center><h1>WorkInc</h1></center>
            <div class=" center-block">
            <a href="../ProyectosPropios"><input class="btn btn-primary" type="button" id="" name="" value="Mis proyectos"></a>
       <a href="../TodosProyectos"><input type="button"class="btn btn-primary" id="" name="" value="Buscar proyectos"></a>
      <a href="proyectoalta.jsp"> <input type="button" class="btn btn-primary" id="" name="" value="Registrar proyectos"></a>
      <a href="#"> <input type="button" class="btn btn-primary" id="" name="" value="Observar proyectos en los que estoy regsitrado"></a>
      
      </div>
      
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quod consequatur, ex assumenda fuga, rem quidem delectus mollitia optio repellendus neque alias repellat distinctio sint omnis, quae blanditiis aliquam? Eius inventore esse, voluptas vero dolores iusto in aut ipsam fugiat possimus hic maxime deleniti, commodi at quidem cupiditate laborum, tempore iste dolorem. Et expedita tenetur saepe dolores fuga excepturi iste sit quos, ab temporibus, molestiae vel sint sed nihil. Officiis debitis unde facilis aperiam quae perspiciatis necessitatibus veniam, quisquam sed animi cumque maiores deleniti reprehenderit exercitationem, culpa. Perferendis repellat corrupti tempore placeat, illo fugiat, magnam, omnis voluptate deserunt ad nihil alias!</p>
        </article>
    </main>
   
        <script src="Disegno/js/jquery.js"></script>
        <script src="Disegno/js/bootstrap.js"></script>
        
    </body>
</html>
