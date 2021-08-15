/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.controlador;


import com.working.dao.NoticiaDaoImpl;
import com.working.idao.iNoticiaDao;
import com.working.modelos.Noticia;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author mauga
 */
@WebServlet(name = "ModificarNoticia", urlPatterns = {"/ModificarNoticia"})
@MultipartConfig(maxFileSize = 16177215) 
public class ModificarNoticia extends HttpServlet {

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
            
                 
            iNoticiaDao Noti= new NoticiaDaoImpl();
            InputStream input =null;
            
            String id=request.getParameter("id_noticia");
            String titulo= request.getParameter("titulo");
            String noticia= request.getParameter("Noticia");
            Part filePart = request.getPart("imagen");
            String categoria= request.getParameter("Categoria");
            response.sendRedirect("Historial");
            
            if(filePart.getSize() >0){
                  input= filePart.getInputStream();
                  Noticia n= new Noticia(titulo, noticia, input, categoria, id);
                  Noti.actualizaNoticia(n);
                  response.sendRedirect("Historial");
            }
            else{
                //metodo para solo modificar texto
                Noticia n= new Noticia(titulo, noticia,categoria, id);
                Noti.actualizaNoticia(n);
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         iNoticiaDao Noti= new NoticiaDaoImpl();
            InputStream input =null;
            
            String id=request.getParameter("id_noticia");
            String titulo= request.getParameter("titulo");
            String noticia= request.getParameter("Noticia");
            Part filePart = request.getPart("imagen");
            String categoria= request.getParameter("Categoria");
            int idNot = Integer.parseInt(id);
            
            if(filePart.getSize() >0){
                input= filePart.getInputStream();
                  Noticia n= new Noticia(titulo, noticia, input, categoria, id);
            
            Noti.actualizaNoticia(n);
            }
            else{
                
                
                //metodo para solo modificar texto
                Noticia n= new Noticia(titulo, noticia,categoria, id);
            
                Noti.actualizaNoticia(n);
            }
            
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
