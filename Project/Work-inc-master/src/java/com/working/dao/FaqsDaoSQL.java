package com.working.dao;



import com.working.conexion.ConexionBD;
import com.working.modelos.faqs;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.owasp.esapi.ESAPI;


public class FaqsDaoSQL implements com.working.idao.iFaqsDao{
    private final String SubirPregunta = "{call SubirPregunta(?,?,?)}";
    private final String TraerPregunta="{call MostrarPreguntas()}";
    private final String borrarPregunta="{call borrarPreguntas(?)}";
    private final String subirRespuesta="{call SubirRespuesta(?,?)}";
    private final String BUSFAQ = "{call Pregunta(?)}";
    private Connection ConexionB;
    
    public FaqsDaoSQL(){
        ConexionBD bd= new ConexionBD();
        this.ConexionB = bd.getConectar();
    }

    @Override
    public int altaPregunta(String pregunta) {
        ResultSet rs=null;
        CallableStatement st=null;
        int Id_Pregunta =0;
        try{
            st=ConexionB.prepareCall(SubirPregunta);
            st.setString(1,  "alta");
            st.setString(2,  ESAPI.encoder().encodeForHTML(pregunta));
            st.setInt(3,  0);
            rs= st.executeQuery();
            if(rs.next()){
                String msj = rs.getString("mensaje");
                if(msj.equals("pregunta alta")){
                    return 10;
                }else{
                    return 0;
                }
            }
        }
        catch(Exception xd){
            System.out.println("error al subirPregunta :" + xd.getMessage());
        }finally{
        
        }
       
        return  Id_Pregunta;
    }

    @Override
    public int traerPregunta(String Pregunta) {
        ResultSet res;
        CallableStatement st = null;      
        String id = "buscar";
        String Spregunta = ESAPI.encoder().encodeForHTML(Pregunta);
        
        try{
            st = ConexionB.prepareCall(BUSFAQ);
            st.setString(1, Spregunta);
            res = st.executeQuery();
            while(res.next()){
                int id_preg  = res.getInt("Id_Pregunta");
               return id_preg;
            }
        }catch(Exception e){
            System.out.println("Error en readFAQ :" + e.getMessage());
        }
        return 0;
    }

    @Override
    public int ModificarPregunta(String pregunta, int id_pregunta) {
        ResultSet rs=null;
        CallableStatement st=null;
        int Id_Pregunta =0;
        try{
            st=ConexionB.prepareCall(SubirPregunta);
            st.setString(1,  "modificar");
            st.setString(2,  ESAPI.encoder().encodeForHTML(pregunta));
            st.setInt(3,  id_pregunta);
            rs= st.executeQuery();
            if(rs.next()){
                String msj = rs.getString("mensaje");
                if(msj.equals("pregunta actualiza")){
                    return 10;
                }else{
                    if(msj.equals("pregunta repetida")){
                    return 0;
                    }
                }
            }
            
        }
        catch(Exception xd){
            System.out.println("error al subir :" + xd.getMessage());
        }finally{
        
        }
       
        return  0;
    }

    @Override
    public boolean borraPregunta(int id_Pregunta) {
        ResultSet res;
        CallableStatement st = null;
        
        try{
            st = ConexionB.prepareCall(borrarPregunta);
            st.setInt(1, id_Pregunta);
            res = st.executeQuery();
            if(res.next()){
                String msj = res.getString("mensaje");
                if(msj.equals("eliminado")){
                    return true;
                }
            }
            
        }catch(Exception e){
            System.out.println("Error en borrar:  "+ e.getMessage());
        }
        return false;
    }

    @Override
    public List<faqs> traerPreguntas() {
        ResultSet rs=null;
        CallableStatement st= null;
        List<faqs> stP= new ArrayList<>();
        try{
            st=ConexionB.prepareCall(TraerPregunta);
            rs=st.executeQuery();
            while(rs.next()){
                stP.add(convertirPregunta(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FaqsDaoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
        return stP;
    }
    private faqs convertirPregunta(ResultSet rs) throws SQLException{
        faqs f= new faqs(rs.getInt("Id_Pregunta"),rs.getString("Pregunta"),rs.getString("FechaPregunta"));
        return f;
    }

    @Override
    public boolean altaRespuesta(String respuesta, int id_pregun) {
        ResultSet rs=null;
        CallableStatement st=null;
        
        try{
            st=ConexionB.prepareCall(subirRespuesta);
            st.setString(1, respuesta);    
            st.setInt(2, id_pregun);    
            rs= st.executeQuery();
            if(rs.next()){
                String men = rs.getString("mensaje");
                if(men.equals("respuestasi")){
                    return true;
                }else{
                    return false;
                }
            }
        }
        catch(Exception xd){
            System.out.println("error al subirrespuesta :" + xd.getMessage());
        }finally{
        
        }
       
        return false;
    }

    @Override
    public List<faqs> traerPyR() {
        ResultSet rs=null;
        CallableStatement st= null;
        List<faqs> stP= new ArrayList<>();
        try{
            st=ConexionB.prepareCall(TraerPregunta);
            rs=st.executeQuery();
            while(rs.next()){
                if(convertirPyR(rs).getEstado().equals("visto")){
                stP.add(convertirPyR(rs));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FaqsDaoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
        return stP;
    }
    private faqs convertirPyR(ResultSet rs) throws SQLException{
        faqs f= new faqs(rs.getInt("Id_Pregunta"),rs.getString("Pregunta"),rs.getString("FechaPregunta"),rs.getString("respuesta"),rs.getString("estado"));
        return f;
    }

    @Override
    public boolean traerSolucion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    }

