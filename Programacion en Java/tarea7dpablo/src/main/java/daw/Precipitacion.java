package daw;

import java.time.LocalDate;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "fecha",
        "estacionMeteorologica",
        "provincia",
        "precipitacion"
})
@Generated("jsonschema2pojo")
public class Precipitacion {

    @JsonProperty("fecha")
    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    private LocalDate fecha;

    @JsonProperty("estacionMeteorologica")
    private String estacionMeteorologica;

    @JsonProperty("provincia")
    private String provincia;

    @JsonProperty("precipitacion")
    private Float precipitacion;

    public Precipitacion() {
    }

    public Precipitacion(LocalDate fecha, String estacionMeteorologica, String provincia, Float precipitacion) {
        this.fecha = fecha;
        this.estacionMeteorologica = estacionMeteorologica;
        this.provincia = provincia;
        this.precipitacion = precipitacion;
    }

    @JsonProperty("fecha")
    public LocalDate getFecha() {
        return fecha;
    }

    @JsonProperty("fecha")
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Precipitacion withFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    @JsonProperty("estacionMeteorologica")
    public String getEstacionMeteorologica() {
        return estacionMeteorologica;
    }

    @JsonProperty("estacionMeteorologica")
    public void setEstacionMeteorologica(String estacionMeteorologica) {
        this.estacionMeteorologica = estacionMeteorologica;
    }

    public Precipitacion withEstacionMeteorologica(String estacionMeteorologica) {
        this.estacionMeteorologica = estacionMeteorologica;
        return this;
    }

    @JsonProperty("provincia")
    public String getProvincia() {
        return provincia;
    }

    @JsonProperty("provincia")
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Precipitacion withProvincia(String provincia) {
        this.provincia = provincia;
        return this;
    }

    @JsonProperty("precipitacion")
    public Float getPrecipitacion() {
        return precipitacion;
    }

    @JsonProperty("precipitacion")
    public void setPrecipitacion(Float precipitacion) {
        this.precipitacion = precipitacion;
    }

    public Precipitacion withPrecipitacion(Float precipitacion) {
        this.precipitacion = precipitacion;
        return this;
    }
}