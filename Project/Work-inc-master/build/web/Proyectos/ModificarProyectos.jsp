
<%@page import="com.working.modelos.TareaProyecto"%>
<%@page import="com.working.modelos.ProfesionistaRequerido"%>
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
        <link rel="shortcut icon" type="image/png" href="RecursosGraficos/Imagenes/ha.png"/>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>

        <title>Modificar Proyecto</title>
        <%
            Proyecto ProtyectoAConsultar;
            ProtyectoAConsultar = (Proyecto) request.getAttribute("ProyectoEspecifico");
            String TituloProyecto = ProtyectoAConsultar.getNombreProyecto();
            String IdeaProyecto = ProtyectoAConsultar.getIdea_Principal();
            String CategoriaProyecto = ProtyectoAConsultar.getCategoria();
            int MontoProyecto = ProtyectoAConsultar.getMonto();
            int informacion = ProtyectoAConsultar.getId_Proyecto();
            Blob imgproyecto = ProtyectoAConsultar.getImgregreso();

            List<Usuario> UsuariosInteresadosUnion;
            UsuariosInteresadosUnion = (List<Usuario>) request.getAttribute("ListaUsuariosPeticionUnion");
            int NumeroDeUsuarios = 0;
            ArrayList<Usuario> UsuariosTodos = new ArrayList<Usuario>();
            Usuario UsuSolicitud;
            for (Usuario u : UsuariosInteresadosUnion) {

                String NombreUsuario = u.getNombre();
                String ApellidoPaterno = u.getApat();
                String ApellidoMaterno = u.getAmat();
                String CorreoUsuario = u.getCorreo();
                String ProfesionUsuario = u.getProfesion();

                UsuSolicitud = new Usuario(NombreUsuario, ApellidoPaterno, ApellidoMaterno, CorreoUsuario, ProfesionUsuario);
                UsuariosTodos.add(UsuSolicitud);
                NumeroDeUsuarios = NumeroDeUsuarios + 1;
            }

            List<ProfesionistaRequerido> PuestosReq;
            PuestosReq = (List<ProfesionistaRequerido>) request.getAttribute("ListaProfesionistasRequeridos");
            int NumeroPuestosReq = 0;
            ArrayList<ProfesionistaRequerido> TodosPuestosReq = new ArrayList<ProfesionistaRequerido>();
            ProfesionistaRequerido Puestos;
            for (ProfesionistaRequerido req : PuestosReq) {

                String PuestoReq = req.getNombreProfesion();
                String StatusPuesto = req.getStatusPuesto();

                Puestos = new ProfesionistaRequerido(PuestoReq, StatusPuesto);
                TodosPuestosReq.add(Puestos);
                NumeroPuestosReq = NumeroPuestosReq + 1;
            }

            List<Usuario> UsuarioUnidos;
            UsuarioUnidos = (List<Usuario>) request.getAttribute("ListaUsuariosUnidos");
            int NumeroDeUsuariosUnidos = 0;
            ArrayList<Usuario> UsuariosUnidosTodos = new ArrayList<Usuario>();
            Usuario UsuUnido;
            for (Usuario Us : UsuarioUnidos) {

                String NombreUsuario = Us.getNombre();
                String ApellidoPaterno = Us.getApat();
                String ApellidoMaterno = Us.getAmat();
                String CorreoUsuario = Us.getCorreo();
                String ProfesionUsuario = Us.getProfesion();

                UsuUnido = new Usuario(NombreUsuario, ApellidoPaterno, ApellidoMaterno, CorreoUsuario, ProfesionUsuario);
                UsuariosUnidosTodos.add(UsuUnido);
                NumeroDeUsuariosUnidos = NumeroDeUsuariosUnidos + 1;
            }

            List<TareaProyecto> Tareas;
            Tareas = (List<TareaProyecto>) request.getAttribute("ListaTareas");
            int NumeroDeTareas = 0;
            ArrayList<TareaProyecto> TareasTodas = new ArrayList<TareaProyecto>();
            TareaProyecto TareaInd;
            for (TareaProyecto tp : Tareas) {

                String TituloTar = tp.getTitulo();
                String DescripTar = tp.getDescripcion();
                String ImportanciaTar = tp.getImportancia();
                int DiasTar = tp.getDuracionDias();
                String NombreUsA = tp.getUsrAsiNombre();
                String ApellidoPatUsA = tp.getApatAsiNombre();

                TareaInd = new TareaProyecto(TituloTar, DescripTar, ImportanciaTar, DiasTar, NombreUsA, ApellidoPatUsA);
                TareasTodas.add(TareaInd);
                NumeroDeTareas = NumeroDeTareas + 1;
            }

        %>
    </head>
    <body>
        <div class="container-fluid mt-4">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="true"> Actualizar Proyecto </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="notify-tab" data-toggle="tab" href="#notify" role="tab" aria-controls="notify" aria-selected="true"> Administrar Proyecto </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="chat-tab" data-toggle="tab" href="#chat" role="tab" aria-controls="chat" aria-selected="true">Chat</a>
                </li>
            </ul>
            <div class="tab-content" id="myTabContent">

                <div class="tab-pane fade show active" id="profile" role="tabpanel" aria-labbelledby="profile-tab">
                    <div class="table-responsive">
                        <table class="table table-bordered">
                   <form action="ModificarDatosProyecto" method="Post" enctype="multipart/form-data">
                       <tr>
                           <td scope="row" >
                               <h4>Nombre de proyecto</h4>
                           </td>
                           <td>
                        
                        <input type="text" class="form-control"   value="<%out.print(TituloProyecto);%>" id ="TituloProyectoo" name="TituloProyectoo">
                           </td>
                        
                        </tr>
                        <tr>
                            <td scope="row" >
                               <h4>Idea del proyecto</h4>
                           </td>
                            <td>
                                
                        <input type="text" class="form-control" value="<%out.print(IdeaProyecto);%>" id ="IdeaProyectoo" name="IdeaProyectoo">
                                
                            </td>
                        </tr>
                        <tr>
                            <td scope="row" >
                               <h4>Categoria</h4>
                           </td>
                            <td>
                        <input type="text"  class="form-control"value="<%out.print(CategoriaProyecto);%>" id ="CategoriaProyectoo" name="CategoriaProyectoo">
                            </td>
                        </tr>
                        <tr>
                            <td scope="row" >
                               <h4>Monto estimado</h4>
                           </td>
                            <td>
                        <input type="text" class="form-control" value="<%out.print(MontoProyecto);%>" id ="MontoProyectoo" name="MontoProyectoo">
                            </td>
                        </tr>
                        <tr>
                            <td scope="row" >
                               <h4>Fotografia del proyecto</h4>
                           </td>
                           <td>
                                <input  class="btn btn-primary " role="button"  accept="image/*" type="file" name="imagen" id="imagen" onchange="prevista(imagen)"><br/>
                           </td>
                        <input type="hidden"class="form-control" value="<%out.print(informacion);%>" id="informacioon" name="informacioon">
                        </tr>

                        <%

                            for (int i = 0; i <= NumeroPuestosReq - 1; i++) {
                                ProfesionistaRequerido puestos = TodosPuestosReq.get(i);
                                String puesto = puestos.getNombreProfesion();
                                String Status = puestos.getStatusPuesto();
                        %>

                        <tr>
                            <td>
                                <h4>Profesionista necesitado <%out.print(i+1);%></h4>
                           </td>
                           <td>
                               <div class="input-group" style="width:50%; ">
                            <input type="text" class="form-control" value="<%out.print(puesto);%>" readonly="readonly">
                               </div>
                               <div class="input-group" style="width:50%; ">
                               <input type="text"class="form-control" value="<%out.print(Status);%>"readonly="readonly">
                               </div>
                            </td>
                            
                        </tr>
                        
                        <%
                            }
                        %>
                        <tr>
                            <td>
                                <input type="submit" class="btn btn-primary"value="Modificar Datos">
                            </td>
                            <td>
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
                            out.println("<div><output id='list'><img  src='data:image/jpg;base64," + base64Encoded + "' alt='Imagen ID:' style='width:100%'></output></div>");
                        %>
                            </td>
                        </tr>
                        </table>
                        </div>
                    </form>

                    <script>
                        function archivo(evt) {
                            var files = evt.target.files;
                            // Obtenemos la imagen del campo "file".
                            for (var i = 0, f; f = files[i]; i++) {
                                //Solo admitimos imágenes.
                                if (!f.type.match('image.*')) {
                                    continue;
                                }
                                var reader = new FileReader();
                                reader.onload = (function (theFile) {
                                    return function (e) {
                                        // Insertamos la imagen
                                        document.getElementById("list").innerHTML = ['<img class="thumbnail  img-responsive" src="', e.target.result, '" title="', escape(theFile.name), '" style=" width:80%"/>'].join('');
                                    };
                                })(f);
                                reader.readAsDataURL(f);
                            }
                        }
                        document.getElementById('imagen').addEventListener('change', archivo, false);
                    </script>

                </div>

                <div class="tab-pane fade" id="notify" role="tabpanel" aria-labelledby="notify-tab">

                    <div class="row">
                        <br/>
                        <br/>
                        <br/>
                        <div class="col-lg-12 col-md-12 col-sm-12 ">
                            <h4>Solicitudes de Usuarios</h4>
                            

                            <Label for="Informacion">
                                Selecciona a los usuarios que cres que puedan aportar valor a tu proyecto, tendras la opcion de ver su curriculo.
                            </Label>
                            <hr/>
                             <table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nombre</th>
      <th scope="col">Profesion</th>
      <th scope="col">Correo</th>
      <th scope="col">Puesto</th>
      <th scope="col">Curriculum</th>
      <th scope="col">Accion</th>
      
      
    </tr>
  </thead>
                            
                            <%                           for (int i = 0; i <= NumeroDeUsuarios - 1; i++) {
                            %>

                            <%
                                Usuario SolicitudesUsuariosUnion = UsuariosTodos.get(i);
                                String NombreUsua = SolicitudesUsuariosUnion.getNombre();
                                String ApellidoPatUsu = SolicitudesUsuariosUnion.getApat();
                                String ApellidoMatUsu = SolicitudesUsuariosUnion.getAmat();
                                String CorreoUsua = SolicitudesUsuariosUnion.getCorreo();
                                String ProfesionUsua = SolicitudesUsuariosUnion.getProfesion();

                            %>
                            <div> 


                                
                                
  <tbody>
    <tr>
      <th scope="row"><%out.print(i+1);%></th>
      <td><%out.print(NombreUsua +" "+ ApellidoPatUsu +" "+ ApellidoMatUsu); %></td>
      <td><%out.print(ProfesionUsua);%></td>
      <td><%out.print(CorreoUsua);%></td>
      <td><form action="Curriculum/PDFCurriculum.jsp" method="post">
        <input type="submit" value="Curriculum" class="btn btn-link">
        <input type="hidden" value="<%out.print(CorreoUsua);%>" name="mail" id="mail">
        </form></td>
                                
<td>

                                <form action="ProcesesamientoSolicitud" method="post"> 

                                    <select id="PuestoSeleccionado" name="PuestoSeleccionado">
                                        <option value="0">Seleccione algun Puesto</option>
                                        <%

                                            for (int j = 0; j <= NumeroPuestosReq - 1; j++) {
                                                ProfesionistaRequerido puestos = TodosPuestosReq.get(j);
                                                String puesto = puestos.getNombreProfesion();
                                                String Status = puestos.getStatusPuesto();
                                        %>

                                        <%if (Status.equals("Disponible")) {%>
                                        <option class="optionHome" value="<%out.print(puesto);%>"><%out.print(puesto);%></option>
                                        <%
                                            }
                                        %>
                                        <%
                                            }
                                        %>

                                    </select>



    
</td>
      <td>
            <input type="hidden" value="<%out.print(informacion);%>" id="infoproject" name="infoproject">
                                    <input type="hidden" value="<%out.print(CorreoUsua);%>" id="correo" name="correo">
                                    <input type="submit" value="Aceptar" id="acciona" name="acciona" class="btn btn-success">
                                </form>
                                    <form action="RechazarSolicitudUnion" method="post">
                                    <input type="hidden" value="<%out.print(informacion);%>" id="infoproject" name="infoproject">
                                    <input type="hidden" value="<%out.print(CorreoUsua);%>" id="correo" name="correo">
                                    <input type="submit" value="Rechazar" id="accionb" name="accionb" class="btn btn-danger"> 
                                </form>
          
          
          
      </td>
      
    
    </tr>
  </tbody>
</table>



                                  

                                

                            </div>

                            <br/>


                            <%
                                }
                            %>






                        </div>

                        <div class="col"></div>
                    </div>
                    <div class="row">

                        <div class="col-lg-12 col-md-12 col-sm-12 ">
                            <h4>Administracion de tareas</h4>
                            <Label for="Informacion">
                                Registra las tareas Indispensables para tu proyecto y ponte a trabajar.
                            </Label>
                            <hr />

                            <table class="table table-bordered">
                                <tr>
                                    <td colspan="2">
                                        <h4>Tareas a Realizar</h4>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="table-responsive">
                                            <table class="table table-bordered">

                                                <tbody>

                                                    <tr>
                                                        <th scope="col">Asignacion de tarea</th>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <table class="table">

                                                                <tr>
                                                                    <th>Titulo de tarea</th>
                                                                    <th>Descripcion</th>
                                                                    <th>Importancia</th>
                                                                    <th>Usuario responsable</th>
                                                                    <th>Duracion(Dias)</th>
                                                                    <th><button  type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalXP">   +   </button></th>
                                                                </tr>
                                                                 <% for (int u = 0; u <= NumeroDeTareas - 1; u++) {
                                                                        TareaProyecto TareaSola = TareasTodas.get(u);
                                                                        String Titulo = TareaSola.getTitulo();
                                                                        String Descripcion = TareaSola.getDescripcion();
                                                                        String Importancia = TareaSola.getImportancia();
                                                                        int Numerodias = TareaSola.getDuracionDias();
                                                                        String NombreResponsable = TareaSola.getUsrAsiNombre();
                                                                        String ApellidoResponsable = TareaSola.getApatAsiNombre();

                                                                %>
                                                                <tr>


                                                                    <td><%out.print(Titulo);%></td>
                                                                    <td><%out.print(Descripcion);%></td>
                                                                    <td><%out.print(Importancia);%></td>
                                                                    <td><%out.print(NombreResponsable + " " + ApellidoResponsable);%></td>                                                              
                                                                    <td><%out.print(Numerodias);%></td>
                                                                    <td><button  type="button" class="btn btn-danger">   -   </button></td>
                                                                </tr>
                                                                <%}%>
                                                            </table>
                                                        </td>
                                                    </tr>

                                                    <tr>

                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </td>

                                </tr>
                            </table>


                            <form action="TareaAlta" method="post" onsubmit=" " >
                                <div class="modal fade" id="ModalXP" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">

                                        <div class="modal-content form-group">
                                            <div class="modal-header">
                                                <h3 class="modal-title" id="exampleModalLabel">REGISTRO DE TAREA</h3>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <div class="input-group" style="width:60%; ">
                                                    <span class="input-group-addon">Titulo de tarea</span>
                                                    <input type="text" class="form-control" name="TituloT"  id="TituloT" pattern="[A-Za-z]{1,20}" title="Este campo debe de llenarse unicamente con letras" placeholder="Ej. Conseguir Patrocinadores"  onkeypress="return sololetras(event)" required />
                                                </div>
                                                <br/>
                                                <div class="input-group" style="width:60%; ">
                                                    <span class="input-group-addon">Descripcion</span>
                                                    <input type="text" name="DescripcionT" id="DescripcionT" class="form-control" placeholder="Ej. Hablales de tu idea"    pattern="[A-Za-z]{1,20}" title="Este campo debe de llenarse unicamente con letras" onkeypress="return sololetras(event)" required />
                                                </div>
                                                <br/>
                                                <div class="input-group" style="width:60%; " >
                                                    <span class="input-group-addon">Importancia</span>
                                                    <input type="text" name="ImportanciaT" id="ImportanciaT" class="form-control"  placeholder="Alta, Media o Baja" pattern="[A-Za-z]{1,20}" title="Este campo debe de llenarse unicamente con letras" onkeypress="return sololetras(event)" required />
                                                </div>
                                                <br/>
                                                <div class="input-group" style="width:40%; " >
                                                    <span class="input-group-addon">Usuario asignado</span>
                                                    <select id="UsuarioResponsable" name="UsuarioResponsable" required>
                                                        <option value="0">Seleccione a su Victima</option>
                                                        <%
                                                            for (int h = 0; h <= NumeroDeUsuariosUnidos - 1; h++) {
                                                                Usuario usrun = UsuariosUnidosTodos.get(h);
                                                                String Nombre = usrun.getNombre();
                                                                String Apat = usrun.getApat();
                                                                String Amat = usrun.getAmat();
                                                                String correo = usrun.getCorreo();
                                                        %>


                                                        <option class="optionHome" value="<%out.print(correo);%>"><%out.print(Nombre + " " + Apat + " " + Amat);%></option>

                                                        <%
                                                            }
                                                        %>

                                                    </select>
                                                </div>
                                                <br/>
                                                <div class="input-group" style="width:40%; " >
                                                    <span class="input-group-addon">Duracion(Dias)</span>
                                                    <input type="number" placeholder="1" id="DuracionDias" name="DuracionDias" required/>
                                                    <input type="hidden" value="<%out.print(informacion);%>" id="InfoProyectoT" name="InfoProyectoT">
                                                </div>
                                                <br/>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">CANCELAR</button>
                                                <input type="submit" class="btn btn-primary" name="guarda" id="guarda" value="GUARDAR INFORMACION">
                                                <!--<input type="button" class="btn btn-primary" name="guarda" id="guarda" value="guarda" onclick="enviar()" />-->
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>

                        </div>



                        <div class="col"></div>
                    </div>

                </div>
                                                
                <div class="tab-pane fade show active" id="chat" role="tabpanel" aria-labbelledby="chat-tab">
                    <div>
                    
                    </div>
                </div>



            </div>

        </div>

        <script src="Disegno/js/jquery.js"></script>
        <script src="Disegno/js/bootstrap.js"></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js'></script>

    </body>
</html>
