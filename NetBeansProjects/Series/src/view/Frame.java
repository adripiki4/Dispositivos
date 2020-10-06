/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.BorderLayout;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author adriba
 */
public class Frame extends JFrame {
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panle3 = new JPanel();
    private JButton b1,b2,b3,b4,b5,b6,b7;
    private JLabel e1,e2,e3,e4,e5,e6;
    private JTextField t1,t2,t3,t4,t5,t6;
    
    public Frame(){
        setSize(500,300);
        setTitle("My series");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel1.setLayout(new BorderLayout());
        
    }
    
}
