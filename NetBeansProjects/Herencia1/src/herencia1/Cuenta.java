/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia1;

/**
 *
 * @author adriba
 */
public class Cuenta {
    private String titular;
    private double cantidad;
    
    public Cuenta(String titular, double cantidad){
        this.titular=titular;
        this.cantidad=cantidad;
    }
    
    public Cuenta(String titular){
        this.titular=titular;
        this.cantidad=0;
    }
    
    public String get_titular(){
        return titular;
    }
    
    public void set_titular(String titular){
        this.titular = titular;
    }
    
    public double get_cantidad(){
        return cantidad;
    }
    
    public void set_cantidad(double cantidad){
        this.cantidad=cantidad;
    }
    
    public String toString(){
        String res="";
        res = "Titular: "+titular +", Saldo: "+ cantidad;
        return res;
    }
    
    public void ingresar_cantidad(double ingresa){
        if(ingresa>0){
            this.cantidad = cantidad + ingresa;
        }else{
            System.out.println("Introduzca una cantidad positiva");
        }
    }
    
    public void retirar_dinero(double retira){
        if(retira<cantidad){
            this.cantidad = cantidad - retira;
        }else if(retira>cantidad){
            this.cantidad = 0;
        }
    }
}
