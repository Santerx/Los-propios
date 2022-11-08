package com.example.empty_activity.model;

public class usuario {
    String name, correo;

    public usuario(){}

    public usuario(String name, String correo) {
        this.name = name;
        this.correo = correo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
