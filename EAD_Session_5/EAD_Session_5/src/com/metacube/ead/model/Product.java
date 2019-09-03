package com.metacube.ead.model;


/**
 * The Class Product{Model Layer}.
 * @author Aman Gautam
 */
public class Product {

	int productId;
	double  productPrice;
	String productName, productType;
	
	/**
	 * Instantiates a new product.
	 *
	 * @param productId
	 * @param productName
	 * @param productPrice
	 * @param productType
	 */
	public Product(int productId,String productName, double productPrice,String productType){
		this.productId=productId;
		this.productPrice=productPrice;
		this.productName=productName;
		this.productType=productType;
	}

	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * Gets the product price.
	 *
	 * @return the product price
	 */
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * Gets the product name.
	 *
	 * @return the product name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Gets the product type.
	 *
	 * @return the product type
	 */
	public String getProductType() {
		return productType;
	}
	
}
