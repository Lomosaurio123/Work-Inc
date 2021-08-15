<%-- 
    Document   : Proyecto Especifico
    Created on : 22/02/2019, 12:08:17 PM
    Author     : Profesor
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.working.modelos.Usuario"%>
<%@page import="java.util.Base64"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="com.working.modelos.Proyecto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Disegno/CSS/uno.css" rel="stylesheet" type="text/css"/>
        
        <%
            
        HttpSession sesion= (HttpSession) request.getSession();
        Usuario usuario =(Usuario)sesion.getAttribute("usuario");
        
        String correo = usuario.getCorreo();
        String contra = usuario.getContra();
        
        
        
         Proyecto ProtyectoAConsultar;
            ProtyectoAConsultar = (Proyecto)request.getAttribute("ProyectoEspecifico");
            String TituloProyecto = ProtyectoAConsultar.getNombreProyecto();
            String IdeaProyecto= ProtyectoAConsultar.getIdea_Principal();
            String CategoriaProyecto= ProtyectoAConsultar.getCategoria();
            int MontoProyecto= ProtyectoAConsultar.getMonto(); 
            int informacion= ProtyectoAConsultar.getId_Proyecto();
            Blob imgproyecto = ProtyectoAConsultar.getImgregreso();

           
        %>
        
        <%
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            byte[] buf = new byte[1024];
                            Blob blob = imgproyecto;
                            InputStream in = blob.getBinaryStream();
                            int n = 0;
                            while ((n = in.read(buf)) >= 0) {
                                baos.write(buf, 0, n);
                            }
                            in.close();
                            byte[] bytes = baos.toByteArray();
                            byte[] encodedBytes = Base64.getEncoder().encode(bytes);
                            String base64Encoded = new String(encodedBytes, "UTF-8");
                            //out.println("<div><output id='list'><img  src='data:image/jpg;base64," + base64Encoded + "' alt='Imagen ID:' style='width:10%'></output></div>");
                        %>
        <title><% out.print(TituloProyecto);%></title>
       
    </head>
    <body>
       
                        
        <div class="fond"> <span class="s1">blog </span><span class="s2">card</span></div>
        <div class="card">
            <div class="thumbnail"><% out.println("<img  src='data:image/jpg;base64," + base64Encoded + "' alt='Imagen ID:' style='width:100%'>");%></div>
            <div class="right">
                <h1><%out.print(TituloProyecto);%></h1>
                
                <div class="separator"></div>
                <p> <%out.print(IdeaProyecto);%> </p>
            </div>
            <h6>Monto requerido: <%out.print(MontoProyecto);%></h6>
            <h5><%out.print(CategoriaProyecto);%></h5>
            
              <form action="SolicitudUnion" method="Post" >
                        <input type="hidden"  value="<%out.print(TituloProyecto);%>" id ="TituloProyectoo" name="TituloProyectoo">
                        <input type="hidden"  value="<%out.print(IdeaProyecto);%>" id ="IdeaProyectoo" name="IdeaProyectoo">
                        <input type="hidden"  value="<%out.print(CategoriaProyecto);%>" id ="CategoriaProyectoo" name="CategoriaProyectoo">
                        <input type="hidden"  value="<%out.print(MontoProyecto);%>" id ="MontoProyectoo" name="MontoProyectoo">
                        <input type="hidden" value="<%out.print(informacion);%>" id="informacioon" name="informacioon">
                        
                       
                        <input type="hidden" value="<%out.print(informacion);%>" id="InformacionProyecto" name="InformacionProyecto">
                     
    
                    
            <ul>
                <li><i class="fa fa-eye fa-2x"></i></li>
                <li><i class="fa fa-heart-o fa-2x"></i></li>
                <li><i class="fa fa-envelope-o fa-2x"></i></li>
                <li><i class="fa fa-share-alt fa-2x"></i></li>
            </ul>
            <div class="fab">   <input type="submit" value="Unirme al proyecto" ></div>
            
           </form>
        </div>
    </body>
</html>
