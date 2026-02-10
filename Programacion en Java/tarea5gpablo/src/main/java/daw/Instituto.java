package daw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Instituto {
    private String nombre;
    private Set<Alumno> alumnos;
    private Set<Curso> cursos;
    private Map<String, List<Curso>> matriculas;

    public Instituto(String nombre, List<Alumno> alumnos, List<Curso> cursosPermitidos) {
        this.nombre = nombre;

        // convertir listas a sets
        this.alumnos = new HashSet<>(alumnos);
        this.cursos = new HashSet<>(cursosPermitidos);

        // matricula vacia
        this.matriculas = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public Map<String, List<Curso>> getMatriculas() {
        return matriculas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    public void setMatriculas(Map<String, List<Curso>> matriculas) {
        this.matriculas = matriculas;
    }

    // matricular
    public boolean matricular(String idAlumno, Curso curso) {
        // verificar que existe
        Alumno alumno = null;
        for (Alumno a : alumnos) {
            if (a.getId().equals(idAlumno)) {
                alumno = a;
                break;
            }
        }
        // si no existe
        if (alumno == null || !cursos.contains(curso)) {
            return false;
        }
        // obtener la lista de cursos
        if (!matriculas.containsKey(idAlumno)) {
            matriculas.put(idAlumno, new ArrayList<>());
        }
        List<Curso> cursosAlumno = matriculas.get(idAlumno);
        // añadir si no matriculadp
        if (!cursosAlumno.contains(curso)) {
            cursosAlumno.add(curso);
            return true;
        }
        return false; // ya matriculado
    }

    // desmatricular
    public boolean desmatricular(String idAlumno, Curso curso) {
        // verificar que existe
        Alumno alumno = null;
        for (Alumno a : alumnos) {
            if (a.getId().equals(idAlumno)) {
                alumno = a;
                break;
            }
        }
        // si no existe
        if (alumno == null || !cursos.contains(curso)) {
            return false;
        }
        // obtener la lista de cursos
        if (!matriculas.containsKey(idAlumno)) {
            matriculas.put(idAlumno, new ArrayList<>());
        }
        List<Curso> cursosAlumno = matriculas.get(idAlumno);
        // añadir si no matriculadp
        if (!cursosAlumno.contains(curso)) {
            cursosAlumno.remove(curso);
            return true;
        }
        return false; // ya matriculado
    }

    // ver cursos matriculados
    public List<Curso> verCursosMatriculados(String idAlumno) {

        matriculas.putIfAbsent(idAlumno, new ArrayList<>());

        return matriculas.get(idAlumno);
    }

    // lista alumnos en un curso
    public List<Alumno> verAlumnosMatriculados(Curso curso) {
    List<Alumno> listaAlumnos = new ArrayList<>();

    for (String idAlumno : matriculas.keySet()) {
        List<Curso> cursosAlumno = matriculas.get(idAlumno);

        if (cursosAlumno.contains(curso)) {
            
            // buscar Alumno en el set
            for (Alumno a : alumnos) {
                if (a.getId().equals(idAlumno)) {
                    listaAlumnos.add(a);
                    break;
                }
            }
        }
    }

    return listaAlumnos;
}


    // total horas

    public Map<String, Integer> totalHorasPorAlumno() {
        Map<String, Integer> totalHoras = new TreeMap<>();

        for (Alumno a : alumnos) {
            int suma = 0;
            for (Curso c : verCursosMatriculados(a.getId())) {
                suma += c.getHoras();
            }
            totalHoras.put(a.getId(), suma);
        }
        return totalHoras;
    }

}
