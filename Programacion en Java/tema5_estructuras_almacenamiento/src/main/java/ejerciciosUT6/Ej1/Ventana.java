package ejerciciosUT6.Ej1;

public class Ventana {

    private Persiana persiana;

    // Composición fuerte . Si el objeto ventana
    // desaparece también lo hace su persiana asociada
    public Ventana(String material){
        this.persiana = new Persiana(material);
    }

    public Persiana getPersiana() {
        return persiana;
    }

    public void setPersiana(Persiana persiana) {
        this.persiana = persiana;
    }

    @Override
    public String toString() {
        return "Ventana [persiana=" + persiana + "]";
    }

    
}
