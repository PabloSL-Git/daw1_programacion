package teoria;

public class EstructurasPrograma {

    /*
     * comentaio multilinea
     * el metodo main es el metodo que busca la JVM
     * para iniciar la ejecuacion de cualquier programa java
     */

    public static void main(String[] args) {

        System.out.println("tipos de datos y variable");

        // tipos primitivos
        // numeros enteros
        // inicializacion de variables de tipo byte llamado valorbyte
        // con valor 120

        byte valorbyte = 120;
        System.out.println("valor byte = " + valorbyte);

        // declarar una variable de tipo short llamado valorshort

        short valorshort;
        valorshort = 1000;

        // dentro del metodo sout cuando uso el operador +
        // lo que hace es una concatenacion de valores

        System.out.println("valorshort = " + valorshort);

        int valorint = -200;
        System.out.println("valor int = " + valorint);
        // todos los tipos primitivos tienen una clase que los gestione o embuelve
        Integer valorinteger = 345;
        // valorint es un tipo primitivivo y valor valorinteger es un objeto

        System.out.println("valor integer =" + valorinteger);
        System.out.println("valor minimo ineteger =" + Integer.MIN_VALUE);
        System.out.println("valor minimo ineteger =" + Integer.MAX_VALUE);
        System.out.println("tamaño int en bytes = " + Integer.BYTES);
        System.out.println("tamaño int en bits = " + Integer.SIZE);

        long valorlong = 1;
        System.out.println("valor long = " + valorlong);

        float valorfloat = 34.5f;
        System.out.println("valor float = " + valorfloat);

        double valordouble = 23.3;
        System.out.println("valor double = " + valordouble);

        // cuidado los literales tipo char llevan comillas simples
        // y los literarles tipo string llevan comillas

        char valorchar = 'j';
        System.out.println("valor char = " + valorchar);

        boolean valorBoolean = false;
        System.out.println("valor boolean = " + valorBoolean);

        String valoString = " esto es una cadena de texto ";
        System.out.println(valoString);

    }
}
