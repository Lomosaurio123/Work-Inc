package org.apache.jsp.Usuarios;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class MenuUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n");
      out.write("        <title>Work-Inc</title>\n");
      out.write("        <link href=\"../Disegno/CSS/menu.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.2/css/all.css\" integrity=\"sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"sidebar-navigation\">\n");
      out.write("            <ul>\n");
      out.write("                <a href=\"\" target=\"prueba\">\n");
      out.write("                    <li class=\"active\">\n");
      out.write("                        <i class=\"fas fa-atom\"></i>\n");
      out.write("                        <span class=\"tooltip\">Work-Inc</span>\n");
      out.write("                    </li>\n");
      out.write("                </a>\n");
      out.write("                <a href=\"../ReadUsuario\" target=\"prueba\">\n");
      out.write("                    <li> \n");
      out.write("                        <i class=\"fas fa-user-circle\"></i>\n");
      out.write("                        <span class=\"tooltip\">Mi Perfil</span>\n");
      out.write("                    </li>\n");
      out.write("                </a>\n");
      out.write("                <a href=\"../Proyectos/Proyectos.jsp\" target=\"prueba\">\n");
      out.write("                    <li>\n");
      out.write("                        <i class=\"fas fa-briefcase\"></i>\n");
      out.write("                        <span class=\"tooltip\">Proyectos</span>\n");
      out.write("                    </li>\n");
      out.write("                </a>\n");
      out.write("                <a href=\"#\" target=\"prueba\">\n");
      out.write("                    <li>\n");
      out.write("                        <i class=\"fas fa-address-card\"></i>\n");
      out.write("                        <span class=\"tooltip\">Currículo</span>\n");
      out.write("                    </li>\n");
      out.write("                </a>\n");
      out.write("                <a href=\"prueba5.jsp\" target=\"prueba\">\n");
      out.write("                    <li>\n");
      out.write("                        <i class=\"far fa-eye\"></i>\n");
      out.write("                        <span class=\"tooltip\">Noticias</span>\n");
      out.write("                    </li>\n");
      out.write("                </a>\n");
      out.write("                <a href=\"prueba6.jsp\" target=\"prueba\">\n");
      out.write("                    <li>\n");
      out.write("                        <i class=\"fas fa-dice\"></i>\n");
      out.write("                        <span class=\"tooltip\">Juego</span>\n");
      out.write("                    </li>\n");
      out.write("                </a>\n");
      out.write("                <a href=\"../Soporte/Ayuda.html\" target=\"prueba\">\n");
      out.write("                    <li>\n");
      out.write("                        <i class=\"fas fa-cogs\"></i>\n");
      out.write("                        <span class=\"tooltip\">Ayuda</span>\n");
      out.write("                    </li>\n");
      out.write("                </a>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"page\">\n");
      out.write("            <!--<iframe src=\"http://localhost:4000\" name=\"prueba\" style=\"left: 90px; position: absolute; height: 90%;width: 90%;top:5%;\">-->\n");
      out.write("            <iframe src=\"../Usuarios/Menu.jsp\" name=\"prueba\" style=\"left: 90px; position: absolute; height: 90%;width: 90%;top:5%;\">\n");
      out.write("\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("            </iframe>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-1.9.1.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $('ul li').on('click', function () {\n");
      out.write("                $('li').removeClass('active');\n");
      out.write("                $(this).addClass('active');\n");
      out.write("            });\n");
      out.write("        </script>\n");
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
