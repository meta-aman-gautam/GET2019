public class Item {

	public int product_quantity = 0;
	public String product_itemname;
	public double product_price;

	//constructor is created of class Item
	public Item(String itemname, double price) {
		product_itemname = itemname;
		product_price = price;
		product_quantity = 0;
	}
	
	//getter/setter method
	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getProduct_itemname() {
		return product_itemname;
	}

	public double getProduct_price() {
		return product_price;
	}

	
	
