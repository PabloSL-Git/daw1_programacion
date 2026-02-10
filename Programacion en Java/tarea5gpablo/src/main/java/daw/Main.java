package daw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // listas

        HashSet<Alumno> setAlumnos = new HashSet<>();
        List<Alumno> listaAlumnos = new ArrayList<>(setAlumnos);

        listaAlumnos.add(new Alumno("333", "Pablo", "1234"));

        HashSet<Curso> setCursos = new HashSet<>();
        List<Curso> listaCursos = new ArrayList<>(setCursos);

        listaCursos.add(new Curso("45", "Programacion", 50));
        listaCursos.add(new Curso("345", "Mates", 25));

        // objeto instituto

        Instituto instituto = new Instituto("nombre", listaAlumnos, listaCursos);

        // matricula alumnos

        Map<String,List<Curso>> listaMatricula = new HashMap<>();

        listaMatricula.put("333", listaCursos);

        instituto.setMatriculas(listaMatricula);

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

        List<Curso> listaCurso2 = instituto.verCursosMatriculados("333");
        for (Curso curso : listaCurso2) {
            System.out.println("curso: " + curso);
        }

        // imprimir alumnos  matriculados a curso

        System.out.println("----------------------------");

        List<String> listaAumosId = instituto.verAlumnosMatriculados("45");
        for (Alumno alumno : listaAlumnos2) {
            System.out.println("Alumno: " + alumno);
        }

    }
}
