package ejercicios;

public class Ejercicio4 {

    public static void main(String[] args) {

        // pasar un numero a horas, minutos y segundos

        // pasar 1423

        int horasCociente = 1423 / 60;
        System.out.println("resultadodivision1 1423 / 60 = " + horasCociente);
        int minutosResto = 1423 % 60;
        System.out.println("restodivision1 1423 % 2 = " + minutosResto);

        int segundosCociente = minutosResto / 60;
        System.out.println("segundosCociente seria anterior / 60  = " + minutosResto);
        
        System.out.println(
                "Serian " + horasCociente + " horas " + minutosResto + " minutos " + segundosCociente + " segundos ");
        // falta poner los datos

        // calcular 7445/3600 y con %

        int cociente1 = 7445 / 3600;
        System.out.println("resultadodivision1 = " + cociente1);
        int resto1 = 7445 % 3600;
        System.out.println("restodivision1 = " + resto1);

        System.out.println("Serian " + (cociente1 + resto1) + " segundos ");

    }

}
