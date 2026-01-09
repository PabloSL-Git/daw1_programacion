package tema2y3;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ChuletaExamen1 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        final int NUMERO_DE_HORAS_CADA_PROFESOR = 18;

        int numeroEdad;
        numeroEdad = 6;

        if (numeroEdad == 18) {
            JOptionPane.showMessageDialog(null, "No tiene que tributar a hacienda");
        }

        String mensaje = """
                Introduce qué operación deseas hacer:
                  - 1 para sumar
                  - 2 para restar
                  - 3 para multiplicar
                  - 4 para dividir
                """;
        String operacionMal = JOptionPane.showInputDialog(null, mensaje);

        String numeroEdadMal = JOptionPane.showInputDialog("Introduce una edad");
        numeroEdad = Integer.parseInt(numeroEdadMal);

        String numero1Mal = JOptionPane.showInputDialog("Introduce numero 1");
        double numero1 = Double.parseDouble(numero1Mal);

        mensaje = """
                Mes %d
                Pago: %.2f €
                Deuda restante: %.2f €
                """.formatted(numero1, operacionMal);

        JOptionPane.showMessageDialog(null, mensaje);

        String mensaje2 = """
                        Numero maquina %d
                        Pago: %.2f €
                        Deuda restante: %.2f €
                        """.formatted(numero1, operacionMal);

                System.out.println(mensaje2);


        // %d     | Entero (int, long, short, byte) | System.out.printf("Número: %d", 42);             | Número: 42
        // %f     | Número decimal (float, double)  | System.out.printf("Precio: %.2f €", 12.5);       | Precio: 12.50 €
        // %s     | Cadena de texto (String)        | System.out.printf("Hola %s", "Ana");             | Hola Ana
        // %c     | Carácter (char)                 | System.out.printf("Letra: %c", 'A');             | Letra: A
        // %b     | Booleano (boolean)              | System.out.printf("Valor: %b", true);            | Valor: true
        // %n     | Salto de línea                  | System.out.printf("Línea 1%nLínea 2");           | Línea 1
        //        |                                 |                                                  | Línea 2
        // %%     | Símbolo % literal               | System.out.printf("Progreso: 50%%");             | Progreso: 50%


        // evitar errores

        int a = 1;
        int b = 2;

        // boolean

        boolean esAigualB = a == b;
        System.out.println("¿Son iguales? " + esAigualB);

        // ptintf para hacer cosas de formacion
        // %.2f para añadir mas decimales
        // \n sirve para saltar linea

        System.out.printf("Nombre: %s\n", a);

        // diferentes tipos para usar JOpane

        int numeroEntero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número entero:"));
        double numeroDecimal = Double.parseDouble(JOptionPane.showInputDialog("Introduce un número decimal:"));
        float numeroFlotante = Float.parseFloat(JOptionPane.showInputDialog("Introduce un número flotante:"));
        long numeroLargo = Long.parseLong(JOptionPane.showInputDialog("Introduce un número largo:"));
        short numeroCorto = Short.parseShort(JOptionPane.showInputDialog("Introduce un número corto:"));
        byte numeroByte = Byte.parseByte(JOptionPane.showInputDialog("Introduce un número byte:"));
        boolean valorBooleano = Boolean.parseBoolean(JOptionPane.showInputDialog("Introduce true o false:"));
        char caracter = JOptionPane.showInputDialog("Introduce un carácter:").charAt(0);

        // para usarlo en algun lado

        System.out.println("int: " + numeroEntero);
        System.out.println("double: " + numeroDecimal);
        System.out.println("float: " + numeroFlotante);
        System.out.println("long: " + numeroLargo);
        System.out.println("short: " + numeroCorto);
        System.out.println("byte: " + numeroByte);
        System.out.println("boolean: " + valorBooleano);
        System.out.println("char: " + caracter);

        // evitar errores

        
        double num1 = teclado.nextDouble();
        teclado.nextLine();
        double num2 = teclado.nextDouble();
        teclado.nextLine();
        double num3 = teclado.nextDouble();
        teclado.nextLine();
        double num4 = teclado.nextDouble();
        teclado.nextLine();
        double num5 = teclado.nextDouble();

        System.out.println(num1 + numeroEntero + num2 + num3 + num5 + num4 + NUMERO_DE_HORAS_CADA_PROFESOR);

        // var swapping

        var aux = num3;
        num2 = num1;
        num1 = aux;

        // interger es rwaped de intç
        //valor minimo integer = -2147483648

        System.out.println("valor minimo integer = " + Integer.MIN_VALUE);

        // Tipos Enteros
        // ------------------------

        // byte varByte = 0; // byte: 8 bits, rango: -128 a 127
        // System.out.println("byte: " + Byte.MIN_VALUE + " a " + Byte.MAX_VALUE);

        // short varShort = 0; // short: 16 bits, rango: -32,768 a 32,767
        // System.out.println("short: " + Short.MIN_VALUE + " a " + Short.MAX_VALUE);

        // int varInt = 0; // int: 32 bits, rango: -2,147,483,648 a 2,147,483,647
        // System.out.println("int: " + Integer.MIN_VALUE + " a " + Integer.MAX_VALUE);

        // long varLong = 0L; // long: 64 bits, rango: -9,223,372,036,854,775,808 a 9,223,372,036,854,775,807
        // System.out.println("long: " + Long.MIN_VALUE + " a " + Long.MAX_VALUE);

        // // ------------------------
        // // Tipos Decimales
        // // ------------------------

        // float varFloat = 0.0f; // float: 32 bits, valores aprox: 1.4E-45 a 3.4E+38
        // System.out.println("float: " + Float.MIN_VALUE + " a " + Float.MAX_VALUE);

        // double varDouble = 0.0; // double: 64 bits, valores aprox: 4.9E-324 a 1.8E+308
        // System.out.println("double: " + Double.MIN_VALUE + " a " + Double.MAX_VALUE);

        // // ------------------------
        // // Tipo Carácter
        // // ------------------------

        // char varChar = 'A'; // char: 16 bits, valores Unicode: 0 a 65,535 (ej: 'A', '1', '€')
        // System.out.println("char: " + (int) Character.MIN_VALUE + " a " + (int) Character.MAX_VALUE + " (Unicode)");

        // // ------------------------
        // // Tipo Booleano
        // // ------------------------

        // boolean varBoolean = true; // boolean: 1 bit (solo puede ser true o false)
        // System.out.println("boolean: " + Boolean.FALSE + " o " + Boolean.TRUE);

       

        teclado.close();

    }

}
