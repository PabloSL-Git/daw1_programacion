package ejerciciosUT6.Ej2;

public class Main {

    public static void main(String[] args) {

        Vehiculo v1 = new Vehiculo("123AAA", "B1", Color.ROJO);
        System.out.println(v1);
        v1.metodoVehiculo();

        System.out.println("----------------");

        Camion c1 = new Camion("222BBB", "B2", Color.AZUL, 1500);
        System.out.println(c1);
        c1.metodoVehiculo(); // heredado
        c1.metodoCamion(); // propio

        System.out.println("----------------");

        Turismo t1 = new Turismo("333CCC", "B3", Color.VERDE, 5);
        System.out.println(t1);
        t1.metodoTurismo();

        System.out.println("----------------");

        Deportivo d1 = new Deportivo("444DDD", "B4", Color.AMARILLO, 300);
        System.out.println(d1);
        d1.metodoDeportivo();

        System.out.println("----------------");

        Furgoneta f1 = new Furgoneta("555EEE", "B5", Color.ROJO, 800);
        System.out.println(f1);
        f1.metodoFurgoneta();

        System.out.println("----------------");

        // Polimorfismo
        Vehiculo v2 = new Camion("666FFF", "B6", Color.AZUL, 2000);
        System.out.println(v2);

        // Esto dara error:
        // v2.metodoCamion();
    }
}
