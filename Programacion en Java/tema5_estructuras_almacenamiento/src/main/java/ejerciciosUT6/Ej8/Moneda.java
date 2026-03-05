package ejerciciosUT6.Ej8;

public class Moneda extends Azar {

    public Moneda() {
        posibilidades = 2;
    }

    @Override
    public int lanzar() {
        return (int) (Math.random() * posibilidades) + 1;
    }
}
