package ejerciciosUT6.Ej11;

public abstract class Figura {

    protected double base;
    protected double altura;

    public Figura(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public abstract double calcularArea();
}
