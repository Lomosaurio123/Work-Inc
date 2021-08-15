
package com.working.dao;

import com.working.conexion.ConexionBD;
import com.working.modelos.ReporteMantenimiento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.owasp.esapi.ESAPI;


public class ReporteMantenimientoDaoImpl {
    
    private final String TRAEREPORTEMANTENIMIENTO ="{call TraeReporteMantenimiento(?,?)}";
    
      private Connection cnx;
    ConexionBD Conexion = new ConexionBD();

    public ReporteMantenimientoDaoImpl() {
        this.cnx = Conexion.getConectar();
    }
    
     public List<ReporteMantenimiento> traerReporteMantenimiento(int id, String Correo) {

        ResultSet rs = null;
        CallableStatement st = null;
        List<ReporteMantenimiento> Reportes = new ArrayList<>();
        

        try {
            st = cnx.prepareCall(TRAEREPORTEMANTENIMIENTO);
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
     
     
      private ReporteMantenimiento ConvertirReporte(ResultSet rs) throws SQLException{
        ReporteMantenimiento RepMan = new ReporteMantenimiento(rs.getString("EventosReporte.ModuloE"),rs.getString("DescripcionE"),rs.getString("EstadoE"),rs.getString("UsuarioFalla"), rs.getString("Fecha"), rs.getString("Folio"), rs.getString("EstadoE"));
        return RepMan;
    }
    
    
    
    
    
}
