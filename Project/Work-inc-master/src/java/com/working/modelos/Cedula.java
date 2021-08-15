/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.modelos;

/**
 *
 * @author Alumno
 */
public class Cedula {
    
    private String nombre;
    private int cedula;
    private String universidad;
    private String carrera;

    @Override
    public String toString() {
        return "Cedula{" + "nombre=" + nombre + ", cedula=" + cedula + ", universidad=" + universidad + ", carrera=" + carrera + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Cedula(String nombre, int cedula, String universidad, String carrera) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.universidad = universidad;
        this.carrera = carrera;
    }

   
    
}
