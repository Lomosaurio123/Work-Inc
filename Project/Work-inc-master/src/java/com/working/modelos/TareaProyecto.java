
package com.working.modelos;


public class TareaProyecto {
    
    
    private String Titulo;
    private String Descripcion;
    private String Importancia;
    private int DuracionDias;
    private String UsrAsiNombre;
    private String ApatAsiNombre;

    public int getInformacion() {
        return informacion;
    }

    public void setInformacion(int informacion) {
        this.informacion = informacion;
    }
    private int informacion;

    public TareaProyecto(String Titulo, String Descripcion, String Importancia, int DuracionDias, int informacion) {
        this.Titulo = Titulo;
        this.Descripcion = Descripcion;
        this.Importancia = Importancia;
        this.DuracionDias = DuracionDias;
        this.informacion = informacion;
    }
    
    
    
    

    public TareaProyecto(String Titulo, String Descripcion, String Importancia, int DuracionDias) {
        this.Titulo = Titulo;
        this.Descripcion = Descripcion;
        this.Importancia = Importancia;
        this.DuracionDias = DuracionDias;
    }
    
    

    public TareaProyecto(String Titulo, String Descripcion, String Importancia, int DuracionDias, String UsrAsiNombre, String ApatAsiNombre) {
        this.Titulo = Titulo;
        this.Descripcion = Descripcion;
        this.Importancia = Importancia;
        this.DuracionDias = DuracionDias;
        this.UsrAsiNombre = UsrAsiNombre;
        this.ApatAsiNombre = ApatAsiNombre;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getImportancia() {
        return Importancia;
    }

    public void setImportancia(String Importancia) {
        this.Importancia = Importancia;
    }

    public int getDuracionDias() {
        return DuracionDias;
    }

    public void setDuracionDias(int DuracionDias) {
        this.DuracionDias = DuracionDias;
    }

    public String getUsrAsiNombre() {
        return UsrAsiNombre;
    }

    public void setUsrAsiNombre(String UsrAsiNombre) {
        this.UsrAsiNombre = UsrAsiNombre;
    }

    public String getApatAsiNombre() {
        return ApatAsiNombre;
    }

    public void setApatAsiNombre(String ApatAsiNombre) {
        this.ApatAsiNombre = ApatAsiNombre;
    }
    
    
    
    
}
