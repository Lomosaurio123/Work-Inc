/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.dao;

import com.working.conexion.ConexionBD;
import com.working.idao.iEscolaridadDao;
import com.working.modelos.Escolaridad;
import com.working.modelos.Experiencia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.owasp.esapi.ESAPI;

/**
 *
 * @author Hp
 */
public class EscolaridadDaoSQL implements iEscolaridadDao{
    private final String ESCOLARIDAD = "{call AltaEscolaridad(?,?,?,?,?,?,?)}";
    private final String BUSESCOLARIDAD = "{call BusquedaEscolaridad(?,?,?)}";
    private Connection cnx;
    ConexionBD Conexion = new  ConexionBD(); 
    
    public EscolaridadDaoSQL() {  
        this.cnx = Conexion.getConectar();
    }
    @Override
    public boolean altaEscolaridad(Escolaridad esco) {
        ResultSet rs = null;
        CallableStatement st = null;
        String id = "alta";
        try {       
            st = cnx.prepareCall(ESCOLARIDAD);
            st.setString(1, id);
            st.setInt(2, 0);
            st.setString(3, ESAPI.encoder().encodeForHTML(esco.getCorreo()));
            st.setString(4, ESAPI.encoder().encodeForHTML(esco.getEscuela()));
            st.setString(5, ESAPI.encoder().encodeForHTML(esco.getCarrera()));
            st.setString(6, ESAPI.encoder().encodeForHTML(esco.getInicio()));
            st.setString(7, ESAPI.encoder().encodeForHTML(esco.getFin()));
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
    public boolean actualizaEscolaridad(Escolaridad esco) {
       ResultSet rs = null;
        CallableStatement st = null;
        String id = "actualiza";
        try {       
            st = cnx.prepareCall(ESCOLARIDAD);
            st.setString(1, id);
            st.setInt(2, esco.getId_escolaridad());
            st.setString(3, ESAPI.encoder().encodeForHTML(esco.getCorreo()));
            st.setString(4, ESAPI.encoder().encodeForHTML(esco.getEscuela()));
            st.setString(5, ESAPI.encoder().encodeForHTML(esco.getCarrera()));
            st.setString(6, ESAPI.encoder().encodeForHTML(esco.getInicio()));
            st.setString(7, ESAPI.encoder().encodeForHTML(esco.getFin()));
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
    public boolean borrarEscolaridad(int id_esco) {
        ResultSet rs = null;
        CallableStatement st = null;
        String id = "borrar";
        try {       
            st = cnx.prepareCall(BUSESCOLARIDAD);
            st.setString(1, id);
            st.setString(2, "");
            st.setInt(3, id_esco);
            rs = st.executeQuery();
            if(rs.next()){
                String msj = rs.getString("mensaje");
                if(msj.equals("escolaridad borrada")){
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
    public List<Escolaridad> traeEscolaridad(String correo) {
        ResultSet rs = null;
        CallableStatement st = null;
        List<Escolaridad> pro = new ArrayList<>();
        String id= "consulta";
                try {
            st = cnx.prepareCall(BUSESCOLARIDAD);
            st.setString(1, id);
            st.setString(2, ESAPI.encoder().encodeForHTML(correo));
            st.setInt(3 , 0);
            rs = st.executeQuery();
            while (rs.next()) {
                pro.add((ConvertirEsco(rs)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProyectoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("error en SQlXP" + ex.getMessage());
        } finally {
            try {
                Conexion.cerrarConectar();
            } catch (Exception ex) {
            }
        }
        return pro;
    }
    private Escolaridad ConvertirEsco(ResultSet rs) throws SQLException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaInicio = sdf.format(rs.getDate("inicio"));
        String fechafin = sdf.format(rs.getDate("final"));
        Escolaridad xp = new Escolaridad(rs.getInt("id_escolaridad"),rs.getString("Escuela"),rs.getString("Carrera"), fechaInicio,fechafin);
        return xp;
    }
    
}
