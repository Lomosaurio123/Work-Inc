
package com.working.controlador;

import com.working.dao.ProyectoDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ProcesesamientoSolicitud", urlPatterns = {"/ProcesesamientoSolicitud"})
public class ProcesesamientoSolicitud extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcesesamientoSolicitud</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcesesamientoSolicitud at " + request.getContextPath() + "</h1>");
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
        
        
            String Correo= request.getParameter("correo");
            int infoproject = Integer.parseInt(request.getParameter("infoproject"));
            String PuestoAsignado= request.getParameter("PuestoSeleccionado");
            ProyectoDaoImpl MetodoDarPuesto = new ProyectoDaoImpl();
            boolean Asignacion = MetodoDarPuesto.AceptarSolicitudUnion(Correo, infoproject, PuestoAsignado);
             response.sendRedirect("ProyectosPropios");

        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
