/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.idao;

import com.working.modelos.Cursos;
import java.util.List;

/**
 *
 * @author Hp
 */
public interface iCursoDao {
    boolean altaCursos(Cursos cur);
    
    boolean actualizaCursos(Cursos cur);
    
    boolean borrarCursos(int id_Cur);
    
    List<Cursos> traeCursos(String correo);
}
