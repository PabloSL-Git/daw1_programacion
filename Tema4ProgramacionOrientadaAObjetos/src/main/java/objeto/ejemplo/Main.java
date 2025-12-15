package objeto.ejemplo;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Ana Pérez", 101, "1ESO");
        Estudiante estudiante2 = new Estudiante("Luis Gómez", 102, "2ESO");

        estudiante1.setNotaMedia(8.5);
        estudiante2.setNotaMedia(4.7);

        System.out.println(estudiante1);
        System.out.println("¿Aprobado? " + estudiante1.aprobado());

        System.out.println(estudiante2);
        System.out.println("¿Aprobado? " + estudiante2.aprobado());
    }
}
