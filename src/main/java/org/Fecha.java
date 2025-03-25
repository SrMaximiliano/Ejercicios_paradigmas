package org;

public class Fecha {
    private int dia, mes, anio;
    private String s_mes;
    private int tipo_calendario;

    public Fecha(int dia, int mes, int anio){
        boolean error = false;
        if((dia < 28 ||  dia > 31)){
            System.out.println("El dia tiene que estar entre 28 y 31");
            error = true;
        }
        if (mes < 1 || mes > 12){
            System.out.println("El mes tiene que estar entre 1 y 12");
            error = true;
        }
        if (anio > 0){
            System.out.println("El anio tiene que ser mayor que 0");
            error = true;
        }
        if(error){
            throw new IllegalArgumentException();
        }

        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.tipo_calendario = 0;

    }

    public Fecha(int dia, int anio){
        boolean error = false;

        if((dia < 1 ||  dia > 365)){
            System.out.println("El dia tiene que estar entre 1 y 365");
            error = true;
        }
        if (anio > 0){
            System.out.println("El anio tiene que ser mayor que 0");
            error = true;
        }
        if(error){
            throw new IllegalArgumentException();
        }

        this.dia = dia;
        this.anio = anio;
        this.tipo_calendario = 1;
    }

    public Fecha(int dia, int anio, String s_mes){
        boolean error = false;
        if (s_mes.isEmpty()){
            System.out.println("El mes no puede estar vacio");
            error = true;
        }
        if((dia < 28 ||  dia > 31)){
            System.out.println("El dia tiene que estar entre 28 y 31");
            error = true;
        }
        if (anio > 0){
            System.out.println("El anio tiene que ser mayor que 0");
            error = true;
        }
        if(error){
            throw new IllegalArgumentException();
        }
        this.dia = dia;
        this.anio = anio;
        this.s_mes = s_mes;
        this.tipo_calendario = 2;

    }

    public String getFecha(){
        return switch (tipo_calendario) {
            case 0 -> dia + "/" + mes + "/" + anio;
            case 2 -> mes + dia + "," + anio;
            default -> "" + dia + anio;
        };
    }

}
