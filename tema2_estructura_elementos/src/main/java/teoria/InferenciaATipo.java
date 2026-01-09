package teoria;


public class InferenciaATipo {

    public static void main(String[] args) {

        // La interferencia de tipos consiste en que el
        // compilador asigna el tipo a la variable
        // en función del literal asignado

        // Uso de la palabra reservada var
        // Se infiere que es un int

        // Uso de la palabra reservada var
        // Se infiere que es un int
        var ocho = 8;
        var ocho2 = 10;
        // Se infiere un long
        var diez = 10l;
        // char
        var letra = 'a';
        // float
        var valorfloat = 43.8d;
        // double
        var valorDouble = 45.8;

        System.out.println(ocho + ocho2 + diez + letra + valorfloat + valorDouble);

    }
}
