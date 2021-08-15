
package com.working.controlador;

import com.working.dao.ProyectoDaoImpl;
import com.working.modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SolicitudUnion", urlPatterns = {"/SolicitudUnion"})
public class SolicitudUnion extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SolicitudUnion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SolicitudUnion at " + request.getContextPath() + "</h1>");
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
        Usuario UsuarioPeticionUnion= (Usuario)session.getAttribute("usuario");
        ProyectoDaoImpl Solicitarunion = new ProyectoDaoImpl();
        
        String UsuarioSolicitud = UsuarioPeticionUnion.getCorreo();
        int  InformacionProyecto = Integer.parseInt(request.getParameter("InformacionProyecto"));
        
        Solicitarunion.PeticionUnionProyecto(UsuarioSolicitud, InformacionProyecto);
        response.sendRedirect("TodosProyectos");
      
        
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
