package ejerciciosUT6.Ej1;

import java.util.ArrayList;
import java.util.List;

public class Casa {

    private Puerta puerta;
    private List<Ventana> ventanas;
    private List<Calefactor> calefactores;

    public Casa(Ventana v, Puerta p){
        this.puerta = p;
        this.ventanas = new ArrayList<>();
        ventanas.add(v);
        this.calefactores = new ArrayList<>();
    }
    
    public Casa(Ventana v, Puerta p, Calefactor c){
        this.puerta = p;
        this.ventanas = new ArrayList<>();
        ventanas.add(v);
        this.calefactores = new ArrayList<>();
        calefactores.add(c);
    }

    public Puerta getPuerta() {
        return puerta;
    }

    public void setPuerta(Puerta puerta) {
        this.puerta = puerta;
    }

    public List<Ventana> getVentanas() {
        return ventanas;
    }

    public void setVentanas(List<Ventana> ventanas) {
        this.ventanas = ventanas;
    }

    public List<Calefactor> getCalefactores() {
        return calefactores;
    }

    public void setCalefactores(List<Calefactor> calefactores) {
        this.calefactores = calefactores;
    }

    @Override
    public String toString() {
        return "Casa [puerta=" + puerta + ", ventanas=" + ventanas + ", calefactores=" + calefactores + "]";
    }
    

}
