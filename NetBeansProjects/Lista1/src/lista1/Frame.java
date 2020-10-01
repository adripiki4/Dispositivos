/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista1;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author adrian
 */
public class Frame extends JFrame{
    private JList listJListColours;
    private final String namesColours[]= {"Black","Blue","Cyan","Dark grey","Green","Light grey", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};
    private final Color colores[]= {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY,Color.GREEN,Color.LIGHT_GRAY,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.RED,Color.WHITE,Color.YELLOW};
    
    private JPanel panel = new JPanel();
    
    public Frame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setTitle("Lista simple");
        add(panel);
        listJListColours = new JList(namesColours);
        listJListColours.setVisibleRowCount(5);
        listJListColours.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.setLayout(new FlowLayout());
        panel.add(new JScrollPane(listJListColours));
        listJListColours.addListSelectionListener(new ListListener());
        
        
    }
    
    private class ListListener implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            panel.setBackground(colores[listJListColours.getSelectedIndex()]);
        }
        
    }
    
    
    
}
