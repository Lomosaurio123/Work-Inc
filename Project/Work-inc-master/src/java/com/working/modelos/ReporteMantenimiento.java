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
public class ReporteMantenimiento {
    
     
    private String  ModuloMantenimiento;
    private String  DescripcionMantenimiento;
    private String  EstadoReporteMantenimiento;
    private String  UsuarioMantenimiento;
    private String  FechaMantenimiento;
    private String folio;
    private String EstadoAsignacion;

    public ReporteMantenimiento(String ModuloMantenimiento, String DescripcionMantenimiento, String EstadoReporteMantenimiento, String UsuarioMantenimiento, String FechaMantenimiento, String folio, String EstadoAsignacion) {
        this.ModuloMantenimiento = ModuloMantenimiento;
        this.DescripcionMantenimiento = DescripcionMantenimiento;
        this.EstadoReporteMantenimiento = EstadoReporteMantenimiento;
        this.UsuarioMantenimiento = UsuarioMantenimiento;
        this.FechaMantenimiento = FechaMantenimiento;
        this.folio = folio;
        this.EstadoAsignacion = EstadoAsignacion;
    }

    public String getModuloMantenimiento() {
        return ModuloMantenimiento;
    }

    public void setModuloMantenimiento(String ModuloMantenimiento) {
        this.ModuloMantenimiento = ModuloMantenimiento;
    }

    public String getDescripcionMantenimiento() {
        return DescripcionMantenimiento;
    }

    public void setDescripcionMantenimiento(String DescripcionMantenimiento) {
        this.DescripcionMantenimiento = DescripcionMantenimiento;
    }

    public String getEstadoReporteMantenimiento() {
        return EstadoReporteMantenimiento;
    }

    public void setEstadoReporteMantenimiento(String EstadoReporteMantenimiento) {
        this.EstadoReporteMantenimiento = EstadoReporteMantenimiento;
    }

    public String getUsuarioMantenimiento() {
        return UsuarioMantenimiento;
    }

    public void setUsuarioMantenimiento(String UsuarioMantenimiento) {
        this.UsuarioMantenimiento = UsuarioMantenimiento;
    }

    public String getFechaMantenimiento() {
        return FechaMantenimiento;
    }

    public void setFechaMantenimiento(String FechaMantenimiento) {
        this.FechaMantenimiento = FechaMantenimiento;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getEstadoAsignacion() {
        return EstadoAsignacion;
    }

    public void setEstadoAsignacion(String EstadoAsignacion) {
        this.EstadoAsignacion = EstadoAsignacion;
    }

    
}
