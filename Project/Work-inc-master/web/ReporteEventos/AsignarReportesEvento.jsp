<%-- 
    Document   : AsignarReportesEvento
    Created on : 28/03/2019, 12:24:28 PM
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                    
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>

        <title>JSP Page</title>
        <%
        
  HttpSession sesion= (HttpSession) request.getSession();
            Usuario usuario =(Usuario)sesion.getAttribute("usuario");       
            String correo = usuario.getCorreo();
            String contra = usuario.getContra();
            

           List<ReporteEvento> TodosRepEvento ;
          
           TodosRepEvento = (List<ReporteEvento>)request.getAttribute("TodosRepGeren");
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
             
               
                 rep=new ReporteEvento(moduloRep,descripcion,estado,usuariofalla,fechafall, etiqueta,folio,EstadoAsignacion,InformacionIng,NombreIngRep,ApatIngRep,AmatIngRep,CorreoIngRep,NombreOperador,ApatOper,AmatOper,soluc);
                 ReportesTodos.add(rep);
               numerodereportes ++;
           }
           

/*Parte para traer a los ingenieros de software disponibles*/

    List<Usuario> TodosIngenieroSoft ;

               TodosIngenieroSoft = (List<Usuario>)request.getAttribute("TodosIngSoft");
               int  numeroingenieros=0;
               ArrayList<Usuario> IngTodos = new ArrayList<Usuario>();
               Usuario IngUsu;

               for(Usuario us : TodosIngenieroSoft){
                 String Nombre = us.getNombre();
                 String Apat = us.getApat();
                 String Amat = us.getAmat();
                 String Correo = us.getCorreo();
                 String contraing = us.getContra();
                 String TipoUsua = us.getCodigoAdmin();
                 
                 
                     IngUsu=new Usuario(Nombre,Apat,Amat,Correo,contraing,TipoUsua);
                     IngTodos.add(IngUsu);
                   numeroingenieros ++;
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
                       
                        <th>Asignacion</th>
                        <th>Ing asignado</th>
                       
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
                               String EstadoAsign = RepEven.getEstadoAsignacion();
                               int InformaIng = RepEven.getInformacionIngenero();
                               String NombreIngInfo = RepEven.getNombreIngDeSoftware();
                               String ApatIngInfo=RepEven.getApatIngDeSoftware();
                               String AmatIngInfo=RepEven.getAmatIngDeSoftware();
                               String CorreoIngInfo=RepEven.getCorreoIng();
                               
                               
                           %>
                           
                           
                           <%if(!Estado.equals("Solucionado")&&!Estado.equals("Mantenimiento")){%>
                         
                           
                           <tr>
                                        <form method="post" action="#">
                                            <td><input type="text" class="form-control" name="folio"  id="folio"  title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa"   required  value="<%out.print(folio);%>" readonly="readonly"/></td>     
                                            <td><input type="text" name="Modulo" id="Modulo" class="form-control" placeholder="Puesto ocupado"     title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(Modulo);%>"/></td>
                                            <td><input type="text" name="Descrip" id="Descrip" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(Descripcion);%>"/></td>
                                            <td><input type="text" name="Estado" id="Estado" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(Estado);%>"/></td>
                                           
                                            <td><%out.print(EstadoAsign);%></td>
                                            <td><%out.print(NombreIngInfo + " "+ApatIngInfo+" "+AmatIngInfo );%></td>
                                            <%if(EstadoAsign.equals("Asignado")){
                                                
                                            %>
                                            <td><button  type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalEsco<%out.print(i);%>"> Modificar Asignacion</button></td>
                                            
                                            <%}else{%>
                                            
                                            <td><button  type="button" class="btn btn-success" data-toggle="modal" data-target="#ModalEsco<%out.print(i);%>">  Realizar asignacion </button></td>
                                            
                                            <%}%>
                                         
                                            
                                            
                                             
                                            <input type="hidden" name="correo" id="correo" value="<%out.print(correo);%>">
                                            <td></td>
                                        </form>
                                            
                                            <td><button  type="button" class="btn btn-danger" data-toggle="modal" data-target="#ModalBorra<%out.print(i);%>"> - </button></td>
                                            
                            </tr>
                            
                            <div class="modal fade" id="ModalEsco<%out.print(i);%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <form action="AsignacionReportes" method="post">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content form-group">
                                        <div class="modal-header">
                                            <h3 class="modal-title" id="exampleModalLabel">Asignacion de Ingeniero de Software</h3>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="input-group" style="width:60%; ">
                                                <span class="input-group-addon">Folio de Reporte de evento: </span><p><b><%out.print(folio);%></b></p>
                                                <input type="hidden" id="FolioIng" name="FolioIng" value="<%out.print(folio);%>">                                          
                                            </div>
                                            <br/>
                                            <div class="input-group" style="width:60%; ">
                                                <span class="input-group-addon">Ingenieros disponibles</span>
                                                <br/>
                                                <select id="IngSeleccionado" name="IngSeleccionado" required>
                                                    <option value="0">Seleccione algun Ingeniero</option>
                                                    <%
                                                        for (int j = 0; j <= numeroingenieros - 1; j++) {

                                                            Usuario IngDisponibles = IngTodos.get(j);
                                                            String NombreIng = IngDisponibles.getNombre();
                                                            String ApatIng = IngDisponibles.getApat();
                                                            String AmatIng = IngDisponibles.getAmat();
                                                            String CorreoIng = IngDisponibles.getCorreo();
                                                            String ConfirmaIng = IngDisponibles.getCodigoAdmin();

                                                    %>
                                                    <option class="optionHome" value="<%out.print(CorreoIng);%>"><%out.print(NombreIng + " " + ApatIng + " " + AmatIng);%></option>

                                                    <%}%>
                                                </select>
                                            </div>
                                            
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">CANCELAR</button>
                                            <input type="submit" class="btn btn-primary" name="guarda" id="guarda" value="Confirmar asignacion">
                                            <!--<input type="button" class="btn btn-primary" name="guarda" id="guarda" value="guarda" onclick="enviar()" />-->
                                        </div>
                                    </div>
                                </div>
                                </form>
                            </div>
                                   
                                                <!--AQUI IRA LA VENTANA MODAL PARA BORRAR-->
                                                <div class="modal fade" id="ModalBorra<%out.print(i);%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                    <form action="EliminarReporteEvento" method="post">
                                                        <div class="modal-dialog" role="document">
                                                            <div class="modal-content form-group">
                                                                <div class="modal-header">
                                                                    <h3 class="modal-title" id="exampleModalLabel">Eliminar Reporte</h3>
                                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span>
                                                                    </button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <div class="input-group" style="width:60%; ">
                                                                        <span class="input-group-addon">Folio de Reporte de evento: </span><p><b><%out.print(folio);%></b></p>
                                                                        <input type="hidden" id="FolioEven" name="FolioEven" value="<%out.print(folio);%>">                                          
                                                                    </div>
                                                                    <br/>
                                                                    <div class="input-group" style="width:60%; ">
                                                                         <input type="submit" class="btn btn-danger" name="elimina" id="elimina" value="Confirmar eliminacion">
                                                                        <br/>

                                                                    </div>

                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">CANCELAR</button>
                                                                   
                                                                    <!--<input type="button" class="btn btn-primary" name="guarda" id="guarda" value="guarda" onclick="enviar()" />-->
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                                                    
                         <!--VENTANA MODAL PARA MODIFICAR-->
                   <div class="modal fade" id="ModalModifica<%out.print(i);%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                    <form action="EliminarReporteEvento" method="post">
                                                        <div class="modal-dialog" role="document">
                                                            <div class="modal-content form-group">
                                                                <div class="modal-header">
                                                                    <h3 class="modal-title" id="exampleModalLabel">Modificar Datos Reporte</h3>
                                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span>
                                                                    </button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <div class="input-group" style="width:60%; ">
                                                                        <span class="input-group-addon">Folio de Reporte de evento: </span><p><b><%out.print(folio);%></b></p>
                                                                        <input type="hidden" id="FolioEven" name="FolioEven" value="<%out.print(folio);%>">                                          
                                                                    </div>
                                                                    <br/>
                                                                    <div class="input-group" style="width:60%; ">
                                                                         
                                                                        <br/>

                                                                    </div>

                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">CANCELAR</button>
                                                                   
                                                                    <!--<input type="button" class="btn btn-primary" name="guarda" id="guarda" value="guarda" onclick="enviar()" />-->
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>          
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                          
                         <%}else

if(Estado.equals("Solucionado")){%>
                          <tr>
                                        <form method="post" action="#">
                                            <td><input type="text" class="form-control" name="folio"  id="folio"  title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa"   required  value="<%out.print(folio);%>" readonly="readonly"/></td>     
                                            <td><input type="text" name="Modulo" id="Modulo" class="form-control" placeholder="Puesto ocupado"     title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(Modulo);%>"readonly="readonly" /></td>
                                            <td><input type="text" name="Descrip" id="Descrip" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(Descripcion);%>" readonly="readonly"/></td>
                                            <td><input type="text" name="Estado" id="Estado" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(Estado);%>" readonly="readonly"/></td>
                                           
                                            <td>No hace falta asignacion</td>
                                            <td>No hace falta asignacion</td>
                                            <%if(EstadoAsign.equals("Asignado")){
                                                
                                            %>
                                            
                                            
                                            <%}else{%>
                                            
                                            <td></td>
                                            
                                            <%}%>
                                         
                                            
                                            
                                             
                                            <input type="hidden" name="correo" id="correo" value="<%out.print(correo);%>">
                                            <td></td>
                                        </form>
                                            
                                            <td><button  type="button" class="btn btn-danger" data-toggle="modal" data-target="#ModalBorra<%out.print(i);%>"> - </button></td>
                                            
                            </tr>
                            
                             <div class="modal fade" id="ModalBorra<%out.print(i);%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                    <form action="EliminarReporteEvento" method="post">
                                                        <div class="modal-dialog" role="document">
                                                            <div class="modal-content form-group">
                                                                <div class="modal-header">
                                                                    <h3 class="modal-title" id="exampleModalLabel">Eliminar Reporte</h3>
                                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                        <span aria-hidden="true">&times;</span>
                                                                    </button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <div class="input-group" style="width:60%; ">
                                                                        <span class="input-group-addon">Folio de Reporte de evento: </span><p><b><%out.print(folio);%></b></p>
                                                                        <input type="hidden" id="FolioEven" name="FolioEven" value="<%out.print(folio);%>">                                          
                                                                    </div>
                                                                    <br/>
                                                                    <div class="input-group" style="width:60%; ">
                                                                         <input type="submit" class="btn btn-danger" name="elimina" id="elimina" value="Confirmar eliminacion">
                                                                        <br/>

                                                                    </div>

                                                                </div>
                                                                <div class="modal-footer">
                                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">CANCELAR</button>
                                                                   
                                                                    <!--<input type="button" class="btn btn-primary" name="guarda" id="guarda" value="guarda" onclick="enviar()" />-->
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                         
                         <%}else{
%>


       <tr>
                                        
                                            <td><input type="text" class="form-control" name="folio"  id="folio"  title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa"   required  value="<%out.print(folio);%>" readonly="readonly"/></td>     
                                            <td><input type="text" name="Modulo" id="Modulo" class="form-control" placeholder="Puesto ocupado"     title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(Modulo);%>"readonly="readonly" /></td>
                                            <td><input type="text" name="Descrip" id="Descrip" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(Descripcion);%>" readonly="readonly"/></td>
                                            <td><input type="text" name="Estado" id="Estado" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%out.print(Estado);%>" readonly="readonly"/></td>
                                           
                                            <td><%out.print(EstadoAsign);%></td>
                                            <td><%out.print(NombreIngInfo + " "+ApatIngInfo+" "+AmatIngInfo );%></td>
                                            <%if(EstadoAsign.equals("Asignado")){
                                                
                                            %>
                                            
                                            
                                            <%}else{%>
                                            
                                            <td></td>
                                            
                                            <%}%>

                                            <input type="hidden" name="correo" id="correo" value="<%out.print(correo);%>">
                                            <td>En espera del area de mantenimiento</td>
                                        
                                            
                                            <td></td>
                                            
                            </tr>
<%}%>
                                                
      
        <%}%>
                </table>
            </td>
        </tr>
        </table>
         <%
                               for(int i=0; i<=numeroingenieros-1;i++){
                                   
                               Usuario IngDisponibles= IngTodos.get(i);
                               String NombreIng = IngDisponibles.getNombre();
                               String ApatIng = IngDisponibles.getApat();
                               String AmatIng= IngDisponibles.getApat();
                               String CorreoIng= IngDisponibles.getCorreo();
                               String ConfirmaIng = IngDisponibles.getCodigoAdmin();
                               
                           %>
                           
                          
        <%}%>
        
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js'></script>
    </body>
</html>
