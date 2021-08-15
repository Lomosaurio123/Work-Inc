package org.apache.jsp.Proyectos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.working.modelos.Usuario;

public final class proyectos1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"../Disegno/CSS/proyectos_1.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("     ");
      
        HttpSession sesion= (HttpSession) request.getSession();
        Usuario usuario =(Usuario)sesion.getAttribute("usuario");
        
        String correo = usuario.getCorreo();
        String contra = usuario.getContra();
        
        
      out.write("\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("            \n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("                <form action=\"javascript:void(0);\" method=\"get\">\n");
      out.write("\n");
      out.write("                    <fieldset>\n");
      out.write("\n");
      out.write("                        <ul class=\"toolbar clearfix\">\n");
      out.write("\n");
      out.write("                            <li><a href=\"../ProyectosPropios\" target=\"pruebas\" class=\"fontawesome-heart\">&ThinSpace; Mis Proyectos</a></li>\n");
      out.write("                            <li><a href=\"proyectoalta.jsp\" target=\"pruebas\" class=\"fontawesome-eye-open\">&ThinSpace; Nuevo Proyecto</a></li>\n");
      out.write("                            <li><input type=\"search\" id=\"search\" placeholder=\"Buscar Proyecto\"></li>\n");
      out.write("                            <li><button type=\"submit\" id=\"btn-search\"><span class=\"fontawesome-search\"></span></button></li>\n");
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("\n");
      out.write("                    </fieldset>\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("            </div> \n");
      out.write("\n");
      out.write("            <div class=\"page\">\n");
      out.write("                <iframe src=\"../TodosProyectos\" name=\"pruebas\" style=\"left: 0px; position: absolute; height: 100%;width: 98%;top:18%;\"></iframe>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script>\n");
      out.write("            <script>\n");
      out.write("                (function () {\n");
      out.write("\n");
      out.write("                    $('#btn-search').on('click', function (e) {\n");
      out.write("\n");
      out.write("                        e.preventDefault();\n");
      out.write("                        $('#search').animate({width: 'toggle'}).focus();\n");
      out.write("\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                }());\n");
      out.write("            </script>\n");
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
