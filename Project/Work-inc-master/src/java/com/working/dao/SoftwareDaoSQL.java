/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.dao;

import com.working.conexion.ConexionBD;
import com.working.idao.iSoftwareDao;
import com.working.modelos.Escolaridad;
import com.working.modelos.Software;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.owasp.esapi.ESAPI;

/**
 *
 * @author Hp
 */
public class SoftwareDaoSQL implements iSoftwareDao{
    private final String SOFTWARE = "{call AltaEscolaridad(?,?,?,?,?,?)}";
    private final String BUSUSOFTWARE = "{call Busquedasoftware(?,?,?)}";
    private Connection cnx; 
    ConexionBD Conexion = new  ConexionBD(); 
    
    public SoftwareDaoSQL() {  
        this.cnx = Conexion.getConectar();
    }
    @Override
    public boolean altaSoftware(Software sof) {
         ResultSet rs = null;
        CallableStatement st = null;
        String id = "alta";
        try {       
            st = cnx.prepareCall(SOFTWARE);
            st.setString(1, id);
            st.setInt(2, 0);
            st.setString(3, ESAPI.encoder().encodeForHTML(sof.getCorreo()));
            st.setString(4, ESAPI.encoder().encodeForHTML(sof.getSoftware()));
            st.setString(5, ESAPI.encoder().encodeForHTML(sof.getAño()));
            st.setString(6, ESAPI.encoder().encodeForHTML(sof.getConstancia()));
            rs = st.executeQuery();
            return true;            
        } catch (Exception e) {
            System.out.println("Error en altaEscolaridadSQL " +e.toString());
        } finally {
        }
        try {
            Conexion.cerrarConectar();
        } catch (SQLException ex) {
            
        }
        return false;
    }

    @Override
    public boolean actualizaSoftware(Software sof) {
        ResultSet rs = null;
        CallableStatement st = null;
        String id = "actualiza";
        try {       
            st = cnx.prepareCall(SOFTWARE);
            st.setString(1, id);
            st.setInt(2, sof.getId_software());
            st.setString(3, ESAPI.encoder().encodeForHTML(sof.getCorreo()));
            st.setString(4, ESAPI.encoder().encodeForHTML(sof.getSoftware()));
            st.setString(5, ESAPI.encoder().encodeForHTML(sof.getAño()));
            st.setString(6, ESAPI.encoder().encodeForHTML(sof.getConstancia()));
            rs = st.executeQuery();
            if(rs.next()){
                String msj = rs.getString("mensaje");
                if(msj.equals("Escolaridad actualizada")){
                    return true;
                }else{
                    return false;
                }
            }
            return true;            
        } catch (Exception e) {
            System.out.println("Error en altaEscolaridadSQL " +e.toString());
        } finally {
        }
        try {
            Conexion.cerrarConectar();
        } catch (SQLException ex) {
            
        }
        return false;
    }

    @Override
    public boolean borrarSoftware(int id_sof) {
        ResultSet rs = null;
        CallableStatement st = null;
        String id = "borrar";
        try {       
            st = cnx.prepareCall(BUSUSOFTWARE);
            st.setString(1, id);
            st.setString(2, "");
            st.setInt(3, id_sof);
            rs = st.executeQuery();
            if(rs.next()){
                String msj = rs.getString("mensaje");
                if(msj.equals("software borrado")){
                    return true;
                }
            }
            return true;            
        } catch (Exception e) {
            System.out.println("Error en altaEscolaridadSQL " +e.toString());
        } finally {
        }
        try {
            Conexion.cerrarConectar();
        } catch (SQLException ex) {
            
        }
        return false;
    }

    @Override
    public List<Software> traeSoftware(String correo) {
        ResultSet rs = null;
        CallableStatement st = null;
        List<Software> pro = new ArrayList<>();
        String id= "consulta";
                try {
            st = cnx.prepareCall(BUSUSOFTWARE);
            st.setString(1, id);
            st.setString(2, ESAPI.encoder().encodeForHTML(correo));
            st.setInt(3 , 0);
            rs = st.executeQuery();
            while (rs.next()) {
                pro.add((ConvertirEsco(rs)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProyectoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("error en SQlXP"  + ex.getMessage());
        } finally {
            try {
                Conexion.cerrarConectar();
            } catch (Exception ex) {
            }
        }
        return pro;
    }
    private Software ConvertirEsco(ResultSet rs) throws SQLException{
        Software xp = new Software(rs.getInt("id_software"),rs.getString("software"),rs.getString("año"),rs.getString("constancia"));
        return xp;
    }
}
