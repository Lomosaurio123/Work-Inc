/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.controlador;

import com.working.dao.UsuarioDaoSQL;
import com.working.idao.iUsuarioDao;
import com.working.mensajes.EnyRe;
import com.working.mensajes.LlavesDes;
import com.working.modelos.Cedula;
import com.working.modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.owasp.esapi.ESAPI;

/**
 *
 * @author Hp
 */
@WebServlet(name = "ActualizarUsuario", urlPatterns = {"/ActualizarUsuario"})
public class ActualizarUsuario extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ActualizarPersona</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActualizarPersona at " + request.getContextPath() + "</h1>");

            try {
                iUsuarioDao usuario = new UsuarioDaoSQL();
                String nombre = request.getParameter("nombre");
                String apat = request.getParameter("apellido_pat");
                String amat = request.getParameter("apellido_mat");
                String edad = request.getParameter("edad");
                int edadsegura = Integer.parseInt(ESAPI.encoder().encodeForHTML(edad));
                String telefono = request.getParameter("telefono");
                String genero = request.getParameter("Sexo");
                String correo = request.getParameter("correo");
                String contra = request.getParameter("contrasena");
                String confircontra = request.getParameter("ConfirContra");
                String cedula = request.getParameter("cedula");
                int cedulanum = Integer.parseInt(cedula);

                //validacion de cedula
                ValidaCedula valida_ced = new ValidaCedula();
                Cedula ced = valida_ced.Compruebacedula(cedulanum);

                String NombreCed = ced.getNombre();
                String UniversidadCed = ced.getUniversidad();
                String CarreraCed = ced.getCarrera();

                // boolean repetido = usuario.correorepetido(usu);
                Usuario usu = new Usuario(nombre, apat, amat, edadsegura, genero, correo, contra, confircontra, cedula, CarreraCed, UniversidadCed, telefono);
                String actua = "actualizo";
                if (usuario.actualizaUsuario(usu)) {
                    request.setAttribute("usuarioCon", usu);
                    request.setAttribute("actualizo", actua);
                    request.getRequestDispatcher("Usuarios/Perfilusuario.jsp").forward(request, response);
                } else {
                    out.println("<script>alert('Usuario No se Actualizo');"
                            + "window.locati on = '../Perfilusuario.jsp'; </script>");
                }
                out.println("<script>alert('Usuario  Actualizo');</script>");

            } catch (Exception e) {
                System.out.println("Error en Actualizar : " + e.toString());
            }
        

        out.println("</body>");
        out.println("</html>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
