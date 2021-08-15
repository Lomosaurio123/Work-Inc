package com.working.modelos;

import java.io.InputStream;
import java.sql.Blob;
import javax.servlet.http.Part;

public class Noticia {
     private String titulo;
    private String noticia;
    InputStream archivoIMG;
    private Blob imagen;
    private String categoria;
    private String id;

    public Noticia(String titulo, String noticia, InputStream archivoIMG, String categoria, String id) {
        this.titulo = titulo;
        this.noticia = noticia;
        this.archivoIMG = archivoIMG;
        this.categoria = categoria;
        this.id = id;
    }
 
    public Noticia(String titulo, String noticia, InputStream archivoIMG, Blob imagen,String categoria) {
        this.titulo = titulo;
        this.noticia = noticia;
        this.archivoIMG = archivoIMG;
        this.imagen = imagen;
        this.categoria=categoria;
    }
    
    public Noticia(String titulo,String noticia,Blob imagen,String categoria){
        this.titulo = titulo;
        this.noticia = noticia;
        this.imagen = imagen;
        this.categoria=categoria;
    }
    
    public Noticia(String titulo,String noticia, InputStream archivoIMG, String categoria){
        this.titulo = titulo;
        this.noticia = noticia;
        this.archivoIMG = archivoIMG;
        this.categoria=categoria;
    }

    public Noticia(String titulo, String noticia, Blob imagen, String categoria, String id) {
        this.titulo = titulo;
        this.noticia = noticia;
        this.imagen = imagen;
        this.categoria = categoria;
        this.id = id;
    }

    public Noticia(String titulo, String noticia,String categoria, String id){
        this.titulo = titulo;
        this.noticia = noticia;
        this.categoria = categoria;
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public InputStream getArchivoIMG() {
        return archivoIMG;
    }
    

    public void setArchivoIMG(InputStream archivoIMG) {
        this.archivoIMG = archivoIMG;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Noticia{" + "titulo=" + titulo + ", noticia=" + noticia + ", archivoIMG=" + archivoIMG + ", imagen=" + imagen + ", categoria=" + categoria + ", id=" + id + '}';
    }
  
}
