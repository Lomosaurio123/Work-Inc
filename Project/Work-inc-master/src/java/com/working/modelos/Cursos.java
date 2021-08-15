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
public class Cursos {
    private int id_cursos;
    private String correo;
    private String nombre_curso;
    private String año;
    private int duracion;

    public Cursos(int id_cursos, String correo, String nombre_curso, String año, int duracion) {
        this.id_cursos = id_cursos;
        this.correo = correo;
        this.nombre_curso = nombre_curso;
        this.año = año;
        this.duracion = duracion;
    }

    public Cursos(int id_cursos, String nombre_curso, String año, int duracion) {
        this.id_cursos = id_cursos;
        this.nombre_curso = nombre_curso;
        this.año = año;
        this.duracion = duracion;
    }

    public int getId_cursos() {
        return id_cursos;
    }

    public void setId_cursos(int id_cursos) {
        this.id_cursos = id_cursos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Cursos{" + "id_cursos=" + id_cursos + ", correo=" + correo + ", nombre_curso=" + nombre_curso + ", a\u00f1o=" + año + ", duracion=" + duracion + '}';
    }

   
    
}
