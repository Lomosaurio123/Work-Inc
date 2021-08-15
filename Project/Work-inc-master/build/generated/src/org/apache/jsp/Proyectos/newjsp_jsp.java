package org.apache.jsp.Proyectos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.working.modelos.Usuario;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        ");


           /* HttpSession sesion = (HttpSession) request.getSession();
            Usuario usuario = (Usuario) sesion.getAttribute("usuario");

            String correo = usuario.getCorreo();
            String contra = usuario.getContra();

            out.println("<script>alert('" + correo + "');</script>");*/


        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form method=\"post\" action=\"../proyectoalta\" enctype=\"multipart/form-data\">\n");
      out.write("\n");
      out.write("            <div>\n");
      out.write("                <input type=\"text\" id=\"NombreProyecto\" name=\"NombreProyecto\" value=\"NombreProyecto\"  required/><br><br>\n");
      out.write("                <input type=\"text\" id=\"IdeaProyecto\" name=\"IdeaProyecto\" value=\"IdeaProyecto\" required/><br><br>\n");
      out.write("                <select  id=\"Categoria\" name=\"Categoria\" style=\"margin: 0 auto;\">\n");
      out.write("                    <option value=\"0\">Seleccione alguna categoria</option>\n");
      out.write("                    <option class=\"optionHome\" value=\"Ciencias Exactas\">Ciencias Exactas</option>\n");
      out.write("                    <option class=\"optionHome\" value=\"Ciencias Naturales\">Ciencias Naturales</option>\n");
      out.write("                    <option class=\"optionHome\" value=\"Medicina y Salud\">Medicina y Salud</option>\n");
      out.write("                    <option class=\"optionHome\" value=\"Ciencias Sociales y Humanidades\">Ciencias Sociales y Humanidades</option>\n");
      out.write("                    <option class=\"optionHome\" value=\"Ciencias de la Ingenieria\">Ciencias de la Ingenieria</option>\n");
      out.write("                    <option class=\"optionHome\" value=\"Agropecuarias y de Alimentos\">Agropecuarias y de Alimentos</option>\n");
      out.write("                    <option class=\"optionHome\" value=\"Divulgacion Cientifica\">Divulgacion Cientifica</option>\n");
      out.write("                    <option class=\"optionHome\" value=\"Medio Ambiente\">Medio Ambiente</option>\n");
      out.write("                    <option class=\"optionHome\" value=\"Mecatronica\">Mecatronica</option>\n");
      out.write("                    <option class=\"optionHome\" value=\"Ciencias de los Materiales\">Ciencias de los Materiales</option>\n");
      out.write("                    <option class=\"optionHome\" value=\"Biología\">Biología</option>\n");
      out.write("                    <option class=\"optionHome\" value=\"Computación y Software\">Computación y Software</option>\n");
      out.write("                </select><br><br>\n");
      out.write("                <input type=\"number\" id=\"Monto_Donacion\" name=\"MontoDonacion\" value=\"1000.0\" required/><br><br>\n");
      out.write("                <input accept=\"image/*\" type=\"file\" name=\"imagen\" id=\"imagen\" onchange=\"prevista(imagen)\"><br/><br>\n");
      out.write("                <div><output id=\"list\"></output></div><br>\n");
      out.write("                <select  id=\"NumeroIntegrantes\" name=\"NumeroIntegrantes\" style=\"margin: 0 auto;\" onchange=\"myFunction()\">\n");
      out.write("                    <option value=\"0\">Seleccione el numero de integrantes</option>\n");
      out.write("                    <option class=\"optionHome\" value=\"1\">1</option>\n");
      out.write("                    <option class=\"optionHome\" value=\"2\">2</option>\n");
      out.write("                    <option class=\"optionHome\" value=\"3\">3</option>\n");
      out.write("                    <option class=\"optionHome\" value=\"4\">4</option>\n");
      out.write("                    <option class=\"optionHome\" value=\"5\">5</option>\n");
      out.write("\n");
      out.write("                </select><br><br>\n");
      out.write("\n");
      out.write("                <input type=\"text\" id=\"Int1\" value=\"1\" style=\"display: none\">\n");
      out.write("                <input type=\"text\" id=\"Int2\" value=\"2\" style=\"display: none\">\n");
      out.write("                <input type=\"text\" id=\"Int3\" value=\"3\" style=\"display: none\">\n");
      out.write("                <input type=\"text\" id=\"Int4\" value=\"4\" style=\"display: none\">\n");
      out.write("                <input type=\"text\" id=\"Int5\" value=\"5\" style=\"display: none\">\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <input type=\"submit\" name=\"Enviar\" id=\"Enviar\">    \n");
      out.write("        </form>\n");
      out.write("        <h1>Registro de proyecto</h1>\n");
      out.write("        <script>\n");
      out.write("            function archivo(evt) {\n");
      out.write("                var files = evt.target.files; // FileList object\n");
      out.write("\n");
      out.write("                // Obtenemos la imagen del campo \"file\".\n");
      out.write("                for (var i = 0, f; f = files[i]; i++) {\n");
      out.write("                    //Solo admitimos imágenes.\n");
      out.write("                    if (!f.type.match('image.*')) {\n");
      out.write("                        continue;\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    var reader = new FileReader();\n");
      out.write("\n");
      out.write("                    reader.onload = (function (theFile) {\n");
      out.write("                        return function (e) {\n");
      out.write("                            // Insertamos la imagen\n");
      out.write("                            document.getElementById(\"list\").innerHTML = ['<img class=\"thumb\" src=\"', e.target.result, '\" title=\"', escape(theFile.name), '\"/>'].join('');\n");
      out.write("                        };\n");
      out.write("                    })(f);\n");
      out.write("\n");
      out.write("                    reader.readAsDataURL(f);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            document.getElementById('imagen').addEventListener('change', archivo, false);\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function myFunction() {\n");
      out.write("                var numIn = document.getElementById(\"NumeroIntegrantes\");\n");
      out.write("                var val = numIn.options[numIn.selectedIndex].value;\n");
      out.write("                //Creamos un nodo de texto que agregaremos al div.\n");
      out.write("                alert(val);\n");
      out.write("                for (var i = 1, max = 5; i <= max; i++) {\n");
      out.write("                    var text = document.getElementById(\"Int\" + i);\n");
      out.write("                    text.style.display = \"none\";\n");
      out.write("                }\n");
      out.write("                for (var i = 1, max = val; i <= max; i++) {\n");
      out.write("                    var text = document.getElementById(\"Int\" + i);\n");
      out.write("                    text.style.display = \"block\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
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
