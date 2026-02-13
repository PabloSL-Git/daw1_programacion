package ejerciciosUT6.Ej1;

public class Ventana {

    private boolean abierta;
    private Persiana persiana;
    private double tamaño; 

    public Ventana(Persiana persiana, double tamaño) {
        this.abierta = false;
        this.persiana = persiana;
        this.tamaño = tamaño;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public Persiana getPersiana() {
        return persiana;
    }

    public double getTamaño() {
        return tamaño;
    }
    
    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }

    public void setPersiana(Persiana persiana) {
        this.persiana = persiana;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public void abrir() {
        abierta = true;
    }

    public void cerrar() {
        abierta = false;
    }

}
