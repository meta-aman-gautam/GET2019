import java.util.Date;

/**
 * The Class OrderDetails.
 * @author Aman Gautam
 */
public class OrderDetails {

	String orderId;
	Date order_date;
	String total_price;
	
	/**
	 * Instantiates a new order details.
	 *
	 * @param orderId the order id
	 * @param order_date the order date
	 * @param total_price the total price
	 */
	public OrderDetails(String orderId,Date order_date,String total_price){
		this.order_date=order_date;
		this.orderId=orderId;
		this.total_price = total_price;
	}
	
	// getter/setter
	public String getOrderId() {
		return orderId;
	}
	
	public Date getOrder_date() {
		return order_date;
	}

	public String getTotal_price() {
		return total_price;
	}

}
