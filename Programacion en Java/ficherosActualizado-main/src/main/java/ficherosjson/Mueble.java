/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ficherosjson;

import java.time.LocalDate;

/**
 *
 * @author Vico
 
 * Clase POJO (Plain Old Java Object) que representa un mueble. 
 * Se usará para escribir y leer objetos de tipo Mueble en formato JSON
 * Las anotaciones @JsonProperty, @JsonIgnore, etc. de la librería Jackson 
 * permiten personalizar el formato JSON, pero no se han usado en este ejemplo para que 
 * el formato JSON sea lo más sencillo posible.
 */

public class Mueble {
    
    private String id;
    private String descripcion;
    private Double ancho ;
    private Double alto;
    private Double profundo;
    private LocalDate fechaFabricacion;

    public Mueble(String id, String descripcion, double ancho, double alto, double profundo, LocalDate fecha) {
        this.id = id;
        this.descripcion = descripcion;
        this.ancho = ancho;
        this.alto = alto;
        this.profundo = profundo;
        this.fechaFabricacion = fecha;
    }

    // Constructor sin parámetros necesario para que Jackson pueda crear 
    // objetos de tipo MuebleVO
    public Mueble (){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public Double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public Double getProfundo() {
        return profundo;
    }

    public void setProfundo(double profundo) {
        this.profundo = profundo;
    }

    @Override
    public String toString() {
        return "MuebleVO{" + "id=" + id + ", descripcion=" + descripcion + ", ancho=" + ancho + ", alto=" + alto + ", profundo=" + profundo + ", fechaFabricacion=" + fechaFabricacion + '}';
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(LocalDate fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }
    
        
}
