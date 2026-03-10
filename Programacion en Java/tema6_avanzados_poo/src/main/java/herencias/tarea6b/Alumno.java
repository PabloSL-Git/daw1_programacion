package herencias.tarea6b;

import java.time.LocalDate ;

public class Alumno extends Persona{

    private String numeroExpediente;
    private LocalDate fechaBaja;

    public Alumno(String nombre, String apellidos, String nif, String numeroExpediente, LocalDate fechaBaja) {
        super(nombre, apellidos, nif);
        this.numeroExpediente = numeroExpediente;
        this.fechaBaja = fechaBaja;
    }

    public Alumno(){

    }

    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    

}
