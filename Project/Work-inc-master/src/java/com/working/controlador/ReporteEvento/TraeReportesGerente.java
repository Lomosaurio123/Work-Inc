
package com.working.controlador.ReporteEvento;

import com.working.dao.ReporteEventoDaoImpl;
import com.working.modelos.ReporteEvento;
import com.working.modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "TraeReportesGerente", urlPatterns = {"/TraeReportesGerente"})
public class TraeReportesGerente extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String CorreoGerente= UsuarioCreador.getCorreo();
            ReporteEventoDaoImpl TraerReporte = new ReporteEventoDaoImpl();
            
            List<Usuario> Ingeniero = TraerReporte.TraeIngenierosSoft(0, CorreoGerente);
            List<ReporteEvento> TodosReportes = TraerReporte.traerProyectoGerente(1, CorreoGerente);
            List<ReporteEvento> TodosReportesEnviar =null;            
           int numerodereportes=0;
           ArrayList<ReporteEvento> ReportesTodos = new ArrayList<ReporteEvento>();
           ReporteEvento rep;
           
           for(ReporteEvento r : TodosReportes){
             String folio = r.getFolio();
             String moduloRep = r.getModuloFalla();
             String descripcion = r.getDescripcionFalla();
             String estado = r.getEstadoReporte();
             String etiqueta = r.getEtiqueta();
             String usuariofalla= r.getUsuarioFalla();
             String fechafall = r.getFechaFalla();
             String NombreOperador = r.getNombreOperador();
             String ApatOper = r.getApatOperador();
             String AmatOper= r.getAmatOperador();
             String EstadoAsignacion = r.getEstadoAsignacion();
             int InformacionIng = r.getInformacionIngenero();
              String solu = r.getSolucion();
             Usuario InfoIng = TraerReporte.TraeIngenierosSoftInfo(0, InformacionIng);
             String NombreIng=InfoIng.getNombre();
             String ApatIng= InfoIng.getApat();
             String AmatIng= InfoIng.getAmat();
             String CorreoIng= InfoIng.getCorreo();
             
             
               
                 rep=new ReporteEvento(moduloRep,descripcion,estado,usuariofalla,fechafall, etiqueta,folio,EstadoAsignacion,InformacionIng, NombreIng ,ApatIng ,AmatIng , CorreoIng,NombreOperador,ApatOper,AmatOper,solu);
                 ReportesTodos.add(rep);
                 TodosReportesEnviar.add(rep);
               numerodereportes ++;
           }
            
            request.setAttribute("TodosRepGeren", TodosReportesEnviar);
            request.setAttribute("TodosIngSoft", Ingeniero);
            request.getRequestDispatcher("ReporteEventos/AsignarReportesEvento.jsp").forward(request, response);
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String CorreoGerente= UsuarioCreador.getCorreo();
            ReporteEventoDaoImpl TraerReporte = new ReporteEventoDaoImpl();
            
            List<Usuario> Ingeniero = TraerReporte.TraeIngenierosSoft(0, CorreoGerente);
            List<ReporteEvento> TodosReportes = TraerReporte.traerProyectoGerente(1, CorreoGerente);
            List<ReporteEvento> TodosReportesEnviar = new  ArrayList<>();          
           int numerodereportes=0;
           ArrayList<ReporteEvento> ReportesTodos = new ArrayList<ReporteEvento>();
           ReporteEvento rep;
           String NombreIng="";
           String ApatIng ="";
           String AmatIng="";
           String CorreoIng="";
           
           for(ReporteEvento r : TodosReportes){
             String folio = r.getFolio();
             String moduloRep = r.getModuloFalla();
             String descripcion = r.getDescripcionFalla();
             String estado = r.getEstadoReporte();
             String etiqueta = r.getEtiqueta();
             String usuariofalla= r.getUsuarioFalla();
             String fechafall = r.getFechaFalla();
             String NombreOperador = r.getNombreOperador();
             String ApatOper = r.getApatOperador();
             String AmatOper= r.getAmatOperador();
             String EstadoAsignacion = r.getEstadoAsignacion();
             int InformacionIng = r.getInformacionIngenero();
             String soluc = r.getSolucion();
             if(InformacionIng==0){
                 
                 NombreIng = "Sin";
                 ApatIng = "ingeniero";
                 AmatIng = "asignado";
                 CorreoIng = "nada";
                 
             }else{
                 Usuario InfoIng = TraerReporte.TraeIngenierosSoftInfo(0, InformacionIng);
                 NombreIng = InfoIng.getNombre();
                 ApatIng = InfoIng.getApat();
                 AmatIng = InfoIng.getAmat();
                 CorreoIng = InfoIng.getCorreo();
                 
             }
             
             
             
             
              try{
                  rep=new ReporteEvento(moduloRep,descripcion,estado,usuariofalla,fechafall, etiqueta,folio,EstadoAsignacion,InformacionIng, NombreIng ,ApatIng ,AmatIng , CorreoIng,NombreOperador,ApatOper,AmatOper,soluc);
                 TodosReportesEnviar.add(rep);
                  
              } catch(Exception e){
                  System.out.println("error en "+ e.toString());
              }
                 
               numerodereportes ++;
           }
            
            request.setAttribute("TodosRepGeren", TodosReportesEnviar);
            request.setAttribute("TodosIngSoft", Ingeniero);
            request.getRequestDispatcher("ReporteEventos/AsignarReportesEvento.jsp").forward(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           HttpSession session = request.getSession(true);
            Usuario UsuarioCreador= (Usuario)session.getAttribute("usuario");
            String CorreoGerente= UsuarioCreador.getCorreo();
            ReporteEventoDaoImpl TraerReporte = new ReporteEventoDaoImpl();
            
            List<Usuario> Ingeniero = TraerReporte.TraeIngenierosSoft(0, CorreoGerente);
            List<ReporteEvento> TodosReportes = TraerReporte.traerProyecto(1, CorreoGerente);
            request.setAttribute("TodosRepGeren", TodosReportes);
            request.setAttribute("TodosIngSoft", Ingeniero);
            request.getRequestDispatcher("ReporteEventos/AsignarReportesEvento.jsp").forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
