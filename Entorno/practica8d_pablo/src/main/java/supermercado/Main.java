package supermercado;

public class Main {
    public static void main(String[] args) {
        // 1. Obtener la instancia (dispensador de la entrada)
        GestorTurnos dispensador = GestorTurnos.getInstancia();

        // 2. Pedir dos turnos (deberían ser 1 y 2)
        int t1 = dispensador.tomarTurno();
        int t2 = dispensador.tomarTurno();
        System.out.println("Turnos dispensador: " + t1 + ", " + t2);

        // 3. Obtener la instancia de nuevo en otra variable (charcutería)
        GestorTurnos mostrador = GestorTurnos.getInstancia();

        // 4. Pedir dos turnos mas (deberían ser 3 y 4)
        int t3 = mostrador.tomarTurno();
        int t4 = mostrador.tomarTurno();
        System.out.println("Turnos mostrador: " + t3 + ", " + t4);

        // 5. Verificación final:
        if (dispensador == mostrador) {
            System.out.println("Dispensador y mostrador son la misma instancia");
        } else {
            System.out.println("Hay mas de una instancia.");
        }
    }

}