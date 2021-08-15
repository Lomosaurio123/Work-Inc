/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.mensajes;

import com.working.modelos.Usuario;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class EnyRe {

    public int EYR(String maquinaAceptora) {
        try {
            // ALICE

            Scanner Sc = new Scanner(System.in);
            int numPuerto = 5000;
            //String mensaje = "ya llego sergio el bailador";
            // instancia un socket para aceptar la conexión
            ServerSocket socketConexion = new ServerSocket(numPuerto);
            /**/ System.out.println("preparado para aceptar una conexión");
            // espera una petición de conexión, instante en el cual
            //se crea u n socket de datos
            hellmanC pri = new hellmanC();
            String mensaje = "";
            int p;
            int k = 0;
            int x = 0;
            int A;
            int B = 0;
            Random ra = new Random();
            p = pri.GeneraPQ(0);
            while (p == 2) {
                p = pri.GeneraPQ(0);
            }
            mensaje = Integer.toString(p);

            int bandera = 0;
            while (bandera <= 2) {
                Misocketstream socketDatos = new Misocketstream(socketConexion.accept());
                // System.out.println("conexión aceptada");
                if (bandera == 0) {
                    socketDatos.enviaMensaje(mensaje);
                    ///**/ System.out.println("mensaje enviado");
                    System.out.println("p : " + mensaje);
                }
                if (bandera == 1) {

                    k = ra.nextInt(100) + 1;
                    while (k >= p) {
                        k = ra.nextInt(100) + 1;
                    }
                    String mensaje2 = Integer.toString(k);
                    socketDatos.enviaMensaje(mensaje2);
                    ///**/ System.out.println("mensaje enviado");
                    System.out.println("k : " + k);
                }

                if (bandera == 2) {

                    x = ra.nextInt(100) + 1;
                    while (x >= p) {
                        x = ra.nextInt(100) + 1;
                    }
                    System.out.println("numero x : " + x);
                    double p3 = Math.pow(k, x);
                    A = (int) (p3 % p);
                    mensaje = Integer.toString(A);
                    socketDatos.enviaMensaje(mensaje);
                    System.out.println("A : " + A);
                    ///**/ System.out.println("mensaje enviado");

                }

                int puertoAceptador = 5001;
                Misocketstream misocket = new Misocketstream(maquinaAceptora, puertoAceptador);
                System.out.println("Solicitud de conexion concedida");
                String mensaje2 = misocket.recibeMensaje();
                //System.out.println("Mensaje recibido");
                System.out.println("Bob: " + mensaje2);

                if (bandera == 2) {
                    System.out.println("B : " + mensaje2);
                    B = Integer.parseInt(mensaje2);
                }

                socketDatos.close();
                ///**/ System.out.println("socket de datos cerrado");
                bandera++;
            }
            socketConexion.close();
            /**/ System.out.println("socket de conexión cerrado");

            double z = Math.pow(B, x);
            int claveA = (int) (z % p);
            System.out.println("clave Alice : " + claveA);
            return claveA;

        } // fin de try
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    public void EnUs(String maquinaAceptadora, Usuario us) throws IOException {
        Scanner Sc = new Scanner(System.in);
        try {
            int numPuerto = 5000;

            ServerSocket socketConexion = new ServerSocket(numPuerto);
            System.out.println("Preparad para una conexion");
            int bandera = 0;
            while (bandera < 12) {
                Misocketstream socketDatos = new Misocketstream(socketConexion.accept());
                System.out.println("conexion aceptada");
                if (bandera == 0) {
                    socketDatos.enviaMensaje(us.getCorreo());
                    System.out.println("Mensaje enviado");
                }
                if (bandera == 1) {
                    socketDatos.enviaMensaje(us.getContra());
                    System.out.println("Mensaje enviado");
                }
                if (bandera == 2) {
                    socketDatos.enviaMensaje(us.getContra());
                    System.out.println("Mensaje enviado");
                }
                if (bandera == 3) {
                    socketDatos.enviaMensaje(us.getNombre());
                    System.out.println("Mensaje enviado");
                }
                if (bandera == 4) {
                    socketDatos.enviaMensaje(us.getApat());
                    System.out.println("Mensaje enviado");
                }
                if (bandera == 5) {
                    socketDatos.enviaMensaje(us.getAmat());
                    System.out.println("Mensaje enviado");
                }
                if (bandera == 6) {
                    socketDatos.enviaMensaje(Integer.toString(us.getEdad()));
                    System.out.println("Mensaje enviado");
                }
                if (bandera == 7) {
                    socketDatos.enviaMensaje(us.getGenero());
                    System.out.println("Mensaje enviado");
                }
                if (bandera == 8) {
                    socketDatos.enviaMensaje(us.getCedula());
                    System.out.println("Mensaje enviado");
                }
                if (bandera == 9) {
                    socketDatos.enviaMensaje(us.getProfesion());
                    System.out.println("Mensaje enviado");
                }
                if (bandera == 10) {
                    socketDatos.enviaMensaje(us.getUniversidad());
                    System.out.println("Mensaje enviado");
                }
                if (bandera == 11) {
                    socketDatos.enviaMensaje(us.getTelefono());
                    System.out.println("Mensaje enviado");
                }

                socketDatos.close();
                System.out.println("Socket de datos cerrado");

                int puertoAceptador = 5001;

                Misocketstream miSocket = new Misocketstream(maquinaAceptadora, puertoAceptador);
                System.out.println("Solicitud de conexion aceptada");

                String mensaje2 = miSocket.recibeMensaje();
                System.out.println("Mensaje recibido:" + "\t" + mensaje2);
                miSocket.close();
                System.out.println("socket de datos cerrado");
                bandera ++;
            }
            socketConexion.close();
            System.out.println("Socket de conexion cerrado");

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }

    }

    public static void main(String[] args) throws IOException {
        EnyRe en = new EnyRe();
        String Correo = "rodrigo@gmail.com";
        String Nombre = "rodrigo";
        String Apat = "sd";
        String Amat = "asd";
        int edad = 12;
        String Genero = "masc";
        String Contra = "123";
        String Cedula = "442";
        String profesion = "infe";
        String universidad = "ipn";
        String telefono = "32423";
        Usuario us = new Usuario(Nombre, Apat, Amat, edad, Genero, Correo, Contra, Cedula, profesion, universidad, telefono);

        en.EnUs("192.168.0.11", us);
    }

}
