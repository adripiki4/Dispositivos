/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudio3;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author adrip
 */
public class Frame extends JFrame {

    JTextField textField1, textField2,textField3;
    JLabel label1, label2, label3,labelresult;
    JPanel panel = new JPanel();
    JButton boton;

    public Frame(){
        setTitle ("Gastos");
        setSize (500,500);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(4,2));
        label1 = new JLabel("Luz");
        label2 = new JLabel("Agua");
        label3 = new JLabel("Gas");
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        textField3 = new JTextField(10);
        textField1.setBorder (BorderFactory.createLineBorder (Color.red));
        textField2.setBorder (BorderFactory.createLineBorder (Color.red));
        textField3.setBorder (BorderFactory.createLineBorder (Color.red));
        labelresult = new JLabel();
        
        boton = new JButton("Calcular");
        boton.addActionListener(new botonListener());
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(boton);
        panel.add(labelresult);
        add(panel);
        
        
    }
    
    private class botonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
//            int luz = Integer.parseInt(textField1.getText());
//            int agua = Integer.parseInt(textField2.getText());
//            int gas = Integer.parseInt(textField3.getText());
//            int result = luz + agua + gas;
//            labelresult.setText(String.valueOf(result));
            
            int luz, agua, gas;
            if (textField1.getText().equals("")) {
                luz = 0;
            } else {
                luz = Integer.parseInt(textField1.getText());

            }

            if (textField2.getText().equals("")) {
                agua = 0;
            } else {
                agua = Integer.parseInt(textField2.getText());

            }

            if (textField3.getText().equals("")) {
                gas = 0;
            } else {
                gas = Integer.parseInt(textField3.getText());

            }
            int result = luz + agua + gas;
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            labelresult.setText(String.valueOf(result));

        }
        
    }
}
