package com.metacube.parking.model;

/**
 * Plan is used to store the details of 
 * the plan choosen by the customer
 * 
 * @author Aman Gautam
 * 
 * Dated:21/9/19
 *
 */
public class Plan {
	
	private String currency;
	
	private String price;
	
	/**
	 * Instantiates a new plan.
	 *
	 * @param currency the currency
	 * @param price the price
	 */
	public Plan( String currency , String price) {
		this.price = price;
		this.currency = currency;
	}
	public Plan() {}
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Plan [currency=" + currency + ", price=" + price + "]";
	}	
}
