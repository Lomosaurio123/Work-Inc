package org.apache.jsp.Usuarios;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Prueba_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\" >\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <title>Dynamic Single Page Login + Sign Up</title>\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,600' rel='stylesheet' type='text/css'>\n");
      out.write("  \n");
      out.write("  \n");
      out.write("<link rel=\"stylesheet\" href=\"../Disegno/CSSLogin/style.css\">\n");
      out.write("\n");
      out.write("  \n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("  <div id=\"back\">\n");
      out.write("  <canvas id=\"canvas\" class=\"canvas-back\"></canvas>\n");
      out.write("  <div class=\"backRight\">    \n");
      out.write("  </div>\n");
      out.write("  <div class=\"backLeft\">\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div id=\"slideBox\">\n");
      out.write("  <div class=\"topLayer\">\n");
      out.write("    <div class=\"left\">\n");
      out.write("      <div class=\"content\">\n");
      out.write("        <h2>Sign Up</h2>\n");
      out.write("        <form id=\"form-signup\" method=\"post\" onsubmit=\"return false;\">\n");
      out.write("          <div class=\"form-element form-stack\">\n");
      out.write("            <label for=\"email\" class=\"form-label\">Email</label>\n");
      out.write("            <input id=\"email\" type=\"email\" name=\"email\">\n");
      out.write("          </div>\n");
      out.write("          <div class=\"form-element form-stack\">\n");
      out.write("            <label for=\"username-signup\" class=\"form-label\">Username</label>\n");
      out.write("            <input id=\"username-signup\" type=\"text\" name=\"username\">\n");
      out.write("          </div>\n");
      out.write("          <div class=\"form-element form-stack\">\n");
      out.write("            <label for=\"password-signup\" class=\"form-label\">Password</label>\n");
      out.write("            <input id=\"password-signup\" type=\"password\" name=\"password\">\n");
      out.write("          </div>\n");
      out.write("          <div class=\"form-element form-checkbox\">\n");
      out.write("            <input id=\"confirm-terms\" type=\"checkbox\" name=\"confirm\" value=\"yes\" class=\"checkbox\">\n");
      out.write("            <label for=\"confirm-terms\">I agree to the <a href=\"#\">Terms of Service</a> and <a href=\"#\">Privacy Policy</a></label>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"form-element form-submit\">\n");
      out.write("            <button id=\"signUp\" class=\"signup\" type=\"submit\" name=\"signup\">Sign up</button>\n");
      out.write("            <button id=\"goLeft\" class=\"signup off\">Log In</button> \n");
      out.write("          </div>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"right\">\n");
      out.write("      <div class=\"content\">\n");
      out.write("        <h2>Login</h2>\n");
      out.write("        <form id=\"form-login\" method=\"post\" onsubmit=\"return false;\">\n");
      out.write("          <div class=\"form-element form-stack\">\n");
      out.write("            <label for=\"username-login\" class=\"form-label\">Username</label>\n");
      out.write("            <input id=\"username-login\" type=\"text\" name=\"username\">\n");
      out.write("          </div>\n");
      out.write("          <div class=\"form-element form-stack\">\n");
      out.write("            <label for=\"password-login\" class=\"form-label\">Password</label>\n");
      out.write("            <input id=\"password-login\" type=\"password\" name=\"password\">\n");
      out.write("          </div>\n");
      out.write("          <div class=\"form-element form-submit\">\n");
      out.write("            <button id=\"logIn\" class=\"login\" type=\"submit\" name=\"login\">Log In</button>\n");
      out.write("            <button id=\"goRight\" class=\"login off\" name=\"signup\">Sign Up</button>\n");
      out.write("          </div>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js'></script>\n");
      out.write("<script src='https://cdnjs.cloudflare.com/ajax/libs/paper.js/0.11.3/paper-full.min.js'></script>\n");
      out.write("\n");
      out.write("  \n");
      out.write("\n");
      out.write("<script  src=\"../Disegno/jsLogin/index.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
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
