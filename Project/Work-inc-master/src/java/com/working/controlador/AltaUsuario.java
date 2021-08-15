/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.controlador;

import com.working.dao.UsuarioDaoImpl;
import com.working.dao.UsuarioDaoSQL;
import com.working.idao.iUsuarioDao;
import com.working.modelos.Cedula;
import com.working.modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "AltaUsuario", urlPatterns = {"/AltaUsuario"})
public class AltaUsuario extends HttpServlet {

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

                try{
                iUsuarioDao usuario= new UsuarioDaoSQL();
                boolean entrada=false;
                HttpSession session = request.getSession(true);
                String nombre = request.getParameter("nombre");
                String apat = request.getParameter("apat");
                String amat = request.getParameter("amat");
                String edad = request.getParameter("edad");
                int edadsegura = Integer.parseInt(ESAPI.encoder().encodeForHTML(edad));
                String telefono = request.getParameter("telefono");
                String genero = request.getParameter("genero");
                String correo = request.getParameter("correo");
                String contra = request.getParameter("contra");
                String confircontra = request.getParameter("confircontra");
                String cedula= request.getParameter("cedula");
                int cedulanum= Integer.parseInt(cedula);
               
                
                //validacion de cedula
                ValidaCedula valida_ced = new ValidaCedula();
                Cedula ced = valida_ced.Compruebacedula(cedulanum);
                
                String NombreCed= ced.getNombre();
                String UniversidadCed =ced.getUniversidad();
                String CarreraCed = ced.getCarrera();
                
               // boolean repetido = usuario.correorepetido(usu);
               Usuario usu = new Usuario(nombre, apat, amat, edadsegura, genero, correo, contra, confircontra, cedula, CarreraCed, UniversidadCed, telefono);
                
                out.println(UniversidadCed);
                
                entrada = usuario.altaUsuario(usu); 
                 if(entrada = true){
                     session.setAttribute("usuario", usu);
                     response.sendRedirect("Usuarios/MenuUsuario.jsp");
                 }else{
                     response.sendRedirect("../index.html");
                 }
                }catch(Exception e){
                    System.out.println("Error en AltaUsuario servlet:  " +e.toString() + e.getMessage());
                }
                
                
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
        

        
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
