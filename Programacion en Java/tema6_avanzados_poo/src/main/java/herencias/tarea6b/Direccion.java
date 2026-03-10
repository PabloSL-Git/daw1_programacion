package herencias.tarea6b;

public class Direccion {

    private String calleNumero;
    private String cpostal;
    private String poblacion;
    
    public Direccion() {
    }

    public Direccion(String calleNumero, String cpostal, String poblacion) {
        this.calleNumero = calleNumero;
        this.cpostal = cpostal;
        this.poblacion = poblacion;
    }

    public String getCalleNumero() {
        return calleNumero;
    }

    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }

    public String getCpostal() {
        return cpostal;
    }

    public void setCpostal(String cpostal) {
        this.cpostal = cpostal;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    

}
