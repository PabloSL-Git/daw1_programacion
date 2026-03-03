package tema5.profesor;

/* Crea la clase Pasajero, con atributos encapsulados: id (final), NIF (final), nombre y email. 
Incluye constructores por defecto y parametrizado, 
toString, equals, hashcode y orden natural por id. 
El email debe contener exactamente un carácter ‘@’ y 
mínimo un carácter ‘.’ en al menos dos posiciones posteriores a la ‘@’. 
*/
public class Pasajero implements Comparable<Pasajero> {
     private final int id;
     private final String nif;
     private String nombre;
     private String email;

     public Pasajero() {
          this.id = 0;
          this.nif = "";
          this.nombre = "";
          this.email = "";
     }

     public Pasajero(int id, String nif, String nombre, String email) {
          if (comprobarEmail(email)) {
               this.email = email;
          } else {
               throw new IllegalArgumentException("Email incorrecto");
          }
          this.id = id;
          this.nif = nif;
          this.nombre = nombre;
     }

     // Método simple para comprobar el formato del email según las reglas
     // especificadas. No contemplamos que haya punto antes de la arroba, ni otros casos más complejos.  
     private boolean comprobarEmail(String email) {
          int indiceArroba = email.indexOf('@');
          int indicePunto = email.indexOf('.');

          // No existe alguno de los caracteres necesarios
          // o el '@' no está antes del '.'
          if (indiceArroba == -1 || indicePunto == -1
                    || indiceArroba >= indicePunto) {
               return false;
          }

          return indicePunto - indiceArroba >= 2;
     }

     public int getId() {
          return id;
     }

     public String getNif() {
          return nif;
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
          if (comprobarEmail(email)) {
               this.email = email;
          } else {
               throw new IllegalArgumentException("Email incorrecto");
          }
     }

     @Override
     public boolean equals(Object obj) {
          if (this == obj)
               return true;
          if (obj == null || getClass() != obj.getClass()) {
               return false;
          }

          Pasajero pasajero = (Pasajero) obj;

          return this.id == pasajero.id;
     }

     @Override
     public int hashCode() {
          int result = this.id;
          result = 31 * result + Integer.hashCode(this.id);
          return result;
     }

     @Override
     public String toString() {
          return "Pasajero{" +
                    "id=" + id +
                    ", nif='" + nif + '\'' +
                    ", nombre='" + nombre + '\'' +
                    ", email='" + email + '\'' +
                    '}';
     }

     @Override
     public int compareTo(Pasajero o) {
          return Integer.compare(this.id, o.id);
     }
}
