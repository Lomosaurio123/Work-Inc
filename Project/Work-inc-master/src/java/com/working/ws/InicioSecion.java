/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.ws;

/**
 *
 * @author juan-
 */
public class InicioSecion {

    private static String hello(java.lang.String usr, java.lang.String contraa) {
        WebServices.INICIOSESION_Service service = new WebServices.INICIOSESION_Service();
        WebServices.INICIOSESION port = service.getINICIOSESIONPort();
        return port.hello(usr, contraa);
    }
    
    public String AccesoDeSesion(String correoCliente, String contraCliente){       
        String estado;
        estado= hello(correoCliente, contraCliente);
        return estado;      
    }
 
}
