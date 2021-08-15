/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.idao;

import com.working.modelos.Idioma;
import java.util.List;

/**
 *
 * @author Hp
 */
public interface iIdiomaDao {
    boolean altaIdioma(Idioma idi);
    
    boolean actualizaIdioma(Idioma idi);
    
    boolean borrarIdioma(int id_idioma);
    
    List<Idioma> traeIdioma(String correo);
}
