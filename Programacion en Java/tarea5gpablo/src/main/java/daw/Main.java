package daw;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // listas

        List<Alumno> listaAlumnos = new ArrayList<>();
        listaAlumnos.add(new Alumno("1", "Pablo", "1234A"));
        listaAlumnos.add(new Alumno("2", "Rosi", "2345B"));
        listaAlumnos.add(new Alumno("3", "Marious", "3456C"));

        List<Curso> listaCursos = new ArrayList<>();
        listaCursos.add(new Curso("101", "Programacion", 50));
        listaCursos.add(new Curso("102", "Mates", 25));
        listaCursos.add(new Curso("103", "Fisica", 30));

        // objeto instituto

        Instituto instituto = new Instituto("nombre", listaAlumnos, listaCursos);

        // matricula alumnos

        instituto.matricular("1", listaCursos.get(0)); // Pablo - Programacion
        instituto.matricular("1", listaCursos.get(1)); // Pablo - Mates
        instituto.matricular("2", listaCursos.get(1)); // Ana - Mates
        instituto.matricular("3", listaCursos.get(2)); // Luis - Fisica

        // imprimir alumnos y cursos

        System.out.println("\nALUMNOS");
        for (Alumno alumno : instituto.getAlumnos()) {
            System.out.println("ID: " + alumno.getId() + "\nNombre: " + alumno.getNombre()
                    + "\nNif: " + alumno.getNif());
        }

        System.out.println("\nCURSOS");
        for (Curso curso : instituto.getCursos()) {
            System.out.println("ID: " + curso.getId() + "\nNombre: " + curso.getNombre()
                    + "\nHoras: " + curso.getHoras());
        }

        // imprimir cursos matriculados de un alumno

        System.out.println("----------------------------");

        System.out.println("\nCursos matriculados por alumno:");
        for (Alumno a : listaAlumnos) {
            System.out.println(a.getNombre() + ": " + instituto.verCursosMatriculados(a.getId()));
        }

        // imprimir alumnos matriculados a curso

        System.out.println("----------------------------");

        System.out.println("\nAlumnos matriculados por curso:");
        for (Curso c : listaCursos) {
            System.out.println(c.getNombre() + ": " + instituto.verAlumnosMatriculados(c));
        }

        // desmatricular
        instituto.desmatricular("1", listaCursos.get(1)); // Pablo - Mates

        System.out.println("\nDespués de desmatricular:");
        for (Alumno a : listaAlumnos) {
            System.out.println(a.getNombre() + ": " + instituto.verCursosMatriculados(a.getId()));
        }

        for (Curso c : listaCursos) {
            System.out.println(c.getNombre() + ": " + instituto.verAlumnosMatriculados(c));
        }

        // total de horas por alumno
        System.out.println("\nTotal de horas por alumno:");

        Map<String, Integer> horasTotales = instituto.totalHorasPorAlumno();
        for (Map.Entry<String, Integer> entry : horasTotales.entrySet()) {
            System.out.println("id: " + entry.getKey() + " ---> Nº HORAS: " + entry.getValue());
        }

    }
}
