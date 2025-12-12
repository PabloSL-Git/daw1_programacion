package funciones.calculadora;

public class CalculadoraFunciones {

        // Función dentro de la clase Main, se llama sumar
    // Recibe dos parámetros de tipo int
    // Devuelve un valor de tipo int, resultado de la suma de los dos parámetros
    // public implica que puedo usar la función desde cualquier clase de mi proyecto
    // [public|private] [tipo_dato_devuelve|void] nombre_Metodo (tipoDato param1,
    // tipoDato parm2, etc)

    public static int sumar(int op1, int op2) {
        int resultado;
        resultado = op1 + op2;
        return resultado;
    }

    public static int restar(int op1, int op2) {
        int resultado;
        resultado = op1 - op2;
        return resultado;
    }

    public static int multiplicar(int op1, int op2) {
        int resultado;
        resultado = op1 * op2;
        return resultado;
    }

    // si queremos double forzamos, con cambiar uno vale

    public static double dividir(double op1, double op2) {
        double resultado;

        if (op2 == 0){
            throw new IllegalArgumentException("op2 es 0");
        }

        resultado = op1 / op2;
        return resultado;
    }

     public static void mostrarMenu() {
        String menu = """
                ## Bienvenido a la calculadora ##
                    1.- Sumar
                    2.- Restar
                    3.- Multiplicar
                    4.- Dividir
                    5.- Salir
                    --------------------------
                """;
        System.out.println(menu);
     }

}
