/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joptionapp;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author adriba
 */
public class Frame extends JFrame {

    private JButton btninfo, btnadv, btnerror, btnconfir, btntxt, btncombo, btnmas;
    private JPanel panel;

    public Frame() {
        setTitle("Montones de JOptionPane");
        setSize(600, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        btninfo = new JButton("Info");
        btnadv = new JButton("Advertencia");
        btnerror = new JButton("Error");
        btnconfir = new JButton("confirmacion");
        btntxt = new JButton("Texto");
        btncombo = new JButton("Combo");
        btnmas = new JButton("Mas");
        panel.add(btninfo);
        panel.add(btnadv);
        panel.add(btnerror);
        panel.add(btnconfir);
        panel.add(btntxt);
        panel.add(btncombo);
        panel.add(btnmas);

        btninfo.addActionListener(new infoListener());
        btnadv.addActionListener(new advListener());
        btnerror.addActionListener(new errorListener());
        btnconfir.addActionListener(new confirListener());

        add(panel);

    }

    public class infoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Este es un mensaje Simple tipo informacion");
            JOptionPane.showMessageDialog(null, "Otro mensaje Simple tipo Infromacion pero con titulo", "INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public class advListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Este es un mensaje de Advertencia", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);

        }

    }

    public class errorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Este es un mensaje de Error", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);

        }

    }

    public class confirListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            JOptionPane.showMessageDialog(null, "Este es un mensaje de confirmacion o pregunta", "QUESTION_MESSAGE", JOptionPane.QUESTION_MESSAGE);

        }

    }

}
