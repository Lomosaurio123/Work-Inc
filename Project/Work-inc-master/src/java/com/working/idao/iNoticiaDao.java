/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.idao;

import com.working.modelos.Noticia;
import java.util.List;

/**
 *
 * @author juan-
 */
public interface iNoticiaDao {
    
  
    int altaNoticia(Noticia n);

    Noticia traerNoticia(String Titulo);

    void actualizaNoticia(Noticia n);

    boolean borraNoticia(int Id_noticia);

    List<Noticia> traerNoticiaPrevias();
    
    List<Noticia> traerNoticias();
    
    List<Noticia> traerNoticias4();
}
