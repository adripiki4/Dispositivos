/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlistexercise;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author adriba
 */
public class Frame  extends JFrame {
    private  JList list;
    private DefaultListModel listModel = new DefaultListModel();
    private JPanel panel1, panel2, panel3, panel4;
    
    public Frame(){
        setTitle("Selection and print");
        setSize(800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        
    }
    
    
    
}
