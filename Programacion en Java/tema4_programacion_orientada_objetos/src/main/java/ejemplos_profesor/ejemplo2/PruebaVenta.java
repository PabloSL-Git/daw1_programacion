package ejemplos_profesor.ejemplo2;

public class PruebaVenta {

    public static void main(String[] args) {

        // Instanciación de un objeto de tipo Venta
        // Para instanciar necesito el constructor y usar el
        // operador new --> reservar memoria

        // Venta v1 = new Venta("AgriculturaEstepona",
        //         "Fina", "Picual", 100, 200.34);

        Venta v2 = new Venta("Casares", "Gruesa",
                "Hojiblanca", 10, 200.35);

        System.out.println(v2.toString());
        System.out.println(v2.getNombreProductor());
        // v2.tamanioAceituna = "El que yo quiera";
        System.out.println(v2.toString());

        v2.setNombreProductor("Jaén");
        System.out.println("-----------------");
        System.out.println(v2);

        v2.setTamanioAceituna("Fina");
        System.out.println(v2);
    }

}