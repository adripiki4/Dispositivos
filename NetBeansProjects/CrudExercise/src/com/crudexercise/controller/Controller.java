/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudexercise.controller;

import com.crudexercise.dao.songDAO;
import com.crudexercise.model.Song;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adrip
 */
public class Controller {

    private songDAO songdao = new songDAO();

    public Controller() {

    }

    //LLamar al DAO para sacar los datos de la base de datos
    public DefaultTableModel obtener() throws SQLException {
        DefaultTableModel model = new DefaultTableModel();
        model = songdao.obtener();
        return model;
    }

    //LLamar al dao para insertar nueva cancion
    public void insertar(Song song) {
        songdao.registrar(song);
    }

    //LLamar al DAO para actulizar una cancion
    public void actulizar(Song song) {
        songdao.actualizar(song);
    }

    //LLamar al DAO para eliminar una cancion
    public void eliminar(Song song) {
        songdao.eliminar(song);
    }
}
