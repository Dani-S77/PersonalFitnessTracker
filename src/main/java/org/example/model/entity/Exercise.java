package org.example.model.entity;

public class Exercise {
    private String id;
    private String nombre;
    private String description;

    public Exercise(String id, String nombre, String description){
        this.id=id;
        this.nombre=nombre;
        this.description=description;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescription() {
        return description;
    }
}
