package org.apache.jsp.FAQ;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import com.working.modelos.faqs;
import java.util.List;

public final class FaqsWorkInc_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\" >\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>FAQ'S WorkInc</title>\n");
      out.write("        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-1.12.4.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");

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

        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <main>\n");
      out.write("            <h1>Preguntas Frecuentes Realizadas Por Los Usuarios</h1>\n");
      out.write("            <input type=\"text\" class=\"live-search-box\" placeholder=\"Búsqueda\" />\n");
      out.write("            \n");
      out.write("            ");

            for(int i=0; i<=numerodepreguntas-1 ;i++ ){
            
      out.write("\n");
      out.write("            <div class=\"topic\">\n");
      out.write("            <div class=\"open\">\n");
      out.write("                ");
faqs fas= PreguntasTodas.get(i);
      out.write("\n");
      out.write("                    <h2 class=\"question\">");
 out.print(fas.getPregunta());
      out.write("<span class=\"ptag\">SIEBEL</span></h2>\n");
      out.write("                    <span class=\"faq-t\"></span>\n");
      out.write("                </div>\n");
      out.write("                <p class=\"answer\">");
 out.print(fas.getRespuesta());
      out.write("<p>\n");
      out.write("            </div>\n");
      out.write("            ");
  }
            
      out.write("\n");
      out.write("            <!--Ventana Modal Para realizar preguntas-->\n");
      out.write("            <h2 class=\"question\">Si desea realizar una pregunta presione el siguiente boton</h2>\n");
      out.write("            <div class=\"contenedor-modal\">\n");
      out.write("                <button type=\"button\" class=\"btn btn-primary btn-lg\" data-toggle=\"modal\" data-target=\"#miModal\">Realizar Pregunta</button>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"modal fade\" id=\"miModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\n");
      out.write("                <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <div class=\"modal-header\">\n");
      out.write("                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                            </button>\n");
      out.write("                            <h4 class=\"modal-title\" id=\"myModalLabel\">Preguntas</h4>\n");
      out.write("                        </div>\n");
      out.write("                        <form method=\"post\" action=\"SubirPregunta\">\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <h2>Por favor, realice su pregunta:</h2>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <textarea class=\"form-control\" id=\"Pregunta\" name=\"Pregunta\" rows=\"3\"></textarea>\n");
      out.write("                                </div>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-info\">Enviar pregunta</button>\n");
      out.write("                        </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </main>\n");
      out.write("        <script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>\n");
      out.write("        <script  src=\"js/index.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
