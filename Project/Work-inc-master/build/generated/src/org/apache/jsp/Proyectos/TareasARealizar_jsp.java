package org.apache.jsp.Proyectos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class TareasARealizar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid mt-4\">\n");
      out.write("            <ul class=\"nav nav-tabs\" id=\"myTab\" role=\"tablist\">\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link active\" id=\"profile-tab\" data-toggle=\"tab\" href=\"#profile\" role=\"tab\" aria-controls=\"profile\" aria-selected=\"true\"> Administracion de tareas </a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" id=\"notify-tab\" data-toggle=\"tab\" href=\"#notify\" role=\"tab\" aria-controls=\"notify\" aria-selected=\"true\"> Chat </a>\n");
      out.write("                </li>\n");
      out.write("\n");
      out.write("            </ul>\n");
      out.write("            <div class=\"tab-content\" id=\"myTabContent\">\n");
      out.write("                <div class=\"tab-pane fade show active\" id=\"profile\" role=\"tabpanel\" aria-labbelledby=\"profile-tab\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col\"></div>\n");
      out.write("                        <div class=\"col-lg-6 col-md-8 col-sm-12 pt-4\">\n");
      out.write("                            <h4> Informacion de Usuario </h4>\n");
      out.write("                            <hr/>\n");
      out.write("                            <div class=\"form-row\">\n");
      out.write("                                <div class=\"form-group col-lg-6 col-md-12\">\n");
      out.write("                                    <label for=\"username\"> Nombre </label>\n");
      out.write("                                    <input class=\"form-control\" id=\"nombre\" name=\"nombre\" value=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-lg-6 col-md-12\">\n");
      out.write("                                    <label for=\"email\"> correo </label>\n");
      out.write("                                    <input class=\"form-control\" id=\"email\" name=\"correo\" value=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-lg-6 col-md-12\">\n");
      out.write("                                    <label for=\"firstname\"> Apellido Paterno</label>\n");
      out.write("                                    <input class=\"form-control\" id=\"firstname\" name=\"apellido_pat\" value=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-lg-6 col-md-12\">\n");
      out.write("                                    <label for=\"lastname\">Apellido Materno</label>\n");
      out.write("                                    <input class=\"form-control\" id=\"lastname\" name=\"apellido_mat\" value=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-lg-6 col-md-12\">\n");
      out.write("                                    <label for=\"phone\">Contraseña</label>\n");
      out.write("                                    <input type=\"password\"class=\"form-control\" id=\"phone\" name=\"contrasena\" value=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-lg-6 col-md-12\">\n");
      out.write("                                    <label for=\"password\">Confirma contraseña</label>\n");
      out.write("                                    <input type=\"password\" class=\"form-control\" id=\"password\" name=\"ConfirContra\" value=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-lg-6 col-md-12\">\n");
      out.write("                                    <label for=\"phone\">Telefono</label>\n");
      out.write("                                    <input class=\"form-control\" id=\"phone\" name=\"telefono\"   value=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-lg-6 col-md-12\">\n");
      out.write("                                    <label for=\"password\">Edad</label>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"password\" name=\"edad\" value=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-lg-6 col-md-12\"></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <div class=\"form-group col-lg-6 col-md-12\">\n");
      out.write("                                    <label for=\"phone\">N° de cecula</label>\n");
      out.write("                                    <input class=\"form-control\" id=\"phone\" name=\"cedula\"   value=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-lg-6 col-md-12\">\n");
      out.write("                                    <label for=\"phone\">Universidad</label>\n");
      out.write("                                    <input class=\"form-control\" id=\"phone\" readonly=\"readonly\" name=\"uni\" value=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-lg-6 col-md-12\">\n");
      out.write("                                    <label for=\"password\">Profesion</label>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"password\" readonly=\"readonly\" name=\"prof\" value=\"\"> \n");
      out.write("                                </div>\n");
      out.write("                               \n");
      out.write("\n");
      out.write("\n");
      out.write("                                <input class=\"btn btn-primary btn-block\" type=\"submit\" value=\"Actualizar Perfil\" name=\"Envia\">\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col\"></div>\n");
      out.write("                        <a href=\"Usuarios/Menu.jsp\">Regresar al menu</a>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"tab-pane fade\" id=\"notify\" role=\"tabpanel\" aria-labelledby=\"notify-tab\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col\"></div>\n");
      out.write("                        <div class=\"col-lg-6 col-md-8 col-sm-12 pt-4\">\n");
      out.write("                            <h4>Eliminar Usuario</h4>\n");
      out.write("                            <Label for=\"Informacion\">Si elimina el perfil de usuario de eliminara toda la informacion relacionada con este, y se perdera todo la reputacion que haya adquiero con este \n");
      out.write("                                perfil , aun asi, ¿Desea Eliminar el perfil de usuario?.\n");
      out.write("                            </Label>\n");
      out.write("                            <form action=\"EliminarUsuario\" method=\"get\" onsubmit=\"return eliminar(this)\" name=\"Eliminar\">\n");
      out.write("                                <input type=\"submit\" value=\"Eliminar Perfil\" name=\"Envia\">\n");
      out.write("                            </form>\n");
      out.write("\n");
      out.write("                            <hr />\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-lg-6 col-md-8 col-sm-12 pt-4\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col\"></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>\n");
      out.write("        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js'></script>\n");
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
