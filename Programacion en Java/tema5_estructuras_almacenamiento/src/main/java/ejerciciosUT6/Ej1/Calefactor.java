package ejerciciosUT6.Ej1;

public class Calefactor {

    // Atributo obligatorio
    private Integer temperatura;
    private boolean encendido;

    public Calefactor(Integer temperatura) {
        this.temperatura = temperatura;
        this.encendido = false;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public void encender() {
        encendido = true;
    }

    public void apagar() {
        encendido = false;
    }

    public void fijarTemperatura(Integer valor) {
        this.temperatura = valor;
    }

    @Override
    public String toString() {
        return "Calefactor [temperatura=" + temperatura + ", encendido=" + encendido + "]";
    }

}
