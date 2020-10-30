/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author adrip
 */
public class Usuario {
    private int Id_usuario;
    private String Usuario;
    private String Password;
    
    public Usuario(){
    }

    //Poner el Id_usuario AI en la bd
    public Usuario(int Id_usuario) {
        this.Id_usuario = Id_usuario;
    }

    public Usuario(String Usuario, String Password) {
        this.Usuario = Usuario;
        this.Password = Password;
    }

    public Usuario(int Id_usuario, String Usuario, String Password) {
        this.Id_usuario = Id_usuario;
        this.Usuario = Usuario;
        this.Password = Password;
    }
    

    public int getId_usuario() {
        return Id_usuario;
    }

    public void setId_usuario(int Id_usuario) {
        this.Id_usuario = Id_usuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "Id_usuario=" + Id_usuario + ", Usuario=" + Usuario + ", Password=" + Password + '}';
    }
    
}
