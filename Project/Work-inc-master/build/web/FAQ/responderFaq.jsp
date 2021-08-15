<%-- 
    Document   : responderFaq
    Created on : 17/02/2019, 08:58:59 PM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Responder FAQ</title>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
    </head>
    <body>

  <div class="container-fluid mt-4">
  <ul class="nav nav-tabs" id="myTab" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="true">FAQS</a>
    </li>
  </ul>
  <div class="tab-content" id="myTabContent">
      <br>
      <h4> Preguntas </h4>
        <hr/>
    <div class="tab-pane fade show active" id="profile" role="tabpanel" aria-labbelledby="profile-tab">
      <div class="row">
        <div class="col"></div>
        <div class="col-lg-6 col-md-8 col-sm-12 pt-4">
          
          <div class="form-row">
            <table class="table"> 
                
            <thead class="thead-dark">
                 
              <tr>
                <th scope="col">id</th>
                <th scope="col">Pregunta</th>
                <th scope='col'>Subir</th>
              </tr>
            </thead>
            <tbody>
              <tr>  
                  <td><p><% out.print(request.getParameter("idpregun"));%></p></td>
                  <td><p><% out.print(request.getParameter("pregunta"));%></p></td>
                 
              </tr>
           
             
            </tbody>
            <thead class="thead-dark">
                 
              <tr>
                <th scope="col">respuesta</th>
                <th scope="col"></th>
                <th scope="col"></th>
                
                
              </tr>
            </thead>
            <tbody>
              <tr>  
            <form action="../SubirRespuesta" method="post">
                      <td></td>
                      <td><input type="text" id="respues" name="respues"class="form-control"> </td> 
                <td><input type="submit" value="subir" class="btn btn-success"></td>
                <input type="hidden" value="<% out.print(request.getParameter("idpregun"));%>" name="id_pregunt" id="id_pregunt">
                </form> 
              </tr>
          </table>
          </div>
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
