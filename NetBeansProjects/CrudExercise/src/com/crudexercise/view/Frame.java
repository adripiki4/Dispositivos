/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crudexercise.view;

import com.crudexercise.controller.Controller;
import com.crudexercise.model.Song;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author adrip
 */
public class Frame extends JFrame {

    private JPanel panelcentral, panel1, panel2, panel3;
    private JButton btnselect, btninsert, btnupdate, btndelete;
    private JLabel lbId, lbname, lbartist, lbalbum, lbgenre;
    private JTextField txtid, txtname, txtartist, txtalbum, txtgenre;
    private JTable tabla;
    private JComboBox combo;
    private String[] generos = {"POP", "ROCK", "CLASSIC", "TECHNO"};
    private Controller controller;

    public Frame() throws SQLException {
        setTitle("MY PLAYLIST");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        controller = new Controller();

        //Definimos panel central
        panelcentral = new JPanel();
        panelcentral.setLayout(new BorderLayout());

        //Definimos primer panel
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        //Rellenamos el panel
        btnselect = new JButton("View all songs");
        btninsert = new JButton("Add new song");
        btnupdate = new JButton("Update song");
        btndelete = new JButton("Delete song");
        panel1.add(btnselect);
        panel1.add(btninsert);
        panel1.add(btnupdate);
        panel1.add(btndelete);
        panelcentral.add(panel1, BorderLayout.NORTH);

        //Definimos segundo panel
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(6, 2));
        //Rellenamos el panel
        lbId = new JLabel("Id Song");
        lbname = new JLabel("Name");
        lbartist = new JLabel("Artist");
        lbalbum = new JLabel("Album");
        lbgenre = new JLabel("Genre");
        combo = new JComboBox(generos);

        combo.setVisible(false);

        txtid = new JTextField(20);
        txtname = new JTextField(20);
        txtartist = new JTextField(20);
        txtalbum = new JTextField(20);
        txtgenre = new JTextField(20);

        txtid.setEditable(false);
        txtname.setEditable(false);
        txtartist.setEditable(false);
        txtalbum.setEditable(false);
        txtgenre.setEditable(false);
        panel2.add(lbId);
        panel2.add(txtid);
        panel2.add(lbname);
        panel2.add(txtname);
        panel2.add(lbartist);
        panel2.add(txtartist);
        panel2.add(lbalbum);
        panel2.add(txtalbum);
        panel2.add(lbgenre);
        panel2.add(txtgenre);
        panel2.add(combo);
        panelcentral.add(panel2, BorderLayout.CENTER);

        //Definimos el tercer panel
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        tabla = new JTable();
        //tabla.setModel(controller.obtener());
        tabla.setVisible(false);
        panel3.add(new JScrollPane(tabla));
        panelcentral.add(panel3, BorderLayout.SOUTH);

        buttonsListener action = new buttonsListener();
        btnselect.addActionListener(action);
        btninsert.addActionListener(action);

        add(panelcentral);

    }

    class buttonsListener implements ActionListener {

        private Controller controller = new Controller();
        int id;
        String name;
        String artist;
        String album;
        Song song = new Song();

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnselect) {
                try {
                    tabla.setModel(controller.obtener());
                } catch (SQLException ex) {
                    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
                tabla.setVisible(true);

            }
            if (e.getSource() == btninsert) {
                if (btninsert.getText().equals("Add new song")) {
                    txtid.setText("");
                    txtname.setText("");
                    txtartist.setText("");
                    txtalbum.setText("");

                    txtid.setEditable(true);
                    txtname.setEditable(true);
                    txtartist.setEditable(true);
                    txtalbum.setEditable(true);

                    btnselect.setEnabled(false);
                    btnupdate.setEnabled(false);
                    btndelete.setEnabled(false);
                    btninsert.setText("Add this");

                    combo.setVisible(true);
                    combo.addItemListener(new ListenerCombo());

                } else {
                    combo.setVisible(false);
                    btnselect.setEnabled(true);
                    btnupdate.setEnabled(true);
                    btndelete.setEnabled(true);
                    btninsert.setText("Add new song");
                    txtgenre.setText(combo.getSelectedItem() + "");
                    song = crear();
                    controller.insertar(song);
                    

                }

            }
        }

        public class ListenerCombo implements ItemListener {

            public void itemStateChanged(ItemEvent e) {
                int indice = combo.getSelectedIndex();
                String escribe = generos[indice];
                txtgenre.setText(escribe);

            }

        }
        
        public Song crear(){
           // int pasaid = Integer.parseInt(txtid.getText());
            Song song = new Song(txtname.getText(), txtartist.getText(), txtalbum.getText(), txtgenre.getText());
            return song;
        }

    }

}
