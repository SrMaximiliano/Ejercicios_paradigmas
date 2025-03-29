package org;

import org.app.Alumno;
import org.app.Profesor;
import org.app.Fiuba;

public class Main {
    public static void main(String[] args) {
        Fiuba fiuba = new Fiuba();
        Alumno Maxi = fiuba.addAlumno("Maxi", 45812429);
        Profesor sr_Maxi = fiuba.addProfesor("Maxi", 45812429);

        Alumno maxito = fiuba.addAlumno(Maxi);
        Alumno maxito_jr = fiuba.addAlumno("maxito", 7878);
    }
}
