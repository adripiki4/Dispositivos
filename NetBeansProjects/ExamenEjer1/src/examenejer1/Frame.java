/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenejer1;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author adriba
 */
public class Frame  extends JFrame{
    private JLabel label1 ,label2;
    private TextField txt1, txt2;
    private JButton btnadd, btnadd2;
    private JList listanombres;
    private DefaultListModel listmodel;
    private JPanel panelprin, panel1, panel2, panel3;
    private JComboBox combo;
    
    public Frame(){
        setTitle("NAMES");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panelprin = new JPanel();
        panelprin.setLayout(new GridLayout(3,1));
        
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2,2));
        label1 = new JLabel("Name");
        label2 = new JLabel("Surnames");
        txt1 = new TextField(10);
        txt2 = new TextField(10);
        panel1.add(label1);
        panel1.add(txt1);
        panel1.add(label2);
        panel1.add(txt2);
        panelprin.add(panel1);
        
        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        btnadd = new JButton("Introduce your name");
        panel2.add(btnadd);
        panelprin.add(panel2);
        
        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1,3));
        listanombres = new JList();
        btnadd2 = new JButton("ADD");
        combo = new JComboBox();
        panel3.add(listanombres);
        panel3.add(btnadd2);
        panel3.add(combo);
         panelprin.add(panel3);
        
        add(panelprin);
    }
    
}
