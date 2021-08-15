 <%@page import="com.working.modelos.Usuario"%>
<%@page import="com.working.modelos.Ticket"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.working.modelos.faqs"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%
           List<faqs> TodasPreguntas ;
          
           TodasPreguntas = (List<faqs>)request.getAttribute("Todos");
           int numerodepreguntas=0;
           ArrayList<faqs> PreguntasTodas = new ArrayList<faqs>();
           faqs fa;
           for(faqs f : TodasPreguntas){
             int id_pregun = f.getId_faq();
             String Pregunta=f.getPregunta();
             String fechaPre = f.getFechapregunta();
             String respues = f.getRespuesta();
             fa=new faqs(id_pregun, Pregunta, fechaPre,respues);
             PreguntasTodas.add(fa);
             numerodepreguntas=numerodepreguntas+1;
           }
           
//TicketsGeneradosUsu

 List<Ticket> TodosTicketsGenerados ;
          
           TodosTicketsGenerados = (List<Ticket>)request.getAttribute("TodosTickets");
           int numerotickets=0;
           ArrayList<Ticket> TicketsTodos = new ArrayList<Ticket>();
           Ticket ti;
           for(Ticket t: TodosTicketsGenerados){
             String Folio = t.getFolio();
             String EstadoRevision =t.getEstadoRevision();
             int InfoOperadorResp=t.getInformacionResponsableRevision();
             String NombreResp=t.getNombreResponsableRevisicon();
             String ApatResponsable=t.getApatResponsableRevisicon();
             String AmatResponsable=t.getAmatResponsableRevisicon();
             String FechaTicket=t.getFechaCreacionTicket();
             String ModuloTicket=t.getModulo();
             String Descripcion=t.getDescripcionProblema();
             String RespuestaTicket=t.getRespuesta();
                     
             ti=new Ticket(Folio,EstadoRevision,InfoOperadorResp,NombreResp,ApatResponsable,AmatResponsable,FechaTicket,ModuloTicket,Descripcion,RespuestaTicket);
             TicketsTodos.add(ti);
             numerotickets++;
           }
Usuario InformacionUsuarioTicket =(Usuario)request.getAttribute("DatosUsuTicket");
String NombreUsuario=InformacionUsuarioTicket.getNombre();
String ApatUsuario=InformacionUsuarioTicket.getApat();
String AmatUsuario=InformacionUsuarioTicket.getAmat();
String CorreoUsuario=InformacionUsuarioTicket.getCorreo();





        %>
<html lang="en" >

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FAQ'S WorkInc</title>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>

        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        
        <link href="Disegno/CSS/styleFaq.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <div class="container-fluid mt-4">
            
            <!--Menu para cambiar entre opciones-->
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="true"> Preguntas frecuentes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="notify-tab" data-toggle="tab" href="#notify" role="tab" aria-controls="notify" aria-selected="true"> Generar tickets de preguntas </a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link" id="check-tab" data-toggle="tab" href="#check" role="tab" aria-controls="check" aria-selected="true"> Tickets generados por mi </a>
                </li>
            </ul>
            
            <!--Seccion para desplegar contenidos-->
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="profile" role="tabpanel" aria-labbelledby="profile-tab">
                        <main>
            <h1>Preguntas Frecuentes Realizadas Por Los Usuarios</h1>
            <input type="text" class="live-search-box" placeholder="Búsqueda" />
            
            <%
            for(int i=0; i<=numerodepreguntas-1 ;i++ ){
            %>
            <div class="topic">
            <div class="open">
                <%faqs fas= PreguntasTodas.get(i);%>
                    <h2 class="question"><% out.print(fas.getPregunta());%><span class="ptag">SIEBEL</span></h2>
                    <span class="faq-t"></span>
                </div>
                <p class="answer"><% out.print(fas.getRespuesta());%><p>
            </div>
            <%  }
            %>
            <!--Ventana Modal Para realizar preguntas-->
            <h2 class="question">Si desea realizar una pregunta presione el siguiente boton</h2>
            <div class="contenedor-modal">
                <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#miModal">Realizar Pregunta</button>
            </div>
            <div class="modal fade" id="miModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title" id="myModalLabel">Preguntas</h4>
                        </div>
                        <form method="post" action="SubirPregunta">
                        <div class="modal-body">
                            <h2>Por favor, realice su pregunta:</h2>
                                <div class="form-group">
                                    <textarea class="form-control" id="Pregunta" name="Pregunta" rows="3"></textarea>
                                </div>
                                <button type="submit" class="btn btn-info">Enviar pregunta</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </main>
                   
            
                </div>


                <div class="tab-pane fade" id="notify" role="tabpanel" aria-labelledby="notify-tab">
                    <form action="AltaTicket" method="post" >
                        <p>Generar ticket de problema</p>
                        <br/>
                        <p>Selecciione el modulo donde se presento la falla</p>
                          <select name="ModuloFalla" id="ModuloFalla" select>
                            <option value="0" selectd> Seleccione algun modulo </option> 
                            <option value="Proyectos">Proyectos</option> 
                            <option value="Curriculos" >Curriculos</option>
                            <option value="ModNegocio">Modelos de negocio</option>
                            <option value="Noticias">Noticias</option>
                            <option value="Usuario">Datos Usuario</option>
                        </select>
                        <br/>
                        <textarea name="DesripcionProblema" id="DesripcionProblema" rows="10" cols="50" placeholder="Descripcion del problema" required></textarea>
                        <br/>
                        <input type="submit" id="EnviarTicket" name="EnviarTicket" value="Generar Ticket" class="btn btn-success">
                    </form> 
                        
                        
                    
                </div>
            <div class="tab-pane fade" id="check" role="tabpanel" aria-labelledby="notify-tab">
                <h3 class="modal-title" id="exampleModalLabel">Informacion de tickets que he generado.</h3>
                <br/>
                <br/>
                 <table class="table">
                      <tr>		
            <th scope="col">Estado de mis tickets</th>
        </tr>
        <tr>
            <td>
                <table class="table">
                     <tr>
                        <th>Folio</th>
                        <th>Modulo</th>
                        <th>Estado</th>
                        <th>Fecha y hora de creacion </th>
                        <th>Revisar Ticket</th>
                       
                    </tr>
                   
<%for(int j =0; j<=numerotickets-1; j++){
     Ticket Ticketss= TicketsTodos.get(j);
     String folio = Ticketss.getFolio();
     int InfoResp = Ticketss.getInformacionResponsableRevision();
     String Estado = Ticketss.getEstadoRevision();
     String FechaCreacion = Ticketss.getFechaCreacionTicket();
     String modulo= Ticketss.getModulo();
     String Descripcion =Ticketss.getDescripcionProblema();
     String Respuesta = Ticketss.getRespuesta();
     String NombreResp=Ticketss.getNombreResponsableRevisicon();
     String ApatResp=Ticketss.getApatResponsableRevisicon();
     String AmatResp=Ticketss.getAmatResponsableRevisicon();
     
%>

<tr>
    <td><%out.print(folio);%></td>
    <td><%out.print(modulo);%></td>
    <td><%out.print(Estado);%></td>
    <td><%out.print(FechaCreacion);%></td>
    <td><button  type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalEsco<%out.print(j);%>"> Ver Estado completo </button></td>
</tr>

                            <div class="modal fade bd-example-modal-lg" id="ModalEsco<%out.print(j);%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <form action="AsignacionReportes" method="post">
                                <div class="modal-dialog modal-lg" role="document">
                                    <div class="modal-content form-group">
                                        <div class="modal-header">
                                            <h3 class="modal-title" id="exampleModalLabel">Informacion del ticket: <%out.print(folio);%></h3>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="row">
                                                 <div class="col-xs-12  col-sm-6 col-md-6 col-lg-6">
                                                     <h6>Informacion del Ticket</h6>
                                                     <br/>
                                                     <p>Estado del ticket: <%out.print(Estado);%><br/>
                                                     Seccion Reportada: <%out.print(modulo);%><br/>
                                                     Fecha de creacion: <%out.print(FechaCreacion);%></p>
                                                 
                                                 
                                                 
                                                 
                                                 </div>
                                                 <div class="col-xs-12  col-sm-6 col-md-6 col-lg-6">
                                                     <h6>Datos del Operador que revisara mi ticket</h6>
                                                     <br/>
                                                     <%if(Estado.equals("Pendiente")){
                                                    
                                                     %>
                                                     <p>De momento no se ha asignado un operador a tu ticket</p>
                                                     <%}else{%>
                                                     
                                                     <p>Nombre del operador: <%out.print(NombreResp +" "+ ApatResp +" "+ AmatResp);%> </p>
                                                   
                                                     <%}%>
                                                     <p></p>
                                                     
                                                    
                                                 </div>
                                                
                                            </div>
                                                     <div class="row">
                                                         <div>
                                                         <p>Usuario: </p>
                                                         <p> <%out.print(NombreUsuario);%>  <%out.print(ApatUsuario);%>  <%out.print(AmatUsuario);%></p>
                                                      
                                                         </div>
                                                       
                                                     </div>
                                                           <div class="row">
                                                             <p>Descripcion:  <%out.print(Descripcion);%></p>
                                                             
                                                         </div>
                                                      
                                                     <div class="row bg-primary text-white">
                                                         <%if(Estado.equals("Pendiente")||Estado.equals("En proceso")){
                                                    
                                                     %>
                                                     <p>En espera de la respuesta del operador</p>
                                                     <%}else{%>
                                                     
                                                     <p>Respuesta: </p>
                                                     <p> <%out.print(Respuesta);%></p>
                                                     <%}%>
                                                         
                                                         
                                                         
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





<%}%>
                </table>
            </td>
        </tr>
                 </table>
                    
                </div>

            </div>
        </div>

        <script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>
        <script src="Disegno/js/FAQ.js" type="text/javascript"></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js'></script>
    </body>
</html>