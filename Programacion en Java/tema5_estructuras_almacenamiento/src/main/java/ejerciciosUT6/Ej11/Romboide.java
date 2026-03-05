package ejerciciosUT6.Ej11;

public class Romboide extends Figura {

    public Romboide(double base, double altura) {
        super(base, altura);
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }
}
