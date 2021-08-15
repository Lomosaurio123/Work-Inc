/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.controlador;

import com.working.dao.ProyectoDaoImpl;
import com.working.idao.iProyectoDao;
import com.working.modelos.Proyecto;
import com.working.modelos.Usuario;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author nayei
 */
@WebServlet(name = "proyectoalta", urlPatterns = {"/proyectoalta"})
@MultipartConfig(maxFileSize = 16177215) 
public class proyectoalta extends HttpServlet {

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
           
            
            iProyectoDao proyect = new ProyectoDaoImpl();
            ProyectoDaoImpl MetodosProyecto = new ProyectoDaoImpl();
            HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            InputStream inputStreamM = null;
            boolean registroUSR= false;

            String CorreoCreador= UsuarioCreador.getCorreo();
            String NombreProyecto= request.getParameter("NombreProyecto"); 
            String IdeaProyecto = request.getParameter("IdeaProyecto");
            String Categoria = request.getParameter("Categoria");
            int Monto =Integer.parseInt(request.getParameter("MontoDonacion"));
            int NumUsuarios = Integer.parseInt(request.getParameter("NumeroIntegrantes"));
            
            String UsuarioSolicitado1 = request.getParameter("Int1");
            String UsuarioSolicitado2 = request.getParameter("Int2");
            String UsuarioSolicitado3 = request.getParameter("Int3");
            String UsuarioSolicitado4 = request.getParameter("Int4");
            String UsuarioSolicitado5 = request.getParameter("Int5");
            
            String Profesionistas[]={UsuarioSolicitado1,UsuarioSolicitado2,UsuarioSolicitado3,UsuarioSolicitado4,UsuarioSolicitado5};
            
            
            
            if(UsuarioSolicitado1.equals("")&&UsuarioSolicitado2.equals("")&&UsuarioSolicitado3.equals("")&&UsuarioSolicitado4.equals("")&&UsuarioSolicitado5.equals("")){
                ////Validacion para que no le permita subir el proyecto
                
            }
            

            Part filePart = request.getPart("imagen");
            
             if (filePart.getSize() > 0) {
                inputStreamM = filePart.getInputStream();
            }

            Proyecto pro= new Proyecto(NombreProyecto,IdeaProyecto,Categoria,Monto,CorreoCreador,inputStreamM,NumUsuarios);
            boolean registrocompletado=proyect.altaProyecto(pro);
            if(registrocompletado){
              registroUSR= MetodosProyecto.InsertarUsuariosReq(NumUsuarios, pro, Profesionistas);
               
            }
            if(registroUSR){
                 response.sendRedirect("ProyectosPropios");
            }
           
            
            
            
            
            
            
            
            
            
            
            
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
