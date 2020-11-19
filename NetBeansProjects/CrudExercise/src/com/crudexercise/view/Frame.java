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
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private String[] generos = {"POP", "ROCK", "CLASSIC", "TECHNO", "HIP-HOP"};
    private Controller controller;
    private boolean exit = false;

    public Frame() throws SQLException {
        setTitle("MY PLAYLIST");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        controller = new Controller();
        Locale.setDefault(Locale.ENGLISH);

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

        //No ponemos el combo visible 
        combo.setVisible(false);

        txtid = new JTextField(20);
        txtname = new JTextField(20);
        txtartist = new JTextField(20);
        txtalbum = new JTextField(20);
        txtgenre = new JTextField(20);

        //Se deshabilita la introduccion de datos, hasta que sea necesario
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
        
        tabla.setVisible(false);
        panel3.add(new JScrollPane(tabla));
        panelcentral.add(panel3, BorderLayout.SOUTH);

        buttonsListener action = new buttonsListener();
        btnselect.addActionListener(action);
        btninsert.addActionListener(action);
        btnupdate.addActionListener(action);
        btndelete.addActionListener(action);

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
                //Al pulsar el boton se cargan los datos de la tabla y se pone visible
                try {
                    tabla.setModel(controller.obtener());
                } catch (SQLException ex) {
                    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
                tabla.setVisible(true);

            }
            if (e.getSource() == btninsert) {
                //Al pulsar el boton se habilita la edicion de los TextField menos el ID, ya que su valor es AutoIncrementable
                if (btninsert.getText().equals("Add new song")) {
                    txtid.setText("");
                    txtname.setText("");
                    txtartist.setText("");
                    txtalbum.setText("");

                    txtname.setEditable(true);
                    txtartist.setEditable(true);
                    txtalbum.setEditable(true);

                    //Se desabilitan los demas botones para no permitir otras acciones
                    btnselect.setEnabled(false);
                    btnupdate.setEnabled(false);
                    btndelete.setEnabled(false);
                    btninsert.setText("Add this");

                    //El combo se hace visible
                    combo.setVisible(true);
                    combo.addItemListener(new ListenerCombo());

                } else {
                    //Se vuelve al estado principal
                    combo.setVisible(false);
                    btnselect.setEnabled(true);
                    btnupdate.setEnabled(true);
                    btndelete.setEnabled(true);
                    btninsert.setText("Add new song");
                    txtgenre.setText(combo.getSelectedItem() + "");
                    //Se introduce el nuevo registro
                    try {
                        crear();
                    } catch (SQLException ex) {
                        Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    txtid.setText("");
                    txtname.setText("");
                    txtartist.setText("");
                    txtalbum.setText("");
                    txtgenre.setText("");

                    txtid.setEditable(false);
                    txtname.setEditable(false);
                    txtartist.setEditable(false);
                    txtalbum.setEditable(false);
                    txtgenre.setEditable(false);

                }

            }

            if (e.getSource() == btnupdate) {
                //Por defecto exit = false para que llame al metodo de buscar un registro
                if (exit == false) {
                    song = buscarsong();
                }

                //Si ha encontrado un registro, habilita las funciones de update y exit = true para que no vuelva a buscar registro
                //hasta que acabe de actulizar el actual.
                if (song != null) {
                    if (btnupdate.getText().equals("Update song")) {
                        exit = true;
                        //Introduce los valores del registro encontrado en los TextField para editarlos
                        txtid.setText(String.valueOf(song.getId_song()));
                        txtname.setText(song.getName());
                        txtartist.setText(song.getArtist());
                        txtalbum.setText(song.getAlbum());
                        txtgenre.setText(song.getGenre());

                        //Permite la edicion de los TextField para modificarlos, menos el Id
                        txtid.setEditable(false);
                        txtname.setEditable(true);
                        txtartist.setEditable(true);
                        txtalbum.setEditable(true);

                        btnselect.setEnabled(false);
                        btninsert.setEnabled(false);
                        btndelete.setEnabled(false);
                        btnupdate.setText("Update this");

                        //El combo se hace visible
                        combo.setVisible(true);
                        combo.addItemListener(new ListenerCombo());

                    } else {
                        //vuelve al estado principal
                        combo.setVisible(false);
                        btnselect.setEnabled(true);
                        btninsert.setEnabled(true);
                        btndelete.setEnabled(true);
                        btnupdate.setText("Update song");
                        txtgenre.setText(combo.getSelectedItem() + "");
                        
                        //LLama al metodo de actulizar
                        try {
                            actuliza();
                        } catch (SQLException ex) {
                            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        txtid.setText("");
                        txtname.setText("");
                        txtartist.setText("");
                        txtalbum.setText("");
                        txtgenre.setText("");

                        txtid.setEditable(false);
                        txtname.setEditable(false);
                        txtartist.setEditable(false);
                        txtalbum.setEditable(false);
                        txtgenre.setEditable(false);
                        //Exit vuelve a ser false al finalizar las funciones
                        exit = false;

                    }
                }

            }

            if (e.getSource() == btndelete) {
                //al pulsar el boton de delete llama el metodo que elimina un registro
                try {
                    elimina();
                } catch (SQLException ex) {
                    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        public class ListenerCombo implements ItemListener {

            public void itemStateChanged(ItemEvent e) {
                int indice = combo.getSelectedIndex();
                String escribe = generos[indice];
                //Esribe en el TextField de genero, la seleccion marcada
                txtgenre.setText(escribe);

            }

        }

        public void crear() throws SQLException {

            //Coge los datos introducidos un crea un nuevo registro
            Song song = new Song(txtname.getText(), txtartist.getText(), txtalbum.getText(), txtgenre.getText());
            
            //Como nombre y artista tiene que tener algun valor, si no se introduce nada, no creara el registro
            if (song.getName().equals("") == false && song.getArtist().equals("") == false) {
                controller.insertar(song);
                JOptionPane.showMessageDialog(null, "Add Successfull");
                tabla.setModel(controller.obtener());
            }

        }

        public void actuliza() throws SQLException {
            //Coge los datos introducidos y actualiza el registro
            int pasaid = Integer.parseInt(txtid.getText());
            Song song = new Song(pasaid, txtname.getText(), txtartist.getText(), txtalbum.getText(), txtgenre.getText());
            controller.actulizar(song);
            JOptionPane.showMessageDialog(null, "Update Successfull");
            tabla.setModel(controller.obtener());
        }

        public Song buscarsong() {
            //A traves de un id introdizo busca un registro y lo devuelve
            Song song = new Song();
            String sel = (String) JOptionPane.showInputDialog(
                    null,
                    "Introduce Id_song","SEARCH ID",
                    JOptionPane.QUESTION_MESSAGE,null,null,null);

            //Si se marca cancelar, no buscara ningun registro
            if (sel != null) {
                int busca = Integer.parseInt(sel);
                song = controller.buscarID(busca);
                //Si se encuntra un registro
                if (song.getId_song() != 0) {
                    System.out.println("Se ha encontrado");
                } else {
                    //Si no se encuentra ningun registro, muestra un mensaje de error y el registro se iguala a null
                    song = null;
                    JOptionPane.showMessageDialog(null, "This Id_song doesn't exits", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                song = null;
            }

            return song;
        }

        public void elimina() throws SQLException {
            //Se introduce un id con Joption y elimina el registro
            String sel = (String) JOptionPane.showInputDialog(
                    null,
                    "Introduce Id_song to delete","DELETE",
                    JOptionPane.ERROR_MESSAGE,null,null,null);

            //Si se selecciona cancelar no elimina
            if (sel != null) {
                int busca = Integer.parseInt(sel);
                song = controller.buscarID(busca);
                
                //Si el registro se encuentra, lo elimina
                if (song.getId_song() != 0) {
                    controller.eliminar(busca);
                    JOptionPane.showMessageDialog(null, "Delete Successfull");
                    tabla.setModel(controller.obtener());
                }else{
                    //si el registro no se encuentra muestra un mensaje de error
                    JOptionPane.showMessageDialog(null, "This Id_song doesn't exits", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }

        }

    }

}
