<%-- 
    Document   : TareasARealizar
    Created on : 18/03/2019, 02:53:44 AM
    Author     : juan-
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.working.modelos.TareaProyecto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
        <title>JSP Page</title>
    </head>
    <%
    
    List<TareaProyecto> Tareas;
            Tareas = (List<TareaProyecto>) request.getAttribute("ListaTareasArealizar");
            int NumeroDeTareas = 0;
            ArrayList<TareaProyecto> TareasTodas = new ArrayList<TareaProyecto>();
            TareaProyecto TareaInd;
            for (TareaProyecto tp : Tareas) {
                String TituloTar = tp.getTitulo();
                String DescripTar = tp.getDescripcion();
                String ImportanciaTar = tp.getImportancia();
                int DiasTar = tp.getDuracionDias();
                int informacionTarea = tp.getInformacion();
                        

                TareaInd = new TareaProyecto(TituloTar, DescripTar, ImportanciaTar, DiasTar, informacionTarea);
                TareasTodas.add(TareaInd);
                NumeroDeTareas = NumeroDeTareas + 1;
            }

    
    %>
    <body>
        
        <div class="container-fluid mt-4">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="true"> Administracion de tareas </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="notify-tab" data-toggle="tab" href="#notify" role="tab" aria-controls="notify" aria-selected="true"> Chat </a>
                </li>

            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="profile" role="tabpanel" aria-labbelledby="profile-tab">
                    <div class="row">
                        
                        
                        
                        
                        <table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Titulo</th>
      <th scope="col">Descripcion</th>
      <th scope="col">Importancia</th>
      <th scope="col">Dias asignados</th>
      <th scope="col">Completar tarea</th>
      
    </tr>
  </thead>
  <tbody>
                        <%
                        for (int i = 0; i <= NumeroDeTareas - 1; i++) {
                                TareaProyecto TareaSola = TareasTodas.get(i);
                                String Titulo = TareaSola.getTitulo();
                                String Descripcion = TareaSola.getDescripcion();
                                String Importancia = TareaSola.getImportancia();
                                int Numerodias = TareaSola.getDuracionDias();
                                int informa = TareaSola.getInformacion();
                               
                        
                        
                        %>
                        
                        <tr>
      <th scope="row"><%out.print(i+1);%></th>
      <td><%out.print(Titulo);%></td>
      <td><%out.print(Descripcion);%></td>
      <td><%out.print(Importancia);%></td>
      <td><%out.print(Numerodias);%></td>
      <td>
          <form method="post"  action="BorrarTarea" >
              <input type="hidden" value="<%out.print(informa);%>" id="TareaTerminada" name="TareaTerminada">
              <input type="submit" value="Terminada" class="btn btn-danger">
          </form>
          
      </td>
    </tr>
                        
                        
                        
                        
                        
                        <%
                        }
                        %>
                
                        </tbody>
</table> 
                        
                    </div>

                </div>
                <div class="tab-pane fade" id="notify" role="tabpanel" aria-labelledby="notify-tab">
                    <div class="row" style="height: 500px ">
                         <iframe src="http://localhost:4000" style=" position: relative; height: 100%;width: 100%;"></iframe>
                    </div>
                </div>

            </div>
        </div>

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js'></script>
    </body>
</html>
