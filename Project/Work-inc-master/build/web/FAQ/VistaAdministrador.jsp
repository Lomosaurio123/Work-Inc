<%-- 
    Document   : VistaAdministrador
    Created on : 16/02/2019, 07:47:20 PM
    Author     : mauga
--%>

<%@page import="com.working.modelos.Ticket"%>
<%@page import="com.working.modelos.ReporteEvento"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.working.modelos.faqs"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" >

    <head>
        <meta http-equiv=”Content-Type” content=”text/html; charset=ISO-8859-1″ />

        <link rel="stylesheet" href="Disegno/icon/style.css">

        <title>Preguntas realizadas por usuarios</title>
        <%
            request.setCharacterEncoding("UTF8");
        %>

        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>

        <%
            List<faqs> TodasPreguntas;

            TodasPreguntas = (List<faqs>) request.getAttribute("Todos");
            int numerodepreguntas = 0;
            ArrayList<faqs> PreguntasTodas = new ArrayList<faqs>();
            faqs fa;
            for (faqs f : TodasPreguntas) {
                int id_pregun = f.getId_faq();
                String Pregunta = f.getPregunta();
                String fechaPre = f.getFechapregunta();
                fa = new faqs(id_pregun, Pregunta, fechaPre);
                PreguntasTodas.add(fa);
                numerodepreguntas = numerodepreguntas + 1;

            }
            int numerodereportes = 0;
            ArrayList<ReporteEvento> ReportesTodosAsignados = new ArrayList<ReporteEvento>();
            int numerotickets = 0;
            ArrayList<Ticket> TicketsTodosAsignados = new ArrayList<Ticket>();
            List<Ticket> TodosTicketsGenerados;
            int numeroticketsAsignados = 0;
            ArrayList<Ticket> TicketsTodos = new ArrayList<Ticket>();
            try {
                List<ReporteEvento> TodosRepEventoAsignados;
                TodosRepEventoAsignados = (List<ReporteEvento>) request.getAttribute("TodosRepAsignadosIng");
                ReporteEvento rep;
                for (ReporteEvento r : TodosRepEventoAsignados) {
                    String folio = r.getFolio();
                    String moduloRep = r.getModuloFalla();
                    String descripcion = r.getDescripcionFalla();
                    String estado = r.getEstadoReporte();
                    String etiqueta = r.getEtiqueta();
                    String usuariofalla = r.getUsuarioFalla();
                    String fechafall = r.getFechaFalla();
                    String NombreOperador = r.getNombreOperador();
                    String ApatOper = r.getApatOperador();
                    String AmatOper = r.getAmatOperador();
                    String EstadoAsignacion = r.getEstadoAsignacion();
                    int InformacionIng = r.getInformacionIngenero();
                    String NombreIngRep = r.getNombreIngDeSoftware();
                    String ApatIngRep = r.getApatIngDeSoftware();
                    String AmatIngRep = r.getAmatIngDeSoftware();
                    String CorreoIngRep = r.getCorreoIng();
                    String solucion = r.getSolucion();
                    rep = new ReporteEvento(moduloRep, descripcion, estado, usuariofalla, fechafall, etiqueta, folio, EstadoAsignacion, InformacionIng, NombreIngRep, ApatIngRep, AmatIngRep, CorreoIngRep, NombreOperador, ApatOper, AmatOper, solucion);
                    ReportesTodosAsignados.add(rep);
                    numerodereportes++;
                }

                TodosTicketsGenerados = (List<Ticket>) request.getAttribute("Todostickets");

                Ticket ti;
                for (Ticket t : TodosTicketsGenerados) {
                    String Folio = t.getFolio();
                    String EstadoRevision = t.getEstadoRevision();
                    int InfoOperadorResp = t.getInformacionResponsableRevision();
                    String NombreResp = t.getNombreResponsableRevisicon();
                    String ApatResponsable = t.getApatResponsableRevisicon();
                    String AmatResponsable = t.getAmatResponsableRevisicon();
                    String FechaTicket = t.getFechaCreacionTicket();
                    String ModuloTicket = t.getModulo();
                    String Descripcion = t.getDescripcionProblema();
                    String RespuestaTicket = t.getRespuesta();

                    ti = new Ticket(Folio, EstadoRevision, InfoOperadorResp, NombreResp, ApatResponsable, AmatResponsable, FechaTicket, ModuloTicket, Descripcion, RespuestaTicket);
                    TicketsTodos.add(ti);
                    numerotickets++;
                }
                List<Ticket> TodosTicketsAsignados;

                TodosTicketsAsignados = (List<Ticket>) request.getAttribute("TodosticketsAsignados");

                Ticket tia;
                for (Ticket t : TodosTicketsAsignados) {
                    String Folio = t.getFolio();
                    String EstadoRevision = t.getEstadoRevision();
                    int InfoOperadorResp = t.getInformacionResponsableRevision();
                    String NombreResp = t.getNombreResponsableRevisicon();
                    String ApatResponsable = t.getApatResponsableRevisicon();
                    String AmatResponsable = t.getAmatResponsableRevisicon();
                    String FechaTicket = t.getFechaCreacionTicket();
                    String ModuloTicket = t.getModulo();
                    String Descripcion = t.getDescripcionProblema();
                    String RespuestaTicket = t.getRespuesta();
                    tia = new Ticket(Folio, EstadoRevision, InfoOperadorResp, NombreResp, ApatResponsable, AmatResponsable, FechaTicket, ModuloTicket, Descripcion, RespuestaTicket);
                    TicketsTodosAsignados.add(tia);
                    numeroticketsAsignados++;
                }

            } catch (Exception e) {
                System.out.println("error en faqs " + e.getMessage());
            }
        %>

    </head>
    <body>

        <div class="container-fluid mt-4">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="profile-tab" data-toggle="tab" href="#Faqs" role="tab" aria-controls="profile" aria-selected="true">FAQS</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " id="ResponderTicket-tab" data-toggle="tab" href="#ResponderTicket" role="tab" aria-controls="ResponderTicket" aria-selected="true">Tickets Disponibles</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " id="Asignados-tab" data-toggle="tab" href="#Asignados" role="tab" aria-controls="Asignados" aria-selected="true">Tickets Asignados</a>
                </li>
            </ul>

            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="Faqs" role="tabpanel" aria-labbelledby="profile-tab">
                    <br>
                    <div class="row">
                        <h4> Preguntas </h4>
                        <hr/>

                        <table class="table">
                            <%
                                List<faqs> TodasFAQ;

                                TodasFAQ = (List<faqs>) request.getAttribute("TodasFAQ");
                                int numerofaq = 0;
                                ArrayList<faqs> faqTodas = new ArrayList<faqs>();
                                faqs fas;
                                for (faqs f : TodasFAQ) {
                                    int id_pregun = f.getId_faq();
                                    String Pregunta = f.getPregunta();
                                    String fechaPre = f.getFechapregunta();
                                    String respues = f.getRespuesta();
                                    fas = new faqs(id_pregun, Pregunta, fechaPre, respues);
                                    faqTodas.add(fas);
                                    numerofaq = numerofaq + 1;

                                }
                            %>
                            <tr>
                                <th>id</th>
                                <th>fecha</th>
                                <th>Pregunta</th>
                                <th>Respuesta</th>
                                <th></th>
                                <th><button  type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalFAQ">   +   </button></th>
                            </tr>
                            <%
                                for (int i = 0; i <= numerofaq - 1; i++) {
                                    faqs ask = faqTodas.get(i);

                            %> 
                            <tr>
                            <form method="post" action="ModificarFAQEditor">
                                <td><input type="text" class="form-control" name="empresa"  id="empresa"  title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa" readonly="readonly"  required  value="<%=ask.getId_faq()%>"/></td>
                                <td><input type="text" name="puesto" id="puesto" class="form-control" placeholder="Puesto ocupado"   readonly="readonly"  title="Este campo debe de llenarse unicamente con letras" required value="<%=ask.getFechapregunta()%>"/></td>
                                <td><input type="text" name="pregunta" id="pregunta" class="form-control" placeholder="Puesto ocupado"     title="Este campo debe de llenarse unicamente con letras"  required value="<%=ask.getPregunta()%>"/></td>

                                <input type="hidden" name="idfaq" id="idfaq" value="<%=ask.getId_faq()%>">
                                <td><input type="submit" class="btn btn-secondary" name="guarda" id="guarda" value=" Modificar Pregunta "></td>
                            </form>
                            <form method="post" action="ModificarFAQAnsw">
                                <input type="hidden" class="form-control" name="empresa"  id="empresa"  title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa" readonly="readonly"  required  value="<%=ask.getId_faq()%>"/>
                                <input type="hidden" name="puesto" id="puesto" class="form-control" placeholder="Puesto ocupado"   readonly="readonly"  title="Este campo debe de llenarse unicamente con letras" required value="<%=ask.getFechapregunta()%>"/>
                                <input type="hidden" name="pregunta" id="pregunta" class="form-control" placeholder="Puesto ocupado"     title="Este campo debe de llenarse unicamente con letras"  required value="<%=ask.getPregunta()%>"/>
                                <td><input type="text" name="respuesta" id="respuesta" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%=ask.getRespuesta()%>"/></td>
                                <input type="hidden" name="idfaq" id="idfaq" value="<%=ask.getId_faq()%>">
                                <td><input type="submit" class="btn btn-secondary" name="guarda" id="guarda" value=" Modificar Respuesta"></td>
                            </form>
                            <td>
                                <form method="post" action="EliminarFaq" onsubmit="return eliminar(this)">
                                    <input type="hidden" value="<% out.print(ask.getId_faq());%>" name="eliminarFaq">
                                    <input type="submit" class="btn btn-danger" name="guarda" id="guarda" value=" - ">
                                </form>
                            </td>
                            </tr>

                            <%
                                }
                            %>

                        </table>
                        <div class="col-lg-6 col-md-8 col-sm-12 pt-4">
                            <div class="form-row">
                                <table class="table"> 
                                    <thead class="thead-dark">

                                        <tr>
                                            <th scope="col">id</th>
                                            <th scope="col">Pregunta</th>
                                            <th scope='col'>Fecha</th>
                                            <th scope='col'>Aprobar</th>
                                            <th scope='col'></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            for (int i = 0; i <= numerodepreguntas - 1; i++) {
                                                faqs fasqq = PreguntasTodas.get(i);
                                        %>
                                        <tr>  
                                            <td scope="col"><p><% out.print(fasqq.getId_faq());%></p></td>
                                            <td><p><% out.print(fasqq.getPregunta());%></p></td>
                                            <td><% out.print(fasqq.getFechapregunta());%></td>
                                    <script>
                                        function eliminar(Eliminar) {
                                            if (confirm('¿Estas seguro de eliminar la FAQ?')) {
                                                document.Eliminar.submit();
                                            } else {
                                                return false;
                                            }
                                        }
                                    </script>
                                    <td><form action="FAQ/responderFaq.jsp" method="post"  name="responder">
                                            <input type="hidden" value="<% out.print(fasqq.getId_faq());%>" name="idpregun">
                                            <input type="hidden" value="<% out.print(fasqq.getPregunta());%>" name="pregunta">
                                            <input type="submit" value="Si" class="btn btn-success">
                                        </form></td>
                                    <td><form action="EliminarFaq" method="get" onsubmit="return eliminar(this)" name="Eliminar">
                                            <input type="hidden" value="<% out.print(fasqq.getId_faq());%>" name="eliminarFaq">
                                            <input type="submit" value="No" class="btn btn-success">
                                        </form></td>
                                    </tr>
                                    <%    }
                                    %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="col"></div>
                    </div>
                </div>


                <div class="tab-pane fade show active" id="ResponderTicket" role="tabpanel" aria-labbelledby="ResponderTicket-tab">
                    <table class="table">
                        <tr>		
                            <th scope="col">Tickets disponibles para contestar</th>
                        </tr>
                        <tr>
                            <td>
                                <table class="table">
                                    <tr>
                                        <th>Folio</th>
                                        <th>Modulo</th>
                                        <th>Estado</th>
                                        <th>Fecha y hora de creacion </th>
                                        <th>Tomar Ticket</th>

                                    </tr>

                                    <%for (int j = 0; j <= numerotickets - 1; j++) {
                                            Ticket Ticketss = TicketsTodos.get(j);
                                            String folio = Ticketss.getFolio();
                                            int InfoResp = Ticketss.getInformacionResponsableRevision();
                                            String Estado = Ticketss.getEstadoRevision();
                                            String FechaCreacion = Ticketss.getFechaCreacionTicket();
                                            String modulo = Ticketss.getModulo();
                                            String Descripcion = Ticketss.getDescripcionProblema();
                                            String Respuesta = Ticketss.getRespuesta();
                                    %>

                                    <tr>
                                        <td><%out.print(folio);%></td>
                                        <td><%out.print(modulo);%></td>
                                        <td><%out.print(Estado);%></td>
                                        <td><%out.print(FechaCreacion);%></td>
                                        <td><button  type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalEsco<%out.print(j);%>">Mas informacion</button></td>
                                    </tr>

                                    <div class="modal fade bd-example-modal-lg" id="ModalEsco<%out.print(j);%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">

                                        <div class="modal-dialog modal-lg" role="document">
                                            <div class="modal-content form-group">
                                                <form action="AsignarTicket" method="post">
                                                    <div class="modal-header">
                                                        <h3 class="modal-title" id="exampleModalLabel">Informacion del ticket: <%out.print(folio);%></h3>
                                                        <input type="hidden" id="folioTomado" name="folioTomado" value="<%out.print(folio);%>">
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="row">
                                                            <div class="col-xs-12  col-sm-6 col-md-6 col-lg-6">
                                                                <h5>Informacion del Ticket</h5>
                                                                <br/>
                                                                <p>Estado del ticket: <%out.print(Estado);%><br/>
                                                                    Seccion Reportada: <%out.print(modulo);%><br/>
                                                                    Fecha de creacion: <%out.print(FechaCreacion);%></p>




                                                            </div>
                                                            <div class="col-xs-12  col-sm-6 col-md-6 col-lg-6">

                                                            </div>

                                                        </div>
                                                        <div class="row">
                                                            <div>
                                                                <h5>Descripcion</h5>
                                                                <p><%out.print(Descripcion);%></p>
                                                            </div>

                                                        </div>




                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">CANCELAR</button>
                                                        <input type="submit" class="btn btn-primary" name="guarda" id="guarda" value="TOMAR TICKET">
                                                        <!--<input type="button" class="btn btn-primary" name="guarda" id="guarda" value="guarda" onclick="enviar()" />-->
                                                    </div>
                                                </form>
                                            </div>
                                        </div>

                                    </div>
                                    <%}%>
                                </table>
                            </td>
                        </tr>
                    </table>

                </div>
                <div class="tab-pane fade show active" id="Asignados" role="tabpanel" aria-labbelledby="Asignados-tab">   
                    <table class="table">
                        <tr>		
                            <th scope="col">Tickets asignados a contestar</th>
                        </tr>
                        <tr>
                            <td>
                                <table class="table">
                                    <tr>
                                        <th>Folio</th>
                                        <th>Modulo</th>
                                        <th>Estado</th>
                                        <th>Fecha y hora de creacion </th>
                                        <th>Responder ticket</th>
                                    </tr>
                                    <%for (int h = 0; h <= numeroticketsAsignados - 1; h++) {
                                            Ticket Ticketsss = TicketsTodosAsignados.get(h);
                                            String folio = Ticketsss.getFolio();
                                            int InfoResp = Ticketsss.getInformacionResponsableRevision();
                                            String Estado = Ticketsss.getEstadoRevision();
                                            String FechaCreacion = Ticketsss.getFechaCreacionTicket();
                                            String modulo = Ticketsss.getModulo();
                                            String Descripcion = Ticketsss.getDescripcionProblema();
                                            String Respuesta = Ticketsss.getRespuesta();
                                    %>

                                    <tr>
                                        <td><%out.print(folio);%></td>
                                        <td><%out.print(modulo);%></td>
                                        <td><%out.print(Estado);%></td>
                                        <td><%out.print(FechaCreacion);%></td>
                                        <td><button  type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalResponder<%out.print(h);%>">Responder Ticket</button></td>
                                    </tr>

                                    <div class="modal fade bd-example-modal-lg" id="ModalResponder<%out.print(h);%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">

                                        <div class="modal-dialog modal-lg" role="document">
                                            <div class="modal-content form-group">
                                                <form action="ResponderTicket" method="post">
                                                    <div class="modal-header">
                                                        <h3 class="modal-title" id="exampleModalLabel">Informacion del ticket: <%out.print(folio);%></h3>
                                                        <input type="hidden" id="folioTomado" name="folioTomado" value="<%out.print(folio);%>">
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="row">
                                                            <div class="col-xs-12  col-sm-6 col-md-6 col-lg-6">
                                                                <h5>Informacion del Ticket</h5>
                                                                <br/>
                                                                <p>Estado del ticket: <%out.print(Estado);%><br/>
                                                                    Seccion Reportada: <%out.print(modulo);%><br/>
                                                                    Fecha de creacion: <%out.print(FechaCreacion);%></p>
                                                            </div>
                                                            <div class="col-xs-12  col-sm-6 col-md-6 col-lg-6">

                                                            </div>

                                                        </div>
                                                        <div class="row">
                                                            <div class="col-xs-12  col-sm-12 col-md-12 col-lg-12">
                                                                <h5>Descripcion</h5>
                                                                <p><%out.print(Descripcion);%></p>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-xs-12  col-sm-12 col-md-12 col-lg-12">
                                                                <h5>Respuesta</h5>
                                                                <textarea name="RespProblema" id="RespProblema" rows="10" cols="50" placeholder="Respuesta al problema" required></textarea>
                                                            </div>

                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">CANCELAR</button>
                                                        <input type="submit" class="btn btn-primary" name="guarda" id="guarda" value="Responder Ticket">
                                                        <!--<input type="button" class="btn btn-primary" name="guarda" id="guarda" value="guarda" onclick="enviar()" />-->
                                                    </div>
                                                </form>
                                            </div>
                                        </div>

                                    </div>

                                    <%}%>
                                </table>
                            </td>
                        </tr>
                    </table>                                     
                </div>
            </div>
        </div>
        <form action="AltaFAQEditor" method="post" onsubmit="" >
            <div class="modal fade" id="ModalFAQ" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content form-group">
                        <div class="modal-header">
                            <h3 class="modal-title" id="exampleModalLabel">ALTA DE FAQ</h3>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true"></span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="input-group" style="width:100%; ">
                                <span class="input-group">Pregunta</span>
                                <textarea class="form-control" id="Pregunta" name="Pregunta" rows="3"></textarea>
                            </div>
                            <br/>
                            <p>Escribir una respuesta</p>
                            <input type="radio" class='form-control'name="Respues" value="respuestaescrita" required>
                            <div class="input-group" style="width:100%; ">
                                <span class="input-group">Respuesta</span>
                                <textarea class="form-control" id="Respuesta" name="Respuesta" rows="3"></textarea>
                            </div>
                            </input>

                            <br/>
                            <p>Seleccionar una respuesta</p>
                            <input type="radio"  class='form-control'name="Respues" value="respuestasolucion" required> 
                            <div class="input-group" style="width:100%; ">
                                <br>
                                <span class="input-group-addon">Soluciones disponibles</span>

                                <select id="IngSeleccionado" class="browser-default custom-select" name="Solucionrespu" required>
                                    <option value="0">Seleccione alguna solucion del  Ingeniero</option>
                                    <%
                                        for (int i = 0; i <= numerodereportes - 1; i++) {
                                            ReporteEvento ReportesAsignados = ReportesTodosAsignados.get(i);
                                            String Folio = ReportesAsignados.getFolio();
                                            String moduloRep = ReportesAsignados.getModuloFalla();
                                            String descripcion = ReportesAsignados.getDescripcionFalla();
                                            String estado = ReportesAsignados.getEstadoReporte();
                                            String solu = ReportesAsignados.getSolucion();

                                    %>
                                    <option class="optionHome" value="<%out.print(solu);%>"><%out.print(solu);%></option>
                                    <%}%>
                                </select>
                            </div>
                            </input>
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


        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>
        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js'></script>

    </body>
</html>

