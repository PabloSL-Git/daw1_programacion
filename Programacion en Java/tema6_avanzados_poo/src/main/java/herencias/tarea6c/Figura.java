package herencias.tarea6c;

import java.util.Objects;

public abstract class Figura {
    private String id;
    private String color;

    public Figura(String id, String color) {
        this.id = id;
        this.color = color;
    }

    public abstract double area();

    // equals y hashCode según id — no se pueden sobrescribir en subclases
    @Override
    public final boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Figura))
            return false;
        Figura f = (Figura) o;
        return Objects.equals(id, f.id);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "id=" + id + ", color=" + color;
    }
}
