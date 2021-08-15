package org.apache.jsp.Proyectos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.working.modelos.TareaProyecto;
import com.working.modelos.ProfesionistaRequerido;
import java.util.ArrayList;
import java.util.List;
import com.working.modelos.Usuario;
import java.util.Base64;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import com.working.modelos.Proyecto;

public final class ModificarProyectos_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/png\" href=\"RecursosGraficos/Imagenes/ha.png\"/>\n");
      out.write("        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>\n");
      out.write("\n");
      out.write("        <title>Modificar Proyecto</title>\n");
      out.write("        ");

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

        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid mt-4\">\n");
      out.write("            <ul class=\"nav nav-tabs\" id=\"myTab\" role=\"tablist\">\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link active\" id=\"profile-tab\" data-toggle=\"tab\" href=\"#profile\" role=\"tab\" aria-controls=\"profile\" aria-selected=\"true\"> Actualizar Proyecto </a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" id=\"notify-tab\" data-toggle=\"tab\" href=\"#notify\" role=\"tab\" aria-controls=\"notify\" aria-selected=\"true\"> Administrar Proyecto </a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" id=\"chat-tab\" data-toggle=\"tab\" href=\"#chat\" role=\"tab\" aria-controls=\"chat\" aria-selected=\"true\">Chat</a>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("            <div class=\"tab-content\" id=\"myTabContent\">\n");
      out.write("\n");
      out.write("                <div class=\"tab-pane fade show active\" id=\"profile\" role=\"tabpanel\" aria-labbelledby=\"profile-tab\">\n");
      out.write("                    <div class=\"table-responsive\">\n");
      out.write("                        <table class=\"table table-bordered\">\n");
      out.write("                   <form action=\"ModificarDatosProyecto\" method=\"Post\" enctype=\"multipart/form-data\">\n");
      out.write("                       <tr>\n");
      out.write("                           <td scope=\"row\" >\n");
      out.write("                               <h4>Nombre de proyecto</h4>\n");
      out.write("                           </td>\n");
      out.write("                           <td>\n");
      out.write("                        \n");
      out.write("                        <input type=\"text\" class=\"form-control\"   value=\"");
out.print(TituloProyecto);
      out.write("\" id =\"TituloProyectoo\" name=\"TituloProyectoo\">\n");
      out.write("                           </td>\n");
      out.write("                        \n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td scope=\"row\" >\n");
      out.write("                               <h4>Idea del proyecto</h4>\n");
      out.write("                           </td>\n");
      out.write("                            <td>\n");
      out.write("                                \n");
      out.write("                        <input type=\"text\" class=\"form-control\" value=\"");
out.print(IdeaProyecto);
      out.write("\" id =\"IdeaProyectoo\" name=\"IdeaProyectoo\">\n");
      out.write("                                \n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td scope=\"row\" >\n");
      out.write("                               <h4>Categoria</h4>\n");
      out.write("                           </td>\n");
      out.write("                            <td>\n");
      out.write("                        <input type=\"text\"  class=\"form-control\"value=\"");
out.print(CategoriaProyecto);
      out.write("\" id =\"CategoriaProyectoo\" name=\"CategoriaProyectoo\">\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td scope=\"row\" >\n");
      out.write("                               <h4>Monto estimado</h4>\n");
      out.write("                           </td>\n");
      out.write("                            <td>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" value=\"");
out.print(MontoProyecto);
      out.write("\" id =\"MontoProyectoo\" name=\"MontoProyectoo\">\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td scope=\"row\" >\n");
      out.write("                               <h4>Fotografia del proyecto</h4>\n");
      out.write("                           </td>\n");
      out.write("                           <td>\n");
      out.write("                                <input  class=\"btn btn-primary \" role=\"button\"  accept=\"image/*\" type=\"file\" name=\"imagen\" id=\"imagen\" onchange=\"prevista(imagen)\"><br/>\n");
      out.write("                           </td>\n");
      out.write("                        <input type=\"hidden\"class=\"form-control\" value=\"");
out.print(informacion);
      out.write("\" id=\"informacioon\" name=\"informacioon\">\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        ");


                            for (int i = 0; i <= NumeroPuestosReq - 1; i++) {
                                ProfesionistaRequerido puestos = TodosPuestosReq.get(i);
                                String puesto = puestos.getNombreProfesion();
                                String Status = puestos.getStatusPuesto();
                        
      out.write("\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <h4>Profesionista necesitado</h4>\n");
      out.write("                           </td>\n");
      out.write("                           <td>\n");
      out.write("                               <div class=\"input-group\" style=\"width:50%; \">\n");
      out.write("                            <input type=\"text\" class=\"form-control\" value=\"");
out.print(puesto);
      out.write("\" readonly=\"readonly\">\n");
      out.write("                               </div>\n");
      out.write("                               <div class=\"input-group\" style=\"width:50%; \">\n");
      out.write("                               <input type=\"text\"class=\"form-control\" value=\"");
out.print(Status);
      out.write("\"readonly=\"readonly\">\n");
      out.write("                               </div>\n");
      out.write("                            </td>\n");
      out.write("                            \n");
      out.write("                        </tr>\n");
      out.write("                        \n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-primary\"value=\"Modificar Datos\">\n");
      out.write("                            </td>\n");
      out.write("                            <td>\n");
      out.write("                        ");

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
                        
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        </table>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                    <script>\n");
      out.write("                        function archivo(evt) {\n");
      out.write("                            var files = evt.target.files;\n");
      out.write("                            // Obtenemos la imagen del campo \"file\".\n");
      out.write("                            for (var i = 0, f; f = files[i]; i++) {\n");
      out.write("                                //Solo admitimos imágenes.\n");
      out.write("                                if (!f.type.match('image.*')) {\n");
      out.write("                                    continue;\n");
      out.write("                                }\n");
      out.write("                                var reader = new FileReader();\n");
      out.write("                                reader.onload = (function (theFile) {\n");
      out.write("                                    return function (e) {\n");
      out.write("                                        // Insertamos la imagen\n");
      out.write("                                        document.getElementById(\"list\").innerHTML = ['<img class=\"thumbnail  img-responsive\" src=\"', e.target.result, '\" title=\"', escape(theFile.name), '\" style=\" width:80%\"/>'].join('');\n");
      out.write("                                    };\n");
      out.write("                                })(f);\n");
      out.write("                                reader.readAsDataURL(f);\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                        document.getElementById('imagen').addEventListener('change', archivo, false);\n");
      out.write("                    </script>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"tab-pane fade\" id=\"notify\" role=\"tabpanel\" aria-labelledby=\"notify-tab\">\n");
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <br/>\n");
      out.write("                        <br/>\n");
      out.write("                        <br/>\n");
      out.write("                        <div class=\"col-lg-12 col-md-12 col-sm-12 \">\n");
      out.write("                            <h4>Solicitudes de Usuarios</h4>\n");
      out.write("                            \n");
      out.write("\n");
      out.write("                            <Label for=\"Informacion\">\n");
      out.write("                                Selecciona a los usuarios que cres que puedan aportar valor a tu proyecto, tendras la opcion de ver su curriculo.\n");
      out.write("                            </Label>\n");
      out.write("                            <hr/>\n");
      out.write("                            \n");
      out.write("                            ");
                           for (int i = 0; i <= NumeroDeUsuarios - 1; i++) {
                            
      out.write("\n");
      out.write("\n");
      out.write("                            ");

                                Usuario SolicitudesUsuariosUnion = UsuariosTodos.get(i);
                                String NombreUsua = SolicitudesUsuariosUnion.getNombre();
                                String ApellidoPatUsu = SolicitudesUsuariosUnion.getApat();
                                String ApellidoMatUsu = SolicitudesUsuariosUnion.getAmat();
                                String CorreoUsua = SolicitudesUsuariosUnion.getCorreo();
                                String ProfesionUsua = SolicitudesUsuariosUnion.getProfesion();

                            
      out.write("\n");
      out.write("                            <div> \n");
      out.write("\n");
      out.write("\n");
      out.write("                                \n");
      out.write("                                 <table class=\"table\">\n");
      out.write("  <thead>\n");
      out.write("    <tr>\n");
      out.write("      <th scope=\"col\">#</th>\n");
      out.write("      <th scope=\"col\">Nombre</th>\n");
      out.write("      <th scope=\"col\">Profesion</th>\n");
      out.write("      <th scope=\"col\">Correo</th>\n");
      out.write("      <th scope=\"col\">Puesto</th>\n");
      out.write("      <th scope=\"col\">Curriculum</th>\n");
      out.write("      <th scope=\"col\">Accion</th>\n");
      out.write("      \n");
      out.write("      \n");
      out.write("    </tr>\n");
      out.write("  </thead>\n");
      out.write("  <tbody>\n");
      out.write("    <tr>\n");
      out.write("      <th scope=\"row\">");
out.print(i+1);
      out.write("</th>\n");
      out.write("      <td>");
out.print(NombreUsua +" "+ ApellidoPatUsu +" "+ ApellidoMatUsu); 
      out.write("</td>\n");
      out.write("      <td>");
out.print(ProfesionUsua);
      out.write("</td>\n");
      out.write("      <td>");
out.print(CorreoUsua);
      out.write("</td>\n");
      out.write("      <td>\n");
      out.write("                                \n");
      out.write("\n");
      out.write("\n");
      out.write("                                <form action=\"ProcesesamientoSolicitud\" method=\"post\"> \n");
      out.write("\n");
      out.write("                                    <select id=\"PuestoSeleccionado\" name=\"PuestoSeleccionado\">\n");
      out.write("                                        <option value=\"0\">Seleccione algun Puesto</option>\n");
      out.write("                                        ");


                                            for (int j = 0; j <= NumeroPuestosReq - 1; j++) {
                                                ProfesionistaRequerido puestos = TodosPuestosReq.get(j);
                                                String puesto = puestos.getNombreProfesion();
                                                String Status = puestos.getStatusPuesto();
                                        
      out.write("\n");
      out.write("\n");
      out.write("                                        ");
if (Status.equals("Disponible")) {
      out.write("\n");
      out.write("                                        <option class=\"optionHome\" value=\"");
out.print(puesto);
      out.write('"');
      out.write('>');
out.print(puesto);
      out.write("</option>\n");
      out.write("                                        ");

                                            }
                                        
      out.write("\n");
      out.write("                                        ");

                                            }
                                        
      out.write("\n");
      out.write("\n");
      out.write("                                    </select>\n");
      out.write("\n");
      out.write("</td>\n");
      out.write("<td>\n");
      out.write("    <form action=\"GeneraCurriculum\" method=\"post\">\n");
      out.write("    \n");
      out.write("    <input type=\"submit\" value=\"Curriculum\" class=\"btn btn-link\">\n");
      out.write("    </form>\n");
      out.write("</td>\n");
      out.write("      <td>\n");
      out.write("            <input type=\"hidden\" value=\"");
out.print(informacion);
      out.write("\" id=\"infoproject\" name=\"infoproject\">\n");
      out.write("                                    <input type=\"hidden\" value=\"");
out.print(CorreoUsua);
      out.write("\" id=\"correo\" name=\"correo\">\n");
      out.write("                                    <input type=\"submit\" value=\"Aceptar\" id=\"acciona\" name=\"acciona\" class=\"btn btn-success\">\n");
      out.write("                                </form>\n");
      out.write("                                    <form action=\"RechazarSolicitudUnion\" method=\"post\">\n");
      out.write("                                    <input type=\"hidden\" value=\"");
out.print(informacion);
      out.write("\" id=\"infoproject\" name=\"infoproject\">\n");
      out.write("                                    <input type=\"hidden\" value=\"");
out.print(CorreoUsua);
      out.write("\" id=\"correo\" name=\"correo\">\n");
      out.write("                                    <input type=\"submit\" value=\"Rechazar\" id=\"accionb\" name=\"accionb\" class=\"btn btn-danger\"> \n");
      out.write("                                </form>\n");
      out.write("          \n");
      out.write("          \n");
      out.write("          \n");
      out.write("      </td>\n");
      out.write("      \n");
      out.write("    \n");
      out.write("    </tr>\n");
      out.write("  </tbody>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                  \n");
      out.write("\n");
      out.write("                                \n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <br/>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("\n");
      out.write("                        <div class=\"col-lg-12 col-md-12 col-sm-12 \">\n");
      out.write("                            <h4>Administracion de tareas</h4>\n");
      out.write("                            <Label for=\"Informacion\">\n");
      out.write("                                Registra las tareas Indispensables para tu proyecto y ponte a trabajar.\n");
      out.write("                            </Label>\n");
      out.write("                            <hr />\n");
      out.write("\n");
      out.write("                            <table class=\"table table-bordered\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td colspan=\"2\">\n");
      out.write("                                        <h4>Tareas a Realizar</h4>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        <div class=\"table-responsive\">\n");
      out.write("                                            <table class=\"table table-bordered\">\n");
      out.write("\n");
      out.write("                                                <tbody>\n");
      out.write("\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <th scope=\"col\">Asignacion de tarea</th>\n");
      out.write("                                                    </tr>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <td>\n");
      out.write("                                                            <table class=\"table\">\n");
      out.write("\n");
      out.write("                                                                <tr>\n");
      out.write("                                                                    <th>Titulo de tarea</th>\n");
      out.write("                                                                    <th>Descripcion</th>\n");
      out.write("                                                                    <th>Importancia</th>\n");
      out.write("                                                                    <th>Usuario responsable</th>\n");
      out.write("                                                                    <th>Duracion(Dias)</th>\n");
      out.write("                                                                    <th><button  type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#ModalXP\">   +   </button></th>\n");
      out.write("                                                                </tr>\n");
      out.write("                                                                 ");
 for (int u = 0; u <= NumeroDeTareas - 1; u++) {
                                                                        TareaProyecto TareaSola = TareasTodas.get(u);
                                                                        String Titulo = TareaSola.getTitulo();
                                                                        String Descripcion = TareaSola.getDescripcion();
                                                                        String Importancia = TareaSola.getImportancia();
                                                                        int Numerodias = TareaSola.getDuracionDias();
                                                                        String NombreResponsable = TareaSola.getUsrAsiNombre();
                                                                        String ApellidoResponsable = TareaSola.getApatAsiNombre();

                                                                
      out.write("\n");
      out.write("                                                                <tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                                    <td>");
out.print(Titulo);
      out.write("</td>\n");
      out.write("                                                                    <td>");
out.print(Descripcion);
      out.write("</td>\n");
      out.write("                                                                    <td>");
out.print(Importancia);
      out.write("</td>\n");
      out.write("                                                                    <td>");
out.print(NombreResponsable + " " + ApellidoResponsable);
      out.write("</td>                                                              \n");
      out.write("                                                                    <td>");
out.print(Numerodias);
      out.write("</td>\n");
      out.write("                                                                    <td><button  type=\"button\" class=\"btn btn-danger\">   -   </button></td>\n");
      out.write("                                                                </tr>\n");
      out.write("                                                                ");
}
      out.write("\n");
      out.write("                                                            </table>\n");
      out.write("                                                        </td>\n");
      out.write("                                                    </tr>\n");
      out.write("\n");
      out.write("                                                    <tr>\n");
      out.write("\n");
      out.write("                                                    </tr>\n");
      out.write("                                                </tbody>\n");
      out.write("                                            </table>\n");
      out.write("                                        </div>\n");
      out.write("                                    </td>\n");
      out.write("\n");
      out.write("                                </tr>\n");
      out.write("                            </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <form action=\"TareaAlta\" method=\"post\" onsubmit=\" \" >\n");
      out.write("                                <div class=\"modal fade\" id=\"ModalXP\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("                                    <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("\n");
      out.write("                                        <div class=\"modal-content form-group\">\n");
      out.write("                                            <div class=\"modal-header\">\n");
      out.write("                                                <h3 class=\"modal-title\" id=\"exampleModalLabel\">REGISTRO DE TAREA</h3>\n");
      out.write("                                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                                    <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                                                </button>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"modal-body\">\n");
      out.write("                                                <div class=\"input-group\" style=\"width:60%; \">\n");
      out.write("                                                    <span class=\"input-group-addon\">Titulo de tarea</span>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"TituloT\"  id=\"TituloT\" pattern=\"[A-Za-z]{1,20}\" title=\"Este campo debe de llenarse unicamente con letras\" placeholder=\"Ej. Conseguir Patrocinadores\"  onkeypress=\"return sololetras(event)\" required />\n");
      out.write("                                                </div>\n");
      out.write("                                                <br/>\n");
      out.write("                                                <div class=\"input-group\" style=\"width:60%; \">\n");
      out.write("                                                    <span class=\"input-group-addon\">Descripcion</span>\n");
      out.write("                                                    <input type=\"text\" name=\"DescripcionT\" id=\"DescripcionT\" class=\"form-control\" placeholder=\"Ej. Hablales de tu idea\"    pattern=\"[A-Za-z]{1,20}\" title=\"Este campo debe de llenarse unicamente con letras\" onkeypress=\"return sololetras(event)\" required />\n");
      out.write("                                                </div>\n");
      out.write("                                                <br/>\n");
      out.write("                                                <div class=\"input-group\" style=\"width:60%; \" >\n");
      out.write("                                                    <span class=\"input-group-addon\">Importancia</span>\n");
      out.write("                                                    <input type=\"text\" name=\"ImportanciaT\" id=\"ImportanciaT\" class=\"form-control\"  placeholder=\"Alta, Media o Baja\" pattern=\"[A-Za-z]{1,20}\" title=\"Este campo debe de llenarse unicamente con letras\" onkeypress=\"return sololetras(event)\" required />\n");
      out.write("                                                </div>\n");
      out.write("                                                <br/>\n");
      out.write("                                                <div class=\"input-group\" style=\"width:40%; \" >\n");
      out.write("                                                    <span class=\"input-group-addon\">Usuario asignado</span>\n");
      out.write("                                                    <select id=\"UsuarioResponsable\" name=\"UsuarioResponsable\" required>\n");
      out.write("                                                        <option value=\"0\">Seleccione a su Victima</option>\n");
      out.write("                                                        ");

                                                            for (int h = 0; h <= NumeroDeUsuariosUnidos - 1; h++) {
                                                                Usuario usrun = UsuariosUnidosTodos.get(h);
                                                                String Nombre = usrun.getNombre();
                                                                String Apat = usrun.getApat();
                                                                String Amat = usrun.getAmat();
                                                                String correo = usrun.getCorreo();
                                                        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                        <option class=\"optionHome\" value=\"");
out.print(correo);
      out.write('"');
      out.write('>');
out.print(Nombre + " " + Apat + " " + Amat);
      out.write("</option>\n");
      out.write("\n");
      out.write("                                                        ");

                                                            }
                                                        
      out.write("\n");
      out.write("\n");
      out.write("                                                    </select>\n");
      out.write("                                                </div>\n");
      out.write("                                                <br/>\n");
      out.write("                                                <div class=\"input-group\" style=\"width:40%; \" >\n");
      out.write("                                                    <span class=\"input-group-addon\">Duracion(Dias)</span>\n");
      out.write("                                                    <input type=\"number\" placeholder=\"1\" id=\"DuracionDias\" name=\"DuracionDias\" required/>\n");
      out.write("                                                    <input type=\"hidden\" value=\"");
out.print(informacion);
      out.write("\" id=\"InfoProyectoT\" name=\"InfoProyectoT\">\n");
      out.write("                                                </div>\n");
      out.write("                                                <br/>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"modal-footer\">\n");
      out.write("                                                <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">CANCELAR</button>\n");
      out.write("                                                <input type=\"submit\" class=\"btn btn-primary\" name=\"guarda\" id=\"guarda\" value=\"GUARDAR INFORMACION\">\n");
      out.write("                                                <!--<input type=\"button\" class=\"btn btn-primary\" name=\"guarda\" id=\"guarda\" value=\"guarda\" onclick=\"enviar()\" />-->\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"col\"></div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                                                \n");
      out.write("                <div class=\"tab-pane fade show active\" id=\"chat\" role=\"tabpanel\" aria-labbelledby=\"chat-tab\">\n");
      out.write("                    \n");
      out.write("                    <iframe src=\"http://localhost:4000\" style=\"left: 0px; position: absolute; height: 100%;width: 98%;top:18%;\"></iframe>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"Disegno/js/jquery.js\"></script>\n");
      out.write("        <script src=\"Disegno/js/bootstrap.js\"></script>\n");
      out.write("        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>\n");
      out.write("        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js'></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
