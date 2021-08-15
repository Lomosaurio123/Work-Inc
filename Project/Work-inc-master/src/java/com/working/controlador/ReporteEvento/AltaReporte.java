
package com.working.controlador.ReporteEvento;

import com.working.dao.ReporteEventoDaoImpl;
import com.working.modelos.ReporteEvento;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AltaReporte", urlPatterns = {"/AltaReporte"})
public class AltaReporte extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AltaReporte</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaReporte at " + request.getContextPath() + "</h1>");
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
       String Modulo = request.getParameter("ModuloFalla");
       String DescripcionFalla = request.getParameter("DesripcionProblema");
       String Usuario = request.getParameter("UsuarioFalla");
       String Estado = request.getParameter("EstadoReporte");
       String Etiqueta = request.getParameter("Etiqueta");
       String IdentificadorOperador = request.getParameter("OperadorIdentificador");
       
       ReporteEvento Reporte = new ReporteEvento(Modulo,DescripcionFalla,Estado,Usuario,Etiqueta, IdentificadorOperador);
       ReporteEventoDaoImpl GuardaReporte = new ReporteEventoDaoImpl();
       boolean GuardadoExitoso =GuardaReporte.AltaReporteEvento(Reporte);
       
       if(GuardadoExitoso){
            out.println("<script type=\"text/javascript\">");
   out.println("alert('Ticket generado correctamente');");
   //out.println("location='FaqsWorkInc.jsp';");
   out.println("</script>");
         response.sendRedirect("TraeReportesEvento");
       }
       else{
           out.print("<script>alert('Un error ocurrio y el reporte no pudo ser guardado');</script>");
           response.sendRedirect("TraeReportesEvento");
       }
       
       
       
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
