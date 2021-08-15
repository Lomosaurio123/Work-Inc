<%-- 
    Document   : ResolverReporteEvento
    Created on : 29/03/2019, 10:58:09 PM
    Author     : juan-
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.working.modelos.ReporteEvento"%>
<%@page import="java.util.List"%>
<%@page import="com.working.modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            HttpSession sesion= (HttpSession) request.getSession();
            Usuario usuario =(Usuario)sesion.getAttribute("usuario");       
            String correo = usuario.getCorreo();
            String contra = usuario.getContra();
            
            List<ReporteEvento> TodosRepEventoAsignados ;
            TodosRepEventoAsignados = (List<ReporteEvento>)request.getAttribute("TodosRepAsignadosIng");
            int numerodereportes=0;
            ArrayList<ReporteEvento> ReportesTodosAsignados = new ArrayList<ReporteEvento>();
            ReporteEvento rep;
            
             for(ReporteEvento r : TodosRepEventoAsignados){
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
             String EstadoAsignacion = r.getEstadoAsignacion();
             int InformacionIng = r.getInformacionIngenero();
             String NombreIngRep= r.getNombreIngDeSoftware();
             String ApatIngRep = r.getApatIngDeSoftware();
             String AmatIngRep =r.getAmatIngDeSoftware();
             String CorreoIngRep = r.getCorreoIng();
             String soluc = r.getSolucion();
             if(soluc == null){
                 soluc = "sin solucion";
             }
             
               
                 rep=new ReporteEvento(moduloRep,descripcion,estado,usuariofalla,fechafall, etiqueta,folio,EstadoAsignacion,InformacionIng,NombreIngRep,ApatIngRep,AmatIngRep,CorreoIngRep,NombreOperador,ApatOper,AmatOper,soluc );
                 ReportesTodosAsignados.add(rep);
               numerodereportes ++;
           }
        
        
        
        %>
    </head>
    <body>
    <table class="table">
            <tr>		
            <th scope="col">Reportes de evento existentes</th>
        </tr>
        <tr>
            <td>
                <table class="table">
                    <tr>
                        <th>Folio</th>
                        <th>Modulo</th>
                        <th>Descripcion</th>
                        <th>Estado</th>
                        <th>Cerrar</th> 
                        <th>Mantenimiento</th>
                    </tr>    
        
        
        
      <%for(int i=0; i<=numerodereportes-1;i++){
          ReporteEvento ReportesAsignados =ReportesTodosAsignados.get(i);
          String Folio = ReportesAsignados.getFolio();
          String moduloRep = ReportesAsignados.getModuloFalla();
          String descripcion = ReportesAsignados.getDescripcionFalla();
          String estado = ReportesAsignados.getEstadoReporte();
      %>
      
      <%if(!estado.equals("Solucionado")&&!estado.equals("Mantenimiento")){%>
      
      <tr>
      
                                            <td><input type="text" class="form-control" name="folio"  id="folio"  title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa"   required  value="<%out.print(Folio);%>" readonly="readonly"/></td>     
                                            <td><input type="text" name="Modulo" id="Modulo" class="form-control" placeholder="Puesto ocupado"     title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(moduloRep);%>"readonly="readonly"/></td>
                                            <td><input type="text" name="Descrip" id="Descrip" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(descripcion);%>"readonly="readonly"/></td>
                                            <td><input type="text" name="Estado" id="Estado" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(estado);%>"readonly="readonly"/></td>
                                            
                                            <td><button  type="button"  class="btn btn-danger" data-toggle="modal" data-target="#ModalCerrar<%out.print(i);%>">Cerrar Reporte</button></td>
                                            <td><button  type="button"  class="btn btn-warning" data-toggle="modal" data-target="#ModalManteni<%out.print(i);%>">Enviar a mantenimiento</button></td>
     
      </tr>
      
      
      <div class="modal fade" id="ModalManteni<%out.print(i);%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <form action="AsignarMantenimiento" method="post">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content form-group">
                                        <div class="modal-header">
                                            <h3 class="modal-title" id="exampleModalLabel">Asignar reporte al area de mantenimiento</h3>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="input-group" style="width:60%; ">
                                                <span class="input-group-addon">Folio de Reporte de evento: </span><p><b><%out.print(Folio);%></b></p>
                                                <input type="hidden" id="foliomantenimiento" name="foliomantenimiento" value="<%out.print(Folio);%>"> 
                                               
                                            </div>
                                            <br/>
                                            <h6>Una vez que confirmes esta asignacion el reporte sera enviado al area de mantenimiento y sera cerrado unicamente cuando esta area le de solucion</h6>
                                            <h6>Estas seguro de mandarlo al area de mantenimiento?</h6>
                                            
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger" data-dismiss="modal">CANCELAR</button>
                                            <input type="submit" class="btn btn-success" name="guarda" id="guarda" value="Asignar a mantenimiento">
                                            <!--<input type="button" class="btn btn-primary" name="guarda" id="guarda" value="guarda" onclick="enviar()" />-->
                                        </div>
                                    </div>
                                </div>
                                </form>
                            </div>
                                            
                            <div class="modal fade bd-example-modal-lg" id="ModalCerrar<%out.print(i);%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <form action="CerrarReporte" method="post">
                                <div class="modal-dialog modal-lg" role="document">
                                    <div class="modal-content form-group">
                                        <div class="modal-header">
                                            <h3 class="modal-title" id="exampleModalLabel">Cerrar reporte de evento</h3>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="input-group" style="width:60%; ">
                                                <span class="input-group-addon">Folio de Reporte de evento: </span><p><b><%out.print(Folio);%></b></p>
                                                <input type="hidden" id="foliocerrar" name="foliocerrar" value="<%out.print(Folio);%>">                                          
                                            </div>
                                            <br/>
                                            <h5>Antes de cerrar el reporte debes escribir la solucion</h5>
                                            <textarea name="SolucionReporte" id="SolucionReporte" rows="10" cols="100" placeholder="Solucion del reporte" required></textarea>
                                            
                                            
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">CANCELAR</button>
                                            <input type="submit" class="btn btn-primary" name="guarda" id="guarda" value="Cerrar reporte">
                                            <!--<input type="button" class="btn btn-primary" name="guarda" id="guarda" value="guarda" onclick="enviar()" />-->
                                        </div>
                                    </div>
                                </div>
                                </form>
                            </div>
                                            
                                            
                                            

     
                
     
     <%}else
     if(estado.equals("Solucionado")){%>
     
      
      <tr>
                                            <td><input type="text" class="form-control" name="folio"  id="folio"  title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa"   required  value="<%out.print(Folio);%>" readonly="readonly"/></td>     
                                            <td><input type="text" name="Modulo" id="Modulo" class="form-control" placeholder="Puesto ocupado"     title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(moduloRep);%>"readonly="readonly"/></td>
                                            <td><input type="text" name="Descrip" id="Descrip" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(descripcion);%>"readonly="readonly"/></td>
                                            <td><input type="text" name="Estado" id="Estado" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(estado);%>"readonly="readonly"/></td>
                                            <td>Reporte cerrado</td>
                                            
     </tr>

     <%}
else{%>
  <tr>
                                            <td><input type="text" class="form-control" name="folio"  id="folio"  title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa"   required  value="<%out.print(Folio);%>" readonly="readonly"/></td>     
                                            <td><input type="text" name="Modulo" id="Modulo" class="form-control" placeholder="Puesto ocupado"     title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(moduloRep);%>"readonly="readonly"/></td>
                                            <td><input type="text" name="Descrip" id="Descrip" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(descripcion);%>"readonly="readonly"/></td>
                                            <td><input type="text" name="Estado" id="Estado" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(estado);%>"readonly="readonly"/></td>
                                            <td></td>
                                            <td>Reporte en mantenimiento</td>
                                            
     </tr>


<%}%>
     
        
      <%}%>
      <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js'></script>
    </body>
    
</html>
