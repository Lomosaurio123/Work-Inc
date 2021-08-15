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
public class Usuario {

    public Usuario(String Nombre, String Apat, String Amat, String Correo, String profesion) {
        this.Nombre = Nombre;
        this.Apat = Apat;
        this.Amat = Amat;
        this.Correo = Correo;
        this.profesion = profesion;
    }
    
    private String Nombre;
    private String Apat;
    private String Amat;
    private int Edad;
    private String Genero;
    private String Correo;
    private String Contra;
    private String ConfirmaContra;
    private String Cedula;
    private String profesion;
    private String universidad;
    private String telefono;
    private String CodigoAdmin;

    public Usuario(String Nombre, String Apat, String Amat, String Correo, String Contra, String CodigoAdmin) {
        this.Nombre = Nombre;
        this.Apat = Apat;
        this.Amat = Amat;
        this.Correo = Correo;
        this.Contra = Contra;
        this.CodigoAdmin = CodigoAdmin;
    }
    
    
    
    
    

    public Usuario(String Nombre, String Apat, String Amat, int Edad, String Genero, String Correo, String Contra, String ConfirmaContra, String Cedula, String profesion, String universidad, String telefono, String CodigoAdmin) {
        this.Nombre = Nombre;
        this.Apat = Apat;
        this.Amat = Amat;
        this.Edad = Edad;
        this.Genero = Genero;
        this.Correo = Correo;
        this.Contra = Contra;
        this.ConfirmaContra = ConfirmaContra;
        this.Cedula = Cedula;
        this.profesion = profesion;
        this.universidad = universidad;
        this.telefono = telefono;
        this.CodigoAdmin = CodigoAdmin;
    }
    
    


    

    public Usuario(String Nombre, String Apat, String Amat, int Edad, String Genero, String Correo, String Contra, String Cedula, String profesion, String universidad, String telefono) {
        this.Nombre = Nombre;
        this.Apat = Apat;
        this.Amat = Amat;
        this.Edad = Edad;
        this.Genero = Genero;
        this.Correo = Correo;
        this.Contra = Contra;
        this.Cedula = Cedula;
        this.profesion = profesion;
        this.universidad = universidad;
        this.telefono = telefono;
    }

    public Usuario(String Nombre, String Apat, String Amat, int Edad, String Genero, String Correo, String Contra, String ConfirmaContra, String Cedula, String profesion, String universidad, String telefono) {
        this.Nombre = Nombre;
        this.Apat = Apat;
        this.Amat = Amat;
        this.Edad = Edad;
        this.Genero = Genero;
        this.Correo = Correo;
        this.Contra = Contra;
        this.ConfirmaContra = ConfirmaContra;
        this.Cedula = Cedula;
        this.profesion = profesion;
        this.universidad = universidad;
        this.telefono = telefono;
    }

    public Usuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Usuario{" + "Nombre=" + Nombre + ", Apat=" + Apat + ", Amat=" + Amat + ", Edad=" + Edad + ", Genero=" + Genero + ", Correo=" + Correo + ", Contra=" + Contra + ", ConfirmaContra=" + ConfirmaContra + ", Cedula=" + Cedula + ", profesion=" + profesion + ", universidad=" + universidad + ", telefono=" + telefono + '}';
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApat() {
        return Apat;
    }

    public void setApat(String Apat) {
        this.Apat = Apat;
    }

    public String getAmat() {
        return Amat;
    }

    public void setAmat(String Amat) {
        this.Amat = Amat;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContra() {
        return Contra;
    }

    public void setContra(String Contra) {
        this.Contra = Contra;
    }

    public String getConfirmaContra() {
        return ConfirmaContra;
    }

    public void setConfirmaContra(String ConfirmaContra) {
        this.ConfirmaContra = ConfirmaContra;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Usuario(String Correo, String Contra) {
        this.Correo = Correo;
        this.Contra = Contra;
    }
    
        public String getCodigoAdmin() {
        return CodigoAdmin;
    }

    public void setCodigoAdmin(String CodigoAdmin) {
        this.CodigoAdmin = CodigoAdmin;
    }

}
