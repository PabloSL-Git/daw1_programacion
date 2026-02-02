package matrices.tarea5c;

public class Temperaturas {
    private String localidad;
    private int año;
    private double[][] matrizTemperatura; // 12 meses x 31 días
    private final int[] diasMes = {31,28,31,30,31,30,31,31,30,31,30,31}; // dias por mes

    // Constructor
    public Temperaturas(String localidad, int año) {
        this.localidad = localidad;
        this.año = año;
        this.matrizTemperatura = new double[12][31];
        // Inicializar toda la matriz con -200.0
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 31; j++) {
                matrizTemperatura[i][j] = -200.0;
            }
        }
        // Ajuste para febrero si es bisiesto
        if (esBisiesto(año)) {
            diasMes[1] = 29;
        }
    }

    // metodo para comprobar si un año es bisiesto
    private boolean esBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }

    // guardar temperatura
    public void guardarTemperatura(int mes, int dia, double temp) {
        if (mes < 1 || mes > 12 || dia < 1 || dia > diasMes[mes - 1]) {
            System.out.println("Coordenadas invalidas.");
            return;
        }
        if (temp < -199.9 || temp > 199.9) {
            System.out.println("Temperatura fuera de rango.");
            return;
        }
        matrizTemperatura[mes - 1][dia - 1] = temp;
    }

    // borrar temperatura
    public void borrarTemperatura(int mes, int dia) {
        if (mes < 1 || mes > 12 || dia < 1 || dia > diasMes[mes - 1]) {
            System.out.println("Coordenadas inválidas.");
            return;
        }
        matrizTemperatura[mes - 1][dia - 1] = -200.0;
    }

    // Mostrar todas las temperaturas
    public void mostrarTemperaturas() {
        System.out.println("Localidad: " + localidad + " - Año: " + año);
        for (int i = 0; i < 12; i++) {
            System.out.print("Mes " + (i + 1) + ": ");
            for (int j = 0; j < diasMes[i]; j++) {
                System.out.print(matrizTemperatura[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Mostrar temperaturas de un mes
    public void mostrarTemperaturaMes(int mes) {
        if (mes < 1 || mes > 12) {
            System.out.println("Mes invalido.");
            return;
        }
        System.out.println("Temperaturas del mes " + mes + ":");
        for (int j = 0; j < diasMes[mes - 1]; j++) {
            System.out.println("Día " + (j + 1) + ": " + matrizTemperatura[mes - 1][j]);
        }
    }

    // Mostrar temperaturas de un dia en todos los meses
    public void mostrarTemperaturaDia(int dia) {
        if (dia < 1 || dia > 31) {
            System.out.println("Día inválido.");
            return;
        }
        System.out.println("Temperaturas del día " + dia + " en todos los meses:");
        for (int i = 0; i < 12; i++) {
            if (dia <= diasMes[i]) {
                System.out.println("Mes " + (i + 1) + ": " + matrizTemperatura[i][dia - 1]);
            } else {
                System.out.println("Mes " + (i + 1) + ": --");
            }
        }
    }
}