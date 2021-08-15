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
public class Escolaridad {
    private int id_escolaridad;
    private String correo;
    private String escuela;
    private String carrera;
    private String inicio;
    private String fin;

    public Escolaridad(int id_escolaridad, String correo, String escuela, String carrera, String inicio, String fin) {
        this.id_escolaridad = id_escolaridad;
        this.correo = correo;
        this.escuela = escuela;
        this.carrera = carrera;
        this.inicio = inicio;
        this.fin = fin;
    }

    public Escolaridad(int id_escolaridad, String escuela, String carrera, String inicio, String fin) {
        this.id_escolaridad = id_escolaridad;
        this.escuela = escuela;
        this.carrera = carrera;
        this.inicio = inicio;
        this.fin = fin;
    }

    public int getId_escolaridad() {
        return id_escolaridad;
    }

    public void setId_escolaridad(int id_escolaridad) {
        this.id_escolaridad = id_escolaridad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
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
        return "Escolaridad{" + "id_escolaridad=" + id_escolaridad + ", correo=" + correo + ", escuela=" + escuela + ", carrera=" + carrera + ", inicio=" + inicio + ", fin=" + fin + '}';
    }
    

    
    
}
