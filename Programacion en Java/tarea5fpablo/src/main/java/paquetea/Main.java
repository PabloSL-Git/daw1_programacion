package paquetea;

public class Main {
    private static Traductor traductor = new Traductor();

    public static void main(String[] args) {

        traductor.añadirEntrada("apple", "manzana");
        traductor.añadirEntrada("book", "libro");
        traductor.añadirEntrada("car", "coche");
        traductor.añadirEntrada("dog", "perro");
        traductor.añadirEntrada("house", "casa");
        traductor.añadirEntrada("milk", "leche");
        traductor.añadirEntrada("sun", "sol");
        traductor.añadirEntrada("tree", "arbol");
        traductor.añadirEntrada("water", "agua");
        traductor.añadirEntrada("window", "ventana");

        // Probar traduccion
        System.out.println("Traduccion de 'apple': " + traductor.traducir("apple"));

        // Modificar entrada
        traductor.modificarEntrada("car", "automovil");
        System.out.println("Nueva traduccion de 'car': " + traductor.traducir("car"));
        
        // Eliminar entrada
        traductor.eliminarEntrada("dog");
        System.out.println("Traducción de 'dog': " + traductor.traducir("dog"));

        // Palabras extranjeras
        System.out.println("\nPalabras extranjeras:");
        traductor.obtenerPalabrasExtranjeras().forEach(System.out::println);

        // Palabras en español
        System.out.println("\nPalabras español:");
        traductor.obtenerPalabrasEspanol().forEach(System.out::println);
    }
}