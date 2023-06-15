package com.example.attendancereport;

public class Usuario {
    int Id;
    String Identidad;
    String Nombre;
    String Usuario;
    String Password;

    public Usuario(){
    }

    public Usuario(String identidad, String nombre, String usuario, String password) {
        Identidad = identidad;
        Nombre = nombre;
        Usuario = usuario;
        Password = password;
    }

    public boolean isNull(){
        if(Identidad.equals("")&&Nombre.equals("")&&Usuario.equals("")&&Password.equals("")){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Id=" + Id +
                ", Identidad='" + Identidad + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Usuario='" + Usuario + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getIdentidad() {
        return Identidad;
    }

    public void setIdentidad(String identidad) {
        Identidad = identidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }





}
