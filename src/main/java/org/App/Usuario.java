package org.App;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

public class Usuario {
    private final Banco banco;
    private int dinero;
    private List<Inversion> inversiones;

    Usuario(Banco banco){
        this.banco = banco;
        this.inversiones = new ArrayList<>();
    }

    public int getDinero(){
        return this.dinero;
    }

    public void terminarInversiones(){
        Iterator<Inversion> iterator = inversiones.iterator();
        while(iterator.hasNext()){
            Inversion inversion = iterator.next();
            if (inversion.terminada()){
                this.dinero += inversion.getDineroConInteres();
                iterator.remove();
            }
        }
    }

    public List<Inversion> getInversiones(){
        return this.inversiones;
    }

    public boolean agregarInversion(int a_invertir, double meses){
        if (a_invertir > this.dinero){
            System.out.println("No puede invertir plata que no tiene");
            return false;
        }
        System.out.println("El interes actual es de " + this.banco.getInteres());
        int dinero_total = a_invertir + a_invertir * (this.banco.getInteres()/12);
        System.out.println("En " + meses + " meses sus $" + a_invertir+ " Se converitira en $" + dinero_total );

        System.out.println("Desea hacer la inversion ahora? Presione Y o y para continuar. Caso contrario, presione cualquier otra tecla para cancelar");
        Scanner teclado = new Scanner(System.in);
        String respuesta = teclado.nextLine();
        if (respuesta.equals("Y") || respuesta.equals("y")){
            Inversion nueva_inversion = new Inversion(meses, a_invertir, banco.getInteres());
            this.inversiones.add(nueva_inversion);
            this.dinero -= a_invertir;
            return true;
        }
        return false;
    }

    public void agregarDinero(int plata){
        this.dinero += plata;
    }

    public boolean transferir(Usuario usuario, int a_transferir){
        if (a_transferir > dinero){
            System.out.println("No puede transferir plata que no tiene");
            return false;
        }
        usuario.agregarDinero(a_transferir);
        this.dinero -= a_transferir;
        return true;
    }
}
