package com.working.idao;

import com.working.modelos.Proyecto;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juan-
 */
public interface iProyectoDao {
    
boolean altaProyecto(Proyecto p);

boolean actualizaProyecto(Proyecto p);

void borraProyecto(Proyecto p);

Proyecto consultaProyecto(Proyecto p);

List <Proyecto> traerProyecto ( int id, String Correo);
}
