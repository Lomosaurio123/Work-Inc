/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.modelos;

/**
 *
 * @author Hp
 */
public class Idiomas {
    private int id_idioma;
    private int id_usuario;
    private String idioma;
    private String nivelhabla;
    private String nivelescrito;
    private String nivelescucha;
    private String certificado;

    public Idiomas(int id_idioma, int id_usuario, String idioma, String nivelhabla, String nivelescrito, String nivelescucha, String certificado) {
        this.id_idioma = id_idioma;
        this.id_usuario = id_usuario;
        this.idioma = idioma;
        this.nivelhabla = nivelhabla;
        this.nivelescrito = nivelescrito;
        this.nivelescucha = nivelescucha;
        this.certificado = certificado;
    }

    public int getId_idioma() {
        return id_idioma;
    }

    public void setId_idioma(int id_idioma) {
        this.id_idioma = id_idioma;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getNivelhabla() {
        return nivelhabla;
    }

    public void setNivelhabla(String nivelhabla) {
        this.nivelhabla = nivelhabla;
    }

    public String getNivelescrito() {
        return nivelescrito;
    }

    public void setNivelescrito(String nivelescrito) {
        this.nivelescrito = nivelescrito;
    }

    public String getNivelescucha() {
        return nivelescucha;
    }

    public void setNivelescucha(String nivelescucha) {
        this.nivelescucha = nivelescucha;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    @Override
    public String toString() {
        return "Idiomas{" + "id_idioma=" + id_idioma + ", id_usuario=" + id_usuario + ", idioma=" + idioma + ", nivelhabla=" + nivelhabla + ", nivelescrito=" + nivelescrito + ", nivelescucha=" + nivelescucha + ", certificado=" + certificado + '}';
    }
    
    
}
