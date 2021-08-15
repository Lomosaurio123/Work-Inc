/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.dao;

import com.working.conexion.ConexionBD;
import com.working.idao.iIdiomaDao;
import com.working.modelos.Escolaridad;
import com.working.modelos.Idioma;
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
public class IdiomaDaoSQL implements iIdiomaDao{
    private final String IDIOMA = "{call Altaidiomas(?,?,?,?,?,?,?,?)}";
    private final String BUSIDIOMA = "{call BusquedaIdioma(?,?,?)}";
    private Connection cnx;
    ConexionBD Conexion = new  ConexionBD(); 
    
    public IdiomaDaoSQL() {  
        this.cnx = Conexion.getConectar();
    }
    @Override
    public boolean altaIdioma(Idioma idi) {
        ResultSet rs = null;
        CallableStatement st = null;
        String id = "alta";
        try {       
            st = cnx.prepareCall(IDIOMA);
            st.setString(1, id);
            st.setInt(2, 0);
            st.setString(3, ESAPI.encoder().encodeForHTML(idi.getCorreo()));
            st.setString(4, ESAPI.encoder().encodeForHTML(idi.getIdioma()));
            st.setString(5, ESAPI.encoder().encodeForHTML(idi.getNivelhabla()));
            st.setString(6, ESAPI.encoder().encodeForHTML(idi.getNivelescrito()));
            st.setString(7, ESAPI.encoder().encodeForHTML(idi.getNivelescucha()));
            st.setString(8, ESAPI.encoder().encodeForHTML(idi.getCertificado()));
            rs = st.executeQuery();
            return true;            
        } catch (Exception e) {
            System.out.println("Error en altaIDIOMASQL " +e.toString());
        } finally {
        }
        try {
            Conexion.cerrarConectar();
        } catch (SQLException ex) {
            
        }
        return false;
    }

    @Override
    public boolean actualizaIdioma(Idioma idi) {
        ResultSet rs = null;
        CallableStatement st = null;
        String id = "actualiza";
        try {       
            st = cnx.prepareCall(IDIOMA);
            st.setString(1, id);
            st.setInt(2, idi.getId_idioma());
            st.setString(3, ESAPI.encoder().encodeForHTML(idi.getCorreo()));
            st.setString(4, ESAPI.encoder().encodeForHTML(idi.getIdioma()));
            st.setString(5, ESAPI.encoder().encodeForHTML(idi.getNivelhabla()));
            st.setString(6, ESAPI.encoder().encodeForHTML(idi.getNivelescrito()));
            st.setString(7, ESAPI.encoder().encodeForHTML(idi.getNivelescucha()));
            st.setString(8, ESAPI.encoder().encodeForHTML(idi.getCertificado()));
            rs = st.executeQuery();
            if(rs.next()){
                String msj = rs.getString("mensaje");
                if(msj.equals("idioma actualizado")){
                    return true;
                }else{
                    return false;
                }
            }
            return true;            
        } catch (Exception e) {
            System.out.println("Error en actualizaIdiomaSQL " +e.toString());
        } finally {
        }
        try {
            Conexion.cerrarConectar();
        } catch (SQLException ex) {
            
        }
        return false;
    }

    @Override
    public boolean borrarIdioma(int id_idioma) {
        ResultSet rs = null;
        CallableStatement st = null;
        String id = "borrar";
        try {       
            st = cnx.prepareCall(BUSIDIOMA);
            st.setString(1, id);
            st.setString(2, "");
            st.setInt(3, id_idioma);
            rs = st.executeQuery();
            if(rs.next()){
                String msj = rs.getString("mensaje");
                if(msj.equals("idioma borrado")){
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
    public List<Idioma> traeIdioma(String correo) {
      ResultSet rs = null;
        CallableStatement st = null;
        List<Idioma> pro = new ArrayList<>();
        String id= "consulta";
                try {
            st = cnx.prepareCall(BUSIDIOMA);
            st.setString(1, id);
            st.setString(2, ESAPI.encoder().encodeForHTML(correo));
            st.setInt(3 , 0);
            rs = st.executeQuery();
            while (rs.next()) {
                pro.add((ConvertirEsco(rs)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProyectoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("error en SQLIDI" + ex.getMessage());
        } finally {
            try {
                Conexion.cerrarConectar();
            } catch (Exception ex) {
            }
        }
        return pro;
    }
    private Idioma ConvertirEsco(ResultSet rs) throws SQLException{
        Idioma xp = new Idioma(rs.getInt("id_idiomas"),rs.getString("idioma"),rs.getString("nivelhabla"),rs.getString("nivelescrito"),rs.getString("nivelescucha"),rs.getString("certificado"));
        return xp;
    }
    
}
