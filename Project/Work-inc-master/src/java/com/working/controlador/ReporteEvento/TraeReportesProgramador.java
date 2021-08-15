
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


@WebServlet(name = "TraeReportesProgramador", urlPatterns = {"/TraeReportesProgramador"})
public class TraeReportesProgramador extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TraeReportesProgramador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TraeReportesProgramador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String CorreoIngeniero= UsuarioCreador.getCorreo();
            ReporteEventoDaoImpl TraerReporte = new ReporteEventoDaoImpl();
            List<ReporteEvento> TodosReportes = TraerReporte.traerProyectoGerente(2,CorreoIngeniero);
              request.setAttribute("TodosRepAsignadosIng", TodosReportes);
            request.getRequestDispatcher("ReporteEventos/ResolverReporteEvento.jsp").forward(request, response);
        
        
        
        
        
        
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
