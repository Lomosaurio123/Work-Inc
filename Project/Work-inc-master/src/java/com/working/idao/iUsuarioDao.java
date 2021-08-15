/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.idao;

import com.working.modelos.Usuario;

/**
 *
 * @author juan-
 */
public interface iUsuarioDao {
    
    boolean altaUsuario(Usuario u);/// create
    
    String entraUsuario(Usuario u);
    
    Usuario consultaUsuario(String nombre_usuario, String contra_usuario );/// read
    //cambio de vacio a boolean
    
    boolean actualizaUsuario(Usuario u);// update
    
    boolean borraUsuario(String coreo_usuario,String Contra);// delete

    boolean correorepetido(Usuario u);
    
}
