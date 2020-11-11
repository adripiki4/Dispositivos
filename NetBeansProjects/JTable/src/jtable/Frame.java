/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtable;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adriba
 */
public class Frame extends JFrame {

    private String[] headers = new String[]{"Name", "Address", "Telephone", "Car?"};
    private Object[][] data = new Object[][]{
        {"Alfons González Pi", "Argentona, Barcelona", new Long(933333333), true},
        {"Ana María Cuesta Suñer", "Gijón, Asturias", new Long(984454545), false},
        {"Elena Veiguela Suárez", "Pontevedra", new Long(986678678), false},
        {"Pedro Aguado Rodríguez", "Madrid", new Long(912804574), true}
    };
    private JTable jTable1;
    private JScrollPane scrollpanel1;

    public Frame() {
        setSize(800,200);
        jTable1 = new JTable();
        jTable1.setModel(new DefaultTableModel(data, headers) {
            // Types of each column
            Class[] tipoColumn = {String.class,
                String.class,
                Long.class,
                Boolean.class};

            // override the getColumnClass method
            @Override
            public Class getColumnClass(int indColum) {
                return tipoColumn[indColum];
            }

        });
        
        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt){
                Object datocelda = jTable1.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn());
                System.out.println(datocelda);
            }
        });
        
        scrollpanel1 = new JScrollPane(jTable1);
        add(scrollpanel1,BorderLayout.CENTER);
        
    }
}
