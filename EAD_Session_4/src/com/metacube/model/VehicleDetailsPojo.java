package com.metacube.model;
s
/**
 * Pojo class of vehicle details. Part of the model layer .
 * 
 * @author Aman Gautam
 * 
 * Dated:21/9/19
 */
public class VehicleDetailsPojo {

	public int empId;
	public String vehicleName,vehicleType,vechicleNumber, identification;
	
	/**
	 * Instantiates a new vehicle details pojo.
	 *
	 * @param empId the emp id
	 * @param vehicleName the vehicle name
	 * @param vehicleType the vehicle type
	 * @param vechicleNumber the vechicle number
	 * @param identification the identification
	 */
	public VehicleDetailsPojo(int empId, String vehicleName, String vehicleType, String vechicleNumber, String identification) {
		this.empId = empId;
		this.vehicleName = vehicleName;
		this.vehicleType = vehicleType;
		this.vechicleNumber = vechicleNumber;
		this.identification = identification;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVechicleNumber() {
		return vechicleNumber;
	}

	public void setVechicleNumber(String vechicleNumber) {
		this.vechicleNumber = vechicleNumber;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

}
