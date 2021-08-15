<%-- 
    Document   : TodosProyectos
    Created on : 13/11/2018, 08:05:25 AM
    Author     : Alumno
--%>

<%@page import="java.util.Base64"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.working.modelos.Proyecto"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Disegno/CSS/proyectos.css">
        <link rel="shortcut icon" type="image/png" href="RecursosGraficos/Imagenes/ha.png"/>
        <link rel="stylesheet" href="Disegno/bootstrap/bootstrap.min.css">
         
        
        <title>Todos_Proyectos</title>
        <style>
            div{
                float: left;
            }
        </style>
        <%
           List<Proyecto> TodosProyectos ;
          
           TodosProyectos = (List<Proyecto>)request.getAttribute("Todos");
           int numerodeproyectos=0;
           ArrayList<Proyecto> ProyectosTodos = new ArrayList<Proyecto>();
           Proyecto pro;
           
           for(Proyecto p : TodosProyectos){
             int informacion = p.getId_Proyecto();
             String idea=p.getIdea_Principal();
             String nombreproyect = p.getNombreProyecto();
             int monto = p.getMonto();
             String categoria = p.getCategoria();
             Blob imgproyecto = p.getImgregreso();
             int id = p.getId_Proyecto();
                 pro=new Proyecto(nombreproyect,idea,categoria,monto,imgproyecto,id);
                 ProyectosTodos.add(pro);
               numerodeproyectos=numerodeproyectos+1; 
           }
        %>
    </head>
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
                        <li><a href="">BUSQUEDA DE PROYECTOS</a></li>                           
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
        <h1 align="center" STYLE=" font-family: Arial   ">PROYECTOS ACTIVOS</h1>
        
       <div style="justify-content:center" class="container center-block ">
        <%
            for(int i=0; i<=numerodeproyectos-1 ;i++ ){
        %> 
       
              
            <div class="blog-card">
            <div class="meta">
               
            
            
            <%
               Proyecto prodesp= ProyectosTodos.get(i);
              
               out.print(prodesp.getNombreProyecto());
               out.print(prodesp.getIdea_Principal());
               out.println(prodesp.getCategoria());
               out.print(prodesp.getMonto());
               

               ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buf = new byte[1024];
                    Blob blob = prodesp.getImgregreso();
                    InputStream in = blob.getBinaryStream();
                    int n = 0;
                    while ((n=in.read(buf))>=0){
                       baos.write(buf, 0, n);
                    }
                     in.close();
                     byte[] bytes = baos.toByteArray(); 
                     byte[] encodedBytes = Base64.getEncoder().encode(bytes);
                     String base64Encoded = new String(encodedBytes, "UTF-8");
                     out.println("<div ><img src='data:image/jpg;base64,"+base64Encoded+"' alt='Imagen ID:' style='width:100%'></div>");
                     
                     out.println("<div class='photo' style=' background-image:  src='data:image/jpg;base64,"+base64Encoded+"' alt='Imagen ID:' style='width:20%'     '></div>");
                     
            %>                       
       <!--  <div class="photo" style="background-image: url(https://storage.googleapis.com/chydlx/codepen/blog-cards/image-1.jpg)"></div>-->

                <ul class="details">
                    <li class="author"><a href="#">John Doe</a></li>
                    <li class="date">Aug. 24, 2015</li>
                    <li class="tags">
                        <ul>
                            <li><a href="#">Learn</a></li>
                            <li><a href="#">Code</a></li>
                            <li><a href="#">HTML</a></li>
                            <li><a href="#">CSS</a></li>
                        </ul>
                    </li>
                </ul>
                
                
            </div>
       <form method="Post" action="ProyectoPublico"  >
            <div class="description">
                <h1><% out.print(prodesp.getNombreProyecto());  %></h1>
                <h2>Categoria:<% out.println(prodesp.getCategoria()); %></h2>
                <p> ¿Cual es la idea?</p>
               
                <p><% out.print(prodesp.getIdea_Principal()); %></p>
                 <p><%out.print(prodesp.getId_Proyecto());%></p>
                
                <p>¿Cuanto dinero necesitamos?</p>
                <p> $<%out.print(prodesp.getMonto());%> .00</p>
                <p class="read-more">
                    <a href="">Mas acerca del proyecto</a>   

                    <input type="hidden" value="<%out.print(prodesp.getId_Proyecto());%>" id="InformacionProyecto" name="InformacionProyecto">
                     <input type="hidden" value="<%out.print(prodesp.getNombreProyecto());%>" id="NompreProyect" name="NompreProyect">
                      <input type="hidden" value="<%out.print(prodesp.getIdea_Principal());%>" id="IdeaProyect" name="IdeaProyect">
                       <input type="hidden" value="<%out.print(prodesp.getCategoria());%>" id="CategoriaProyect" name="CategoriaProyect">
                        <input type="hidden" value="<%out.print(prodesp.getMonto());%>" id="MontoProyect" name="MontoProyect">
                    
                      
                  <input type="submit" value="Proyecto Completo">
                </p>
            </div>
       </form>
            </div>
                
               

            </div>
        
                
                

 
            <% }
            %>
            
      <!-- </div>-->
       

            
         <script src="Disegno/js/jquery.js"></script>
        <script src="Disegno/js/bootstrap.js"></script>    
            
    </body>
</html>
