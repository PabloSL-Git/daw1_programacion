package ejerciciosUT6.Ej2;

public class Turismo extends Vehiculo {

    private int numeroPuertas;

    public Turismo(String matricula, String bastidor,
            Color color, int numeroPuertas) {

        super(matricula, bastidor, color);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public String toString() {
        return super.toString() + ", numeroPuertas=" + numeroPuertas;
    }

    public void metodoTurismo() {
        System.out.println("Método propio de Turismo");
    }
}
