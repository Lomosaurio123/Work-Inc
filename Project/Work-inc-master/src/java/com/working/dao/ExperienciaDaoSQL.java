/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.dao;

import com.working.conexion.ConexionBD;
import com.working.idao.iExperienciaDao;
import com.working.modelos.Experiencia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.owasp.esapi.ESAPI;

/**
 *
 * @author Alumno
 */
public class ExperienciaDaoSQL implements iExperienciaDao {
    
    private final String EXPERIENCIA = "{call AltaExperiencia(?,?,?,?,?,?,?,?)}";
    private final String BUSEXPERIENCIA = "{call BusquedaExperiencia(?,?,?)}";
    
    
   
    private Connection cnx;
    ConexionBD Conexion = new  ConexionBD(); 
    
    public ExperienciaDaoSQL() {  
        this.cnx = Conexion.getConectar();
    }
    @Override
    public boolean altaExperiencia(Experiencia xp) {
        
        ResultSet rs = null;
        CallableStatement st = null;
        String id = "alta";
        try {       
            st = cnx.prepareCall(EXPERIENCIA);
            st.setString(1, id);
            st.setInt(2, xp.getId_experiencia());
            st.setString(3, ESAPI.encoder().encodeForHTML(xp.getCorreo()));
            st.setString(4, ESAPI.encoder().encodeForHTML(xp.getPuesto()));
            st.setString(5, ESAPI.encoder().encodeForHTML(xp.getEmpresa()));
            st.setString(6, ESAPI.encoder().encodeForHTML(xp.getFuncion()));
            st.setString(7, ESAPI.encoder().encodeForHTML(xp.getInicio()));
            st.setString(8, ESAPI.encoder().encodeForHTML(xp.getFin()));
            rs = st.executeQuery();
            return true;            
        } catch (Exception e) {
            System.out.println("Error en altaExperienciaSQL " +e.toString());
        } finally {
        }
        try {
            Conexion.cerrarConectar();
        } catch (SQLException ex) {
            
        }
        return false;
    }

    @Override
    public boolean actualizaExperiencia(Experiencia xp) {
        
        ResultSet rs = null;
        CallableStatement st = null;
        String id = "actualiza";
        try {
            st = cnx.prepareCall(EXPERIENCIA);
            st.setString(1, id);
            st.setInt(2, xp.getId_experiencia());
            st.setString(3, ESAPI.encoder().encodeForHTML(xp.getCorreo()));
            st.setString(4, ESAPI.encoder().encodeForHTML(xp.getPuesto()));
            st.setString(5, ESAPI.encoder().encodeForHTML(xp.getEmpresa()));
            st.setString(6, ESAPI.encoder().encodeForHTML(xp.getFuncion()));
            st.setString(7, ESAPI.encoder().encodeForHTML(xp.getInicio()));
            st.setString(8, ESAPI.encoder().encodeForHTML(xp.getFin()));
            rs = st.executeQuery();
             if(rs.next()){
                String msj = rs.getString("mensaje");
                if(msj.equals("Experiencia actualizada")){
                    return true;
                }else{
                    return false;
                }
            }
            return true;            
            } catch (Exception e) {
            System.out.println("Error en altausuarioimple " +e.toString());
        } finally {
        }
        try {
            Conexion.cerrarConectar();
        } catch (SQLException ex) {
            System.out.println("error en la conexion XP-SQL");
        }
        
        return false;
    }

    @Override
    public boolean borrarExperiencia(int idxp) {
        ResultSet res;
        CallableStatement st = null;
        String id = "borrar";
        try{
            st = cnx.prepareCall(BUSEXPERIENCIA);
            st.setString(1, id);
            st.setString(2, "");
            st.setInt(3, idxp);
            res = st.executeQuery();
            if(res.next()){
                String msj = res.getString("mensaje");
                if(msj.equals("experiencia borrarada")){
                    return true;
                }
            }
            
        }catch(Exception e){
            System.out.println("Error en actualizaExperienciaSQL:  "+ e.getMessage());
        }
        return false;
    }

    @Override
    public List<Experiencia> traeExperiencia(String correo) {
        ResultSet rs = null;
        CallableStatement st = null;
        List<Experiencia> pro = new ArrayList<>();
        String id= "consulta";
                try {
            st = cnx.prepareCall(BUSEXPERIENCIA);
            st.setString(1, id);
            st.setString(2, ESAPI.encoder().encodeForHTML(correo));
            st.setInt(3,0);
            rs = st.executeQuery();
            while (rs.next()) {
                pro.add((ConvertirXP(rs)));
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
    private Experiencia ConvertirXP(ResultSet rs) throws SQLException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaInicio = sdf.format(rs.getDate("inicio"));
        String fechafin = sdf.format(rs.getDate("final"));
        Experiencia xp = new Experiencia(rs.getInt("id_experiencia"),rs.getString("puesto"),rs.getString("empresa"),rs.getString("funcion"), fechaInicio,fechafin);
        return xp;
    }
    
}
