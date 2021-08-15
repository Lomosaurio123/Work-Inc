/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.modelos;

/**
 *
 * @author juan-
 */
public class ProfesionistaRequerido {
    
    
    private String NombreProfesion;
    private String StatusPuesto;

    public ProfesionistaRequerido(String NombreProfesion, String StatusPuesto) {
        this.NombreProfesion = NombreProfesion;
        this.StatusPuesto = StatusPuesto;
    }
    
    
    

    public String getNombreProfesion() {
        return NombreProfesion;
    }

    public void setNombreProfesion(String NombreProfesion) {
        this.NombreProfesion = NombreProfesion;
    }

    public String getStatusPuesto() {
        return StatusPuesto;
    }

    public void setStatusPuesto(String StatusPuesto) {
        this.StatusPuesto = StatusPuesto;
    }
    
    
    
    
}
