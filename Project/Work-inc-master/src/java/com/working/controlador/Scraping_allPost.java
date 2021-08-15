/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.controlador;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

/**
 *
 * @author Alumno
 */
public class Scraping_allPost {
    public static int getStatusConnectionCode(String url) {
		
    Response response = null;
	
    try {
	response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
    } catch (IOException ex) {
	System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
    }
    return response.statusCode();
    }
        
        
    }

