
package com.working.controlador;

import com.working.dao.ProyectoDaoImpl;
import com.working.dao.UsuarioDaoImpl;
import com.working.idao.iUsuarioDao;
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


@WebServlet(name = "ProyectosUsuario", urlPatterns = {"/ProyectosUsuario"})
public class ProyectosUsuario extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProyectosUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>ESTE ES EL SERVLET PARA MANEJO DE PROYECTOS DE UNO MISMO " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
          
            HttpSession sesion= (HttpSession) request.getSession();
            Usuario usuario =(Usuario)sesion.getAttribute("usuario");
        
            String correo = usuario.getCorreo();
            String contra = usuario.getContra();
            
            out.println("<script>alert('" + correo + "');</script>");
            
            iUsuarioDao Usuarioo= new UsuarioDaoImpl();
            Usuario objetousuario = Usuarioo.consultaUsuario(correo, contra);
            
            if(objetousuario != null){
                
                ProyectoDaoImpl proyecto = new ProyectoDaoImpl();
                List<Proyecto> TodosProyectos = proyecto.traerProyecto(1, objetousuario.getCorreo() );
                request.setAttribute("TodosUsuario", TodosProyectos);
                request.getRequestDispatcher("Proyectos/ManejoProyectos.jsp").forward(request, response);

               
                
            }
            
            
            
            
            
            
            
            
            
            
            
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
        
        
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
