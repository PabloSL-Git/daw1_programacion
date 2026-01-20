package biblioteca;

public class Main {

    public static void main(String[] args) {

        estudiantes = new ArrayList<>(3);

        // estudiantes

        Estudiante estudiante1 = new Estudiante("Pablo", "Santamaria", "11111111A");
        Estudiante estudiante2 = new Estudiante("Rosi", "Loredo", "22222222B");
        Estudiante estudiante3 = new Estudiante("Marious", "Loredo", "33333333C");

        this.añadir(estudiante1);
        this.añadir(estudiante2);
        this.añadir(estudiante3);

        estudiantes.imprimir();
    }
}
