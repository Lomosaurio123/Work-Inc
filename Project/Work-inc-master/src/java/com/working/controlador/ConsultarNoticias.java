/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.controlador;


import com.working.dao.NoticiaDaoImpl;
import com.working.modelos.Noticia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ConsultarNoticias", urlPatterns = {"/ConsultarNoticias"})
public class ConsultarNoticias extends HttpServlet {


    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
     
            NoticiaDaoImpl not= new NoticiaDaoImpl();
            
            List<Noticia> todaslasnoticias = not.traerNoticias4();
            
            request.setAttribute("Todos", todaslasnoticias);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
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
        
            NoticiaDaoImpl not= new NoticiaDaoImpl();
            
            List<Noticia> todaslasnoticias = not.traerNoticias4();
            
            request.setAttribute("Todos", todaslasnoticias);
            request.getRequestDispatcher("index.jsp").forward(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
