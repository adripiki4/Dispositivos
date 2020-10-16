/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia3;

import java.util.Random;

/**
 *
 * @author adriba
 */
public class Password {
    private int longitud;
    private String contrasena;
    
    public Password(){
        this.longitud = 8;
        
    }
    
    public Password(int longitud){
        this.longitud = longitud;
        
    }
    
    public String genetaPassword(int longitud){
        String buena = "";
        int posicion;
        String[] creando = new String[longitud];
        String [] escoge = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
            "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"};
        Random random = new Random();
        
        posicion = random.nextInt(escoge.length);
        
        
        return buena;
    }
    
}
