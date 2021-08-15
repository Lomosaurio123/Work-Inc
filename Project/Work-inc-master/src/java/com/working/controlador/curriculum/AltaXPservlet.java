/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.controlador.curriculum;

import com.working.dao.ExperienciaDaoSQL;
import com.working.idao.iExperienciaDao;
import com.working.modelos.Experiencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hp
 */
@WebServlet(name = "AltaXPservlet", urlPatterns = {"/AltaXPservlet"})
public class AltaXPservlet extends HttpServlet {

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
            out.println("<title>Servlet AltaXPservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaXPservlet at " + request.getContextPath() + "</h1>");
            try{
                iExperienciaDao xp = new ExperienciaDaoSQL();
                String empresa = request.getParameter("empresa");
                String puesto = request.getParameter("puesto");
                String funcion = request.getParameter("funcion");
                String inicio = request.getParameter("inicio");
                String fin = request.getParameter("fin");
                String correo = request.getParameter("correo");
                Experiencia exp = new Experiencia(0, correo, puesto, empresa, funcion, inicio, fin);
                if(xp.altaExperiencia(exp)){
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
