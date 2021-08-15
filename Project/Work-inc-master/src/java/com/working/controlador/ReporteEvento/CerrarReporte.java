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

/**
 *
 * @author mauga
 */
@WebServlet(name = "CerrarReporte", urlPatterns = {"/CerrarReporte"})
public class CerrarReporte extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CerrarReporte</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CerrarReporte at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Folio, SolucionReporte;
        Folio= request.getParameter("foliocerrar");
        SolucionReporte = request.getParameter("SolucionReporte");
        
       ReporteEvento Reporte = new ReporteEvento(Folio);
       ReporteEventoDaoImpl GuardaReporte = new ReporteEventoDaoImpl();
       boolean CambioExitoso =GuardaReporte.CerrarReporte(Reporte,SolucionReporte);
       
       if(CambioExitoso){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Reporte cerrado exitosamente');");
            out.println("</script>");
           response.sendRedirect("TraeReportesProgramador");
       }
       else{
           out.print("<script>alert('Un error ocurrio y el reporte no pudo cerrado');</script>");
           response.sendRedirect("TraeReportesProgramador");
       }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
