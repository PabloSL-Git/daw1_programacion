package daw;

import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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
    private List<Integer> fecha;
    @JsonProperty("estacionMeteorologica")
    private String estacionMeteorologica;
    @JsonProperty("provincia")
    private String provincia;
    @JsonProperty("precipitacion")
    private float precipitacion;

    /**
     * No args constructor for use in serialization
     *
     */
    public Precipitacion() {
    }

    public Precipitacion(List<Integer> fecha, String estacionMeteorologica, String provincia, float precipitacion) {
        super();
        this.fecha = fecha;
        this.estacionMeteorologica = estacionMeteorologica;
        this.provincia = provincia;
        this.precipitacion = precipitacion;
    }

    @JsonProperty("fecha")
    public List<Integer> getFecha() {
        return fecha;
    }

    @JsonProperty("fecha")
    public void setFecha(List<Integer> fecha) {
        this.fecha = fecha;
    }

    public Precipitacion withFecha(List<Integer> fecha) {
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
    public float getPrecipitacion() {
        return precipitacion;
    }

    @JsonProperty("precipitacion")
    public void setPrecipitacion(float precipitacion) {
        this.precipitacion = precipitacion;
    }

    public Precipitacion withPrecipitacion(float precipitacion) {
        this.precipitacion = precipitacion;
        return this;
    }

}
