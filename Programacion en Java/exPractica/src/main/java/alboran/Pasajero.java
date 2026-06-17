/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package alboran;

import java.util.Objects;

/**
 *
 * @author pablo
 */
public class Pasajero implements Comparable<Pasajero> {

    private final int id;
    private final String NIF;
    private String nombre;
    private String email;

    public Pasajero(int id, String NIF, String nombre, String email) {

        if (comprobarEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email incorrecto");
        }

        this.id = id;
        this.NIF = NIF;
        this.nombre = nombre;
    }

    private boolean comprobarEmail(String email) {
        int indiceArroba = email.indexOf('@');

        // Buscamos el primer '.' que esté DESPUÉS de la arroba
        // indexOf(char, desdeIndice) empieza a buscar desde esa posición
        // Ejemplo: "pablo.garcia@gmail.com"
        //           indexOf('.', 13) → encuentra el '.' de ".com" en posición 18
        //           y no el '.' de "pablo." en posición 5
        int indicePunto = email.indexOf('.', indiceArroba + 1);

        // Rechazamos si no existe '@' o no existe '.' después de la arroba
        if (indiceArroba == -1 || indicePunto == -1) {
            return false;
        }

        // Comprobamos que haya AL MENOS 1 carácter entre '@' y '.'
        // Ejemplo:  "pablo@g.com"  →  indicePunto(7) - indiceArroba(5) = 2  ✓
        //           "pablo@.com"   →  indicePunto(6) - indiceArroba(5) = 1  ✗
        return indicePunto - indiceArroba >= 2;
    }

    public Pasajero() {
        this.id = 0;
        this.NIF = "";
        this.nombre = "";
        this.email = "";
    }

    @Override
    public String toString() {
        return "Pasajero{" + "id=" + id + ", NIF=" + NIF + ", nombre=" + nombre + ", email=" + email + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!comprobarEmail(email)) {
            throw new IllegalArgumentException("Email incorrecto");
        }
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pasajero other = (Pasajero) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public int compareTo(Pasajero o) {
        return Integer.compare(this.id, o.id);
    }

    //con string
    // @Override
    // public int compareTo(Pasajero otro) {
    //     return this.id.compareTo(otro.id);
    //}
}
