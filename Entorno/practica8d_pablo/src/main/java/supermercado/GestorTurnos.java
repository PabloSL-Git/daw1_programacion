package supermercado;

public class GestorTurnos {

    // atributos
    private static GestorTurnos instancia; // unica instancia
    private int turnoActual; // contador de turnos

    // constructor privado
    private GestorTurnos() {
        turnoActual = 0;
    }

    // getInstancia()
    public static GestorTurnos getInstancia() {
        if (instancia == null) {
            instancia = new GestorTurnos();
        }
        return instancia;
    }

    public int tomarTurno() {
        turnoActual++;
        return turnoActual;
    }

    public void mostrarTurnoActual() {
        System.out.println("Turno actual: " + turnoActual);
    }

    public void resetearContador() {
        turnoActual = 0;
    }
}
