/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.access;
import model.listshow;
import model.show;

/**
 *
 * @author adriba
 */
public class controller {
    private int position;
    private listshow ls;
    private access acc = new access();
    
    public controller(){
        position = 0;
        ls = new listshow();
        ls = acc.loadLS();
    }
    
    public show first(){
        position = 0;
        return ls.getShow(position);
    }
    
    public show previous(){
        if(position>0){
            position--;
        }
        return ls.getShow(position);
    }
    
    public show next(){
        position++;
        if(position==ls.longitud()){
            position--;
        }
        return ls.getShow(position);
    }
    
    public show last(){
        position = ls.longitud()-1;
        return ls.getShow(position);
    }
    
    public void nuevo(show s){
        ls.setshow(s);
        position = ls.longitud()-1;
        acc.saveLS(ls);
        
    }
    public void delete(){
        ls.delete(position);
        position--;
        acc.saveLS(ls);
    }
    
    public show getShow(){
        return ls.getShow(position);
    }
    
    public void actualiza(show s){
        ls.getShow(position).setTitle(s.getTitle());
        ls.getShow(position).setScriptwriter(s.getScriptwriter());
        ls.getShow(position).setSeasons(s.getSeasons());
        ls.getShow(position).setGenre(s.getGenre());
        ls.getShow(position).setViews(s.getViews());
        ls.getShow(position).setPlatforms(s.getPlatforms());
        acc.saveLS(ls);
    }
}
