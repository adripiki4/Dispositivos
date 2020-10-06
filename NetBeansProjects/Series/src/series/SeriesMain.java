/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series;

import model.access;
import model.listshow;
import model.show;

/**
 *
 * @author adriba
 */
public class SeriesMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        show sh = new show("Breaking Bad","Vicent Guilligan",5,"Drama",5);
        listshow ls = new listshow();
//        ls.setshow(sh);
        
////        sh=new show("JGame of thrones","David Benioff", 6, "1", 6);
//        ls.setshow(sh);
//        
//        access.saveLS(ls);
//        
//        System.out.println("saved series");

//REad  the file
        ls=access.loadLS();
//        Create a show
        show sh = new show();
//        obtain firts element of arraylist:
        sh=ls.getShow(0);
//      get the tittle
        System.out.print("Tittle: ");
        System.out.println(sh.getTitle());
        
//        obatin the second element:
        sh =ls.getShow(1);
//      get the title2
        System.out.print("Tittle: ");
        System.out.println(sh.getTitle());
        
        
        
        
    }
    
}
