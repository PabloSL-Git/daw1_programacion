package tarea7a;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.Map;
import java.io.FileWriter;

public class Main {

    // main
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = leerVehiculos("vehiculos.csv");

        // Mostrar lista
        for (Vehiculo v : vehiculos) {
        System.out.println(v);
        }

        System.out.println("Total vehículos: " + vehiculos.size());

        Set<String> fabricantes = fabricantes(vehiculos);

        System.out.println("Fabricantes:");
        System.out.println(fabricantes);

        Set<String> fabricantesStreamSet = fabricantesStream(vehiculos);
        System.out.println("Fabricantes (Streams):");
        System.out.println(fabricantesStreamSet);

        Map<String, Integer> mapaColores = contarPorColor(vehiculos);
        System.out.println("Coches por color:");
        System.out.println(mapaColores);

        Map<String, Long> mapaColoresStream = contarPorColorStream(vehiculos);
        System.out.println("Coches por color (Streams):");
        System.out.println(mapaColoresStream);

        guardarMapCSV(mapaColores, "colores.csv");
    }

    // leer cvs
    public static List<Vehiculo> leerVehiculos(String ruta) {
        List<Vehiculo> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;

            // Saltar cabecera
            br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");

                Vehiculo v = new Vehiculo(
                        partes[0].trim(),
                        partes[1].trim(),
                        Integer.parseInt(partes[2].trim()),
                        partes[3].trim(),
                        partes[4].trim(),
                        partes[5].trim());

                lista.add(v);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // lista set

    public static Set<String> fabricantes(List<Vehiculo> lista) {
        Set<String> set = new HashSet<>();

        for (Vehiculo v : lista) {
            if (v.vehicle_color().equals("Pink") && v.vehicle_year() == 2007) {
                set.add(v.vehicle_make());
            }
        }

        return set;
    }

    // stream

    public static Set<String> fabricantesStream(List<Vehiculo> lista) {
        return lista.stream()
                .filter(v -> v.vehicle_color().equals("Pink") && v.vehicle_year() == 2007)
                .map(Vehiculo::vehicle_make)
                .collect(Collectors.toSet());
    }

    // contar coches por color

    public static Map<String, Integer> contarPorColor(List<Vehiculo> lista) {
        Map<String, Integer> map = new TreeMap<>();
        for (Vehiculo v : lista) {
            String color = v.vehicle_color();
            if (map.containsKey(color)) {
                map.put(color, map.get(color) + 1);
            } else {
                map.put(color, 1);
            }
        }
        return map;
    }

    // contar con stream y lambdas

    public static Map<String, Long> contarPorColorStream(List<Vehiculo> lista) {
        return lista.stream()
                .collect(Collectors.groupingBy(Vehiculo::vehicle_color, Collectors.counting()));
    }

    // guardar map en fichero

    public static void guardarMapCSV(Map<String, ? extends Number> map, String nombreArchivo) {
        try (FileWriter fw = new FileWriter(nombreArchivo)) {
            for (Map.Entry<String, ? extends Number> entry : map.entrySet()) {
                fw.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
            System.out.println("Archivo CSV creado: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}