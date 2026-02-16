package ejerciciosUT6.Ej2;

public class Furgoneta extends Vehiculo {

    private double capacidadCarga;

    public Furgoneta(String matricula, String bastidor,
            Color color, double capacidadCarga) {

        super(matricula, bastidor, color);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String toString() {
        return super.toString() + ", capacidadCarga=" + capacidadCarga;
    }

    public void metodoFurgoneta() {
        System.out.println("Método propio de Furgoneta");
    }
}
