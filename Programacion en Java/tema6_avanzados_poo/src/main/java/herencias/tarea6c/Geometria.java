package herencias.tarea6c;

import java.util.*;

public class Geometria {

    public static void main(String[] args) {

        // 1. Conjunto de figuras
        Set<Figura> conjunto = new HashSet<>();
        conjunto.add(new Rectangulo("R1", "rojo", 4, 3));
        conjunto.add(new Rectangulo("R2", "azul", 5, 2));
        conjunto.add(new Triangulo("T1", "rojo", 3, 4));
        conjunto.add(new Triangulo("T2", "verde", 6, 2));
        conjunto.add(new Circulo("C1", "azul", 3));
        conjunto.add(new Circulo("C2", "verde", 5));

        // 2. Mostrar datos y area con foreach
        System.out.println("=== Todas las figuras ===");
        for (Figura f : conjunto) {
            System.out.println(f + " | área=" + f.area());
        }

        // 3. Lista a partir del conjunto
        List<Figura> lista = new ArrayList<>(conjunto);

        // 4. Ordenar por id con Comparator y lambda
        lista.sort((a, b) -> a.getId().compareTo(b.getId()));
        System.out.println("\n=== Ordenadas por id ===");
        lista.forEach(System.out::println);

        // 5. Busqueda binaria por id
        String buscarId = "T1";
        int pos = Collections.binarySearch(lista,
                new Triangulo(buscarId, "", 0, 0), // figura para comparar
                (a, b) -> a.getId().compareTo(b.getId()));
        System.out.println("\nBúsqueda de id=" + buscarId + " → posición: " + pos);

        // 6. Ordenar por color y luego por id
        lista.sort(Comparator.comparing(Figura::getColor).thenComparing(Figura::getId));
        System.out.println("\n=== Ordenadas por color y luego id ===");
        lista.forEach(System.out::println);

        // 7. Separar Dibujables y Movibles
        List<Dibujable> dibujables = new ArrayList<>();
        List<Movible> movibles = new ArrayList<>();
        for (Figura f : lista) {
            if (f instanceof Dibujable)
                dibujables.add((Dibujable) f);
            if (f instanceof Movible)
                movibles.add((Movible) f);
        }

        // 8. Llamar dibujar() en cada dibujable
        System.out.println("\n=== Dibujar figuras ===");
        for (Dibujable d : dibujables)
            d.dibujar();

        // 9. Mover Rectangulos 2 der, Circulos 3 arriba
        System.out.println("\n=== Mover figuras ===");
        for (Movible m : movibles) {
            if (m instanceof Rectangulo) {
                ((Rectangulo) m).moverDer(2);
                System.out.println("Rectángulo movido der 2: " + m);
            } else if (m instanceof Circulo) {
                ((Circulo) m).moverArr(3);
                System.out.println("Círculo movido arr 3: " + m);
            }
        }

        // 10. Mapa figura a area
        Map<Figura, Double> mapaAreas = obtenerMapaAreas(conjunto);
        System.out.println("\n=== Mapa figura→área ===");
        mapaAreas.forEach((f, a) -> System.out.println(f.getId() + " → " + a));
    }

    // Metodo (static) que devuelve un Map<Figura, Double>
    public static Map<Figura, Double> obtenerMapaAreas(Set<Figura> conjunto) {
        Map<Figura, Double> mapa = new HashMap<>();
        for (Figura f : conjunto) {
            mapa.put(f, f.area());
        }
        return mapa;
    }
}
