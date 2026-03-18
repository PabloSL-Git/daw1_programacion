package herencias.tarea6c;

// Rectangulo tiene 4 puntos y es la clase con Point[]
public final class Rectangulo extends Poligono implements Movible, Dibujable {
    private Point[] vertices;

    public Rectangulo(String id, String color, int base, int altura) {
        super(id, color, base, altura, 4);

        vertices = new Point[] {
                new Point(0, 0),
                new Point(base, 0),
                new Point(base, altura),
                new Point(0, altura)
        };
    }

    @Override
    public double area() {
        return (double) getBase() * getAltura();
    }

    @Override
    public void dibujar() {
        for (int i = 0; i < getAltura(); i++) {
            for (int j = 0; j < getBase(); j++) {
                if (i == 0 || i == getAltura() - 1)
                    System.out.print("*");
                else
                    System.out.print(j == 0 || j == getBase() - 1 ? "*" : " ");
            }
            System.out.println();
        }
    }

    @Override
    public void moverIzq(int x) {
        for (Point p : vertices)
            p.setX(p.getX() - x);
    }

    @Override
    public void moverDer(int x) {
        for (Point p : vertices)
            p.setX(p.getX() + x);
    }

    @Override
    public void moverArr(int y) {
        for (Point p : vertices)
            p.setY(p.getY() + y);
    }

    @Override
    public void moverAba(int y) {
        for (Point p : vertices)
            p.setY(p.getY() - y);
    }

    public Point[] getVertices() {
        return vertices;
    }

    @Override
    public String toString() {
        return "Rectangulo [" + super.toString() + "]";
    }
}
