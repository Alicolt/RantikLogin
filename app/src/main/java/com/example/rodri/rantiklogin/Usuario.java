package com.example.rodri.rantiklogin;

public class Usuario {
    public String id;
    public String nombre;
    public String apellido;
    public String usuario;
    public String contraseña;

    public Usuario(String id, String nombre, String apellido, String usuario, String contraseña){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

}
