package org.apache.jsp.Usuarios;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.working.modelos.Usuario;

public final class Menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Menu</title>\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/png\" href=\"../RecursosGraficos/Imagenes/ha.png\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"../Disegno/bootstrap/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../Disegno/CSS/menuNoActualizado.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../Disegno/CSS/iconos.css\">\n");
      out.write("         <link rel=\"stylesheet\" href=\"../RecursosGraficos/icon/style.css\">\n");
      out.write("\n");
      out.write("    </head>  \n");
      out.write("        ");
  
        try{
        HttpSession sesion= (HttpSession) request.getSession();
        Usuario usuario =(Usuario)sesion.getAttribute("usuario");      
        String correo = usuario.getCorreo();
        String contra = usuario.getContra();
        

        }catch(Exception e){
            response.sendRedirect("../index.html");
        }
        
        
      out.write("\n");
      out.write("        <body>\n");
      out.write("        \n");
      out.write("        <header>\n");
      out.write("            <nav class=\"navbar navbar-default\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar-1\">\n");
      out.write("                        <span class=\"sr-only\">Menu</span>\n");
      out.write("                        \n");
      out.write("                    </button>\n");
      out.write("                    <a href=\"#\" class=\"navbar-brand\">BIENVENIDO:  </a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"navbar navbar-collapse\" id=\"navbar-1\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">   \n");
      out.write("                        <li><a href=\"\">ACERCA DE AXIS</a></li>    \n");
      out.write("                        <li ><a href=\"\">INICIO</a></li>   \n");
      out.write("                    </ul>\n");
      out.write("                    \n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <li data-toggle=\"modal\" data-target=\"#ModalRegis\"><a>AYUDA</a></li>\n");
      out.write("                        <li><a href=\"../cerrarcesion\">CERRAR SESION</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    <form class=\"navbar-form navbar-right\" role=\"search\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <input type=\"text\" class=\"form-control icon-next\" placeholder=\"Buscar\" >\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </nav> \n");
      out.write("        </header>\n");
      out.write("        \n");
      out.write("\n");
      out.write("         \n");
      out.write("     <main>\n");
      out.write("        <div class=\"content-menu\">\n");
      out.write("           \n");
      out.write("            \n");
      out.write("            <a href=\"../ReadUsuario\"><li><span class=\"lnr lnr-user icon2\"></span><h4 class=\"text2\">Usuario</h4></li></a>\n");
      out.write("            <a href=\"../Proyectos/Proyectos.jsp\"> <li><span class=\"lnr lnr-apartment icon3\"></span><h4 class=\"text3\">Proyectos</h4></li></a>\n");
      out.write("            <li><span class=\"lnr lnr-bubble icon6\"></span><h4 class=\"text6\">Chats</h4></li>\n");
      out.write("            <a href=\"../Curriculum/PrimerPaso.jsp\"><li><span class=\"lnr lnr-envelope icon7\"></span><h4 class=\"text7\">Curriculos</h4></li></a>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        <article>\n");
      out.write("            <center><h1>WorkInc</h1></center>\n");
      out.write("           \n");
      out.write("            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quod consequatur, ex assumenda fuga, rem quidem delectus mollitia optio repellendus neque alias repellat distinctio sint omnis, quae blanditiis aliquam? Eius inventore esse, voluptas vero dolores iusto in aut ipsam fugiat possimus hic maxime deleniti, commodi at quidem cupiditate laborum, tempore iste dolorem. Et expedita tenetur saepe dolores fuga excepturi iste sit quos, ab temporibus, molestiae vel sint sed nihil. Officiis debitis unde facilis aperiam quae perspiciatis necessitatibus veniam, quisquam sed animi cumque maiores deleniti reprehenderit exercitationem, culpa. Perferendis repellat corrupti tempore placeat, illo fugiat, magnam, omnis voluptate deserunt ad nihil alias!</p>\n");
      out.write("        </article>\n");
      out.write("    </main>\n");
      out.write("   \n");
      out.write("        <script src=\"Disegno/js/jquery.js\"></script>\n");
      out.write("        <script src=\"Disegno/js/bootstrap.js\"></script>\n");
      out.write("        \n");
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
