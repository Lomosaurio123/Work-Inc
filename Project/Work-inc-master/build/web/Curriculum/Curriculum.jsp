<%-- 
    Document   : Curriculum
    Created on : 12/03/2019, 10:29:19 PM
    Author     : Hp
--%>

<%@page import="com.working.modelos.Cursos"%>
<%@page import="com.working.modelos.Habilidades"%>
<%@page import="com.working.modelos.Software"%>
<%@page import="com.working.modelos.Idioma"%>
<%@page import="com.working.modelos.Escolaridad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.working.modelos.Proyecto"%>
<%@page import="com.working.modelos.Experiencia"%>
<%@page import="java.util.List"%>
<%@page import="com.working.modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="Disegno/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="Disegno/icon/style.css">
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession();
            Usuario usuario = (Usuario) sesion.getAttribute("usuario");
            Usuario us = null;
            try {
                us = (Usuario) request.getAttribute("usuarioCon");
            } catch (Exception e) {
                System.out.println("Error curriculum: " + e.toString() + "--" + e.getMessage() + "_-" + e);
            }
        %>
        <div class="table-responsive">
            <table class="table table-bordered">
                <tr>
                    <td colspan="2">
                        <h4>Curriculum</h4>
                    </td>
                    <td>
                        <a class="btn btn-success ">Crear el PDF</a>
                    </td>
                </tr>
                <tr>
            </table>
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <tr>
                            <th scope="col">Datos personales</th>
                        </tr>
                        <tbody>
                            <tr>
                                <td scope="row">
                                    <table class="table">
                                        <tr>
                                            <td>
                                                Nombre <input type="text" name="nombre" id="nombre" class="form-control" value="<%=us.getNombre()%>"readonly="readonly"/></br> 
                                                Apellido Paterno <input type="text" name="ApelliPa" id="ApelliPa" class="form-control" value="<%=us.getApat()%>"readonly="readonly"/></br> 
                                                Apellido Materno <input type="text" name="ApelliMa" id="ApelliMa" class="form-control"value="<%=us.getAmat()%>"readonly="readonly"/></br> 
                                                Profesion <input type="text" name="edad" id="edad" class="form-control" value="<%=us.getProfesion()%>"readonly="readonly"/></br> 
                                            </td>
                                            <td>
                                                Edad <input type="text" name="edad" id="edad" class="form-control"value="<%=us.getEdad()%>"readonly="readonly"/></br> 
                                                Genero <input type="text" name="edad" id="edad" class="form-control" value="<%=us.getGenero()%>"readonly="readonly"/></br> 
                                                Telefono <input type="text" name="edad" id="edad" class="form-control" value="<%=us.getTelefono()%>"readonly="readonly"/></br> 
                                                Email <input type="text" name="edad" id="edad" class="form-control" value="<%=us.getCorreo()%>"readonly="readonly"/></br> 
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <th scope="col">Experiencia</th>
                            </tr>
                            <tr>
                                <td>
                                    <table class="table">
                                        <%
                                            List<Experiencia> TExperiencias;

                                            TExperiencias = (List<Experiencia>) request.getAttribute("experiencias");
                                            int numxp = 0;
                                            ArrayList<Experiencia> ATexperiencia = new ArrayList<Experiencia>();
                                            Experiencia exp;

                                            for (Experiencia xp : TExperiencias) {
                                                int id_xp = xp.getId_experiencia();
                                                String empresa = xp.getEmpresa();
                                                String puesto = xp.getPuesto();
                                                String funcion = xp.getFuncion();
                                                String inicio = xp.getInicio();
                                                String fin = xp.getFin();
                                                exp = new Experiencia(id_xp, puesto, empresa, funcion, inicio, fin);
                                                ATexperiencia.add(exp);
                                                numxp = numxp + 1;
                                            }
                                        %>
                                        <tr>
                                            <th>Empresa</th>
                                            <th>puesto</th>
                                            <th>funcion</th>
                                            <th>inicio</th>
                                            <th>fin</th>
                                            <th><button  type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalXP">   +   </button></th>

                                        </tr>

                                        <%
                                            
                                            for (int i = 0; i <= numxp - 1; i++) {
                                                Experiencia XPdesp = ATexperiencia.get(i);

                                        %> 


                                        <tr>
                                        <form method="post" action="ModificaXPservlet">
                                            <td><input type="text" class="form-control" name="empresa"  id="empresa"  title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa"   required  value="<%=XPdesp.getEmpresa()%>"/></td>
                                            <td><input type="text" name="puesto" id="puesto" class="form-control" placeholder="Puesto ocupado"     title="Este campo debe de llenarse unicamente con letras" required value="<%=XPdesp.getPuesto()%>"/></td>
                                            <td><input type="text" name="funcion" id="funcion" class="form-control" placeholder="Puesto ocupado"     title="Este campo debe de llenarse unicamente con letras"  required value="<%=XPdesp.getFuncion()%>"/></td>
                                            <td><input type="date" name="inicio" id="inicio" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%=XPdesp.getInicio()%>"/></td>
                                            <td><input type="date" name="fin" id="fin" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%=XPdesp.getFin()%>"/></td>
                                            <input type="hidden" name="idxp" id="idxp" value="<%=XPdesp.getId_experiencia()%>">
                                            <input type="hidden" name="correo" id="correo" value="<%=usuario.getCorreo()%>">
                                            <td><input type="submit" class="btn btn-secondary" name="guarda" id="guarda" value=" Modificar "></td>
                                        </form>
                                        <td>
                                            <form method="post" action="EliminarXPservlet">
                                                <input type="hidden" name="idxp" id="idxp" value="<%=XPdesp.getId_experiencia()%>">
                                                <input type="submit" class="btn btn-danger" name="guarda" id="guarda" value=" - ">
                                            </form>
                                        </td>
                            </tr>

                            <%
                                }
                            %>
                    </table>
                    </td>
                    </tr>
                    <tr>
                        <th>idiomas</th>
                    </tr>
                    <tr>
                        <td>
                            <table class="table">
                                <%
                                    List<Idioma> TIdioma;

                                    TIdioma = (List<Idioma>) request.getAttribute("idiomas");
                                    int numidi = 0;
                                    ArrayList<Idioma> ATIdioma = new ArrayList<Idioma>();
                                    Idioma idi;

                                    for (Idioma xp : TIdioma) {
                                        int id_idio = xp.getId_idioma();
                                        String idioma = xp.getIdioma();
                                        String habla = xp.getNivelhabla();
                                        String escrito = xp.getNivelescrito();
                                        String escucha = xp.getNivelescucha();
                                        String certificado = xp.getCertificado();
                                        idi = new Idioma(id_idio, idioma, habla, escrito, escucha, certificado);
                                        ATIdioma.add(idi);
                                        numidi = numidi + 1;
                                    }
                                %>
                                <tr>
                                    <th>idioma</th>
                                    <th>nivel de habla</th>
                                    <th>nivel escrito</th>
                                    <th>nivel de </br>entendimineto</th>
                                    <th>certicado</th>
                                    <th><button  type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalIdioma">   +   </button></th>
                                </tr>
                                <%
                                    for (int i = 0; i <= numidi - 1; i++) {
                                        Idioma XPdesp = ATIdioma.get(i);

                                %> 
                                <tr>
                                <form method="post" action="ModificaIdiomaservlet">
                                    <td><input type="text" class="form-control" name="idioma"  id="idioma"  title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa"   required  value="<%=XPdesp.getIdioma()%>"/></td>
                                    <td><input type="text" name="habla" id="habla" class="form-control" placeholder="Puesto ocupado"     title="Este campo debe de llenarse unicamente con letras" required value="<%=XPdesp.getNivelhabla()%>"/></td>
                                    <td><input type="text" name="escrito" id="escrito" class="form-control" placeholder="Puesto ocupado"     title="Este campo debe de llenarse unicamente con letras"  required value="<%=XPdesp.getNivelescrito()%>"/></td>
                                    <td><input type="text" name="escuchado" id="escuchado" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%=XPdesp.getNivelescucha()%>"/></td>
                                    <td><input type="text" name="certificado" id="certificado" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%=XPdesp.getCertificado()%>"/></td>
                                    <input type="hidden" name="id_idi" id="id_idi" value="<%=XPdesp.getId_idioma()%>">
                                    <input type="hidden" name="correo" id="correo" value="<%=usuario.getCorreo()%>">
                                    <td><input type="submit" class="btn btn-secondary" name="guarda" id="guarda" value=" Modificar "></td>
                                </form>
                                <td>
                                    <form method="post" action="EliminarIdiomaservlet">
                                        <input type="hidden" name="ididioma" id="ididioma" value="<%=XPdesp.getId_idioma()%>">
                                        <input type="submit" class="btn btn-danger" name="guarda" id="guarda" value=" - ">
                                    </form>
                                </td>
                    </tr>

                    <%
                        }
                    %>

            </table>
        </td>
    </tr>
    <tr>
        <th>Habilidades</th>
    </tr>
    <tr>
        <td>
            <table class="table">
                <%
                                            List<Habilidades> THabilidades;

                                            THabilidades = (List<Habilidades>) request.getAttribute("habilidades");
                                            int numhab= 0;
                                            ArrayList<Habilidades> ATHabilidades = new ArrayList<Habilidades>();
                                            Habilidades habi;

                                            for (Habilidades hab : THabilidades) {
                                                int id_hab = hab.getId_habilidad();
                                                String habilidad = hab.getHabilidad();
                                                habi = new Habilidades(id_hab, habilidad);
                                                ATHabilidades.add(habi);
                                                numhab = numhab + 1;
                                            }
                                        %>
                <tr>
                    <th>habilidad</th>
                    <th><button  type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalHab">   +   </button></th>
                </tr>
                    <%
                                    for (int i = 0; i <= numhab - 1; i++) {
                                        Habilidades Habdesp = ATHabilidades.get(i);

                                %> 
                                <tr>
                                <form method="post" action="ModificaHabServlet">
                                    <td><input type="text" class="form-control" name="Habilidad"  id="Habilidad"  title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa"   required  value="<%=Habdesp.getHabilidad()%>"/></td>
                                    <input type="hidden" name="id_hab" id="id_hab" value="<%=Habdesp.getId_habilidad()%>">
                                    <input type="hidden" name="correo" id="correo" value="<%=usuario.getCorreo()%>">
                                    <td><input type="submit" class="btn btn-secondary" name="guarda" id="guarda" value=" Modificar "></td>
                                </form>
                                <td>
                                    <form method="post" action="EliminarHabServlet">
                                        <input type="hidden" name="id_hab" id="id_hab" value="<%=Habdesp.getId_habilidad()%>">
                                        <input type="submit" class="btn btn-danger" name="guarda" id="guarda" value=" - ">
                                    </form>
                                </td>
                </tr>
                <%
                        }
                    %>
            </table>
        </td>
    </tr>
    
</tbody>
</table>
</div>  

<div class="table-responsive">
    <table class="table">
        <tr>
            <th scope="col">Foto </th>
        </tr>
        <tr>
            <td scope="row">
                <input class="btn-success" accept="image/*" type="file" name="imagen" id="imagen" onchange="prevista(imagen)"><br/>
            </td>
        </tr>
        <tr>		
            <th scope="col">Estudios </th>
        </tr>
        <tr>
            <td>
                <table class="table">
                    <%
                        List<Escolaridad> TEscolaridad;
                        TEscolaridad = (List<Escolaridad>) request.getAttribute("escolaridad");
                        int numesco = 0;
                        ArrayList<Escolaridad> ATesco = new ArrayList<Escolaridad>();
                        Escolaridad esco;

                        for (Escolaridad escola : TEscolaridad) {
                            int id_esco = escola.getId_escolaridad();
                            String escuela = escola.getEscuela();
                            String carrera = escola.getCarrera();
                            String inicio = escola.getInicio();
                            String fin = escola.getFin();
                            esco = new Escolaridad(id_esco, escuela, carrera, inicio, fin);
                            ATesco.add(esco);
                            numesco = numesco + 1;
                        }
                    %>
                    <tr>
                        <th>Escuela</th>
                        <th>Carrera</th>
                        <th>Inicio</th>
                        <th>fin</th>
                        <th><button  type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalEsco">   +   </button></th>

                    </tr>
                    <%
                        for (int i = 0; i <= numesco - 1; i++) {
                            Escolaridad ESdesp = ATesco.get(i);

                    %> 
                    <form method="post" action="ModificaEscoservlet">
                        <tr>
                            <td><input type="text" class="form-control" name="escuela"  id="escuela"  title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la escuela"  required  value="<%=ESdesp.getEscuela()%>"/></td>
                            <td><input type="text" name="carrera" id="carrera" class="form-control" placeholder="carrera cursada"    title="Este campo debe de llenarse unicamente con letras"  required value="<%=ESdesp.getCarrera()%>"/></td>
                            <td><input type="date" name="inicio" id="inicio" class="form-control"  placeholder="fecha de inicio" title="Este campo debe de llenarse unicamente con letras"  required value="<%=ESdesp.getInicio()%>"/></td>
                            <td><input type="date" name="fin" id="fin" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%=ESdesp.getFin()%>"/></td>
                        <input type="hidden" name="idEs" id="idEs" value="<%=ESdesp.getId_escolaridad()%>">
                        <input type="hidden" name="correo" id="correo" value="<%=usuario.getCorreo()%>">
                        <td><input type="submit" class="btn btn-secondary" name="guarda" id="guarda" value=" Modificar "></td>
                        <td>
                    </form>
                    <form method="post" action="EliminarEscoservlet">
                        <input type="hidden" name="idEsc" id="idEsc" value="<%=ESdesp.getId_escolaridad()%>">
                        <input type="submit" class="btn btn-danger" name="guarda" id="guarda" value=" - ">
                    </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</td>
</tr>
<tr>		
    <th>Programas o softwares</th>
</tr>
<tr>
    <td>
        <table class="table">
            <%
                List<Software> TSoftware;

                TSoftware = (List<Software>) request.getAttribute("softwares");
                int numsftw = 0;
                ArrayList<Software> ATSoftware = new ArrayList<Software>();
                Software sf;

                for (Software sftw : TSoftware) {
                    int id_software = sftw.getId_software();
                    String softw = sftw.getSoftware();
                    String año = sftw.getAño();
                    String constancia = sftw.getConstancia();
                    sf = new Software(id_software, softw, año, constancia);
                    ATSoftware.add(sf);
                    numsftw = numsftw + 1;
                }
            %>
            <tr>
                <th>software</th>
                <th>año</th>
                <th>constancia</th>
                <th><button  type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalSoft">   +   </button></th>

            </tr>
            <%
                        for (int i = 0; i <= numsftw - 1; i++) {
                            Software softw = ATSoftware.get(i);

                    %> 
                    <form method="post" action="ModificaSoftServlet">
                        <tr>
                            <td><input type="text" class="form-control" name="software"  id="software"  title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa"  required  value="<%=softw.getSoftware()%>"/></td>
                            <td><input type="text" name="Ano" id="Ano" class="form-control" placeholder="Puesto ocupado"     title="Este campo debe de llenarse unicamente con letras"  required value="<%=softw.getAño()%>"/></td>
                            <td><input type="text" name="constancia" id="constancia" class="form-control"  placeholder="Fecha de terminacion" title="Este campo debe de llenarse unicamente con letras"  required value="<%=softw.getConstancia()%>"/></td>
                        <input type="hidden" name="idSoft" id="idSoft" value="<%=softw.getId_software()%>">
                        <input type="hidden" name="correo" id="correo" value="<%=usuario.getCorreo()%>">
                        <td><input type="submit" class="btn btn-secondary" name="guarda" id="guarda" value=" Modificar "></td>
                        </form>
                        <td>
                        <form method="post" action="EliminarSoftServlet">
                            <input type="hidden" name="idSoft" id="idSoft" value="<%=softw.getId_software()%>">
                            <input type="submit" class="btn btn-danger" name="guarda" id="guarda" value=" - ">
                        </form>
                        </td>
        </tr>
        <%
            }
        %>
        </table>
    </td>
</tr>
<tr>		
    <th>Cursos</th>
</tr>
<tr>
    <td>
        <table class="table">
            <%
                List<Cursos> TCursos;

                TCursos = (List<Cursos>) request.getAttribute("Cursos");
                int numcur= 0;
                ArrayList<Cursos> ATCursos = new ArrayList<Cursos>();
                Cursos curso;

                for (Cursos cur : TCursos) {
                    int id_cursos = cur.getId_cursos();
                    String nombre_curso = cur.getNombre_curso();
                    String año = cur.getAño();
                    int duracion = cur.getDuracion();
                    curso = new Cursos(id_cursos, nombre_curso, año, duracion);
                    ATCursos.add(curso);
                    numcur = numcur + 1;
                }
            %>
            <tr>
                <th>Nombre</th>
                <th>año</th>
                <th>duracion</th>
                <th><button  type="button" class="btn btn-primary" data-toggle="modal" data-target="#ModalCurso">   +   </button></th>

            </tr>
                <%
                        for (int i = 0; i <= numcur - 1; i++) {
                            Cursos curs = ATCursos.get(i);

                    %> 
                    <form method="post" action="ModificaCursoServlet">
                        <tr>
                            <td><input type="text" class="form-control" name="nomcurso"  id="software"  title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa"  required  value="<%=curs.getNombre_curso()%>"/></td>
                            <td><input type="text" name="Ano" id="Ano" class="form-control" placeholder="Puesto ocupado"     title="Este campo debe de llenarse unicamente con letras"  required value="<%=curs.getAño()%>"/></td>
                            <td><input type="number" name="duracion" id="duracion" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required value="<%=curs.getDuracion()%>"/></td>
                        <input type="hidden" name="idCurso" id="idCurso" value="<%=curs.getId_cursos()%>">
                        <input type="hidden" name="correo" id="correo" value="<%=usuario.getCorreo()%>">
                        <td><input type="submit" class="btn btn-secondary" name="guarda" id="guarda" value=" Modificar "></td>
                        </form>
                        <td>
                        <form method="post" action="EliminarCursoServlet">
                            <input type="hidden" name="idCurso" id="idCurso" value="<%=curs.getId_cursos()%>">
                            <input type="submit" class="btn btn-danger" name="guarda" id="guarda" value=" - ">
                        </form>
                        </td>
        </tr>
        <%
            }
        %>
        </table>
    </td>
</tr>
</table>
</div>
</tr>
</table>
</div> 

<form action="AltaXPservlet" method="post" onsubmit=" " >
    <div class="modal fade" id="ModalXP" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">

            <div class="modal-content form-group">
                <div class="modal-header">
                    <h3 class="modal-title" id="exampleModalLabel">REGISTRO DE EXPERIENCIA</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="input-group" style="width:60%; ">
                        <span class="input-group-addon">Empresa</span>
                        <input type="text" class="form-control" name="empresa"  id="empresa" title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa"   required />
                    </div>
                    <br/>
                    <div class="input-group" style="width:60%; ">
                        <span class="input-group-addon">Puesto</span>
                        <input type="text" name="puesto" id="puesto" class="form-control" placeholder="Puesto ocupado"   title="Este campo debe de llenarse unicamente con letras" required />
                    </div>
                    <br/>
                    <div class="input-group" style="width:60%; " >
                        <span class="input-group-addon">Funcion</span>
                        <input type="text" name="funcion" id="funcion" class="form-control"  placeholder="que activiades realizaba" title="Este campo debe de llenarse unicamente con letras"  required />
                    </div>
                    <br/>
                    <div class="input-group" style="width:40%; " >
                        <span class="input-group-addon">inicio</span>
                        <input type="date" name="inicio" id="inicio" class="form-control"  placeholder="Fecha de inicio" title="Este campo debe de llenarse unicamente con letras"  required />
                    </div>
                    <br/>
                    <div class="input-group" style="width:40%; " >
                        <span class="input-group-addon">fin</span>
                        <input type="date" name="fin" id="fin" class="form-control"  placeholder="Fecha de terminacion" pattern="[A-Za-z]{1,20}" title="Este campo debe de llenarse unicamente con letras"  required />
                        <input type="hidden" name="correo" id="correo" value="<%=us.getCorreo()%>">
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
<form action="AltaEscoservlet" method="post" onsubmit=" " >
    <div class="modal fade" id="ModalEsco" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content form-group">
                <div class="modal-header">
                    <h3 class="modal-title" id="exampleModalLabel">REGISTRO DE ESCOLARIDAD</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="input-group" style="width:60%; ">
                        <span class="input-group-addon">Escuela</span>
                        <input type="text" class="form-control" name="escuela"  id="escuela"  title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la escuela"   required />
                    </div>
                    <br/>
                    <div class="input-group" style="width:60%; ">
                        <span class="input-group-addon">Carrera</span>
                        <input type="text" name="carrera" id="carrera" class="form-control" placeholder="carrera terminada"   title="Este campo debe de llenarse unicamente con letras"  required />
                    </div>
                    <br/>
                    <div class="input-group" style="width:40%; " >
                        <span class="input-group-addon">inicio</span>
                        <input type="date" name="inicio" id="inicio" class="form-control"  placeholder="Fecha de inicio" pattern="[A-Za-z]{1,20}" title="Este campo debe de llenarse unicamente con letras"  required />
                    </div>
                    <br/>
                    <div class="input-group" style="width:40%; " >
                        <span class="input-group-addon">fin</span>
                        <input type="date" name="fin" id="fin" class="form-control"  placeholder="Fecha de terminacion" pattern="[A-Za-z]{1,20}" title="Este campo debe de llenarse unicamente con letras"  required />
                        <input type="hidden" name="correo" id="correo" value="<%=us.getCorreo()%>">
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
<form action="AltaIdiomaservlet" method="post" onsubmit=" " >
    <div class="modal fade" id="ModalIdioma" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content form-group">
                <div class="modal-header">
                    <h3 class="modal-title" id="exampleModalLabel">REGISTRO DE IDIOMA</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="input-group" style="width:60%; ">
                        <span class="input-group-addon">Idioma</span>
                        <input type="text" class="form-control" name="Idioma"  id="Idioma"  title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa" required />
                    </div>
                    <br/>
                    <div class="input-group" style="width:60%; ">
                        <span class="input-group-addon">nivel de habla</span>
                        <input type="text" name="nivelhabla" id="nivelhabla" class="form-control" placeholder="Puesto ocupado"    title="Este campo debe de llenarse unicamente con letras"  required />
                    </div>
                    <br/>
                    <div class="input-group" style="width:80%; " >
                        <span class="input-group-addon">nivelescrito</span>
                        <input type="text" name="nivelescrito" id="nivelescrito" class="form-control"  placeholder="Fecha de inicio"  title="Este campo debe de llenarse unicamente con letras"  required />
                    </div>
                    <br/>
                    <div class="input-group" style="width:80%; " >
                        <span class="input-group-addon">nivel de entendimiento</span>
                        <input type="text" name="nivelescucha" id="nivelescucha" class="form-control"  placeholder="Fecha de terminacion" title="Este campo debe de llenarse unicamente con letras"  required />
                        <input type="hidden" name="correo" id="correo" value="<%=us.getCorreo()%>">
                    </div>
                    <br/>
                    <div class="input-group" style="width:80%; " >
                        <span class="input-group-addon">Certificado</span>
                        <input type="text" name="Certificado" id="Certificado" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required />
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
<form action="AltaIdiomaservlet" method="post" onsubmit=" " >
    <div class="modal fade" id="ModalIdioma" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content form-group">
                <div class="modal-header">
                    <h3 class="modal-title" id="exampleModalLabel">REGISTRO DE ESCOLARIDAD</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="input-group" style="width:60%; ">
                        <span class="input-group-addon">Idioma</span>
                        <input type="text" class="form-control" name="Idioma"  id="Idioma" pattern="[A-Za-z]{1,20}" title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa" required />
                    </div>
                    <br/>
                    <div class="input-group" style="width:60%; ">
                        <span class="input-group-addon">nivel de habla</span>
                        <input type="text" name="nivelhabla" id="nivelhabla" class="form-control" placeholder="Puesto ocupado"     title="Este campo debe de llenarse unicamente con letras"  required />
                    </div>
                    <br/>
                    <div class="input-group" style="width:80%; " >
                        <span class="input-group-addon">nivelescrito</span>
                        <input type="text" name="nivelescrito" id="nivelescrito" class="form-control"  placeholder="Fecha de inicio" title="Este campo debe de llenarse unicamente con letras"  required />
                    </div>
                    <br/>
                    <div class="input-group" style="width:80%; " >
                        <span class="input-group-addon">nivel de entendimiento</span>
                        <input type="text" name="nivelescucha" id="nivelescucha" class="form-control"  placeholder="Fecha de terminacion"  title="Este campo debe de llenarse unicamente con letras"  required />
                        <input type="hidden" name="correo" id="correo" value="<%=us.getCorreo()%>">
                    </div>
                    <br/>
                    <div class="input-group" style="width:80%; " >
                        <span class="input-group-addon">Certificado</span>
                        <input type="text" name="Certificado" id="Certificado" class="form-control"  placeholder="Fecha de terminacion" title="Este campo debe de llenarse unicamente con letras"  required />
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
<form action="AltaHabServlet" method="post" onsubmit=" " >
    <div class="modal fade" id="ModalHab" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content form-group">
                <div class="modal-header">
                    <h3 class="modal-title" id="exampleModalLabel">REGISTRO DE HABILIDAD</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="input-group" style="width:60%; ">
                        <span class="input-group-addon">Habilidad</span>
                        <input type="text" class="form-control" name="Habilidad"  id="Habilidad" title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa" required />
                        <input type="hidden" name="correo" id="correo" value="<%=us.getCorreo()%>">
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
<form action="AltaSoftwareServlet" method="post" onsubmit=" " >
    <div class="modal fade" id="ModalSoft" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content form-group">
                <div class="modal-header">
                    <h3 class="modal-title" id="exampleModalLabel">REGISTRO DE HABILIDAD</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="input-group" style="width:60%; ">
                        <span class="input-group-addon">Software</span>
                        <input type="text" class="form-control" name="software"  id="software"  title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa" required />
                        <input type="hidden" name="correo" id="correo" value="<%=us.getCorreo()%>">
                    </div>
                    <br/>
                    <div class="input-group" style="width:80%; " >
                        <span class="input-group-addon">Año</span>
                        <input type="number" name="Ano" id="Ano" class="form-control"  placeholder="Fecha de terminacion" title="Este campo debe de llenarse unicamente con letras"  required />
                    </div>
                    <br/>
                    <div class="input-group" style="width:80%; " >
                        <span class="input-group-addon">Constancia</span>
                        <input type="text" name="constancia" id="constancia" class="form-control"  placeholder="Fecha de terminacion" title="Este campo debe de llenarse unicamente con letras"  required />
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
<form action="AltaCursoServlet" method="post" onsubmit=" " >
    <div class="modal fade" id="ModalCurso" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content form-group">
                <div class="modal-header">
                    <h3 class="modal-title" id="exampleModalLabel">REGISTRO DE CURSOS</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="input-group" style="width:60%; ">
                        <span class="input-group-addon">Nombre del Curso</span>
                        <input type="text" class="form-control" name="nomcurso"  id="nomcurso" title="Este campo debe de llenarse unicamente con letras" placeholder="Nombre de la empresa" required />
                    </div>
                    <br/>
                    <div class="input-group" style="width:60%; ">
                        <span class="input-group-addon">Año</span>
                        <input type="number" name="Ano" id="Ano" class="form-control" placeholder="Año"    pattern="[0-9]{1,20}" title="Este campo debe de llenarse unicamente con letras"  required />
                    </div>
                    <br/>
                    <div class="input-group" style="width:80%; " >
                        <span class="input-group-addon">Duracion</span>
                        <input type="number" name="duracion" id="duracion" class="form-control"  placeholder="Fecha de inicio" pattern="[0-9]{1,20}" title="Este campo debe de llenarse unicamente con letras"  required />
                        <input type="hidden" name="correo" id="correo" value="<%=us.getCorreo()%>">
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
</body>
<script>
    function selXp(idxp) {

        $('#id_xp').val(idxp);
    }
    function archivo(evt) {
        var files = evt.target.files; // FileList object

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

<script src="Disegno/js/jquery.js"></script>
<script src="Disegno/js/bootstrap.js"></script>
</html>
