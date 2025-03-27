package org.App;
import java.util.ArrayList;
import java.util.List;
public class Banco {
    private List<Usuario> clientes;
    private int interes;
    private String nombre;

    public Banco(int interes, String nombre) {
        if (interes < 0){
            throw new IllegalArgumentException("El interes no puede ser negativo");
        }
        clientes = new ArrayList<Usuario>();
        this.nombre = nombre;
        this.interes = interes;
    }

    public Usuario crearUsuario() {
        Usuario usuario = new Usuario(this);
        clientes.add(usuario);
        return usuario;
    }

    public int getInteres(){
        return interes;
    }

    public String getNombre(){
        return nombre;
    }

    public boolean esUsuario(Usuario usuario){
        return clientes.contains(usuario);
    }

    public void setInteres(int interes){
        if (interes < 0){
            throw new IllegalArgumentException("El interes no puede ser negativo");
        }
        this.interes = interes;
    }

}
