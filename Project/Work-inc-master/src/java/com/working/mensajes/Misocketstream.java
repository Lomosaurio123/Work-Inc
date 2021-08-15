/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.mensajes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author Hp
 */
public class Misocketstream extends Socket {

    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter salida;

    Misocketstream(String maquinaAceptadora,int puertoAceptador) throws SocketException, IOException {
        socket = new Socket(maquinaAceptadora, puertoAceptador);
        establecerFlujos();
    }

    Misocketstream(Socket socket) throws IOException {
        this.socket = socket;
        establecerFlujos();
    }

    
    private void establecerFlujos() throws IOException {
        // obtiene un flujo de salida para leer del socket de datos
        InputStream flujoEntrada = socket.getInputStream();
        entrada = new BufferedReader(new InputStreamReader(flujoEntrada));
        OutputStream flujoSalida = socket.getOutputStream();
        // crea un objeto PrintWriter para salida en modo carácter
        salida  = new PrintWriter(new OutputStreamWriter(flujoSalida));
    }

    public void enviaMensaje(String mensaje)
            throws IOException {
        salida.println(mensaje);
        // L a subsiguiente llamada al método flush es necesaria para que
        // los datos se escriban en el flujo de datos del socket
        // antes de que se cierre el socket.
        salida.flush();
    } // fin de enviaMensa je

    public String recibeMensaje()
            throws IOException {
        // lee una linea del flujo de datos
        String mensaje = entrada.readLine();
        return mensaje;
    } // fin de recibeMensaje

    
    public void close()throws IOException {
        socket.close();
    }
}
