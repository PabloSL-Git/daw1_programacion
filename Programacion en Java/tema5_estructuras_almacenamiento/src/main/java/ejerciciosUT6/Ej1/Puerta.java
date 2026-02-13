package ejerciciosUT6.Ej1;

public class Puerta {

    private boolean estado;

    public Puerta(){
        this.estado = true;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Puerta [estado=" + estado + "]";
    }

    

}
