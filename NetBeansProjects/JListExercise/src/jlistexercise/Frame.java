/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlistexercise;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import java.sql.*;

/**
 *
 * @author adriba
 */
public class Frame extends JFrame {

    private JList list, list2;
    private DefaultListModel listModel = new DefaultListModel();
    private DefaultListModel listModel2 = new DefaultListModel();
    private JPanel panel1, panel2, panel3, panel4;
    private JButton boton1, boton2, boton3;

    public Frame() throws SQLException {
        setTitle("Selection and print");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel1.setLayout(new BorderLayout());

        panel3.setLayout(new GridLayout(3, 1, 5, 5));
        boton1 = new JButton(">>>>");
        boton2 = new JButton("<<<<");
        boton3 = new JButton("Imprimir");

        panel3.add(boton1);
        panel3.add(boton2);
        panel3.add(boton3);

        panel2.setLayout(new FlowLayout());
        panel4.setLayout(new FlowLayout());
        panel1.add(panel2, BorderLayout.WEST);
        panel1.add(panel3, BorderLayout.CENTER);
        panel1.add(panel4, BorderLayout.EAST);
        add(panel1);

        //Acciendo a la base de datos
        String url = "jdbc:mysql://localhost:3307/di.?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        try {
            //puede ser que sea requerido lo siguiente
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = java.sql.DriverManager.getConnection(url, "root", "piqui4");
            Statement instruccion = (Statement) conexion.createStatement();
            String sql = "Select id from clients";
            ResultSet resultado = instruccion.executeQuery(sql);

            while (resultado.next()) {
                listModel.addElement(resultado.getString("id"));

            }
            list = new JList(listModel);

            panel2.add(list);

            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }

        list2 = new JList(listModel2);
        panel4.add(list2);

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s;
                //toma el indice del elemnto seleccionado de la list
                int index = list.getSelectedIndex();
                if (index >= 0) {
                    //devuelve el valor selecionado
                    s = (String) listModel.get(index);
                    listModel.remove(index);
                    //anadira a la listamodel2
                    listModel2.addElement(s);
                }
            }

        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //toma el indice del elemnto seleccionado de la list
                int index = list2.getSelectedIndex();
                if (index >= 0) {
                    String devuelve = (String) listModel2.get(index);
                    //eliminara de la lista
                    listModel2.remove(index);
                    //anadira a la listamodel
                    listModel.addElement(devuelve);
                }
            }

        });
    }

}
