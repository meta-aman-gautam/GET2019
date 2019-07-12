public class Item {

	
	public int pquantity = 0;
	public String pitemname;
	public double pprice ;


	/*
	 * constructor is created of class Item
	 */
	public Item(String itemname, double price) {
		pitemname = itemname;
		pprice = price;
		pquantity = 0;
	}

	
	/* getter/setter method
	 * 
	 */

	public int getPquantity() {
		return pquantity;
	}


	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}


	public String getPitemname() {
		return pitemname;
	}


	public double getPprice() {
		return pprice;
	}
	
	

}
