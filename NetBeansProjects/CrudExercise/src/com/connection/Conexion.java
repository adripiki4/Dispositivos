/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connection;

import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author adriba
 */
public class Conexion {

    public static Connection conectar() {
        Connection con = null;
        String password = "piqui4";
        String usuario = "root";
        String url = "jdbc:mysql://localhost:3307/myplaylist?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        try {
            con = (Connection) DriverManager.getConnection(url, usuario, password);
            if (con != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
            e.printStackTrace();
        }

        return con;
    }
}
