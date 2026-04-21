package daw;

public class Vehiculo {

    private String make;
    private String model;
    private int year;
    private String vin;
    private String color;
    private String licensePlate;

    public Vehiculo(String make, String model, int year, String vin, String color, String licensePlate) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
        this.color = color;
        this.licensePlate = licensePlate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getVin() {
        return vin;
    }

    public String getColor() {
        return color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String toString() {
        return make + " " + model + " (" + year + ") - " + color;
    }

}