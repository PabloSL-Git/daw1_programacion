package teoria;

public class OperacionesAritmeticas {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // suma
        // en la variable suma se guarda el resultado de sumar
        // el valor de num1 y num2 sustitulle las vars por su valor
        // y realiza la operacion

        double num1 = 200;
        double num2 = 300;

        double suma = num1 + num2;
        System.out.println("resultado suma =" + suma);

        double multiplicacion = num1 * num2;
        System.out.println("resultado multiplicacion =" + multiplicacion);

        double division = num1 / num2;
        System.out.println("resultado division = " + division);

        // cuidado con las divisiones enteras

        int a = 5;
        int b = 2;
        double c = a / (double) b;
        System.out.println(c);

        // si todos son int y hay un double
        // se convierte en double

        // division 0

        double d = 3;
        double e = 0;

        System.out.println("division entre 0 = " + (d / e));

        // modulos

        int resultado1 = 4 / 2;
        System.out.println("resultadodivision1 4/2 = " + resultado1);
        int resto1 = 4 % 2;
        System.out.println("restodivision1 4%2 = " + resto1);

        int resultado2 = 5 / 2;
        System.out.println("resultadodivision2 5/2 = " + resultado2);
        int resto2 = 5 % 2;
        System.out.println("restodivision2 5%2 = " + resto2);

    }
}