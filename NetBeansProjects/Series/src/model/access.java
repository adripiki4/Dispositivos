/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.*;
/**
 *
 * @author adriba
 */
public class access {
    private static File f = new File("series.dat");
    
    public static void saveLS(listshow ls){
        try{
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ls);
            oos.close();
        }catch (IOException ex){
            System.out.println("Failed to open file");
        }
    }
    
    public static listshow loadLS(){
        listshow ls = new listshow();
        ObjectInputStream ois=null;
        try {
            FileInputStream fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            ls=(listshow) ois.readObject();
            ois.close();
        } catch (IOException io) {
            //System.out.println("Failed to open");
            io.printStackTrace();
        }finally{
            return ls;
        }
        }

}
