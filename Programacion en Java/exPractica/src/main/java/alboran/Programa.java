/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alboran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/**
 *
 * @author pablo
 */
public class Programa {

    public static void main(String[] args) {

        List<Vuelo> vuelos = new ArrayList<>();

        Vuelo vuelo1 = new Vuelo(3, "Madrid", "Barcelona", 60);
        Vuelo vuelo2 = new Vuelo(1, "Madrid", "Valencia", 46);
        Vuelo vuelo3 = new Vuelo(2, "Barcelona", "Valencia", 120);
        Vuelo vuelo4 = new Vuelo(0, "Valencia", "Madrid", 80);
        Vuelo vuelo5 = new Vuelo(1, "Barcelona", "Madrid", 75);

        // Añade los vuelos a la lista
        vuelos.add(vuelo1);
        vuelos.add(vuelo2);
        vuelos.add(vuelo3);
        vuelos.add(vuelo4);
        vuelos.add(vuelo5);

        // Imprime los vuelos sin pasajeros para verificar su creación
        System.out.println("Vuelos sin pasajeros, hay vuelos con id repetido:\n");
        for (Vuelo vuelo : vuelos) {
            System.out.println(vuelo);
        }
        System.out.println("------------------------------");

        // Creación de pasajeros
        Pasajero pasajero1 = new Pasajero(1, "12345678A", "Juan Pérez", "juanperez@correo.com");
        Pasajero pasajero2 = new Pasajero(2, "87654321B", "María López", "marialopez@correo.com");
        Pasajero pasajero3 = new Pasajero(3, "11111111C", "Carlos García", "carlosgarcia@correo.com");
        Pasajero pasajero4 = new Pasajero(4, "22222222D", "Ana Martínez", "anamartinez@correo.com");
        Pasajero pasajero5 = new Pasajero(1, "33333333E", "Luis Rodríguez", "luisrodriguez@correo.com");

        // Añade los pasajeros a todos los vuelos CON FOR EACH
        for (Vuelo vuelo : vuelos) {
            vuelo.addPasajero(pasajero1);
            vuelo.addPasajero(pasajero2);
            vuelo.addPasajero(pasajero3);
            vuelo.addPasajero(pasajero4);
            vuelo.addPasajero(pasajero5);
        }

    // Imprime los vuelos con pasajeros
          System.out.println("Lista de vuelos con id repetido pero con sin pasajeros duplicados:\n");
          vuelos.forEach(System.out::println);
          System.out.println("------------------------------");

          // Obtiene un conjunto de vuelos únicos a partir de la lista de vuelos
          HashSet<Vuelo> vuelosUnicos = vuelosUnicos(vuelos);
          System.out.println("Vuelos únicos, eliminando los que tengan código de vuelo repetido:\n");
          vuelosUnicos.forEach(System.out::println);
          System.out.println("------------------------------");

          // Obtiene el número de pasajeros por ciudad de destino
          Map<String, Integer> pasajerosPorDestino = pasajerosPorDestino(vuelos);
          System.out.println("\nNúmero de pasajeros por ciudad de destino:");
          for (Map.Entry<String, Integer> entry : pasajerosPorDestino.entrySet()) {
               System.out.println("Ciudad destino: " + entry.getKey() + ", Número de pasajeros: " + entry.getValue());
          }
          System.out.println("------------------------------");

          // Pasajeros por código de vuelo
          Map<Integer, Set<Pasajero>> pasajerosPorCodigoVuelo = pasajerosPorCodigoVuelo(vuelos);
          System.out.println("\nInformación de pasajeros por código de vuelo:");
          for (Map.Entry<Integer, Set<Pasajero>> registro : pasajerosPorCodigoVuelo.entrySet()) {
               System.out.println("\nCódigo de vuelo: " + registro.getKey() + ", Pasajeros:\n " + registro.getValue());
          }

          // Borrar vuelos con destino a Valencia
          borrarVuelosDestino(vuelos, "Valencia");
          System.out.println("\nVuelos después de borrar los que tienen destino a Valencia:\n");
          vuelos.forEach(System.out::println);
          System.out.println("------------------------------");

          // Ordenar vuelos por orden natural (código de vuelo)
          ordenarVuelos(vuelos);
          System.out.println("\nVuelos ordenados por código de vuelo:\n");
          vuelos.forEach(System.out::println);    
          System.out.println("------------------------------");

          // Buscar un vuelo por código de vuelo          
          int codigoVueloBuscado = 3;
          int indiceVuelo = buscarVueloPorCodigo(vuelos, codigoVueloBuscado);
          if (indiceVuelo >= 0) {
               System.out.println("\nVuelo encontrado con código de vuelo " + codigoVueloBuscado + 
               " en posición " + indiceVuelo + ":\n" + vuelos.get(indiceVuelo));
          } else {
               System.out.println("\nNo se encontró un vuelo con código de vuelo " + codigoVueloBuscado + ".");
          }

     }

     // Método para obtener un conjunto de vuelos únicos a partir de una lista de
     // vuelos
     // Elimina los que tenga código de vuelo repetido, quedándose solo con uno el
     // primero que encuentre.
     public static HashSet<Vuelo> vuelosUnicos(List<Vuelo> vuelos) {
          return new HashSet<>(vuelos);
     }

     // Devolver una estructura de datos donde para cada ciudad de destino
     // se indique el número de pasajeros que vuelan a ese destino
     public static Map<String, Integer> pasajerosPorDestino(List<Vuelo> vuelos) {
          // Crear un map para almacenar la cantidad de pasajeros por ciudad de destino
          Map<String, Integer> pasajerosPorDestino = new HashMap<>();

          // Recorrer todos los vuelos
          for (Vuelo vuelo : vuelos) {
               String ciudadDestino = vuelo.getCiudadDestino();
               int cantidadPasajeros = vuelo.getPasajeros().size(); // Obtener el número de pasajeros del vuelo

               // Sumar la cantidad de pasajeros a la ciudad de destino correspondiente
               pasajerosPorDestino.put(ciudadDestino,
                         pasajerosPorDestino.getOrDefault(ciudadDestino, 0) + cantidadPasajeros);
          }

          return pasajerosPorDestino;
     }

     // Devolver una estructura de datos donde para cada ciudad de destino
     // se indique el número de pasajeros que vuelan a ese destino ordenando las
     // ciudades por orden alfabético
     public static Map<String, Integer> pasajerosPorDestinoOrdenados(List<Vuelo> vuelos) {
          Map<String, Integer> pasajerosPorDestino = pasajerosPorDestino(vuelos);
          // Crear un TreeMap para ordenar las ciudades alfabéticamente
          Map<String, Integer> pasajerosPorDestinoOrdenados = new TreeMap<>(pasajerosPorDestino);
          // También se puede copiar el código del método anterior
          return pasajerosPorDestinoOrdenados;
     }

     // Generar una estructura de datos para asociar el código de vuelo
     // a un conjunto de pasajeros de ese vuelo
     public static Map<Integer, Set<Pasajero>> pasajerosPorCodigoVuelo(List<Vuelo> vuelos) {
          Map<Integer, Set<Pasajero>> vuelosPasajeros = new HashMap<>();
          for (Vuelo vuelo : vuelos) {
               vuelosPasajeros.put(vuelo.getCodigoVuelo(), vuelo.getPasajeros());
          }
          return vuelosPasajeros;
     }

     // Borrar todos los vuelos que viajan a una ciudad de destino,
     // que se pasa como parámetro, usando iteradores
     public static void borrarVuelosDestino(List<Vuelo> vuelos, String ciudadDestino) {
          Iterator<Vuelo> iterador = vuelos.iterator();
          while (iterador.hasNext()) {
               Vuelo vuelo = iterador.next();
               if (vuelo.getCiudadDestino().equals(ciudadDestino)) {
                    iterador.remove();
               }
          }
     }

     // Ordenar vuelos por orden natural
     public static void ordenarVuelos(List<Vuelo> vuelos) {
          Collections.sort(vuelos); // Ordena por orden natural, que es por código de vuelo
     }

     // Ordenar vuelos por ciudad de origen
     public static void ordenarVuelosPorCiudadOrigen(List<Vuelo> vuelos) {
          Collections.sort(vuelos, (v1, v2) -> v1.getCiudadOrigen().compareTo(v2.getCiudadOrigen()));
     }

     // Realizar una búsqueda binaria de un vuelo por código de vuelo, asumiendo que 
     // la lista de vuelos está ordenada por código de vuelo
     public static int buscarVueloPorCodigo(List<Vuelo> vuelos, int codigoVuelo) {
          Vuelo vueloBuscado = new Vuelo(codigoVuelo, "a", "b", 100);
          return Collections.binarySearch(vuelos, vueloBuscado);
     }

}
