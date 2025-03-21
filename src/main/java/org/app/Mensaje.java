package org.app;
import java.util.Date;

public class Mensaje {
    private Usuario mensajero;
    private String mensaje;
    private Date fecha;

    public Mensaje(Usuario mensajero, String mensaje) {
        this.mensajero = mensajero;
        this.mensaje = mensaje;
        this.fecha = new Date();
    }

    public Usuario getMensajero() {
        return mensajero;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public String leerMensaje() {
        return mensajero.getNombre() + ":" + mensaje + "\t[" + fecha + "]\n";
    }
}
