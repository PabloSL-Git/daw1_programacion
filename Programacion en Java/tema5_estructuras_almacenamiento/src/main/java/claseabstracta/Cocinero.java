package claseabstracta;

public class Cocinero extends Trabajador{

    private String especialidad;

    public Cocinero(String nombre, String nif, double sueldoBase, String especialidad) {
        super(nombre, nif, sueldoBase);
        this.especialidad = especialidad;
    }

    public Cocinero(){
        super();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Cocinero [especialidad=" + especialidad + ", getNombre()=" + getNombre() + ", getNif()=" + getNif()
                + "]";
    }

    @Override
    public double cotizar() {
        return getSueldoBase()*0.05;
    }

    public void hacerPostre(String nombre){
        System.out.println("El cocinero " + getNombre() +
        "está elaborando " + nombre);
    }

    
}
