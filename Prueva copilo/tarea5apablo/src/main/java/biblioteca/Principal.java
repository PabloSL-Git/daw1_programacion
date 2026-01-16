package biblioteca;

public class Principal {

    public static void main(String[] args) {
        System.out.println("=== CREACIÓN DE LIBROS ===\n");

        // Crear libros con isbn diferente
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967,
                9788497592207L, Libro.Genero.NOVELA, true);
        Libro libro2 = new Libro("Harry Potter", "J.K. Rowling", 1997,
                9788478884453L, Libro.Genero.FICCION, true);
        Libro libro3 = new Libro("La Odisea", "Homero", 2023,
                9788497592207L, Libro.Genero.POESIA, true); // ISBN igual a libro1

        // Crear otro libro con el mismo isbn que libro1
        Libro libro4 = new Libro("Don Quijote", "Miguel de Cervantes", 1605,
                9788497592207L, Libro.Genero.NOVELA, true); // ISBN igual a libro1 y libro3

        // Mostrar datos de todos los libros
        System.out.println("Datos de los libros:");
        System.out.println("Libro 1: " + libro1);
        System.out.println("Libro 2: " + libro2);
        System.out.println("Libro 3: " + libro3);
        System.out.println("Libro 4: " + libro4);

        System.out.println("\n=== PRUEBA DE MÉTODOS PRESTAR Y DEVOLVER ===\n");
        // Probar prestar
        System.out.println("Intentando prestar libro1:");
        libro1.prestar();
        System.out.println("Estado después: " + libro1);

        System.out.println("\nIntentando prestar libro1 nuevamente (no disponible):");
        libro1.prestar();

        System.out.println("\nIntentando prestar libro2:");
        libro2.prestar();
        System.out.println("Estado después: " + libro2);

        // Probar devolver
        System.out.println("\nIntentando devolver libro1:");
        libro1.devolver();
        System.out.println("Estado después: " + libro1);

        System.out.println("\nIntentando devolver libro2:");
        libro2.devolver();
        System.out.println("Estado después: " + libro2);

        System.out.println("\nIntentando devolver libro3 (ya estaba disponible):");
        libro3.devolver();

        System.out.println("\n=== PRUEBA DE HASHCODE ===\n");

        // Mostrar hashCode de todos los libros
        System.out.println("HashCode de libro1 (isbn: " + libro1.getIsbn() + "): " + libro1.hashCode());
        System.out.println("HashCode de libro2 (isbn: " + libro2.getIsbn() + "): " + libro2.hashCode());
        System.out.println("HashCode de libro3 (isbn: " + libro3.getIsbn() + "): " + libro3.hashCode());
        System.out.println("HashCode de libro4 (isbn: " + libro4.getIsbn() + "): " + libro4.hashCode());

        System.out.println("\nLibro1, libro3 y libro4 tienen el mismo ISBN, por lo que su hashCode es igual.");
        System.out.println("Libro2 tiene un ISBN diferente, por lo que su hashCode es diferente.");

        System.out.println("\n=== PRUEBA DE EQUALS ===\n");

        // Libros con el mismo isbn (debe devolver true)
        System.out.println("¿libro1.equals(libro3)? " + libro1.equals(libro3) +
                " (ambos tienen isbn " + libro1.getIsbn() + ")");
        System.out.println("¿libro1.equals(libro4)? " + libro1.equals(libro4) +
                " (ambos tienen isbn " + libro1.getIsbn() + ")");
        System.out.println("¿libro3.equals(libro4)? " + libro3.equals(libro4) +
                " (ambos tienen isbn " + libro3.getIsbn() + ")");

        // Libros con isbn distinto (debe devolver false)
        System.out.println("\n¿libro1.equals(libro2)? " + libro1.equals(libro2) +
                " (isbn diferentes: " + libro1.getIsbn() + " vs " + libro2.getIsbn() + ")");
        System.out.println("¿libro2.equals(libro3)? " + libro2.equals(libro3) +
                " (isbn diferentes: " + libro2.getIsbn() + " vs " + libro3.getIsbn() + ")");
        System.out.println("¿libro2.equals(libro4)? " + libro2.equals(libro4) +
                " (isbn diferentes: " + libro2.getIsbn() + " vs " + libro4.getIsbn() + ")");
    }
}
