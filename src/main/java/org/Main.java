package org;

import org.App.Usuario;
import org.App.Banco;
import org.App.Inversion;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Banco galicia = new Banco(10, "Galicia");
        Usuario Maxi = galicia.crearUsuario();
        if (galicia.esUsuario(Maxi)){
            System.out.println("El usuario se creo exitosamente");
        }

        Maxi.agregarDinero(1500);
        Maxi.agregarInversion(1500, 0);
        System.out.println("Usted ahora tiene $" + Maxi.getDinero());

        galicia.setInteres(999999);
        Maxi.agregarInversion(1500, 2);

        List<Inversion> inversion = Maxi.getInversiones();
        for (Inversion i : inversion) {
            System.out.println(i.mostrar_inversion());
        }

        Maxi.terminarInversiones();
        Usuario Pablo = galicia.crearUsuario();
        Maxi.transferir(Pablo, 1500);
        System.out.println("Usted ahora tiene $" + Pablo.getDinero());
        System.out.println("Usted ahora tiene $" + Maxi.getDinero());
    }
}
