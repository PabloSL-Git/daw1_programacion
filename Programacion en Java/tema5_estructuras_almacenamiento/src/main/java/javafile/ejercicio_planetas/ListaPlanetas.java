package javafile.ejercicio_planetas;

import java.util.List;
import java.util.ArrayList;

public class ListaPlanetas {

    private List<Planeta> listaPlanetas;

    public ListaPlanetas() {
        listaPlanetas = new ArrayList<>();

        listaPlanetas.add(new Planeta(PlanetasPermitidos.MERCURIO, 57.9));
        listaPlanetas.add(new Planeta(PlanetasPermitidos.VENUS, 108.2));
        listaPlanetas.add(new Planeta(PlanetasPermitidos.TIERRA, 149.6));
        listaPlanetas.add(new Planeta(PlanetasPermitidos.MARTE, 227.9));
        listaPlanetas.add(new Planeta(PlanetasPermitidos.JUPITER, 778.5));
        listaPlanetas.add(new Planeta(PlanetasPermitidos.SATURNO, 1434.0));
        listaPlanetas.add(new Planeta(PlanetasPermitidos.URANO, 2871.0));
        listaPlanetas.add(new Planeta(PlanetasPermitidos.NEPTUNO, 4495.1));
    }
}
