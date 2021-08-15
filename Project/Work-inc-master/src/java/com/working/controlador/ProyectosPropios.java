/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.controlador;

import com.working.dao.ProyectoDaoImpl;
import com.working.dao.UsuarioDaoImpl;
import com.working.dao.UsuarioDaoSQL;
import com.working.idao.iUsuarioDao;
import com.working.modelos.Proyecto;
import com.working.modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.owasp.esapi.ESAPI;

/**
 *
 * @author juan-
 */
@WebServlet(name = "ProyectosPropios", urlPatterns = {"/ProyectosPropios"})
public class ProyectosPropios extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

        HttpSession sesion= (HttpSession) request.getSession();
        Usuario usuario =(Usuario)sesion.getAttribute("usuario");
        
        String correo = usuario.getCorreo();
        String contra = usuario.getContra();
        
        out.println("<script>alert('" + correo + "');</script>");
        
        iUsuarioDao Usuarioo= new UsuarioDaoSQL();
        Usuario objetousuario = Usuarioo.consultaUsuario(correo, contra);
        ProyectoDaoImpl proyecto = new ProyectoDaoImpl();
            
            if(objetousuario != null){
                
                    List<Proyecto> TodosProyectos = proyecto.traerProyecto(1, objetousuario.getCorreo() );
                request.setAttribute("TodosUsuario", TodosProyectos);
                request.getRequestDispatcher("Proyectos/ManejoProyectos.jsp").forward(request, response); 
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
        
        
         /* HttpSession sesion= (HttpSession) request.getSession();
        Usuario usuario =(Usuario)sesion.getAttribute("usuario");
        
       String correo = usuario.getCorreo();
        String contra = usuario.getContra();
        
        out.println("<script>alert('" + correo + "');</script>");
        
        iUsuarioDao Usuarioo= new UsuarioDaoImpl();
        Usuario objetousuario = Usuarioo.consultaUsuario(correo, contra);
        ProyectoDaoImpl proyecto = new ProyectoDaoImpl();
        String correo_propio = objetousuario.getCorreo();
        String correo_propio_seguro = ESAPI.encoder().encodeForHTML(correo_propio);
            
            if(objetousuario != null){
                
                
                List<Proyecto> TodosProyectos = proyecto.traerProyecto(1, correo_propio );
                request.setAttribute("TodosUsuario", TodosProyectos);
                request.getRequestDispatcher("Proyectos/ManejoProyectos.jsp").forward(request, response);

               
                
            }
            
            */
       
       
        HttpSession sesion= (HttpSession) request.getSession();
        Usuario usuario =(Usuario)sesion.getAttribute("usuario");
        
        String correo = usuario.getCorreo();
        String contra = usuario.getContra();
        
        out.println("<script>alert('" + correo + "');</script>");
        
        iUsuarioDao Usuarioo= new UsuarioDaoSQL();
        Usuario objetousuario = Usuarioo.consultaUsuario(correo, contra);
        ProyectoDaoImpl proyecto = new ProyectoDaoImpl();
            
            if(objetousuario != null){
                
                    List<Proyecto> TodosProyectos = proyecto.traerProyecto(1, objetousuario.getCorreo() );
                request.setAttribute("TodosUsuario", TodosProyectos);
                request.getRequestDispatcher("Proyectos/ManejoProyectos.jsp").forward(request, response); 
            }
       
       
       
       
        
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
       
          /*HttpSession sesion= (HttpSession) request.getSession();
        Usuario usuario =(Usuario)sesion.getAttribute("usuario");
        
        String correo = usuario.getCorreo();
        String contra = usuario.getContra();
        
        out.println("<script>alert('" + correo + "');</script>");
        
        iUsuarioDao Usuarioo= new UsuarioDaoImpl();
        Usuario objetousuario = Usuarioo.consultaUsuario(correo, contra);
        ProyectoDaoImpl proyecto = new ProyectoDaoImpl();
            
            if(objetousuario != null){
                
                
                List<Proyecto> TodosProyectos = proyecto.traerProyecto(1, objetousuario.getCorreo() );
                request.setAttribute("TodosUsuario", TodosProyectos);
                request.getRequestDispatcher("Proyectos/ManejoProyectos.jsp").forward(request, response);

               
                
            }
            
            */
        
           HttpSession sesion= (HttpSession) request.getSession();
        Usuario usuario =(Usuario)sesion.getAttribute("usuario");
        
        String correo = usuario.getCorreo();
        String contra = usuario.getContra();
        
        out.println("<script>alert('" + correo + "');</script>");
        
        iUsuarioDao Usuarioo= new UsuarioDaoSQL();
        Usuario objetousuario = Usuarioo.consultaUsuario(correo, contra);
        ProyectoDaoImpl proyecto = new ProyectoDaoImpl();
            
            if(objetousuario != null){
                
                    List<Proyecto> TodosProyectos = proyecto.traerProyecto(1, objetousuario.getCorreo() );
                request.setAttribute("TodosUsuario", TodosProyectos);
                request.getRequestDispatcher("Proyectos/ManejoProyectos.jsp").forward(request, response); 
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
