package claseabstracta;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Casting implícito
        Trabajador t1 = new Cocinero("Marcos", "11", 1200, "pastelero");
        Trabajador t2 = new Camarero("María", "12", 1250, "jefe sala");

        
        List<Trabajador> lista=  new ArrayList<>();
        lista.add(t1);
        lista.add(t2);

        for (Trabajador t : lista) {
            System.out.println(t); // Invocación método polimórfico toString
            // Invocación método polimórfico cotizar
            System.out.println("Este trabajador cotiza " + t.cotizar());
        
            if (t instanceof Cocinero){
                // Conversión explícita de tipos
                // para poder acceder a los métodos propios
                // de la clase cocinero
                ((Cocinero)t).hacerPostre("flan");
            }
            if (t instanceof Camarero){
                ((Camarero)t).servirMesa("8");
            }

        }
    }
}
