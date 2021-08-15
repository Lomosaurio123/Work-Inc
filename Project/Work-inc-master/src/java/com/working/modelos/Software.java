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
public class Software {
    private int id_software;
    private String correo;
    private String software;
    private String año;
    private String constancia;

    public Software(int id_software, String correo, String software, String año, String constancia) {
        this.id_software = id_software;
        this.correo = correo;
        this.software = software;
        this.año = año;
        this.constancia = constancia;
    }

    public Software(int id_software, String software, String año, String constancia) {
        this.id_software = id_software;
        this.software = software;
        this.año = año;
        this.constancia = constancia;
    }

    public int getId_software() {
        return id_software;
    }

    public void setId_software(int id_software) {
        this.id_software = id_software;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getConstancia() {
        return constancia;
    }

    public void setConstancia(String constancia) {
        this.constancia = constancia;
    }

    @Override
    public String toString() {
        return "Software{" + "id_software=" + id_software + ", correo=" + correo + ", software=" + software + ", a\u00f1o=" + año + ", constancia=" + constancia + '}';
    }

   
}
