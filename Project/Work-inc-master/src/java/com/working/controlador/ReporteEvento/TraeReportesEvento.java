
package com.working.controlador.ReporteEvento;

import com.working.dao.ReporteEventoDaoImpl;
import com.working.modelos.ReporteEvento;
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


@WebServlet(name = "TraeReportesEvento", urlPatterns = {"/TraeReportesEvento"})
public class TraeReportesEvento extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String CorreoOperador= UsuarioCreador.getCorreo();
            ReporteEventoDaoImpl TraerReporte = new ReporteEventoDaoImpl();
            
             List<ReporteEvento> TodosReportes = TraerReporte.traerProyecto(0, CorreoOperador);
            request.setAttribute("TodosRep", TodosReportes);
            request.getRequestDispatcher("ReporteEventos/GenerarReporteEvento.jsp").forward(request, response);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String CorreoOperador= UsuarioCreador.getCorreo();
            ReporteEventoDaoImpl TraerReporte = new ReporteEventoDaoImpl();
            
             List<ReporteEvento> TodosReportes = TraerReporte.traerProyecto(0, CorreoOperador);
            request.setAttribute("TodosRep", TodosReportes);
            request.getRequestDispatcher("ReporteEventos/GenerarReporteEvento.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String CorreoOperador= UsuarioCreador.getCorreo();
            ReporteEventoDaoImpl TraerReporte = new ReporteEventoDaoImpl();
            
             List<ReporteEvento> TodosReportes = TraerReporte.traerProyecto(0, CorreoOperador);
            request.setAttribute("TodosRep", TodosReportes);
            request.getRequestDispatcher("ReporteEventos/GenerarReporteEvento.jsp").forward(request, response);
            
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
