package objeto.ejemplo_profesor;

import java.time.DayOfWeek;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Calificacion c1 = Calificacion.SOBRESALIENTE;
        System.out.println(c1.getNota());
        System.out.println("nombre del enum " + c1.name());
        System.out.println("Ordinal " + c1.ordinal());
        Calificacion[] array = Calificacion.values();
        System.out.println(Arrays.toString(array));
        System.out.println(DayOfWeek.MONDAY.ordinal());
    }
}
