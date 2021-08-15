
package com.working.controlador;

import com.working.dao.FaqsDaoSQL;
import com.working.dao.ReporteEventoDaoImpl;
import com.working.dao.TicketDaoImpl;
import com.working.dao.UsuarioDaoSQL;
import com.working.idao.iFaqsDao;
import com.working.modelos.Ticket;
import com.working.modelos.Usuario;
import com.working.modelos.faqs;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "DesplegarPyR", urlPatterns = {"/DesplegarPyR"})
public class DesplegarPyR extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String Correo= UsuarioCreador.getCorreo();
            String Contra = UsuarioCreador.getContra();
            
            try{
            iFaqsDao faqs = new FaqsDaoSQL();
            TicketDaoImpl TraerTicketsUsuario = new TicketDaoImpl();
            UsuarioDaoSQL TraerDatosUsuario= new UsuarioDaoSQL();
            Usuario DatosUsuarioTicket= TraerDatosUsuario.consultaUsuario(Correo, Contra);
            
            List<Ticket> TicketsGeneradosUsu =TraerTicketsUsuario.traerTicketsUsu(0, Correo);
             ReporteEventoDaoImpl TraerReporte = new ReporteEventoDaoImpl();
           
            int numeroTickets=0;
            ArrayList<Ticket> TicketsTodos = new ArrayList<Ticket>();
            Ticket Tik;
                String NombreResp="";
             String ApatResp= "";
             String AmatResp= "";
             String CorreoResp= "";
           
            for(Ticket t : TicketsGeneradosUsu){
                String Folio= t.getFolio();
                String EstadoRev= t.getEstadoRevision();
                int ResponsableRevision= t.getInformacionResponsableRevision();
                String FechaTicket= t.getFechaCreacionTicket();
                String Modulo= t.getModulo();
                String Descripcion= t.getDescripcionProblema();
                String Respuesta= t.getRespuesta();
                if(EstadoRev.equals("Pendiente")){
                    
                     NombreResp = "Sin";
                     ApatResp = "operador";
                     AmatResp = "asignado";
                     CorreoResp = "nada";
                    
                }else{
                    Usuario InfoIng = TraerReporte.TraeIngenierosSoftInfo(0, ResponsableRevision);
                     NombreResp = InfoIng.getNombre();
                     ApatResp = InfoIng.getApat();
                     AmatResp = InfoIng.getAmat();
                     CorreoResp = InfoIng.getCorreo();
                    
                }

                 Tik=new Ticket(Folio,EstadoRev,ResponsableRevision,NombreResp,ApatResp,AmatResp,FechaTicket,Modulo,Descripcion,Respuesta);
                 TicketsTodos.add(Tik);
                 
               numeroTickets++;
           }
            
 
            List<faqs> TodasPreguntas = faqs.traerPyR();
            request.setAttribute("DatosUsuTicket", DatosUsuarioTicket);
            request.setAttribute("Todos", TodasPreguntas);
            request.setAttribute("TodosTickets", TicketsTodos);
            
            request.getRequestDispatcher("FAQ/FaqsWorkInc.jsp").forward(request, response);
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
