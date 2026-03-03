package tema5.profesor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*Crea la clase Vuelo, con atributos encapsulados: código de vuelo (final), ciudad origen, 
ciudad destino, duración en minutos y un conjunto de pasajeros únicos (final). 
Solo existe un constructor parametrizado que no recibe 
la lista de pasajeros porque inicialmente los vuelos 
se crean con la lista de pasajeros vacía. 
Las ciudades de origen y destino deben ser diferentes y 
la duración mayor que 45 minutos.
 La clase debe proporcionar métodos para añadir y borrar pasajeros al vuelo. 
 Incluye equals, hashcode y orden natural por código de vuelo. 

 */
public class Vuelo implements Comparable<Vuelo> {
     private final int codigoVuelo;
     private String ciudadOrigen;
     private String ciudadDestino;
     private int duracionMinutos;
     private final Set<Pasajero> pasajeros;

     public Vuelo(int codigoVuelo, String ciudadOrigen, String ciudadDestino, int duracionMinutos) {
          if (ciudadOrigen.equals(ciudadDestino)) {
               throw new IllegalArgumentException("La ciudad de origen y destino deben ser diferentes");
          }

          if (duracionMinutos <= 45) {
               throw new IllegalArgumentException("La duración debe ser mayor que 45 minutos");
          }
          this.codigoVuelo = codigoVuelo;
          this.ciudadOrigen = ciudadOrigen;
          this.ciudadDestino = ciudadDestino;
          this.duracionMinutos = duracionMinutos;
          this.pasajeros = new HashSet<>();
     }

     public int getCodigoVuelo() {
          return codigoVuelo;
     }

     public String getCiudadOrigen() {
          return ciudadOrigen;
     }

     public void setCiudadOrigen(String ciudadOrigen) {
          if (ciudadOrigen.equals(this.ciudadDestino)) {
               throw new IllegalArgumentException("La ciudad de origen y destino deben ser diferentes");
          }
          this.ciudadOrigen = ciudadOrigen;
     }

     public String getCiudadDestino() {
          return ciudadDestino;
     }

     public void setCiudadDestino(String ciudadDestino) {
          if (ciudadDestino.equals(this.ciudadOrigen)) {
               throw new IllegalArgumentException("La ciudad de origen y destino deben ser diferentes");
          }
          this.ciudadDestino = ciudadDestino;
     }

     public int getDuracionMinutos() {
          return duracionMinutos;
     }

     public void setDuracionMinutos(int duracionMinutos) {
          this.duracionMinutos = duracionMinutos;
     }

     public Set<Pasajero> getPasajeros() {
          return pasajeros;
     }

     // Añadir pasajero al vuelo
     public boolean addPasajero(Pasajero pasajero) {
          return pasajeros.add(pasajero);
     }

     // Eliminar pasajero del vuelo
     public boolean removePasajero(Pasajero pasajero) {
          return pasajeros.remove(pasajero);
     }

     @Override
     public int hashCode() {
          int hash = 7;
          hash = 97 * hash + Objects.hashCode(this.codigoVuelo);
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
          final Vuelo other = (Vuelo) obj;
          return Objects.equals(this.codigoVuelo, other.codigoVuelo);
     }

     @Override
     public String toString() {
          return "Vuelo{" +
                    "codigoVuelo='" + codigoVuelo + '\'' +
                    ", ciudadOrigen='" + ciudadOrigen + '\'' +
                    ", ciudadDestino='" + ciudadDestino + '\'' +
                    ", duracionMinutos=" + duracionMinutos +
                    ", \npasajeros=\n" + getPasajerosString() +
                    "}\n";
     }

     // Obtener en un string los pasajeros del vuelo. No se pide en el enunciado
     // pero así la información se ve mejor. Método privado porque no se pide
     // que se pueda acceder a la lista de pasajeros desde fuera de la clase.
     private String getPasajerosString() {
          StringBuilder sb = new StringBuilder();
          for (Pasajero pasajero : pasajeros) {
               sb.append(pasajero.toString()).append("\n");
          }
          return sb.toString();
     }

     @Override
     public int compareTo(Vuelo o) {
          return Integer.compare(this.codigoVuelo, o.codigoVuelo);
     }

}
