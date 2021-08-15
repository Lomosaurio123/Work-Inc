
package com.working.dao;


import com.working.conexion.ConexionBD;
import com.working.idao.iNoticiaDao;
import com.working.modelos.Noticia;
import java.util.List;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NoticiaDaoImpl implements iNoticiaDao{
    
    private final String SubirNoticiaBS = "{call SubirNoticia(?,?,?,?)}";
    private final String TraerNoticia="{call TraerNoticiaprevia(?)}";
    private final String TraerNoticiasTodas="{call TraerNoticia()}";
    private final String NombrarNoticia="{call TraerNoticiaDatos(?)}";
    private final String Traer4Noticias="{call TraerNoticiaLimitada()}";
    private final String ModificarNoticia="{call ModificarNoticia(?,?,?,?,?)}";
    private final String BorrarNoticia="{call BorrarNoticia(?)}";
    
        private Connection cnx;
    ConexionBD Conexion = new ConexionBD();

    public NoticiaDaoImpl() {
        this.cnx = Conexion.getConectar();
    }

    @Override
    public int altaNoticia(Noticia n) {
         ResultSet rs=null;
        CallableStatement st=null;
        int Id_noticias =0;
        try{
            st=cnx.prepareCall(SubirNoticiaBS);
            st.setString(1, n.getNoticia());
            st.setString(2, n.getTitulo());
            st.setBlob(3, n.getArchivoIMG());
            st.setString(4, n.getCategoria());
            
            rs= st.executeQuery();
            if(rs.next()){
                Id_noticias= rs.getInt("Id_noticias");
            }
        }
        catch(Exception xd){
            
        }finally{
        
        }
       
        return  Id_noticias;
    }

    @Override
    public Noticia traerNoticia(String Titulo) {
        
         ResultSet rs=null;
        CallableStatement st= null;
        Noticia n=null;
        try{
            st=cnx.prepareCall(TraerNoticia);
            st.setString(1, Titulo);
            rs=st.executeQuery();
            if(rs.next()){
                n=convertirNoticias(rs);
                
            }
        } catch (SQLException ex) {
            
        }
        return n;
    }

    @Override
    public void actualizaNoticia(Noticia n) {
        ResultSet rs=null;
        CallableStatement st=null;
        try{
            st=cnx.prepareCall(ModificarNoticia);
            st.setString(1, n.getId());
            st.setString(2, n.getNoticia());
            st.setString(3, n.getTitulo());
            st.setBlob(4, n.getArchivoIMG());
            st.setString(5, n.getCategoria());
            
            rs= st.executeQuery();
            if(rs.next()){
            }
        }
        catch(Exception xd){
        }finally{
        
        }
    }

    @Override
    public boolean borraNoticia(int Id_noticia) {
         ResultSet res;
        CallableStatement st = null;
         
        try{
            st = cnx.prepareCall(BorrarNoticia);
            st.setInt(1, Id_noticia);
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
    public List<Noticia> traerNoticias() {
          ResultSet rs=null;
        CallableStatement st= null;
        List<Noticia> stP= new ArrayList<>();
        try{
            st=cnx.prepareCall(TraerNoticiasTodas);
            rs=st.executeQuery();
            while(rs.next()){
                stP.add(convertirNoticias(rs));
            }
        } catch (SQLException ex) {
           
        }
        return stP;
    }


    @Override
    public List<Noticia> traerNoticiaPrevias() {
         ResultSet rs=null;
        CallableStatement st= null;
        List<Noticia> stP= new ArrayList<>();
        try{
            st=cnx.prepareCall(TraerNoticia);
            rs=st.executeQuery();
            while(rs.next()){
                stP.add(convertirNoticia(rs));
            }
        } catch (SQLException ex) {
            
        }
        return stP;
    }

    @Override
    public List<Noticia> traerNoticias4() {
         ResultSet rs=null;
        CallableStatement st= null;
        List<Noticia> stP= new ArrayList<>();
        try{
            st=cnx.prepareCall(Traer4Noticias);
            rs=st.executeQuery();
            while(rs.next()){
                stP.add(convertirNoticia(rs));
            }
        } catch (SQLException ex) {
           
        }
        return stP;
    }

            private Noticia convertirNoticia(ResultSet rs) throws SQLException{
        Noticia n= new Noticia(rs.getString("Titulo"),rs.getString("Noticia"),rs.getBlob("imagen"),rs.getString("Categoria"));
        return n;
    }
    private Noticia convertirNoticias(ResultSet rs) throws SQLException{
        Noticia n= new Noticia(rs.getString("Titulo"),rs.getString("Noticia"),rs.getBlob("imagen"),rs.getString("Categoria"),rs.getString("Id_noticias"));
        return n;
    }


   

}
