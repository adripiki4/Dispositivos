/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citiescombo;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author adrian
 */
public class Frame extends JFrame {
    private JComboBox combo;
    private JLabel label;
    private JPanel panel;
    private String [] cities = {"Madrid", "Vigo","Cadiz", "Badajoz"};
    
    public Frame(){
        setSize(500,300);
        setTitle("Traveling");
        panel = new JPanel();
        panel.setLayout( new BorderLayout());
        
        add(panel);
        combo = new JComboBox(cities);
        panel.add(combo,BorderLayout.NORTH);
        label = new JLabel();
        label.setText("Madrid");
        panel.add(label, BorderLayout.CENTER);
        
        combo.addItemListener(new ListenerCombo());
        
        
    }
    
    public class ListenerCombo implements ItemListener{
        
        public void itemStateChanged(ItemEvent e) {
            int indice = combo.getSelectedIndex();
            String escribe = cities[indice];
            label.setText(escribe);
        }
        
    }
    
    
}
