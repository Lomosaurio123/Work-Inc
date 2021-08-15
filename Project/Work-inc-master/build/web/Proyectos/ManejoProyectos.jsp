
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
         <link href="../Disegno/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"  MEDIA=screen/>
        <title>Administracion_Proyectos</title>
        <style>
            div{
                float: left;
               
            }
        </style>
        <%
           List<Proyecto> TodosProyectos ;
          
           TodosProyectos = (List<Proyecto>)request.getAttribute("TodosUsuario");
           int numerodeproyectos=0;
           ArrayList<Proyecto> ProyectosTodos = new ArrayList<Proyecto>();
           Proyecto pro;
           
           for(Proyecto p : TodosProyectos){
             String idea=p.getIdea_Principal();
             String nombreproyect = p.getNombreProyecto();
             int monto = p.getMonto();
             String categoria = p.getCategoria();
             Blob imgproyecto = p.getImgregreso();
             
                 pro=new Proyecto(nombreproyect,idea,categoria,monto,imgproyecto);
                 ProyectosTodos.add(pro);
               numerodeproyectos=numerodeproyectos+1; 
           }
        %>
    </head>
    <body>
        
        <div style="justify-content:center">
        <%
            for(int i=0; i<=numerodeproyectos-1 ;i++ ){
        %> 
       
              
            <div class="blog-card">
            <div class="meta">
               
            
            
            <%
               Proyecto prodesp= ProyectosTodos.get(i);
               

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
      

                <ul class="details">
                    <li class="author"><a href="#">Proyecto de WORK-INC</a></li>
                        
                    </li>
                </ul>
                
                
            </div>
            <div class="description">
                
                <form action="ProyectoEspecifico" method="post">
                <h1><% out.print(prodesp.getNombreProyecto());  %></h1>
                <%String tituloprueba=prodesp.getNombreProyecto(); %>
                <input type="hidden" value="<% out.print(prodesp.getNombreProyecto());%>" id="NompreProyect" name="NompreProyect">
                
                
                
                <h2>Categoria: <% out.println(prodesp.getCategoria()); %></h2>
                <input type="hidden" value="<%out.print(prodesp.getCategoria()); ;%>" id="CategoriaProyect" name="CategoriaProyect">
                
                <p><b> ¿Cual es la idea?</b></p>
                <p><% out.print(prodesp.getIdea_Principal()); %></p>
                <input type="hidden" value="<%out.print(prodesp.getIdea_Principal()) ;%>" id="IdeaProyect" name="IdeaProyect">
                
                <p><b>¿Cuanto dinero necesitamos?</b></p>
                <p> $<%out.print(prodesp.getMonto());%> .00</p>
                <input type="hidden" value="<% out.print(prodesp.getMonto()); %>" id="MontoProyect" name="MontoProyect">

                <p class="read-more">
                 <input type="submit"  class="btn btn-primary" value="Administracion del Proyecto">
                    
                </p>
                </form>
            </div>
            </div>
                
            <% }
            %>
            
        </div>
       

            
            
            
    </body>
</html>
