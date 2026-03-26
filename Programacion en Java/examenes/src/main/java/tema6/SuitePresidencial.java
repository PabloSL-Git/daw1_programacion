/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6;

/**
 *
 * @author usuario
 */
public final class SuitePresidencial extends Habitacion {

    private boolean mayordomo;

    public SuitePresidencial(boolean mayordomo, int numero, int capacidad) {
        super(numero, capacidad);
        this.mayordomo = mayordomo;
        setEstado(Estado.MANTENIMIENTO);
    }

    public boolean isMayordomo() {
        return mayordomo;
    }

    public void setMayordomo(boolean mayordomo) {
        this.mayordomo = mayordomo;
    }

    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.mayordomo ? 1 : 0);
        return hash;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SuitePresidencial other = (SuitePresidencial) obj;
        return this.mayordomo == other.mayordomo;
    }

    @Override
    public String toString() {
        return "Habitacion [numero" + getNumero() + ", capacidad" + getCapacidad() + ", estado" + getEstado()
                + "SuitePresidencial{" + "mayordomo=" + mayordomo + '}';
    }
    
    // limpiar
    
   @Override
    public void limpiar() {

        System.out.println("Mayordomo ordeno la habitacion");

    }

}
