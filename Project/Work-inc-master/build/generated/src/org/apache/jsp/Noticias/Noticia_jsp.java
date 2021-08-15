package org.apache.jsp.Noticias;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Base64;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public final class Noticia_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\" >\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"viewport\" content=\"initial-scale=1\">\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Noticias</title>\n");
      out.write("        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid mt-4\">\n");
      out.write("            <ul class=\"nav nav-tabs\" id=\"myTab\" role=\"tablist\">\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link active\" id=\"profile-tab\" data-toggle=\"tab\" href=\"#profile\" role=\"tab\" aria-controls=\"profile\" aria-selected=\"true\">Subir</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" id=\"notify-tab\" data-toggle=\"tab\" href=\"#notify\" role=\"tab\" aria-controls=\"notify\" aria-selected=\"true\">Modificar</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" id=\"history-tab\" data-toggle=\"tab\" href=\"#history\" role=\"tab\" aria-controls=\"notify\" aria-selected=\"true\">Historial</a>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("            <div class=\"tab-content\" id=\"myTabContent\">\n");
      out.write("                <form action=\"../guardaNoticia\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                <div class=\"tab-pane fade show active\" id=\"profile\" role=\"tabpanel\" aria-labbelledby=\"profile-tab\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col\"></div>\n");
      out.write("                        <div class=\"col-lg-6 col-md-8 col-sm-12 pt-4\">\n");
      out.write("                            <h4> Noticias</h4>\n");
      out.write("                            <hr/>\n");
      out.write("                            <div class=\"form-row\">\n");
      out.write("                                <div class=\"form-group col-lg-14 col-md-12\">\n");
      out.write("                                    <label for=\"titulo\">Titulo</label>\n");
      out.write("                                    <input class=\"form-control\" id=\"titulo\" name=\"titulo\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-lg-14 col-md-12\">\n");
      out.write("                                    <label for=\"Noticia\">Noticia</label>\n");
      out.write("                                    <textarea class=\"form-control\" name=\"Noticia\" id=\"Noticia\" rows=\"3\"></textarea>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-lg-14 col-md-12\">\n");
      out.write("                                    <label for=\"imagen\">Subir Imagen</label>\n");
      out.write("                                    <input type=\"file\" class=\"form-control-file\" id=\"imagen\" name=\"imagen\">\n");
      out.write("                                </div>\n");
      out.write("                                \n");
      out.write("                                <button class=\"btn btn-primary btn-block\">Save</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("  \n");
      out.write("                        <div class=\"col\"></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                </form>\n");
      out.write("                <div class=\"tab-pane fade\" id=\"notify\" role=\"tabpanel\" aria-labelledby=\"notify-tab\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col\"></div>\n");
      out.write("                        <div class=\"col-lg-6 col-md-8 col-sm-12 pt-4\">\n");
      out.write("                            <h4>Notifications For</h4>\n");
      out.write("                            <select id=\"nonsig\" class=\"form-control\">\n");
      out.write("                                <option>51618563</option>\n");
      out.write("                                <option>56156432</option>\n");
      out.write("                            </select>\n");
      out.write("                            <hr />\n");
      out.write("                            <div class=\"form-row\">\n");
      out.write("                                <div class=\"col-lg-6 col-sm-12 form-group\">\n");
      out.write("                                    <label for=\"invoice\">When I receive an invoice: </label>\n");
      out.write("                                    <select id=\"invoice\" class=\"form-control\">\n");
      out.write("                                        <option>Send an email</option>\n");
      out.write("                                        <option>Do not email me</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-6 col-sm-12 form-group\">\n");
      out.write("                                    <label for=\"invoice\">When I receive a chargeback: </label>\n");
      out.write("                                    <select id=\"invoice\" class=\"form-control\">\n");
      out.write("                                        <option>Send an email</option>\n");
      out.write("                                        <option>Do not email me</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-6 col-sm-12 form-group\">\n");
      out.write("                                    <label for=\"invoice\">When I receive a G86: </label>\n");
      out.write("                                    <select id=\"invoice\" class=\"form-control\">\n");
      out.write("                                        <option>Send an email</option>\n");
      out.write("                                        <option>Do not email me</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-6 col-sm-12 form-group\">\n");
      out.write("                                    <label for=\"invoice\">When I receive a FleetHQ Call: </label>\n");
      out.write("                                    <select id=\"invoice\" class=\"form-control\">\n");
      out.write("                                        <option>Send an email</option>\n");
      out.write("                                        <option>Do not email me</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-6 col-sm-12 form-group\">\n");
      out.write("                                    <label for=\"invoice\">Documents on hold older than </label>\n");
      out.write("                                    <select id=\"invoice\" class=\"form-control\">\n");
      out.write("                                        <option>Do not email me</option>\n");
      out.write("                                        <option>1 Day</option>\n");
      out.write("                                        <option>5 Days</option>\n");
      out.write("                                        <option>14 Days</option>\n");
      out.write("                                        <option>1 Month</option>\n");
      out.write("                                        <option>3 Months</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-6 col-sm-12 form-group\">\n");
      out.write("                                    <label for=\"invoice\">When news is released</label>\n");
      out.write("                                    <select id=\"invoice\" class=\"form-control\">\n");
      out.write("                                        <option>Send an email</option>\n");
      out.write("                                        <option>Do not email me</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col\"></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"tab-pane fade\" id=\"history\" role=\"tabpanel\" aria-labelledby=\"history-tab\">\n");
      out.write("                    <div class=\"row my-4\">\n");
      out.write("                        <div class=\"col\"></div>\n");
      out.write("                        <div class=\"col-lg-8 col-md-10 col-sm-12\">\n");
      out.write("                            <table class=\"table\">\n");
      out.write("                                <thead class=\"thead-dark\">\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th scope=\"col\">Time</th>\n");
      out.write("                                        <th scope=\"col\">Action</th>\n");
      out.write("                                    </tr>\n");
      out.write("                                </thead>\n");
      out.write("                                <tbody>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>Tue Jan 08 2019</td>\n");
      out.write("                                        <td>Login</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>Tue Jan 08 2019</td>\n");
      out.write("                                        <td>Invalid Login</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>Tue Jan 08 2019</td>\n");
      out.write("                                        <td>Password Change</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>Tue Jan 08 2019</td>\n");
      out.write("                                        <td>Submitted document 15435</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>Tue Jan 08 2019</td>\n");
      out.write("                                        <td>Created document 15435</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>Tue Jan 08 2019</td>\n");
      out.write("                                        <td>Login</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>Tue Jan 08 2019</td>\n");
      out.write("                                        <td>Submitted claim C975432</td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col\"></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>\n");
      out.write("        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js'></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
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
