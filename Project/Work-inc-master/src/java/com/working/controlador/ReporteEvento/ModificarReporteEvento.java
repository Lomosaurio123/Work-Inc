/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

@WebServlet(name = "ModificarReporteEvento", urlPatterns = {"/ModificarReporteEvento"})
public class ModificarReporteEvento extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModificarReporteEvento</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModificarReporteEvento at " + request.getContextPath() + "</h1>");
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
        
        String Folio,Usaurio, Modulo, Descrip,Estado, Etiq, Fecha, correo;
        Folio= request.getParameter("folio");
        Usaurio=  request.getParameter("Usuario");
        Modulo=  request.getParameter("Modulo");
        Descrip =  request.getParameter("Descrip");
        Estado =  request.getParameter("Estado");
        Etiq =  request.getParameter("Etiqueta");
        Fecha = request.getParameter("Fecha");
        correo =  request.getParameter("correo");
        
        ReporteEvento Reporte = new ReporteEvento(Modulo,Descrip,Estado,Usaurio,Fecha, Etiq, correo, Folio);
       ReporteEventoDaoImpl GuardaReporte = new ReporteEventoDaoImpl();
       boolean CambioExitoso =GuardaReporte.ModificaReporte(Reporte);
       
       if(CambioExitoso){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Reporte modificado correctamente');");
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
