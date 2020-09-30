/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package check_radio;
import java.awt.FlowLayout;
 import java.awt.Font;
 import java.awt.event.ItemListener;
 import java.awt.event.ItemEvent;
 import javax.swing.JFrame;
 import javax.swing.JTextField;
 import javax.swing.JRadioButton;
 import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author adriba
 */
public class RadioCheck extends JFrame {
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup grupo;
    private JCheckBox sons;
    private JCheckBox daughters;
    private JPanel panel = new JPanel();
    private JLabel escribehijos;
    private JLabel escribegenero;
    
    public RadioCheck(){
        setTitle("Cuestionary");
        setSize(500,200);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        
        male = new JRadioButton("Male",false);
        female = new JRadioButton("Female", false);
        grupo = new ButtonGroup();
        sons = new JCheckBox("Sons");
        daughters = new JCheckBox("Daughters");
        grupo.add(male);
        grupo.add(female);
        escribehijos = new JLabel();
        escribegenero = new JLabel();
        
        
        panel.add(sons);
        panel.add(daughters);
        panel.add(male);
        panel.add(female);
        panel.add(escribehijos);
        panel.add(escribegenero);
        add(panel);
        
        ListenerCheckBox manejador = new ListenerCheckBox();
        sons.addItemListener(manejador);
        daughters.addItemListener(manejador);
        
        Opciongenero opcion = new Opciongenero();
        male.addItemListener(opcion);
        female.addItemListener(opcion);
        
        
    }
    
    private class ListenerCheckBox implements ItemListener{
                private String escribesons ="";
                private String escribeaughters ="";
                private String resultado="";
                
                public void itemStateChanged( ItemEvent event ){
                     if(event.getSource()== sons){
                         if(sons.isSelected()){
                             escribesons = "sons";
                             
                         }
                         else{
                             escribesons="";
                         }
                     } 
                     if(event.getSource()==daughters){
                         if(daughters.isSelected()){
                             escribeaughters = "daughers";
                             
                         }
                         else{
                             escribeaughters = "";
                         }
                     }
                     
                     if(escribesons.length()>0){
                         resultado = "You have sons";
                         if(escribeaughters.length()>0){
                             resultado = resultado + " and daughters";
                         }
                     }
                     else if (escribeaughters.length()>0){
                         resultado = "You have daughters";
                         
                     }else{
                         resultado = "None";
                     }
                     escribehijos.setText(resultado);
                     
                     
                } 
        }

    /**
     *
     */
    public class Opciongenero implements ItemListener{
         String gen ="";
        
        
        public void itemStateChanged(ItemEvent event) {
            if(male==event.getSource()){
                if(male.isSelected()){
                    gen = " Is male";
                }
            }
            else if(female == event.getSource()){
                if(female.isSelected()){
                    gen = " Is female";
                }
            }
            
            escribegenero.setText(gen);
            
            
        }
        
    }

    
    
}
