package ejerciciosUT6.Ej12;

public class Main {

    public static void main(String[] args) {

        Persona p1 = new Persona("Juan", "Perez", "12345678A");

        Cuenta c1 = new CuentaCorriente(p1, -200);
        Cuenta c2 = new CuentaAhorro(p1, 0.03, 20);

        c1.actualizarSaldo(1500);
        c1.retirar(200);

        c2.actualizarSaldo(1000);
        c2.retirar(100);

        System.out.println(c1);
        System.out.println(c2);
    }
}
