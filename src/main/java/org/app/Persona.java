package org.app;

public class Persona {
    private String nombre;
    private final int dni;

    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public boolean son_iguales(Persona persona) {
        return dni == persona.getDni();
    }
}
