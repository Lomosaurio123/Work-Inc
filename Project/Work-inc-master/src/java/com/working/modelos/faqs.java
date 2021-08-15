package com.working.modelos;

public class faqs {
    private int id_faq;
    private String Pregunta;
    private String fechapregunta;
    private String respuesta;
    private String estado;

    public faqs(String Pregunta) {
        this.Pregunta = Pregunta;
    }

    public String getPregunta() {
        return Pregunta;
    }

    public void setPregunta(String Pregunta) {
        this.Pregunta = Pregunta;
    }

    public int getId_faq() {
        return id_faq;
    }

    public void setId_faq(int id_faq) {
        this.id_faq = id_faq;
    }

    public String getFechapregunta() {
        return fechapregunta;
    }

    public void setFechapregunta(String fechapregunta) {
        this.fechapregunta = fechapregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public faqs(int id_faq, String Pregunta, String fechapregunta, String respuesta) {
        this.id_faq = id_faq;
        this.Pregunta = Pregunta;
        this.fechapregunta = fechapregunta;
        this.respuesta = respuesta;
    }

    public faqs(int id_faq, String Pregunta, String fechapregunta) {
        this.id_faq = id_faq;
        this.Pregunta = Pregunta;
        this.fechapregunta = fechapregunta;
    }

    public faqs(int id_faq, String Pregunta, String fechapregunta, String respuesta, String estado) {
        this.id_faq = id_faq;
        this.Pregunta = Pregunta;
        this.fechapregunta = fechapregunta;
        this.respuesta = respuesta;
        this.estado = estado;
    }
    
    

    
    
    

    
    
    
    
}
