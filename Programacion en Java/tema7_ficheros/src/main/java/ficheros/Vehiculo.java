package ficheros;

import com.opencsv.bean.CsvBindByName;

/**
 * Representa un vehículo leído desde un fichero CSV.
 */
public class Vehiculo {

	@CsvBindByName(column = "vehicle_make")
	private String vehicleMake;

	@CsvBindByName(column = "vehicle_model")
	private String vehicleModel;

	@CsvBindByName(column = "vehicle_year")
	private int vehicleYear;

	@CsvBindByName(column = "vehicle_vin")
	private String vehicleVin;

	@CsvBindByName(column = "vehicle_color")
	private String vehicleColor;

	@CsvBindByName(column = "vehicle_license_plate")
	private String vehicleLicensePlate;

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

	public int getVehicleYear() {
		return vehicleYear;
	}

	public void setVehicleYear(int vehicleYear) {
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
		return String.format("Vehiculo{marca='%s', modelo='%s', año=%d, vin='%s', color='%s', matrícula='%s'}",
				vehicleMake, vehicleModel, vehicleYear, vehicleVin, vehicleColor, vehicleLicensePlate);
	}
}
