/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudexercise.dao;

import com.connection.Conexion;
import com.crudexercise.model.Song;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adrip
 */
public class songDAO {

//    private static final String SQL_SELECT = "SELECT Id_song, Name, Artist, Album, Genre FROM song";
//    private static final String SQL_INSERT = "INSERT INTO song(Id_song, Name, Artist, Album, Genre) VALUES (?,?,?,?,?)";
//    private static final String SQL_DELETE = "DELETE FROM song WHERE Id_song=?";
//    private static final String SQL_UPDATE = "UPDATE song SET Name=?, Artist=?, Album=?, Genre=? where  Id_song=?";

    public DefaultTableModel obtener() throws SQLException {
        DefaultTableModel model = new DefaultTableModel();
        String SQL_SELECT = "SELECT Id_song, Name, Artist, Album, Genre FROM song";
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        int rowNumber = 0;
        Object[] tags = new Object[5];
        tags[0] = "Id_song";
        tags[1] = "Name";
        tags[2] = "Artist";
        tags[3] = "Album";
        tags[4] = "Genre";
        model.setColumnIdentifiers(tags);

        try {
            conn = Conexion.conectar();
            stm = conn.createStatement();
            rs = stm.executeQuery(SQL_SELECT);
            while (rs.next()) {
                Object[] rowData = new Object[model.getColumnCount()];
                rowData[0] = rs.getObject(1);
                rowData[1] = rs.getObject(2);
                rowData[2] = rs.getObject(3);
                rowData[3] = rs.getObject(4);
                rowData[4] = rs.getObject(5);
                model.addRow(rowData);
                rowNumber++;
            }
            rs.close();
            stm.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return model;
    }

    public boolean registrar(Song song) {
        Connection conn = null;
        Statement stm = null;
        String SQL_INSERT = "INSERT INTO song values ('" + song.getId_song() + "','" + song.getName() + "','" + song.getArtist() + "','" + song.getAlbum() + "','" + song.getGenre() + "')";
        boolean registros = false;

        try {
            conn = Conexion.conectar();
            stm = conn.createStatement();
            stm.execute(SQL_INSERT);
            registros = true;
            stm.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error Clase SongDAO, metodo insertar");
            e.printStackTrace();
        }
        return registros;
    }

    public boolean actualizar(Song song) {
        Connection conn = null;
        Statement stm = null;
        boolean actuliza = false;
        String SQL_UPDATE = "UPDATE song SET Name='" + song.getName() + "', Artist='" + song.getArtist() + "', Album='" + song.getAlbum() + "', Genre='" + song.getGenre() + "'" + " WHERE Id_song=" + song.getId_song();

        try {
            conn = Conexion.conectar();
            stm = conn.createStatement();
            stm.execute(SQL_UPDATE);
            actuliza = true;

        } catch (SQLException e) {
            System.out.println("Error Clase SongDAO, metodo actulizar");
            e.printStackTrace();
        }

        return actuliza;
    }

    public boolean eliminar(Song song) {
        Connection conn = null;
        Statement stm = null;
        boolean elimina = false;
        
        String SQL_DELETE = "DELETE FROM song WHERE Id_song="+song.getId_song();
        
        try{
            conn = Conexion.conectar();
            stm = conn.createStatement();
            stm.execute(SQL_DELETE);
            elimina = true;
        } catch (SQLException e){
            System.out.println("Error Clase SongDAO, metodo eliminar");
            e.printStackTrace();
        }
        
        return elimina;
    }

}
