
package com.working.modelos;


public class ReporteEvento {
    
    private String  ModuloFalla ;
    private String  DescripcionFalla;
    private String  EstadoReporte;
    private String  UsuarioFalla;
    private String  FechaFalla ;
    private String  Etiqueta ;
    private String Operador;
    private String folio;
    private String EstadoAsignacion;
    private int InformacionIngenero;
    private String Solucion;

   
    
    /*Datos del ingeniero de software que resolvera la duda*/
    
    private String NombreIngDeSoftware;
    private String ApatIngDeSoftware;
    private String AmatIngDeSoftware;

   
    private String CorreoIng;

 /*DATOS DE EL OPERADOR CUANDO SE REGRESA*/
    private String NombreOperador;
    private String ApatOperador;
    private String AmatOperador;

    public ReporteEvento(String ModuloFalla, String DescripcionFalla, String EstadoReporte, String UsuarioFalla, String FechaFalla, String Etiqueta, String folio, String EstadoAsignacion, int InformacionIngenero, String NombreIngDeSoftware, String ApatIngDeSoftware, String AmatIngDeSoftware, String CorreoIng, String NombreOperador, String ApatOperador, String AmatOperador ,String solucion){
        this.ModuloFalla = ModuloFalla;
        this.DescripcionFalla = DescripcionFalla;
        this.EstadoReporte = EstadoReporte;
        this.UsuarioFalla = UsuarioFalla;
        this.FechaFalla = FechaFalla;
        this.Etiqueta = Etiqueta;
        this.folio = folio;
        this.EstadoAsignacion = EstadoAsignacion;
        this.InformacionIngenero = InformacionIngenero;
        this.NombreIngDeSoftware = NombreIngDeSoftware;
        this.ApatIngDeSoftware = ApatIngDeSoftware;
        this.AmatIngDeSoftware = AmatIngDeSoftware;
        this.CorreoIng = CorreoIng;
        this.NombreOperador = NombreOperador;
        this.ApatOperador = ApatOperador;
        this.AmatOperador = AmatOperador;
       this.Solucion = solucion;
    }

    
    
    
    
    
    
    
    public ReporteEvento(String ModuloFalla, String DescripcionFalla, String EstadoReporte, String UsuarioFalla, String FechaFalla, String Etiqueta, String folio, String EstadoAsignacion, int InformacionIngenero, String NombreOperador, String ApatOperador, String AmatOperador,String solucion) {
        this.ModuloFalla = ModuloFalla;
        this.DescripcionFalla = DescripcionFalla;
        this.EstadoReporte = EstadoReporte;
        this.UsuarioFalla = UsuarioFalla;
        this.FechaFalla = FechaFalla;
        this.Etiqueta = Etiqueta;
        this.folio = folio;
        this.EstadoAsignacion = EstadoAsignacion;
        this.InformacionIngenero = InformacionIngenero;
        this.NombreOperador = NombreOperador;
        this.ApatOperador = ApatOperador;
        this.AmatOperador = AmatOperador;
          this.Solucion = solucion;
    }
    
    
    

    public ReporteEvento(String ModuloFalla, String DescripcionFalla, String EstadoReporte, String UsuarioFalla, String FechaFalla, String Etiqueta, String folio, String NombreOperador, String ApatOperador, String AmatOperador) {
        this.ModuloFalla = ModuloFalla;
        this.DescripcionFalla = DescripcionFalla;
        this.EstadoReporte = EstadoReporte;
        this.UsuarioFalla = UsuarioFalla;
        this.FechaFalla = FechaFalla;
        this.Etiqueta = Etiqueta;
        this.folio = folio;
        this.NombreOperador = NombreOperador;
        this.ApatOperador = ApatOperador;
        this.AmatOperador = AmatOperador;
    }


    
    
    
    
    
    

    public ReporteEvento(String ModuloFalla, String DescripcionFalla, String EstadoReporte, String UsuarioFalla, String FechaFalla, String Etiqueta, String Operador, String folio) {
        this.ModuloFalla = ModuloFalla;
        this.DescripcionFalla = DescripcionFalla;
        this.EstadoReporte = EstadoReporte;
        this.UsuarioFalla = UsuarioFalla;
        this.FechaFalla = FechaFalla;
        this.Etiqueta = Etiqueta;
        this.Operador = Operador;
        this.folio = folio;
    }
    
    


    public ReporteEvento(String ModuloFalla, String DescripcionFalla, String EstadoReporte, String UsuarioFalla, String Etiqueta, String Operador) {
        this.ModuloFalla = ModuloFalla;
        this.DescripcionFalla = DescripcionFalla;
        this.EstadoReporte = EstadoReporte;
        this.UsuarioFalla = UsuarioFalla;
        this.Etiqueta = Etiqueta;
        this.Operador = Operador;
        
    }
    
    public ReporteEvento(String ModuloFalla, String DescripcionFalla, String EstadoReporte, String UsuarioFalla, String Etiqueta) {
        this.ModuloFalla = ModuloFalla;
        this.DescripcionFalla = DescripcionFalla;
        this.EstadoReporte = EstadoReporte;
        this.UsuarioFalla = UsuarioFalla;
        this.Etiqueta = Etiqueta;
    }
    
    
    public ReporteEvento(String folio){
        this.folio = folio;
    }
    
    
    
    
    
    
    
    
    

    public String getModuloFalla() {
        return ModuloFalla;
    }

    public void setModuloFalla(String ModuloFalla) {
        this.ModuloFalla = ModuloFalla;
    }

    public String getDescripcionFalla() {
        return DescripcionFalla;
    }

    public void setDescripcionFalla(String DescripcionFalla) {
        this.DescripcionFalla = DescripcionFalla;
    }

    public String getEstadoReporte() {
        return EstadoReporte;
    }

    public void setEstadoReporte(String EstadoReporte) {
        this.EstadoReporte = EstadoReporte;
    }

    public String getUsuarioFalla() {
        return UsuarioFalla;
    }

    public void setUsuarioFalla(String UsuarioFalla) {
        this.UsuarioFalla = UsuarioFalla;
    }

    public String getFechaFalla() {
        return FechaFalla;
    }

    public void setFechaFalla(String FechaFalla) {
        this.FechaFalla = FechaFalla;
    }

    public String getEtiqueta() {
        return Etiqueta;
    }

    public void setEtiqueta(String Etiqueta) {
        this.Etiqueta = Etiqueta;
    }

     public String getOperador() {
        return Operador;
    }

    public void setOperador(String Operador) {
        this.Operador = Operador;
    }
    
    
    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }
       public String getNombreOperador() {
        return NombreOperador;
    }

    public void setNombreOperador(String NombreOperador) {
        this.NombreOperador = NombreOperador;
    }

    public String getApatOperador() {
        return ApatOperador;
    }

    public void setApatOperador(String ApatOperador) {
        this.ApatOperador = ApatOperador;
    }

    public String getAmatOperador() {
        return AmatOperador;
    }

   
    public void setAmatOperador(String AmatOperador) {
        this.AmatOperador = AmatOperador;
    }
    
     public String getEstadoAsignacion() {
        return EstadoAsignacion;
    }

    public void setEstadoAsignacion(String EstadoAsignacion) {
        this.EstadoAsignacion = EstadoAsignacion;
    }
    
     public String getNombreIngDeSoftware() {
        return NombreIngDeSoftware;
    }

    public void setNombreIngDeSoftware(String NombreIngDeSoftware) {
        this.NombreIngDeSoftware = NombreIngDeSoftware;
    }

    public String getApatIngDeSoftware() {
        return ApatIngDeSoftware;
    }

    public void setApatIngDeSoftware(String ApatIngDeSoftware) {
        this.ApatIngDeSoftware = ApatIngDeSoftware;
    }

        public String getAmatIngDeSoftware() {
        return AmatIngDeSoftware;
    }

    public void setAmatIngDeSoftware(String AmatIngDeSoftware) {
        this.AmatIngDeSoftware = AmatIngDeSoftware;
    }
    
     public int getInformacionIngenero() {
        return InformacionIngenero;
    }

    public void setInformacionIngenero(int InformacionIngenero) {
        this.InformacionIngenero = InformacionIngenero;
    }
    
     public String getCorreoIng() {
        return CorreoIng;
    }

    public void setCorreoIng(String CorreoIng) {
        this.CorreoIng = CorreoIng;
    }

    public String getSolucion() {
        return Solucion;
    }

    public void setSolucion(String Solucion) {
        this.Solucion = Solucion;
    }
    

    
}
