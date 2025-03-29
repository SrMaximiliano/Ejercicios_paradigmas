package org.app;

public class Profesor extends Persona {
    int legajo;

     Profesor(String nombre, int dni, int nuevo_legajo) {
         super(nombre, dni);
        legajo = nuevo_legajo;
     }

}
