/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author adriba
 */
public class listshow  implements Serializable{
    private ArrayList<show> seriesList;
    
    public listshow(){
        seriesList = new ArrayList<>();
        
    }
    
    public show getShow(int p){
        return seriesList.get(p);
    }
    public void setshow(show s){
        seriesList.add(s);
    }
    public int longitud(){
        return seriesList.size();
    }
    
}
