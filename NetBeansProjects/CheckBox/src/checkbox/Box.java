/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkbox;
import java.awt.FlowLayout;
 import java.awt.Font;
 import java.awt.event.ItemListener;
 import java.awt.event.ItemEvent;
 import javax.swing.JFrame;
 import javax.swing.JTextField;
 import javax.swing.JCheckBox;
/**
 *
 * @author adriba
 */
public class Box extends JFrame {
        private JTextField textField; // muestra el texto en tipos de letra cambiantes
        private JCheckBox boldJCheckBox; // para seleccionar/deseleccionar negrita
        private JCheckBox italicJCheckBox; // para seleccionar/deseleccionar cursiva
        
        public Box(){
            setTitle( "Proving JCheckBox" );
            setLayout( new FlowLayout() ); 
            setSize(500,100);

            // establece JTextField y su tipo de letra
            textField = new JTextField( "Observe changes in font style", 20 );
            textField.setFont( new Font( "Serif", Font.PLAIN, 14 ) );
            add( textField ); // agrega textField a JFrame
            
            boldJCheckBox = new JCheckBox( "Bold" ); // crea casilla de verificación "negrita"
            italicJCheckBox = new JCheckBox( "Italic" ); // crea casilla de verificación "cursiva"
            add( boldJCheckBox ); // agrega casilla de verificación "negrita" a JFrame
            add( italicJCheckBox ); // agrega casilla de verificación "cursiva" a JFrame
            
            // listener de  JCheckBox
            ListenerCheckBox manejador = new ListenerCheckBox();
            boldJCheckBox.addItemListener( manejador );
            italicJCheckBox.addItemListener( manejador );
        }
        
        // clase para el escuchador de los JCheckBox, en este caso no es un ActionListener como en los botones, es un ItemListener
        private class ListenerCheckBox implements ItemListener{
                private int valBold = Font.PLAIN; // controla el estilo de tipo de letra negrita
                private int valItalic = Font.PLAIN; // controla el estilo de tipo de letra cursiva
                
                 // cuando cambia el estado de un JCheckBox:
                public void itemStateChanged( ItemEvent event ){
                        // procesa los eventos de la casilla de verificación "negrita"
                         if ( event.getSource() == boldJCheckBox )
                            valBold = boldJCheckBox.isSelected() ? Font.BOLD : Font.PLAIN;

                        // procesa los eventos de la casilla de verificación "cursiva"
                        if ( event.getSource() == italicJCheckBox )
                            valItalic = italicJCheckBox.isSelected() ? Font.ITALIC : Font.PLAIN;

                        // establece el tipo de letra del campo de texto
                        textField.setFont( new Font( "Serif", valBold + valItalic, 14 ) );
                } 
        }
    
}
