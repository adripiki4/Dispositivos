/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createmenu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author adriba
 */
public class JMenuBar extends JFrame {

    private javax.swing.JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;

    public JMenuBar() {
        setSize(800,600);
        setTitle("Ventanas modales y no modales");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        menuBar = new javax.swing.JMenuBar();
        //La primera opcion del menu
        menu = new JMenu("Primer menu");
        menuBar.add(menu);
        // a la primera opcion del menu le ponemos dos item
        menuItem = new JMenuItem("Opcion 1");
        //añade listener a una opcion del menu
        menuItem.addActionListener(new em(this));
        menu.add(menuItem);
        menu.addSeparator(); //separador
        menuItem = new JMenuItem("Opcion 2");
        menu.add(menuItem);
        //Segunda opcion de la barra de menus sin ningun item
        menu = new JMenu("Segundo menu");
        menuBar.add(menu);
        
        add(menuBar);
    }

    //Listener fuera
    class em implements ActionListener {

        JFrame miFrame;

        public em(JFrame f) {
            miFrame = f;
        }

        public void actionPerformed(ActionEvent e) {
            Dialogomodal dialogomodal = new Dialogomodal(miFrame);
            dialogomodal.pack();
            //para darle tamaño automatico a la ventana
            dialogomodal.setVisible(true);
            //como es una ventana modal no volvera a esta linea
            //hasta que no sea cerrada la otra
            System.out.println(dialogomodal.getText());
        }
    }
}
