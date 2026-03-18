package herencias.tarea6c;

public final class Triangulo extends Poligono implements Comparable<Triangulo> {
    public Triangulo(String id, String color, int base, int altura) {
        super(id, color, base, altura, 3);
    }

    @Override
    public double area() {
        return (double) getBase() * getAltura() / 2;
    }

    @Override
    public int compareTo(Triangulo t) {
        return Integer.compare(this.getBase(), t.getBase());
    }

    @Override
    public String toString() {
        return "Triangulo [" + super.toString() + "]";
    }
}
