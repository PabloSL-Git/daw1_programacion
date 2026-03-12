package herencias.tarea6b;

public class Direccion {

    private String calleNumero;
    private String cpostal;
    private String poblacion;
    
    public Direccion() {
    }

    public Direccion(String calleNumero, String cpostal, String poblacion) {

        if (cpostal != null && cpostal.length() == 5) {
            this.cpostal = cpostal;
        } else {
            this.cpostal = "00000";
        }
        this.calleNumero = calleNumero;
        this.poblacion = poblacion;
    }

    public void setCpostal(String cpostal) {
        if (cpostal != null && cpostal.length() == 5) {
            this.cpostal = cpostal;
        } else {
            this.cpostal = "00000";
        }
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

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    

}
