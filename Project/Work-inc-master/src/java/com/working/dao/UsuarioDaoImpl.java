/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.dao;

import com.working.conexion.ConexionBD;
import com.working.idao.iUsuarioDao;
import com.working.modelos.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.owasp.esapi.ESAPI;


/**
 *
 * @author juan-
 */
public class UsuarioDaoImpl implements iUsuarioDao{
    
    private final String GUARDAUSUARIO = "{call GuardaUsuario(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    private final String CONSULTAUSUARIO="{call ConsultaUsuario(?,?)}"; 
    private final String ENTRAUSUARIO="{call EntraUsuario(?,?)}";
    private final String CONSULTACORREO="{call ConsultaCorreo(?)}";
    
   
    private Connection cnx;
    ConexionBD Conexion = new  ConexionBD(); 
    
    public UsuarioDaoImpl() {  
        this.cnx = Conexion.getConectar();
    }
    
    
    @Override
    public boolean altaUsuario(Usuario u) {
        
        ResultSet rs = null;
        CallableStatement st = null;
        boolean alta =false;
        int idpersona=0;

        try {
            st = cnx.prepareCall(GUARDAUSUARIO);
            st.setInt(1, idpersona);
            st.setString(2, u.getNombre());
            st.setString(3, u.getApat());
            st.setString(4, u.getAmat());
            st.setInt(5, u.getEdad());
            st.setString(6, u.getGenero());
            st.setString(7, u.getCorreo());
            st.setString(8, u.getContra());
            st.setString(9, u.getConfirmaContra());
            st.setString(10, u.getCedula());
            st.setString(11, u.getProfesion());
            st.setString(12,u.getUniversidad());
            st.setString(13,u.getTelefono());
            rs = st.executeQuery();
            alta = true;
            
        } catch (SQLException e) {
            System.out.println("error en SQl " +e.toString());
        } finally {
        }
        try {
            Conexion.cerrarConectar();
        } catch (SQLException ex) {
            
        }
        
        return alta;
        
    }

    @Override
    public String entraUsuario(Usuario u) {
        ResultSet rs = null;
        CallableStatement st = null;
        String id = "login";
        String escorreo = ESAPI.encoder().encodeForHTML(u.getCorreo());
        String escontra = ESAPI.encoder().encodeForHTML(u.getContra());
        try {
            st = cnx.prepareCall(CONSULTAUSUARIO);
            st.setString(1, id);
            st.setString(2, escorreo);
            st.setString(3, escontra);
            rs = st.executeQuery();
            if(rs.next()){
                String msj = rs.getString("mensaje");
                if(msj.equals("usuario correcto")){
                    return "usuario correcto";
                }else{
                    if(msj.equals("Contraseña incorrecta")){
                    return "Contraseña incorrecta";
                    }else{
                        if(msj.equals("El correo no existe")){
                        return "El correo no existe";
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("error en entrarusuario " + e.toString());
        } finally {

            try {
                Conexion.cerrarConectar();
            } catch (SQLException ex) {

            }
        }
        return "error login";
    }

    @Override
    public Usuario consultaUsuario(String coreo_usuario, String contra_usuario) {

        ResultSet rs = null;
        CallableStatement st = null;
        Usuario UsuarioPro = null ;
        
        try {
            st = cnx.prepareCall(ENTRAUSUARIO);
            st.setString(1,coreo_usuario );
            st.setString(2, contra_usuario);
            rs = st.executeQuery();
            if(rs.next()){
               String nombre= rs.getString("Nombre");
               String apat = rs.getString("Apat");
               String amat = rs.getString("Amat");
               int edad = rs.getInt("Edad");              
               String genero = rs.getString("Genero");
               String correo = rs.getString("Correo");
               String contra = rs.getString("Contra");
               String profesion = rs.getString("Profesion");
               String cedula = rs.getString("Num_Ced_Prof");
               String uni = rs.getString("Universidad");
               String tel = rs.getString("telefono");
               
               UsuarioPro= new Usuario(nombre, apat, amat, edad, genero, correo, contra, contra, cedula, profesion, uni, tel);
  
            }
        } catch (SQLException e) {
            
        } finally {

            try {
                Conexion.cerrarConectar();
            } catch (SQLException ex) {

            }
        }
        
        return UsuarioPro;

    }

    @Override
    public boolean actualizaUsuario(Usuario a) {
        
        
        
        
        return false;
    }

    @Override
    public boolean borraUsuario(String nombre_usuario, String Contra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean correorepetido(Usuario u) {
        boolean repetido = false;

        ResultSet rs = null;
        CallableStatement st = null;

        try {
            st = cnx.prepareCall(CONSULTACORREO);
            st.setString(1, u.getCorreo());
            rs = st.executeQuery();
            if (rs.next()) {
                repetido = true;
            }

        } catch (SQLException e) {

        } finally {
        }
        try {
            Conexion.cerrarConectar();
        } catch (SQLException ex) {

        }

        return repetido;
    }
    
    
    
    
}
