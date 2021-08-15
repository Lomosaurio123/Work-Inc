
package com.working.controlador;

import com.working.dao.ProyectoDaoImpl;
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


@WebServlet(name = "TareasARealizarPorProyecto", urlPatterns = {"/TareasARealizarPorProyecto"})
public class TareasARealizarPorProyecto extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TareasARealizarPorProyecto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TareasARealizarPorProyecto at " + request.getContextPath() + "</h1>");
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
        
        
        ProyectoDaoImpl MetodoTraerTareas = new ProyectoDaoImpl();
        HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String CorreoCreador= UsuarioCreador.getCorreo();
            
            int infoProyecto = Integer.parseInt(request.getParameter("informacionProyecto"));
            List<TareaProyecto> TareasArealizar  = MetodoTraerTareas.DesplegarTareasUsuarioARealizar(infoProyecto, CorreoCreador);
            request.setAttribute("ListaTareasArealizar",TareasArealizar );
            request.getRequestDispatcher("Proyectos/TareasARealizar.jsp").forward(request, response);
        
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
