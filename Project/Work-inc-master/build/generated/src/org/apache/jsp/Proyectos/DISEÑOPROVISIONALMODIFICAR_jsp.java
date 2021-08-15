package org.apache.jsp.Proyectos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DISEÑOPROVISIONALMODIFICAR_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/png\" href=\"../RecursosGraficos/Imagenes/ha.png\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"../Disegno/bootstrap/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../Disegno/CSS/proyectoalta.css\">\n");
      out.write("        <style>\n");
      out.write("             \n");
      out.write("            body{\n");
      out.write("    \n");
      out.write("            overflow-y: auto;\n");
      out.write("            font-family: Arial;\n");
      out.write("}\n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("         \n");
      out.write("        <title>Registro_Proyecto</title>\n");
      out.write("       \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("\n");
      out.write("        <form method=\"post\" action=\"../proyectoalta\" enctype=\"multipart/form-data\">\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <h1>Registro de proyecto</h1>\n");
      out.write("                <div class=\" row\" style=\"display: -webkit-flex; flex-wrap: wrap;\">\n");
      out.write("                \n");
      out.write("                    <article class=\"col-xs-12  col-sm-2 col-md-2 col-lg-2 \" style=\"background: grey\">\n");
      out.write("                         <div ><output id=\"list\"></output></div>\n");
      out.write("                    </article>\n");
      out.write("                    \n");
      out.write("                     <article class=\"col-xs-12  col-sm-5 col-md-5 col-lg-5 margen\" style=\"background: black\">\n");
      out.write("                     <input type=\"text\"   class=\"form-control form-control-lg\" placeholder=\"NOMBRE DEL PROYECTO\"  id=\"NombreProyecto\" name=\"NombreProyecto\" required/>\n");
      out.write("                     <br/>\n");
      out.write("                     <input  class=\"btn btn-primary \" role=\"button\"  accept=\"image/*\" type=\"file\" name=\"imagen\" id=\"imagen\" onchange=\"prevista(imagen)\"><br/>\n");
      out.write("                    </article>\n");
      out.write("                    \n");
      out.write("\n");
      out.write("                    <article class=\"col-xs-12  col-sm-4 col-md-4 col-lg-4 margen\" style=\"background: grey\">\n");
      out.write("                        <h4>¡Selecciona la categoria de tu proyecto!</h4>\n");
      out.write("                        <div class=\"input-group-prepend\">\n");
      out.write("                        <select  id=\"Categoria\" class=\"combobox form-control\" name=\"Categoria\" style=\"margin: 0 auto;\">\n");
      out.write("                            <option value=\"0\">Seleccione alguna categoria</option>\n");
      out.write("                            <option class=\"optionHome\" value=\"Ciencias Exactas\">Ciencias Exactas</option>\n");
      out.write("                            <option class=\"optionHome\" value=\"Ciencias Naturales\">Ciencias Naturales</option>\n");
      out.write("                            <option class=\"optionHome\" value=\"Medicina y Salud\">Medicina y Salud</option>\n");
      out.write("                            <option class=\"optionHome\" value=\"Ciencias Sociales y Humanidades\">Ciencias Sociales y Humanidades</option>\n");
      out.write("                            <option class=\"optionHome\" value=\"Ciencias de la Ingenieria\">Ciencias de la Ingenieria</option>\n");
      out.write("                            <option class=\"optionHome\" value=\"Agropecuarias y de Alimentos\">Agropecuarias y de Alimentos</option>\n");
      out.write("                            <option class=\"optionHome\" value=\"Divulgacion Cientifica\">Divulgacion Cientifica</option>\n");
      out.write("                            <option class=\"optionHome\" value=\"Medio Ambiente\">Medio Ambiente</option>\n");
      out.write("                            <option class=\"optionHome\" value=\"Mecatronica\">Mecatronica</option>\n");
      out.write("                            <option class=\"optionHome\" value=\"Ciencias de los Materiales\">Ciencias de los Materiales</option>\n");
      out.write("                            <option class=\"optionHome\" value=\"Biología\">Biología</option>\n");
      out.write("                            <option class=\"optionHome\" value=\"Computación y Software\">Computación y Software</option>\n");
      out.write("                        </select>\n");
      out.write("                        </div>\n");
      out.write("                    </article>          \n");
      out.write("                </div>\n");
      out.write("                <div class=\" row\" style=\"display: -webkit-flex; flex-wrap: wrap;\">\n");
      out.write("                    \n");
      out.write("                    <div class=\"col-xs-12  col-sm-12 col-md-12 col-lg-12 margen\" style=\" background: grey\">\n");
      out.write("                        <select class=\"combobox form-control\" id=\"NumeroIntegrantes\" name=\"NumeroIntegrantes\" style=\"margin: 0 auto;\" onchange=\"myFunction()\">\n");
      out.write("                            <option value=\"0\">Seleccione el numero de integrantes</option>\n");
      out.write("                            <option class=\"optionHome\" value=\"1\">1</option>\n");
      out.write("                            <option class=\"optionHome\" value=\"2\">2</option>\n");
      out.write("                            <option class=\"optionHome\" value=\"3\">3</option>\n");
      out.write("                            <option class=\"optionHome\" value=\"4\">4</option>\n");
      out.write("                            <option class=\"optionHome\" value=\"5\">5</option>\n");
      out.write("                        </select>\n");
      out.write("                        <br/>\n");
      out.write("                        <input class=\"form-control form-control-lg\" type=\"text\" id=\"Int1\" name=\"Int1\" placeholder=\"Profesionista requerido num. 1\" style=\"display: none\">\n");
      out.write("                        <input class=\"form-control form-control-lg\" type=\"text\" id=\"Int2\" name=\"Int2\"  placeholder=\"Profesionista requerido num. 2\" style=\"display: none\">\n");
      out.write("                        <input class=\"form-control form-control-lg\" type=\"text\" id=\"Int3\" name=\"Int3\"  placeholder=\"Profesionista requerido num. 3\" style=\"display: none\">\n");
      out.write("                        <input class=\"form-control form-control-lg\" type=\"text\" id=\"Int4\" name=\"Int4\"  placeholder=\"Profesionista requerido num. 4\" style=\"display: none\">\n");
      out.write("                        <input class=\"form-control form-control-lg\" type=\"text\" id=\"Int5\" name=\"Int5\"  placeholder=\"Profesionista requerido num. 5\" style=\"display: none\">\n");
      out.write("                        <script>\n");
      out.write("                            function myFunction() {\n");
      out.write("                                var numIn = document.getElementById(\"NumeroIntegrantes\");\n");
      out.write("                                var val = numIn.options[numIn.selectedIndex].value;\n");
      out.write("                                //Creamos un nodo de texto que agregaremos al div.\n");
      out.write("                                /*alert(val);*/\n");
      out.write("                                for (var i = 1, max = 5; i <= max; i++) {\n");
      out.write("                                    var text = document.getElementById(\"Int\" + i);\n");
      out.write("                                    text.style.display = \"none\";\n");
      out.write("                                }\n");
      out.write("                                for (var i = 1, max = val; i <= max; i++) {\n");
      out.write("                                    var text = document.getElementById(\"Int\" + i);\n");
      out.write("                                    text.style.display = \"block\";\n");
      out.write("                                }\n");
      out.write("                            }\n");
      out.write("                        </script>\n");
      out.write("                    </div>   \n");
      out.write("                </div>\n");
      out.write("                <div class=\" row\" style=\"display: -webkit-flex; flex-wrap: wrap;\">\n");
      out.write("                    <article class=\"col-xs-12  col-sm-7 col-md-7 col-lg-7 margen\">\n");
      out.write("                        <input class=\"form-control form-control-lg\" placeholder=\"Escribe la idea de tu proyecto\" type=\"text\" id=\"IdeaProyecto\" name=\"IdeaProyecto\" required/>\n");
      out.write("                    </article>\n");
      out.write("                    <article class=\"col-xs-12  col-sm-5 col-md-5 col-lg-5 margen\">\n");
      out.write("                      \n");
      out.write("                        <input class=\"form-control\"  placeholder=\"Donacion necesaria\"type=\"number\" id=\"Monto_Donacion\" name=\"MontoDonacion\" required/>\n");
      out.write("                    </article>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                \n");
      out.write("                \n");
      out.write("               \n");
      out.write("                <input  class=\"btn btn-primary btn-lg btn-block\" type=\"submit\" name=\"Guardar\" id=\"Enviar\" value=\"GUARDAR PROYECTO\"> \n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("         <script>\n");
      out.write("          function archivo(evt) {\n");
      out.write("              var files = evt.target.files; // FileList object\n");
      out.write("\n");
      out.write("              // Obtenemos la imagen del campo \"file\".\n");
      out.write("              for (var i = 0, f; f = files[i]; i++) {\n");
      out.write("                //Solo admitimos imágenes.\n");
      out.write("                if (!f.type.match('image.*')) {\n");
      out.write("                    continue;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                var reader = new FileReader();\n");
      out.write("                reader.onload = (function(theFile) {\n");
      out.write("                    return function(e) {\n");
      out.write("                      // Insertamos la imagen\n");
      out.write("                     document.getElementById(\"list\").innerHTML = ['<img class=\"thumbnail  img-responsive\" src=\"', e.target.result,'\" title=\"', escape(theFile.name), '\" style=\" width:80%\"/>'].join('');\n");
      out.write("                    };\n");
      out.write("                })(f);\n");
      out.write("\n");
      out.write("                reader.readAsDataURL(f);\n");
      out.write("              }\n");
      out.write("          }\n");
      out.write("\n");
      out.write("          document.getElementById('imagen').addEventListener('change', archivo, false);\n");
      out.write("    </script>\n");
      out.write("   \n");
      out.write("        \n");
      out.write("    <script src=\"Disegno/js/jquery.js\"></script>\n");
      out.write("    <script src=\"Disegno/js/bootstrap.js\"></script>\n");
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
