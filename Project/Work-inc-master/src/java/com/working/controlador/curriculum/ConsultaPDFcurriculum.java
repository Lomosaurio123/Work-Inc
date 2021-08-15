/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.controlador.curriculum;

import com.working.dao.CursoDaoSQL;
import com.working.dao.EscolaridadDaoSQL;
import com.working.dao.ExperienciaDaoSQL;
import com.working.dao.HabilidadesDaoSQL;
import com.working.dao.IdiomaDaoSQL;
import com.working.dao.SoftwareDaoSQL;
import com.working.dao.UsuarioDaoSQL;
import com.working.idao.iUsuarioDao;
import com.working.modelos.Cursos;
import com.working.modelos.Escolaridad;
import com.working.modelos.Experiencia;
import com.working.modelos.Habilidades;
import com.working.modelos.Idioma;
import com.working.modelos.Software;
import com.working.modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rodri
 */
@WebServlet(name = "ConsultaPDFcurriculum", urlPatterns = {"/ConsultaPDFcurriculum"})
public class ConsultaPDFcurriculum extends HttpServlet {

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
            out.println("<title>Servlet ConsultaPDFcurriculum</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsultaPDFcurriculum at " + request.getContextPath() + "</h1>");
            try{  
            HttpSession sesion = request.getSession();
            Usuario us = (Usuario)sesion.getAttribute("usuario");
            iUsuarioDao usuD = new UsuarioDaoSQL();
            Usuario usua = null;
            usua = usuD.consultaUsuario(us.getCorreo(), us.getContra());
            if(usua != null){
                request.setAttribute("usuarioCon", usua);
            }else{
                response.sendRedirect("Usuarios/Login.jsp");
            }
            //Traer las experiencias
            ExperienciaDaoSQL xp = new ExperienciaDaoSQL();
            List<Experiencia> exps = xp.traeExperiencia(us.getCorreo());
            if(exps != null){
                request.setAttribute("experiencias", exps);
            }else{
                response.sendRedirect("Usuarios/Login.jsp");
            }
            //traer escolaridad
            EscolaridadDaoSQL esco = new EscolaridadDaoSQL();
            List<Escolaridad> escola = esco.traeEscolaridad(us.getCorreo());
            if(escola != null){
                request.setAttribute("escolaridad", escola);
                
            }else{
                response.sendRedirect("Usuarios/Login.jsp");
            }
            IdiomaDaoSQL idi = new IdiomaDaoSQL();
            List<Idioma> idio = idi.traeIdioma(us.getCorreo());
            if(idio != null){
                request.setAttribute("idiomas", idio);
            }else{
                response.sendRedirect("Usuarios/Login.jsp");
            }
            SoftwareDaoSQL sof = new SoftwareDaoSQL();
            List<Software> soft = sof.traeSoftware(us.getCorreo());
            if(soft != null){
                request.setAttribute("softwares", soft);
                
            }else{
                response.sendRedirect("Usuarios/Login.jsp");
            }
            HabilidadesDaoSQL Hab = new HabilidadesDaoSQL();
            List<Habilidades> Habi = Hab.traeHabilidades(us.getCorreo());
            if(Habi != null){
                request.setAttribute("habilidades", Habi);
            }else{
                response.sendRedirect("Usuarios/Login.jsp");
            }
            CursoDaoSQL cur = new CursoDaoSQL();
            List<Cursos> curso = cur.traeCursos(us.getCorreo());
            if(curso != null){
                request.setAttribute("Cursos", curso);
                request.getRequestDispatcher("Curriculum/PDFCurriculum.jsp").forward(request, response);
            }else{
                response.sendRedirect("Usuarios/Login.jsp");
            }
            }catch(Exception e){
                System.out.println("Error en ReadPersonaServlet :  " + e.toString());
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
