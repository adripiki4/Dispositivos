/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

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
 * @author adriba
 */
public class Calcu extends JFrame {
    
    JTextField textField1, textField2;
    JLabel label1 ;
    JLabel label2 ; 
    JPanel panel = new JPanel ();
    JButton boton ;
    
    public Calcu(){
        setTitle ("Converter");
        setSize (500,500);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        panel.setLayout (new GridLayout (3,2, 5,5));
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        textField1.setBorder (BorderFactory.createLineBorder (Color.red));
        textField2.setBorder (BorderFactory.createLineBorder (Color.red));
        label1 = new JLabel("Celsius Grades", JLabel.LEFT);
        label2 = new JLabel("Kelvin Grades", JLabel.LEFT);
        boton = new JButton("Clean"); 
        boton.addActionListener(new ButtonListener());
        textField1.addActionListener(new TextFieldListener1());
        textField2.addActionListener(new TextFieldListener2());
        
        
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(boton);
        add(panel);
        
        
    }
    
    class TextFieldListener1 implements ActionListener {
    public void actionPerformed (ActionEvent e) {
    double celsius = Double.parseDouble(textField1.getText());
    double kelvin;//= Double.parseDouble(textField2.getText());
    kelvin = celsius + 273.15;
    String kelvintext = Double.toString(kelvin);
    textField2.setText(kelvintext);

}
}
    
     class TextFieldListener2 implements ActionListener {
    public void actionPerformed (ActionEvent e) {
    double kelvin = Double.parseDouble(textField2.getText());
    double celsius;//= Double.parseDouble(textField2.getText());
    celsius = kelvin - 273.15;
    String celsiustext = Double.toString(celsius);
    textField1.setText(celsiustext);

}
}
    
    class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent e) {
    // clean the textfields.
    textField1.setText ("");
    textField1.requestFocus (); // Give focus to textfield1
    textField2.setText ("");
    }
    }   
    
}
