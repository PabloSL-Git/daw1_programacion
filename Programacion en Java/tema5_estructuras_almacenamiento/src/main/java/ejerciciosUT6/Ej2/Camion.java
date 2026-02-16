package ejerciciosUT6.Ej2;

// Indicamos que esta es una subclase de vehiculo
public class Camion extends Vehiculo{

    // Atributos propios de Camion
    private double pma; // peso máximo autorizado

    // Constructor de camion
    // Para construir un objeto hijo hay que
    // proporcionar los datos propios y de la 
    // clase padre

    public Camion(String matricula, String bastidor,
        Color color, double pma){

            // Crea el vehiculo con los datos proporcionados
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
        return "Camion [matricula=" + super.getMatricula()+"pma=" + pma + "]";
    }

    public void metodoCamion(){
        System.out.println("Ejecutando un método en la clase camión");
    }
    

}
