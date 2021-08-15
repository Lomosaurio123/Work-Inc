
package com.working.controlador;

import com.working.dao.ProyectoDaoImpl;
import com.working.idao.iProyectoDao;
import com.working.modelos.Proyecto;
import com.working.modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ProyectoPublico", urlPatterns = {"/ProyectoPublico"})
public class ProyectoPublico extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
      
        iProyectoDao proyect = new ProyectoDaoImpl();
            
            HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String CorreoCreador= UsuarioCreador.getCorreo();
           
            String NombreProyecto = request.getParameter("NompreProyect");
            String CategoriaProyecto =request.getParameter("CategoriaProyect");
            String IdeaProyecto = request.getParameter("IdeaProyect");
            int MontoProyecto = Integer.parseInt(request.getParameter("MontoProyect"));
            Proyecto ProyectoConsulta = new Proyecto(NombreProyecto,IdeaProyecto,CategoriaProyecto, MontoProyecto,CorreoCreador);
            Proyecto ProyectoRegresa = proyect.consultaProyecto(ProyectoConsulta);
            
            request.setAttribute("ProyectoEspecifico", ProyectoRegresa);
            request.getRequestDispatcher("Proyectos/ProyectoPublicoEspecifico.jsp").forward(request, response); 
            
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
