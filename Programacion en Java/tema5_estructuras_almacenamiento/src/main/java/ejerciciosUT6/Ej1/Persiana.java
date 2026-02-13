package ejerciciosUT6.Ej1;

public class Persiana {

    private boolean subida;
    private String material;

    public Persiana(String material) {
        this.subida = false;
        this.material = material;
    }

    public boolean isSubida() {
        return subida;
    }

    public void setSubida(boolean subida) {
        this.subida = subida;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void subir() {
        subida = true;
    }

    public void bajar() {
        subida = false;
    }

    @Override
    public String toString() {
        return "Persiana [subida=" + subida + ", material=" + material + "]";
    }
}
