package com.metacube.model;
/**
 * Pojo class of vehicle plan details. which also a part of model layer
 * 
 * @author Aman Gautam
 * 
 * Dated :21/9/19
 */
public class VechilePlanDetails {

	public int empId,planPrice;
	public String vechileNumber, empVechilePlan;
	
	/**
	 * Instantiates a new vechile plan details.
	 *
	 * @param empId 
	 * @param vechileNumber 
	 * @param empVechilePlan 
	 * @param the plan price
	 */
	public VechilePlanDetails(int empId, String vechileNumber, String empVechilePlan, int planPrice) {
		this.empId = empId;
		this.vechileNumber = vechileNumber;
		this.empVechilePlan = empVechilePlan;
		this.planPrice = planPrice;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getPlanPrice() {
		return planPrice;
	}

	public void setPlanPrice(int planPrice) {
		this.planPrice = planPrice;
	}

	public String getVechileNumber() {
		return vechileNumber;
	}

	public void setVechileNumber(String vechileNumber) {
		this.vechileNumber = vechileNumber;
	}

	public String getEmpVechilePlan() {
		return empVechilePlan;
	}

	public void setEmpVechilePlan(String empVechilePlan) {
		this.empVechilePlan = empVechilePlan;
	}

}
