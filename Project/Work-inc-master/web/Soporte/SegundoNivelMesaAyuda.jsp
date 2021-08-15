<%-- 
    Document   : SegundoNivelMesaAyuda
    Created on : 11/03/2019, 09:21:48 PM
    Author     : juan-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
        <link rel="shortcut icon" type="image/png" href="RecursosGraficos/Imagenes/ha.png"/>
        <title>JSP Page</title>
    </head>
    <body>
       <div class="container-fluid mt-4">
  <ul class="nav nav-tabs" id="myTab" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="true"> Generar Un ticket </a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="notify-tab" data-toggle="tab" href="#notify" role="tab" aria-controls="notify" aria-selected="true"> Revisar estado de mis tickets</a>
    </li>
    
  </ul>
  <div class="tab-content" id="myTabContent">
    <div class="tab-pane fade show active" id="profile" role="tabpanel" aria-labbelledby="profile-tab">
        
        
        
        <div>
            <form action="GenerarTicket" method="post">
            
          
            <p>Por favor escriba el problema</p>
            <input type="text" id="ModuloProblema" name="ModuloProblema" placeholder="Modulo del problema" > 
            <br/>
            <input type="text" id="ModuloProblema" name="ModuloProblema" placeholder="Descripcion del problema" >
            <br/>
            <input type="submit" value="enviar ticket">
            </form>
        </div>
        <div>
              
            
        </div>
        
        
        
        
        
        
        
        
        
        
        
        
        
    
    </div>
    <div class="tab-pane fade" id="notify" role="tabpanel" aria-labelledby="notify-tab">
      <div class="row">
        <div class="col"></div>
        <div class="col-lg-6 col-md-8 col-sm-12 pt-4">
          <h4>Eliminar Usuario</h4>
          <Label for="Informacion">Si elimina el perfil de usuario de eliminara toda la informacion relacionada con este, y se perdera todo la reputacion que haya adquiero con este 
              perfil , aun asi, ¿Desea Eliminar el perfil de usuario?.
          </Label>
          <hr />
          
        </div>
        <div class="col-lg-6 col-md-8 col-sm-12 pt-4">
          
          
          
        </div>
        <div class="col"></div>
      </div>
    </div>
    
    </div>
  </div>
        
        
        
        
        
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js'></script>
    </body>
</html>
