
package com.working.controlador.ReporteMantenimiento;

import com.working.dao.ReporteMantenimientoDaoImpl;
import com.working.modelos.ReporteMantenimiento;
import com.working.modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "TraeReportesMantenimiento", urlPatterns = {"/TraeReportesMantenimiento"})
public class TraeReportesMantenimiento extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TraeReportesMantenimiento</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TraeReportesMantenimiento at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String CorreoOperador= UsuarioCreador.getCorreo();
            ReporteMantenimientoDaoImpl TraeRepMan =new ReporteMantenimientoDaoImpl();
            
            List<ReporteMantenimiento> TodosReportesMant =TraeRepMan.traerReporteMantenimiento(0, CorreoOperador);
            
            request.setAttribute("TodosRepMant", TodosReportesMant);
            request.getRequestDispatcher("ReporteMantenimiento/DespRepMan.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         
         HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String CorreoOperador= UsuarioCreador.getCorreo();
            ReporteMantenimientoDaoImpl TraeRepMan =new ReporteMantenimientoDaoImpl();
            
            List<ReporteMantenimiento> TodosReportesMant =TraeRepMan.traerReporteMantenimiento(0, CorreoOperador);
            
            request.setAttribute("TodosRepMant", TodosReportesMant);
            request.getRequestDispatcher("ReporteMantenimiento/DespRepMan.jsp").forward(request, response);
        
        
        
        
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
