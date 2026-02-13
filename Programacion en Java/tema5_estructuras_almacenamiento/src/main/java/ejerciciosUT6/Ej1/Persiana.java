package ejerciciosUT6.Ej1;

public class Persiana {

    private String material;
    private boolean estado; // true está subida

    public Persiana(String material) {
        this.material = material;
        this.estado = false;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

   

    @Override
    public String toString() {
        return "Persiana [material=" + material + ", estado=" + estado + "]";
    }

    public void subir(){
        this.estado = true;
    }

    public void bajar(){
        this.estado = false;
    }

}
