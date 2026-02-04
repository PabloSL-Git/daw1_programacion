package paquetec;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        VaqueriaMap vaqueriaMap = new VaqueriaMap();
        Vaqueria vaqueria1 = new Vaqueria();

        vaqueria1.añadirVaca(new Vaca("987654321", LocalDate.of(2015, 12, 3), "Esta delgada"));
        vaqueria1.añadirVaca(new Vaca("123456789", LocalDate.of(2010, 12, 3), "Esta gorda"));

        Vaqueria vaqueria2 = new Vaqueria();

        vaqueria2.añadirVaca(new Vaca("987654321", LocalDate.of(2015, 12, 3), "Esta delgada"));
        vaqueria2.añadirVaca(new Vaca("123456789", LocalDate.of(2010, 12, 3), "Esta gorda"));

        vaqueriaMap.añadirVaqueria("1", vaqueria1);
        vaqueriaMap.añadirVaqueria("2", vaqueria2);

        vaqueriaMap.imprimirLista();

    }
}
