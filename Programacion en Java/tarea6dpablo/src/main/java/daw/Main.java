package daw;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = VehicleCSVReader.leerVehiculo("vehiculos.csv");

        // Llamadas a StreamsJava

        List<Vehiculo> first5 = StreamsJava.firstFive(vehiculos);

        System.out.println("Obtener los primeros 5 vehículos de la lista original.");
        System.out.println("---------------------------------------------------");

        System.out.println(first5);

        System.out.println("---------------------------------------------------");
        System.out.println("Obtener todos los vehículos del año 2012 e imprimir por consola.");
        System.out.println("---------------------------------------------------");

        StreamsJava.vehicles2012(vehiculos);

        System.out.println("---------------------------------------------------");
        System.out.println("Obtener un conjunto de todos los nombres de marcas distintas.");
        System.out.println("---------------------------------------------------");

        System.out.println(StreamsJava.uniqueBrands(vehiculos));

        System.out.println("---------------------------------------------------");
        System.out.println(
                "Obtener en un lista todos los vehículos ordenados por su año de fabricación, de menor a mayor.");
        System.out.println("---------------------------------------------------");

        System.out.println(StreamsJava.sortedByYear(vehiculos));

        System.out.println("---------------------------------------------------");
        System.out.println(
                "A partir de la lista original, saltando los primeros 10 vehículos, guardar en otra lista los siguientes 5.");
        System.out.println("---------------------------------------------------");

        System.out.println(StreamsJava.skipAndTake(vehiculos));

        System.out.println("---------------------------------------------------");
        System.out.println("Verificar si existe algún vehículo de color Green.");
        System.out.println("---------------------------------------------------");

        System.out.println(StreamsJava.anyGreen(vehiculos));

        System.out.println("---------------------------------------------------");
        System.out.println("Verificar si todos los vehículos son del año 1990 o superior.");
        System.out.println("---------------------------------------------------");

        System.out.println(StreamsJava.allAfter1990(vehiculos));

        System.out.println("---------------------------------------------------");
        System.out.println("Contar cuántos vehículos son marca Ford.");
        System.out.println("---------------------------------------------------");

        System.out.println(StreamsJava.countFord(vehiculos));

        System.out.println("---------------------------------------------------");
        System.out.println("Obtener el año más pequeño de toda la lista.");
        System.out.println("---------------------------------------------------");

        System.out.println(StreamsJava.minYear(vehiculos));

        System.out.println("---------------------------------------------------");
        System.out.println("Obtener un conjunto (Set) de colores únicos de vehículos fabricados después del 2010.");
        System.out.println("---------------------------------------------------");

        System.out.println(StreamsJava.colorsAfter2010(vehiculos));

        System.out.println("---------------------------------------------------");
        System.out.println(
                "Obtener un map, por cada color de vehículo asocie cuantos objetos hay de ese color. Usa groupingBy.");
        System.out.println("---------------------------------------------------");

        System.out.println(StreamsJava.countByColor(vehiculos));

        System.out.println("---------------------------------------------------");
        System.out.println(
                "Dado que hay matrículas repetidas (vehicle_license_plate),  obtén un mapa donde para cada placa (licensePlate) se asocie la lista de vehículos con esa placa. Usa groupingBy");
        System.out.println("---------------------------------------------------");

        System.out.println(StreamsJava.groupByPlate(vehiculos));
    }
}