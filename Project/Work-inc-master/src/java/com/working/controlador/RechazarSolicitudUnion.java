
package com.working.controlador;

import com.working.dao.ProyectoDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "RechazarSolicitudUnion", urlPatterns = {"/RechazarSolicitudUnion"})
public class RechazarSolicitudUnion extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RechazarSolicitudUnion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RechazarSolicitudUnion at " + request.getContextPath() + "</h1>");
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
        
        String CorreoUsr= request.getParameter("correo");
        int InfoProyecto = Integer.parseInt(request.getParameter("infoproject"));
        
        ProyectoDaoImpl MetodoBorrarSolictud = new ProyectoDaoImpl();
        boolean RechazoExitoso = MetodoBorrarSolictud.RechazarSolicitudUnion(CorreoUsr, InfoProyecto);
         if(RechazoExitoso){
             response.sendRedirect("ProyectosPropios");
         }
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
