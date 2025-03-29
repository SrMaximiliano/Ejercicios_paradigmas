package org.app;

public class Alumno extends Persona {
    int padron;

     Alumno (String nombre, int dni, int nuevo_padron) {
         super(nombre, dni);
         padron = nuevo_padron;
     }
}
