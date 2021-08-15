/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.dao;

import com.working.conexion.ConexionBD;
import com.working.idao.iHabilidadDao;
import com.working.modelos.Habilidades;
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
public class HabilidadesDaoSQL implements iHabilidadDao{
    private final String HABILIDAD = "{call Altahabilidad(?,?,?,?)}";
    private final String BUSHABILIDAD = "{call Busquedahabilidad(?,?,?)}";
    
    private Connection cnx;
    ConexionBD Conexion = new  ConexionBD(); 
    
    public HabilidadesDaoSQL() {  
        this.cnx = Conexion.getConectar();
    }
    @Override
    public boolean altaHabilidades(Habilidades hab) {
        ResultSet rs = null;
        CallableStatement st = null;
        String id = "alta";
        try {       
            st = cnx.prepareCall(HABILIDAD);
            st.setString(1, id);
            st.setInt(2, hab.getId_habilidad());
            st.setString(3, ESAPI.encoder().encodeForHTML(hab.getCorreo()));
            st.setString(4, ESAPI.encoder().encodeForHTML(hab.getHabilidad()));
            rs = st.executeQuery();
            return true;            
        } catch (Exception e) {
            System.out.println("Error en altaHABILIDADSQL " +e.toString());
        } finally {
        }
        try {
            Conexion.cerrarConectar();
        } catch (SQLException ex) {
            
        }
        return false;
    }

    @Override
    public boolean actualizaHabilidades(Habilidades hab) {
        ResultSet rs = null;
        CallableStatement st = null;
        String id = "actualiza";
        try {
            st = cnx.prepareCall(HABILIDAD);
            st.setString(1, id);
            st.setInt(2, hab.getId_habilidad());
            st.setString(3, ESAPI.encoder().encodeForHTML(hab.getCorreo()));
            st.setString(4, ESAPI.encoder().encodeForHTML(hab.getHabilidad()));
            rs = st.executeQuery();
             if(rs.next()){
                String msj = rs.getString("mensaje");
                if(msj.equals("habilidad actualizada")){
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
    public boolean borrarHabilidades(int id_hab) {
        ResultSet res;
        CallableStatement st = null;
        String id = "borrar";
        try{
            st = cnx.prepareCall(BUSHABILIDAD);
            st.setString(1, id);
            st.setString(2, "");
            st.setInt(3, id_hab);
            res = st.executeQuery();
            if(res.next()){
                String msj = res.getString("mensaje");
                if(msj.equals("habilidad borrada")){
                    return true;
                }
            }
            
        }catch(Exception e){
            System.out.println("Error en actualizaExperienciaSQL:  "+ e.getMessage());
        }
        return false;
    }

    @Override
    public List<Habilidades> traeHabilidades(String correo) {
        ResultSet rs = null;
        CallableStatement st = null;
        List<Habilidades> pro = new ArrayList<>();
        String id= "consulta";
                try {
            st = cnx.prepareCall(BUSHABILIDAD);
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
    private Habilidades ConvertirXP(ResultSet rs) throws SQLException{
        Habilidades xp = new Habilidades(rs.getInt("id_habilidad"),rs.getString("Habilidad"));
        return xp;
    }
    
}
