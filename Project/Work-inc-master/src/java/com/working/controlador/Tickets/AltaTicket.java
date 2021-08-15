
package com.working.controlador.Tickets;

import com.working.dao.TicketDaoImpl;
import com.working.modelos.Ticket;
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


@WebServlet(name = "AltaTicket", urlPatterns = {"/AltaTicket"})
public class AltaTicket extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AltaTicket</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaTicket at " + request.getContextPath() + "</h1>");
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
            Usuario UsuarioTicket= (Usuario)session.getAttribute("usuario");
            String CorreoUsTicket= UsuarioTicket.getCorreo();
            TicketDaoImpl TicketLaventar = new TicketDaoImpl();
            
            String ModuloFallaTickte = request.getParameter("ModuloFalla");
            String DescricionFallaTiket = request.getParameter("DesripcionProblema");
            Ticket TicketLevantar = new Ticket(CorreoUsTicket,ModuloFallaTickte,DescricionFallaTiket);
            boolean ExitoAltaTicket =TicketLaventar.AltaTicket(TicketLevantar);
            if(ExitoAltaTicket){
            

               response.sendRedirect("DesplegarPyR");
                
            }else{
                
               response.sendRedirect("DesplegarPyR");
                
            }
            
        
        
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
