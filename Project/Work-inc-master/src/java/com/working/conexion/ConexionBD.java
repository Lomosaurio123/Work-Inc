/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.working.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    private Connection Conectar;


    public ConexionBD() {

        String server = "localhost";
        String baseDatos = "WORKINC";
        String usr = "root";
        String pswd = "28062001**gar";
        String url = "jdbc:mysql://"+server+"/"+baseDatos;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Conectar = DriverManager.getConnection(url,usr,pswd);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {

        }
    }
    
    public Connection getConectar() {
        return Conectar;
    }
    
    public void cerrarConectar() throws SQLException{
        Conectar.close();
    }
    
}

