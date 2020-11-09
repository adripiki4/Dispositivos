/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author adriba
 */
public class Dialogomodal extends JDialog {

    private JTextField textfield;

    public Dialogomodal(JFrame padre) {
        //el constructor recibe la ventana que le ha llamado osea, su padre

        super(padre, true);
        //invoco el constructor del la clase
        // padre, quien es su padre
        // despues true para modal y false para no modal

        setTitle("Mete un dato");
        textfield = new JTextField(20);
        add(textfield);

        //Se oculta la ventana al pulsar <enter> sobre el textfield
        textfield.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
            }
        });
    }

    public String getText() {
        return textfield.getText();
    }
}
