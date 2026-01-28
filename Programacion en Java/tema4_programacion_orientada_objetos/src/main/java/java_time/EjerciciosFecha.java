package java_time;

// Clase para tratar fechas (sólo día, mes y año)
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.time.LocalTime;
// Enumerado para los meses del año (Enero, ...)
// import java.time.Month;
// import java.time.MonthDay;
// import java.time.Period;
// import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
//import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
//import java.util.Locale;
import java.util.Scanner;

public class EjerciciosFecha {

    private static final Scanner tec = new Scanner(System.in);

    public static void main(String[] args) {

        LocalDate fecha = LocalDate.now();
        long numeroDias = 20;
        long numeroSegundos = 40;
        LocalDate fecha1 = LocalDate.of(2000, 6, 5);
        LocalDate fecha2 = LocalDate.of(2001, 6, 5);
        LocalDateTime time1 = LocalDateTime.of(2024, 12, 25, 10, 30, 0);
        LocalDateTime time2 = LocalDateTime.of(2024, 12, 25, 11, 35, 0);

        System.out.println("¿Es bisiesto? " + isBisiesto(fecha));
        System.out.println("Copia: " + copia(fecha));
        System.out.println("Dias en este mes: " + diasMes(fecha));
        System.out.println("Dia de hoy es: " + diaSemana(fecha));
        System.out.println("Hoy: " + mostrarfechaLarga(fecha));
        System.out.println("Suma es: " + sumarDias(numeroDias, fecha));
        System.out.println("Dias transcurridos: " + diasTranscurridos(fecha1, fecha2));
        System.out.println("Siguiente dia: " + siguienteDia(fecha));
        System.out.println("Minutos pasados: " + minutosEntre(time1, time2));
        System.out.println("La suma es: " + sumarSegundos(numeroSegundos, time2));
        tec.close();
    }

    // isBisiesto
    public static boolean isBisiesto(LocalDate fecha) {
        return fecha.isLeapYear();
    }

    // copia
    public static LocalDate copia(LocalDate fecha) {
        return LocalDate.of(fecha.getYear(), fecha.getMonth(), fecha.getDayOfMonth());
    }

    // diasMes
    public static int diasMes(LocalDate fecha) {
        return fecha.lengthOfMonth();
    }

    // diaSemana
    public static DayOfWeek diaSemana(LocalDate fecha) {
        return fecha.getDayOfWeek();
    }

    // mostrarfechaLarga
    public static String mostrarfechaLarga(LocalDate fecha) {
        return fecha.format(DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy"));
    }

    // sumarDias
    public static LocalDate sumarDias(long numeroDias, LocalDate fecha) {
        return fecha.plus(numeroDias, ChronoUnit.DAYS);
    }

    // diasTranscurridos
    public static long diasTranscurridos(LocalDate fecha1, LocalDate fecha2) {
        return ChronoUnit.DAYS.between(fecha1, fecha2);
    }

    // siguiente dia
    public static LocalDate siguienteDia(LocalDate fecha) {
        return fecha.plus(1, ChronoUnit.DAYS);
    }

    // anteriorDia
    public static LocalDate anteriorDia(LocalDate fecha) {
        return fecha.minus(1, ChronoUnit.DAYS);
    }

    // minutosEntre
    public static long minutosEntre(LocalDateTime time1, LocalDateTime time2) {
        return ChronoUnit.MINUTES.between(time1, time2);
    }

    // sumarSegundos
    public static LocalDateTime sumarSegundos(long numeroSegundos, LocalDateTime fecha) {
        return fecha.plusSeconds(numeroSegundos);
    }
}