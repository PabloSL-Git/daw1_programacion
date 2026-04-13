package daw;

import java.util.List;
import java.util.ArrayList;

public class Plantilla {

    private List<Empleado> empleados;

    public Plantilla() {
        this.empleados = new ArrayList<>();
    }

    // metodo contratar empleado
    public void contratarEmpleado(Empleado empleado){
        this.empleados.add(empleado);
    }

    // metodo lista empleados, nueva lista con un nombre o apellido especifico

    public List<Empleado> getEmpleadosPorNombre(String filtroNombre){

        List<Empleado> empledosFiltrados = new ArrayList<>();

        for (Empleado empleado : empleados) {
            if (empleado.getNombre().toLowerCase().contains(filtroNombre)) {
                empledosFiltrados.add(empleado);
            } else if (empleado.getApellidos().toLowerCase().contains(filtroNombre)) {
                empledosFiltrados.add(empleado);
            }
        }

        return empledosFiltrados;



    }
}