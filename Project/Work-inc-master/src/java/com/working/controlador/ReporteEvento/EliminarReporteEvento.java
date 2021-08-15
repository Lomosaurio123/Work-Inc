
package com.working.controlador.ReporteEvento;

import com.working.dao.ReporteEventoDaoImpl;
import com.working.modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "EliminarReporteEvento", urlPatterns = {"/EliminarReporteEvento"})
public class EliminarReporteEvento extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EliminarReporteEvento</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EliminarReporteEvento at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String CorreoGerente= UsuarioCreador.getCorreo();
            String Folio = request.getParameter("FolioEven");
            ReporteEventoDaoImpl EliminaRepEven = new ReporteEventoDaoImpl();
            boolean EliminadoCorrecto = EliminaRepEven.EliminarReporteEven(Folio, CorreoGerente);
            
            if(EliminadoCorrecto){
                out.println("<script type=\"text/javascript\">");
            out.println("alert('Reporte eliminado correctamente');");
            out.println("</script>");
           response.sendRedirect("TraeReportesGerente");
                
            }else{
                 out.println("<script type=\"text/javascript\">");
            out.println("alert('No se pudo eliminar el reporte');");
            out.println("</script>");
           response.sendRedirect("TraeReportesGerente");
                
            }
            
            
            
            
            
            
            
            
            
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
