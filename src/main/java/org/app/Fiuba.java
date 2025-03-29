package org.app;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class Fiuba {
    List<Alumno> alumnos;
    List<Profesor> profesores;

    public Fiuba() {
        alumnos = new ArrayList<>();
        profesores = new ArrayList<>();
    }

    private <T> T addPersona(String nombre, int dni, String tipo_persona, List<T> lista_personas, PersonaFactory<T> factory) {
        for (T persona : lista_personas) {
            if (tipo_persona.equals("Alumno")) {
                Alumno alum_ac = (Alumno) persona;

                if (alum_ac.getDni() == dni) {
                    System.out.println("Ya hay un alumno con el DNI " + dni);
                    return null;
                }

            }else{
                Profesor prof_ac = (Profesor) persona;
                if (prof_ac.getDni() == dni) {
                    System.out.println("Ya hay un alumno con el DNI " + dni);
                    return null;
                }
            }
        }

        int padron_o_legajo;

        if (tipo_persona.equals("Profesor"))
            padron_o_legajo = profesores.size() +1;
        else
            padron_o_legajo = alumnos.size() +1;

        T nueva_persona = factory.create(nombre, dni, padron_o_legajo);
        lista_personas.add(nueva_persona);
        return nueva_persona;
    }

    public Alumno addAlumno(@NotNull Persona integrante) {
        return addPersona(integrante.getNombre(), integrante.getDni(), "Alumno", alumnos, Alumno::new);
    }

    public Alumno addAlumno(String nombre, int dni) {
        return addPersona(nombre, dni, "Alumno", alumnos, Alumno::new);
    }

    public Profesor addProfesor(@NotNull Persona integrante) {
        return addPersona(integrante.getNombre(), integrante.getDni(), "Profesor", profesores, Profesor::new);
    }

    public Profesor addProfesor(String nombre, int dni) {
        return addPersona(nombre, dni, "Profesor", profesores, Profesor::new);
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

}
