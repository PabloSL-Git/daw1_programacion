package modelos;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import java.time.LocalDate;
import java.util.Objects;

public class Persona {

    @CsvBindByName(column = "id")
    private long id;

    @CsvBindByName(column = "nombre")
    private String nombre;

    @CsvBindByName(column = "apellido")
    private String apellido;

    @CsvBindByName(column = "email")
    private String email;

    @CsvBindByName(column = "genero")
    private String genero;

    @CsvDate("dd-MM-yyyy")
    @CsvBindByName(column = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @CsvBindByName(column = "jubilado")
    private boolean jubilado;

    @CsvBindByName(column = "ciudad")
    private String ciudad;

    public Persona() {
    }

    public Persona(long id, String nombre, String apellido, String email, String genero, LocalDate fechaNacimiento, boolean jubilado, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.jubilado = jubilado;
        this.ciudad = ciudad;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public boolean isJubilado() { return jubilado; }
    public void setJubilado(boolean jubilado) { this.jubilado = jubilado; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    @Override
    public String toString() {
        return "Persona{id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
                + ", genero=" + genero + ", fechaNacimiento=" + fechaNacimiento + ", jubilado=" + jubilado
                + ", ciudad=" + ciudad + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona persona = (Persona) o;
        return id == persona.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
