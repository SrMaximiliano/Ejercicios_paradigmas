package org.app;

public interface PersonaFactory<T> {
    T create(String nombre, int dni, int nuevo_padron);
}
