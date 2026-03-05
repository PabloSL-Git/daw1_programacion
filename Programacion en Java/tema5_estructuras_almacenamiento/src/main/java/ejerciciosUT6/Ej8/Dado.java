package ejerciciosUT6.Ej8;

public class Dado extends Azar {

    public Dado() {
        posibilidades = 6;
    }

    @Override
    public int lanzar() {
        return (int) (Math.random() * posibilidades) + 1;
    }
}