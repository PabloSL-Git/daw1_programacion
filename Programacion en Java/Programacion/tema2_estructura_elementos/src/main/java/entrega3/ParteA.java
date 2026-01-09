package entrega3;

import java.util.Scanner;

public class ParteA {
        public static void main(String[] args) {

                final double PRECIO = 32.6f;

                // pide las ventas de cada dia
                // Lunes

                Scanner teclado = new Scanner(System.in);
                System.out.println("introduce numero de reparaciones Lunes = ");
                float repL = teclado.nextFloat();
                teclado.nextLine();

                // Martes

                System.out.println("introduce numero de reparaciones Martes = ");
                float repMa = teclado.nextFloat();
                teclado.nextLine();

                // Miercoles

                System.out.println("introduce numero de reparaciones Miercoles = ");
                float repMi = teclado.nextFloat();
                teclado.nextLine();

                // jueves

                System.out.println("introduce numero de reparaciones Jueves = ");
                float repJ = teclado.nextFloat();
                teclado.nextLine();

                // Viernes

                System.out.println("introduce numero de reparaciones Viernes = ");
                float repV = teclado.nextFloat();
                teclado.nextLine();

                teclado.close();

                // hace las multiplicaciones para obtener beneficio al dia

                float benefL = repL * (float) PRECIO;
                System.out.printf("beneficio el Lunes fue = %.3f € \n", benefL);

                float benefMa = repMa * (float) PRECIO;
                System.out.printf("beneficio el Martes fue = %.3f € \n", benefMa);

                float benefMi = repMi * (float) PRECIO;
                System.out.printf("beneficio el Miercoles fue = %.3f € \n", benefMi);

                float benefJ = repJ * (float) PRECIO;
                System.out.printf("beneficio el Jueves fue = %.3f € \n", benefJ);

                float benefV = repV * (float) PRECIO;
                System.out.printf("beneficio el Viernes fue = %.3f € \n", benefV);

                // se suman los beneficios para obtener l beneficio final

                float benefFinal = benefL + benefMa + benefMi + benefJ + benefV;
                System.out.printf("beneficio al final de la semana = %.3f € \n", benefFinal);

                // una variable que indique si es ams o menos

                var mas0menos3000 = (benefFinal > 0) && (benefFinal < 3000);
                System.out.println(mas0menos3000);

        }
}