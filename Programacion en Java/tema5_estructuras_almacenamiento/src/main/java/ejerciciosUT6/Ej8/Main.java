package ejerciciosUT6.Ej8;

public class Main {
    public static void main(String[] args) {

        Dado dado = new Dado();
        Moneda moneda = new Moneda();

        System.out.println("Dado: " + dado.lanzar());
        System.out.println("Moneda: " + moneda.lanzar());
    }
}
