/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import DAO.ClientDAO;
import DAO.Connection_DB;
import DAO.client;
import java.awt.event.*;
import java.sql.*;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author adriba
 */
public class listener implements ActionListener {

    private JTextField id, searchID;
    private JTextArea notes;
    private JButton backwards, forward, search, all;
    private List<client> clients;
    private int position;

    public listener(JTextField id, JTextArea notes, JTextField searchID,
            JButton backwards, JButton forward, JButton search, JButton all) {
        this.id = id;
        this.notes = notes;
        this.searchID = searchID;
        this.backwards = backwards;
        this.forward = forward;
        this.search = search;
        this.all = all;
        position = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        client c = new client();
        // FIND A CLIENT
        if (e.getSource() == this.search) {
            // in searches disabled movement buttons
            forward.setEnabled(false);
            backwards.setEnabled(false);
        
        try {
            DB_Connection DB_Connection = new DB_Connection();
            Connection with = DB_connection.OpenConexion();
            CustomerDAO customerDAO = new CustomerDAO();
            c.setId(idBuscar.getText());
            c = clientDAO.findById(with, c);
            conexion_DB.CerrarConexion(with);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    // LOAD ALL CLIENTS
 if (e.getSource () == this.all) {
 // on all motion buttons enabled
 forward.setEnabled (true);
 backwards.setEnabled (true);
 position = 0;
 // All clients:
 try {
 DB_Connection DB_Connection = new DB_Connection (); 
 Connection with = DB_connection.OpenConexion ();
 CustomerDAO customerDAO = new CustomerDAO ();
 customers = customerDAO.findAll (with); 
 conexion_DB.CloseConexion (with);
 // charge the first customer
 position = 0;
 c = customers.get (position);
 } catch (Exception ex) {
 ex.printStackTrace (); 
 }
 }
 //AHEAD
 if (e.getSource () == this.ahead) {
 position ++;
 if (position == customers.size ()) {
 position--;
 }
    
    
}
    }
}
