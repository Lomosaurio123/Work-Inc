package com.working.idao;


import com.working.modelos.faqs;
import java.util.List;

public interface iFaqsDao {
    int altaPregunta(String pregunta);
    
    boolean altaRespuesta(String respuesta , int id_pregun);
   
    int traerPregunta(String IDPregunta);
    
    boolean traerSolucion();
            
    int ModificarPregunta(String f, int id);

    boolean borraPregunta(int IDPregunta);

    List<faqs> traerPreguntas();
    
    List<faqs> traerPyR();
}
