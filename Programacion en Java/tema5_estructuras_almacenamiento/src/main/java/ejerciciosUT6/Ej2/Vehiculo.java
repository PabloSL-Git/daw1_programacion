package ejerciciosUT6.Ej2;

public class Vehiculo {

    private String matricula;
    private String bastidor;
    private Color color;

    public Vehiculo(String matricula, String bastidor, Color color) {
        this.matricula = matricula;
        this.bastidor = bastidor;
        this.color = color;
    }

    public void metodoVehiculo(){
        System.out.println("Se está ejecutando un método en vehículo");
    }

    public Vehiculo(){
        
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehiculo [matricula=" + matricula + ", bastidor=" + bastidor + ", color=" + color + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bastidor == null) ? 0 : bastidor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehiculo other = (Vehiculo) obj;
        if (bastidor == null) {
            if (other.bastidor != null)
                return false;
        } else if (!bastidor.equals(other.bastidor))
            return false;
        return true;
    }
    

}
