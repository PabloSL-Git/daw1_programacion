package ejerciciosUT6.Ej1;

public class Puerta {

     private boolean abierta;
     private String material;

    public Puerta(String material) {
        this.abierta = false;
        this.material = material;
    }
    
    public boolean isAbierta() {
        return abierta;
    }

    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void abrir() {
        abierta = true;
    }

    public void cerrar() {
        abierta = false;
    }

    @Override
    public String toString() {
        return "Puerta [abierta=" + abierta + ", material=" + material + "]";
    }
    


}
