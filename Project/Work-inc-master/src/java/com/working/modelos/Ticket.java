
package com.working.modelos;


public class Ticket {
    private String Folio;
    private String CorreoUsuarioTicket;
    private String EstadoRevision ;
    private int InformacionResponsableRevision;
    private String NombreResponsableRevisicon;
    private String ApatResponsableRevisicon;
    private String AmatResponsableRevisicon;
    private String FechaCreacionTicket ;
    private String Modulo;
    private String DescripcionProblema ;
    private String Respuesta;

    public Ticket(String CorreoUsuarioTicket, String Modulo, String DescripcionProblema) {
        this.CorreoUsuarioTicket = CorreoUsuarioTicket;
        this.Modulo = Modulo;
        this.DescripcionProblema = DescripcionProblema;
    }

    public Ticket(String Folio, String EstadoRevision, int InformacionResponsableRevision, String NombreResponsableRevisicon, String ApatResponsableRevisicon, String AmatResponsableRevisicon, String FechaCreacionTicket, String Modulo, String DescripcionProblema, String Respuesta) {
        this.Folio = Folio;
        this.EstadoRevision = EstadoRevision;
        this.InformacionResponsableRevision = InformacionResponsableRevision;
        this.NombreResponsableRevisicon = NombreResponsableRevisicon;
        this.ApatResponsableRevisicon = ApatResponsableRevisicon;
        this.AmatResponsableRevisicon = AmatResponsableRevisicon;
        this.FechaCreacionTicket = FechaCreacionTicket;
        this.Modulo = Modulo;
        this.DescripcionProblema = DescripcionProblema;
        this.Respuesta = Respuesta;
    }

    public Ticket(String Folio, String EstadoRevision, int InformacionResponsableRevision, String FechaCreacionTicket, String Modulo, String DescripcionProblema, String Respuesta) {
        this.Folio = Folio;
        this.EstadoRevision = EstadoRevision;
        this.InformacionResponsableRevision = InformacionResponsableRevision;
        this.FechaCreacionTicket = FechaCreacionTicket;
        this.Modulo = Modulo;
        this.DescripcionProblema = DescripcionProblema;
        this.Respuesta = Respuesta;
    }
    

    
    
    
    
    
    
    @Override
    public String toString() {
        return "Ticket{" + "Folio=" + Folio + ", CorreoUsuarioTicket=" + CorreoUsuarioTicket + ", EstadoRevision=" + EstadoRevision + ", InformacionResponsableRevision=" + InformacionResponsableRevision + ", NombreResponsableRevisicon=" + NombreResponsableRevisicon + ", ApatResponsableRevisicon=" + ApatResponsableRevisicon + ", AmatResponsableRevisicon=" + AmatResponsableRevisicon + ", FechaCreacionTicket=" + FechaCreacionTicket + ", Modulo=" + Modulo + ", DescripcionProblema=" + DescripcionProblema + ", Respuesta=" + Respuesta + '}';
    }
    

    public String getFolio() {
        return Folio;
    }

    public void setFolio(String Folio) {
        this.Folio = Folio;
    }

    public String getCorreoUsuarioTicket() {
        return CorreoUsuarioTicket;
    }

    public void setCorreoUsuarioTicket(String CorreoUsuarioTicket) {
        this.CorreoUsuarioTicket = CorreoUsuarioTicket;
    }

    public String getEstadoRevision() {
        return EstadoRevision;
    }

    public void setEstadoRevision(String EstadoRevision) {
        this.EstadoRevision = EstadoRevision;
    }

    public int getInformacionResponsableRevision() {
        return InformacionResponsableRevision;
    }

    public void setInformacionResponsableRevision(int InformacionResponsableRevision) {
        this.InformacionResponsableRevision = InformacionResponsableRevision;
    }

    public String getNombreResponsableRevisicon() {
        return NombreResponsableRevisicon;
    }

    public void setNombreResponsableRevisicon(String NombreResponsableRevisicon) {
        this.NombreResponsableRevisicon = NombreResponsableRevisicon;
    }

    public String getApatResponsableRevisicon() {
        return ApatResponsableRevisicon;
    }

    public void setApatResponsableRevisicon(String ApatResponsableRevisicon) {
        this.ApatResponsableRevisicon = ApatResponsableRevisicon;
    }

    public String getAmatResponsableRevisicon() {
        return AmatResponsableRevisicon;
    }

    public void setAmatResponsableRevisicon(String AmatResponsableRevisicon) {
        this.AmatResponsableRevisicon = AmatResponsableRevisicon;
    }

    public String getFechaCreacionTicket() {
        return FechaCreacionTicket;
    }

    public void setFechaCreacionTicket(String FechaCreacionTicket) {
        this.FechaCreacionTicket = FechaCreacionTicket;
    }

    public String getModulo() {
        return Modulo;
    }

    public void setModulo(String Modulo) {
        this.Modulo = Modulo;
    }

    public String getDescripcionProblema() {
        return DescripcionProblema;
    }

    public void setDescripcionProblema(String DescripcionProblema) {
        this.DescripcionProblema = DescripcionProblema;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    public void setRespuesta(String Respuesta) {
        this.Respuesta = Respuesta;
    }
    
    
    
    
    
}
