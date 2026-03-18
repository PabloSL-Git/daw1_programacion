package herencias.tarea6c;

public class Circulo extends Figura implements Movible, Dibujable {
    private int longitudRadio;
    private Point centro; // centro en 0,0 al crearse

    public Circulo(String id, String color, int radio) {
        super(id, color);
        this.longitudRadio = radio;
        this.centro = new Point(0, 0);
    }

    @Override
    public double area() {
        return Math.PI * longitudRadio * longitudRadio;
    }

    @Override
    public void dibujar() {
        int tam = longitudRadio * 2;
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    @Override
    public void moverIzq(int x) {
        centro.setX(centro.getX() - x);
    }

    @Override
    public void moverDer(int x) {
        centro.setX(centro.getX() + x);
    }

    @Override
    public void moverArr(int y) {
        centro.setY(centro.getY() + y);
    }

    @Override
    public void moverAba(int y) {
        centro.setY(centro.getY() - y);
    }

    public int getLongitudRadio() {
        return longitudRadio;
    }

    public void setLongitudRadio(int r) {
        this.longitudRadio = r;
    }

    public Point getCentro() {
        return centro;
    }

    @Override
    public String toString() {
        return "Circulo [" + super.toString() + ", radio=" + longitudRadio + ", centro=" + centro + "]";
    }
}
