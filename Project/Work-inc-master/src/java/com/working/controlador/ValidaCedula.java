/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.controlador;

import com.working.modelos.Cedula;

/**
 *
 * @author juan-
 */
public class ValidaCedula {
    
    
    private int cedula;
    
    public Cedula Compruebacedula(int cedula_de_controlador){
        
        this.cedula=cedula_de_controlador;      
        Validar_Cedula trae = new Validar_Cedula();       
        Cedula del =trae.consultacedula(cedula);      
        return del;

    }
    
    
    
    
    
    
}
