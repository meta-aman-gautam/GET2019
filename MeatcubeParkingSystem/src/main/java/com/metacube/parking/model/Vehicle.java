package com.metacube.parking.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
/**
 * Vehicle details is used to store the details 
 * of the the vehicle
 * 
 * @author Aman Gautam
 * 
 * Dated:21/9/19
 *
 */
public class Vehicle {
	
	@NotBlank(message="{vehicleName.NotBlank}")
	@Size(min=2, max=10, message="{vehicleName.Size}")
	private String vehicleName;
	
	private String email;
	
	private String vehicleType;
	
	@NotBlank(message="{vehicleNumber.NotBlank}")
	@Size(min=2, max=12, message="{vehicleNumber.Size}")
	private String vehicleNumber;
	
	@NotBlank(message="{employeeId.NotBlank}")
	@Size(min=1, max=9, message="{employeeId.Size}")
	private String employeeId;
	
	@NotBlank(message="{vehicleDetails.Size}" )
	private String vehicleDetails;
	
	/**
	 * Instantiates a new vehicle.
	 *
	 * @param email the email
	 * @param vehicleName the vehicle name
	 * @param vehicleType the vehicle type
	 * @param vehicleNumber the vehicle number
	 * @param employeeId the employee id
	 * @param vehicleDetails the vehicle details
	 */
	public Vehicle(String email , String vehicleName,	String vehicleType,	String vehicleNumber,	String employeeId,	String vehicleDetails) {
		this.email = email;
		this.employeeId=employeeId;
		this.vehicleDetails=vehicleDetails;
		this.vehicleName=vehicleName;
		this.vehicleNumber=vehicleNumber;
		this.vehicleType=vehicleType;
	}
	public Vehicle() {}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getVehicleDetails() {
		return vehicleDetails;
	}
	public void setVehicleDetails(String vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}
	

}
