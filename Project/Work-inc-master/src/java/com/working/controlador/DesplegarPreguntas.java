
package com.working.controlador;

import com.working.dao.FaqsDaoSQL;
import com.working.dao.ReporteEventoDaoImpl;
import com.working.dao.TicketDaoImpl;
import com.working.idao.iFaqsDao;
import com.working.modelos.ReporteEvento;
import com.working.modelos.Ticket;
import com.working.modelos.Usuario;
import com.working.modelos.faqs;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DesplegarPreguntas", urlPatterns = {"/DesplegarPreguntas"})
public class DesplegarPreguntas extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession(true);
            Usuario UsuarioTicket= (Usuario)session.getAttribute("usuario");
            String CorreoUsTicket= UsuarioTicket.getCorreo();
            
            try{
            iFaqsDao faqs = new FaqsDaoSQL();
            List<faqs> TodasPreguntas = faqs.traerPreguntas();  
            List<faqs> TodasFAQ = faqs.traerPyR();
            ReporteEventoDaoImpl TraerReporte = new ReporteEventoDaoImpl();
            List<ReporteEvento> TodosReportes = TraerReporte.traerProyectoGerente(3,"");
            TicketDaoImpl TraeTickets = new TicketDaoImpl();
            List<Ticket> TodosTickets =TraeTickets.traerTicketsUsu(2, CorreoUsTicket);
            List<Ticket> TicketsPropiosAdmin =TraeTickets.traerTicketsUsu(3, CorreoUsTicket);
            
            request.setAttribute("TodosRepAsignadosIng", TodosReportes);
            request.setAttribute("Todos", TodasPreguntas);
            request.setAttribute("TodasFAQ", TodasFAQ);
            request.setAttribute("Todostickets", TodosTickets);
            request.setAttribute("TodosticketsAsignados", TicketsPropiosAdmin);
            request.getRequestDispatcher("FAQ/VistaAdministrador.jsp").forward(request, response);
            }catch(Exception e){
                System.out.println("Error Desplegar  "+ e.getMessage());
            }
            
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
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
