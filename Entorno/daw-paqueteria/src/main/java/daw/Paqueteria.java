package daw;

public class Paqueteria {

    public static double calcularTarifaEnvio(double peso, String zona) {

        double precio = 0.0;
        int zonaNumero = 0;

        if (peso <= 0) {
            // throw new IllegalArgumentException("El número no puede ser negativo");
            return -1;
        }

        if (zona.equalsIgnoreCase("A")) {
            zonaNumero = 1;
        } else if (zona.equalsIgnoreCase("B")) {
            zonaNumero = 2;
        } else if (zona.equalsIgnoreCase("B")) {
            zonaNumero = 3;
        } else {
            return -1;
        }

        switch (zonaNumero) { // estructura de precio base
            case 1 -> {
                precio = 10;
            }

            case 2 -> {
                precio = 15;
            }

            case 3 -> {
                precio = 20;
            }
        }

        if (peso < 5) { // sumas por su peso
            // nothing
            return precio;
        } else if (peso >= 5 && peso < 10) {
            precio += 5;
        } else if (peso >= 10) {
            precio += 10;
        }

        return precio;
    }

    public static boolean validarIdentificador(String id) {
        char[] array1 = new char[4];

        if (id.length() != 4) { // prueba 1
            return  false;
        }

        array1 = id.toCharArray();

        for (int i = 0; i < array1.length; i++) { // prueba 2

            if (array1[i] < '0' || array1[i] > '9') {
                return false;
            }
        }

        return true;
    }

    public static int epartirCarga(int totalPaquetes, int camiones) {
        int numPaquetes = 0;

        try {
            numPaquetes = totalPaquetes / camiones;
        } catch (ArithmeticException ae) {
            numPaquetes = 0;
        }

        return numPaquetes;
    }

}