/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenejer2;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

/**
 *
 * @author adriba
 */
public class Frame extends JFrame {

    private JPanel panelprin, panel1, panel2, panel3, panel4;
    private JButton mortadelo1, filemon1, carpanta1, rompetechos1, pepegotera1, otilio1;
    private JToggleButton mortadelo2, filemon2, carpanta2, rompetechos2, pepegotera2, otilio2;
    private JCheckBox chmorta, chfile, chcarpa, chrompe, chpepe, chotili;
    private JRadioButton rmorta, rfile, rcarpa, rrompe, rpepe, rotili;
    private TitledBorder titu1, titu2, titu3, titu4;
    private ButtonGroup grupo;

    public Frame() {
        setTitle("tutorial de Java, SWing");
        setSize(900, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.GRAY);
        

        panelprin = new JPanel();
        panelprin.setLayout(new GridLayout(4, 1));
        panelprin.setBorder(BorderFactory.createLineBorder(Color.RED));

        //Primer bloque
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 6));
        titu1 = BorderFactory.createTitledBorder("JButton");
        panel1.setBorder(titu1);
        mortadelo1 = new JButton("Mortadelo");
        filemon1 = new JButton("Filemon");
        carpanta1 = new JButton("Carpanta");
        rompetechos1 = new JButton("Rompetechos");
        pepegotera1 = new JButton("Pepe Gotera");
        otilio1 = new JButton("Otilio");
        panel1.add(mortadelo1);
        panel1.add(filemon1);
        panel1.add(carpanta1);
        panel1.add(rompetechos1);
        panel1.add(pepegotera1);
        panel1.add(otilio1);
        panelprin.add(panel1);

        //Bloque2
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 6));
        titu2 = BorderFactory.createTitledBorder("JToggleButton");
        panel2.setBorder(titu2);
        mortadelo2 = new JToggleButton("Mortadelo");
        filemon2 = new JToggleButton("Filemon");
        carpanta2 = new JToggleButton("Carpanta");
        rompetechos2 = new JToggleButton("Rompetechos");
        pepegotera2 = new JToggleButton("Pepe Gotera");
        otilio2 = new JToggleButton("Otilio");
        panel2.add(mortadelo2);
        panel2.add(filemon2);
        panel2.add(carpanta2);
        panel2.add(rompetechos2);
        panel2.add(pepegotera2);
        panel2.add(otilio2);
        panelprin.add(panel2);

        //Bloque3
        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1, 6));
        titu3 = BorderFactory.createTitledBorder("JCheckBox");
        panel3.setBorder(titu3);
        chmorta = new JCheckBox("Mortadelo");
        chfile = new JCheckBox("Filemon");
        chcarpa = new JCheckBox("Carpanta",true);
        chrompe = new JCheckBox("Rompetechos");
        chpepe = new JCheckBox("Pepe Gotera");
        chotili = new JCheckBox("Otilio");
        panel3.add(chmorta);
        panel3.add(chfile);
        panel3.add(chcarpa);
        panel3.add(chrompe);
        panel3.add(chpepe);
        panel3.add(chotili);
        panelprin.add(panel3);

        //Bloque4
        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1, 6));
        titu4 = BorderFactory.createTitledBorder("JRadioButton");
        panel4.setBorder(titu4);
        rmorta = new JRadioButton("Mortadelo");
        rfile = new JRadioButton("Filemon");
        rcarpa = new JRadioButton("Carpanta");
        rrompe = new JRadioButton("Rompetechos");
        rpepe = new JRadioButton("Pepe Gotera");
        rotili = new JRadioButton("Otilio",true);
        panel4.add(rmorta);
        panel4.add(rfile);
        panel4.add(rcarpa);
        panel4.add(rrompe);
        panel4.add(rpepe);
        panel4.add(rotili);
        grupo = new ButtonGroup();
        grupo.add(rmorta);
        grupo.add(rfile);
        grupo.add(rcarpa);
        grupo.add(rrompe);
        grupo.add(rpepe);
        grupo.add(rotili);
        panelprin.add(panel4);

        add(panelprin);
    }

}
