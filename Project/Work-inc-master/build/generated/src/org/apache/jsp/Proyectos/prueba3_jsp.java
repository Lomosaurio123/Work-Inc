package org.apache.jsp.Proyectos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class prueba3_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n");
      out.write("        <title>Proyectos</title>\n");
      out.write("        <link href=\"../Disegno/CSS/Todoslosproyectos.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"general\">\n");
      out.write("            <div class=\"proyecto\">\n");
      out.write("                <div class=\"imagen\">\n");
      out.write("                    \n");
      out.write("                    <img src=\"../RecursosGraficos/Imagenes/WORKING.png\" alt=\"\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"informacion\">\n");
      out.write("                    <div class=\"texto\">\n");
      out.write("                        <h1>Categoría</h1>\n");
      out.write("                        <h2>Proyecto</h2>\n");
      out.write("                        <h3>Monto necesario</h3>\n");
      out.write("                        <p>Espacio para la idea del proyecto</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mas\">\n");
      out.write("                        <a href=\"#openModal\">Ver más</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"proyecto\">\n");
      out.write("                <div class=\"imagen\">\n");
      out.write("                    <img src=\"../RecursosGraficos/Imagenes/porque.png\" alt=\"\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"informacion\">\n");
      out.write("                    <div class=\"texto\">\n");
      out.write("                        <h1>Categoría</h1>\n");
      out.write("                        <h2>Proyecto2</h2>\n");
      out.write("                        <h3>Monto necesario</h3>\n");
      out.write("                        <p>Espacio para la idea del proyecto</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mas\">\n");
      out.write("                        <a href=\"#openModal\">Ver más</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"proyecto\">\n");
      out.write("                <div class=\"imagen\">\n");
      out.write("                    <img src=\"../RecursosGraficos/Imagenes/porque.png\" alt=\"\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"informacion\">\n");
      out.write("                    <div class=\"texto\">\n");
      out.write("                        <h1>Categoría</h1>\n");
      out.write("                        <h2>Proyecto2</h2>\n");
      out.write("                        <h3>Monto necesario</h3>\n");
      out.write("                        <p>Espacio para la idea del proyecto</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mas\">\n");
      out.write("                        <a href=\"#openModal\">Ver más</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"proyecto\">\n");
      out.write("                <div class=\"imagen\">\n");
      out.write("                    <img src=\"../RecursosGraficos/Imagenes/IMG COOL.jpg\" alt=\"\"/>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"informacion\">\n");
      out.write("                    <div class=\"texto\">\n");
      out.write("                        <h1>Categoría</h1>\n");
      out.write("                        <h2>Proyecto2</h2>\n");
      out.write("                        <h3>Monto necesario</h3>\n");
      out.write("                        <p>Espacio para la idea del proyecto</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mas\">\n");
      out.write("                        <a href=\"#openModal\">Ver más</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!--NUEVO--->\n");
      out.write("        <div id=\"openModal\" class=\"modalDialog\">\n");
      out.write("            <div>\n");
      out.write("                <input type=\"text\" disabled=\"off\" value=\"Nombre Proyecto\" />\n");
      out.write("             \n");
      out.write("            </div>\n");
      out.write("            <a href=\"#close\" class=\"close\">Cerrar</a>\n");
      out.write("            <br><br>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!---->\n");
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
