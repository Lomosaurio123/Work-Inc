/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.idao;

import com.working.modelos.Escolaridad;
import com.working.modelos.Experiencia;
import java.util.List;

/**
 *
 * @author juan-
 */
public interface iExperienciaDao {
    boolean altaExperiencia(Experiencia esco);
    
    boolean actualizaExperiencia(Experiencia esco);
    
    boolean borrarExperiencia(int id_xp);
    
    List<Experiencia> traeExperiencia(String correo);
}
