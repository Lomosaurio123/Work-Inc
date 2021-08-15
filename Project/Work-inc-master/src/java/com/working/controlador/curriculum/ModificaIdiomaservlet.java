/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.controlador.curriculum;

import com.working.dao.IdiomaDaoSQL;
import com.working.idao.iIdiomaDao;
import com.working.modelos.Idioma;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hp
 */
@WebServlet(name = "ModificaIdiomaservlet", urlPatterns = {"/ModificaIdiomaservlet"})
public class ModificaIdiomaservlet extends HttpServlet {

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
            out.println("<title>Servlet ModificaIdiomaservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModificaIdiomaservlet at " + request.getContextPath() + "</h1>");
            try{
                iIdiomaDao xp = new IdiomaDaoSQL();
                int ididio = Integer.parseInt(request.getParameter("id_idi"));
                String idioma = request.getParameter("idioma");
                String habla = request.getParameter("habla");
                String escrito = request.getParameter("escrito");
                String escuchado = request.getParameter("escuchado");
                String certificado = request.getParameter("certificado");
                String correo = request.getParameter("correo");
                Idioma exp = new Idioma(ididio, correo, idioma, habla, escrito, escuchado, certificado);
                if(xp.actualizaIdioma(exp)){
                    response.sendRedirect("ConsultaUsuarioCurriculum");
                }else{
                    out.println("<script>alert('Error al dar de Alta experiencia');"
                            + "window.locati on = '../Usuarios/Menu.jsp'; </script>");
                }
                
                
            }catch(Exception e){
                System.out.println("error servlet altaxp " + e.getMessage());
            }
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
