/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.mensajes;

import java.util.Random;

/**
 *
 * @author Hp
 */
public class hellmanC {

    public int GeneraPQ(int igual) {
        int a = 1, b = 100, resultado;
        Random ra = new Random();
        while (true) {
            resultado = (int) Math.floor(Math.random() * (b - a + 1) + a);
            if (VerificarN(resultado) && resultado != igual) {
                break;
            }
        }

        return resultado;

    }

    static boolean VerificarN(int n) {
        int suma = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                suma++;
                break;
            }
        }
        if (suma == 0) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        
    }

}
