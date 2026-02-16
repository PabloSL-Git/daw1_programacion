package ejerciciosUT6.Ej2;

// Indicamos que esta es una subclase de Vehiculo
public class Camion extends Vehiculo {

    // Atributos propios de Camion
    private double pma; // peso máximo autorizado

    // Constructor de Camion
    public Camion(String matricula, String bastidor,
                  Color color, double pma) {

        // Llamada al constructor de la clase padre
        super(matricula, bastidor, color);
        this.pma = pma;
    }

    public double getPma() {
        return pma;
    }

    public void setPma(double pma) {
        this.pma = pma;
    }

    @Override
    public String toString() {
        return super.toString() + ", pma=" + pma;
    }

    public void metodoCamion() {
        System.out.println("Ejecutando un método en la clase Camión");
    }
}
