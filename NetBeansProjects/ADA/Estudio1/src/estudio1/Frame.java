/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudio1;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author adrip
 */
public class Frame extends JFrame {

    private JButton boton = new JButton("Seleccionar");
    private JComboBox combo;
    private String[] select = {"1ºDAM", "2ºDAM"};
    private JList asignaturas;
    private String mete;
    private DefaultListModel listmodel = new DefaultListModel();
    private JPanel panel = new JPanel();
    private String[] dam1 = {"Entornos", "Programacion", "Base de datos", "Lenguaje de marcas", "Sistemas"};
    private String[] dam2 = {"Desarrollo de interfaces", "Programacion multimedia", "Acceso a datos", "Sistemas de gestion"};

    public Frame() {
        setSize(500, 300);
        setTitle("DAM");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new BorderLayout());

        combo = new JComboBox(select);
        panel.add(combo, BorderLayout.NORTH);
        combo.addItemListener((ItemListener) new ListenerCombo());
        for (int i = 0; i < dam1.length; i++) {
            //mete = dam1[i];
            listmodel.addElement(dam1[i]);
        }
        asignaturas = new JList(listmodel);
        asignaturas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        panel.add(new JScrollPane(asignaturas));
        boton.addActionListener(new ButtonListener());
        panel.add(boton, BorderLayout.SOUTH);
        add(panel);

    }

    private class ListenerCombo implements ItemListener {

        public void itemStateChanged(ItemEvent e) {
            int indice = combo.getSelectedIndex();
            if (indice == 0) {
                listmodel.removeAllElements();
                for (int i = 0; i < dam1.length; i++) {
                    listmodel.addElement(dam1[i]);
                }
            } else if (indice == 1) {
                listmodel.removeAllElements();
                for (int i = 0; i < dam2.length; i++) {
                    listmodel.addElement(dam2[i]);
                }
            }

        }

    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int[] indices = asignaturas.getSelectedIndices();
            String salida = "Asignaturas seleccionadas: ";
            int indice = combo.getSelectedIndex();
            if (indice == 0) {
                for (int i = 0; i < indices.length; i++) {
                    salida = salida + dam1[indices[i]]+"\n";
                }
            } else if (indice == 1){
                for (int i = 0; i < indices.length; i++) {
                    salida = salida + dam2[indices[i]]+"\n";
                }
            }
            JOptionPane.showMessageDialog(null, salida);

        }

    }
}
