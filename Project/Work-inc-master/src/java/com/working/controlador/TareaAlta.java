
package com.working.controlador;

import com.working.dao.ProyectoDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "TareaAlta", urlPatterns = {"/TareaAlta"})
public class TareaAlta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TareaAlta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TareaAlta at " + request.getContextPath() + "</h1>");
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
       String Titulo= request.getParameter("TituloT");
       String DescripcionTarea = request.getParameter("DescripcionT");
       String ImportanciaTarea = request.getParameter("ImportanciaT");
       String CorreoUsrAsignado = request.getParameter("UsuarioResponsable");
       int DiasTarea = Integer.parseInt(request.getParameter("DuracionDias"));
       int infoproyecto = Integer.parseInt(request.getParameter("InfoProyectoT"));
       
       ProyectoDaoImpl AltaTarea = new ProyectoDaoImpl();
       boolean ExitoAltaTarea = AltaTarea.CrearTarea(Titulo, DescripcionTarea, ImportanciaTarea, CorreoUsrAsignado, DiasTarea, infoproyecto);
       
       response.sendRedirect("ProyectosPropios");
       
       
       
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
