<%-- 
    Document   : Perfilusuario
    Created on : 21/11/2018, 08:12:25 PM
    Author     : Hp
--%>

<%@page import="com.working.modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
  <meta charset="UTF-8">
  <title>Perfil de Usuario</title>
  
     <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>

</head>
<%
            HttpSession sesion = request.getSession();
            Usuario us = null;
            
            try{            
            
            us = (Usuario)request.getAttribute("usuarioCon");  
            if(request.getAttribute("actualizo").equals("actualizo")){
                out.println("<script>alert('usuario actualizado');</script>");
            }
                  
            
            
            }catch(Exception e){
                System.out.println("Error Perfilusuario: " + e.toString() + "--" + e.getMessage() + "_-" + e);
            }
            
            %>

<body>
<form method = "post" action="ActualizarUsuario" name="Actualizar" onsubmit="return validar(this)">
  <div class="container-fluid mt-4">
  <ul class="nav nav-tabs" id="myTab" role="tablist">
    <li class="nav-item">
      <a class="nav-link active" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="true"> Actualizar Perfil </a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="notify-tab" data-toggle="tab" href="#notify" role="tab" aria-controls="notify" aria-selected="true"> Eliminar Perfil </a>
    </li>
    
  </ul>
  <div class="tab-content" id="myTabContent">
    <div class="tab-pane fade show active" id="profile" role="tabpanel" aria-labbelledby="profile-tab">
      <div class="row">
        <div class="col"></div>
        <div class="col-lg-6 col-md-8 col-sm-12 pt-4">
          <h4> Informacion de Usuario </h4>
          <hr/>
          <div class="form-row">
            <div class="form-group col-lg-6 col-md-12">
              <label for="username"> Nombre </label>
              <input class="form-control" id="nombre" name="nombre" value="<%=us.getNombre()  %>">
            </div>
            <div class="form-group col-lg-6 col-md-12">
              <label for="email"> correo </label>
              <input class="form-control" id="email" name="correo" value="<%=us.getCorreo()%>">
            </div>
            <div class="form-group col-lg-6 col-md-12">
              <label for="firstname"> Apellido Paterno</label>
              <input class="form-control" id="firstname" name="apellido_pat" value="<%=us.getApat()%>">
            </div>
            <div class="form-group col-lg-6 col-md-12">
              <label for="lastname">Apellido Materno</label>
              <input class="form-control" id="lastname" name="apellido_mat" value="<%=us.getAmat()%>">
            </div>
            <div class="form-group col-lg-6 col-md-12">
                <label for="phone">Contraseña</label>
                <input type="password"class="form-control" id="phone" name="contrasena" value="<%=us.getContra()  %>">
            </div>
            <div class="form-group col-lg-6 col-md-12">
              <label for="password">Confirma contraseña</label>
              <input type="password" class="form-control" id="password" name="ConfirContra" value="<%=us.getContra()%>">
            </div>
            <div class="form-group col-lg-6 col-md-12">
                <label for="phone">Telefono</label>
              <input class="form-control" id="phone" name="telefono"   value="<%=us.getTelefono()%>">
            </div>
            <div class="form-group col-lg-6 col-md-12">
              <label for="password">Edad</label>
              <input type="text" class="form-control" id="password" name="edad" value="<%=us.getEdad()  %>">
            </div>
            <div class="form-group col-lg-6 col-md-12"></div>
              
            
            <div class="form-group col-lg-6 col-md-12">
                <label for="phone">N° de cecula</label>
              <input class="form-control" id="phone" name="cedula"   value="<%=us.getCedula()%>">
            </div>
              <div class="form-group col-lg-6 col-md-12">
                <label for="phone">Universidad</label>
              <input class="form-control" id="phone" readonly="readonly" name="uni" value="<%=us.getUniversidad()%>">
            </div>
            <div class="form-group col-lg-6 col-md-12">
              <label for="password">Profesion</label>
              <input type="text" class="form-control" id="password" readonly="readonly" name="prof" value="<%=us.getProfesion()%>"> 
            </div>
              <%
                    if(us.getGenero().equals("Masculino")){
                        out.print("<div class='form-group col-lg-6 col-md-12'>"+
                "<label for='phone'>Sexo</label>"+"<label for='sexo' ><input class='form-control' id='phone' type='radio'  name='Sexo' value='Masculino' checked>Masculino</label>"
            +"</div>"+"<div class='form-group col-lg-6 col-md-12'>" + "<label for='password'>Sexo</label>"+
              "<label for='sexo' >"+"<input class='form-control' id='phone' type='radio' name='Sexo' value='Femenino'>Femenino</label>"
            +"</div>");
                    }else{
                        out.print("<div class='form-group col-lg-6 col-md-12'>"+
                "<label for='phone'>Sexo</label>"+"<label for='sexo' ><input class='form-control' id='phone' type='radio'   name='Sexo' value='Masculino' checked>Masculino</label>"
            +"</div>"+"<div class='form-group col-lg-6 col-md-12'>" + "<label for='password'>Sexo</label>"+
              "<label for='sexo' >"+"<input class='form-control' id='phone' type='radio' name='Sexo' value='Femenino' checked>Femenino</label>"
            +"</div>");
                    }
                    %>
              
            
            <input class="btn btn-primary btn-block" type="submit" value="Actualizar Perfil" name="Envia">
            </form>
          </div>
        </div>
        <div class="col"></div>
        <a href="Usuarios/Menu.jsp">Regresar al menu</a>
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
          <form action="EliminarUsuario" method="get" onsubmit="return eliminar(this)" name="Eliminar">
                    <input type="submit" value="Eliminar Perfil" name="Envia">
        </form>
          
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
<script>
                    function eliminar(Eliminar){
                      if(confirm('¿Estas seguro de eliminar tu perfil?')){
                            document.Eliminar.submit();
                        }else{
                            return false;
                        }
                    }  
                </script>
</body>

</html>
