/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiobutton;
 import java.awt.FlowLayout;
 import java.awt.Font;
 import java.awt.event.ItemListener;
 import java.awt.event.ItemEvent;
 import javax.swing.JFrame;
 import javax.swing.JTextField;
 import javax.swing.JRadioButton;
 import javax.swing.ButtonGroup;
/**
 *
 * @author adriba
 */
public class RButton extends JFrame {
    private JTextField fieldText; // se utiliza para mostrar los cambios en el tipo de letra
    private Font letterTypeSimple; // tipo de letra para texto simple
    private Font letterTypeBold; // tipo de letra para texto en bold
    private Font letterTypeItalic; // tipo de letra para texto en italic
    private Font letterTypeBoldItalic; // tipo de letra para texto en bold y italic
    private JRadioButton simpleJRadioButton; // selecciona texto simple
    private JRadioButton boldJRadioButton; // selecciona texto en bold
    private JRadioButton italicJRadioButton; // selecciona texto en italic
    private JRadioButton boldItalicJRadioButton; // bold y italic
    private ButtonGroup optionsGroup; // grupo de botones que contiene los botones de opción
    
    public RButton (){
        setTitle( "Proving RadioButton" );
        setLayout( new FlowLayout() ); // establece el esquema del marco
        setSize(300,200);
        

        fieldText = new JTextField( "Observe changes in font type", 28);
        add( fieldText ); // agrega fieldText a JFrame
        
        // crea los botones de opción
        simpleJRadioButton = new JRadioButton( "Simple", true );
        boldJRadioButton = new JRadioButton( "Bold", false );
        italicJRadioButton = new JRadioButton( "Italic", false );
        boldItalicJRadioButton = new JRadioButton( "Bold/Italic", false );
        add( simpleJRadioButton ); // agrega botón simple a JFrame
        add( boldJRadioButton ); // agrega botón bold a JFrame
        add( italicJRadioButton ); // agrega botón italic a JFrame
        add( boldItalicJRadioButton ); // agrega botón bold y italic
    
        // crea una relación lógica entre los objetos JRadioButton
        optionsGroup = new ButtonGroup(); // crea ButtonGroup
        optionsGroup.add( simpleJRadioButton ); // agrega simple al grupo
        optionsGroup.add( boldJRadioButton ); // agrega bold al grupo
        optionsGroup.add( italicJRadioButton ); // agrega italic al grupo
        optionsGroup.add( boldItalicJRadioButton ); // agrega bold y italic
        
        // crea objetos tipo de letra
        letterTypeSimple = new Font( "Serif", Font.PLAIN, 14 );
        letterTypeBold = new Font( "Serif", Font.BOLD, 14 );
        letterTypeItalic = new Font( "Serif", Font.ITALIC, 14 );
        letterTypeBoldItalic = new Font( "Serif", Font.BOLD + Font.ITALIC, 14 );
        fieldText.setFont( letterTypeSimple ); // establece tipo letra inicial a simple
        
        // registra eventos para los objetos JRadioButton
        simpleJRadioButton.addItemListener( new ManejadorBotonOpcion( letterTypeSimple ) );
        boldJRadioButton.addItemListener( new ManejadorBotonOpcion( letterTypeBold ) );
        italicJRadioButton.addItemListener(
        new ManejadorBotonOpcion( letterTypeItalic ) );
        boldItalicJRadioButton.addItemListener(
        new ManejadorBotonOpcion( letterTypeBoldItalic ) );
        
        
    }
    
    // clase para  eventos de botones de opción
    private class ManejadorBotonOpcion implements ItemListener
    {
    private Font letterType; // tipo de letra asociado con este componente de escucha

    public ManejadorBotonOpcion( Font f )
    {
   letterType = f; // establece el tipo de letra de este componente de escucha
    } // fin del constructor ManejadorBotonOpcion

    // maneja los eventos de botones de opción
    public void itemStateChanged( ItemEvent evento )
    {
    fieldText.setFont( letterType ); // establece el tipo de letra de fieldText
    }
}
}
