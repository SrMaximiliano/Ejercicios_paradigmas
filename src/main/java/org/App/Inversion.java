package org.App;
import java.util.Date;
import java.time.Duration;
import java.util.Calendar;


public class Inversion {
    private final Date finalizacion;
    private  final int plata;
    private final int interes;

    public Inversion(double meses, int plata, int interes) {
        this.plata = plata;
        this.interes = interes;

        Date fecha_hoy = new Date();
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha_hoy);
        calendario.add(Calendar.MONTH, (int) meses);
        finalizacion = calendario.getTime();

    }

    public String mostrar_inversion(){
        Date fecha_actual = new Date();
        Duration tiempo_faltante= Duration.between(this.finalizacion.toInstant(), fecha_actual.toInstant());

        int plata_con_interes =  this.plata + this.plata * (this.interes/12);
        return "La inversion de $" + plata + " se volvio $" + plata_con_interes + " y le quedan " + -1*tiempo_faltante.toDays() + " dias";
    }

    public boolean terminada(){
        Date fecha_actual = new Date();
        return (finalizacion.getTime() - fecha_actual.getTime()) < 0;
    }

    public int getDineroConInteres(){
        return this.plata + this.plata * (this.interes/12);
    }

}
