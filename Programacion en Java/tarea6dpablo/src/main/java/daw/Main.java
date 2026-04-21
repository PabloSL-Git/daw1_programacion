package daw;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> vehiculos = VehicleCSVReader.leerVehiculo("vehiculos.csv");

        System.out.println("\nPrimeros 5 vehículos:");
        System.out.println(StreamsJava.firstFive(vehiculos));

        System.out.println("\nVehículos del año 2012:");
        StreamsJava.vehicles2012(vehiculos);

        System.out.println("\nMarcas únicas:");
        System.out.println(StreamsJava.uniqueBrands(vehiculos));

        System.out.println("\nVehículos ordenados por año:");
        System.out.println(StreamsJava.sortedByYear(vehiculos));

        System.out.println("\nSalto de 10 y toma de 5 vehículos:");
        System.out.println(StreamsJava.skipAndTake(vehiculos));

        System.out.println("\n¿Existe algún vehículo verde?");
        System.out.println(StreamsJava.anyGreen(vehiculos));

        System.out.println("\n¿Todos los vehículos son del año 1990 o superior?");
        System.out.println(StreamsJava.allAfter1990(vehiculos));

        System.out.println("\nCantidad de vehículos Ford:");
        System.out.println(StreamsJava.countFord(vehiculos));

        System.out.println("\nAño mínimo de fabricación:");
        System.out.println(StreamsJava.minYear(vehiculos));

        System.out.println("\nColores de vehículos posteriores a 2010:");
        System.out.println(StreamsJava.colorsAfter2010(vehiculos));

        System.out.println("\nCantidad de vehículos por color:");
        System.out.println(StreamsJava.countByColor(vehiculos));

        System.out.println("\nVehículos agrupados por matrícula:");
        System.out.println(StreamsJava.groupByPlate(vehiculos));
    }
}