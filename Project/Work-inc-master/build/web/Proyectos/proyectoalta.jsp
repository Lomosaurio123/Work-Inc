
<%-- 
    Document   : proyectoalta
    Created on : 11/11/2018, 05:13:01 PM
    Author     : nayei
--%>

<%@page import="com.working.modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/png" href="../RecursosGraficos/Imagenes/ha.png"/>
        <link rel="stylesheet" href="../Disegno/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="../Disegno/CSS/proyectoalta.css">
        <style>
             
            body{
    
            overflow-y: auto;
            font-family: Arial;
}
            
        </style>
         
        <title>Registro_Proyecto</title>
        <%
        
        HttpSession sesion= (HttpSession) request.getSession();
        Usuario usuario =(Usuario)sesion.getAttribute("usuario");
        
        String correo = usuario.getCorreo();
        String contra = usuario.getContra();

        %>
    </head>
    <body>
        
        
        

        <form method="post" action="../proyectoalta" enctype="multipart/form-data">

            <div class="container">
                <h1>Registro de proyecto</h1>
                <div class=" row" style="display: -webkit-flex; flex-wrap: wrap;">
                
                    <article class="col-xs-12  col-sm-2 col-md-2 col-lg-2 " >
                         <div ><output id="list"></output></div>
                    </article>
                    
                     <article class="col-xs-12  col-sm-5 col-md-5 col-lg-5 margen" >
                     <input type="text"   class="form-control form-control-lg" placeholder="NOMBRE DEL PROYECTO"  id="NombreProyecto" name="NombreProyecto" required/>
                     <br/>
                     <input  class="btn btn-primary " role="button"  accept="image/*" type="file" name="imagen" id="imagen" onchange="prevista(imagen)"><br/>
                    </article>
                    

                    <article class="col-xs-12  col-sm-4 col-md-4 col-lg-4 margen">
                        <h4>¡Selecciona la categoria de tu proyecto!</h4>
                        <div class="input-group-prepend">
                        <select  id="Categoria" class="combobox form-control" name="Categoria" style="margin: 0 auto;">
                            <option value="0">Seleccione alguna categoria</option>
                            <option class="optionHome" value="Ciencias Exactas">Ciencias Exactas</option>
                            <option class="optionHome" value="Ciencias Naturales">Ciencias Naturales</option>
                            <option class="optionHome" value="Medicina y Salud">Medicina y Salud</option>
                            <option class="optionHome" value="Ciencias Sociales y Humanidades">Ciencias Sociales y Humanidades</option>
                            <option class="optionHome" value="Ciencias de la Ingenieria">Ciencias de la Ingenieria</option>
                            <option class="optionHome" value="Agropecuarias y de Alimentos">Agropecuarias y de Alimentos</option>
                            <option class="optionHome" value="Divulgacion Cientifica">Divulgacion Cientifica</option>
                            <option class="optionHome" value="Medio Ambiente">Medio Ambiente</option>
                            <option class="optionHome" value="Mecatronica">Mecatronica</option>
                            <option class="optionHome" value="Ciencias de los Materiales">Ciencias de los Materiales</option>
                            <option class="optionHome" value="Biología">Biología</option>
                            <option class="optionHome" value="Computación y Software">Computación y Software</option>
                        </select>
                        </div>
                    </article>          
                </div>
                <div class=" row" style="display: -webkit-flex; flex-wrap: wrap;">
                    
                    <div class="col-xs-12  col-sm-12 col-md-12 col-lg-12 margen">
                        <select class="combobox form-control" id="NumeroIntegrantes" name="NumeroIntegrantes" style="margin: 0 auto;" onchange="myFunction()">
                            <option value="0">Seleccione el numero de integrantes</option>
                            <option class="optionHome" value="1">1</option>
                            <option class="optionHome" value="2">2</option>
                            <option class="optionHome" value="3">3</option>
                            <option class="optionHome" value="4">4</option>
                            <option class="optionHome" value="5">5</option>
                        </select>
                        <br/>
                        <input class="form-control form-control-lg" type="text" id="Int1" name="Int1" placeholder="Profesionista requerido num. 1" style="display: none">
                        <input class="form-control form-control-lg" type="text" id="Int2" name="Int2"  placeholder="Profesionista requerido num. 2" style="display: none">
                        <input class="form-control form-control-lg" type="text" id="Int3" name="Int3"  placeholder="Profesionista requerido num. 3" style="display: none">
                        <input class="form-control form-control-lg" type="text" id="Int4" name="Int4"  placeholder="Profesionista requerido num. 4" style="display: none">
                        <input class="form-control form-control-lg" type="text" id="Int5" name="Int5"  placeholder="Profesionista requerido num. 5" style="display: none">
                        <script>
                            function myFunction() {
                                var numIn = document.getElementById("NumeroIntegrantes");
                                var val = numIn.options[numIn.selectedIndex].value;
                                //Creamos un nodo de texto que agregaremos al div.
                                /*alert(val);*/
                                for (var i = 1, max = 5; i <= max; i++) {
                                    var text = document.getElementById("Int" + i);
                                    text.style.display = "none";
                                }
                                for (var i = 1, max = val; i <= max; i++) {
                                    var text = document.getElementById("Int" + i);
                                    text.style.display = "block";
                                }
                            }
                        </script>
                    </div>   
                </div>
                <div class=" row" style="display: -webkit-flex; flex-wrap: wrap;">
                    <article class="col-xs-12  col-sm-7 col-md-7 col-lg-7 margen">
                        <input class="form-control form-control-lg" placeholder="Escribe la idea de tu proyecto" type="text" id="IdeaProyecto" name="IdeaProyecto" required/>
                    </article>
                    <article class="col-xs-12  col-sm-5 col-md-5 col-lg-5 margen">
                      
                        <input class="form-control"  placeholder="Donacion necesaria"type="number" id="Monto_Donacion" name="MontoDonacion" required/>
                    </article>
                    
                    
                    
                </div>
                




                
                
               
                <input  class="btn btn-primary btn-lg btn-block" type="submit" name="Guardar" id="Enviar" value="GUARDAR PROYECTO"> 
            </div>
        </form>

         <script>
          function archivo(evt) {
              var files = evt.target.files; // FileList object

              // Obtenemos la imagen del campo "file".
              for (var i = 0, f; f = files[i]; i++) {
                //Solo admitimos imágenes.
                if (!f.type.match('image.*')) {
                    continue;
                }

                var reader = new FileReader();
                reader.onload = (function(theFile) {
                    return function(e) {
                      // Insertamos la imagen
                     document.getElementById("list").innerHTML = ['<img class="thumbnail  img-responsive" src="', e.target.result,'" title="', escape(theFile.name), '" style=" width:80%"/>'].join('');
                    };
                })(f);

                reader.readAsDataURL(f);
              }
          }

          document.getElementById('imagen').addEventListener('change', archivo, false);
    </script>
   
        
    <script src="Disegno/js/jquery.js"></script>
    <script src="Disegno/js/bootstrap.js"></script>
        
    </body>
</html>
