package ejerciciosUT6.Ej2;

public class Deportivo extends Vehiculo {

    private int caballos;

    public Deportivo(String matricula, String bastidor,
            Color color, int caballos) {

        super(matricula, bastidor, color);
        this.caballos = caballos;
    }

    public int getCaballos() {
        return caballos;
    }

    public void setCaballos(int caballos) {
        this.caballos = caballos;
    }

    @Override
    public String toString() {
        return super.toString() + ", caballos=" + caballos;
    }

    public void metodoDeportivo() {
        System.out.println("Método propio de Deportivo");
    }
}
