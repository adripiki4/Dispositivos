/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuexercise;

import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * @author adriba
 */
public class Frame extends JFrame {

    private JMenuBar menuBar;
    private JMenu menu1, menu1_1, menu2;
    private JMenuItem menuitem1, menuitem2, menuitem3, menuitem4;
    private JCheckBoxMenuItem boxmenu;
    private JRadioButtonMenuItem radiomenu1;
    private JRadioButtonMenuItem radiomenu2;
    private ButtonGroup grupo;
    private ImageIcon img;

    public Frame() {
        setSize(800, 600);
        setTitle("MENU");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        menuBar = new JMenuBar();
//        img = new ImageIcon(getClass().getResource("image/casa.jpg"));
//        menu1 = new JMenu("Casa");
        menu1.setIcon(img);
        menu1_1 = new JMenu("Habitaciones");
        menuitem1 = new JMenuItem("Habitacion1");
        menuitem2 = new JMenuItem("Habitacion2");
        menu1_1.add(menuitem1);
        menu1_1.add(menuitem2);
        menu1.add(menu1_1);
        boxmenu = new JCheckBoxMenuItem("Salon");
        boxmenu.setSelected(true);
        menu1.add(boxmenu);
        menu1.addSeparator();
        radiomenu1 = new JRadioButtonMenuItem("Cocina");
        radiomenu1.setSelected(true);
        radiomenu2 = new JRadioButtonMenuItem("Baño");
        grupo = new ButtonGroup();
        grupo.add(radiomenu1);
        grupo.add(radiomenu2);
        menu1.add(radiomenu1);
        menu1.add(radiomenu2);

        menu2 = new JMenu("Extras");
        menuitem3 = new JMenuItem("Garaje");
        menuitem4 = new JMenuItem("Trastero");
        menu2.add(menuitem3);
        menu2.add(menuitem4);

        menuBar.add(menu1);
        menuBar.add(menu2);

        add(menuBar);

    }

}
