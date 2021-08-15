
package com.working.controlador;

import com.working.dao.UsuarioDaoImpl;
import com.working.dao.UsuarioDaoSQL;
import com.working.idao.iUsuarioDao;
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



@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {    
            
        }
   }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("usuario") != null) {
              response.sendRedirect("Usuarios/MenuUsuario.jsp");
        } else {
            //request.getRequestDispatcher("Usuarios/Login.jsp").forward(request, response); 
            response.sendRedirect("Usuarios/Login.jsp");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                try{
                    iUsuarioDao usuarioc= new UsuarioDaoSQL();
                    Usuario datos;
                    UsuarioDaoSQL IdentificaTipoUsu= new UsuarioDaoSQL(); 
                    String usuariolog=request.getParameter("usuario");
                    String contralog=request.getParameter("contra");
                    Usuario usu = new Usuario(usuariolog,contralog);
                     datos =IdentificaTipoUsu.consultaUsuario(usuariolog, contralog);
                     String id = usuarioc.entraUsuario(usu);
                    if(id.equals("usuario correcto")){
                        HttpSession session = request.getSession(true);
                         session.setAttribute("usuario", usu);
                        String TipoUsua = datos.getCodigoAdmin();
                         
                         if(TipoUsua.equals("UsuarioNormal")){
                             response.sendRedirect("Usuarios/MenuUsuario.jsp");
                         }else
                             if(TipoUsua.equals("GeerenteSoft")){
                                  response.sendRedirect("Usuarios/MenuGerente.jsp");
                             }
                             else
                                 if(TipoUsua.equals("IngenieroSoft")){
                                      response.sendRedirect("Usuarios/MenuIngeniero.jsp");
                                 }
                                else
                                     if(TipoUsua.equals("Operador")){
                                         response.sendRedirect("Usuarios/MenuOperador.jsp");
                                     }
                                        else
                                            if(TipoUsua.equals("EditorFAQS")){
                                                response.sendRedirect("Usuarios/MenuAdminMesaSoporte.jsp");
                                            }
                                            else
                                                if(TipoUsua.equals("IngMantenimiento")){
                                                    response.sendRedirect("Usuarios/MenuIngMantenimiento.jsp");
                                                }
                    }else{     
                        if(id.equals("Contraseña incorrecta")){
                            try (PrintWriter out = response.getWriter()) {
                            out.println("<script>alert('La contraseña es incorrecta');window.location = 'Usuarios/Login.jsp'; </script>");
                             }
                            response.sendRedirect("Usuarios/Login.jsp");
                        }else{
                            if(id.equals("El correo no existe")){
                                try (PrintWriter out = response.getWriter()) {
                                out.println("<script>alert('El correo no existe');window.location = 'Usuarios/Login.jsp'; </script>");
                                 }
                                response.sendRedirect("Usuarios/Login.jsp");
                            }
                        }
                       
                    }
                   
                         
                                     
                         
                         
                        
                    
                }catch(Exception e){
                    System.out.println("error en loginservlet : " + e.toString());
                }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
