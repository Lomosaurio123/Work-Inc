package org.apache.jsp.Proyectos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Base64;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import com.working.modelos.Proyecto;

public final class ManejoProyectos_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"Disegno/CSS/proyectos.css\">\n");
      out.write("         <link rel=\"shortcut icon\" type=\"image/png\" href=\"RecursosGraficos/Imagenes/ha.png\"/>\n");
      out.write("         \n");
      out.write("        <title>Administracion_Proyectos</title>\n");
      out.write("        <style>\n");
      out.write("            div{\n");
      out.write("                float: left;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        ");

           List<Proyecto> TodosProyectos ;
          
           TodosProyectos = (List<Proyecto>)request.getAttribute("TodosUsuario");
           int numerodeproyectos=0;
           ArrayList<Proyecto> ProyectosTodos = new ArrayList<Proyecto>();
           Proyecto pro;
           
           for(Proyecto p : TodosProyectos){
             String idea=p.getIdea_Principal();
             String nombreproyect = p.getNombreProyecto();
             int monto = p.getMonto();
             String categoria = p.getCategoria();
             Blob imgproyecto = p.getImgregreso();
             
                 pro=new Proyecto(nombreproyect,idea,categoria,monto,imgproyecto);
                 ProyectosTodos.add(pro);
               numerodeproyectos=numerodeproyectos+1; 
           }
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>PROYECTOS ACTIVOS</h1>\n");
      out.write("        \n");
      out.write("        <div style=\"justify-content:center\">\n");
      out.write("        ");

            for(int i=0; i<=numerodeproyectos-1 ;i++ ){
        
      out.write(" \n");
      out.write("       \n");
      out.write("              \n");
      out.write("            <div class=\"blog-card\">\n");
      out.write("            <div class=\"meta\">\n");
      out.write("               \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            ");

               Proyecto prodesp= ProyectosTodos.get(i);
               

               ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buf = new byte[1024];
                    Blob blob = prodesp.getImgregreso();
                    InputStream in = blob.getBinaryStream();
                    int n = 0;
                    while ((n=in.read(buf))>=0){
                       baos.write(buf, 0, n);
                    }
                     in.close();
                     byte[] bytes = baos.toByteArray(); 
                     byte[] encodedBytes = Base64.getEncoder().encode(bytes);
                     String base64Encoded = new String(encodedBytes, "UTF-8");
                     out.println("<div ><img src='data:image/jpg;base64,"+base64Encoded+"' alt='Imagen ID:' style='width:100%'></div>");
                     
                     out.println("<div class='photo' style=' background-image:  src='data:image/jpg;base64,"+base64Encoded+"' alt='Imagen ID:' style='width:20%'     '></div>");
                     
            
      out.write("                       \n");
      out.write("      \n");
      out.write("\n");
      out.write("                <ul class=\"details\">\n");
      out.write("                    <li class=\"author\"><a href=\"#\">John Doe</a></li>\n");
      out.write("                    <li class=\"date\">Aug. 24, 2015</li>\n");
      out.write("                    <li class=\"tags\">\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"#\">Learn</a></li>\n");
      out.write("                            <li><a href=\"#\">Code</a></li>\n");
      out.write("                            <li><a href=\"#\">HTML</a></li>\n");
      out.write("                            <li><a href=\"#\">CSS</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            <div class=\"description\">\n");
      out.write("                \n");
      out.write("                <form action=\"ProyectoEspecifico\" method=\"post\">\n");
      out.write("                <h1>");
 out.print(prodesp.getNombreProyecto());  
      out.write("</h1>\n");
      out.write("                ");
String tituloprueba=prodesp.getNombreProyecto(); 
      out.write("\n");
      out.write("                <input type=\"hidden\" value=\"");
 out.print(prodesp.getNombreProyecto());
      out.write("\" id=\"NompreProyect\" name=\"NompreProyect\">\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <h2>Categoria: ");
 out.println(prodesp.getCategoria()); 
      out.write("</h2>\n");
      out.write("                <input type=\"hidden\" value=\"");
out.print(prodesp.getCategoria()); ;
      out.write("\" id=\"CategoriaProyect\" name=\"CategoriaProyect\">\n");
      out.write("                \n");
      out.write("                <p><b> ¿Cual es la idea?</b></p>\n");
      out.write("                <p>");
 out.print(prodesp.getIdea_Principal()); 
      out.write("</p>\n");
      out.write("                <input type=\"hidden\" value=\"");
out.print(prodesp.getIdea_Principal()) ;
      out.write("\" id=\"IdeaProyect\" name=\"IdeaProyect\">\n");
      out.write("                \n");
      out.write("                <p><b>¿Cuanto dinero necesitamos?</b></p>\n");
      out.write("                <p> $");
out.print(prodesp.getMonto());
      out.write(" .00</p>\n");
      out.write("                <input type=\"hidden\" value=\"");
 out.print(prodesp.getMonto()); 
      out.write("\" id=\"MontoProyect\" name=\"MontoProyect\">\n");
      out.write("\n");
      out.write("                <p class=\"read-more\">\n");
      out.write("                 <input type=\"submit\"  value=\"Administracion del Proyecto\">\n");
      out.write("                    \n");
      out.write("                </p>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            </div>\n");
      out.write("                \n");
      out.write("            ");
 }
            
      out.write("\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("       \n");
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
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
