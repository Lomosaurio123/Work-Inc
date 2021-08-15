
package com.working.controlador.ReporteEvento;

import com.working.dao.ReporteEventoDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AsignarMantenimiento", urlPatterns = {"/AsignarMantenimiento"})
public class AsignarMantenimiento extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AsignarMantenimiento</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AsignarMantenimiento at " + request.getContextPath() + "</h1>");
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
        String Foliomantenimiento = request.getParameter("foliomantenimiento");
        ReporteEventoDaoImpl AsignarMantenimiento = new ReporteEventoDaoImpl();
        boolean AsignacionExitosa = AsignarMantenimiento.AsignarReporteMantenimiento(Foliomantenimiento);
        
        if(AsignacionExitosa){
             out.println("<script type=\"text/javascript\">");
            out.println("alert('Asignacion a mantenimiento exitosa');");
            out.println("</script>");
           response.sendRedirect("TraeReportesProgramador");
            
        }else{
             out.println("<script type=\"text/javascript\">");
            out.println("alert('No se ha podido realizar la asignacion a mantenimiento');");
            out.println("</script>");
           response.sendRedirect("TraeReportesProgramador");
            
        }
        
        
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
