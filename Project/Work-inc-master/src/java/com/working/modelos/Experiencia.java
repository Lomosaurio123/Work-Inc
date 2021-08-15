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
public class Experiencia {
    private int id_experiencia;
    private String correo;
    private String puesto;
    private String empresa;
    private String funcion;
    private String inicio;
    private String fin;

    public Experiencia(int id_experiencia, String correo, String puesto, String empresa, String funcion, String inicio, String fin) {
        this.id_experiencia = id_experiencia;
        this.correo = correo;
        this.puesto = puesto;
        this.empresa = empresa;
        this.funcion = funcion;
        this.inicio = inicio;
        this.fin = fin;
    }

    public Experiencia(int id_experiencia, String puesto, String empresa, String funcion, String inicio, String fin) {
        this.id_experiencia = id_experiencia;
        this.puesto = puesto;
        this.empresa = empresa;
        this.funcion = funcion;
        this.inicio = inicio;
        this.fin = fin;
    }
    

    public int getId_experiencia() {
        return id_experiencia;
    }

    public void setId_experiencia(int id_experiencia) {
        this.id_experiencia = id_experiencia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    @Override
    public String toString() {
        return "Experiencia{" + "id_experiencia=" + id_experiencia + ", correo=" + correo + ", puesto=" + puesto + ", empresa=" + empresa + ", funcion=" + funcion + ", inicio=" + inicio + ", fin=" + fin + '}';
    }

   
    
}
