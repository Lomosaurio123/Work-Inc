package org.apache.jsp.Curriculum;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.working.modelos.Usuario;
import com.working.conexion.ConexionBD;

public final class PrimerPaso_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/png\" href=\"../RecursosGraficos/Imagenes/ha.png\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"../Disegno/bootstrap/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../Disegno/CSS/menu.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../Disegno/CSS/iconos.css\">\n");
      out.write("        <link href=\"CurriCss.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Curriculum</title>\n");
      out.write("    </head>\n");
      out.write("    ");

        HttpSession sesion = (HttpSession) request.getSession();
        Usuario usuario = null;
        try {

            usuario = (Usuario) sesion.getAttribute("usuario");

            String correo = usuario.getCorreo();
            String contra = usuario.getContra();

            out.println("<script>alert('" + correo + "');</script>");

        } catch (Exception e) {
            response.sendRedirect("../index.html");
        }

        ConexionBD conecta = new ConexionBD();
        conecta.getConectar();


    
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <nav class=\"navbar navbar-default\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar-1\">\n");
      out.write("                        <span class=\"sr-only\">Menu</span>\n");
      out.write("\n");
      out.write("                    </button>\n");
      out.write("                    <a href=\"#\" class=\"navbar-brand\">BIENVENIDO:  </a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"navbar navbar-collapse\" id=\"navbar-1\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">   \n");
      out.write("                        <li><a href=\"\">ACERCA DE AXIS</a></li>    \n");
      out.write("                        <li ><a href=\"\">INICIO</a></li>   \n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <li data-toggle=\"modal\" data-target=\"#ModalRegis\"><a>AIUDA</a></li>\n");
      out.write("                        <li><a href=\"../cerrarcesion\">CERRAR SESION</a></li>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <form class=\"navbar-form navbar-right\" role=\"search\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input type=\"text\" class=\"form-control icon-next\" placeholder=\"Buscar\" >\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </nav> \n");
      out.write("        </header>\n");
      out.write("        <main>\n");
      out.write("            <div class=\"content-menu\">\n");
      out.write("\n");
      out.write("                <!--<li><span class=\"lnr lnr-home icon1\"></span><h4 class=\"text1\">Inicio</h4></li>-->\n");
      out.write("                <a href=\"../ReadUsuario\"><li><span class=\"lnr lnr-user icon2\"></span><h4 class=\"text2\">Usuario</h4></li></a>\n");
      out.write("                <a href=\"../Proyectos/Proyectos.jsp\"> <li><span class=\"lnr lnr-apartment icon3\"></span><h4 class=\"text3\">Proyectos</h4></li></a>\n");
      out.write("                <!-- <li><span class=\"lnr lnr-thumbs-up icon4\"></span><h4 class=\"text4\">Mis proyectos</h4></li>\n");
      out.write("                 <li><span class=\"lnr lnr-magic-wand icon5\"></span><h4 class=\"text5\">Crear proyecto</h4></li>-->\n");
      out.write("                <li><span class=\"lnr lnr-bubble icon6\"></span><h4 class=\"text6\">Chats</h4></li>\n");
      out.write("                <a href=\"../Curriculum/PrimerPaso.jsp\"><li><span class=\"lnr lnr-envelope icon7\"></span><h4 class=\"text7\">Curriculos</h4></li></a>\n");
      out.write("\n");
      out.write("                <!--<li><span class=\"lnr lnr-exit icon1\"></span><h4 class=\"text9\">Salir</h4></li>-->\n");
      out.write("                <!-- <li><span class=\"lnr lnr-question-circle icon9\"></span><h4 class=\"text9\">Ayuda</h4></li>-->\n");
      out.write("            </div>\n");
      out.write("            <article>\n");
      out.write("                <center><h1>Mi Curriculum</h1></center>\n");
      out.write("                <div id=\"contenedorT\">    \n");
      out.write("                ");

                out.print("<table cellspacing='5'>");
                    out.print("<tr>");
                        out.print("<td>");
                 
      out.write("\n");
      out.write("                            <img src=\"Foto.png\">\n");
      out.write("                 ");

                        out.print("</td>");
                   
                        out.print("<td>");
                
      out.write("\n");
      out.write("                            <input type=\"text\" id=\"nombre\" name=\"nombre\" disabled value=\"");
      out.print(usuario.getApat() + ' ' + usuario.getAmat() + ' ' + usuario.getNombre());
      out.write("\"></br> \n");
      out.write("                            <br><input type=\"text\" id=\"profesion\" name=\"profesion\" disabled size=\"50\" value=\"");
      out.print(usuario.getProfesion());
      out.write("\"></br> \n");
      out.write("                ");

                        out.print("</td>");
                    out.print("</tr>");
                    out.print("<tr>");
                            out.print("<td id='Exp'>");out.print("Experiencia Laboral");out.print("</td>");
                            out.print("<td id='Est'>");out.print("Estudios");out.print("</td>");
                    out.print("</tr>");
                    out.print("<tr>");
                            //Aquí irá lo que anote
                            out.print("<td>");
                            out.print("¡Te falta completar este campo!");
                            out.print("</td>");
                            out.print("<td>");
                 
      out.write(" \n");
      out.write("                            <input type=\"text\" id=\"uni\" name=\"uni\" disabled size=\"50\" value=\"");
      out.print(usuario.getUniversidad());
      out.write("\"><br>\n");
      out.write("                            <br>\n");
      out.write("                            <label>Idiomas</label>\n");
      out.write("                            <br>\n");
      out.write("                            ...\n");
      out.write("                 ");

                            out.print("</td>");
                            
                    out.print("</tr>");
                    
                    out.print("<tr>");
                            out.print("<td id='Cnt'>");
                            out.print("Contácto");
                            out.print("</td>");
                    out.print("</tr>");
                    
                    out.print("<tr>");
                            out.print("<td>");
               
      out.write("\n");
      out.write("                            <label>Correo </label><br>\n");
      out.write("                            <input type=\"text\" id=\"correo\" name=\"correo\" disabled value=\"");
      out.print(usuario.getCorreo());
      out.write("\"></br> \n");
      out.write("                            <br>\n");
      out.write("                            <label>Teléfono </label><br>\n");
      out.write("                            <input type=\"text\" id=\"tel\" name=\"tel\" disabled value=\"");
      out.print(usuario.getTelefono());
      out.write("\"></br>\n");
      out.write("               ");

                            out.print("</td>");
                    out.print("</tr>");
                    
                out.print("</table>");
                       
                
      out.write("\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div id=\"contiene\"> \n");
      out.write("                    <li><a href=\"#openModal\" class=\"cool\">¡Terminar!</a></li>\n");
      out.write("                    <br><br><br>\n");
      out.write("                    <li><a href=\"\" class=\"cool\">Modificar</a></li>\n");
      out.write("                </div>\n");
      out.write("            </article>\n");
      out.write("        </main>\n");
      out.write("\n");
      out.write("         <!--VENTANA MODAL-->\n");
      out.write("        \n");
      out.write("         <div style=\"display: table; width: 1250px; height: 120px;\">\n");
      out.write("          <div id=\"openModal\" class=\"modalDialog\">\n");
      out.write("            <div>\n");
      out.write("                <a href=\"#close\" title=\"Cerrar\" class=\"close\">X</a>\n");
      out.write("                <center> \n");
      out.write("                 <form action=\"\" method=\"post\"> \n");
      out.write("                     <h2>Experiencia Laboral</h2> <br>\n");
      out.write("                   <label>Lugar: </label>\n");
      out.write("                   <input type=\"text\"  name='lugar' id=\"lugar\" autocomplete=\"off\" required>\n");
      out.write("                   <br>\n");
      out.write("                   <br>\n");
      out.write("                   <br>\n");
      out.write("                   <label>Actividad: </label>\n");
      out.write("                   <textarea name=\"actividad\" id=\"actividad\" required autocomplete=\"off\"></textarea>\n");
      out.write("                   <br>\n");
      out.write("                   <h2>Idiomas</h2> <br> \n");
      out.write("                   <input type=\"text\" size=\"30\" name='idioma' id=\"idioma\" autocomplete=\"off\" required>\n");
      out.write("                   <br><br>\n");
      out.write("                   <button type=\"submit\" name=\"guarda\" class=\"bota\">Guardar</button>\n");
      out.write("                 </form>   \n");
      out.write("                </center>\n");
      out.write("            </div>\n");
      out.write("         </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"Disegno/js/jquery.js\"></script>\n");
      out.write("        <script src=\"Disegno/js/bootstrap.js\"></script> \n");
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
