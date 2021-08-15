
package com.working.controlador;

import static com.working.controlador.Scraping_allPost.getStatusConnectionCode;
import com.working.modelos.Cedula;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

 
public class Validar_Cedula {
    public String url; 
    public static String Dat = "";
    int cedul;

    public Cedula consultacedula(int numcedula) {
        String titulo;
        String Nombre = null;
        this.cedul=numcedula;
        
        url="http://www.buholegal.com/"+cedul+"/";
        // Compruebo si me da un 200 al hacer la petición
        if (getStatusConnectionCode(url) == 200) {		
            // Obtengo el HTML de la web en un objeto Document
            Document document = getHtmlDocument(url);	
            // Busco todas las entradas que estan dentro de: 
            Elements entradas = document.select("div.col.mb-5");
            System.out.println("Número de entradas en la página inicial de BuholEGAL: "+entradas.size()+"\n");	
            // Paseo cada una de las entradas
            for (Element elem : entradas) {
                titulo = elem.getElementsByClass("tablascedulas").text();
                Nombre = elem.getElementById("nombrecedulah3").text();		
		Dat=titulo;		
                // Con el método "text()" obtengo el contenido que hay dentro de las etiquetas HTML
                // Con el método "toString()" obtengo todo el HTML con etiquetas incluidas
            }		
        }else
            System.out.println("El Status Code no es OK es: "+getStatusConnectionCode(url));
        
        Cedula ced = Filtrado(Dat);
        
        String carrera =ced.getCarrera();
        String universidad = ced.getUniversidad();
        Cedula datos = new Cedula(Nombre,cedul,universidad,carrera);
        return datos;
        //String filtrado = Filtrado(Dat);
        
    }
    //Metodo para pasar la pagina a uun tipo document
    public static Document getHtmlDocument(String url){
    Document doc = null;
	try {
	    doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
	    } catch (IOException ex) {
		System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
	    }
    return doc;
    }
    
   public Cedula Filtrado( String Dat ){
        String Datos = Dat;
        String Carr = "";
        String Carrera = null;
        String busqueda1;
        String busqueda2;
        String busqueda3;
        String busqueda4;
        String Universidad = null;

        if( Datos.equals("") ){
            System.out.println("No encontramos la cedula, intentelo nuevamente");
        }
        else{
            /*char Fil[] = new char[Datos.length()];
            for (int i = 28; i < Datos.length(); i++) {
                if( Datos.charAt(i) == 'n' ){
                    break;
                }
                else{
                    Fil[i] = Datos.charAt(i); 
                    Carr = Carr + Fil[i];
                }
            }
            for (int i = 0; i < (Carr.length()-2); i++) {
                Carrera = Carrera + Carr.charAt(i);
            }*/
            
            busqueda3 ="Carrera";
            busqueda4= "Universidad";
            
            int recorte3= Datos.indexOf(busqueda3)+8;
            int recorte4=Datos.indexOf(busqueda4)-1;
            
            Carrera =Datos.substring(recorte3, recorte4);
            
             
             busqueda1= "Universidad";
             busqueda2= "Estado";
             
              int recorte1=Datos.indexOf(busqueda1)+12;
              int recorte2= Datos.indexOf(busqueda2)-1;
             
              Universidad= Datos.substring(recorte1, recorte2);
        }
        Cedula ced = new Cedula("nombre",0,Universidad,Carrera);
        return ced;
    }
}
    

