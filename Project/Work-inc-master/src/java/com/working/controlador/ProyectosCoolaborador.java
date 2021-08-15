
package com.working.controlador;

import com.working.dao.ProyectoDaoImpl;
import com.working.modelos.Proyecto;
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


@WebServlet(name = "ProyectosCoolaborador", urlPatterns = {"/ProyectosCoolaborador"})
public class ProyectosCoolaborador extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String CorreoCreador= UsuarioCreador.getCorreo();
            ProyectoDaoImpl MetodoProyectosUnidos = new ProyectoDaoImpl();
            List<Proyecto> TodosProyectosUnidos= MetodoProyectosUnidos.traerProyectoColaborador(CorreoCreador);
            request.setAttribute("TodosProyectosUnidos", TodosProyectosUnidos);
            request.getRequestDispatcher("Proyectos/ProyectosParticipante.jsp").forward(request, response);
            
            
           
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
        
          HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String CorreoCreador= UsuarioCreador.getCorreo();
            ProyectoDaoImpl MetodoProyectosUnidos = new ProyectoDaoImpl();
            List<Proyecto> TodosProyectosUnidos= MetodoProyectosUnidos.traerProyectoColaborador(CorreoCreador);
            request.setAttribute("TodosProyectosUnidos", TodosProyectosUnidos);
            request.getRequestDispatcher("Proyectos/ProyectosParticipante.jsp").forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
