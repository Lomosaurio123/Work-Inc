

<%@page import="java.util.ArrayList"%>
<%@page import="com.working.modelos.ReporteEvento"%>
<%@page import="java.util.List"%>
<%@page import="com.working.modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
             <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
        <title>Generar Reporte de Eventos</title>
        <%
        
            HttpSession sesion= (HttpSession) request.getSession();
            Usuario usuario =(Usuario)sesion.getAttribute("usuario");       
            String correo = usuario.getCorreo();
            String contra = usuario.getContra();
            

             List<ReporteEvento> TodosRepEvento ;
          
           TodosRepEvento = (List<ReporteEvento>)request.getAttribute("TodosRep");
           int numerodereportes=0;
           ArrayList<ReporteEvento> ReportesTodos = new ArrayList<ReporteEvento>();
           ReporteEvento rep;
           
           for(ReporteEvento r : TodosRepEvento){
             String folio = r.getFolio();
             String moduloRep = r.getModuloFalla();
             String descripcion = r.getDescripcionFalla();
             String estado = r.getEstadoReporte();
             String etiqueta = r.getEtiqueta();
             String usuariofalla= r.getUsuarioFalla();
             String fechafall = r.getFechaFalla();
             String NombreOperador = r.getNombreOperador();
             String ApatOper = r.getApatOperador();
             String AmatOper= r.getAmatOperador();
               
                 rep=new ReporteEvento(moduloRep,descripcion,estado,usuariofalla,fechafall, etiqueta,folio,NombreOperador,ApatOper,AmatOper );
                 ReportesTodos.add(rep);
               numerodereportes ++;
           }

            
 
        %>
    </head>
    <body>
        <div class="container-fluid mt-4">
            
            <!--Menu para cambiar entre opciones-->
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="true"> Generar Reporte de Eventos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="notify-tab" data-toggle="tab" href="#notify" role="tab" aria-controls="notify" aria-selected="true"> Consultar Reportes de Evento </a>
                </li>

            </ul>
            
            <!--Seccion para desplegar contenidos-->
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="profile" role="tabpanel" aria-labbelledby="profile-tab">

                    <div class="row" >
                        <p>Dar de alta reporte de eventos</p>
                    </div>
                    <br/>
                    <form method="post" action="AltaReporte">
                        <select name="ModuloFalla" id="ModuloFalla">
                            <option value="0" selectd> Seleccione algun modulo </option> 
                            <option value="Proyectos">Proyectos</option> 
                            <option value="Curriculos" >Curriculos</option>
                            <option value="ModNegocio">Modelos de negocio</option>
                            <option value="Noticias">Noticias</option>
                            <option value="Usuario">Datos Usuario</option>
                        </select>
                        <br/>
                        <textarea name="DesripcionProblema" id="DesripcionProblema" rows="10" cols="50" placeholder="Descripcion del problema" ></textarea>
                        <br/>
                        <select name="EstadoReporte" id="EstadoReporte">
                            <option value="0" selectd> Estado de reporte </option> 
                            <option value="Solucionado">Solucionado</option> 
                            <option value="Proceso" >En proceso</option>
                            <option value="SinSolucion">Sin solucion</option>             
                        </select>
                        <br/>
                        <input type="text" id="UsuarioFalla" name="UsuarioFalla" placeholder="Usuario que reporta falla" >
                        <br/>
                        <input type="text" id="Etiqueta" name="Etiqueta" placeholder="Etiqueta" >
                        <br/>
                        <input type="hidden" id="OperadorIdentificador" name="OperadorIdentificador" value="<%out.print(correo);%>">
                        <input type="submit" name="" id="" value="Dar de alta reporte de eventos" class="btn btn-primary" >
                    </form>
                </div>


                <div class="tab-pane fade" id="notify" role="tabpanel" aria-labelledby="notify-tab">
                    <div class="row">
                        <div class="col"></div>
                        <div class="col-lg-12 col-md-12 col-sm-12 ">
                            <h4>Reportes de Evento generados</h4>
                            <br/>
                            <table class="table">
                                <tr>
                                    <th>Folio</th>
                                    <th>Usuario</th>
                                    <th>Modulo</th>
                                    <th>Descripcion</th>
                                    <th>Estado</th>
                                    <th>Etiqueta</th>
                                    <th>Fecha y Hora</th>
                                    
                                    <th>Modificar</th>

                                </tr>

                           <%
                               for(int i=0; i<=numerodereportes-1;i++){
                                   
                               ReporteEvento RepEven= ReportesTodos.get(i);
                               String Modulo = RepEven.getModuloFalla();
                               String Descripcion = RepEven.getDescripcionFalla();
                               String Estado = RepEven.getEstadoReporte();
                               String Usuario=RepEven.getUsuarioFalla();
                               String Fecha = RepEven.getFechaFalla();
                               String Etiqueta = RepEven.getEtiqueta();
                               String folio = RepEven.getFolio();
                               
                               out.print(Modulo);
                           %>
                           
                          
                           
                            <tr>
                                        <form method="post" action="ModificarReporteEvento">
                                            <td><input type="text" class="form-control" name="folio"  id="folio"  title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa"   required  value="<%out.print(folio);%>" readonly="readonly"/></td>
                                            <td><input type="text" name="Usuario" id="Usuario" class="form-control" placeholder="Puesto ocupado"     title="Este campo debe de llenarse unicamente con letras" required value="<%out.print(Usuario);%>"/></td>
                                            <td><input type="text" name="Modulo" id="Modulo" class="form-control" placeholder="Puesto ocupado"     title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(Modulo);%>"/></td>
                                            <td><input type="text" name="Descrip" id="Descrip" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(Descripcion);%>"/></td>
                                            <td><input type="text" name="Estado" id="Estado" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(Estado);%>"/></td>
                                           <td><input type="text" name="Etiqueta" id="Etiqueta" class="form-control" placeholder="Puesto ocupado"     title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(Etiqueta);%>"/></td> 
                                            <td><input type="text" name="Fecha" id="Fecha" class="form-control" placeholder="Puesto ocupado"     title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(Fecha);%>" readonly="readonly"/></td>
                                            
                                            <input type="hidden" name="correo" id="correo" value="<%out.print(correo);%>">
                                            <td><input type="submit" class="btn btn-success" name="guarda" id="guarda" value="Modificar"></td>
                                        </form>
                                       
                            </tr>
                           
                           
                           <%}%>
                            
                            </table>
                            

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
