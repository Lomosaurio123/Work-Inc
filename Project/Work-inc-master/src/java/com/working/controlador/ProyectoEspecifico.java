
package com.working.controlador;

import com.working.dao.ProyectoDaoImpl;
import com.working.idao.iProyectoDao;
import com.working.modelos.ProfesionistaRequerido;
import com.working.modelos.Proyecto;
import com.working.modelos.TareaProyecto;
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


@WebServlet(name = "ProyectoEspecifico", urlPatterns = {"/ProyectoEspecifico"})
public class ProyectoEspecifico extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            iProyectoDao proyect = new ProyectoDaoImpl();
            ProyectoDaoImpl procedimientos = new ProyectoDaoImpl();
            
            
            HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String CorreoCreador= UsuarioCreador.getCorreo();
           
            String NombreProyecto = request.getParameter("NompreProyect");
            String CategoriaProyecto =request.getParameter("CategoriaProyect");
            String IdeaProyecto = request.getParameter("IdeaProyect");
            int MontoProyecto = Integer.parseInt(request.getParameter("MontoProyect"));
            
            Proyecto ProyectoConsulta = new Proyecto(NombreProyecto,IdeaProyecto,CategoriaProyecto, MontoProyecto,CorreoCreador);
            Proyecto ProyectoRegresa = proyect.consultaProyecto(ProyectoConsulta);
            
           List<Usuario> UsuarioInteresadoUnion  = procedimientos.DesplegarUsuarioInteresado(ProyectoConsulta);
           List<ProfesionistaRequerido> PuestosReq =procedimientos.DesplegarProfesionistasReq(ProyectoConsulta);
           List<Usuario> UsuariosUnidos  = procedimientos.DesplegarUsuarioUnido(ProyectoConsulta);
            
            request.setAttribute("ProyectoEspecifico", ProyectoRegresa);
            request.setAttribute("ListaUsuariosPeticionUnion", UsuarioInteresadoUnion);
            request.setAttribute("ListaProfesionistasRequeridos", PuestosReq);
            request.setAttribute("ListaUsuariosUnidos", UsuariosUnidos);
            
            request.getRequestDispatcher("Proyectos/ModificarProyectos.jsp").forward(request, response); 
           
            
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
            request.getRequestDispatcher("Proyectos/ModificarProyectos.jsp").forward(request, response); 
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             iProyectoDao proyect = new ProyectoDaoImpl();
              ProyectoDaoImpl procedimientos = new ProyectoDaoImpl();
            
            HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String CorreoCreador= UsuarioCreador.getCorreo();
           
            String NombreProyecto = request.getParameter("NompreProyect");
            String CategoriaProyecto =request.getParameter("CategoriaProyect");
            String IdeaProyecto = request.getParameter("IdeaProyect");
            int MontoProyecto = Integer.parseInt(request.getParameter("MontoProyect"));          
            Proyecto ProyectoConsulta = new Proyecto(NombreProyecto,IdeaProyecto,CategoriaProyecto, MontoProyecto,CorreoCreador);
            Proyecto ProyectoRegresa = proyect.consultaProyecto(ProyectoConsulta);
            
          
            
            List<Usuario> UsuarioInteresadoUnion  = procedimientos.DesplegarUsuarioInteresado(ProyectoConsulta);
           List<ProfesionistaRequerido> PuestosReq =procedimientos.DesplegarProfesionistasReq(ProyectoConsulta);
           List<Usuario> UsuariosUnidos  = procedimientos.DesplegarUsuarioUnido(ProyectoConsulta);
           List<TareaProyecto> Tareas  = procedimientos.DesplegarTareas(ProyectoConsulta);
           
            
            request.setAttribute("ProyectoEspecifico", ProyectoRegresa);
            request.setAttribute("ListaUsuariosPeticionUnion", UsuarioInteresadoUnion);
            request.setAttribute("ListaProfesionistasRequeridos", PuestosReq);
            request.setAttribute("ListaUsuariosUnidos", UsuariosUnidos);
             request.setAttribute("ListaTareas",Tareas );
            
            request.getRequestDispatcher("Proyectos/ModificarProyectos.jsp").forward(request, response); 
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
