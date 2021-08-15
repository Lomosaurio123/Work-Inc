package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Base64;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import com.working.modelos.Noticia;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>WorkInc</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n");
      out.write("        <link href=\"Disegno/CSS/index.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"Disegno/CSS/animate.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"Disegno/icon/style.css\">\n");
      out.write("         <script type=\"text/javascript\" src=\"Validacion/ValidaAlta.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.2/css/all.css\" integrity=\"sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    ");

            List<Noticia> todaslasnoticias;
            todaslasnoticias = (List<Noticia>)request.getAttribute("Todos");
            int numerodenoticias=0;
            ArrayList<Noticia> NoticiasTodas= new ArrayList<Noticia>();
            Noticia no;
            
           /* for(Noticia n : todaslasnoticias){
               String titulo=n.getTitulo();
               String noticia=n.getNoticia();
               Blob imagen= n.getImagen();
               String Categoria = n.getCategoria();
               
               no= new Noticia(titulo, noticia, imagen, Categoria);
               NoticiasTodas.add(n);
               numerodenoticias=numerodenoticias+1;
            }*/
        
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <header class=\"menuP\">\n");
      out.write("            <input type=\"checkbox\" id=\"ocu\">\n");
      out.write("            <label for=\"ocu\"><img src=\"RecursosGraficos/Imagenes/menu.png\" alt=\"Menu\"/></label>\n");
      out.write("            <nav class=\"menu\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"#\" id=\"menu\" class=\"wow zoomIn\" data-wow-duration=\"2s\" data-wow-delay=\"1s\">Ayuda</a></li>\n");
      out.write("                    <li><a href=\"#noticias\" id=\"menu\" class=\"wow zoomIn\" data-wow-duration=\"2s\" data-wow-delay=\"1s\">Noticias</a></li>\n");
      out.write("                    <li><a href=\"#conocenos\" id=\"menu\" class=\"wow zoomIn\" data-wow-duration=\"2s\" data-wow-delay=\"1s\">Conócenos</a></li>\n");
      out.write("                    <li><a href=\"#\" id=\"menu\" class=\"wow zoomIn\" data-wow-duration=\"2s\" data-wow-delay=\"1s\">¡Juega!</a></li>\n");
      out.write("                    <li><a href=\"Login\" id=\"menu2\" class=\"wow zoomIn\" data-wow-duration=\"2s\" data-wow-delay=\"1s\">Iniciar Sesión</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("        <header class=\"header content\">\n");
      out.write("            <div class=\"header-video\">\n");
      out.write("                <video src=\"RecursosGraficos/Videos/friends.mp4\" autoplay muted loop id=\"video\"></video>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"header-overlay\"></div>\n");
      out.write("            <div class=\"header-content\">\n");
      out.write("                <h1 class=\"wow jackInTheBox\" data-wow-duration=\"2s\" data-wow-delay=\"1s\">Work-Inc</h1>\n");
      out.write("                <p class=\"wow fadeInLeft\" data-wow-duration=\"2s\" data-wow-delay=\"1s\">Si la vida te da limones... Haz un proyecto.</p>\n");
      out.write("                <a href=\"#\" id=\"reg\" class=\"btn wow fadeInRightBig\" data-wow-duration=\"2s\" data-wow-delay=\"1s\">Registrate.</a>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"conocenos\" class=\"main wow rubberBand\" data-wow-duration=\"2s\" data-wow-delay=\"1s\">\n");
      out.write("            <div class=\"slides\">\n");
      out.write("                <img src=\"RecursosGraficos/Imagenes/ques.png\" alt=\"Que es Work-Inc?\"/>\n");
      out.write("                <img src=\"RecursosGraficos/Imagenes/porque.png\" alt=\"Por que Work-Inc?\"/>\n");
      out.write("                <img src=\"RecursosGraficos/Imagenes/axissomos.png\" alt=\"Informacion Axis\"/>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <br><br>\n");
      out.write("        \n");
      out.write("        <div class=\"container2\" id=\"noticias\">\n");
      out.write("            ");

                for(int i=0; i<=numerodenoticias-1; i++){
            
      out.write("\n");
      out.write("            ");

                Noticia ni= NoticiasTodas.get(i);
                
                ByteArrayOutputStream baos= new ByteArrayOutputStream();
                    byte[] buf= new byte[1024];
                    Blob blob = ni.getImagen();
                    InputStream in= blob.getBinaryStream();
                    int n =0;
                    while((n=in.read(buf))>=0){
                        baos.write(buf,0,n);
                    }
                    in.close();
                    byte[] bytes = baos.toByteArray();
                    byte[] encodedBytes= Base64.getEncoder().encode(bytes);
                    String base64Encoded = new String(encodedBytes, "UTF-8");
            
      out.write("\n");
      out.write("            <div class=\"column wow fadeInLeftBig\" data-wow-duration=\"2s\">\n");
      out.write("                <div class=\"post-module\">\n");
      out.write("                    <div class=\"thumbnail\">\n");
      out.write("                        <div class=\"date\">\n");
      out.write("                            <div class=\"day\">18</div>\n");
      out.write("                            <div class=\"month\">Mayo</div>\n");
      out.write("                        </div>");
out.println("<div><img src='data:image/jpg;base64,"+base64Encoded+"' alt='Imagen ID:' ></div>");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"post-content\">\n");
      out.write("                        <div class=\"category\">Foto</div>\n");
      out.write("                        <h1 class=\"title\">");
out.print(ni.getTitulo());
      out.write("</h1>\n");
      out.write("                        <p class=\"description\">");
out.print(ni.getNoticia());
      out.write("</p>\n");
      out.write("                        <div class=\"post-meta\">\n");
      out.write("                            <span class=\"comments\"><i class=\"fas fa-book\"></i><a href=\"#\"> Leer más...</a></span>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <br><br>\n");
      out.write("\n");
      out.write("        <footer>\n");
      out.write("            <div class=\"footer-copy-redes\">\n");
      out.write("                <div class=\"main-copy-redes\">\n");
      out.write("                    <div class=\"footer-copy wow heartBeat\" data-wow-duration=\"2s\" data-wow-delay=\"1s\">\n");
      out.write("                        &copy; 2019, Todos los derechos reservados - | AXIS |.\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"footer-redes\">\n");
      out.write("                        <a href=\"#\" class=\"fas fa-envelope wow rotateInUpLeft\" data-wow-duration=\"2s\" data-wow-delay=\"1s\"></a>\n");
      out.write("                        <a href=\"#\" class=\"fas fa-phone wow rotateInUpLeft\" data-wow-duration=\"2s\" data-wow-delay=\"1s\"></a>\n");
      out.write("                        <a href=\"#\" class=\"far fa-registered wow rotateInUpLeft\" data-wow-duration=\"2s\" data-wow-delay=\"1s\"></a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"openModal\" class=\"modalDialog\">\n");
      out.write("            <div>\n");
      out.write("\n");
      out.write("                <div id=\"menuF\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a  class=\"active\">Iniciar Sesión</a></li>\n");
      out.write("                        <li><a >Registro</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"formularios\">\n");
      out.write("                    <form action=\"Login\" method=\"post\">\n");
      out.write("                        <p>Usuario:</p>\n");
      out.write("                        <div class=\"fiel-container\">\n");
      out.write("                            <i class=\"fas fa-id-card-alt\" aria-hidden=\"true\"></i>\n");
      out.write("                            <input type=\"text\" class=\"field\" id=\"usuario\" name=\"usuario\"/>\n");
      out.write("                        </div>\n");
      out.write("                        <p>Contraseña:</p>\n");
      out.write("                        <div class=\"fiel-container\">\n");
      out.write("                            <i class=\"fas fa-lock\" aria-hidden=\"true\"></i>\n");
      out.write("                            <input type=\"password\" class=\"field\" id=\"contra\" name=\"contra\"/>\n");
      out.write("                        </div>\n");
      out.write("                        <p class=\"center-content\">\n");
      out.write("                            <input type=\"submit\" class=\"btn2\"  name=\"ingresar\" id=\"ingresar\" value=\"Ingresar\"/>\n");
      out.write("                        </p>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                    <form  action=\"AltaUsuario\" method=\"post\" onsubmit=\" return enviar();\" id=\"form_register\">\n");
      out.write("\n");
      out.write("                        <div class=\"columns\">\n");
      out.write("                            <div class=\"field-container\">\n");
      out.write("                                <p> Nombre:</p>\n");
      out.write("                                <i class=\"fa fa-user-circle fa-lg\" aria-hidden=\"true\"></i>\t\n");
      out.write("                                <input type=\"text\" class=\"field\" name=\"nombre\"  id=\"nombre\" pattern=\"[A-Za-z]{1,20}\" title=\"Este campo debe de llenarse unicamente con letras\" placeholder=\"Silvia\"  onkeypress=\"return sololetras(event)\" required  > <br/>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"field-container\">\n");
      out.write("                                <p> Apellido Paterno:</p>\n");
      out.write("                                <i class=\"fa fa-user-circle fa-lg\" aria-hidden=\"true\" ></i>\t\n");
      out.write("                                <input type=\"text\" class=\"field\" placeholder=\"Rivas\" name=\"apat\" id=\"apat\" pattern=\"[A-Za-z]{1,20}\" title=\"Este campo debe de llenarse unicamente con letras\" onkeypress=\"return sololetras(event)\" required > <br/>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"field-container\">\n");
      out.write("                                <p> Apellido Materno:</p>\n");
      out.write("                                <i class=\"fa fa-user-circle fa-lg\" aria-hidden=\"true\"></i>\t\n");
      out.write("                                <input type=\"text\" class=\"field\" placeholder=\"González\" name=\"amat\" id=\"amat\" pattern=\"[A-Za-z]{1,20}\" title=\"Este campo debe de llenarse unicamente con letras\" onkeypress=\"return sololetras(event)\" required > <br/>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <p>Correo electrónico:</p>\n");
      out.write("                        <div class=\"field-container\">\n");
      out.write("                            <i class=\"fas fa-envelope\" aria-hidden=\"true\"></i>\t\n");
      out.write("                            <input type=\"text\" class=\"field\" placeholder=\"user@example.com\" name=\"correo\" id=\"correo\" required> <br/>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <p>Contraseña:</p>\n");
      out.write("                        <div class=\"field-container\">\n");
      out.write("                            <i class=\"fa fa-key fa-lg\" aria-hidden=\"true\"></i>\t\n");
      out.write("                            <input type=\"password\" class=\"field\" placeholder=\"*******\" name=\"contra\" id=\"contra\" required/> <br/>\n");
      out.write("                        </div>\n");
      out.write("                        <p>Confirma contraseña:</p>\n");
      out.write("                        <div class=\"field-container\">\n");
      out.write("                            <i class=\"fa fa-key fa-lg\" aria-hidden=\"true\"></i>\t\n");
      out.write("                            <input type=\"password\" class=\"field\" placeholder=\"*******\" name=\"confircontra\" id=\"confircontra\" required/> <br/>\n");
      out.write("                        </div>\n");
      out.write("                        <p>Genero:</p>\n");
      out.write("                        <div class=\"fiel-container\" id=\"radio\">\t\n");
      out.write("                            <input type=\"radio\" class=\"field\" value=\"Femenino\" id=\"Femenino\" name=\"genero\"     required>\n");
      out.write("                            <label for=\"Femenino\">Femenino </label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"fiel-container\" id=\"radio\">\t\n");
      out.write("                            <input type=\"radio\" class=\"field\" value=\"Masculino\" id=\"Masculino\" name=\"genero\"      required>\n");
      out.write("                            <label for=\"Masculino\">Masculino </label>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"columns\">\n");
      out.write("\n");
      out.write("                            <div class=\"field-container\">\n");
      out.write("                                <p> Cédula Profesional:</p>\n");
      out.write("                                <i class=\"fas fa-graduation-cap\" aria-hidden=\"true\"></i>\t\n");
      out.write("                                <input type=\"text\" class=\"field\" placeholder=\"12345678\" name=\"cedula\" id=\"cedula\"  pattern=\"[0-9]{1,8}\" title=\"Este campo debe de llenarse unicamente con numeros\" onkeypress=\"return solonumeros(event)\"     required> <br/>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"field-container\">\n");
      out.write("                                <p> Edad:</p>\n");
      out.write("                                <i class=\"fas fa-hourglass\" aria-hidden=\"true\"></i>\t\n");
      out.write("                                <input type=\"text\" class=\"field\" name=\"edad\" id=\"edad\"  placeholder=\"25\" pattern=\"[0-9]{1,2}\" title=\"Este campo debe de llenarse unicamente con numeros\" onkeypress=\"return solonumeros(event)\" required > <br/>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"field-container\">\n");
      out.write("                                <p> Teléfono:</p>\n");
      out.write("                                <i class=\"fa fa-phone fa-lg\" aria-hidden=\"true\"></i>\t\n");
      out.write("                                <input type=\"text\" class=\"field\" placeholder=\"55...\"  name=\"telefono\" id=\"telefono\" pattern=\"[0-9]{1,10}\" title=\"Este campo debe de llenarse unicamente con numeros\" onkeypress=\"return solonumeros(event)\"   required> <br/>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <p class=\"center-content\">\n");
      out.write("                            <input type=\"submit\" class=\"btn2\" name=\"guarda\" id=\"guarda\" value=\"GUARDAR INFORMACION\">\n");
      out.write("                        </p>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <a href=\"#close\" class=\"close\">Cerrar</a>\n");
      out.write("                <br><br>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-1.9.1.min.js\"></script>\n");
      out.write("        <script src=\"Disegno/js/jquery.slides.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"Disegno/js/wow.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("            $(function () {\n");
      out.write("                $(\".slides\").slidesjs({\n");
      out.write("                    play: {\n");
      out.write("                        active: true,\n");
      out.write("                        effect: \"slide\",\n");
      out.write("                        interval: 3000,\n");
      out.write("                        auto: true,\n");
      out.write("                        swap: true,\n");
      out.write("                        pauseOnHover: false,\n");
      out.write("                        restartDelay: 2500\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("\n");
      out.write("\n");
      out.write("            $(document).ready(function () {\n");
      out.write("\n");
      out.write("                var flag = false;\n");
      out.write("                var scroll;\n");
      out.write("\n");
      out.write("                $(window).scroll(function () {\n");
      out.write("                    scroll = $(window).scrollTop();\n");
      out.write("                    if (scroll > 120) {\n");
      out.write("                        if (!flag) {\n");
      out.write("                            $(\".menuP\").css({\"background-color\": \"rgb(54,156,197)\"});\n");
      out.write("                            $(\".menu\").css({\"border-bottom\": \"1px solid #fff\"});\n");
      out.write("\n");
      out.write("                            flag = true;\n");
      out.write("                        }\n");
      out.write("                    } else {\n");
      out.write("                        if (flag) {\n");
      out.write("                            $(\".menuP\").css({\"background-color\": \"transparent\"});\n");
      out.write("                            $(\".menu\").css({\"border-bottom\": \"transparent\"});\n");
      out.write("\n");
      out.write("                            flag = false;\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            $(window).load(function () {\n");
      out.write("                $('.post-module').hover(function () {\n");
      out.write("                    $(this).find('.description').stop().animate({\n");
      out.write("                        height: \"toggle\",\n");
      out.write("                        opacity: \"toggle\"\n");
      out.write("                    }, 300);\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            $(function () {\n");
      out.write("                $(\"#menuF li\").on(\"click\", function () {\n");
      out.write("                    var i = $(this).index();\n");
      out.write("                    $(\"#formularios form\").hide();\n");
      out.write("                    $(\"#formularios form\").eq(i).show();\n");
      out.write("                    $(\"#menuF li a\").removeClass(\"active\").attr('href', 'http://localhost:8080/WORK-INC-WODY2/ConsultarNoticias?#openModal');\n");
      out.write("                    $(this).find(\"#menuF\").addClass(\"active\").attr('href', 'http://localhost:8080/WORK-INC-WODY2/ConsultarNoticias?#openModal');\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("            $(function () {\n");
      out.write("                $(\"#reg\").on(\"click\", function () {\n");
      out.write("                    $(\"#formularios form\").hide();\n");
      out.write("                    $(\"#form_register\").show();\n");
      out.write("                    $(\"#reg\").attr('href', 'http://localhost:8080/WORK-INC-WODY2/ConsultarNoticias?#openModal');\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("        <script>\n");
      out.write("            new WOW().init();\n");
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
