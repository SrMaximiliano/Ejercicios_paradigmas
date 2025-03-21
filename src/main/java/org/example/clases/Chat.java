package org.example.clases;
import java.util.ArrayList;
import java.util.List;

//Tiene varios metodos que solo pueden ser accedidos por otras clases dentro del mismo paquete porque, al los chats ser privados, queria que solo los usuarios pudiesen ver ciertos datos.
public class Chat {
    private Usuario creador;
    private List<Usuario> miembros;
    private List<Mensaje> mensajes;

    Chat(Usuario usuario_creador,  Usuario... otros_usuarios) {
        this.creador = usuario_creador;
        this.miembros = new ArrayList<>();
        this.miembros.add(usuario_creador);
        for (Usuario usuario : otros_usuarios) {
            if (!this.esMiembro(usuario)) {
                this.miembros.add(usuario);

            }
        }
        this.mensajes = new ArrayList<>();
    }

    public Usuario getCreador() {
        return creador;
    }

    public List<Usuario> getMiembros() {
        return miembros;
    }

    List<Mensaje> getMensajes() {
        return mensajes;
    }

    void addMiembro(Usuario nuevo_miembro){
        if (!miembros.contains(nuevo_miembro))
            this.miembros.add(nuevo_miembro);
        else
            System.out.println("El usuario ya esta agregado");
    }

    void addMensaje(Usuario mensajero, String mensaje){
        Mensaje nuevo_mensaje = new Mensaje(mensajero, mensaje);
        this.mensajes.add(nuevo_mensaje);
    }

    public boolean esMiembro(Usuario usuario){
        return miembros.contains(usuario);
    }
}
