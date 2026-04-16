package daw;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Empleado empleado1 = new Tecnico("11111111H", "Alejandro", "Fernández", 1000, 1);
        Empleado empleado2 = new Tecnico("22222222J", "Jerónima", "Jiménez", 1000, 2);
        Empleado empleado3 = new Comercial("33333333P", "Desiderio", "Durán", 800, 2000);

        Plantilla empleados = new Plantilla();

        empleados.contratarEmpleado(empleado1);
        empleados.contratarEmpleado(empleado2);
        empleados.contratarEmpleado(empleado3);

        List<Empleado> lista = empleados.getEmpleadosPorNombre("er");

        for (Empleado empleado : lista) {
            System.out.println(empleado.getNombre() + " " + empleado.getApellidos() + " " + empleado.getSueldo());
        }
    }

}
