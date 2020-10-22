package jlistexample;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class frame extends JFrame {
   
    private  JList list;
    private DefaultListModel listModel = new DefaultListModel();
    public frame() {
        setTitle(" JList Example");
        setSize(800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1,10,10));
        //añadir elementos al modelo de la list:
        for (int i=0; i<40;i++) {
            listModel.addElement("element" + i);
        }
        //crear lal list
        list=new JList(listModel);
        list.setVisibleRowCount( 20 );
        list.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        //añado la list al panel con una barra de desplazamiento
        panel.add( new JScrollPane(list) );
        //BOTON
        JButton b1=new JButton("Take out element from the list");
        panel.add(b1);
        add(panel);
        
        //Eliminará el elemto seleccionado de la list
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //toma el indice del elemnto seleccionado de la list
               int index = list.getSelectedIndex();
               if (index>=0){ //si hay algún elemto seleccionado:
                  //antes de borrarlo muestro un mensaje al usuario con el elemento a borrar
                  JOptionPane.showMessageDialog(null, 
                        "Se borrará el siguiente elemento de la list:   " + 
                        listModel.get(index));
                  //borro el elemento de la list
                  listModel.remove(index);
                }

            }
        });
        
    } 
}