package ejerciciosUT6.Ej1;

public class Casa {

    private Puerta puerta;
    private Ventana ventana;
    private Calefactor calefactor;
    private String nombre;

    public Casa(Puerta puerta, Ventana ventana, Calefactor calefactor, String nombre) {
        this.puerta = puerta;
        this.ventana = ventana;
        this.calefactor = calefactor;
        this.nombre = nombre;
    }

    public Puerta getPuerta() {
        return puerta;
    }

    public void setPuerta(Puerta puerta) {
        this.puerta = puerta;
    }

    public Ventana getVentana() {
        return ventana;
    }

    public void setVentana(Ventana ventana) {
        this.ventana = ventana;
    }

    public Calefactor getCalefactor() {
        return calefactor;
    }

    public void setCalefactor(Calefactor calefactor) {
        this.calefactor = calefactor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Casa [puerta=" + puerta + ", ventana=" + ventana + ", calefactor="
                + calefactor + ", nombre=" + nombre
                + "]";
    }

}
