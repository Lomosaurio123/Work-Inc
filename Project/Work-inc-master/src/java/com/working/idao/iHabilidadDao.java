/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.idao;

import com.working.modelos.Habilidades;
import java.util.List;

/**
 *
 * @author Hp
 */
public interface iHabilidadDao {
    boolean altaHabilidades(Habilidades esco);
    
    boolean actualizaHabilidades(Habilidades esco);
    
    boolean borrarHabilidades(int id_hab);
    
    List<Habilidades> traeHabilidades(String correo);
}
