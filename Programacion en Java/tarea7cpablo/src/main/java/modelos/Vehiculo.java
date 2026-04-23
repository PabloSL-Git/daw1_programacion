package modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase POJO (Plain Old Java Object) que representa un vehículo.
 * Se usará para leer objetos de tipo Vehiculo en formato JSON
 * 
 * Las anotaciones de Jackson permiten:
 * @JsonProperty: mapear propiedades JSON con nombres diferentes a los atributos Java
 * 
 * @author alumno
 */
public class Vehiculo {
    
    @JsonProperty("vehicle_make")
    private String vehicleMake;
    
    @JsonProperty("vehicle_model")
    private String vehicleModel;
    
    @JsonProperty("vehicle_year")
    private Integer vehicleYear;
    
    @JsonProperty("vehicle_vin")
    private String vehicleVin;
    
    @JsonProperty("vehicle_color")
    private String vehicleColor;
    
    @JsonProperty("vehicle_license_plate")
    private String vehicleLicensePlate;

    public Vehiculo() {
    }

    public Vehiculo(String vehicleMake, String vehicleModel, Integer vehicleYear,
                    String vehicleVin, String vehicleColor, String vehicleLicensePlate) {
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.vehicleVin = vehicleVin;
        this.vehicleColor = vehicleColor;
        this.vehicleLicensePlate = vehicleLicensePlate;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Integer getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(Integer vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getVehicleVin() {
        return vehicleVin;
    }

    public void setVehicleVin(String vehicleVin) {
        this.vehicleVin = vehicleVin;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleLicensePlate() {
        return vehicleLicensePlate;
    }

    public void setVehicleLicensePlate(String vehicleLicensePlate) {
        this.vehicleLicensePlate = vehicleLicensePlate;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "vehicleMake='" + vehicleMake + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleYear=" + vehicleYear +
                ", vehicleVin='" + vehicleVin + '\'' +
                ", vehicleColor='" + vehicleColor + '\'' +
                ", vehicleLicensePlate='" + vehicleLicensePlate + '\'' +
                '}';
    }
}
