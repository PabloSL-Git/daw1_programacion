package herencias.ejerciciosUT6.Ej7;

public class Camarero extends Trabajador{

    private String rango;

    public Camarero(String nombre, String nif, double sueldoBase, String rango) {
        
        this.rango = rango;
    }
    public Camarero(){
        // Implícitamente se llama a super()
        // super();
    }
    public String getRango() {
        return rango;
    }
    public void setRango(String rango) {
        this.rango = rango;
    }
    @Override
    public String toString() {
        return "Camarero [rango=" + rango + ", Nombre=" + getNombre() + ", Nif=" + getNif() + "]";
    }
    @Override
    public double cotizar() {
        return getSueldoBase()*0.03;
    }

    public void servirMesa(String numeroMesa){
        System.out.println("El camarero " + getNif() +
        " sirve la mesa " + numeroMesa);
    }

}
