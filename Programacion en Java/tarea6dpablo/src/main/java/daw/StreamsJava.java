package daw;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsJava {

    // 1

    public static List<Vehiculo> firstFive(List<Vehiculo> list) {
        return list.stream()
                .limit(5)
                .collect(Collectors.toList());

    }

    // 2

    public static void vehicles2012(List<Vehiculo> list) {
        list.stream()
                .filter(v -> v.getYear() == 2012)
                .forEach(System.out::println);
    }

    // 3

    public static Set<String> uniqueBrands(List<Vehiculo> list) {
        return list.stream()
                .map(Vehiculo::getMake)
                .collect(Collectors.toSet());
    }

    // 4

    public static List<Vehiculo> sortedByYear(List<Vehiculo> list) {
        return list.stream()
                .sorted(Comparator.comparing(Vehiculo::getYear))
                .collect(Collectors.toList());
    }

    // 4

    public static List<Vehiculo> skipAndTake(List<Vehiculo> list) {
        return list.stream()
                .skip(10)
                .limit(5)
                .collect(Collectors.toList());
    }

    // 6

    public static boolean anyGreen(List<Vehiculo> list) {
        return list.stream()
                .anyMatch(v -> v.getColor().equalsIgnoreCase("Green"));
    }

    // 7

    public static boolean allAfter1990(List<Vehiculo> list) {
        return list.stream()
                .allMatch(v -> v.getYear() >= 1990);
    }

    // 8

    public static long countFord(List<Vehiculo> list) {
        return list.stream()
                .filter(v -> v.getMake().equalsIgnoreCase("Ford"))
                .count();
    }

    // 9

    public static OptionalInt minYear(List<Vehiculo> list) {
        return list.stream()
                .mapToInt(Vehiculo::getYear)
                .min();
    }

    // 10

    public static Set<String> colorsAfter2010(List<Vehiculo> list) {
        return list.stream()
                .filter(v -> v.getYear() > 2010)
                .map(Vehiculo::getColor)
                .collect(Collectors.toSet());
    }

    // 11

    public static Map<String, Long> countByColor(List<Vehiculo> list) {
        return list.stream()
                .collect(Collectors.groupingBy(
                        Vehiculo::getColor,
                        Collectors.counting()));
    }

    // 12

    public static Map<String, List<Vehiculo>> groupByPlate(List<Vehiculo> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Vehiculo::getLicensePlate));
    }

}
