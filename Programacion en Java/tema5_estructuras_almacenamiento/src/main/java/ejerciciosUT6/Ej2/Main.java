package ejerciciosUT6.Ej2;

public class Main {

    public static void main(String[] args) {
            Vehiculo v1 = new Vehiculo("123DDD", "ddgfsdfs",Color.AMARILLO);
        v1.metodoVehiculo();
        System.out.println(v1);

        // Camion ES UN Vehiculo
        // Camion hereda los atributos y métodos públicos de vehiculo
        Camion c1 = new Camion("333EEE", "ww",Color.AZUL, 1200);
        System.out.println(c1);
    }    

}
