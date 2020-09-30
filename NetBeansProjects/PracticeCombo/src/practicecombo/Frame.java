/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicecombo;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author adriba
 */
public class Frame extends JFrame {
    private JComboBox combo;
    private JLabel label;
    private JPanel panel;
    private String[] images = {"Rabbit", "Cat","Dog","Bird", "Pig"};
    private Icon img;
    
    
    public Frame(){
        setSize(500,300);
        setTitle("Combos and images");
        panel =new JPanel();
        panel.setLayout(new BorderLayout());
        
        add(panel);
        combo = new JComboBox(images);
        panel.add(combo,BorderLayout.NORTH);
        
        img = new ImageIcon(getClass().getResource("images/Rabbit.gif"));
        label = new JLabel();
        label.setText("Rabbit");
        label.setIcon(img);
        panel.add(label, BorderLayout.CENTER);
        
        combo.addItemListener(new ListenerCombito());
        
    }

   private class ListenerCombito implements ItemListener{
        public void itemStateChanged( ItemEvent e){
            int indice = combo.getSelectedIndex();
            String s = images[indice];
            img = new ImageIcon(getClass().getResource("images/"+ s +".gif"));
            label.setIcon(img);
            label.setText(s);
            
        }
    }
   
        
    
    
    
}
