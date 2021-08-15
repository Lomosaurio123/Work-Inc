/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.idao;


import com.working.modelos.Software;
import java.util.List;

/**
 *
 * @author Hp
 */
public interface iSoftwareDao {
    boolean altaSoftware(Software sof);
    
    boolean actualizaSoftware(Software sof);
    
    boolean borrarSoftware(int id_sof);
    
    List<Software> traeSoftware(String correo);
}
