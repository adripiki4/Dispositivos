/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenejer3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author adriba
 */
public class Frame extends JFrame {

    private JPanel panelprin, panel1;
    private JRadioButton linux, windows, mac;
    private ButtonGroup grupo;
    private JButton boton;
    private Icon img;
    private JLabel label, labelmuestra;
    private String[] images = {"linux", "windows", "mac"};

    public Frame() {
        setTitle("Swing JRadioButton Demo");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panelprin = new JPanel();
        panelprin.setLayout(new GridLayout(3, 1));
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 3));
        linux = new JRadioButton("Linux", true);
        windows = new JRadioButton("Windows");
        mac = new JRadioButton("Macintosh");
        linux.addItemListener(new ListenerRadio());
        windows.addItemListener(new ListenerRadio());
        mac.addItemListener(new ListenerRadio());

        grupo = new ButtonGroup();
        grupo.add(linux);
        grupo.add(windows);
        grupo.add(mac);
        panel1.add(linux);
        panel1.add(windows);
        panel1.add(mac);
        panelprin.add(panel1);

        //img = new ImageIcon(getClass().getResource("images/linux.png"));
//        label = new JLabel();
//        label.setText("Linux");
//        panelprin.add(label);
        labelmuestra = new JLabel("Linux");
        panelprin.add(labelmuestra);

        boton = new JButton("OK");
        boton.addActionListener(new ButtonListener());
        panelprin.add(boton);

        add(panelprin);

    }

    public class ListenerRadio implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {
            String escribe = "";

            if (event.getSource() == linux) {
                escribe = "Linux";
            } else if (event.getSource() == windows) {
                escribe = "windows";
            } else if (event.getSource() == mac) {
                escribe = "Macintosh";
            }
            labelmuestra.setText(escribe);
        }

    }
    
    public class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,"You selected: "+ labelmuestra.getText());
        }
        
    }
}
