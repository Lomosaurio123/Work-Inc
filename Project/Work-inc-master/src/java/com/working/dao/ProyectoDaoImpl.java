package com.working.dao;

import com.working.idao.iProyectoDao;
import com.working.modelos.Proyecto;
import com.working.conexion.ConexionBD;
import com.working.modelos.ProfesionistaRequerido;
import com.working.modelos.TareaProyecto;
import com.working.modelos.Usuario;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.owasp.esapi.ESAPI;

/**
 *
 * @author juan-
 */
public class ProyectoDaoImpl implements iProyectoDao {

    private final String GUARDAPROYECTO = "{call GuardaProyecto(?,?,?,?,?,?,?)}";
    private final String USUARIOSREQUERIDOS = "{call InsertaUsuariosRequeridos(?,?,?,?,?,?,?)}";
    private final String TRAEPUESTOSQUERIDOS = "{call TraerPuestosReq(?,?,?,?,?)}";
    private final String TRAEPROYECTO = "{call TraeProyecto(?,?)}";
    private final String CONSULTAPROYECTO = "{call ConsultaProyecto(?,?,?,?,?)}";
    private final String ACTUALIZAPROYECTO ="{call ActualizaProyecto(?,?,?,?,?,?,?)}";
    private final String UNIONPROYECTO = "{call UnionProyecto(?,?)}";
    private final String PETICIONUSUARIOSUNION = "{call TraerUsuarioPeticionUnion(?,?,?,?,?)}";
    private final String ADMINISTRARSOLICITUDESUNION = "{call administrarsolicitudesUnion(?,?,?)}";
    private final String TRAEUSUARIOUNIDOS = "{call TraeUsuariosUnidos(?,?,?,?,?)}";
    private final String RECHAZAUNIONPROYECTO = "{call RechazaUnionProyecto(?,?)}";
    private final String CREARTAREAPROYECTO = "{call CrearTareaProyecto(?,?,?,?,?,?)}";
    private final String TRAERTAREASPROYECTO = "{call TraerTareaProyecto(?,?,?,?,?)}";
    private final String TRAERPROYECTOUNIDO = "{call TraerProyectoUsuarioUnido(?)}";
    private final String TRAERTAREASPROYECTOPORUSUARIO = "{call TraerTareaProyectoARealizar(?,?)}";
    private final String BORRATAREA = "{call BorraTarea(?,?)}";

    private Connection cnx;
    ConexionBD Conexion = new ConexionBD();

    public ProyectoDaoImpl() {
        this.cnx = Conexion.getConectar();
    }

    @Override
    public boolean altaProyecto(Proyecto p) {
        ResultSet rs = null;
        CallableStatement st = null;
        boolean alta = false;
        try {
            st = cnx.prepareCall(GUARDAPROYECTO);
            st.setString(1, p.getNombreProyecto());
            st.setString(2, p.getIdea_Principal());
            st.setString(3, p.getCategoria());
            st.setInt(4, p.getMonto());
            st.setString(5, ESAPI.encoder().encodeForHTML(p.getCorreo_creador()));
            st.setBlob(6, p.getArchivoimg());
            st.setInt(7, p.getId_Proyecto());//ESTE ES EL NUMERO DE INTEGRANTES (por cuestiones de constructor mejor se uso el id_Proyecto)
            rs = st.executeQuery();
            alta = true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                Conexion.cerrarConectar();
            }catch (Exception ex) {
                
                }
        }
        return alta;
    }
    
    public boolean InsertarUsuariosReq(int NumeroUsuarios, Proyecto p, String Profesionistas[]){
        boolean UsuariosInsertadosConExito= false;
        ResultSet rs = null;
        CallableStatement st = null;
        String EstadoDefault="Disponible";
        int ContadorExito =0;
        
        try{
            for(int i=0; i<=NumeroUsuarios-1;i++){
                st = cnx.prepareCall(USUARIOSREQUERIDOS);
                st.setString(1, p.getNombreProyecto());
                st.setString(2,p.getIdea_Principal());
                st.setInt(3, p.getMonto());
                st.setString(4, p.getCategoria());
                st.setString(5, ESAPI.encoder().encodeForHTML(p.getCorreo_creador()));
                st.setString(6, EstadoDefault);
                st.setString(7, Profesionistas[i]);
                rs = st.executeQuery();
                ContadorExito++;
            }
            
            if(ContadorExito==NumeroUsuarios){
                UsuariosInsertadosConExito= true;
            }
   
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 

        return UsuariosInsertadosConExito;
    }
    
    


    @Override
    public boolean actualizaProyecto(Proyecto p) {
       
        boolean ActualizacionExitosa= false;
         ResultSet rs = null;
        CallableStatement st = null;
        boolean alta = false;
           try {
            st = cnx.prepareCall(ACTUALIZAPROYECTO);
            st.setString(1,ESAPI.encoder().encodeForHTML( p.getNombreProyecto()));
            st.setString(2, ESAPI.encoder().encodeForHTML(p.getIdea_Principal()));
            st.setString(3, ESAPI.encoder().encodeForHTML(p.getCategoria()));
            st.setInt(4, p.getMonto());
            st.setString(5, ESAPI.encoder().encodeForHTML(p.getCorreo_creador()));
            st.setBlob(6, p.getArchivoimg());
            st.setInt(7,p.getId_Proyecto() );
            
            rs = st.executeQuery();
            ActualizacionExitosa = true;

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return ActualizacionExitosa;
    }

    @Override
    public void borraProyecto(Proyecto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Proyecto consultaProyecto(Proyecto p) {
                 ResultSet rs = null;
                 CallableStatement st = null;
                 Proyecto ProyectoConsulta = null;
                   try {

                    st = cnx.prepareCall(CONSULTAPROYECTO);
                    st.setString(1,p.getNombreProyecto());
                    st.setString(2,p.getIdea_Principal());
                    st.setString(3,p.getCategoria());
                    st.setInt(4,p.getMonto());
                    st.setString(5, p.getCorreo_creador());
                    rs = st.executeQuery();
                    
                    if(rs.next()) {
                        ProyectoConsulta= ConvertirProyectoEspecifico(rs);
                    }

        } catch (SQLException ex) {
                       System.out.println(ex);
        } finally {
            try {
                Conexion.cerrarConectar();
            } catch (Exception ex) {
            }
        }
         return ProyectoConsulta;
    }

    @Override
    public List<Proyecto> traerProyecto(int id, String Correo) {

        ResultSet rs = null;
        CallableStatement st = null;
        List<Proyecto> pro = new ArrayList<>();
        

        try {
            st = cnx.prepareCall(TRAEPROYECTO);
            st.setInt(1, id);
            st.setString(2, Correo);
            rs = st.executeQuery();
            while (rs.next()) {
                pro.add((ConvertirProyectoEspecifico(rs)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProyectoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Conexion.cerrarConectar();
            } catch (Exception ex) {
            }
        }
        return pro;
    }
    
    
        private Proyecto ConvertirProyectoEspecifico(ResultSet rs) throws SQLException{
        Proyecto p = new Proyecto(rs.getString("Nombre_proyecto"),rs.getString("Idea_principal"),rs.getString("Categoria"),rs.getInt("Monto"), rs.getBlob("imagen"), rs.getInt("Id_proyecto"));
        return p;
    }
        
    public boolean PeticionUnionProyecto(String CorreoUsuario, int InformacionProyecto){
        boolean UnionExitosa= false;
        ResultSet rs = null;
        CallableStatement st = null;
           try {
           st = cnx.prepareCall(UNIONPROYECTO);
            st.setString(1,ESAPI.encoder().encodeForHTML(CorreoUsuario) );
            st.setInt(2, InformacionProyecto);
            rs = st.executeQuery();
               if (rs.next()) {
                   UnionExitosa = true;
               }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return UnionExitosa;
    }   
    
    
    public List<Usuario> DesplegarUsuarioInteresado(Proyecto p){
        
        ResultSet rs = null;
        CallableStatement st = null;
        List<Usuario> UsuarioInteresadoUnion = new ArrayList<>();
        
         try {
           
            st = cnx.prepareCall(PETICIONUSUARIOSUNION);
                    st.setString(1,p.getNombreProyecto());
                    st.setString(2,p.getIdea_Principal());
                    st.setString(3,p.getCategoria());
                    st.setInt(4,p.getMonto());
                    st.setString(5, ESAPI.encoder().encodeForHTML(p.getCorreo_creador()));
                    rs = st.executeQuery();
            while (rs.next()) {
                UsuarioInteresadoUnion.add((ConvertirUsuariosPeticionUnion(rs)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProyectoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //Conexion.cerrarConectar();
            } catch (Exception ex) {
            }
        }

        return UsuarioInteresadoUnion;
    }
    
        private Usuario ConvertirUsuariosPeticionUnion(ResultSet rs) throws SQLException{
        Usuario u = new Usuario(rs.getString("Nombre"),rs.getString("Apat"),rs.getString("Amat"),rs.getString("Correo"), rs.getString("Profesion"));
        return u;
    }
        
        
        
        
        
        
        
        
        public boolean AceptarDenegarSolicitudes (String correo, String Accion, int InfoProject){
        boolean AdministracionExitosa= false;
            return AdministracionExitosa;
        }
        
    public List<ProfesionistaRequerido> DesplegarProfesionistasReq(Proyecto p){
        
        ResultSet rs = null;
        CallableStatement st = null;
        List<ProfesionistaRequerido> PuestosRequeridos = new ArrayList<>();
        
         try {         
            st = cnx.prepareCall(TRAEPUESTOSQUERIDOS);
                    st.setString(1,p.getNombreProyecto());
                    st.setString(2,p.getIdea_Principal());
                    st.setString(3,p.getCategoria());
                    st.setInt(4,p.getMonto());
                    st.setString(5, ESAPI.encoder().encodeForHTML(p.getCorreo_creador()));
                    rs = st.executeQuery();
            while (rs.next()) {
                PuestosRequeridos.add((ConvertirProfesionistasreq(rs)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProyectoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                
            } catch (Exception ex) {
            }
        }

        return PuestosRequeridos;
    }
        
        
     private ProfesionistaRequerido ConvertirProfesionistasreq(ResultSet rs) throws SQLException{
        ProfesionistaRequerido profreq = new ProfesionistaRequerido(rs.getString("Tipo_profesionista"),rs.getString("StatusOcupacion"));
        return profreq;
    }
     
     
     
     public boolean AceptarSolicitudUnion(String Correo, int IdProyect, String PuestoAsign){
        boolean UnionExitosa= false;
        ResultSet rs = null;
        CallableStatement st = null;
         
        try{
             st = cnx.prepareCall(ADMINISTRARSOLICITUDESUNION);
             st.setString(1,ESAPI.encoder().encodeForHTML(Correo));
             st.setInt(2, IdProyect);
             st.setString(3,PuestoAsign);
             rs= st.executeQuery();
             UnionExitosa = true;
        }catch(Exception e ){
            System.out.println( e.toString() );
        }
         
         
         return UnionExitosa;
     }
     
     
     
     
         public List<Usuario> DesplegarUsuarioUnido(Proyecto p){
        
        ResultSet rs = null;
        CallableStatement st = null;
        List<Usuario> UsuarioUnido = new ArrayList<>();
        
         try {
           
            st = cnx.prepareCall(TRAEUSUARIOUNIDOS);
                    st.setString(1,p.getNombreProyecto());
                    st.setString(2,p.getIdea_Principal());
                    st.setString(3,p.getCategoria());
                    st.setInt(4,p.getMonto());
                    st.setString(5, ESAPI.encoder().encodeForHTML(p.getCorreo_creador()));
                    rs = st.executeQuery();
            while (rs.next()) {
                UsuarioUnido.add((ConvertirUsuariosUnidos(rs)));
            }

        } catch (SQLException ex) {
             System.out.println("EL ERROR ES" + ex.toString());
        } 

        return UsuarioUnido;
    }
        
        
        private Usuario ConvertirUsuariosUnidos(ResultSet rs) throws SQLException{
        Usuario u = new Usuario(rs.getString("Nombre"),rs.getString("Apat"),rs.getString("Amat"),rs.getString("Correo"), rs.getString("Profesion"));
        return u;
    }
        
     public boolean RechazarSolicitudUnion(String Correo, int IdProyect){
        boolean RechazoExitoso= false;
        ResultSet rs = null;
        CallableStatement st = null;
         
        try{
             st = cnx.prepareCall(RECHAZAUNIONPROYECTO);
             st.setString(1,ESAPI.encoder().encodeForHTML(Correo));
             st.setInt(2, IdProyect);
             rs= st.executeQuery();
             RechazoExitoso = true;
        }catch(Exception e ){
            System.out.println( e.toString() );
        }
         
         
         return RechazoExitoso;
     }
     
       public boolean CrearTarea(String TituloT, String Descripcion, String Importancia, String CorreoUsrAsignado,int DiasTarea, int InfoProyecto){
        boolean AltaTarea= false;
        ResultSet rs = null;
        CallableStatement st = null;
         
        try{
             st = cnx.prepareCall(CREARTAREAPROYECTO);
             st.setString(1,TituloT);
             st.setString(2, Descripcion);
             st.setString(3,Importancia );
             st.setString(4,ESAPI.encoder().encodeForHTML(CorreoUsrAsignado) );
             st.setInt(5, DiasTarea);
             st.setInt(6,InfoProyecto);
             rs= st.executeQuery();
             AltaTarea = true;
        }catch(Exception e ){
            System.out.println( e.toString() );
        }
         
         return AltaTarea;
     }
        
        
        public List<TareaProyecto> DesplegarTareas(Proyecto p){
        
        ResultSet rs = null;
        CallableStatement st = null;
        List<TareaProyecto> TareasPro = new ArrayList<>();
        
         try {
           
            st = cnx.prepareCall(TRAERTAREASPROYECTO);
                    st.setString(1,p.getNombreProyecto());
                    st.setString(2,p.getIdea_Principal());
                    st.setString(3,p.getCategoria());
                    st.setInt(4,p.getMonto());
                    st.setString(5, ESAPI.encoder().encodeForHTML(p.getCorreo_creador()));
                    rs = st.executeQuery();
            while (rs.next()) {
                TareasPro.add((ConvertirTareaProyecto(rs)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProyectoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //Conexion.cerrarConectar();
            } catch (Exception ex) {
            }
        }

        return TareasPro;
    }
    
        private TareaProyecto ConvertirTareaProyecto(ResultSet rs) throws SQLException{
        TareaProyecto tarea = new TareaProyecto(rs.getString("TituloT"),rs.getString("DescripcionT"),rs.getString("ImportanciaT"),
        rs.getInt("DuracionDias"),rs.getString("Nombre"),rs.getString("Apat"));
        return tarea;
    }
        
    
    public List<Proyecto> traerProyectoColaborador(String Correo) {

        ResultSet rs = null;
        CallableStatement st = null;
        List<Proyecto> pro = new ArrayList<>();
        try {
            st = cnx.prepareCall(TRAERPROYECTOUNIDO); 
            st.setString(1, ESAPI.encoder().encodeForHTML(Correo));
            rs = st.executeQuery();
            while (rs.next()) {
                pro.add((ConvertirProyectoEspecifico(rs)));
            }

        } catch (SQLException ex) {
            System.out.println("Error en " + ex.toString());
        } 
        return pro;
    }
    
    
    
        public List<TareaProyecto> DesplegarTareasUsuarioARealizar(int informacionproyecto, String correo){
        
        ResultSet rs = null;
        CallableStatement st = null;
        List<TareaProyecto> TareasPro = new ArrayList<>();
        
         try {
           
            st = cnx.prepareCall(TRAERTAREASPROYECTOPORUSUARIO);
                    st.setInt(1,informacionproyecto);
                    st.setString(2,ESAPI.encoder().encodeForHTML(correo));
                    rs = st.executeQuery();
            while (rs.next()) {
                TareasPro.add((ConvertirTareaProyectoArealizar(rs)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProyectoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //Conexion.cerrarConectar();
            } catch (Exception ex) {
            }
        }

        return TareasPro;
    }
    
    
          private TareaProyecto ConvertirTareaProyectoArealizar(ResultSet rs) throws SQLException{
        TareaProyecto tarea = new TareaProyecto(rs.getString("TituloT"),rs.getString("DescripcionT"),rs.getString("ImportanciaT"),
        rs.getInt("DuracionDias"), rs.getInt("Id_Tarea") );
        return tarea;
    }
          
          
          
          public boolean BorrarTarea(String Correo, int infotarea ){
        boolean BorraTarea= false;
        ResultSet rs = null;
        CallableStatement st = null;
         
        try{
             st = cnx.prepareCall(BORRATAREA);
             st.setString(1,ESAPI.encoder().encodeForHTML(Correo));
             st.setInt(2, infotarea);
             rs= st.executeQuery();
             BorraTarea = true;
        }catch(Exception e ){
            System.out.println( e.toString() );
        }
         
         return BorraTarea;
     }
        
          
        
        
       
        
           
}