

<%@page import="java.util.Base64"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.working.modelos.Proyecto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Disegno/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        
        <title>JSP Page</title>
    </head>
    
    <%
     List<Proyecto> ProyectosUnidos;
         ProyectosUnidos = (List<Proyecto>) request.getAttribute("TodosProyectosUnidos");
         int NumeroDeProyectosUnidos = 0;
         ArrayList<Proyecto> ProyectosTodos = new ArrayList<Proyecto>();
         Proyecto ProyectosUnid;
         for (Proyecto p : ProyectosUnidos) {

             String TituloProyecto = p.getNombreProyecto();
             String IdeaProyecto = p.getIdea_Principal();
             String CategoriaProyecto = p.getCategoria();
             int MontoProyecto = p.getMonto();
             int informacion = p.getId_Proyecto();
             Blob imgproyecto = p.getImgregreso();

             ProyectosUnid = new Proyecto(TituloProyecto, IdeaProyecto, CategoriaProyecto, MontoProyecto, imgproyecto,informacion);
             ProyectosTodos.add(ProyectosUnid);
             NumeroDeProyectosUnidos++;
         }
    
    %>
    <body>
        <h1>PROYECTOS EN LOS QUE PARTICIPO</h1>
        
                <table class="table table-striped ">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Imagen</th>
      <th scope="col">Proyecto</th>
      <th scope="col">Categoria</th>
       <th scope="col"></th>
      
    </tr>
  </thead>
  <tbody>
        
        
        <% for(int i =0; i <=NumeroDeProyectosUnidos -1; i++ ){
            
            Proyecto ProyectosUnion = ProyectosTodos.get(i);
            String Titulo =ProyectosUnion.getNombreProyecto();
            String categoria = ProyectosUnion.getCategoria();
            int Informacion =ProyectosUnion.getId_Proyecto();
            Blob ImagenProyectoUnido = ProyectosUnion.getImgregreso();
            
        %>
        
        
          <%
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            byte[] buf = new byte[1024];
                            Blob blob = ImagenProyectoUnido;
                            InputStream in = blob.getBinaryStream();
                            int n = 0;
                            while ((n = in.read(buf)) >= 0) {
                                baos.write(buf, 0, n);
                            }
                            in.close();
                            byte[] bytes = baos.toByteArray();
                            byte[] encodedBytes = Base64.getEncoder().encode(bytes);
                            String base64Encoded = new String(encodedBytes, "UTF-8");                         
                        %>
        
        
        

    <tr>
      <th scope="row"><%out.print(i+1);%></th>
      <td><% out.println("<img  src='data:image/jpg;base64," + base64Encoded + "' alt='Imagen ID:' style='width:10%'>"); %></td>
      <td><%out.print(Titulo);%></td>
      <td><%out.print(categoria);%></td>
      <td>
          <form action="TareasARealizarPorProyecto" method="post">
              <input type="hidden" id="informacionProyecto" name="informacionProyecto" value="<%out.print(Informacion);%>">
          <input type="submit" class="btn btn-primary" value="Gestionar Tareas">
          </form>
      </td>
    </tr>
    

        
        
        
        
        <%}%>
        
          </tbody>
</table>
    </body>
</html>
