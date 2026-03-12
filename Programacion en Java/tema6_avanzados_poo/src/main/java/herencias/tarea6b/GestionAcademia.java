package herencias.tarea6b;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionAcademia {
    public static void main(String[] args) {
        // a) crear academia
        Academia academia = new Academia();
        academia.setNombre("Academia Java");
        academia.setDireccion(new Direccion("Calle Falsa 123", "28080", "Madrid"));

        // b) contratar empleados
        Interino i1 = new Interino("Ana", "García", "111A", "SS001", 2000,
                Especialidad.Secundaria, 0);
        Interino i2 = new Interino("Luis", "Fernández", "222B", "SS002", 2100,
                Especialidad.ProfesorTecnico, 100);
        Titular t1 = new Titular("María", "López", "333C", "SS003", 2500,
                Especialidad.Secundaria, 300, LocalDate.of(2025, 6, 30));
        Titular t2 = new Titular("Carlos", "Ruiz", "444D", "SS004", 2600,
                Especialidad.ProfesorTecnico, 200, LocalDate.of(2028, 12, 31));
        academia.contratarEmpleado(i1);
        academia.contratarEmpleado(i2);
        academia.contratarEmpleado(t1);
        academia.contratarEmpleado(t2);

        // c) matricular alumnos
        Alumno a1 = new Alumno("Pablo", "Sánchez", "555E", "EXP001");
        Alumno a2 = new Alumno("Pablo", "Sánchez", "555E", "EXP001"); // igual a1
        Alumno a3 = new Alumno("Laura", "Martín", "666F", "EXP002");
        Alumno a4 = new Alumno("Juan", "Pérez", "777G", "EXP003");
        academia.matricularAlumno(a1);
        academia.matricularAlumno(a2);
        academia.matricularAlumno(a3);
        academia.matricularAlumno(a4);

        // d) mostrar empleados y alumnos
        System.out.println("\n______________ EMPLEADOS _____________");
        for (Empleado e : academia.getEmpleado()) {
            System.out.println(e);
        }
        System.out.println("\n_______________ ALUMNOS _______________");
        for (Alumno a : academia.getAlumno()) {
            System.out.println(a);
        }

        // e) recorrer empleados con polimorfismo
        System.out.println("\nResultados calcularIRPF y prorrogas");
        for (Empleado e : academia.getEmpleado()) {
            // polimórficamente se invoca el método concreto
            double irpf = e.calcularIRPF();
            System.out.printf("%s IRPF=%.2f\n", e.getNombre(), irpf);
            if (e instanceof Titular) {
                Titular tit = (Titular) e; // conversión explícita
                boolean pr = tit.pedirProrroga(12); // un año
                System.out.printf("prórroga para %s -> %b nueva fecha=%s\n",
                        tit.getNombre(), pr, tit.getfechaJubilacion());
            }
        }

        // f) lista de objetos que pueden darse de baja
        List<SolicitarBaja> bajaList = new ArrayList<>();
        bajaList.add(a1);
        bajaList.add(a3);
        bajaList.add(i1);
        bajaList.add(i2);
        System.out.println("\nSolicitudes de baja");
        for (SolicitarBaja sb : bajaList) {
            boolean ok = sb.solicitarBaja(LocalDate.now());
            System.out.printf("%s -> baja solicitada: %b\n", sb, ok);
        }

        // g) crear y usar metodo calcularDiasInterinos
        Map<String, Long> dias = calcularDiasInterinos(academia);
        System.out.println("\nDías trabajados por interino:");
        dias.forEach((nif, d) -> System.out.printf("%s : %d días\n", nif, d));
    }

    // recorre academia y lista empleados

    public static Map<String, Long> calcularDiasInterinos(Academia acad) {
        Map<String, Long> resultado = new HashMap<>();
        if (acad == null || acad.getEmpleado() == null) {
            return resultado;
        }
        for (Empleado e : acad.getEmpleado()) {
            if (e instanceof Interino) {
                Interino inter = (Interino) e; // downcast necesario
                resultado.put(inter.getNif(), inter.calcularDiasTrabajados());
            }
        }
        return resultado;
    }
}
