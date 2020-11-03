/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layouts;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author adriba
 */
public class Frame extends JFrame {

    private JPanel panel1, panel2, panel3, panel4, panelprin;
    private JButton boton1, boton2, boton3, boton4, boton5;

    public Frame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setTitle("Probando Layouts");

        panelprin = new JPanel();
        panelprin.setLayout(new GridLayout(1, 2));
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

        boton1 = new JButton("Boton1");
        boton2 = new JButton("Boton2");
        boton3 = new JButton("Boton3");
        boton4 = new JButton("Boton4");
        boton5 = new JButton("Boton5");

        panel1.setLayout(new GridLayout(2, 1));
        panel1.add(boton1);
        panel1.add(boton2);
       
        panel2.setLayout(new GridLayout(2,2 ));
        
        panel2.add(boton3);
        panel2.add(boton4);
        panel2.add(boton5);
//        panelprin.add(boton1);
       
        panelprin.add(panel1);
         panelprin.add(panel2);
//        panelprin.add(boton2);
//        panelprin.add(boton3);
//        panelprin.add(boton4);
//       

        
        add(panelprin);
    }

}
