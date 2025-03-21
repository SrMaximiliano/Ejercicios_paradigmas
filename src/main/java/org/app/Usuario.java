package org.app;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private final String nombre;
    private List<Chat> chats;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.chats = new ArrayList<Chat>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public List<Usuario> getMiembrosDeChat(Chat chat) {
        if (chats.contains(chat))
            return chat.getMiembros();

        System.out.println("Usted no es miembro del chat");
        return null;
    }

    public List<Mensaje> getMensajesDeChat(Chat chat) {
        if (chats.contains(chat))
            return chat.getMensajes();
        System.out.println("Usted no es miembro del chat");
        return null;
    }

    private void agregarChatAUsuario(Chat chat) {
        this.chats.add(chat);
    }

    public Chat nuevoChat(Usuario... otros_usuarios) {
        Chat nuevo_chat = new Chat(this, otros_usuarios);
        chats.add(nuevo_chat);
        for (Usuario usuario : otros_usuarios) {
            usuario.agregarChatAUsuario(nuevo_chat);
        }
        return nuevo_chat;
    }

    public void agrerUsuarioAChat(Chat chat, Usuario nuevo_usuario) {
        if (chats.contains(chat)){
            chat.addMiembro(nuevo_usuario);
            nuevo_usuario.agregarChatAUsuario(chat);
        }else
            System.out.println("Usted no es miembro del chat");
    }

    public void mensajear(Chat chat, String mensaje) {
        if (chats.contains(chat))
            chat.addMensaje(this, mensaje);
        else
            System.out.println("Usted no es miembro del chat");
    }


}
