/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

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
public class myfirtsFrame extends JFrame{
    private JPanel panel = new JPanel();
    public myfirtsFrame () {

setTitle ("Hello !!!"); // window title
setSize (300,200); // size
// to close the window when the close icon is clicked
setDefaultCloseOperation (EXIT_ON_CLOSE);
// I create an object of type JPanel
// I add the panel to the frame
add (panel);
// I put the background color of the panel red
panel.setBackground (Color.red);
// instantiate a button
JButton button = new JButton ("text goes here");
button.addActionListener(new button_listener());

// set the button dimensions
Dimension d = new Dimension ();
d.height = 60;
d.width = 200;
button.setPreferredSize (d);
// add the button to the panel
panel.add (button);
}

    class button_listener implements ActionListener {

        public void actionPerformed (ActionEvent e) {
            panel.setBackground(Color.blue);
        }
    }
}

