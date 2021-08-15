package com.working.mensajes;

import com.working.dao.UsuarioDaoSQL;
import com.working.idao.iUsuarioDao;
import com.working.modelos.Usuario;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hp
 */
public class EyRservidor {

    public int EYRS(String maquinaAceptora) {
        try {
            int numPuerto = 5001;
            ServerSocket socketConexion = new ServerSocket(numPuerto);
            System.out.println("preparado para aceptar una conexión");
            int puertoAceptador = 5000;
            String mensaje = "";
            String mensaje2 = "";
            hellmanC pri = new hellmanC();
            String p = "";
            int A = 0;
            String k = "";
            mensaje = "ok";
            int P = 0;
            int y = 0;
            Random ra = new Random();
            int bandera = 0;
            Scanner Sc = new Scanner(System.in);
            while (bandera <= 2) {
                Misocketstream misocket = new Misocketstream(maquinaAceptora, puertoAceptador);
                //System.out.println("Solicitud de conexion concedida");
                if (bandera == 0) {
                    p = misocket.recibeMensaje();
                    System.out.println("p " + p);
                }
                if (bandera == 1) {
                    k = misocket.recibeMensaje();
                    System.out.println("k " + k);
                }
                if (bandera == 2) {
                    mensaje2 = misocket.recibeMensaje();
                    //System.out.println("Mensaje recibido");
                    System.out.println("A : " + mensaje2);
                    A = Integer.parseInt(mensaje2);

                }
                // instancia un nsocket para aceptar la conexión
                // espera una petición de conexión, instante en el cual
                //se crea u n socket de datos
                Misocketstream socketDatos = new Misocketstream(socketConexion.accept());
                ///**/ System.out.println("conexión aceptada");
                if (bandera == 2) {
                    P = Integer.parseInt(p);
                    int K = Integer.parseInt(k);
                    y = ra.nextInt(100) + 1;
                    while (y >= P) {
                        y = ra.nextInt(100) + 1;
                    }
                    System.out.println("numero y " + y);
                    double p3 = Math.pow(K, y);
                    int B = (int) (p3 % P);
                    mensaje = Integer.toString(B);
                    System.out.println("numero B " + B);
                }

                socketDatos.enviaMensaje(mensaje);
                ///**/ System.out.println("mensaje enviado");
                socketDatos.close();
                ///**/ System.out.println("socket de datos cerrado");
                bandera++;
            }
            socketConexion.close();
            /**/ System.out.println("socket de conexión cerrado");
            double z = Math.pow(A, y);
            int claveB = (int) (z % P);
            return claveB;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public Usuario ReS(String maquinaAceptora) throws IOException {
        try {
            Scanner Sc = new Scanner(System.in);
            int numPuerto = 5001;
            ServerSocket socketConexion = new ServerSocket(numPuerto);
            System.out.println("preparado para aceptar una conexión");
            int puertoAceptador = 5000;
            String Nombre = "";
            String Apat = "";
            String Amat = "";
            int edad = 0;
            String Genero = null;
            String Correo = null;
            String Contra = null;
            String ConfirmaContra = null;
            String Cedula = null;
            String profesion = null;
            String universidad = null;
            String telefono = null;

            String mensaje = "ok";
            int bandera = 0;

            while (bandera < 12) {
                Misocketstream misocket = new Misocketstream(maquinaAceptora, puertoAceptador);
                //System.out.println("Solicitud de conexion concedida");
                if (bandera == 0) {
                    Correo = misocket.recibeMensaje();
                    System.out.println("p " + Correo);

                }
                if (bandera == 1) {
                    Contra = misocket.recibeMensaje();
                    System.out.println("p " + Contra);
                }
                if (bandera == 2) {
                    ConfirmaContra = misocket.recibeMensaje();
                    System.out.println("p " + ConfirmaContra);
                }
                if (bandera == 3) {
                    Nombre = misocket.recibeMensaje();
                    System.out.println("p " + Nombre);
                }
                if (bandera == 4) {
                    Apat = misocket.recibeMensaje();
                    System.out.println("p " + Apat);

                }
                if (bandera == 5) {
                    Amat = misocket.recibeMensaje();
                    System.out.println("p " + Amat);
                }
                if (bandera == 6) {
                    edad = Integer.parseInt(misocket.recibeMensaje());
                    System.out.println("p " + edad);
                }
                if (bandera == 7) {
                    Genero = misocket.recibeMensaje();
                    System.out.println("p " + Genero);
                }
                if (bandera == 8) {
                    Cedula = misocket.recibeMensaje();
                    System.out.println("p " + Cedula);
                }
                if (bandera == 9) {
                    profesion = misocket.recibeMensaje();
                    System.out.println("p " + profesion);
                }
                if (bandera == 10) {
                    universidad = misocket.recibeMensaje();
                    System.out.println("p " + universidad);
                }
                if (bandera == 11) {
                    telefono = misocket.recibeMensaje();
                    System.out.println("p " + telefono);
                    
                }

                // instancia un nsocket para aceptar la conexión
                // espera una petición de conexión, instante en el cual
                //se crea u n socket de datos
                Misocketstream socketDatos = new Misocketstream(socketConexion.accept());
                /**/ System.out.println("conexión aceptada");

                socketDatos.enviaMensaje(mensaje);
                ///**/ System.out.println("mensaje enviado");
                socketDatos.close();
                ///**/ System.out.println("socket de datos cerrado");
                bandera++;
            }
            Usuario us = new Usuario(Nombre, Apat, Amat, edad, Genero, Correo, Contra, ConfirmaContra, Cedula, profesion, universidad, telefono);
            socketConexion.close();
            /**/ System.out.println("socket de conexión cerrado");
            return us;
        } catch (Exception ex) {
            System.out.println("error  " + ex.getMessage());
            ex.printStackTrace();

        }
        return null;
    }

    public static void main(String[] args) throws IOException {

        EyRservidor r = new EyRservidor();
       int clave = r.EYRS("192.168.20.73");
        
        System.out.println("clave BOb : " + clave);
        Usuario usua = r.ReS("192.168.20.73");
        System.out.println("Recibido");
        
        LlavesDes d = new LlavesDes();
        String Nombre = d.Descifrado(usua.getNombre(), Integer.toString(clave));
        String Apat = d.Descifrado(usua.getApat(), Integer.toString(clave));
        String Amat = d.Descifrado(usua.getAmat(), Integer.toString(clave));
        int edad = usua.getEdad();
        String Genero = d.Descifrado(usua.getGenero(), Integer.toString(clave));
        String Correo = d.Descifrado(usua.getCorreo(), Integer.toString(clave));
        String Contra = d.Descifrado(usua.getContra(), Integer.toString(clave));
        String ConfirmaContra = d.Descifrado(usua.getConfirmaContra(), Integer.toString(clave));
        String telef = d.Descifrado(usua.getTelefono(), Integer.toString(clave));
        String Cedula = d.Descifrado(usua.getCedula(), Integer.toString(clave));
        String profesion = d.Descifrado(usua.getProfesion(), Integer.toString(clave));
        String universidad = d.Descifrado(usua.getUniversidad(), Integer.toString(clave));
        
        String nCo = Correo.replace(" ", "");
        String nCon = Contra.replace(" ", "");
        String nom = Nombre.replace(" ", "");
        String pat = Apat.replace(" ", "");
        String mat = Amat.replace(" ", "");
        String gene = Genero.replace(" ", "");
        String ced = Cedula.replace(" ", "");
        String pro = profesion.replace(" ", "");
        String uni = universidad.replace(" ", "");
        String tel = telef.replace(" ", "");
        
        iUsuarioDao usuario = new UsuarioDaoSQL();
        Usuario usuar = new Usuario(nom, pat, mat, edad, gene, nCo, nCon, nCon, ced, pro, uni, tel);
        System.out.println(Correo);
        System.out.println(Contra);
        System.out.println(ConfirmaContra);
        System.out.println(Nombre);
        System.out.println(Apat);
        System.out.println(Amat);
        System.out.println(edad);
        System.out.println(Genero);
        System.out.println(Cedula);
        System.out.println(profesion);
        System.out.println(universidad);
        System.out.println(telef);
        if(usuario.actualizaUsuario(usuar)){
            System.out.println("Usuario Actualizado en la base de datos");
            Usuario ur = usuario.consultaUsuario(Correo, Contra);
            EnyRe en = new EnyRe();
            en.EnUs("192.168.20.73", ur);
            
        }else{
            System.out.println("no se actualizo");
        }    

    }
}
