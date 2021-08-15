
package com.working.modelos;

import java.io.InputStream;
import java.sql.Blob;

public class Proyecto {
    
    private String NombreProyecto;
    private String Idea_Principal;
    private String Categoria;
    private int Monto;
    private String correo_creador;
    InputStream archivoimg;
    private Blob imgregreso;
    private int id_Proyecto;
    private String Profesionista1;
    private String Profesionista2;
    private String Profesionista3;
    private String Profesionista4;
    private String Profesionista5;
    private int NumIntegrantes;

    
 
    

    
    
    
    
    public Proyecto(String NombreProyecto, String Idea_Principal, String Categoria, int Monto, String correo_creador, InputStream archivoimg, int id_Proyecto) {
        this.NombreProyecto = NombreProyecto;
        this.Idea_Principal = Idea_Principal;
        this.Categoria = Categoria;
        this.Monto = Monto;
        this.correo_creador = correo_creador;
        this.archivoimg = archivoimg;
        this.id_Proyecto = id_Proyecto;
    }
    



    public Proyecto(String NombreProyecto, String Idea_Principal, String Categoria, int Monto, Blob imgregreso, int id_Proyecto) {
        this.NombreProyecto = NombreProyecto;
        this.Idea_Principal = Idea_Principal;
        this.Categoria = Categoria;
        this.Monto = Monto;
        this.imgregreso = imgregreso;
        this.id_Proyecto = id_Proyecto;
    }

   
    public Proyecto(String NombreProyecto, String Idea_Principal, String Categoria, int Monto, Blob imgregreso) {
        this.NombreProyecto = NombreProyecto;
        this.Idea_Principal = Idea_Principal;
        this.Categoria = Categoria;
        this.Monto = Monto;
        this.imgregreso = imgregreso;    
    }
 
    public Proyecto(String NombreProyecto, String Idea_Principal, String Categoria, int Monto, String correo_creador, InputStream archivoimg) {
        this.NombreProyecto = NombreProyecto;
        this.Idea_Principal = Idea_Principal;
        this.Categoria = Categoria;
        this.Monto = Monto;
        this.correo_creador = correo_creador;
        this.archivoimg = archivoimg;
    }

    public Proyecto(String NombreProyecto, String Idea_Principal, String Categoria, int Monto, String correo_creador) {
        this.NombreProyecto = NombreProyecto;
        this.Idea_Principal = Idea_Principal;
        this.Categoria = Categoria;
        this.Monto = Monto;
        this.correo_creador = correo_creador;
    }
   
    public int getId_Proyecto() {
        return id_Proyecto;
    }

    public void setId_Proyecto(int id_Proyecto) {
        this.id_Proyecto = id_Proyecto;
    }

    public Blob getImgregreso() {
        return imgregreso;
    }

    public void setImgregreso(Blob imgregreso) {
        this.imgregreso = imgregreso;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "correo_creador=" + correo_creador + '}';
    }

    public String getCorreo_creador() {
        return correo_creador;
    }

    public void setCorreo_creador(String correo_creador) {
        this.correo_creador = correo_creador;
    }


    public String getNombreProyecto() {
        return NombreProyecto;
    }

    public void setNombreProyecto(String NombreProyecto) {
        this.NombreProyecto = NombreProyecto;
    }

    public String getIdea_Principal() {
        return Idea_Principal;
    }

    public void setIdea_Principal(String Idea_Principal) {
        this.Idea_Principal = Idea_Principal;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public InputStream getArchivoimg() {
        return archivoimg;
    }

    public void setArchivoimg(InputStream archivoimg) {
        this.archivoimg = archivoimg;
    }

    public int getMonto() {
        return Monto;
    }

    public void setMonto(int Monto) {
        this.Monto = Monto;
    }
          
          
}
