package herencias.tarea6c;

public abstract class Poligono extends Figura {
    private int base;
    private int altura;
    private int numeroLados;

    public Poligono(String id, String color, int base, int altura, int numeroLados) {
        super(id, color);
        this.base = base;
        this.altura = altura;
        this.numeroLados = numeroLados;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getNumeroLados() {
        return numeroLados;
    }

    public void setNumeroLados(int n) {
        this.numeroLados = n;
    }

    @Override
    public String toString() {
        return super.toString() + ", base=" + base + ", altura=" + altura + ", lados=" + numeroLados;
    }
}
