/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_time;

// Clase para horas, minutos y segundos
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author usuario
 */
public class HorasJava8 {
    
    public static void main(String[] args) {
        
        // Creación de horas
        // Momento actual
        LocalTime ahora = LocalTime.now();
        System.out.println("Hora actual: "+ ahora);
        
        System.out.println("Hora: " + ahora.getHour() + " Minutos: "
        + ahora.getMinute());
        
        LocalTime mediaNoche = LocalTime.MIDNIGHT;
        System.out.println("Media noche " + mediaNoche);
        
        LocalTime medioDia = LocalTime.NOON;
        System.out.println("Medio dia: " + medioDia);
        
        // Hora específica
        LocalTime hora1 = LocalTime.of(14, 45, 01);
        System.out.println("Hora de salida " + hora1);
        
        // Los métodos of() lanzan Excepción DateTime si algún
        // parámetro es incorrecto
        //LocalTime horaMala = LocalTime.of(23, 61, 0);
        
        // Paso de LocalTime a segundos y viceversa
        hora1 = LocalTime.of(1, 0);
        int segundos = hora1.toSecondOfDay();
        System.out.println("Hora en segundos " + segundos);
        
        segundos += segundos+60;
        LocalTime horaSegundos = LocalTime.ofSecondOfDay(segundos);
        System.out.println("La nueva hora es " + horaSegundos);
        
        /* COMPARACIÓN DE HORAS */
        
        LocalTime horaDesayuno = LocalTime.of(8, 30);
        LocalTime horaAlmuerzo = LocalTime.of(15,00);
        System.out.println("Hora Desayuno " + horaDesayuno);
        System.out.println("Hora Almuerzo " + horaAlmuerzo);
        System.out.println("Son iguales ? " + horaDesayuno.equals(horaAlmuerzo));
        
        if (horaAlmuerzo.isAfter(horaDesayuno)){
            System.out.println("Hora Almuerzo es posterior");
        }
        
        if (horaDesayuno.isBefore(horaAlmuerzo)){
            System.out.println("Hora desayuno es anterior");
        }
        
        /* OPERACIONES CON HORAS : SUMAS Y RESTAS DE H,M,S*/
        
        // Hora de salida y llegada de un vuelo según duración
        LocalTime salida = LocalTime.of(14,15);
        System.out.println("Salida del vuelo " + salida);
        
        // La duración es de 5 horas y 43 minutos
        // Creamos un objeto LocalTime con la duración LocalTime.of(5,43)
        // Ese objeto lo pasamos a segundos LocalTime.of(5,43).toSecondOfDay()
        // Esos segundos los pasamos al método plusSeconds de un LocalTime
        LocalTime llegada = salida.plusSeconds(LocalTime.of(5,43).toSecondOfDay());
        System.out.println("Hora de llegada " + llegada);
        
        // Los métodos minus() funcionan igual pero para restar h, m o s
        
        /* TIEMPOS ENTRE HORAS */
        // Duración en horas entre dos objetos LocalTime
        long horasEntreObjetos = ChronoUnit.HOURS.between(llegada, salida);
        System.out.println("Horas entre " + horasEntreObjetos);
        
        // Duración en minutos
        long minutosEntreObjetos = ChronoUnit.MINUTES.between(salida, llegada);
        System.out.println("Minutos entre " + minutosEntreObjetos);
        
        // Calculamos duración en segundos entre dos objetos LocalTime
        LocalTime a = LocalTime.of(12,30);
        LocalTime b = LocalTime.of(14,45);
        
        long duracion = ChronoUnit.SECONDS.between(a, b);
        System.out.println("Duracion " + duracion);
        
        // Pasamos esos segundos a objeto LocalTime
        LocalTime conFormato = LocalTime.ofSecondOfDay(duracion);
        System.out.println("Duración con formato " + conFormato);
        
        
    }  
}
