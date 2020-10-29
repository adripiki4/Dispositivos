/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adriba
 */
public class All {
    public List<client> findAll() throws SQLException {
        List<client> listClients = new ArrayList();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
                    
        try {
            String urlOdbc = "jdbc:mysql://localhost:3307/di.?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            con = (java.sql.DriverManager.getConnection(urlOdbc, "root", "piqui4"));
            st = con.createStatement();
            rs = st.executeQuery("Select * from clients");
            client cli = null;
            while (rs.next()) {
                cli = new client();
                cli.setId(rs.getString("id"));
                cli.setNotes(rs.getString("notes"));
                listClients.add(cli);
            }
            rs.close();
            st.close();
            con.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        } 
               return listClients;
           }
    
     
}
