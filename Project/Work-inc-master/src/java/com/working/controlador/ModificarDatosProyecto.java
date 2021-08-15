
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


@WebServlet(name = "ModificarDatosProyecto", urlPatterns = {"/ModificarDatosProyecto"})
@MultipartConfig(maxFileSize = 16177215) 
public class ModificarDatosProyecto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            iProyectoDao proyect = new ProyectoDaoImpl();
            
            HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String CorreoCreador= UsuarioCreador.getCorreo();
            InputStream inputStreamM = null;
           
            String NombreProyecto = request.getParameter("TituloProyectoo");
            String CategoriaProyecto =request.getParameter("CategoriaProyectoo");
            String IdeaProyecto = request.getParameter("IdeaProyectoo");
            int MontoProyecto = Integer.parseInt(request.getParameter("MontoProyectoo"));
            int Idproyecto = Integer.parseInt(request.getParameter("informacioon"));
            
             Part filePart = request.getPart("imagen");
             
            if (filePart.getSize() > 0) {
                inputStreamM = filePart.getInputStream();
            } 
            
            
            Proyecto ProyectoActualiza = new Proyecto(NombreProyecto,IdeaProyecto,CategoriaProyecto, MontoProyecto,CorreoCreador,inputStreamM,Idproyecto);
            proyect.actualizaProyecto(ProyectoActualiza);
            
    
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          iProyectoDao proyect = new ProyectoDaoImpl();
            
            HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String CorreoCreador= UsuarioCreador.getCorreo();
            InputStream inputStreamM = null;
           
            String NombreProyecto = request.getParameter("TituloProyectoo");
            String CategoriaProyecto =request.getParameter("CategoriaProyectoo");
            String IdeaProyecto = request.getParameter("IdeaProyectoo");
            int MontoProyecto = Integer.parseInt(request.getParameter("MontoProyectoo"));
            int Idproyecto = Integer.parseInt(request.getParameter("informacioon"));
            
             Part filePart = request.getPart("imagen");
             
            if (filePart.getSize() > 0) {
                inputStreamM = filePart.getInputStream();
            } 
            
            
            Proyecto ProyectoActualiza = new Proyecto(NombreProyecto,IdeaProyecto,CategoriaProyecto, MontoProyecto,CorreoCreador,inputStreamM,Idproyecto);
            proyect.actualizaProyecto(ProyectoActualiza);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          iProyectoDao proyect = new ProyectoDaoImpl();
            
            HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String CorreoCreador= UsuarioCreador.getCorreo();
            InputStream inputStreamM = null;
           
            String NombreProyecto = request.getParameter("TituloProyectoo");
            String CategoriaProyecto =request.getParameter("CategoriaProyectoo");
            String IdeaProyecto = request.getParameter("IdeaProyectoo");
            int MontoProyecto = Integer.parseInt(request.getParameter("MontoProyectoo"));
            int Idproyecto = Integer.parseInt(request.getParameter("informacioon"));
            
             Part filePart = request.getPart("imagen");
             
            if (filePart.getSize() > 0) {
                inputStreamM = filePart.getInputStream();
            } 
            
            
            Proyecto ProyectoActualiza = new Proyecto(NombreProyecto,IdeaProyecto,CategoriaProyecto, MontoProyecto,CorreoCreador,inputStreamM,Idproyecto);
            proyect.actualizaProyecto(ProyectoActualiza);
            response.sendRedirect("ProyectosPropios");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
