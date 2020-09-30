/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author adriba
 */
public class Frame2 extends JFrame {
    JPanel panel = new JPanel();
    private JButton azul, rosa,amarillo,verde;
    public Frame2(){
            setTitle("Example with several buttons");
            setSize(800,600);
            panel.setLayout(new BorderLayout());
            azul = new JButton("Blue");
            Dimension d = new Dimension();
            d.height = 40;
            d.width = 100;
            azul.setPreferredSize(d);
            azul.addActionListener(new button_listener1());
            verde = new JButton("Verde");
            d.height = 40;
            d.width = 100;
            verde.setPreferredSize(d);
            verde.addActionListener(new button_listener2());
            amarillo = new JButton("Amarillo");
            d.height = 40;
            d.width = 100;
            amarillo.setPreferredSize(d);
            amarillo.addActionListener(new button_listener3());
            rosa = new JButton("Rosa");
            d.height = 40;
            d.width = 100;
            rosa.setPreferredSize(d);
            rosa.addActionListener(new button_listener4());
            panel.add(azul,BorderLayout.SOUTH);
            panel.add(verde,BorderLayout.NORTH);
            panel.add(amarillo,BorderLayout.EAST);
            panel.add(rosa,BorderLayout.WEST);
            add(panel);
            panel.setBackground(Color.red);
            
            }
     class button_listener1 implements ActionListener {

        public void actionPerformed (ActionEvent e) {
            panel.setBackground(Color.blue);
        }
    }
     class button_listener2 implements ActionListener {

        public void actionPerformed (ActionEvent e) {
            panel.setBackground(Color.green);
        }
    }
     class button_listener3 implements ActionListener {

        public void actionPerformed (ActionEvent e) {
            panel.setBackground(Color.YELLOW);
        }
    }
     class button_listener4 implements ActionListener {

        public void actionPerformed (ActionEvent e) {
            panel.setBackground(Color.pink);
        }
    }
    
}
