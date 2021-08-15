
package com.working.dao;

import com.working.conexion.ConexionBD;
import com.working.controlador.ReporteEvento.random;
import com.working.modelos.ReporteEvento;
import com.working.modelos.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.owasp.esapi.ESAPI;


public class ReporteEventoDaoImpl {
    
        private final String ALTAREPORTEEVENTO = "{call AltaReporteEvento(?,?,?,?,?,?,?)}";
        private final String MODIFICAREPORTEEVENTO = "{call ModificaReporteEvento(?,?,?,?,?,?,?)}";
        private final String CONSULTAREPORTEEVENTO ="{call ConsultaReporteEvento(?,?)}";
        private final String CONSULTAINGENIEROSSOFT ="{call ConsultaIngenierosSoft(?,?)}";
        private final String ASIGNACIONINGENIERO ="{call AsignacionIngeniero(?,?)}";
        private final String CONSULTAINFOING ="{call ConsultaInfoIng(?,?)}";
        private final String ELIMINAREPORTEING ="{call EliminaReporteEvento(?,?)}";
        private final String CERRARREPORTE="{call CerrarReporteDeEvento(?,?)}";
        private final String REPORTEMANTENIMIENTO="{call AsignarMantenimientoReporte(?)}";

    private Connection cnx;
    ConexionBD Conexion = new ConexionBD();

    public ReporteEventoDaoImpl() {
        this.cnx = Conexion.getConectar();
    }
    
     public boolean AltaReporteEvento(ReporteEvento R) {
        ResultSet rs = null;
        CallableStatement st = null;
        boolean alta = false;
        try {
            st = cnx.prepareCall(ALTAREPORTEEVENTO);
            st.setString(1, R.getModuloFalla());
            st.setString(2, R.getDescripcionFalla());
            st.setString(3, R.getUsuarioFalla());
            st.setString(4, R.getEstadoReporte());
            st.setString(5, R.getEtiqueta());
            
            random ran = new random();
            String Folio= ran.getPassword(); 
            
            st.setString(6, Folio);
            st.setString(7, ESAPI.encoder().encodeForHTML(R.getOperador()));
            
            rs = st.executeQuery();
            alta = true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                Conexion.cerrarConectar();
            }catch (Exception ex) {
                
                }
        }
        return alta;
    }
     
     
     
    public List<ReporteEvento> traerProyecto(int id, String Correo) {

        ResultSet rs = null;
        CallableStatement st = null;
        List<ReporteEvento> Reportes = new ArrayList<>();
        

        try {
            st = cnx.prepareCall(CONSULTAREPORTEEVENTO);
            st.setInt(1, id);
            st.setString(2,ESAPI.encoder().encodeForHTML(Correo));
            rs = st.executeQuery();
            while (rs.next()) {
                Reportes.add((ConvertirReporte(rs)));
            }

        } catch (SQLException ex) {
            System.out.println("Error al traer reporte causado por" + ex.toString());
        } 
        return Reportes;
    }
    
    
     public List<ReporteEvento> traerProyectoGerente(int id, String Correo) {

        ResultSet rs = null;
        CallableStatement st = null;
        List<ReporteEvento> Reportes = new ArrayList<>();
        

        try {
            st = cnx.prepareCall(CONSULTAREPORTEEVENTO);
            st.setInt(1, id);
            st.setString(2,ESAPI.encoder().encodeForHTML(Correo));
            rs = st.executeQuery();
            while (rs.next()) {
                Reportes.add((ConvertirReporteGerente(rs)));
            }

        } catch (SQLException ex) {
            System.out.println("Error al traer reporte causado por" + ex.toString());
        } 
        return Reportes;
    }
    
    
       private ReporteEvento ConvertirReporte(ResultSet rs) throws SQLException{
        ReporteEvento Rep = new ReporteEvento(rs.getString("EventosReporte.ModuloE"),rs.getString("DescripcionE"),rs.getString("EstadoE"),rs.getString("UsuarioFalla"), rs.getString("Fecha"), rs.getString("EtiquetaE"), rs.getString("Folio"),rs.getString("Nombre"),  rs.getString("Apat"), rs.getString("Amat")       );
        return Rep;
    }
        private ReporteEvento ConvertirReporteGerente(ResultSet rs) throws SQLException{
        ReporteEvento Rep = new ReporteEvento(rs.getString("EventosReporte.ModuloE"),rs.getString("DescripcionE"),rs.getString("EstadoE"),rs.getString("UsuarioFalla"), rs.getString("Fecha"), rs.getString("EtiquetaE"), rs.getString("Folio"), rs.getString("Asignacion"),rs.getInt("Id_IngenieroAsignado"),rs.getString("Nombre"),  rs.getString("Apat"), rs.getString("Amat"),rs.getString("solucion"));
        return Rep;
    }
         
       
            public boolean ModificaReporte(ReporteEvento R) {
        ResultSet rs = null;
        CallableStatement st = null;
        boolean modificacion = false;
        try {
            st = cnx.prepareCall(MODIFICAREPORTEEVENTO);
            st.setString(1, R.getModuloFalla());
            st.setString(2, R.getDescripcionFalla());
            st.setString(3, R.getUsuarioFalla());
            st.setString(4, R.getEstadoReporte());
            st.setString(5, R.getEtiqueta());
            st.setString(6, R.getFolio());
            st.setString(7, ESAPI.encoder().encodeForHTML(R.getOperador()));
            
            rs = st.executeQuery();
            modificacion = true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                Conexion.cerrarConectar();
            }catch (Exception ex) {
                
                }
        }
        return modificacion;
    }
     
            
            
     public List<Usuario> TraeIngenierosSoft(int id, String Correo) {

        ResultSet rs = null;
        CallableStatement st = null;
        List<Usuario> Ingenieros = new ArrayList<>();
        

        
        try {
            st = cnx.prepareCall(CONSULTAINGENIEROSSOFT);
            st.setInt(1, id);
            st.setString(2,ESAPI.encoder().encodeForHTML(Correo));
            rs = st.executeQuery();
            while (rs.next()) {
                Ingenieros.add((ConvertirIngeni(rs)));
            }

        } catch (SQLException ex) {
            System.out.println("Error al traer ingenieros causado por" + ex.toString());
        } 
        return Ingenieros;
    }
    
    
       private Usuario ConvertirIngeni(ResultSet rs) throws SQLException{
        Usuario Ingeniero = new Usuario(rs.getString("Nombre"),rs.getString("Apat"),rs.getString("Amat"),rs.getString("Correo"), rs.getString("Contra"), rs.getString("TipoUsuario") );
        return Ingeniero;
    }
         
       
            public boolean AsignacionReporteIng(String folio, String correoIng) {
        ResultSet rs = null;
        CallableStatement st = null;
        boolean asignacion = false;
        try {
            st = cnx.prepareCall(ASIGNACIONINGENIERO);
            st.setString(1,folio);
            st.setString(2,ESAPI.encoder().encodeForHTML(correoIng) );
            
            rs = st.executeQuery();
            asignacion = true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                Conexion.cerrarConectar();
            }catch (Exception ex) {
                
                }
        }
        return asignacion;
    }
            
            
public Usuario TraeIngenierosSoftInfo(int id, int infoIngeniero) {

        ResultSet rs = null;
        CallableStatement st = null;
        Usuario Ingenieros=null;
        
        try {
            st = cnx.prepareCall(CONSULTAINFOING);
            st.setInt(1, id);
            st.setInt(2,infoIngeniero);
            rs = st.executeQuery();
            if(rs.next()) {
                Ingenieros=ConvertirIngeInfo(rs);
            }

        } catch (SQLException ex) {
            System.out.println("Error al traer ingenieros causado por" + ex.toString());
        } 
        return Ingenieros;
    }
    
    
       private Usuario ConvertirIngeInfo(ResultSet rs) throws SQLException{
        Usuario Ingeniero = new Usuario(rs.getString("Nombre"),rs.getString("Apat"),rs.getString("Amat"),rs.getString("Correo"), rs.getString("Contra"), rs.getString("TipoUsuario") );
        return Ingeniero;
    }
       
           public boolean EliminarReporteEven(String folio, String correoGerente) {
        ResultSet rs = null;
        CallableStatement st = null;
        boolean EliminacionExitosa = false;
        try {
            st = cnx.prepareCall(ELIMINAREPORTEING);
            st.setString(1,folio);
            st.setString(2,ESAPI.encoder().encodeForHTML(correoGerente) );
            rs = st.executeQuery();
            EliminacionExitosa = true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                Conexion.cerrarConectar();
            }catch (Exception ex) {
                
                }
        }
        return EliminacionExitosa;
    }
            
    public boolean CerrarReporte(ReporteEvento R, String solucion) {
        ResultSet rs = null;
        CallableStatement st = null;
        boolean modificacion = false;
        try {
            st = cnx.prepareCall(CERRARREPORTE);
            st.setString(1, R.getFolio());
            st.setString(2, solucion);
            
            rs = st.executeQuery();
            modificacion = true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                Conexion.cerrarConectar();
            }catch (Exception ex) {
                
                }
        }
        return modificacion;
    }        
        public boolean AsignarReporteMantenimiento(String FolioReporteMantenimiento) {
        ResultSet rs = null;
        CallableStatement st = null;
        boolean mantenimientoasignacion = false;
        try {
            st = cnx.prepareCall(REPORTEMANTENIMIENTO);
            st.setString(1, FolioReporteMantenimiento);
 
            rs = st.executeQuery();
            mantenimientoasignacion = true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                Conexion.cerrarConectar();
            }catch (Exception ex) {
                
                }
        }
        return mantenimientoasignacion;
    }  
    
    
    
    
    
}
