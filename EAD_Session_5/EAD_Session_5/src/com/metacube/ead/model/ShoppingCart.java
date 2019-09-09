package com.metacube.ead.model;

/**
 * The Class ShoppingCart{Model Layer}.
 * @author Aman Gautam
 */
public class ShoppingCart {

	int productId,productQuantity, noOfProducts;
	double price ,totalPrice;
	String productName ,productType;
	
	/**
	 * Instantiates a new shopping cart.
	 *
	 * @param productId 
	 * @param productName
	 * @param productType
	 * @param productQuantity
	 * @param price 
	 * @param noOfProducts 
	 * @param totalPrice 
	 */
	public ShoppingCart(int productId,String productName,String productType,int productQuantity,double price,int noOfProducts,double totalPrice){
		this.productId=productId;
		this.productQuantity=productQuantity;
		this.productName=productName;
		this.noOfProducts=noOfProducts;
		this.price =price;
		this.productType=productType;
		this.totalPrice=totalPrice;
		
	}

	/**
	 * Gets the no of products.
	 *
	 * @return no of products
	 */
	public int getNoOfProducts() {
		return noOfProducts;
	}

	/**
	 * Gets the price.
	 *
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Gets the total price.
	 *
	 * @return  total price
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Gets the product name.
	 *
	 * @return product name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Gets the product type.
	 *
	 * @return  product type
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * Gets the product id.
	 *
	 * @return product id
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * Gets the product quantity.
	 *
	 * @return product quantity
	 */
	public int getProductQuantity() {
		return productQuantity;
	}
}
