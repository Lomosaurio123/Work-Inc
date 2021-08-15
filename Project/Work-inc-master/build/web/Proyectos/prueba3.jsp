

<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.util.Base64"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.working.modelos.Proyecto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Proyectos</title>
        <link href="Disegno/CSS/Todoslosproyectos.css" rel="stylesheet" type="text/css"/>
    </head>
  
         
    
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
    <body>

        <div class="general">
            
             <%
            for(int i=0; i<=numerodeproyectos-1 ;i++ ){
        %> 
        <form action=" ProyectoPublico" method="post">
        
        <div class="proyecto">
               
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
                    
                     
                    
            %>                
                
                
           
                
                <div class="imagen">
                    
                   <% out.println("<img src='data:image/jpg;base64,"+base64Encoded+"' alt='Imagen ID:' style='width:100%'>");%>
                </div>
                <div class="informacion">
                    <div class="texto">
                        <h1><%out.println(prodesp.getCategoria());%></h1>
                        <h2><% out.print(prodesp.getNombreProyecto());%></h2>
                        <h3><% out.print(prodesp.getMonto());%></h3>
                        <p> <% out.print(prodesp.getIdea_Principal());%></p>
                    </div>
                     <input type="hidden" value="<%out.print(prodesp.getId_Proyecto());%>" id="InformacionProyecto" name="InformacionProyecto">
                     <input type="hidden" value="<%out.print(prodesp.getNombreProyecto());%>" id="NompreProyect" name="NompreProyect">
                      <input type="hidden" value="<%out.print(prodesp.getIdea_Principal());%>" id="IdeaProyect" name="IdeaProyect">
                       <input type="hidden" value="<%out.print(prodesp.getCategoria());%>" id="CategoriaProyect" name="CategoriaProyect">
                        <input type="hidden" value="<%out.print(prodesp.getMonto());%>" id="MontoProyect" name="MontoProyect">
                        <a><div class="mas">
                       <input type="submit" value="Ver mas">
                            </div></a>
                </div>
            </div>
            </form>
                 
           
            
            
            
              <% }
            %>
        </div>

      
    </body>
</html>
