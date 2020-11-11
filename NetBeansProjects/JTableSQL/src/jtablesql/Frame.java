/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtablesql;

import com.sun.jdi.connect.spi.Connection;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adriba
 */
public class Frame extends JFrame {

    private Object[] tags = new Object[2];
    private DefaultTableModel model;
    private JTable jtable;
    private JPanel panel;

    public Frame() throws SQLException {
        setSize(800,400);
        tags[0] = "ID";
        tags[1] = "Notes";
        jtable = new JTable();
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        model = new DefaultTableModel();
        model.setColumnIdentifiers(tags);
        jtable.setModel(model);

        java.sql.Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String urlOdbc = "jdbc:mysql://localhost:3306/di.?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        con = (java.sql.DriverManager.getConnection(urlOdbc, "root", "piqui4"));
        st = con.createStatement();
        rs = st.executeQuery("Select * from clients");

        // We go through the result, while there are records to read
        // add each record to the DefaultDataModel
        int rowNumber = 0;
        while (rs.next()) {
            // The row for the table model is created and filled.
            Object[] rowData = new Object[model.getColumnCount()];
            rowData[0] = rs.getObject(1);
            rowData[1] = rs.getObject(2);
            model.addRow(rowData);
            rowNumber++;
        }
        rs.close();
        st.close();
        con.close();
        
        panel.add(new JScrollPane(jtable));
        
        add(panel);

    }

}
