/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.dao;

import com.working.conexion.ConexionBD;
import com.working.idao.iCursoDao;
import com.working.modelos.Cursos;
import com.working.modelos.Escolaridad;
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
public class CursoDaoSQL implements iCursoDao {
    private final String CURSO = "{call Altacursos(?,?,?,?,?,?)}";
    private final String BUSCURSO = "{call BusquedaCursos(?,?,?)}";
    private Connection cnx;
    ConexionBD Conexion = new  ConexionBD(); 
    
    public CursoDaoSQL() {  
        this.cnx = Conexion.getConectar();
    }
    @Override
    public boolean altaCursos(Cursos cur) {
        ResultSet rs = null;
        CallableStatement st = null;
        String id = "alta";
        try {       
            st = cnx.prepareCall(CURSO);
            st.setString(1, id);
            st.setInt(2, 0);
            st.setString(3, ESAPI.encoder().encodeForHTML(cur.getCorreo()));
            st.setString(4, ESAPI.encoder().encodeForHTML(cur.getNombre_curso()));
            st.setString(5, ESAPI.encoder().encodeForHTML(cur.getAño()));
            st.setInt(6, cur.getDuracion());
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
    public boolean actualizaCursos(Cursos cur) {
        ResultSet rs = null;
        CallableStatement st = null;
        String id = "actualiza";
        try {       
            st = cnx.prepareCall(CURSO);
            st.setString(1, id);
            st.setInt(2, cur.getId_cursos());
            st.setString(3, ESAPI.encoder().encodeForHTML(cur.getCorreo()));
            st.setString(4, ESAPI.encoder().encodeForHTML(cur.getNombre_curso()));
            st.setString(5, ESAPI.encoder().encodeForHTML(cur.getAño()));
            st.setInt(6, cur.getDuracion());
            rs = st.executeQuery();
            if(rs.next()){
                String msj = rs.getString("mensaje");
                if(msj.equals("curso actualizado")){
                    return true;
                }else{
                    return false;
                }
            }              
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
    public boolean borrarCursos(int id_Cur) {
        ResultSet rs = null;
        CallableStatement st = null;
        String id = "borrar";
        try {       
            st = cnx.prepareCall(BUSCURSO);
            st.setString(1, id);
            st.setString(2, "");
            st.setInt(3, id_Cur);
            rs = st.executeQuery();
            if(rs.next()){
                String msj = rs.getString("mensaje");
                if(msj.equals("curso borrado")){
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
    public List<Cursos> traeCursos(String correo) {
        ResultSet rs = null;
        CallableStatement st = null;
        List<Cursos> pro = new ArrayList<>();
        String id= "consulta";
                try {
            st = cnx.prepareCall(BUSCURSO);
            st.setString(1, id);
            st.setString(2, ESAPI.encoder().encodeForHTML(correo));
            st.setInt(3 , 0);
            rs = st.executeQuery();
            while (rs.next()) {
                pro.add((ConvertirEsco(rs)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProyectoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("error en SQlCurso" + ex.getMessage());
        } finally {
            try {
                Conexion.cerrarConectar();
            } catch (Exception ex) {
            }
        }
        return pro;
    }
    private Cursos ConvertirEsco(ResultSet rs) throws SQLException{
        Cursos xp = new Cursos(rs.getInt("id_cursos"),rs.getString("Nombre_Curso"),rs.getString("año"),rs.getInt("duracion"));
        return xp;
    }
      
}
