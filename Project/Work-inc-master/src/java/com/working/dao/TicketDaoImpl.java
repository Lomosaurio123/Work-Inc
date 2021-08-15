
package com.working.dao;

import com.working.conexion.ConexionBD;
import com.working.controlador.ReporteEvento.random;
import com.working.modelos.Ticket;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.owasp.esapi.ESAPI;


public class TicketDaoImpl {
     private final String GuardaTicket = "{call GuardaTicket(?,?,?,?)}";
     private final String TraeTicket = "{call ConsultaTicket(?,?)}";
     private final String AsignaTicket = "{call AsignaTicket(?,?)}";
     private final String ResponderTicket = "{call RespondeTicket(?,?,?)}";
     
      private Connection cnx;
      ConexionBD Conexion = new ConexionBD();
      
       public TicketDaoImpl() {
        this.cnx = Conexion.getConectar();
    }
       
      public boolean AltaTicket(Ticket p) {
        ResultSet rs = null;
        CallableStatement st = null;
        boolean altaTicket = false;
        try {
            st = cnx.prepareCall(GuardaTicket);
            
            st.setString(1,p.getModulo() );
            st.setString(2,p.getDescripcionProblema() );
            st.setString(3, ESAPI.encoder().encodeForHTML(p.getCorreoUsuarioTicket()));
            random ran = new random();
            String Folio= ran.getPassword(); 
            st.setString(4,Folio);
           
            rs = st.executeQuery();
            altaTicket = true;

        } catch (Exception e) {
            System.out.println("Error en altaTicket de "+e.toString());
        } finally {
            try {
                Conexion.cerrarConectar();
            }catch (Exception ex) {
                
                }
        }
        return altaTicket;
    }
      
      
      public List<Ticket> traerTicketsUsu(int id, String Correo) {

        ResultSet rs = null;
        CallableStatement st = null;
        List<Ticket> ticke = new ArrayList<>();
        

        try {
            st = cnx.prepareCall(TraeTicket);
            st.setInt(1, id);
            st.setString(2,ESAPI.encoder().encodeForHTML(Correo));
            rs = st.executeQuery();
            while (rs.next()) {
                ticke.add((ConvertirTicketEspecifico(rs)));
            }

        } catch (Exception e) {
            System.out.println("Error en " +e.toString());
        } 
        return ticke;
    }
    
    
        private Ticket ConvertirTicketEspecifico(ResultSet rs) throws SQLException{
        Ticket t = new Ticket(rs.getString("Folio"), rs.getString("EstadoRevision"),rs.getInt("Id_ResponsableRevision"),     
        rs.getString("FechaCreacion"),rs.getString("Modulo"),
        rs.getString("DescripcionProblema"), rs.getString("Respuesta"));
        return t;
    }
     
        
        
        
        
        public boolean AsignarTicket(String folio, String CooreoAdminAsignado) {
        ResultSet rs = null;
        CallableStatement st = null;
        boolean ModificaExito = false;
        try {
            st = cnx.prepareCall(AsignaTicket);
            st.setString(1, folio);
            st.setString(2,ESAPI.encoder().encodeForHTML(CooreoAdminAsignado));
            rs = st.executeQuery();
            ModificaExito = true;

        } catch (Exception e) {
            System.out.println("Error en altaTicket de "+e.toString());
        } finally {
            try {
                Conexion.cerrarConectar();
            }catch (Exception ex) {
                
                }
        }
        return ModificaExito;
    }
     
        
        
  public boolean ResponderTicket(String folio, String CooreoAdminAsignado, String Respuesta) {
        ResultSet rs = null;
        CallableStatement st = null;
        boolean RespondeTicket = false;
        try {
            st = cnx.prepareCall(ResponderTicket);
            st.setString(1, folio);
            st.setString(2,ESAPI.encoder().encodeForHTML(CooreoAdminAsignado));
            st.setString(3, Respuesta);
            rs = st.executeQuery();
            RespondeTicket = true;

        } catch (Exception e) {
            System.out.println("Error en altaTicket de "+e.toString());
        } finally {
            try {
                Conexion.cerrarConectar();
            }catch (Exception ex) {
                
                }
        }
        return RespondeTicket;
    }
        
        
        
        
        
        
        
    
}
