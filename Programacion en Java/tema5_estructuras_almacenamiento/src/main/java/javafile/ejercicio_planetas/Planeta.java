package javafile.ejercicio_planetas;

public class Planeta {

    // enum los palnetas sistema, cada distancia al sol final,
    // nombre, clase sistema solar lista planetas

    private PlanetasPermitidos planetas;
    private final double distancia;

    public Planeta(PlanetasPermitidos planetas, double distancia) {
        this.planetas = planetas;
        this.distancia = distancia;
    }

    public PlanetasPermitidos getPlanetas() {
        return planetas;
    }

    public void setPlanetas(PlanetasPermitidos planetas) {
        this.planetas = planetas;
    }

    public double getDistancia() {
        return distancia;
    }

}
