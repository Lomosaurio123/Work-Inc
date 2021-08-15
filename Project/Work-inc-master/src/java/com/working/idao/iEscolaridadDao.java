/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.idao;

import com.working.modelos.Escolaridad;
import java.util.List;

/**
 *
 * @author Hp
 */
public interface iEscolaridadDao {
    boolean altaEscolaridad(Escolaridad esco);
    
    boolean actualizaEscolaridad(Escolaridad esco);
    
    boolean borrarEscolaridad(int id_esco);
    
    List<Escolaridad> traeEscolaridad(String correo);
}
