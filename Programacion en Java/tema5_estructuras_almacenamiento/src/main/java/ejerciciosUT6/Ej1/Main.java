package ejerciciosUT6.Ej1;

public class Main {
    public static void main(String[] args) {

        Ventana v1 = new Ventana("Plástico");
        Ventana v2 = new Ventana("aluminio");
        System.out.println(v1);
        System.out.println(v2);
        v2.getPersiana().subir();

        Casa casa = new Casa(v2, new Puerta());
        System.out.println(casa);

        casa.getVentanas().get(0).getPersiana().bajar();
        System.out.println(casa);
    }
}