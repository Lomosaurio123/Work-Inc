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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.owasp.esapi.ESAPI;


/**
 *
 * @author juan-
 */
public class UsuarioDaoSQL implements iUsuarioDao{
    
    private final String GUARDAUSUARIO = "{call GuardaUsuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    private final String CONSULTAUSUARIO="{call spBuscaUsuario(?,?,?)}";
    
   
    private Connection cnx;
    ConexionBD Conexion = new  ConexionBD(); 
    
    public UsuarioDaoSQL() {  
        this.cnx = Conexion.getConectar();
    }
    
    
    @Override
    public boolean altaUsuario(Usuario u) {
        
        ResultSet rs = null;
        CallableStatement st = null;
        
        String id = "alta";

        try {
            Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mat = pat.matcher(u.getCorreo());
            if(mat.matches()){
            st = cnx.prepareCall(GUARDAUSUARIO);
            st.setString(1, id);
            st.setString(2, ESAPI.encoder().encodeForHTML(u.getNombre()));
            st.setString(3, ESAPI.encoder().encodeForHTML(u.getApat()));
            st.setString(4, ESAPI.encoder().encodeForHTML(u.getAmat()));
            st.setInt(5, u.getEdad() );
            st.setString(6, ESAPI.encoder().encodeForHTML(u.getGenero()));
            st.setString(7, ESAPI.encoder().encodeForHTML(u.getCorreo()));
            st.setString(8, ESAPI.encoder().encodeForHTML(u.getContra()));
            st.setString(9, ESAPI.encoder().encodeForHTML(u.getConfirmaContra()));
            st.setString(10, ESAPI.encoder().encodeForHTML(u.getCedula()));
            st.setString(11, ESAPI.encoder().encodeForHTML(u.getProfesion()));
            st.setString(12,ESAPI.encoder().encodeForHTML(u.getUniversidad()));
            st.setString(13,ESAPI.encoder().encodeForHTML(u.getTelefono()));
            st.setString(14, ESAPI.encoder().encodeForHTML(u.getCodigoAdmin()));
            rs = st.executeQuery();
            return true;
            }else{
                System.out.println("error al introducir el correo");
                return false;
            }
            
        } catch (Exception e) {
            System.out.println("Error en altausuarioimple " +e.toString());
        } finally {
        }
        try {
            Conexion.cerrarConectar();
        } catch (SQLException ex) {
            
        }
        
        return false;
        
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
    public Usuario consultaUsuario(String correo_usuario, String contra_usuario) {
        ResultSet res;
        CallableStatement st = null;      
        String id = "buscar";
        String correoS = ESAPI.encoder().encodeForHTML(correo_usuario);
        String contraS = ESAPI.encoder().encodeForHTML(contra_usuario);
        try{
            st = cnx.prepareCall(CONSULTAUSUARIO);
            st.setString(1, id);
            st.setString(2, correoS);
            st.setString(3, contraS);
            res = st.executeQuery();
            while(res.next()){
                String Nombre = res.getString("Nombre");
                String Apat = res.getString("Apat");
                String Amat = res.getString("Amat");
                int Edad  = res.getInt("Edad");;
                String Genero = res.getString("Genero");
                String Cedula =  res.getString("Num_Ced_Prof");
                String profesion = res.getString("Profesion");
                String universidad = res.getString("Universidad");
                String telefono = res.getString("telefono");
                String TipoUsu = res.getString("TipoUsuario");
                
                Usuario usua = new Usuario(Nombre, Apat, Amat, Edad, Genero, correoS, contraS,
                        contraS , Cedula, profesion, universidad, telefono,TipoUsu);
                return usua;
            }
        }catch(Exception e){
            System.out.println("Error en readPersona :" + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizaUsuario(Usuario u) {
        
        ResultSet rs = null;
        CallableStatement st = null;
        String id = "actualiza";
        try {
            Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mat = pat.matcher(u.getCorreo());
            if(mat.matches()){
            st = cnx.prepareCall(GUARDAUSUARIO);
            String Nombre = ESAPI.encoder().encodeForHTML(u.getNombre());
            String Apat = ESAPI.encoder().encodeForHTML(u.getApat());
            String Amat = ESAPI.encoder().encodeForHTML(u.getAmat());
            int edad = u.getEdad();
            String Genero = ESAPI.encoder().encodeForHTML(u.getGenero());
            String Correo = ESAPI.encoder().encodeForHTML(u.getCorreo());
            String Contra = ESAPI.encoder().encodeForHTML(u.getContra());
            String ConfirmaContra = ESAPI.encoder().encodeForHTML(u.getConfirmaContra());
            String Cedula = ESAPI.encoder().encodeForHTML(u.getCedula());
            String profesion =  ESAPI.encoder().encodeForHTML(u.getProfesion());
            String universidad = ESAPI.encoder().encodeForHTML(u.getUniversidad());
            String telefono = ESAPI.encoder().encodeForHTML(u.getTelefono());
            st.setString(1, id);
            st.setString(2, Nombre);
            st.setString(3, Apat);
            st.setString(4, Amat);
            st.setInt(5, edad );
            st.setString(6, Genero);
            st.setString(7,Correo);
            st.setString(8, Contra);
            st.setString(9, Contra);
            st.setString(10, Cedula);
            st.setString(11, profesion);
            st.setString(12, universidad);
            st.setString(13, telefono);
            rs = st.executeQuery();
            if(rs.next()){
                String msj = rs.getString("mensaje");
                if(msj.equals("Persona actualizada")){
                    return true;
                }else{
                    return false;
                }
            }
            }else{
                System.out.println("error al introducir el correo");
                return false;
            }
            
        } catch (Exception e) {
            System.out.println("Error en altausuarioimple " +e.toString());
        } finally {
        }
        try {
            Conexion.cerrarConectar();
        } catch (SQLException ex) {
            
        }
        
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
        String id = "buscar";
        String contra = "";
        try{
            st = cnx.prepareCall(CONSULTAUSUARIO);
            st.setString(1, id);
            st.setString(2, ESAPI.encoder().encodeForHTML(u.getCorreo()));
            st.setString(3, contra);
            rs = st.executeQuery();
            if (rs.next()) {
                String msj = rs.getString("mensaje");
                if(msj.equals("El correo no existe")){
                    return false;
                }else{
                    return true;
                }
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
