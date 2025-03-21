package org.example;
import org.example.clases.Usuario;
import org.example.clases.Mensaje;
import org.example.clases.Chat;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Usuario maxi = new Usuario("Maxi");
        Usuario tomas = new Usuario("Tomas");
        Usuario juan = new Usuario("Juan");

        Chat los_pibes = maxi.nuevoChat(tomas);
        juan.mensajear(los_pibes, "Me invitaron?");
        maxi.agrerUsuarioAChat(los_pibes, juan);
        juan.mensajear(los_pibes, "Ahora si estoy dentro");
        tomas.mensajear(los_pibes, "Por finnnn");
        maxi.mensajear(los_pibes, "Sorry, me costo invitarte al grupo");

        List<Mensaje> historial = maxi.getMensajesDeChat(los_pibes);
        for (Mensaje m : historial) {
            System.out.print(m.leerMensaje());
        }
    }
}
