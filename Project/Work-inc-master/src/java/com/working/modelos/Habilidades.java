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
public class Habilidades {
    private int id_habilidad;
    private String correo;
    private String habilidad;

    public Habilidades(int id_habilidad, String correo, String habilidad) {
        this.id_habilidad = id_habilidad;
        this.correo = correo;
        this.habilidad = habilidad;
    }

    public Habilidades(int id_habilidad, String habilidad) {
        this.id_habilidad = id_habilidad;
        this.habilidad = habilidad;
    }

    public int getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(int id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    @Override
    public String toString() {
        return "Habilidades{" + "id_habilidad=" + id_habilidad + ", correo=" + correo + ", habilidad=" + habilidad + '}';
    }

    
    
}
